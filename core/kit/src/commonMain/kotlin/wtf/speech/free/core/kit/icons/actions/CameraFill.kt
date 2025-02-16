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

public val SpeechIcons.Actions.CameraFill: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.CameraFill",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(fill = SolidColor(Color(0xFF1F3241))) {
            moveTo(22f, 7.25f)
            verticalLineTo(18.179f)
            curveTo(22f, 19.184f, 21.16f, 20f, 20.125f, 20f)
            horizontalLineTo(3.875f)
            curveTo(2.84f, 20f, 2f, 19.184f, 2f, 18.179f)
            verticalLineTo(7.25f)
            curveTo(2f, 6.244f, 2.84f, 5.429f, 3.875f, 5.429f)
            horizontalLineTo(7.313f)
            lineTo(7.793f, 4.18f)
            curveTo(8.066f, 3.471f, 8.766f, 3f, 9.547f, 3f)
            horizontalLineTo(14.449f)
            curveTo(15.231f, 3f, 15.93f, 3.471f, 16.203f, 4.18f)
            lineTo(16.688f, 5.429f)
            horizontalLineTo(20.125f)
            curveTo(21.16f, 5.429f, 22f, 6.244f, 22f, 7.25f)
            close()
            moveTo(16.688f, 12.714f)
            curveTo(16.688f, 10.202f, 14.586f, 8.161f, 12f, 8.161f)
            curveTo(9.414f, 8.161f, 7.313f, 10.202f, 7.313f, 12.714f)
            curveTo(7.313f, 15.226f, 9.414f, 17.268f, 12f, 17.268f)
            curveTo(14.586f, 17.268f, 16.688f, 15.226f, 16.688f, 12.714f)
            close()
            moveTo(15.438f, 12.714f)
            curveTo(15.438f, 14.555f, 13.894f, 16.054f, 12f, 16.054f)
            curveTo(10.106f, 16.054f, 8.563f, 14.555f, 8.563f, 12.714f)
            curveTo(8.563f, 10.874f, 10.106f, 9.375f, 12f, 9.375f)
            curveTo(13.894f, 9.375f, 15.438f, 10.874f, 15.438f, 12.714f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun CameraFillPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.CameraFill, contentDescription = null)
    }
}
