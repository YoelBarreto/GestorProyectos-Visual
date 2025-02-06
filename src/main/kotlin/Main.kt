import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import cafe.adriel.voyager.navigator.Navigator
import UI.LoginScreen

@Composable
@Preview
fun App() {
    MaterialTheme{
        Navigator(LoginScreen())
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Gestor de Proyectos",
        state = rememberWindowState(width = 900.dp, height = 800.dp)
    ) {
        App()
    }
}
