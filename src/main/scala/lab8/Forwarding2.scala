package lab8
import chisel3 . _
import chisel3 . util . _

class Forwarding2 extends Module {
    val width = 16
    val io = IO ( new Bundle {
        val out = Output (Vec(2, ( UInt (width. W ) )))
        val rdAddr = Input ( UInt (10. W ))
        val wrAddr = Input ( UInt (10. W ))
        val mask = Input (Vec(2, Bool ()))
        val wrData = Input (Vec(2, ( UInt (width. W ))))
        val wr_en = Input ( Bool () )
    })
    val memory = SyncReadMem (1024 , Vec(2,UInt (width. W )) )
    val wrDataReg = RegNext ( io . wrData )
    val doForwardReg = RegNext ( io . wrAddr === io . rdAddr && io . wr_en )
    val memData = memory . read ( io . rdAddr  )
    when ( io . wr_en ){
        memory . write ( io . wrAddr , io . wrData, io.mask )
    }
    io . out := Mux ( doForwardReg , wrDataReg , memData )
}