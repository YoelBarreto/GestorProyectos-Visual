package UI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import model.User

data class ProyectoFinalizado(val nombre: String, val fecha: String)

val proyectosTerminados = listOf(
    ProyectoFinalizado("DANA", "29/10/2024"),
    ProyectoFinalizado("Robo a minoristas", "7/7/2018"),
    ProyectoFinalizado("Funcionarios locos", "8/11/2020"),
    ProyectoFinalizado("Turistas de peru", "29/2/1980"),
    ProyectoFinalizado("Problemas en casa", "14/6/2015"),
    ProyectoFinalizado("Ciudania descontrolada", "N/A"),
    ProyectoFinalizado("Problemas genitales", "N/A"),
    ProyectoFinalizado("Viaje a malvinas", "N/A")
)

class WelcomeScreen(val user : User) : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current

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
                    text = "Bienvenido, ${user.nombre} (Gestor)",
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ver proyectos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = {
                        navigator?.push(ProyectosScreen())
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EA))
                ) {
                    Text(
                        text = "Entrar",
                        color = Color.White
                    )
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            // Menu de opciones
            Text(
                text = "Historial (Proyectos finalizados)",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .padding(16.dp)
                    .height(300.dp)
            ) {
                items(proyectosTerminados) { proyectoF ->
                    Proyecto(proyectoF)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cerrar sesión",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = {
                        navigator?.pop()
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFdf1818))
                ) {
                    Text(
                        text = "Desconectar",
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun Proyecto(proyectosTerminados: ProyectoFinalizado) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row {
            Text(
                text = proyectosTerminados.nombre,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = " (Finalizado)",
                fontSize = 18.sp,
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
        }
        Text(
            text = proyectosTerminados.fecha,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color.Red,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}
