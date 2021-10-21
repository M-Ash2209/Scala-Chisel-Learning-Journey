package lab2
import chisel3._
import chisel3.util._

class LM_IO_Interface extends Bundle {
    val s0 = Input(Bool())
    val s1 = Input(Bool())
    val s2 = Input(Bool())
    val out = Output(UInt(32.W))
}
class Mux_5to1 extends Module {
    val io = IO ( new LM_IO_Interface )
    // Start coding here
    when (io.s0 === 0.B & io.s1 === 0.B & io.s2 === 0.B){
        io.out:= (0.U)
    }.elsewhen (io.s0 === 1.B & io.s1 === 0.B & io.s2 === 0.B){
        io.out:= (8.U)
    }.elsewhen (io.s0 === 0.B & io.s1 === 1.B & io.s2 === 0.B){
        io.out:= (16.U)
    }.elsewhen (io.s0 === 1.B & io.s1 === 1.B & io.s2 === 0.B){
        io.out:= (24.U)
    }.otherwise{
        io.out:= (32.U)
    }


// End your code here
}