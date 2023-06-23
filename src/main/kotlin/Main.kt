import kotlinx.coroutines.*

fun sendNotification(message: String): Deferred<String> = CoroutineScope(Dispatchers.Default).async {
    delay(1000)
    println("Notification: $message")
    message
}

fun main() = runBlocking {
    val messages = listOf("Message 1", "Message 2", "Message 3")
    val deferredList = mutableListOf<Deferred<String>>()

    for (message in messages) {
        val deferred = sendNotification(message)
        deferredList.add(deferred)
    }

    deferredList.awaitAll().forEach { notification ->
        println("Received Notification: $notification")
    }
}
