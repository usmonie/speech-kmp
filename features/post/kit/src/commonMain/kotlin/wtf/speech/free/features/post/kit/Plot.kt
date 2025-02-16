package wtf.speech.free.features.post.kit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFilter
import androidx.compose.ui.util.fastFlatMap
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import androidx.compose.ui.util.fastSumBy

@Stable
public data class PlotNode(
    val post: Post,
    val children: SnapshotStateList<PlotNode> = mutableStateListOf(),
    val parent: PlotNode? = null,
    val level: Int = 0
) {
    val isRoot: Boolean get() = parent == null
    val isLeaf: Boolean get() = children.isEmpty()
    val hasChildren: Boolean get() = children.isNotEmpty()

    public fun addReply(reply: Post): PlotNode {
        val node = PlotNode(
            post = reply,
            parent = this,
            level = this.level + 1
        )
        children.add(node)
        return node
    }

    public fun findNode(postId: String): PlotNode? {
        if (post.id == postId) return this
        return children.firstNotNullOfOrNull { it.findNode(postId) }
    }

    public fun getAllPosts(): List<Post> {
        return listOf(post) + children.fastFlatMap { it.getAllPosts() }
    }

    public fun getPath(): List<Post> {
        val path = mutableListOf<Post>()
        var current: PlotNode? = this
        while (current != null) {
            path.add(0, current.post)
            current = current.parent
        }
        return path
    }


    private fun getParentAvatars(): List<String> {
        val avatars = mutableListOf<String>()
        var current = parent
        while (current != null) {
            avatars.add(current.post.author.avatarUrls.first())
            current = current.parent
        }
        return avatars
    }

    public fun traverse(action: (PlotNode) -> Unit) {
        action(this)
        children.fastForEach { it.traverse(action) }
    }

    public fun traverseWithLevel(action: (PlotNode, Int) -> Unit, level: Int = 0) {
        action(this, level)
        children.fastForEach { it.traverseWithLevel(action, level + 1) }
    }

    @Composable
    public fun PlotNodeView(
        onPostClick: (Post) -> Unit,
        onRepostsClick: (Post) -> Unit,
        onLikeClick: (Post) -> Unit,
        onRepostClick: (Post) -> Unit,
        onReplyClick: (Post) -> Unit,
        onMoreClick: (Post) -> Unit,
        onUserClick: (User) -> Unit,
        content: @Composable (Post, Boolean, List<String>) -> Unit,
        isRoot: Boolean = false,
        paddingStart: Dp = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = paddingStart)
        ) {
            content(post, isRoot, getParentAvatars())

            children.fastForEach { childNode ->
                childNode.PlotNodeView(
                    onPostClick = onPostClick,
                    onRepostsClick = onRepostsClick,
                    onLikeClick = onLikeClick,
                    onRepostClick = onRepostClick,
                    onReplyClick = onReplyClick,
                    onMoreClick = onMoreClick,
                    onUserClick = onUserClick,
                    content = content,
                    isRoot = false,
                    paddingStart = paddingStart
                )
            }
        }
    }
}

