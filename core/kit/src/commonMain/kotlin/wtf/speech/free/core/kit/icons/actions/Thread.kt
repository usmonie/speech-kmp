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

public val SpeechIcons.Actions.Thread: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Thread",
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
            moveTo(15f, 19f)
            curveTo(15f, 17.343f, 13.657f, 16f, 12f, 16f)
            curveTo(10.343f, 16f, 9f, 17.343f, 9f, 19f)
            curveTo(9f, 20.657f, 10.343f, 22f, 12f, 22f)
            curveTo(13.657f, 22f, 15f, 20.657f, 15f, 19f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(15f, 5f)
            curveTo(15f, 3.343f, 13.657f, 2f, 12f, 2f)
            curveTo(10.343f, 2f, 9f, 3.343f, 9f, 5f)
            curveTo(9f, 6.657f, 10.343f, 8f, 12f, 8f)
            curveTo(13.657f, 8f, 15f, 6.657f, 15f, 5f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(12f, 9f)
            lineTo(12f, 12f)
            lineTo(12f, 15f)
        }
    }.build()
}

@Preview
@Composable
private fun ThreadPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Thread, contentDescription = null)
    }
}
