package UI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import model.Proyecto
import model.User
import network.apiGestorProyects
import network.apiProyects
import kotlin.random.Random

// Datos temporales para los proyectos

//data class Project(val nombre: String, val clientes: List<String>)

//fun generarClientes(): List<String> {
//    val posiblesClientes = listOf("Juan Pérez", "María López", "Carlos Gómez", "Ana Martínez", "Pedro Sánchez")
//    return posiblesClientes.shuffled().take(Random.nextInt(1, 4))
//}

//val projects = listOf(
//    Project("Spiderman Home alone", generarClientes()),
//    Project("Ventanas furiosas", generarClientes()),
//    Project("Pistolas de goma", generarClientes()),
//    Project("Turistas asiaticos simulator", generarClientes()),
//    Project("Software cocina", generarClientes()),
//    Project("Ciudania descontrolada", generarClientes()),
//    Project("Robo minoristas 2", generarClientes()),
//    Project("Alexsoft Rework", generarClientes()),
//    Project("Subnautica 4", generarClientes()),
//    Project("Torrente 2 Rework", generarClientes())
//)



class ProyectosScreen(val user: User) : Screen{
    @Composable
    override fun Content() {
        var filter by remember { mutableStateOf(true)}
        val navigator = LocalNavigator.current
        val proyectList = remember { mutableStateOf(emptyList<model.Proyecto>()) }
        apiProyects {
            proyectList.value = it
        }
        val mineProyectList = remember { mutableStateOf(emptyList<model.Proyecto>()) }
        apiGestorProyects(user.idGestor) {
            mineProyectList.value = it
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFf5f5f5))
                .padding(16.dp)
        ) {
            // Header con botón Volver
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF6200EA))
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        navigator?.pop()
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(text = "Volver", color = Color(0xFF6200EA))
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row {
                        Text(
                            text = "Lista de Proyectos",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = " Activos",
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f)) // Para empujar el botón a la derecha

                Button(
                    onClick = { filter = !filter }, // Cambia el estado al hacer clic
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EA))
                ) {
                    Text(
                        text = if (filter) "Filtrar: Todos" else "Filtrar: Mios",
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de proyectos
            if (filter) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    items(proyectList.value) {
                        ProyectoItem(it)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
                // Mis proyectos
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    items(mineProyectList.value) {
                        ProyectoItem(it)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ProyectoItem(proyecto: Proyecto){

    val navigator = LocalNavigator.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = proyecto.nombre,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                // navigator?.push(ProyectScreen(project.nombre))
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EA))
        ) {
            Text(text = "Ver", color = Color.White)
        }
    }
}