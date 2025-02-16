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

public val SpeechIcons.Statuses.Bell: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Statuses.Bell",
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
            moveTo(10f, 11.333f)
            horizontalLineTo(6f)
            verticalLineTo(12f)
            curveTo(6f, 13.105f, 6.895f, 14f, 8f, 14f)
            curveTo(9.105f, 14f, 10f, 13.105f, 10f, 12f)
            verticalLineTo(11.333f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(3.333f, 11.333f)
            horizontalLineTo(12.667f)
            curveTo(13.035f, 11.333f, 13.333f, 11.035f, 13.333f, 10.667f)
            verticalLineTo(10.276f)
            curveTo(13.333f, 10.099f, 13.263f, 9.93f, 13.138f, 9.805f)
            lineTo(12.798f, 9.464f)
            curveTo(12.714f, 9.38f, 12.667f, 9.267f, 12.667f, 9.148f)
            verticalLineTo(6.667f)
            curveTo(12.667f, 4.089f, 10.577f, 2f, 8f, 2f)
            curveTo(5.423f, 2f, 3.333f, 4.089f, 3.333f, 6.667f)
            verticalLineTo(9.148f)
            curveTo(3.333f, 9.267f, 3.286f, 9.38f, 3.203f, 9.464f)
            lineTo(2.862f, 9.805f)
            curveTo(2.737f, 9.93f, 2.667f, 10.099f, 2.667f, 10.276f)
            verticalLineTo(10.667f)
            curveTo(2.667f, 11.035f, 2.965f, 11.333f, 3.333f, 11.333f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun BellPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Statuses.Bell, contentDescription = null)
    }
}
