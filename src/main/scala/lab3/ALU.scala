package lab3
import chisel3._
import chisel3.util._

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
        is (0.U){
            io.out := io.a + io.b
        }
        //sll
        is (1.U){
            io.out := io.a << io.b(4,0)
        }
        //SLT
        is (2.U){
            when(io.a < io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        
        }
        //SLTU
        is (3.U){
            when(io.a.asUInt < io.b.asUInt){
                io.out:= 1.S
            }.otherwise{
                io.out:= 0.S
            }
        }
        //xor
        is(4.U){
            io.out:=io.a^io.b
        }
        //slr
        is(5.U){
            io.out:=io.a >> io.b(4,0)
        }
        //or
        is(6.U){
            io.out:=io.a | io.b
            
        }
        //ANd
        is(7.U){
            io.out:=io.a & io.b
        }
        //sub
         is(8.U){
            io.out:=io.a - io.b
        }
        //SRA
        // is(13.U){
        //     io.out:=io.a << io.b
        // }
        //BEQ
        is(16.U){
            when(io.a === io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //bne
        is(17.U){
            when(io.a =/= io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //blt
        is(20.U){
            when(io.a < io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //bge
        is(21.U){
            when(io.a >= io.b){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //bltu
        is(22.U){
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





