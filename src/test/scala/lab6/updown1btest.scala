package lab6
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class updown1btest extends FreeSpec with ChiselScalatestTester{
    "updown1b lab6."  in {
     test (new updown1b){ c =>
        
        
        c.io.up_down.poke(0.B)
        
        c.clock.step(50)
        }
    }
}