package lab3
import chisel3._
import chisel3.util._

object Opcode1{
    val I_TYPE1= "b0000011".U
    val I_TYPE2= "b0010011".U
    val I_TYPE3= "b0011011".U
    val R_TYPE1= "b0010011".U
    val R_TYPE2= "b0011011".U
    val S_TYPE = "b0100011".U
    val SB_TYPE= "b1100011".U
    val UJ_TYPE ="b1101111".U
    val U_TYPE1 ="b0010111".U
    val U_TYPE2 ="b0110111".U
    
}

import Opcode1._

class IO_Interface_ImmdValGen extends Bundle {
    val instr = Input (UInt(32. W))
    val immd_se = Output(SInt(32.W))
}

class Immediate extends Module {
    val io = IO (new IO_Interface_ImmdValGen)
    val Itype= io.instr(31, 20).asSInt
    val Stype =Cat(io.instr(11,7),io.instr(31,25)).asSInt
    val SBtype =(Cat(io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8))).asSInt
    val Utype =(Cat(io.instr(31,12))).asSInt
    val UJtype =(Cat(io.instr(31),io.instr(20),io.instr(30,21),io.instr(19,12))).asSInt
    when (I_TYPE1 === io.instr(6, 0) | I_TYPE2 === io.instr(6, 0)| I_TYPE3=== io.instr(6, 0)) {
        io.immd_se:= Itype
    }.elsewhen (S_TYPE=== (io.instr(6,0))){
        io.immd_se:= Stype
    }.elsewhen (SB_TYPE=== (io.instr(6,0))){
        io.immd_se:= SBtype
    }.elsewhen (U_TYPE1 === io.instr(6,0)| U_TYPE2 === io.instr(6,0)){
        io.immd_se:= Utype
    }.otherwise{
        io.immd_se := UJtype
    }
        
}
    