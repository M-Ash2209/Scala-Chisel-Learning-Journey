package lab6
import chisel3 . _
import chisel3 .util._

class shiftreg ( val init : Int = 1) extends Module {
    val io = IO ( new Bundle {
        val in = Input (Vec(4,Bool()))
        val out = Output (Vec(4,UInt(4.W)))
    })
    val state0 = RegInit ( init . U (4. W ) )
    val state1 = RegInit ( init . U (4. W ) )
    val state2 = RegInit ( init . U (4. W ) )
    val state3 = RegInit ( init . U (4. W ) )
    // register initialization
    // serial data in at LSB
    val nextState0 = ( state0 << 1) | io . in(0)
    val nextState1 = ( state1 << 1) | io . in(1)
    val nextState3 = ( state3 << 1) | io . in(3)
    val nextState2 = ( state2 << 1) | io . in(2)
    state0 := nextState0
    state1 := nextState1
    state2 := nextState2
    state3 := nextState3

    io . out(0) := state0
    io . out(1) := state1
    io . out(2) := state2
    io . out(3) := state3
}