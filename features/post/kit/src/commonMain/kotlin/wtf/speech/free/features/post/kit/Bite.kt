@file:OptIn(ExperimentalMaterialApi::class)

package wtf.speech.free.features.post.kit

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.pluralStringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import speechwtf.features.post.kit.generated.resources.Res
import speechwtf.features.post.kit.generated.resources.post_kit_likes
import speechwtf.features.post.kit.generated.resources.post_kit_replies
import speechwtf.features.post.kit.generated.resources.post_kit_reply
import speechwtf.features.post.kit.generated.resources.post_kit_replying_to
import speechwtf.features.post.kit.generated.resources.post_kit_reposts
import wtf.speech.free.core.kit.AsyncCircleAvatarMedium
import wtf.speech.free.core.kit.AsyncSmallAvatarsGroup
import wtf.speech.free.core.kit.Body1Text
import wtf.speech.free.core.kit.Body3Text
import wtf.speech.free.core.kit.Body5Text
import wtf.speech.free.core.kit.FlatCard
import wtf.speech.free.core.kit.GhostButton
import wtf.speech.free.core.kit.SpeechButtonColors
import wtf.speech.free.core.kit.SpeechIconButton
import wtf.speech.free.core.kit.VerticalSeparator
import wtf.speech.free.core.kit.icons.SpeechIcons
import wtf.speech.free.core.kit.icons.actions.Heart
import wtf.speech.free.core.kit.icons.actions.HeartFilled
import wtf.speech.free.core.kit.icons.actions.Menu
import wtf.speech.free.core.kit.icons.actions.Send
import wtf.speech.free.core.kit.icons.nav.Blab
import wtf.speech.free.core.kit.icons.statuses.Elipse
import wtf.speech.free.core.kit.theme.SpeechTheme

