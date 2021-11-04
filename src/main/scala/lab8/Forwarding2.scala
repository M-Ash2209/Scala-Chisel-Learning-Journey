package lab8
import chisel3 . _
import chisel3 . util . _

class Forwarding2 extends Module {
    val width : Int = 32
    val io = IO ( new Bundle {
        val wr_en = Input ( Bool () )
        val addr = Input ( Vec (4 ,( UInt (10. W ) )))
        val rdAddr = Input ( Vec (4 ,( UInt (10. W ) )))
        val mask = Input ( Vec (4 , Bool () ) )
        val dataIn = Input ( Vec (4 , UInt ( width . W ) ) )
        val dataOut = Output ( Vec (4 , UInt ( width . W ) ) )
    })
    // Create a 32 - bit wide memory that is byte - masked
    val mem = SyncReadMem (1024 , Vec (4 , UInt ( width . W ) ) )
    // Write with mask
    when (io.mask(0) === 1.B){
        
        val wrDataReg = RegNext ( io . dataIn(0) )
        val doForwardReg = RegNext ( io . addr(0) === io . rdAddr(0) && io . wr_en )
        val memData = mem . read ( io . rdAddr(0) )
        // when ( io . wr_en ){
            mem . write ( io . addr(0) , io . dataIn(0))
        // }
         io . dataOut(0) := Mux ( doForwardReg , wrDataReg , memData )
    }.elsewhen (io.mask(1) === 1.B){
        
        val wrDataReg = RegNext ( io . dataIn(1) )
        val doForwardReg = RegNext ( io . addr(1) === io . rdAddr(1) && io . wr_en )
        val memData = mem . read ( io . rdAddr(1) )
        // when ( io . wr_en ){
            mem . write ( io . addr(1) , io . dataIn)
        // }
         io . dataOut(1) := Mux ( doForwardReg , wrDataReg , memData )
    }
    
   

    // io . dataOut := mem . read ( io . addr , io . enable )
}