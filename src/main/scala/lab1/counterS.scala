package lab1
import chisel3._

class counterS ( counterBits : UInt ) extends Module {
    val io = IO ( new Bundle {
        val result = Output ( Bool () )
    })
    val max = (1. S << counterBits ) - 1.S
    val count = RegInit (0. U (16. W ) )
    when ( count === max.asUInt ) {
        count := 0. U
    } .otherwise {
        count := count + 1.U
    }
    io . result := count (15.U)
    //println ( s " counter created with max value $max " )
}