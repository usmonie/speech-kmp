package wtf.speech.free.core.kit.icons.statuses

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

public val SpeechIcons.Statuses.Pin: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Statuses.Pin",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f,
    ).apply {
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(12.966f, 8.025f)
            curveTo(13.628f, 7.364f, 14f, 6.466f, 14f, 5.53f)
            curveTo(14f, 4.594f, 13.628f, 3.696f, 12.966f, 3.034f)
            curveTo(12.303f, 2.372f, 11.405f, 2f, 10.468f, 2f)
            curveTo(9.532f, 2f, 8.633f, 2.372f, 7.971f, 3.034f)
            lineTo(4.586f, 6.417f)
            curveTo(4.211f, 6.792f, 4f, 7.301f, 4f, 7.831f)
            verticalLineTo(10f)
            curveTo(4f, 11.105f, 4.895f, 12f, 6f, 12f)
            horizontalLineTo(8.171f)
            curveTo(8.702f, 12f, 9.211f, 11.789f, 9.587f, 11.413f)
            lineTo(12.966f, 8.025f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(10.5f, 5.5f)
            lineTo(2.5f, 13.5f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(8f, 3.667f)
            lineTo(8f, 7.667f)
        }
    }.build()
}

@Preview
@Composable
private fun PinPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Statuses.Pin, contentDescription = null)
    }
}
