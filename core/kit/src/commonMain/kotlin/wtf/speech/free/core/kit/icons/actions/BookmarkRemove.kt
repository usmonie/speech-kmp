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

public val SpeechIcons.Actions.BookmarkRemove: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.BookmarkRemove",
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
            moveTo(6f, 8.783f)
            verticalLineTo(12.566f)
            verticalLineTo(16.349f)
            verticalLineTo(20.132f)
            curveTo(6f, 20.93f, 6.89f, 21.407f, 7.555f, 20.963f)
            lineTo(11.445f, 18.37f)
            curveTo(11.781f, 18.146f, 12.219f, 18.146f, 12.555f, 18.37f)
            lineTo(13.5f, 19f)
            moveTo(12f, 4f)
            horizontalLineTo(17f)
            curveTo(17.552f, 4f, 18f, 4.448f, 18f, 5f)
            verticalLineTo(12.566f)
            verticalLineTo(14.5f)
        }
        path(
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
        ) {
            moveTo(7.5f, 3.5f)
            lineTo(18f, 19.5f)
        }
    }.build()
}

@Preview
@Composable
private fun BookmarkRemovePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.BookmarkRemove, contentDescription = null)
    }
}
