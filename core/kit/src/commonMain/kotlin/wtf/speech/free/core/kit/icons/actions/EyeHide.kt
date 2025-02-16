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

public val SpeechIcons.Actions.EyeHide: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.EyeHide",
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
            moveTo(4f, 4f)
            lineTo(20f, 20f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(16.5f, 16.756f)
            curveTo(15.147f, 17.485f, 13.619f, 18f, 12f, 18f)
            curveTo(6.477f, 18f, 2f, 12f, 2f, 12f)
            curveTo(2f, 12f, 4.088f, 9.201f, 7.172f, 7.427f)
            moveTo(19.5f, 14.634f)
            curveTo(21.056f, 13.265f, 22f, 12f, 22f, 12f)
            curveTo(22f, 12f, 17.523f, 6f, 12f, 6f)
            curveTo(11.663f, 6f, 11.329f, 6.022f, 11f, 6.064f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(13.323f, 13.5f)
            curveTo(12.97f, 13.811f, 12.507f, 14f, 12f, 14f)
            curveTo(10.895f, 14f, 10f, 13.104f, 10f, 12f)
            curveTo(10f, 11.46f, 10.214f, 10.971f, 10.561f, 10.611f)
        }
    }.build()
}

@Preview
@Composable
private fun EyeHidePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.EyeHide, contentDescription = null)
    }
}
