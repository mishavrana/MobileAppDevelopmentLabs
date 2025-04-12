import kotlinx.coroutines.*

suspend fun fetchGradesFromServer(): List<Int> {
    delay(2000)
    return listOf(95, 87, 90, 100, 78)
}