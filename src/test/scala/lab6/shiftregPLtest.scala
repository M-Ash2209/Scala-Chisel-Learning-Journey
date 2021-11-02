package lab6
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class shiftregPLtest extends FreeSpec with ChiselScalatestTester{
    "shift RegPL."  in {
     test (new shiftregPL){ c =>
        c.io.load_in(0).poke(1.B)
        c.io.load_in(1).poke(0.B)
        c.io.load_in(2).poke(1.B)
        c.io.in.poke(1.B)
        c.io.load.poke(0.B)
        
        
        // c.io.out.expect(4.U)
        
        c.clock.step(50)
        }
    }
}