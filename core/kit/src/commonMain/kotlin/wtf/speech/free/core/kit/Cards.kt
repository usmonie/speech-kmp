package wtf.speech.free.core.kit

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import wtf.speech.free.core.kit.theme.SpeechTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
@NonRestartableComposable
public fun FlatCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = SpeechTheme.shapes.medium,
    backgroundColor: Color = SpeechTheme.colors.interactiveSecondary,
    contentColor: Color = SpeechTheme.colors.onInteractiveSecondary,
    border: BorderStroke? = null,
    content: @Composable () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
        elevation = 0.dp,
        border = border,
        content = content
    )
}