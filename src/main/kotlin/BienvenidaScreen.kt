import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun WelcomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFf5f5f5))
            .padding(16.dp)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color(0xFF6200EA), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Bienvenido, Pedro Sanchez (Administrador de izquierdas)",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Esto es una aplicación la cual usa una API creada manualmente la cual simula una empresa llamada 'AlexSoft'.",
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Option("Ver proyectos", "Entrar", 0xFF6200EA)

        Spacer(modifier = Modifier.height(16.dp))

        // Menu de opciones
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Historial (Proyectos finalizados)",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Proyecto("DANA", "29/10/2024")
            Proyecto("Robo a minoristas", "7/6/2018")
        }

        Spacer(modifier = Modifier.weight(1f))

        Option("Cerrar sesión", "Desconectar", 0xFFdf1818)
    }
}

@Composable
fun Option(titulo: String, boton: String, color: Long) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = titulo,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(color))
        ) {
            Text(
                text = boton,
                color = Color.White
            )
        }
    }
}

@Composable
fun Proyecto(titulo: String, fecha: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = titulo,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = fecha,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color.Red,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}
