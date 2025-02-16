package wtf.speech.free.features.timeline.kit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.HorizontalSeparator
import wtf.speech.free.core.kit.icons.SpeechIcons
import wtf.speech.free.core.kit.icons.actions.Send
import wtf.speech.free.core.kit.theme.SpeechTheme
import wtf.speech.free.features.post.kit.Bite
import wtf.speech.free.features.post.kit.Plot
import wtf.speech.free.features.post.kit.PlotNode
import wtf.speech.free.features.post.kit.PlotPermission
import wtf.speech.free.features.post.kit.Post
import wtf.speech.free.features.post.kit.User

@Immutable
public data class TimelineState(
    val items: List<TimelineItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val hasMore: Boolean = true,
    val nextPageToken: String? = null
) {
    public fun appendItems(newItems: List<TimelineItem>, newNextPageToken: String?): TimelineState =
        copy(
            items = items + newItems,
            nextPageToken = newNextPageToken,
            hasMore = newNextPageToken != null
        )

    @Composable
    public fun Timeline(
        onPostClick: (Post) -> Unit,
        onRepostsClick: (Post) -> Unit,
        onLikeClick: (Post) -> Unit,
        onRepostClick: (Post) -> Unit,
        onReplyClick: (Post) -> Unit,
        onMoreClick: (Post) -> Unit,
        onUserClick: (User) -> Unit,
        onLoadMore: () -> Unit,
        postContent: @Composable (post: Post, isRoot: Boolean, repliedUsersAvatars: List<String>) -> Unit = { post, isRoot, repliedUsersAvatars ->
            when (post) {
                is Bite -> {
                    if (isRoot) {
                        post.MainContent(
                            onPostClick = onPostClick,
                            onRepostsClick = onRepostsClick,
                            onLikeClick = onLikeClick,
                            onRepostClick = onRepostClick,
                            onReplyClick = onReplyClick,
                            onMoreClick = onMoreClick,
                            onUserClick = onUserClick
                        )
                    } else {
                        post.ReplyContent(
                            onPostClick = onPostClick,
                            onRepostsClick = onRepostsClick,
                            onLikeClick = onLikeClick,
                            onRepostClick = onRepostClick,
                            onReplyClick = onReplyClick,
                            onMoreClick = onMoreClick,
                            onUserClick = onUserClick,
                            repliedUsersAvatars = repliedUsersAvatars,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        },
        modifier: Modifier = Modifier
    ) {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(vertical = 48.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items.size) { index ->
                if (index >= items.size - 5 && !isLoading && hasMore) {
                    onLoadMore()
                }

                when (val item = items[index]) {
                    is TimelineItem.SinglePost -> {
                        postContent(item.post, true, emptyList())
                    }

                    is TimelineItem.PlotUpdate -> {
                        item.plot.PlotView(
                            onPostClick = onPostClick,
                            onRepostsClick = onRepostsClick,
                            onLikeClick = onLikeClick,
                            onRepostClick = onRepostClick,
                            onReplyClick = onReplyClick,
                            onMoreClick = onMoreClick,
                            onUserClick = onUserClick,
                            content = postContent,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    is TimelineItem.RepostUpdate -> {
                        Column {
                            // Show repost info
                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(SpeechIcons.Actions.Send, contentDescription = null)

                            }

                            // Show original post
                            postContent(item.originalPost, true, emptyList())
                        }
                    }
                }

                if (index < items.size - 1) {
                    HorizontalSeparator()
                }
            }

            if (isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }

            if (error != null) {
                item {
                }
            }
        }
    }
}

@Immutable
public sealed class TimelineItem {
    public data class SinglePost(
        val post: Post
    ) : TimelineItem()

    public data class PlotUpdate(
        val plot: Plot,
        val latestReply: Post,
        val newRepliesCount: Int,
        val highlightedPostId: String? = null
    ) : TimelineItem()

    public data class RepostUpdate(
        val repost: Post,
        val originalPost: Post,
        val reposter: User
    ) : TimelineItem()
}

@Preview
@Composable
public fun TimelinePreview() {
    // Create sample users
    val mainUser = User(
        id = "user1",
        username = "@john_doe",
        name = "John Doe",
        avatarUrls = listOf("https://picsum.photos/200")
    )

    val replier = User(
        id = "user2",
        username = "@jane_smith",
        name = "Jane Smith",
        avatarUrls = listOf("https://picsum.photos/201")
    )

    val reposter = User(
        id = "user3",
        username = "@bob_wilson",
        name = "Bob Wilson",
        avatarUrls = listOf("https://picsum.photos/202")
    )

    // Create sample posts
    val singleBite = Bite(
        id = "post1",
        author = mainUser,
        likesCount = 42,
        repostCount = 15,
        repliesCount = 7,
        createdAt = "2h ago",
        updatedAt = "2h ago",
        permission = PlotPermission.ForEveryone,
        liked = true,
        content = "This is a single post showing in the timeline. #speech",
        mediaUrls = emptyList()
    )

    // Create a plot (thread) with multiple replies
    val rootBite = Bite(
        id = "thread1",
        author = mainUser,
        likesCount = 100,
        repostCount = 25,
        repliesCount = 2,
        createdAt = "3h ago",
        updatedAt = "1h ago",
        permission = PlotPermission.ForEveryone,
        liked = false,
        content = "Starting a thread about something interesting! 🧵",
        mediaUrls = emptyList()
    )

    val reply1 = Bite(
        id = "reply1",
        author = replier,
        likesCount = 30,
        repostCount = 5,
        repliesCount = 1,
        createdAt = "2h ago",
        updatedAt = "2h ago",
        permission = PlotPermission.ForEveryone,
        liked = true,
        content = "This is such an interesting topic! Let's discuss more.",
        mediaUrls = emptyList(),
        postParent = rootBite,
        postRoot = rootBite
    )

    val reply2 = Bite(
        id = "reply2",
        author = mainUser,
        likesCount = 20,
        repostCount = 3,
        repliesCount = 0,
        createdAt = "1h ago",
        updatedAt = "1h ago",
        permission = PlotPermission.ForEveryone,
        liked = false,
        content = "Thank you for your interest! Here's more detail...",
        mediaUrls = emptyList(),
        postParent = reply1,
        postRoot = rootBite
    )

    // Create a repost
    val originalBite = Bite(
        id = "original1",
        author = replier,
        likesCount = 75,
        repostCount = 30,
        repliesCount = 12,
        createdAt = "4h ago",
        updatedAt = "4h ago",
        permission = PlotPermission.ForEveryone,
        liked = true,
        content = "Original post that got reposted!",
        mediaUrls = emptyList()
    )

    val repost = Bite(
        id = "repost1",
        author = reposter,
        likesCount = 10,
        repostCount = 2,
        repliesCount = 0,
        createdAt = "1h ago",
        updatedAt = "1h ago",
        permission = PlotPermission.ForEveryone,
        liked = false,
        content = "",
        mediaUrls = emptyList(),
        isRepost = true,
        repostedPost = originalBite,
        repostedUser = replier
    )

    // Create plot
    val plotRoot = PlotNode(post = rootBite)
    val plotReply1 = plotRoot.addReply(reply1)
    plotReply1.addReply(reply2)
    val plot = Plot(root = plotRoot)

    // Create timeline items
    val timelineItems = listOf(
        TimelineItem.SinglePost(singleBite),
        TimelineItem.PlotUpdate(
            plot = plot,
            latestReply = reply2,
            newRepliesCount = 2
        ),
//        TimelineItem.RepostUpdate(
//            repost = repost,
//            originalPost = originalBite,
//            reposter = reposter
//        )
    )

    // Create timeline state
    val timelineState = remember {
        TimelineState(
            items = timelineItems,
            isLoading = false,
            error = null,
            hasMore = true,
            nextPageToken = "next_page_token"
        )
    }

    SpeechTheme {
        timelineState.Timeline(
            onPostClick = {},
            onRepostsClick = {},
            onLikeClick = {},
            onRepostClick = {},
            onReplyClick = {},
            onMoreClick = {},
            onUserClick = {},
            onLoadMore = {}
        )
    }
}

