package wtf.speech.free.core.kit.icons.actions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.icons.SpeechIcons

public val SpeechIcons.Actions.Write: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Actions.Write",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFF1F3241)),
            pathFillType = PathFillType.EvenOdd,
        ) {
            moveTo(19.06f, 3.59f)
            lineTo(20.41f, 4.94f)
            curveTo(21.2f, 5.72f, 21.2f, 6.99f, 20.41f, 7.77f)
            lineTo(7.18f, 21f)
            horizontalLineTo(3f)
            verticalLineTo(16.82f)
            lineTo(13.4f, 6.41f)
            lineTo(16.23f, 3.59f)
            curveTo(17.01f, 2.81f, 18.28f, 2.81f, 19.06f, 3.59f)
            close()
            moveTo(5f, 19f)
            lineTo(6.41f, 19.06f)
            lineTo(16.23f, 9.23f)
            lineTo(14.82f, 7.82f)
            lineTo(5f, 17.64f)
            verticalLineTo(19f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun WritePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Actions.Write, contentDescription = null)
    }
}
