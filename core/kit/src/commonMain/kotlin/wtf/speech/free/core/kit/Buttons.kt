package wtf.speech.free.core.kit

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.icons.SpeechIcons
import wtf.speech.free.core.kit.icons.actions.Heart
import wtf.speech.free.core.kit.theme.SpeechTheme

/**
 * Button variants based on the Speech design system
 */
public enum class SpeechButtonVariant {
    Primary,    // Filled purple button
    Secondary,  // Light background with dark text
    Tertiary,   // Dark background with white text
    Ghost,      // Transparent with purple text
    Icon,       // Icon button
}

/**
 * Button sizes following the Speech design system
 */
public enum class SpeechButtonSize {
    Large,      // Full width buttons
    Medium,     // Standard size buttons
    Small,      // Compact buttons
    Icon        // Icon-only circular buttons
}

/**
 * Data class holding the button configuration
 */
public data class SpeechButtonConfig(
    public val variant: SpeechButtonVariant = SpeechButtonVariant.Primary,
    public val size: SpeechButtonSize = SpeechButtonSize.Medium,
    public val contentPadding: PaddingValues = when (size) {
        SpeechButtonSize.Large -> PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        SpeechButtonSize.Medium -> PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        SpeechButtonSize.Small -> PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        SpeechButtonSize.Icon -> PaddingValues(8.dp)
    },
)

public data class SpeechButtonColors(
    public val background: Color,
    public val content: Color,
    public val pressedBackground: Color,
    public val pressedContent: Color,
    public val disabledBackground: Color,
    public val disabledContent: Color,
) {
    public companion object {
        @Composable
        public fun primary(
            background: Color = SpeechTheme.colors.interactivePrimary,
            content: Color = SpeechTheme.colors.onInteractivePrimary,
            pressedBackground: Color = SpeechTheme.colors.interactivePrimary.copy(alpha = 0.8f),
            pressedContent: Color = SpeechTheme.colors.onInteractivePrimary,
            disabledBackground: Color = SpeechTheme.colors.interactivePrimary.copy(alpha = 0.5f),
            disabledContent: Color = SpeechTheme.colors.onInteractivePrimary.copy(alpha = 0.5f)
        ): SpeechButtonColors {
            return SpeechButtonColors(
                background = background,
                content = content,
                pressedBackground = pressedBackground,
                pressedContent = pressedContent,
                disabledBackground = disabledBackground,
                disabledContent = disabledContent,
            )
        }

        @Composable
        public fun secondary(
            background: Color = SpeechTheme.colors.interactiveSecondary,
            content: Color = SpeechTheme.colors.onInteractiveSecondary,
            pressedBackground: Color = SpeechTheme.colors.interactiveSecondary.copy(alpha = 0.8f),
            pressedContent: Color = SpeechTheme.colors.onInteractiveSecondary,
            disabledBackground: Color = SpeechTheme.colors.interactiveSecondary.copy(alpha = 0.5f),
            disabledContent: Color = SpeechTheme.colors.onInteractiveSecondary.copy(alpha = 0.5f)
        ): SpeechButtonColors {
            return SpeechButtonColors(
                background = background,
                content = content,
                pressedBackground = pressedBackground,
                pressedContent = pressedContent,
                disabledBackground = disabledBackground,
                disabledContent = disabledContent,
            )
        }

        @Composable
        public fun tertiary(
            background: Color = SpeechTheme.colors.interactiveTertiary,
            content: Color = SpeechTheme.colors.onInteractiveTertiary,
            pressedBackground: Color = SpeechTheme.colors.interactiveTertiary.copy(alpha = 0.8f),
            pressedContent: Color = SpeechTheme.colors.onInteractiveTertiary,
            disabledBackground: Color = SpeechTheme.colors.interactiveTertiary.copy(alpha = 0.5f),
            disabledContent: Color = SpeechTheme.colors.onInteractiveTertiary.copy(alpha = 0.5f)
        ): SpeechButtonColors {
            return SpeechButtonColors(
                background = background,
                content = content,
                pressedBackground = pressedBackground,
                pressedContent = pressedContent,
                disabledBackground = disabledBackground,
                disabledContent = disabledContent,
            )
        }

        @Composable
        public fun ghost(
            background: Color = Color.Transparent,
            content: Color = SpeechTheme.colors.interactivePrimary,
            pressedBackground: Color = SpeechTheme.colors.interactivePrimary.copy(alpha = 0.1f),
            pressedContent: Color = SpeechTheme.colors.interactivePrimary,
            disabledBackground: Color = Color.Transparent,
            disabledContent: Color = SpeechTheme.colors.interactiveQuaternary
        ): SpeechButtonColors {
            return SpeechButtonColors(
                background = background,
                content = content,
                pressedBackground = pressedBackground,
                pressedContent = pressedContent,
                disabledBackground = disabledBackground,
                disabledContent = disabledContent,
            )
        }

        @Composable
        public fun icon(
            background: Color = SpeechTheme.colors.interactiveSecondary,
            content: Color = SpeechTheme.colors.onInteractiveSecondary,
            pressedBackground: Color = SpeechTheme.colors.interactivePrimary.copy(alpha = 0.1f),
            pressedContent: Color = SpeechTheme.colors.interactivePrimary,
            disabledBackground: Color = SpeechTheme.colors.interactiveTertiary.copy(alpha = 0.5f),
            disabledContent: Color = SpeechTheme.colors.interactiveTertiary.copy(alpha = 0.5f)
        ): SpeechButtonColors {
            return SpeechButtonColors(
                background = background,
                content = content,
                pressedBackground = pressedBackground,
                pressedContent = pressedContent,
                disabledBackground = disabledBackground,
                disabledContent = disabledContent,
            )
        }
    }

    public fun resolveColors(enabled: Boolean, pressed: Boolean): Pair<Color, Color> {
        return when {
            !enabled -> disabledBackground to disabledContent
            pressed -> pressedBackground to pressedContent
            else -> background to content
        }
    }
}

