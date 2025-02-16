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

public val SpeechIcons.Actions.ShieldCheck: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.ShieldCheck",
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
            moveTo(19f, 3f)
            horizontalLineTo(5f)
            curveTo(4.448f, 3f, 4f, 3.448f, 4f, 4f)
            verticalLineTo(10.165f)
            curveTo(4f, 17.546f, 10.274f, 20.352f, 11.71f, 20.897f)
            curveTo(11.9f, 20.969f, 12.1f, 20.969f, 12.29f, 20.897f)
            curveTo(13.726f, 20.352f, 20f, 17.546f, 20f, 10.165f)
            verticalLineTo(4f)
            curveTo(20f, 3.448f, 19.552f, 3f, 19f, 3f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(15f, 9f)
            lineTo(11f, 13f)
            lineTo(9f, 11f)
        }
    }.build()
}

@Preview
@Composable
private fun ShieldCheckPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.ShieldCheck, contentDescription = null)
    }
}
