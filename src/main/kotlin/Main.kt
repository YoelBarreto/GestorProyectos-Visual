import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.ui.draw.clip

@Composable
@Preview
fun App() {
    MaterialTheme{
        WelcomeScreen()
    }
}

fun main() = application {
    var showWelcomeScreen by remember { mutableStateOf(false) }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Login",
        state = rememberWindowState(width = 900.dp, height = 800.dp)
    ) {
        App()
    }
}
