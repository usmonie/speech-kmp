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

public val SpeechIcons.Actions.Heart: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Heart",
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
            // Moving the heart to center of 24x24 viewport (adding 2dp on each side, 3dp top/bottom)
            moveTo(12f, 20f)
            curveTo(12f, 20f, 3f, 14.9875f, 3f, 8.97237f)
            curveTo(3f, 2.95726f, 10f, 2.456f, 12f, 7.16224f)
            curveTo(14f, 2.456f, 21f, 2.95726f, 21f, 8.97237f)
            curveTo(21f, 14.9875f, 12f, 20f, 12f, 20f)
            close()
        }
    }.build()
}

public val SpeechIcons.Actions.HeartFilled: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Heart.Filled",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFFCC2936)),
            stroke = SolidColor(Color(0xFFCC2936)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(12f, 20f)
            curveTo(12f, 20f, 3f, 14.9875f, 3f, 8.97237f)
            curveTo(3f, 2.95726f, 10f, 2.456f, 12f, 7.16224f)
            curveTo(14f, 2.456f, 21f, 2.95726f, 21f, 8.97237f)
            curveTo(21f, 14.9875f, 12f, 20f, 12f, 20f)
            close()
        }
    }.build()
}
@Preview
@Composable
private fun HeartPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Heart, contentDescription = null)
    }
}

@Preview
@Composable
private fun HeartFilledPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.HeartFilled, contentDescription = null)
    }
}
