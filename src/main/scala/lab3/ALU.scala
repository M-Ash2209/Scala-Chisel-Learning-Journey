package lab3
import chisel3._
import chisel3.util._

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
    val BEQ = 16.U(5.W)
    val BNE = 17.U(5.W)
    val BLT = 20.U(5.W)
    val BGE = 21.U(5.W)
    val BLTU= 22.U(5.W)
    // val ALU_COPY_A = 10.U(4.W)
    // val ALU_COPY_B = 11.U(4.W)
    // val ALU_XXX = 12.U(4.W) 
}
import ALUOP._
class ALU extends Module{
    val io = IO(new Bundle{
        val a = Input(SInt(32.W))
        val b =  Input(SInt(32.W))
        val out = Output(SInt(32.W))
        val select = Input(UInt(5.W))
        val out1 = Output(Bool())
    })
    io.out := 0.S
    switch(io.select){
        is (ADD){
            io.out := io.a + io.b
        }
        //sll
        is (SLL){
            io.out := io.a << io.b(4,0)
        }
        //SLT
        is (SLT){
            when(io.a < io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        
        }
        //SLTU
        is (SLTU){
            when(io.a.asUInt < io.b.asUInt){
                io.out:= 1.S
            }.otherwise{
                io.out:= 0.S
            }
        }
        //xor
        is(XOR){
            io.out:=io.a^io.b
        }
        //srl/sra
        is(SRL){
            io.out:=io.a >> io.b(4,0)
        }
        //or
        is(OR){
            io.out:=io.a | io.b
            
        }
        //ANd
        is(AND){
            io.out:=io.a & io.b
        }
        //sub
         is(SUB){
            io.out:=io.a - io.b
        }
        //SRA
        is(SRA){
            io.out:=io.a >> io.b(4,0)
        }
        //BEQ
        is(BEQ){
            when(io.a === io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //bne
        is(BNE){
            when(io.a =/= io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //blt
        is(BLT){
            when(io.a < io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //bge
        is(BGE){
            when(io.a >= io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //bltu
        is(BLTU){
            when(io.a.asUInt < io.b.asUInt){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }




 

    }
    when (io.out === 1.S & io.select(4,3) === "b10".U){
        io.out1 := 1.B
    }.otherwise{
        io.out1 := 0.B
    }
    
    

}





