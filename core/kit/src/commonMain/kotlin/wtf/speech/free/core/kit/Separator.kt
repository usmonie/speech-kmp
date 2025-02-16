package wtf.speech.free.core.kit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import wtf.speech.free.core.kit.theme.SpeechTheme

@Composable
public fun HorizontalSeparator(
    modifier: Modifier = Modifier,
    color: Color = SpeechTheme.colors.separator,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
) {
    val indentMod =
        if (startIndent.value != 0f) {
            Modifier.padding(start = startIndent)
        } else {
            Modifier
        }
    val targetThickness =
        if (thickness == Dp.Hairline) {
            (1f / LocalDensity.current.density).dp
        } else {
            thickness
        }
    Box(modifier
        .then(indentMod)
        .fillMaxWidth()
        .height(targetThickness)
        .background(color = color))
}

@Composable
public fun VerticalSeparator(
    modifier: Modifier = Modifier,
    color: Color = SpeechTheme.colors.separator,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
) {
    val indentMod =
        if (startIndent.value != 0f) {
            Modifier.padding(start = startIndent)
        } else {
            Modifier
        }
    val targetThickness =
        if (thickness == Dp.Hairline) {
            (1f / LocalDensity.current.density).dp
        } else {
            thickness
        }
    Box(
        modifier
            .then(indentMod)
            .fillMaxHeight()
            .width(targetThickness)
            .background(color = color)
    )
}
