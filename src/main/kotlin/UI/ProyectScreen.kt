package UI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import model.Proyecto
import network.apiGestorProyects

//data class Tarea(val nombre: String)
//
//val tareas = listOf(
//    Tarea("Autenticación de usuarios"),
//    Tarea("Optimizar base de datos"),
//    Tarea("Diseñar API de pagos"),
//    Tarea("Corregir bug de notificaciones"),
//    Tarea("Integrar Stripe"),
//    Tarea("Refactorizar backend"),
//    Tarea("Pruebas unitarias"),
//    Tarea("Crear dashboard"),
//    Tarea("Implementar chat en vivo"),
//    Tarea("Mejorar seguridad"),
//)

class ProyectScreen(proyecto: Proyecto) : Screen {

    val proyectoActual = proyecto
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current
//        val mineProyectList = remember { mutableStateOf(emptyList<model.Proyecto>()) }
//        apiGestorProyects(tarea) {
//            mineProyectList.value = it
//        }
//        val lorem = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
//                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
//                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
//                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
//                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
//                "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
//
//        val info = "Fecha creación: 2024-01-01 \n" +
//                "Fecha inicio: 2024-01-01 \n" +
//                "Fecha finalización: 2024-01-01 \n" +
//                "CLIENTE: @viviendoenlacalle"
        val info = "ID: ${proyectoActual.id} \n" +
                "Fecha creación: ${proyectoActual.fecha_creacion} \n" +
                "Fecha Inicio: ${proyectoActual.fecha_inicio} \n" +
                "Fecha finalización: ${proyectoActual.fecha_finalizacion} \n" +
                "${proyectoActual.}"

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFf5f5f5))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado entre los items
        ) {
            // Header con botón Volver
            item {
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
                        Text(
                            text = "Proyecto: ${proyectoActual.nombre}",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Título de descripción
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF6200EA))
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Descripción",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Contenido de descripción
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = proyectoActual.descripcion,
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontStyle = FontStyle.Italic
                    )
                }
            }

            // Sección de Tareas
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Tareas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
            item {
                Box(
                    modifier = Modifier.height(300.dp)
                ) {
                    // Lista de proyectos
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                        items(tareas) { tarea ->
                            TareaItem(tarea)
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF6200EA))
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Información",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            // Contenido de información
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = info,
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}


@Composable
fun TareaItem(tarea: Tarea){

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
                text = tarea.nombre,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navigator?.push(TareaScreen(tarea.nombre))
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6200EA))
        ) {
            Text(text = "Ver", color = Color.White)
        }
    }
}