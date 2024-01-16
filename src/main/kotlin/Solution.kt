

/**
 * 서로다른 4개의점이 주어질대, 평행이 되는경우가 있으면 1를 반환 아니면 0
 * 4개중 2개를 골라 기울기를 구하고 그 기울기가 같다면 평행
 * 총 3번의 경우인가? 중복 제외하면
 */


class Solution {
    fun solution(dots: Array<IntArray>): Int {

        var gradientA = 0.0 // 기울기
        var gradientB = 0.0 // 기울기
        //(0,1 2,3) (0,2 3,1) (0,3 2,1)
        gradientA = getGradient(dots[0], dots[1])
        gradientB = getGradient(dots[2], dots[3])
        println(" $gradientA,$gradientB ")
        if (gradientA == gradientB) return 1

        gradientA = getGradient(dots[0],dots[2])
        gradientB = getGradient(dots[1],dots[3])
        println(" $gradientA,$gradientB ")
        if (gradientA == gradientB) return 1

        gradientA = getGradient(dots[0],dots[3])
        gradientB = getGradient(dots[2],dots[1])
        println(" $gradientA,$gradientB ")
        if (gradientA == gradientB) return 1

        return 0
    }


    private fun getGradient(a: IntArray, b: IntArray): Double =
        calculateGradient(lineToDouble(a[0], b[0]), lineToDouble(a[1], b[1]))

    private fun lineToDouble(x: Int, y: Int): Double = x.toDouble() - y.toDouble()
    private fun calculateGradient(a: Double, b: Double): Double = a/b

}

fun main() {
    println(Solution().solution(
        arrayOf(
            intArrayOf(1, 4),
            intArrayOf(9, 2),
            intArrayOf(3, 8),
            intArrayOf(11, 6)
        )
    ))//1
    println(Solution().solution(
        arrayOf(
            intArrayOf(3, 5),
            intArrayOf(4, 1),
            intArrayOf(2, 4),
            intArrayOf(5, 10)
        )
    ))
    println(Solution().solution(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(5, 1),
            intArrayOf(3, 6),
            intArrayOf(6, 3)
        )
    ))//1
}