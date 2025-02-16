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

public val SpeechIcons.Actions.Media: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Media",
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
            moveTo(4.536f, 11.465f)
            lineTo(11.43f, 4.57f)
            curveTo(13.48f, 2.52f, 16.804f, 2.52f, 18.855f, 4.57f)
            curveTo(20.905f, 6.62f, 20.905f, 9.945f, 18.855f, 11.995f)
            lineTo(10.9f, 19.95f)
            curveTo(9.533f, 21.317f, 7.317f, 21.317f, 5.95f, 19.95f)
            curveTo(4.583f, 18.583f, 4.583f, 16.367f, 5.95f, 15f)
            lineTo(13.905f, 7.045f)
            curveTo(14.588f, 6.362f, 15.696f, 6.362f, 16.38f, 7.045f)
            curveTo(17.063f, 7.728f, 17.063f, 8.836f, 16.38f, 9.52f)
            lineTo(9.485f, 16.414f)
        }
    }.build()
}

@Preview
@Composable
private fun MediaPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Media, contentDescription = null)
    }
}
