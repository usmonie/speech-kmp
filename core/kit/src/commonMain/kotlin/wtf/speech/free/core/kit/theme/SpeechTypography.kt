package wtf.speech.free.core.kit.theme

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
public data class SpeechTypography(
    public val title: TextStyle,
    public val headline: TextStyle,
    public val body1: TextStyle,
    public val body2: TextStyle,
    public val body3: TextStyle,
    public val body4: TextStyle,
    public val body5: TextStyle,
    public val button1: TextStyle,
    public val button2: TextStyle,
    public val label1: TextStyle,
    public val label2: TextStyle,
) {

    public constructor(
        fontFamily: FontFamily,
        title: TextStyle = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 24.sp,
        ),
        headline: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 20.sp,
        ),
        body1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 20.sp,
        ),
        body2: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 18.sp,
        ),
        body3: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 18.sp,
        ),
        body4: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp,
        ),
        body5: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp,
        ),
        button1: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 18.sp,
        ),
        button2: TextStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp,
        ),
        label1: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 18.sp,
        ),
        label2: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            lineHeight = 14.sp,
        ),
    ) : this(
        title = title.withDefaultFontFamily(fontFamily),
        headline = headline.withDefaultFontFamily(fontFamily),
        body1 = body1.withDefaultFontFamily(fontFamily),
        body2 = body2.withDefaultFontFamily(fontFamily),
        body3 = body3.withDefaultFontFamily(fontFamily),
        body4 = body4.withDefaultFontFamily(fontFamily),
        body5 = body5.withDefaultFontFamily(fontFamily),
        button1 = button1.withDefaultFontFamily(fontFamily),
        button2 = button2.withDefaultFontFamily(fontFamily),
        label1 = label1.withDefaultFontFamily(fontFamily),
        label2 = label2.withDefaultFontFamily(fontFamily),
    )
}

/**
 * @return [this] if there is a [FontFamily] defined, otherwise copies [this] with [default] as the
 *   [FontFamily].
 */
private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}

internal val defaultFontFamily = FontFamily.Default

/**
 * This CompositionLocal holds on to the current definition of typography for this application as
 * described by the Material spec. You can read the values in it when creating custom components
 * that want to use Material types, as well as override the values when you want to re-style a part
 * of your hierarchy. Material components related to text such as [Button] will use this
 * CompositionLocal to set values with which to style children text components.
 *
 * To access values within this CompositionLocal, use [MaterialTheme.typography].
 */
internal val LocalSpeechTypography = staticCompositionLocalOf { SpeechTypography(defaultFontFamily) }