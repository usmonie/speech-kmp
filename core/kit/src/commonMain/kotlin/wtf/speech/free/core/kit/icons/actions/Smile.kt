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

public val SpeechIcons.Actions.Smile: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Smile",
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
            moveTo(12f, 2f)
            curveTo(17.523f, 2f, 22f, 6.477f, 22f, 12f)
            curveTo(22f, 17.523f, 17.523f, 22f, 12f, 22f)
            curveTo(6.477f, 22f, 2f, 17.523f, 2f, 12f)
            curveTo(2f, 6.477f, 6.477f, 2f, 12f, 2f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
        ) {
            moveTo(8f, 15f)
            curveTo(10.5f, 17f, 13.5f, 17f, 16f, 15f)
        }
        path(
            fill = SolidColor(Color(0xFF1F3241)),
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 0.5f,
            strokeLineCap = StrokeCap.Round,
        ) {
            moveTo(9f, 9f)
            curveTo(9.552f, 9f, 10f, 9.448f, 10f, 10f)
            curveTo(10f, 10.552f, 9.552f, 11f, 9f, 11f)
            curveTo(8.448f, 11f, 8f, 10.552f, 8f, 10f)
            curveTo(8f, 9.448f, 8.448f, 9f, 9f, 9f)
            close()
        }
        path(
            fill = SolidColor(Color(0xFF1F3241)),
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 0.5f,
            strokeLineCap = StrokeCap.Round,
        ) {
            moveTo(15f, 9f)
            curveTo(15.552f, 9f, 16f, 9.448f, 16f, 10f)
            curveTo(16f, 10.552f, 15.552f, 11f, 15f, 11f)
            curveTo(14.448f, 11f, 14f, 10.552f, 14f, 10f)
            curveTo(14f, 9.448f, 14.448f, 9f, 15f, 9f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun SmilePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Smile, contentDescription = null)
    }
}
