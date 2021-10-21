package lab1
import chisel3._

class AdderWithOffset extends Module {
val io = IO ( new Bundle {
val x = Input ( SInt (16. W ) )
val y = Input ( UInt (16. W ) )
val z = Output ( UInt (16. W ) )
})
// Initialized as UInt and casted to SInt
val y1 = (23. S)
val in1 = io . x + y1
io . z := in1 . asUInt + io . y // Typecast SInt to UInt
}