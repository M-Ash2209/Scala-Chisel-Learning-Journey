package lab5
import chisel3 . _
import chisel3 . util . _
// import chisel3 . iotesters .{ Driver , PeekPokeTester }

object ALUOP {
    val ADD = 0.U(5.W)
    val SLL = 1.U(5.W)
    val SLT = 2.U(5.W)
    val SLTU= 3.U(5.W)
    val XOR = 4.U(5.W)
    val SRL = 5.U(5.W)
    val OR  = 6.U(5.W)
    val AND = 7.U(5.W)
    val SUB = 8.U(5.W)
    val SRA = 13.U(5.W)
    // val BEQ = 16.U(5.W)
    // val BNE = 17.U(5.W)
    // val BLT = 20.U(5.W)
    // val BGE = 21.U(5.W)
    // val BLTU= 22.U(5.W)
 
}
import ALUOP._

class ALUW ( width_parameter : Int ) extends Module {
    val io = IO ( new IO_Interface ( width_parameter ) )
    io . alu_out := 0. S
    val index = log2Ceil ( width_parameter )
    
        // AND
        when (  io . alu_oper === 7. U ) {
            io . alu_out := io.arg_x & io.arg_y
        } // OR
        .elsewhen ( io . alu_oper === 6 . U ) {
            io . alu_out := io.arg_x | io.arg_y
        } // ADD
        .elsewhen ( io . alu_oper === 0. U ) {
            io . alu_out := io.arg_x + io.arg_y
        } // SUB
        .elsewhen ( io . alu_oper === 8. U ) {
            io . alu_out := io.arg_x - io.arg_y
        } // XOR
        .elsewhen (io . alu_oper ===  4. U ) {
            io . alu_out := io.arg_x ^ io.arg_y
        } // SLL
        .elsewhen(io . alu_oper ===  1. U ) {
            io . alu_out := io.arg_x << io . arg_y ( index -1 , 0). asUInt
        } // SRL
        .elsewhen (io . alu_oper ===  5. U ) {
            io . alu_out := io.arg_x >> io . arg_y ( index -1 , 0). asUInt
        } // SRA
        .elsewhen (io . alu_oper ===  13. U ) {
            io . alu_out := io.arg_x >> io . arg_y ( index -1 , 0). asUInt
        } // SLT
        .elsewhen ( io . alu_oper === 2. U ) {
            when (io . arg_x < io . arg_y){
                io . alu_out := 1.S
            }.otherwise{
                io . alu_out := 0.S
            }
        } // SLTU
        .elsewhen ( io . alu_oper === 3. U ) {
            when (io . arg_x.asUInt < io . arg_y.asUInt){
                io . alu_out := 1.S
            }.otherwise{
                io . alu_out := 0.S
            }
        }
    
}
class IO_Interface ( width : Int ) extends Bundle {
    val alu_oper = Input ( UInt ( width . W ) )
    val arg_x = Input ( SInt ( width . W ) )
    val arg_y = Input ( SInt ( width . W ) )
    val alu_out = Output ( SInt ( width . W ) )
}




