package lab6
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class countertest extends FreeSpec with ChiselScalatestTester{
    "counter lab6."  in {
     test (new counter(13)){ c =>
        
        
        // c.io.out.expect(4.U)
        
        c.clock.step(50)
        }
    }
}