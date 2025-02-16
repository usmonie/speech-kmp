package wtf.speech.free.core.kit.icons.statuses

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

public val SpeechIcons.Statuses.SecretBlab: ImageVector by lazy(LazyThreadSafetyMode.NONE) {
    ImageVector.Builder(
        name = "Statuses.SecretBlab",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f,
    ).apply {
        path(
            stroke = SolidColor(Color(0xFF7662F5)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(12.667f, 2f)
            horizontalLineTo(3.333f)
            curveTo(2.965f, 2f, 2.667f, 2.298f, 2.667f, 2.667f)
            verticalLineTo(6.777f)
            curveTo(2.667f, 11.698f, 6.85f, 13.568f, 7.807f, 13.931f)
            curveTo(7.933f, 13.979f, 8.067f, 13.979f, 8.194f, 13.931f)
            curveTo(9.151f, 13.568f, 13.333f, 11.698f, 13.333f, 6.777f)
            verticalLineTo(2.667f)
            curveTo(13.333f, 2.298f, 13.035f, 2f, 12.667f, 2f)
            close()
        }
        path(
            stroke = SolidColor(Color(0xFF7662F5)),
            strokeLineWidth = 1.5f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round,
        ) {
            moveTo(10f, 6f)
            lineTo(7.333f, 8.667f)
            lineTo(6f, 7.333f)
        }
    }.build()
}

@Preview
@Composable
private fun SecretBlabPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = SpeechIcons.Statuses.SecretBlab, contentDescription = null)
    }
}
