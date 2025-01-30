import androidx.compose.desktop.ui.tooling.preview.Preview
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
import kotlin.random.Random

// Datos temporales para los proyectos

data class Proyecto(val nombre: String, val clientes: List<String>)

fun generarClientes(): List<String> {
    val posiblesClientes = listOf("Juan Pérez", "María López", "Carlos Gómez", "Ana Martínez", "Pedro Sánchez")
    return posiblesClientes.shuffled().take(Random.nextInt(1, 4))
}

val proyectos = listOf(
    Proyecto("Spiderman Home alone", generarClientes()),
    Proyecto("Ventanas furiosas", generarClientes()),
    Proyecto("Pistolas de goma", generarClientes()),
    Proyecto("Turistas asiaticos simulator", generarClientes()),
    Proyecto("Software cocina", generarClientes()),
    Proyecto("Ciudania descontrolada", generarClientes()),
    Proyecto("Robo minoristas 2", generarClientes()),
    Proyecto("Alexsoft Rework", generarClientes()),
    Proyecto("Subnautica 4", generarClientes()),
    Proyecto("Torrente 2 Rework", generarClientes())
)



@Composable
@Preview
fun ProyectosScreen() {
    var filter by remember { mutableStateOf(true)}

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
                onClick = { /* Acción para volver */ },
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
                Text(
                    text = "Lista de Proyectos",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
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
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            items(proyectos) { proyecto ->
                ProyectoItem(proyecto)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun ProyectoItem(proyecto: Proyecto) {
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

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Clientes: ${proyecto.clientes.joinToString(", ")}",
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        }
        Button(
            onClick = { /* Proyecto en concreto */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EA))
        ) {
            Text(text = "Ver", color = Color.White)
        }
    }
}