@Composable
public fun SpeechButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: SpeechButtonColors = SpeechButtonColors.primary(),
    size: SpeechButtonSize = SpeechButtonSize.Medium,
    contentPadding: PaddingValues = when (size) {
        SpeechButtonSize.Large -> PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        SpeechButtonSize.Medium -> PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        SpeechButtonSize.Small -> PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        SpeechButtonSize.Icon -> PaddingValues(8.dp)
    },
    shape: Shape = when (size) {
        SpeechButtonSize.Icon -> SpeechTheme.shapes.small
        else -> SpeechTheme.shapes.medium
    },
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val (backgroundColor, contentColor) = colors.resolveColors(enabled, isPressed)
    val typography = SpeechTheme.typography

    // Animation states
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.98f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Box(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
            .clickable(
                enabled = enabled && !loading,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(contentPadding)
            .scale(scale),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (loading) {
                LoadingIndicator(
                    color = contentColor,
                    size = when (size) {
                        SpeechButtonSize.Large, SpeechButtonSize.Medium -> 20.dp
                        else -> 16.dp
                    }
                )
            } else {
                CompositionLocalProvider(
                    LocalContentColor provides contentColor,
                    LocalTextStyle provides when (size) {
                        SpeechButtonSize.Large, SpeechButtonSize.Medium -> typography.button1
                        else -> typography.button2
                    }
                ) {
                    content()
                }
            }
        }
    }
}

@Composable
private fun LoadingIndicator(
    color: Color = LocalContentColor.current,
    size: Dp,
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier.size(size),
        color = color,
        strokeWidth = 2.dp
    )
}

// Preset configurations
public object SpeechButtonPresets {
    public val primaryLarge: SpeechButtonConfig = SpeechButtonConfig(
        variant = SpeechButtonVariant.Primary,
        size = SpeechButtonSize.Large
    )

    public val secondaryMedium: SpeechButtonConfig = SpeechButtonConfig(
        variant = SpeechButtonVariant.Secondary,
        size = SpeechButtonSize.Medium
    )

    public val tertiarySmall: SpeechButtonConfig = SpeechButtonConfig(
        variant = SpeechButtonVariant.Tertiary,
        size = SpeechButtonSize.Small
    )

