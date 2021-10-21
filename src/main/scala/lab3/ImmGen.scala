package lab3
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_ImmdValGen extends Bundle {
    val instr = Input ( SInt (32. W ) )
    val sel = Input(UInt())
    val PC = Input (UInt(32. W ) )
    val ImmB = Output ( SInt (32. W ) )
    val ImmS = Output ( SInt (32. W ) )
    val ImmI = Output ( SInt (32. W ) )
    val ImmJal = Output ( SInt (32. W ) )
    val ImmU = Output ( SInt (32. W ) )
    val ImmAU = Output ( SInt (32. W ) )
}
class ImmGen extends Module {
    val io = IO ( new LM_IO_Interface_ImmdValGen )
    
    // Start coding here
    io. ImmB := ((Cat(io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8),0.U)) + io.PC)
    io. ImmS := Cat(io.instr(31,25),io.instr(11,7))
    io. ImmI := io.instr(31,20)
    io. ImmJal := (((Cat(io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21),0.U)) << 12.U)+ io.PC)
    io. ImmU := io.instr(31,12)
    io. ImmAU := (io.instr(31,12) + io.PC)
    // End your code here

}