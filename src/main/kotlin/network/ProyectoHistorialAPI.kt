package network

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.Proyecto
import network.NetworkUtils.httpClient

fun apiPastProyects(onSuccessResponse: (List<Proyecto>) -> Unit) {
    val url = "http://127.0.0.1:5000/proyectos/historial"

    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.get(url) {
            contentType(ContentType.Application.Json)
        }
        if (response.status == HttpStatusCode.OK) {
            val listProyecto = response.body<List<Proyecto>>()
            onSuccessResponse(listProyecto)
        } else {
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }
}
