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

public val SpeechIcons.Actions.Settings: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Settings",
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
            moveTo(12f, 16f)
            curveTo(14.209f, 16f, 16f, 14.209f, 16f, 12f)
            curveTo(16f, 9.791f, 14.209f, 8f, 12f, 8f)
            curveTo(9.791f, 8f, 8f, 9.791f, 8f, 12f)
            curveTo(8f, 14.209f, 9.791f, 16f, 12f, 16f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(19.167f, 7.94f)
            lineTo(19.101f, 7.826f)
            curveTo(18.92f, 7.512f, 18.827f, 7.155f, 18.833f, 6.792f)
            lineTo(18.863f, 5.013f)
            curveTo(18.869f, 4.65f, 18.678f, 4.312f, 18.363f, 4.13f)
            lineTo(15.626f, 2.553f)
            curveTo(15.312f, 2.372f, 14.924f, 2.375f, 14.613f, 2.562f)
            lineTo(13.094f, 3.471f)
            curveTo(12.784f, 3.657f, 12.429f, 3.755f, 12.067f, 3.755f)
            horizontalLineTo(11.935f)
            curveTo(11.572f, 3.755f, 11.216f, 3.657f, 10.906f, 3.47f)
            lineTo(9.379f, 2.554f)
            curveTo(9.067f, 2.366f, 8.678f, 2.363f, 8.363f, 2.546f)
            lineTo(5.635f, 4.13f)
            curveTo(5.321f, 4.311f, 5.131f, 4.649f, 5.137f, 5.011f)
            lineTo(5.167f, 6.792f)
            curveTo(5.173f, 7.155f, 5.08f, 7.512f, 4.899f, 7.826f)
            lineTo(4.834f, 7.939f)
            curveTo(4.653f, 8.253f, 4.389f, 8.512f, 4.072f, 8.687f)
            lineTo(2.517f, 9.549f)
            curveTo(2.198f, 9.726f, 2.001f, 10.062f, 2.001f, 10.426f)
            lineTo(2.009f, 13.578f)
            curveTo(2.009f, 13.94f, 2.206f, 14.274f, 2.522f, 14.45f)
            lineTo(4.07f, 15.31f)
            curveTo(4.388f, 15.488f, 4.652f, 15.748f, 4.833f, 16.065f)
            lineTo(4.903f, 16.186f)
            curveTo(5.082f, 16.499f, 5.173f, 16.853f, 5.167f, 17.213f)
            lineTo(5.137f, 18.986f)
            curveTo(5.131f, 19.35f, 5.322f, 19.688f, 5.637f, 19.87f)
            lineTo(8.374f, 21.447f)
            curveTo(8.688f, 21.628f, 9.076f, 21.625f, 9.387f, 21.438f)
            lineTo(10.906f, 20.529f)
            curveTo(11.217f, 20.343f, 11.572f, 20.245f, 11.934f, 20.245f)
            horizontalLineTo(12.065f)
            curveTo(12.428f, 20.245f, 12.784f, 20.343f, 13.095f, 20.53f)
            lineTo(14.621f, 21.446f)
            curveTo(14.933f, 21.633f, 15.323f, 21.636f, 15.637f, 21.454f)
            lineTo(18.365f, 19.87f)
            curveTo(18.679f, 19.688f, 18.869f, 19.351f, 18.863f, 18.989f)
            lineTo(18.833f, 17.208f)
            curveTo(18.827f, 16.845f, 18.92f, 16.488f, 19.101f, 16.174f)
            lineTo(19.166f, 16.061f)
            curveTo(19.348f, 15.747f, 19.611f, 15.488f, 19.929f, 15.312f)
            lineTo(21.483f, 14.451f)
            curveTo(21.802f, 14.274f, 22f, 13.938f, 21.999f, 13.574f)
            lineTo(21.992f, 10.422f)
            curveTo(21.991f, 10.06f, 21.794f, 9.726f, 21.478f, 9.55f)
            lineTo(19.927f, 8.687f)
            curveTo(19.611f, 8.512f, 19.348f, 8.253f, 19.167f, 7.94f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun SettingsPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Settings, contentDescription = null)
    }
}
