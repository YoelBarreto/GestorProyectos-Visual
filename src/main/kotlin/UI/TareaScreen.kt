package UI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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

data class Programador(val nombre: String)

val programadores = listOf(
    Programador("Juan Pérez"),
    Programador("María López"),
    Programador("Carlos Rodríguez"),
    Programador("Ana Gómez"),
    Programador("Luis Fernández"),
    Programador("Sofía Martín"),
    Programador("Pedro Sánchez"),
    Programador("Elena Díaz"),
    Programador("David Torres"),
    Programador("Raúl García")

)
val lorem = "Contrary to popular belief, Lorem Ipsum is not simply random text." +
        " It has roots in a piece of classical Latin literature from 45 BC, " +
        "making it over 2000 years old. Richard McClintock, a Latin professor at " +
        "Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, " +
        "consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, " +
        "discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of " +
        "\"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. " +
        "This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, " +
        "\"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32." +
        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. " +
        "Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, " +
        "accompanied by English versions from the 1914 translation by H. Rackham." +
        "Contrary to popular belief, Lorem Ipsum is not simply random text." +
        " It has roots in a piece of classical Latin literature from 45 BC, " +
        "making it over 2000 years old. Richard McClintock, a Latin professor at " +
        "Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, " +
        "consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, " +
        "discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of " +
        "\"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. " +
        "This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, " +
        "\"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32." +
        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. " +
        "Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, " +
        "accompanied by English versions from the 1914 translation by H. Rackham." + "Contrary to popular belief, Lorem Ipsum is not simply random text." +
        " It has roots in a piece of classical Latin literature from 45 BC, " +
        "making it over 2000 years old. Richard McClintock, a Latin professor at " +
        "Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, " +
        "consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, " +
        "discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of " +
        "\"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. " +
        "This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, " +
        "\"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32." +
        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. " +
        "Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, " +
        "accompanied by English versions from the 1914 translation by H. Rackham."


class TareaScreen(val nombre: String): Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.current

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFf5f5f5))
                .padding(16.dp)
        ) {
            item {
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
                        Text(
                            text = "Proyecto: $nombre",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
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
                        text = "Descripcion",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            item {
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
                        text = lorem,
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontStyle = FontStyle.Italic
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(programadores) { programador ->
                ProgramadorItem(programador)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}


@Composable
fun ProgramadorItem(programador: Programador){

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
                text = programador.nombre,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}
