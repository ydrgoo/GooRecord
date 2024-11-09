import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    LoginSession.login("googoo", "goo1234!")

    // [1] 사과 구입
    LoginSession.current?.coroutineScope?.launch {
        println("buy Apple...")
        delay(200)
        println("buy Apple... Done!")
    }

    // [2] 회원 탈퇴
    LoginSession.current?.coroutineScope?.launch(Dispatchers.Default) {
        println("Withdrawal...")
        delay(250)
        println("Withdrawal...Done! Logout.")
        LoginSession.logout()
    }

    // [3] 물건 검색
    LoginSession.current?.coroutineScope?.launch {
        println("item search...")
        try {
            delay(400)
        } catch (e: LogoutException) {
            println("Already Logout")
        }

        println("item search...Done!")
    }

    delay(2000)
}