    public val ghost: SpeechButtonConfig = SpeechButtonConfig(
        variant = SpeechButtonVariant.Ghost,
        size = SpeechButtonSize.Medium
    )

    public val ghostIcon: SpeechButtonConfig = SpeechButtonConfig(
        variant = SpeechButtonVariant.Ghost,
        size = SpeechButtonSize.Icon
    )

    public val icon: SpeechButtonConfig = SpeechButtonConfig(
        variant = SpeechButtonVariant.Icon,
        size = SpeechButtonSize.Icon
    )
}

@Composable
public fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: SpeechButtonColors = SpeechButtonColors.primary(),
    size: SpeechButtonSize = SpeechButtonSize.Medium,
    contentPadding: PaddingValues = when (size) {
        SpeechButtonSize.Large -> PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        SpeechButtonSize.Medium -> PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        SpeechButtonSize.Small -> PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        SpeechButtonSize.Icon -> PaddingValues(8.dp)
    },
    shape: Shape = when (size) {
        SpeechButtonSize.Icon -> SpeechTheme.shapes.small
        else -> SpeechTheme.shapes.medium
    },
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.(String) -> Unit = {
        Text(it)
    }
) {
    SpeechButton(
        onClick,
        modifier,
        colors,
        size,
        contentPadding,
        shape,
        enabled,
        loading,
        interactionSource,
    ) {
        content(text)
    }
}

@Composable
public fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: SpeechButtonColors = SpeechButtonColors.secondary(),
    size: SpeechButtonSize = SpeechButtonSize.Medium,
    contentPadding: PaddingValues = when (size) {
        SpeechButtonSize.Large -> PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        SpeechButtonSize.Medium -> PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        SpeechButtonSize.Small -> PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        SpeechButtonSize.Icon -> PaddingValues(8.dp)
    },
    shape: Shape = when (size) {
        SpeechButtonSize.Icon -> SpeechTheme.shapes.small
        else -> SpeechTheme.shapes.medium
    },
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.(String) -> Unit = {
        Text(it)
    }
) {
    SpeechButton(
        onClick,
        modifier,
        colors,
        size,
        contentPadding,
        shape,
        enabled,
        loading,
        interactionSource,
    ) {
        content(text)
    }
}

@Composable
public fun GhostButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: SpeechButtonColors = SpeechButtonColors.ghost(),
    size: SpeechButtonSize = SpeechButtonSize.Medium,
    contentPadding: PaddingValues = PaddingValues(),
    shape: Shape = when (size) {
        SpeechButtonSize.Icon -> SpeechTheme.shapes.small
        else -> SpeechTheme.shapes.medium
    },
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.(String) -> Unit = {
        Text(it)
    }
) {
    SpeechButton(
        onClick,
        modifier,
        colors,
        size,
        contentPadding,
        shape,
        enabled,
        loading,
        interactionSource,
    ) {
        content(text)
    }
}

@Composable
public fun SpeechIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: SpeechButtonColors = SpeechButtonColors.icon(),
    size: SpeechButtonSize = SpeechButtonSize.Icon,
    contentPadding: PaddingValues = when (size) {
        SpeechButtonSize.Large -> PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        SpeechButtonSize.Medium -> PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        SpeechButtonSize.Small -> PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        SpeechButtonSize.Icon -> PaddingValues(8.dp)
    },
    shape: Shape = when (size) {
        SpeechButtonSize.Icon -> SpeechTheme.shapes.small
        else -> SpeechTheme.shapes.medium
    },
    enabled: Boolean = true,
    loading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.(ImageVector) -> Unit = {
        Icon(
            imageVector = it,
            contentDescription = it.name,
            tint = LocalContentColor.current,
        )
    }
) {
    SpeechButton(
        onClick,
        modifier,
        colors,
        size,
        contentPadding,
        shape,
        enabled,
        loading,
        interactionSource,
    ) {
        content(icon)
    }
}

// Example Usage
@Preview()
@Composable
public fun ButtonExample() {
    SpeechTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            PrimaryButton("Primary Button", {})
            SecondaryButton("Secondary Button", {})
            GhostButton("Ghost Button", {})
            SpeechIconButton(SpeechIcons.Actions.Heart, {})
        }
    }
}