/**
 * Created by powel on 1/4/2018.
 */
class TemperatureStats{
    var frequencies = mutableMapOf<Int, Int>()

    private object statistics{
        var min:Int = Int.MAX_VALUE
        var max:Int = Int.MIN_VALUE
        var mean:Int = 0
        var mode:Int = 0
        var count:Int = 0
        var sum: Int = 0
        var frequencies = mutableMapOf<Int, Int>()
        var freqCount:Int = 0
    }

    fun input(temp: Int){
        statistics.sum += temp
        if (statistics.count == 0){
            statistics.min = temp
            statistics.max = temp
            statistics.mean = temp
            statistics.mode = temp
            statistics.sum = temp
        }
        statistics.count++
        //Check min
        if (statistics.min > temp){
            statistics.min = temp
        }
        //Check max
        if (statistics.max < temp){
            statistics.max = temp
        }
        //Calculate mean
        statistics.mean = statistics.sum/statistics.count

        //determine mode
        if (statistics.frequencies[temp] != null){
            var count: Int = statistics.frequencies[temp]!!
            count = count!! + 1
            statistics.frequencies[temp] = count
        }else{
            statistics.frequencies[temp] = 1
        }
        if (statistics.frequencies[temp]!! > statistics.freqCount) {
            statistics.freqCount = statistics.frequencies[temp]!!
            statistics.mode = temp
        }

    }

    fun getMin(): Int {
        return statistics.min
    }

    fun getMax(): Int{
        return statistics.max
    }
     fun getMean(): Int{
            return statistics.mean
        }
     fun getMode(): Int{
//         var mostFrequent = statistics.frequencies.maxBy { it.value }
//            return mostFrequent!!.component1()
         return statistics.mode
        }

}

fun main(args: Array<String>) {
    var tempStat = TemperatureStats()
    tempStat.input(-10)
    tempStat.input(30)
    tempStat.input(6)
    tempStat.input(6)
    tempStat.input(6)
    tempStat.input(30)
    tempStat.input(-10)
    tempStat.input(-10)
    tempStat.input(-10)

    println(tempStat.getMax())
    println(tempStat.getMode())
    println(tempStat.getMean())

}
