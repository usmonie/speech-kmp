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

public val SpeechIcons.Actions.Bell: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Bell",
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
            moveTo(15f, 17f)
            horizontalLineTo(9f)
            verticalLineTo(18f)
            curveTo(9f, 19.657f, 10.343f, 21f, 12f, 21f)
            curveTo(13.657f, 21f, 15f, 19.657f, 15f, 18f)
            verticalLineTo(17f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(5f, 17f)
            horizontalLineTo(19f)
            curveTo(19.552f, 17f, 20f, 16.552f, 20f, 16f)
            verticalLineTo(15.414f)
            curveTo(20f, 15.149f, 19.895f, 14.895f, 19.707f, 14.707f)
            lineTo(19.196f, 14.196f)
            curveTo(19.071f, 14.071f, 19f, 13.9f, 19f, 13.722f)
            verticalLineTo(10f)
            curveTo(19f, 6.134f, 15.866f, 3f, 12f, 3f)
            curveTo(8.134f, 3f, 5f, 6.134f, 5f, 10f)
            verticalLineTo(13.722f)
            curveTo(5f, 13.9f, 4.929f, 14.071f, 4.804f, 14.196f)
            lineTo(4.293f, 14.707f)
            curveTo(4.105f, 14.895f, 4f, 15.149f, 4f, 15.414f)
            verticalLineTo(16f)
            curveTo(4f, 16.552f, 4.448f, 17f, 5f, 17f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun BellPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Bell, contentDescription = null)
    }
}
