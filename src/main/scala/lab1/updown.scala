package lab1
import chisel3._

class updown ( n : Int ) extends Module {
    val io = IO ( new Bundle {
        val data_in = Input ( UInt ( n . W ) )
        val reload = Input ( Bool () )
        val out = Output (Bool ())
        val out1 = Output (UInt())
    })

    val counter = RegInit (0. U ( n . W ) )
    val max_count = RegInit (7. U (n . W ) )
    var flag = RegInit(1.B)
    //when (counter===0.U | counter=== ((1. U << n ) - 1.U)){
    when (counter===0.U | counter=== max_count){
        io.out := 1.U
    }.otherwise{
        io.out := 0.U
    }

    when( counter === max_count | flag === 0.B){
        counter := counter - 1.U
        when(counter === 0.U){
            counter := 0.U
            flag := 1.B
        } .otherwise{
            flag :=0.B
        }
    }.otherwise{
        counter := counter + 1.U
        when(counter === max_count){
            flag := 0.B
        } .otherwise{
            flag := 1.B
        }
    }

    io.out1 := counter


}

