package lab8
import chisel3 . _
import chisel3 .util. _

class WMaskedReadWriteSmem extends Module {
    val width : Int = 32
    val io = IO ( new Bundle {
        val enable = Input ( Bool () )
        val write = Input ( Bool () )
        val addr = Input ( UInt (10. W ) )
        val mask = Input ( UInt (2. W ) )
        val dataIn = Input (UInt ( width . W )) 
        val dataOut = Output (UInt ( width . W )) 
    })
    // Create a 32 - bit wide memory that is byte - masked
    val mem = SyncReadMem (1024 , UInt ( width . W ) )
    // Write with mask
    when (io.mask ===2.U){
        mem . write ( io . addr , io . dataIn(7,0))
    }.elsewhen (io.mask ===1.U){
        mem . write ( io . addr , io . dataIn(15,0))
    }.elsewhen (io.mask ===0.U){
        mem . write ( io . addr , io . dataIn)
    }.otherwise{
        mem . write ( io . addr , io . dataIn)

    }
    
    io . dataOut := mem . read ( io . addr , io . enable )
}