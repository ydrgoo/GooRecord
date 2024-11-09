import kotlinx.coroutines.*
import java.util.concurrent.Executors

/**
 * 로그인 세션. 로그인 후 진행할 수 있는 작업을 수행할 수 있습니다.
 */
class LoginSession(val id: String) {
    private val executor by lazy {
        Executors.newSingleThreadExecutor()
    }
    val coroutineScope = CoroutineScope(executor.asCoroutineDispatcher())

    companion object {
        /**
         * 현재 로그인 세션입니다.
         */
        val current: LoginSession? get() = _currentSession
        private var _currentSession: LoginSession? = null

        val isLogin: Boolean
            get() = _currentSession != null

        /**
         * 새 로그인 세션을 시작합니다.
         * 기존에 로그인 세션이 남아있다면 강제로 로그아웃합니다.
         */
        fun login(id: String, pw: String) {
            logout()
            _currentSession = LoginSession(id)
        }

        /**
         * 세션을 무효화하고, 현재 로그인 세션에서 실행 중인 작업을 모두 취소합니다.
         */
        fun logout() {
            _currentSession?.let {
                _currentSession = null
                it.coroutineScope.cancel(LogoutException(it))
            }
        }
    }
}

class LogoutException(loginScope: LoginSession): CancellationException("${loginScope.id} is Logged Out.")

