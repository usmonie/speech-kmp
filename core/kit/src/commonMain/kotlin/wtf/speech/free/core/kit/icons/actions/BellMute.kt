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
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.icons.SpeechIcons

public val SpeechIcons.Actions.BellMute: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.BellMute",
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
            pathFillType = PathFillType.EvenOdd,
        ) {
            moveTo(15f, 17f)
            horizontalLineTo(9f)
            verticalLineTo(18f)
            curveTo(9f, 19.657f, 10.343f, 21f, 12f, 21f)
            curveTo(13.657f, 21f, 15f, 19.657f, 15f, 18f)
            verticalLineTo(17f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(19f, 17f)
            horizontalLineTo(5f)
            curveTo(4.487f, 17f, 4.064f, 16.614f, 4.007f, 16.117f)
            lineTo(4f, 16f)
            verticalLineTo(15.414f)
            curveTo(4f, 15.149f, 4.105f, 14.895f, 4.293f, 14.707f)
            lineTo(4.804f, 14.196f)
            curveTo(4.929f, 14.071f, 5f, 13.9f, 5f, 13.722f)
            verticalLineTo(10f)
            curveTo(5f, 8.158f, 5.711f, 6.483f, 6.874f, 5.233f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(5f, 3f)
            lineTo(21f, 19f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(18.999f, 12.999f)
            lineTo(19f, 10f)
            curveTo(19f, 6.134f, 15.866f, 3f, 12f, 3f)
            lineTo(11.759f, 3.004f)
            curveTo(10.955f, 3.031f, 10.184f, 3.194f, 9.47f, 3.471f)
        }
    }.build()
}

@Preview
@Composable
private fun BellMutePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.BellMute, contentDescription = null)
    }
}
