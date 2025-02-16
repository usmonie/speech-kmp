package wtf.speech.free.core.kit.icons.actions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.icons.SpeechIcons

public val SpeechIcons.Actions.StoryCircle: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.StoryCircle",
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
            moveTo(12f, 8f)
            lineTo(12f, 16f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
        ) {
            moveTo(8f, 12f)
            lineTo(16f, 12f)
        }
        path(
            fill = SolidColor(Color(0xFF1F3241)),
            pathFillType = PathFillType.EvenOdd,
        ) {
            moveTo(10.199f, 1.144f)
            curveTo(9.598f, 1.242f, 9.249f, 1.852f, 9.407f, 2.441f)
            curveTo(9.565f, 3.029f, 10.169f, 3.37f, 10.772f, 3.287f)
            curveTo(11.574f, 3.177f, 12.39f, 3.177f, 13.195f, 3.29f)
            curveTo(14.365f, 3.453f, 15.491f, 3.85f, 16.504f, 4.457f)
            curveTo(17.518f, 5.064f, 18.4f, 5.868f, 19.097f, 6.822f)
            curveTo(19.794f, 7.776f, 20.292f, 8.861f, 20.562f, 10.011f)
            curveTo(20.832f, 11.161f, 20.868f, 12.354f, 20.668f, 13.519f)
            curveTo(20.468f, 14.683f, 20.035f, 15.796f, 19.397f, 16.79f)
            curveTo(18.759f, 17.784f, 17.927f, 18.64f, 16.952f, 19.307f)
            curveTo(16.28f, 19.766f, 15.55f, 20.128f, 14.783f, 20.386f)
            curveTo(14.205f, 20.58f, 13.816f, 21.155f, 13.936f, 21.752f)
            curveTo(14.057f, 22.349f, 14.64f, 22.74f, 15.222f, 22.561f)
            curveTo(16.278f, 22.236f, 17.281f, 21.753f, 18.196f, 21.127f)
            curveTo(19.415f, 20.294f, 20.455f, 19.224f, 21.253f, 17.981f)
            curveTo(22.051f, 16.738f, 22.591f, 15.348f, 22.841f, 13.892f)
            curveTo(23.091f, 12.436f, 23.046f, 10.945f, 22.709f, 9.507f)
            curveTo(22.372f, 8.069f, 21.749f, 6.714f, 20.878f, 5.521f)
            curveTo(20.006f, 4.329f, 18.904f, 3.323f, 17.637f, 2.565f)
            curveTo(16.369f, 1.806f, 14.963f, 1.31f, 13.5f, 1.106f)
            curveTo(12.402f, 0.953f, 11.289f, 0.966f, 10.199f, 1.144f)
            close()
            moveTo(10.874f, 22.995f)
            curveTo(11.48f, 23.056f, 11.975f, 22.556f, 11.975f, 21.948f)
            curveTo(11.975f, 21.339f, 11.479f, 20.852f, 10.875f, 20.776f)
            curveTo(10.095f, 20.678f, 9.329f, 20.476f, 8.6f, 20.174f)
            curveTo(7.53f, 19.73f, 6.557f, 19.081f, 5.738f, 18.262f)
            curveTo(4.919f, 17.443f, 4.27f, 16.47f, 3.826f, 15.4f)
            curveTo(3.524f, 14.671f, 3.322f, 13.905f, 3.224f, 13.125f)
            curveTo(3.148f, 12.521f, 2.661f, 12.025f, 2.052f, 12.025f)
            curveTo(1.444f, 12.025f, 0.944f, 12.52f, 1.005f, 13.126f)
            curveTo(1.112f, 14.196f, 1.376f, 15.247f, 1.789f, 16.244f)
            curveTo(2.343f, 17.582f, 3.155f, 18.797f, 4.179f, 19.821f)
            curveTo(5.203f, 20.845f, 6.418f, 21.657f, 7.756f, 22.211f)
            curveTo(8.753f, 22.624f, 9.804f, 22.888f, 10.874f, 22.995f)
            close()
            moveTo(2.157f, 10.588f)
            curveTo(1.554f, 10.5f, 1.132f, 9.938f, 1.28f, 9.347f)
            curveTo(1.664f, 7.814f, 2.373f, 6.382f, 3.358f, 5.147f)
            curveTo(3.738f, 4.671f, 4.441f, 4.666f, 4.877f, 5.092f)
            curveTo(5.312f, 5.517f, 5.314f, 6.212f, 4.946f, 6.697f)
            curveTo(4.272f, 7.586f, 3.773f, 8.595f, 3.475f, 9.67f)
            curveTo(3.313f, 10.256f, 2.759f, 10.676f, 2.157f, 10.588f)
            close()
            moveTo(6.275f, 2.588f)
            curveTo(5.754f, 2.903f, 5.657f, 3.599f, 6.023f, 4.086f)
            curveTo(6.388f, 4.573f, 7.081f, 4.662f, 7.61f, 4.361f)
            curveTo(8.139f, 4.059f, 8.416f, 3.418f, 8.184f, 2.855f)
            curveTo(7.951f, 2.293f, 7.303f, 2.02f, 6.766f, 2.308f)
            curveTo(6.6f, 2.397f, 6.436f, 2.49f, 6.275f, 2.588f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun StoryCirclePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.StoryCircle, contentDescription = null)
    }
}
