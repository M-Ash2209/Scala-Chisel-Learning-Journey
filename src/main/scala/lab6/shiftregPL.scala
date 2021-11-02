package lab6
import chisel3 . _
import chisel3 . util . _


class shiftregPL (val len : Int = 3 ) extends Module {
    val io = IO (new Bundle {
        val out = Vec ( len , Output ( Bool () ) )
        val load_in = Vec ( len , Input ( Bool () ) )
        val in = Input ( Bool () )
        val load = Input ( Bool () )
    })
    // Start Coding here
    val mux0 = Mux(io.load,io.load_in(0),io.in)
    val mux1 = Mux(io.load,io.load_in(1),io.out(0))
    val mux2 = Mux(io.load,io.load_in(2),io.out(1))

    val reg0 =  RegInit ( 1. U ( 32 . W))
    val reg1 = RegInit ( 1 . U ( 32. W ))
    val reg2 = RegInit( 1. U ( 32 . W ) )

    val nextState0 = ( reg0 << 1) | mux0
    val nextState1 = ( reg1 << 1) | mux1
    val nextState2 = ( reg2 << 1) | mux2

    reg0 := nextState0
    reg1 := nextState1
    reg2 := nextState2
    // state3 := nextState3

    // io . out(0) := state0
    // io . out(1) := state1
    // io . out(2) := state2
    // io . out(3) := state3


    // reg0 := mux0
    // reg1 := mux1
    // reg2 := mux2

    io.out(0) := reg0
    io.out(1) := reg1
    io.out(2) := reg2


    // End your code here
    // Well , you can actually write classes too . So , technically you have no
    // limit ; )
}
// package lab6
// import chisel3 . _
// import chisel3 .util._

// class shiftreg ( val init : Int = 1) extends Module {
//     val io = IO ( new Bundle {
//         val in = Input (Vec(4,Bool()))
//         val out = Output (Vec(4,UInt(4.W)))
//     })
//     val state0 = RegInit ( init . U (4. W ) )
//     val state1 = RegInit ( init . U (4. W ) )
//     val state2 = RegInit ( init . U (4. W ) )
//     val state3 = RegInit ( init . U (4. W ) )
//     // register initialization
//     // serial data in at LSB
//     val nextState0 = ( state0 << 1) | io . in(0)
//     val nextState1 = ( state1 << 1) | io . in(1)
//     val nextState3 = ( state3 << 1) | io . in(3)
//     val nextState2 = ( state2 << 1) | io . in(2)
//     state0 := nextState0
//     state1 := nextState1
//     state2 := nextState2
//     state3 := nextState3

//     io . out(0) := state0
//     io . out(1) := state1
//     io . out(2) := state2
//     io . out(3) := state3
// }