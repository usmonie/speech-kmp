package wtf.speech.free.core.kit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter.Companion.DefaultTransform
import coil3.compose.AsyncImagePainter.State
import wtf.speech.free.core.kit.theme.Colors
import kotlin.math.roundToInt

/**
 * Preset sizes for common avatar use cases
 */
public object AvatarSize {
    public val Small: Dp = 20.dp
    public val Medium: Dp = 36.dp
    public val Large: Dp = 48.dp
    public val XLarge: Dp = 84.dp
}

/**
 * Common border presets for avatars
 */
public object AvatarBorders {
    public val Thin: BorderStroke = BorderStroke(1.dp, Colors.MidGrey)
    public val Medium: BorderStroke = BorderStroke(2.dp, Colors.MidGrey)
    public val Thick: BorderStroke = BorderStroke(3.dp, Colors.MidGrey)

    public fun custom(width: Dp, color: Color): BorderStroke = BorderStroke(width, color)
}

/**
 * A customizable Avatar component that supports various sizes, shapes, and interactions.
 *
 * @param size The size of the avatar
 * @param shape The shape of the avatar (default: CircleShape)
 * @param border Optional border for the avatar
 * @param onClick Optional click handler
 */
@Composable
public fun CircleAvatar(
    size: Dp,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    border: BorderStroke? = null,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Surface(
        shape = shape,
        border = border,
        color = Color.Transparent,
        modifier = modifier
            .size(size)
            .clip(shape)
            .run {
                if (onClick != null) {
                    clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = onClick
                    )
                } else this
            },
        content = content,
    )
}

@Composable
public fun AsyncCircleAvatar(
    url: String,
    contentDescription: String,
    size: Dp,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    border: BorderStroke? = null,
    onClick: (() -> Unit)? = null,
    transform: (State) -> State = DefaultTransform,
    onState: ((State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DefaultFilterQuality,
    clipToBounds: Boolean = true,
) {
    CircleAvatar(
        modifier = modifier,
        size = size,
        border = border,
        onClick = onClick,
        content = {
            AsyncImage(
                model = url,
                contentDescription = contentDescription,
                transform = transform,
                onState = onState,
                alignment = alignment,
                contentScale = contentScale,
                alpha = alpha,
                colorFilter = colorFilter,
                filterQuality = filterQuality,
                clipToBounds = clipToBounds,
                modifier = Modifier.fillMaxSize()
            )
        }
    )
}

@Composable
public fun AsyncCircleAvatarXLarge(
    url: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    border: BorderStroke? = null,
    onClick: (() -> Unit)? = null,
    transform: (State) -> State = DefaultTransform,
    onState: ((State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DefaultFilterQuality,
    clipToBounds: Boolean = true,
) {
    AsyncCircleAvatar(
        url,
        contentDescription,
        AvatarSize.XLarge,
        modifier,
        shape,
        border,
        onClick,
        transform,
        onState,
        alignment,
        contentScale,
        alpha,
        colorFilter,
        filterQuality,
        clipToBounds
    )
}

@Composable
public fun AsyncCircleAvatarLarge(
    url: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    border: BorderStroke? = null,
    onClick: (() -> Unit)? = null,
    transform: (State) -> State = DefaultTransform,
    onState: ((State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DefaultFilterQuality,
    clipToBounds: Boolean = true,
) {
    AsyncCircleAvatar(
        url,
        contentDescription,
        AvatarSize.Large,
        modifier,
        shape,
        border,
        onClick,
        transform,
        onState,
        alignment,
        contentScale,
        alpha,
        colorFilter,
        filterQuality,
        clipToBounds
    )
}

@Composable
public fun AsyncCircleAvatarMedium(
    url: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    border: BorderStroke? = null,
    onClick: (() -> Unit)? = null,
    transform: (State) -> State = DefaultTransform,
    onState: ((State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DefaultFilterQuality,
    clipToBounds: Boolean = true,
) {
    AsyncCircleAvatar(
        url,
        contentDescription,
        AvatarSize.Medium,
        modifier,
        shape,
        border,
        onClick,
        transform,
        onState,
        alignment,
        contentScale,
        alpha,
        colorFilter,
        filterQuality,
        clipToBounds
    )
}

@Composable
public fun AsyncCircleAvatarSmall(
    url: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    border: BorderStroke? = null,
    onClick: (() -> Unit)? = null,
    transform: (State) -> State = DefaultTransform,
    onState: ((State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DefaultFilterQuality,
    clipToBounds: Boolean = true,
) {
    AsyncCircleAvatar(
        url,
        contentDescription,
        AvatarSize.Small,
        modifier,
        shape,
        border,
        onClick,
        transform,
        onState,
        alignment,
        contentScale,
        alpha,
        colorFilter,
        filterQuality,
        clipToBounds
    )
}


/**
 * A group of avatars that overlap horizontally
 * @param avatars List of avatar composables to display
 * @param size Size of each avatar
 * @param overlap How much avatars should overlap (in dp)
 * @param maxVisible Maximum number of avatars to show
 */
@Composable
public fun AsyncSmallAvatarsGroup(
    modifier: Modifier = Modifier,
    size: Dp = AvatarSize.Small,
    overlap: Dp = 12.dp,
    maxVisible: Int = Int.MAX_VALUE,
    avatars: List<String>
) {
    if (avatars.isEmpty()) return

    val visibleAvatars = avatars.take(maxVisible)
    val overlapPx = overlap.value

    Layout(
        modifier = modifier,
        content = {
            // Render avatars in reverse order for proper z-index
            visibleAvatars.asReversed().fastForEach { avatar ->
                Box(
                    modifier = Modifier
                        .size(size)
                        // Add white border around each avatar
                        .drawBehind {
                            drawCircle(
                                color = Color.White,
                                radius = size.toPx() / 2 + 2.dp.toPx()
                            )
                        }
                ) {
                    AsyncCircleAvatarSmall(avatar, avatar)
                }
            }
        }
    ) { measurables, constraints ->
        // Measure each avatar
        val placeables = measurables.fastMap { measurable ->
            measurable.measure(constraints)
        }

        // Calculate total width with overlap
        val totalWidth = if (placeables.isNotEmpty()) {
            placeables[0].width + // First avatar full width
                    ((placeables.size - 1) * (placeables[0].width - overlapPx)).roundToInt() // Remaining avatars with overlap
        } else {
            0
        }

        // Calculate height (all avatars are same size)
        val height = placeables.firstOrNull()?.height ?: 0

        // Set the final size of the layout
        layout(totalWidth, height) {
            var xPosition = 0

            // Place avatars with overlap
            placeables.fastForEach { placeable ->
                placeable.place(xPosition, 0)
                xPosition += (placeable.width - overlapPx).roundToInt()
            }
        }
    }
}