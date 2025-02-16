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

public val SpeechIcons.Actions.Copy: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Copy",
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
            moveTo(18.154f, 7f)
            horizontalLineTo(9.846f)
            curveTo(8.827f, 7f, 8f, 7.964f, 8f, 9.154f)
            verticalLineTo(18.846f)
            curveTo(8f, 20.036f, 8.827f, 21f, 9.846f, 21f)
            horizontalLineTo(18.154f)
            curveTo(19.173f, 21f, 20f, 20.036f, 20f, 18.846f)
            verticalLineTo(9.154f)
            curveTo(20f, 7.964f, 19.173f, 7f, 18.154f, 7f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(4f, 14f)
            verticalLineTo(5f)
            curveTo(4f, 4.47f, 4.211f, 3.961f, 4.586f, 3.586f)
            curveTo(4.961f, 3.211f, 5.47f, 3f, 6f, 3f)
            horizontalLineTo(15f)
        }
    }.build()
}

@Preview
@Composable
private fun CopyPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Copy, contentDescription = null)
    }
}
