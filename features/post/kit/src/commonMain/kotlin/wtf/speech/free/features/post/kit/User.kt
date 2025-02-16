@file:OptIn(ExperimentalMaterialApi::class)

package wtf.speech.free.features.post.kit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import wtf.speech.free.core.kit.AsyncCircleAvatarMedium
import wtf.speech.free.core.kit.Body2Text
import wtf.speech.free.core.kit.Body5Text
import wtf.speech.free.core.kit.theme.SpeechTheme

@Immutable
public data class User(
    public val id: String,
    public val username: String,
    public val name: String,
    public val avatarUrls: List<String>,
) {

    @Composable
    public fun PostHeader(
        onClick: (User) -> Unit,
        postCreatedAt: String,
        modifier: Modifier = Modifier,
    ) {
        Surface(
            onClick = { onClick(this) },
            modifier = modifier,
            shape = SpeechTheme.shapes.medium,
        ) {
            Row(
                Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AsyncCircleAvatarMedium(avatarUrls.first(), "Avatar of $name")
                Column {
                    Body2Text(name)
                    Body5Text(postCreatedAt)
                }
            }
        }
    }

    @Composable
    public fun UsernameHeader(
        onClick: (User) -> Unit,
        modifier: Modifier = Modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Body2Text(name)
            Body5Text(username)
        }
    }
}
