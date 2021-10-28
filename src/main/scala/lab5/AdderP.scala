package lab5
import chisel3 . _
import chisel3 . util . _

class AdderP ( Wdth:Int ) extends Module {
    require ( Wdth >= 0)
    // your code begin from here
    val io =IO(new Bundle{
        val in0 = Input(SInt(Wdth.W))
        val in1 = Input(SInt(Wdth.W))
        val sum = Output(SInt(Wdth.W))
    })
    io.sum := io.in0 + io.in1
    // your code end here
}