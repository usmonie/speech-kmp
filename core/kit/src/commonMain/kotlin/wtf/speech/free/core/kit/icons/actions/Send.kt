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

public val SpeechIcons.Actions.Send: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Send",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(5.214f, 4.107f)
            lineTo(19.211f, 11.106f)
            curveTo(19.948f, 11.474f, 19.948f, 12.526f, 19.211f, 12.894f)
            lineTo(5.214f, 19.893f)
            curveTo(4.41f, 20.295f, 3.525f, 19.514f, 3.824f, 18.666f)
            lineTo(6.059f, 12.333f)
            curveTo(6.135f, 12.118f, 6.135f, 11.882f, 6.059f, 11.667f)
            lineTo(3.824f, 5.334f)
            curveTo(3.525f, 4.486f, 4.41f, 3.705f, 5.214f, 4.107f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(7f, 12f)
            horizontalLineTo(9f)
        }
    }.build()
}

@Preview
@Composable
private fun SendPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Send, contentDescription = null)
    }
}
