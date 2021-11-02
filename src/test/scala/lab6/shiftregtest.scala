package lab6
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class shiftregtest extends FreeSpec with ChiselScalatestTester{
    "shift Reg."  in {
     test (new shiftreg){ c =>
        c.io.in(0).poke(1.B)
        c.io.in(1).poke(0.B)
        c.io.in(2).poke(0.B)
        c.io.in(3).poke(1.B)
        
        // c.io.out.expect(4.U)
        
        c.clock.step(50)
        }
    }
}