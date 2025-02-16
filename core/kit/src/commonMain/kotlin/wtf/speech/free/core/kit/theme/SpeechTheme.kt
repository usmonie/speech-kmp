package wtf.speech.free.core.kit.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Shapes
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

public object SpeechTheme {
    public val typography: SpeechTypography
        @Composable @ReadOnlyComposable get() = LocalSpeechTypography.current

    public val colors: SpeechColors
        @Composable @ReadOnlyComposable get() = LocalSpeechColors.current

    public val shapes: Shapes
        @Composable @ReadOnlyComposable get() = LocalShapes.current
}

@Composable
public fun SpeechTheme(
    colors: SpeechColors = SpeechTheme.colors,
    typography: SpeechTypography = SpeechTheme.typography,
    shapes: Shapes = SpeechTheme.shapes,
    content: @Composable () -> Unit
) {
    val rememberedColors =
        remember {
            // Explicitly creating a new object here so we don't mutate the initial [colors]
            // provided, and overwrite the values set in it.
            colors.copy()
        }
            .apply { updateColorsFrom(colors) }
    val rippleIndication = ripple()
    val selectionColors = rememberTextSelectionColors(rememberedColors)
    CompositionLocalProvider(
        LocalSpeechColors provides rememberedColors,
        LocalContentAlpha provides ContentAlpha.high,
        LocalIndication provides rippleIndication,
        LocalShapes provides shapes,
        LocalTextSelectionColors provides selectionColors,
        LocalSpeechTypography provides typography
    ) {
        ProvideTextStyle(value = typography.body1) { content() }
    }
}

/** CompositionLocal used to specify the default shapes for the surfaces. */
internal val LocalShapes = staticCompositionLocalOf {
    Shapes(
        large = RoundedCornerShape(12.dp),
        medium = RoundedCornerShape(12.dp),
        small = RoundedCornerShape(8.dp),
    )
}