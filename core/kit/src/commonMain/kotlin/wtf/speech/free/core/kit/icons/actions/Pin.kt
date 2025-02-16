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

public val SpeechIcons.Actions.Pin: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Pin",
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
            moveTo(20.24f, 12.24f)
            curveTo(21.366f, 11.114f, 21.998f, 9.587f, 21.998f, 7.995f)
            curveTo(21.998f, 6.403f, 21.366f, 4.876f, 20.24f, 3.75f)
            curveTo(19.114f, 2.624f, 17.587f, 1.992f, 15.995f, 1.992f)
            curveTo(14.403f, 1.992f, 12.876f, 2.624f, 11.75f, 3.75f)
            lineTo(5.586f, 9.914f)
            curveTo(5.211f, 10.289f, 5f, 10.798f, 5f, 11.328f)
            verticalLineTo(17f)
            curveTo(5f, 18.104f, 5.895f, 19f, 7f, 19f)
            horizontalLineTo(12.67f)
            curveTo(13.201f, 19f, 13.711f, 18.788f, 14.086f, 18.412f)
            lineTo(20.24f, 12.24f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(16f, 8f)
            lineTo(2f, 22f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(9f, 6.5f)
            verticalLineTo(14.5f)
        }
    }.build()
}

@Preview
@Composable
private fun PinPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Pin, contentDescription = null)
    }
}
