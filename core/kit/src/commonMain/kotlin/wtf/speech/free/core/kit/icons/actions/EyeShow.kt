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

public val SpeechIcons.Actions.EyeShow: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.EyeShow",
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
            moveTo(12f, 18f)
            curveTo(17.523f, 18f, 22f, 12f, 22f, 12f)
            curveTo(22f, 12f, 17.523f, 6f, 12f, 6f)
            curveTo(6.477f, 6f, 2f, 12f, 2f, 12f)
            curveTo(2f, 12f, 6.477f, 18f, 12f, 18f)
            close()
        }
        path(
            fill = SolidColor(Color(0xFF1F3241)),
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(12f, 14f)
            curveTo(13.105f, 14f, 14f, 13.105f, 14f, 12f)
            curveTo(14f, 10.895f, 13.105f, 10f, 12f, 10f)
            curveTo(10.895f, 10f, 10f, 10.895f, 10f, 12f)
            curveTo(10f, 13.105f, 10.895f, 14f, 12f, 14f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun EyeShowPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.EyeShow, contentDescription = null)
    }
}
