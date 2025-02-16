package wtf.speech.free.core.kit.icons.nav

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

public val SpeechIcons.Nav.HomeFill: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Nav.HomeFill",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFF1F3241)),
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(3.731f, 8.789f)
            lineTo(10.731f, 3.042f)
            curveTo(11.469f, 2.436f, 12.531f, 2.436f, 13.269f, 3.042f)
            lineTo(20.269f, 8.789f)
            curveTo(20.732f, 9.169f, 21f, 9.736f, 21f, 10.335f)
            verticalLineTo(19f)
            curveTo(21f, 20.105f, 20.105f, 21f, 19f, 21f)
            horizontalLineTo(5f)
            curveTo(3.895f, 21f, 3f, 20.105f, 3f, 19f)
            verticalLineTo(10.335f)
            curveTo(3f, 9.736f, 3.268f, 9.169f, 3.731f, 8.789f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun HomeFillPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Nav.HomeFill, contentDescription = null)
    }
}
