package lab5
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class AdderCTtest extends FreeSpec with ChiselScalatestTester{
    "Clone Type"  in {
     test (new Top(16,16,32)){ c =>
        c.io.in.poke(2.U)
        
        c.io.out.expect(4.U)
        
        c.clock.step(50)
        }
    }
}