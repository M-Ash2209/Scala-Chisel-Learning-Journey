// package RegF
// import chisel._
// import chisel.util._

// class RegFile extends Module{
//     val io = IO(new Bundle{
//         val wr_en = Input(Bool())
//         val rd = Input (UInt(5.W))
//         val rs1 = Input(UInt(5.W))
//         val rs2 = Input(UInt(5.W))
//         val wr_back = Input(SInt(32.W))
//         val da = Output (SInt(32.W))
//         val db = Output(SInt(32.W))
//     })
//     val reg = RegInit(Vec(32(0.S(32.W))))
//     when (io.wr_en){
//         reg(io.rd):= io.wr_back
//         io.da:= reg(rs1)

//     }.elsewhen (io.wr_en & (io.rd=== 0.U)){
//         reg(io.rd):= 0.S
//     }

// }