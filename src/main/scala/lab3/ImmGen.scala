package lab3
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_ImmdValGen extends Bundle {
    val instr = Input ( UInt (32. W ) )
    // val sel = Input(UInt())
    val PC = Input (UInt(32. W ) )
    val out = Output ( SInt (32. W ) )
//     val ImmS = Output ( SInt (32. W ) )
//     val ImmI = Output ( SInt (32. W ) )
//     val ImmJal = Output ( SInt (32. W ) )
//     val ImmU = Output ( SInt (32. W ) )
//     val ImmAU = Output ( SInt (32. W ) )
}
class ImmGen extends Module {
    val io = IO ( new LM_IO_Interface_ImmdValGen )
    val opc = io.instr(6,0)
    io.out := 0.S
    switch(opc){
        // Start coding here
        //B type
        is(99.U){
            io. out := ((Cat(io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8),0.U)) + io.PC).asSInt
        }
        //S type
        is(35.U){
            io. out := Cat(io.instr(31,25),io.instr(11,7)).asSInt
        }
        //I type
        is(19.U){
            io. out := io.instr(31,20).asSInt
        }
        //L type
        is(3.U){
            io. out := io.instr(31,20).asSInt
        }
        //JAL type
        is(111.U){
            io. out := (((Cat(io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21),0.U)) << 12.U)+ io.PC).asSInt
        }
        //U Type
        is(55.U){
            io. out := io.instr(31,12).asSInt
        }
        //AUI
        is(23.U){
            io. out := (io.instr(31,12) + io.PC).asSInt
        }
        // End your code here
    }

}