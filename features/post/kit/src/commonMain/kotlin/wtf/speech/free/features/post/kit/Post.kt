package wtf.speech.free.features.post.kit

import androidx.compose.runtime.Immutable

@Immutable
public sealed class Post(
    public open val id: String,
    public open val author: User,
    public open val likesCount: Int,
    public open val repostCount: Int,
    public open val repliesCount: Int,
    public open val createdAt: String,
    public open val updatedAt: String,
    public open val permission: PlotPermission,
    public open val liked: Boolean,
    public open val originalPost: Post? = null,
    public open val postParent: Post? = null,
    public open val postRoot: Post? = null,
    public open val quotePost: Post? = null,
    public open val isRepost: Boolean = false,
    public open val repostedPost: Post? = null,
    public open val repostedUser: User? = null,
)
