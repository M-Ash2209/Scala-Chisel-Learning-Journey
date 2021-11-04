package lab7
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class DetectSeqtest extends FreeSpec with ChiselScalatestTester{
    "FSM lab7"  in {
     test (new DetectSeq){ c =>
        
        c.io.in.poke(1.B)
        
        
        // c.io.out.expect(4.U)
        
        c.clock.step(50)
        }
    }
}