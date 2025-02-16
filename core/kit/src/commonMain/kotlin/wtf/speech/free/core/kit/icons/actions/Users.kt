package wtf.speech.free.core.kit.icons.actions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.icons.SpeechIcons

public val SpeechIcons.Actions.Users: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Users",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(17f, 16.228f)
            curveTo(19.33f, 16.777f, 21f, 18.258f, 21f, 20f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(3f, 20f)
            curveTo(3f, 17.791f, 5.686f, 16f, 9f, 16f)
            curveTo(12.314f, 16f, 15f, 17.791f, 15f, 20f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(15f, 13f)
            curveTo(17.209f, 13f, 19f, 11.209f, 19f, 9f)
            curveTo(19f, 6.791f, 17.209f, 5f, 15f, 5f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(9f, 13f)
            curveTo(11.209f, 13f, 13f, 11.209f, 13f, 9f)
            curveTo(13f, 6.791f, 11.209f, 5f, 9f, 5f)
            curveTo(6.791f, 5f, 5f, 6.791f, 5f, 9f)
            curveTo(5f, 11.209f, 6.791f, 13f, 9f, 13f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun UsersPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Users, contentDescription = null)
    }
}
