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

public val SpeechIcons.Actions.Unread: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Unread",
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
            moveTo(12f, 3f)
            curveTo(10.961f, 3f, 9.963f, 3.176f, 9.035f, 3.5f)
            curveTo(5.521f, 4.726f, 3f, 8.068f, 3f, 12f)
            curveTo(3f, 13.771f, 3.512f, 15.423f, 4.395f, 16.815f)
            lineTo(3f, 21f)
            lineTo(7.185f, 19.605f)
            curveTo(8.577f, 20.488f, 10.229f, 21f, 12f, 21f)
            curveTo(16.971f, 21f, 21f, 16.971f, 21f, 12f)
            curveTo(21f, 10.16f, 20.448f, 8.449f, 19.5f, 7.023f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(20f, 5f)
            curveTo(20f, 7.209f, 18.209f, 9f, 16f, 9f)
            curveTo(13.791f, 9f, 12f, 7.209f, 12f, 5f)
            curveTo(12f, 2.791f, 13.791f, 1f, 16f, 1f)
            curveTo(18.209f, 1f, 20f, 2.791f, 20f, 5f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun UnreadPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Unread, contentDescription = null)
    }
}