@Immutable
public data class Bite(
    public override val id: String,
    public override val author: User,
    public override val likesCount: Int,
    public override val repostCount: Int,
    public override val repliesCount: Int,
    public override val createdAt: String,
    public override val updatedAt: String,
    public override val permission: PlotPermission,
    public override val liked: Boolean,
    public val content: String,
    public val mediaUrls: List<String>,
    public override val originalPost: Post? = null,
    public override val postParent: Post? = null,
    public override val postRoot: Post? = null,
    public override val quotePost: Post? = null,
    public override val isRepost: Boolean = false,
    public override val repostedPost: Post? = null,
    public override val repostedUser: User? = null,
) : Post(
    id,
    author,
    likesCount,
    repostCount,
    repliesCount,
    createdAt,
    updatedAt,
    permission,
    liked,
    originalPost,
    postParent,
    postRoot,
    quotePost,
    isRepost,
    repostedPost,
    repostedUser,
) {

    @Composable
    public fun MainContent(
        onPostClick: (Post) -> Unit,
        onRepostsClick: (Post) -> Unit,
        onLikeClick: (Post) -> Unit,
        onRepostClick: (Post) -> Unit,
        onReplyClick: (Post) -> Unit,
        onMoreClick: (Post) -> Unit,
        onUserClick: (User) -> Unit,
        modifier: Modifier = Modifier,
    ) {
        CompositionLocalProvider(LocalContentColor provides SpeechTheme.colors.textPrimary) {
            Surface(modifier) {
                Column(Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                    author.PostHeader(onUserClick, createdAt, Modifier.fillMaxWidth())

                    PostTextContent(onPostClick)

                    PostInteractionsCount(
                        onRepostsClick,
                        Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )

                    Divider(
                        Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        color = SpeechTheme.colors.separator
                    )

                    Row(
                        Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        SpeechIconButton(SpeechIcons.Actions.Heart, { onLikeClick(this@Bite) })
                        SpeechIconButton(SpeechIcons.Nav.Blab, { onReplyClick(this@Bite) })
                        SpeechIconButton(SpeechIcons.Actions.Send, { onRepostClick(this@Bite) })
                        SpeechIconButton(SpeechIcons.Actions.Menu, { onMoreClick(this@Bite) })
                    }
                }
            }
        }
    }

    @Composable
    public fun ReplyContent(
        onPostClick: (Post) -> Unit,
        onRepostsClick: (Post) -> Unit,
        onLikeClick: (Post) -> Unit,
        onRepostClick: (Post) -> Unit,
        onReplyClick: (Post) -> Unit,
        onMoreClick: (Post) -> Unit,
        onUserClick: (User) -> Unit,
        repliedUsersAvatars: List<String>,
        modifier: Modifier = Modifier,
    ) {
        CompositionLocalProvider(LocalContentColor provides SpeechTheme.colors.textPrimary) {
            Surface(modifier) {
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (postParent != null) {
                            VerticalSeparator()
                        }
                        AsyncCircleAvatarMedium(author.avatarUrls.first(), "Avatar of $author.name")
                        if (repliesCount > 0) {
                            VerticalSeparator()
                        }
                    }

                    Column {
                        FlatCard(onClick = { onPostClick(this@Bite) }) {
                            Column {
                                ReplyHeader(onUserClick, repliedUsersAvatars)

                                ReplyTextContent()
                                Spacer(Modifier.height(4.dp))
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 4.dp, bottom = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(start = 8.dp),
                            ) {
                                Body5Text(createdAt)

                                InteractionsCount(
                                    {},
                                    likesCount,
                                    pluralStringResource(Res.plurals.post_kit_likes, likesCount),
                                    false,
                                    SpeechTheme.typography.body2,
                                    SpeechTheme.typography.body2,
                                    color = SpeechTheme.colors.textSecondary,
                                )
                                ReplyButton { onReplyClick(this@Bite) }
                            }

                            val animatedLikeColor by animateColorAsState(if (liked) SpeechTheme.colors.error else SpeechTheme.colors.onInteractiveSecondary)

                            SpeechIconButton(
                                if (liked) SpeechIcons.Actions.HeartFilled else SpeechIcons.Actions.Heart,
                                { onLikeClick(this@Bite) },
                                shape = RoundedCornerShape(16.dp),
                                colors = SpeechButtonColors.icon(content = animatedLikeColor),
                                contentPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp),
                                content = {
                                    Icon(
                                        imageVector = it,
                                        contentDescription = it.name,
                                        tint = LocalContentColor.current,
                                        modifier = Modifier.size(20.dp),
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ReplyHeader(
        onUserClick: (User) -> Unit,
        repliedUsersAvatars: List<String>
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
        ) {
            ReplayUserInfo(onUserClick)

            if (repliesCount > 0) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Body5Text(
                        "$repliesCount " +
                                pluralStringResource(
                                    Res.plurals.post_kit_replies,
                                    repliesCount,
                                    repliesCount.toString()
                                )
                    )

                    AsyncSmallAvatarsGroup(avatars = repliedUsersAvatars)
                }
            }
        }
    }

    @Composable
    private fun ReplayUserInfo(onUserClick: (User) -> Unit) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            author.UsernameHeader(onUserClick)
            postRoot?.author?.let { repliedUser ->
                val replyingResource = stringResource(Res.string.post_kit_replying_to)
                val textStyle = SpeechTheme.typography.body5
                val userLinkColor = SpeechTheme.colors.interactivePrimary
                val clickableSpanStyle = textStyle.toSpanStyle().copy(color = userLinkColor)
                val text = remember(repliedUser.username) {
                    buildAnnotatedString {
                        append(replyingResource)

                        withLink(
                            LinkAnnotation.Clickable(
                                repliedUser.username,
                                TextLinkStyles(
                                    style = clickableSpanStyle,
                                ),
                                { onUserClick(repliedUser) }),
                        ) {
                            append(repliedUser.username)
                        }
                    }
                }
                Body5Text(
                    text,
                    color = SpeechTheme.colors.textSecondary,
                )
            }
        }
    }

    @Composable
    private fun PostInteractionsCount(
        onRepostClick: (Post) -> Unit,
        modifier: Modifier = Modifier
    ) {
        Row(modifier, verticalAlignment = Alignment.CenterVertically) {
            InteractionsCount(
                pluralStringResource(Res.plurals.post_kit_likes, likesCount),
                likesCount
            )

            Icon(SpeechIcons.Statuses.Elipse, contentDescription = null)

            InteractionsCount(
                pluralStringResource(Res.plurals.post_kit_replies, repliesCount),
                repliesCount
            )

            Icon(SpeechIcons.Statuses.Elipse, contentDescription = null)

            InteractionsCount(
                { onRepostClick(this@Bite) },
                repostCount,
                pluralStringResource(Res.plurals.post_kit_reposts, repostCount),
            )
        }
    }

    @Composable
    private fun PostTextContent(onPostClick: (Post) -> Unit) {
        Box(modifier = Modifier.clickable { onPostClick(this@Bite) }) {
            PostTextContent()
        }
    }

    @Composable
    private fun PostTextContent() {
        Body1Text(
            content,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }

    @Composable
    private fun ReplyTextContent() {
        Body3Text(
            content,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }

    @Composable
    private fun ReplyButton(onClick: () -> Unit) {
        GhostButton(
            stringResource(Res.string.post_kit_reply),
            onClick,
            colors = SpeechButtonColors.ghost(content = SpeechTheme.colors.textSecondary)
        )
    }
}

@Composable
private fun InteractionsCount(
    onRepostClick: () -> Unit,
    count: Int,
    text: String,
    enabled: Boolean = true,
    countStyle: TextStyle = SpeechTheme.typography.body4,
    textStyle: TextStyle = SpeechTheme.typography.body5,
    color: Color = LocalContentColor.current,
) {
    val text = remember(countStyle, textStyle, count) {
        buildAnnotatedString {
            pushStyle(countStyle.toSpanStyle())
            append(count.toString())
            pushStyle(textStyle.toSpanStyle())
            append(" ")
            append(text)
        }
    }

    Text(text, modifier = Modifier.clickable(enabled, onClick = onRepostClick), color = color)
}

@Composable
private fun InteractionsCount(text: String, count: Int) {
    InteractionsCount({}, count, text, false)
}


public fun Post.isThreadRoot(): Boolean = postParent == null
public fun Post.isThreadReply(): Boolean = postParent != null
public fun Post.isQuotePost(): Boolean = quotePost != null
public fun Post.isPartOfThread(): Boolean = postRoot != null
public fun Post.isRetweet(): Boolean = isRepost && repostedPost != null

@Preview
@Composable
public fun PostPreview() {
    SpeechTheme {
        Column {
            Bite(
                "",
                User("", "usmonie", "usman", listOf("https://picsum.photos/200")),
                12,
                1,
                10,
                "Today at 19:45",
                "Today at 19:45",
                PlotPermission.ForEveryone,
                true,
                "Hi, this is post in speech",
                emptyList(),
            )
        }
    }
}

