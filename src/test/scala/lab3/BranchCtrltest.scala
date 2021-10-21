package lab3
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class BranchCtrltest extends FreeSpec with ChiselScalatestTester{
    "Branching" in  {
        test (new BranchCtrl){ c =>
        c.io.branch.poke(0.B)
        c.io.y.poke(12.S)
        c.io.x.poke(12.S)
      
        c.io.sel.poke(16.U)
        c.io.br_taken.expect(1.B)
        c.io.out.expect(1.S) 
        //c.alu.io.out1.expect(1.B)     
        c.clock.step(100)
        }
    }
}