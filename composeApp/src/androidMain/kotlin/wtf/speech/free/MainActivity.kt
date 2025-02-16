package wtf.speech.free

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.theme.Colors


public class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.light(Colors.White.toArgb(), Colors.BlackPearl.toArgb()))
        setContent {
            App()
        }
    }
}

@Preview
@Composable
public fun AppAndroidPreview() {
    App()
}