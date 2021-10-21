package lab3
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_BranchControl extends Bundle {
    val sel= Input ( UInt (5. W ) )
    val branch= Input ( Bool () )
    val x= Input ( SInt (32. W ) )
    val y= Input ( SInt (32. W ) )
    val out= Output ( SInt (32. W ) )
    val br_taken = Output ( Bool () )
}
class BranchCtrl extends Module {
    val io = IO ( new LM_IO_Interface_BranchControl )
    // Start Coding here
    io.out := 0.S
    switch(io.sel){
        //BEQ
        is(16.U){
            when(io.x === io.y){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //bne
        is(17.U){
            when(io.x =/= io.y){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //blt
        is(20.U){
            when(io.x < io.y){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //bge
        is(21.U){
            when(io.x >= io.y){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }
        //bltu
        is(22.U){
            when(io.x.asUInt < io.y.asUInt){
                io.out:= 1.S
            }.otherwise{
                io.out:=0.S
            }
        }

    }
    when (io.out === 1.S & io.sel(4,3) === "b10".U & io.branch === 1.B){
        io.br_taken := 1.B
    }.otherwise{
        io.br_taken := 0.B
    }
// End your code here
}