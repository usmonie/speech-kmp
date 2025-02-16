package wtf.speech.free.core.kit.icons.actions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.icons.SpeechIcons

public val SpeechIcons.Actions.Voice: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Voice",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
        ) {
            moveTo(6f, 10f)
            verticalLineTo(11f)
            curveTo(6f, 14.314f, 8.686f, 17f, 12f, 17f)
            verticalLineTo(17f)
            curveTo(15.314f, 17f, 18f, 14.314f, 18f, 11f)
            verticalLineTo(10f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
        ) {
            moveTo(12f, 17f)
            verticalLineTo(21f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
        ) {
            moveTo(9f, 5f)
            verticalLineTo(11f)
            curveTo(9f, 12.657f, 10.343f, 14f, 12f, 14f)
            curveTo(13.657f, 14f, 15f, 12.657f, 15f, 11f)
            verticalLineTo(5f)
            curveTo(15f, 3.343f, 13.657f, 2f, 12f, 2f)
            curveTo(10.343f, 2f, 9f, 3.343f, 9f, 5f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun VoicePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Voice, contentDescription = null)
    }
}
