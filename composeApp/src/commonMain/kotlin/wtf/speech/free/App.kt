package wtf.speech.free

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import wtf.speech.free.core.kit.theme.SpeechTheme
import wtf.speech.free.features.timeline.kit.TimelinePreview

@Composable
@Preview
public fun App() {
    SpeechTheme {
        Scaffold {
            TimelinePreview()
        }
    }
}