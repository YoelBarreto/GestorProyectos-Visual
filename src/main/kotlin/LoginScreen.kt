import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Login() {
    var user by remember { mutableStateOf("") }
    var passwd by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFd3d3d3)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Log in",
            fontSize = 32.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .width(300.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Usuario") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = passwd,
                onValueChange = { passwd = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Iniciar sesión")
            }
        }
    }
}