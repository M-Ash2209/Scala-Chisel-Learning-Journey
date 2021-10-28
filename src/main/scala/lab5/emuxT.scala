package lab5
import chisel3._
import chisel3.util._

class emuxT  extends Module {
    val io = IO ( new Io(SInt(32.W)))
    
    io . out := Mux2_to_1 ( (io . in2).asUInt , io . in1 , io . sel )
    def Mux2_to_1 [ T <: Data ]( in_0 :T , in_1 :T , sel : Bool ) : T = {
        Mux ( sel , in_1 , in_0 )
    }
}
class Io [ T <: Data ]( gen : T ) extends Bundle {
    val out = Output ( gen )
    val in1 = Input ( gen )
    val in2 = Input ( gen )
    val sel = Input ( Bool () )

}
//can't create Mux with heterogeneous types class 