@Stable
public data class Plot(
    val root: PlotNode,
    val totalReplies: Int = countReplies(root),
    val totalLikes: Int = countLikes(root),
    val totalReposts: Int = countReposts(root)
) {
    public companion object {
        private fun countReplies(node: PlotNode): Int =
            node.children.size + node.children.fastSumBy { countReplies(it) }

        private fun countLikes(node: PlotNode): Int =
            node.post.likesCount + node.children.fastSumBy { countLikes(it) }

        private fun countReposts(node: PlotNode): Int =
            node.post.repostCount + node.children.fastSumBy { countReposts(it) }
    }

    public fun findPost(postId: String): PlotNode? = root.findNode(postId)

    public fun addReply(parentId: String, reply: Post): Boolean {
        val parentNode = findPost(parentId) ?: return false
        parentNode.addReply(reply)
        return true
    }

    public fun getAllPosts(): List<Post> = root.getAllPosts()

    public fun getLatestReplies(limit: Int): List<Post> {
        return getAllPosts()
            .sortedByDescending { it.createdAt }
            .drop(1) // Exclude root post
            .take(limit)
    }

    public fun getPathToPost(postId: String): List<Post>? {
        return findPost(postId)?.getPath()
    }

    public fun isParticipant(user: User): Boolean {
        var isParticipant = false
        root.traverse { node ->
            if (node.post.author == user) {
                isParticipant = true
                return@traverse
            }
        }
        return isParticipant
    }

    @Composable
    public fun PlotView(
        onPostClick: (Post) -> Unit,
        onRepostsClick: (Post) -> Unit,
        onLikeClick: (Post) -> Unit,
        onRepostClick: (Post) -> Unit,
        onReplyClick: (Post) -> Unit,
        onMoreClick: (Post) -> Unit,
        onUserClick: (User) -> Unit,
        content: @Composable (Post, Boolean, List<String>) -> Unit,
        modifier: Modifier = Modifier
    ) {
        root.PlotNodeView(
            onPostClick = onPostClick,
            onRepostsClick = onRepostsClick,
            onLikeClick = onLikeClick,
            onRepostClick = onRepostClick,
            onReplyClick = onReplyClick,
            onMoreClick = onMoreClick,
            onUserClick = onUserClick,
            content = content,
            isRoot = true,
        )
    }

    @Composable
    public fun BitePlotView(
        onPostClick: (Post) -> Unit,
        onRepostsClick: (Post) -> Unit,
        onLikeClick: (Post) -> Unit,
        onRepostClick: (Post) -> Unit,
        onReplyClick: (Post) -> Unit,
        onMoreClick: (Post) -> Unit,
        onUserClick: (User) -> Unit,
        modifier: Modifier = Modifier
    ) {
        PlotView(
            onPostClick = onPostClick,
            onRepostsClick = onRepostsClick,
            onLikeClick = onLikeClick,
            onRepostClick = onRepostClick,
            onReplyClick = onReplyClick,
            onMoreClick = onMoreClick,
            onUserClick = onUserClick,
            content = { post, isRoot, repliedUsersAvatars ->
                when (post) {
                    is Bite if isRoot -> post.MainContent(
                        onPostClick = onPostClick,
                        onRepostsClick = onRepostsClick,
                        onLikeClick = onLikeClick,
                        onRepostClick = onRepostClick,
                        onReplyClick = onReplyClick,
                        onMoreClick = onMoreClick,
                        onUserClick = onUserClick
                    )

                    is Bite -> post.ReplyContent(
                        onPostClick = onPostClick,
                        onRepostsClick = onRepostsClick,
                        onLikeClick = onLikeClick,
                        onRepostClick = onRepostClick,
                        onReplyClick = onReplyClick,
                        onMoreClick = onMoreClick,
                        onUserClick = onUserClick,
                        repliedUsersAvatars = repliedUsersAvatars
                    )
                }
            },
            modifier = modifier
        )
    }
}

public fun List<Post>.toPlot(): List<Plot> {
    // Group posts by their parent ID
    val childrenMap = groupBy { it.postParent?.id }

    // Find root posts (posts without parents)
    val rootPosts = fastFilter { it.postParent == null }

    return rootPosts.fastMap { rootPost ->
        // Build tree recursively
        fun buildNode(post: Post, level: Int = 0, parent: PlotNode? = null): PlotNode {
            val children = childrenMap[post.id] ?: emptyList()
            val node = PlotNode(post = post, level = level, parent = parent)
            children.fastForEach { childPost ->
                node.children.add(buildNode(childPost, level + 1, node))
            }
            return node
        }

        val rootNode = buildNode(rootPost)
        Plot(root = rootNode)
    }
}