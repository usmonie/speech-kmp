package wtf.speech.free.core.kit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.icons.SpeechIcons
import wtf.speech.free.core.kit.icons.nav.Blab
import wtf.speech.free.core.kit.icons.nav.BlabFill
import wtf.speech.free.core.kit.icons.nav.Home
import wtf.speech.free.core.kit.icons.nav.HomeFill
import wtf.speech.free.core.kit.icons.nav.Profile
import wtf.speech.free.core.kit.icons.nav.ProfileFill
import wtf.speech.free.core.kit.theme.DarkSpeechColors
import wtf.speech.free.core.kit.theme.LightSpeechColors
import wtf.speech.free.core.kit.theme.SpeechTheme

public data class NavigationItem<T: NavigationBarRoute>(
    val icon: ImageVector,
    val selectedIcon: ImageVector,
    val contentDescription: String,
    val route: T
)

public interface NavigationBarRoute

@Composable
public fun <T: NavigationBarRoute> SpeechNavigationBar(
    items: List<NavigationItem<T>>,
    selectedRoute: T,
    onItemSelected: (T) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = SpeechTheme.colors

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(colors.background)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.fastForEach { item ->
            NavigationBarItem(
                item = item,
                isSelected = item.route == selectedRoute,
                onSelected = { onItemSelected(item.route) }
            )
        }
    }
}

@Composable
private fun <T: NavigationBarRoute> NavigationBarItem(
    item: NavigationItem<T>,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    val colors = SpeechTheme.colors
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .clip(SpeechTheme.shapes.small)
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(),
                onClick = onSelected
            )
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = if (isSelected) item.selectedIcon else item.icon,
            contentDescription = item.contentDescription,
            tint = colors.interactiveTertiary,
            modifier = Modifier.size(24.dp)
        )
    }
}

// Example usage
@Composable
@Preview
public fun NavigationBarExample() {
    var selectedRoute: SpeechNavigationBarRoutes by remember { mutableStateOf(SpeechNavigationBarRoutes.Timeline) }

    val navigationItems: List<NavigationItem<SpeechNavigationBarRoutes>> = listOf(
        NavigationItem(
            icon = SpeechIcons.Nav.Home,
            selectedIcon = SpeechIcons.Nav.HomeFill,
            contentDescription = "Home",
            route = SpeechNavigationBarRoutes.Timeline
        ),
        NavigationItem(
            icon = SpeechIcons.Nav.Blab,
            selectedIcon = SpeechIcons.Nav.BlabFill,
            contentDescription = "Blabs",
            route = SpeechNavigationBarRoutes.Blabs
        ),
        NavigationItem(
            icon = SpeechIcons.Nav.Profile,
            selectedIcon = SpeechIcons.Nav.ProfileFill,
            contentDescription = "Profile",
            route = SpeechNavigationBarRoutes.Profile
        )
    )

    SpeechNavigationBar(
        items = navigationItems,
        selectedRoute = selectedRoute,
        onItemSelected = { route -> selectedRoute = route }
    )
}

// Light/Dark theme variations
@Composable
@Preview
public fun NavigationBarForLightTheme() {
    SpeechTheme(
        colors = LightSpeechColors,
        content = { NavigationBarExample() }
    )
}

@Composable
@Preview
public fun NavigationBarForDarkTheme() {
    SpeechTheme(
        colors = DarkSpeechColors,
        content = { NavigationBarExample() }
    )
}

public sealed class SpeechNavigationBarRoutes: NavigationBarRoute {
    public object Timeline: SpeechNavigationBarRoutes()
    public object Blabs: SpeechNavigationBarRoutes()
    public object Profile: SpeechNavigationBarRoutes()
}
