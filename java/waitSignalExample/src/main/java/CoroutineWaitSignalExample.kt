import data.DataFactory
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    // 이 부분은 그냥 랜덤하게 숫자 2억개 리스트를 생성하는 부분입니다.
    val integerList = DataFactory.getHugeData(200000000)

    println("작업 시작")
    val result = suspendCoroutine<Long> { continuation ->
        Observable.fromIterable<Int>(integerList).observeOn(Schedulers.computation())
            .reduce<Long>(0L) { acc: Long, integer: Int -> acc + integer }
            .subscribe { result: Long ->
                println("작업 완료 (합: $result)")
                // "Sum All" 중단점으로 완료 신호 전달
                continuation.resume(result)
            }
    }

    println("프로그램 종료")
}