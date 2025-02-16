package wtf.speech.free.core.kit.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import speechwtf.core.kit.generated.resources.Res
import speechwtf.core.kit.generated.resources.rubik_medium
import speechwtf.core.kit.generated.resources.rubik_regular
import speechwtf.core.kit.generated.resources.rubik_semi_bold

public object Fonts {

    public val RubikSemiBold: Font
        @Composable
        get() {
            return org.jetbrains.compose.resources.Font(
                Res.font.rubik_semi_bold,
                FontWeight.SemiBold,
            )
        }

    public val RubikMedium: Font
        @Composable
        get() {
            return org.jetbrains.compose.resources.Font(
                Res.font.rubik_medium,
                FontWeight.Medium,
            )
        }

    public val RubikNormal: Font
        @Composable
        get() {
            return org.jetbrains.compose.resources.Font(
                Res.font.rubik_regular,
                FontWeight.Normal,
            )
        }

    public val RubikFontFamily: FontFamily
        @Composable
        get() {
            return FontFamily(
                RubikSemiBold,
                RubikMedium,
                RubikNormal,
            )
        }
}

