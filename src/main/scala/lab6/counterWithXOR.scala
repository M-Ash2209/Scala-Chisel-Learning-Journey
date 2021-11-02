package lab6
import chisel3._
import chisel3.util._

class counterWithXOR ( val max : Int = 7 ) extends Module {
    val io = IO ( new Bundle {
        val out = Output ( UInt ( log2Ceil ( max ) . W ) )
    })
    val counter = RegInit (0.U ( log2Ceil ( max ) . W ) )
    // If the max count is of power 2 and the min value = 0 ,
    // then we can skip the comparator and the Mux
    val count_buffer = Mux ((0.B ^ counter((log2Ceil ( max )-1))) , 0.U , counter +1. U ) 
                    
    counter := count_buffer
    io . out := counter
}