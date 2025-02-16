package wtf.speech.free.core.kit.icons.actions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.icons.SpeechIcons

public val SpeechIcons.Actions.Plot: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Plot",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
        ) {
            moveTo(9f, 10f)
            lineTo(5f, 10f)
            curveTo(4.448f, 10f, 4f, 9.552f, 4f, 9f)
            lineTo(4f, 5f)
            curveTo(4f, 4.448f, 4.448f, 4f, 5f, 4f)
            lineTo(9f, 4f)
            curveTo(9.552f, 4f, 10f, 4.448f, 10f, 5f)
            lineTo(10f, 9f)
            curveTo(10f, 9.552f, 9.552f, 10f, 9f, 10f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
        ) {
            moveTo(19f, 10f)
            lineTo(15f, 10f)
            curveTo(14.448f, 10f, 14f, 9.552f, 14f, 9f)
            lineTo(14f, 5f)
            curveTo(14f, 4.448f, 14.448f, 4f, 15f, 4f)
            lineTo(19f, 4f)
            curveTo(19.552f, 4f, 20f, 4.448f, 20f, 5f)
            lineTo(20f, 9f)
            curveTo(20f, 9.552f, 19.552f, 10f, 19f, 10f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
        ) {
            moveTo(9f, 20f)
            lineTo(5f, 20f)
            curveTo(4.448f, 20f, 4f, 19.552f, 4f, 19f)
            lineTo(4f, 15f)
            curveTo(4f, 14.448f, 4.448f, 14f, 5f, 14f)
            lineTo(9f, 14f)
            curveTo(9.552f, 14f, 10f, 14.448f, 10f, 15f)
            lineTo(10f, 19f)
            curveTo(10f, 19.552f, 9.552f, 20f, 9f, 20f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
        ) {
            moveTo(19f, 20f)
            lineTo(15f, 20f)
            curveTo(14.448f, 20f, 14f, 19.552f, 14f, 19f)
            lineTo(14f, 15f)
            curveTo(14f, 14.448f, 14.448f, 14f, 15f, 14f)
            lineTo(19f, 14f)
            curveTo(19.552f, 14f, 20f, 14.448f, 20f, 15f)
            lineTo(20f, 19f)
            curveTo(20f, 19.552f, 19.552f, 20f, 19f, 20f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun PlotPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Plot, contentDescription = null)
    }
}
