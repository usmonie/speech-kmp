package wtf.speech.free.core.kit.theme

import androidx.compose.material.Button
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
public data class SpeechColors(
    public var background: Color,
    public var onBackground: Color,
    public var textPrimary: Color,
    public var textSecondary: Color,
    public var interactivePrimary: Color,
    public var onInteractivePrimary: Color,
    public var interactiveSecondary: Color,
    public var onInteractiveSecondary: Color,
    public var interactiveTertiary: Color,
    public var onInteractiveTertiary: Color,
    public var interactiveQuaternary: Color,
    public var onInteractiveQuaternary: Color,
    public var error: Color,
    public var onError: Color,
    public var separator: Color,
)

public object Colors {
    public val White: Color = Color(0xFFFFFFFF)
    public val BlackPearl: Color = Color(0xFF00060A)
    public val BluePearl: Color = Color(0xFF011627)
    public val MidGrey: Color = Color(0xFF5C6A75)
    public val Heather: Color = Color(0xFFAEB4BA)
    public val AliceBlue: Color = Color(0xFFEBEDEE)
    public val AliceBlueLight: Color = Color(0xFFF5F6F7)
    public val BlueWhale: Color = Color(0xFF1F3241)
    public val Mahogany: Color = Color(0xFFCC2936)
    public val MediumStateBlue: Color = Color(0xFF7662F5)
    public val MediumStateBlueHalf: Color = Color(0x807662F5)
}

public val LightSpeechColors: SpeechColors = SpeechColors(
    background = Colors.White,
    onBackground = Colors.BluePearl,
    textPrimary = Colors.BluePearl,
    textSecondary = Colors.MidGrey,
    interactivePrimary = Colors.MediumStateBlue,
    onInteractivePrimary = Colors.White,
    interactiveSecondary = Colors.AliceBlueLight,
    onInteractiveSecondary = Colors.BlueWhale,
    interactiveTertiary = Colors.BlueWhale,
    onInteractiveTertiary = Colors.White,
    interactiveQuaternary = Colors.MidGrey,
    onInteractiveQuaternary = Colors.White,
    error = Colors.Mahogany,
    onError = Colors.White,
    separator = Colors.AliceBlue,
)

public val DarkSpeechColors: SpeechColors = SpeechColors(
    background = Colors.BlackPearl,
    onBackground = Colors.White,
    textPrimary = Colors.White,
    textSecondary = Colors.Heather,
    interactivePrimary = Colors.MediumStateBlue,
    onInteractivePrimary = Colors.White,
    interactiveSecondary = Colors.BluePearl,
    onInteractiveSecondary = Colors.White,
    interactiveTertiary = Colors.White,
    onInteractiveTertiary = Colors.BlueWhale,
    interactiveQuaternary = Colors.MidGrey,
    onInteractiveQuaternary = Colors.White,
    error = Colors.Mahogany,
    onError = Colors.White,
    separator = Colors.BlueWhale,
)

/**
 * Updates the internal values of the given [Colors] with values from the [other] [Colors]. This
 * allows efficiently updating a subset of [Colors], without recomposing every composable that
 * consumes values from [LocalColors].
 *
 * Because [Colors] is very wide-reaching, and used by many expensive composables in the hierarchy,
 * providing a new value to [LocalColors] causes every composable consuming [LocalColors] to
 * recompose, which is prohibitively expensive in cases such as animating one color in the theme.
 * Instead, [Colors] is internally backed by [mutableStateOf], and this function mutates the
 * internal state of [this] to match values in [other]. This means that any changes will mutate the
 * internal state of [this], and only cause composables that are reading the specific changed value
 * to recompose.
 */
internal fun SpeechColors.updateColorsFrom(other: SpeechColors) {
    textPrimary = other.textPrimary
    textSecondary = other.textSecondary

    interactivePrimary = other.interactivePrimary
    interactiveSecondary = other.interactiveSecondary
    interactiveTertiary = other.interactiveTertiary
    interactiveQuaternary = other.interactiveQuaternary

    error = other.error
    background = other.background
    separator = other.separator
}

/**
 * This CompositionLocal holds on to the current definition of typography for this application as
 * described by the Speech spec. You can read the values in it when creating custom components
 * that want to use Speech types, as well as override the values when you want to re-style a part
 * of your hierarchy. Speech components related to text such as [Button] will use this
 * CompositionLocal to set values with which to style children text components.
 *
 * To access values within this CompositionLocal, use [SpeechTheme.typography].
 */
internal val LocalSpeechColors = staticCompositionLocalOf { LightSpeechColors }
