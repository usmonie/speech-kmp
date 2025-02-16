package wtf.speech.free.core.kit.icons.statuses

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

public val SpeechIcons.Statuses.BellMute: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Statuses.BellMute",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f,
    ).apply {
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
            pathFillType = PathFillType.EvenOdd,
        ) {
            moveTo(10f, 11.333f)
            horizontalLineTo(6f)
            verticalLineTo(12f)
            curveTo(6f, 13.105f, 6.895f, 14f, 8f, 14f)
            curveTo(9.105f, 14f, 10f, 13.105f, 10f, 12f)
            verticalLineTo(11.333f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(12.667f, 11.333f)
            horizontalLineTo(3.333f)
            curveTo(2.992f, 11.333f, 2.71f, 11.076f, 2.671f, 10.744f)
            lineTo(2.667f, 10.667f)
            verticalLineTo(10.276f)
            curveTo(2.667f, 10.099f, 2.737f, 9.93f, 2.862f, 9.805f)
            lineTo(3.203f, 9.464f)
            curveTo(3.286f, 9.38f, 3.333f, 9.267f, 3.333f, 9.148f)
            verticalLineTo(6.667f)
            curveTo(3.333f, 5.439f, 3.808f, 4.322f, 4.583f, 3.489f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(3.333f, 2f)
            lineTo(14f, 12.5f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(12.667f, 7.438f)
            verticalLineTo(6.667f)
            curveTo(12.667f, 4.089f, 10.577f, 2f, 8f, 2f)
            lineTo(7.84f, 2.003f)
        }
    }.build()
}

@Preview
@Composable
private fun BellMutePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Statuses.BellMute, contentDescription = null)
    }
}
