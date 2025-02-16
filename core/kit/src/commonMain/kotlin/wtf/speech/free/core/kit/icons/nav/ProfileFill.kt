package wtf.speech.free.core.kit.icons.nav

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

public val SpeechIcons.Nav.ProfileFill: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Nav.ProfileFill",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f,
    ).apply {
        path(
            fill = SolidColor(Color(0xFF1F3241)),
            stroke = SolidColor(Color(0xFF1F3241)),
            strokeLineWidth = 2f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(12f, 22f)
            curveTo(17.523f, 22f, 22f, 17.523f, 22f, 12f)
            curveTo(22f, 6.477f, 17.523f, 2f, 12f, 2f)
            curveTo(6.477f, 2f, 2f, 6.477f, 2f, 12f)
            curveTo(2f, 17.523f, 6.477f, 22f, 12f, 22f)
            close()
        }
        path(fill = SolidColor(Color(0xFFF5F6F7))) {
            moveTo(16.303f, 15.321f)
            curveTo(15.058f, 13.851f, 13.582f, 13f, 12f, 13f)
            curveTo(10.418f, 13f, 8.942f, 13.851f, 7.697f, 15.321f)
            curveTo(6.745f, 16.445f, 7.707f, 18f, 9.18f, 18f)
            horizontalLineTo(14.821f)
            curveTo(16.293f, 18f, 17.255f, 16.445f, 16.303f, 15.321f)
            close()
        }
        path(fill = SolidColor(Color(0xFFF5F6F7))) {
            moveTo(12f, 12f)
            curveTo(13.657f, 12f, 15f, 10.657f, 15f, 9f)
            curveTo(15f, 7.343f, 13.657f, 6f, 12f, 6f)
            curveTo(10.343f, 6f, 9f, 7.343f, 9f, 9f)
            curveTo(9f, 10.657f, 10.343f, 12f, 12f, 12f)
            close()
        }
    }.build()
}

@Preview
@Composable
private fun ProfileFillPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Nav.ProfileFill, contentDescription = null)
    }
}
