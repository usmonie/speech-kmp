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

public val SpeechIcons.Actions.UserVoice: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.UserVoice",
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
            moveTo(3f, 19f)
            curveTo(3f, 16.791f, 5.686f, 15f, 9f, 15f)
            curveTo(12.314f, 15f, 15f, 16.791f, 15f, 19f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(16.828f, 5.172f)
            curveTo(17.2f, 5.543f, 17.494f, 5.984f, 17.695f, 6.469f)
            curveTo(17.896f, 6.955f, 18f, 7.475f, 18f, 8f)
            curveTo(18f, 8.525f, 17.896f, 9.045f, 17.695f, 9.531f)
            curveTo(17.494f, 10.016f, 17.2f, 10.457f, 16.828f, 10.828f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(9f, 12f)
            curveTo(11.209f, 12f, 13f, 10.209f, 13f, 8f)
            curveTo(13f, 5.791f, 11.209f, 4f, 9f, 4f)
            curveTo(6.791f, 4f, 5f, 5.791f, 5f, 8f)
            curveTo(5f, 10.209f, 6.791f, 12f, 9f, 12f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(19f, 3f)
            curveTo(19.657f, 3.657f, 20.177f, 4.436f, 20.533f, 5.294f)
            curveTo(20.888f, 6.152f, 21.071f, 7.071f, 21.071f, 8f)
            curveTo(21.071f, 8.929f, 20.888f, 9.848f, 20.533f, 10.706f)
            curveTo(20.177f, 11.564f, 19.657f, 12.343f, 19f, 13f)
        }
    }.build()
}

@Preview
@Composable
private fun UserVoicePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.UserVoice, contentDescription = null)
    }
}
