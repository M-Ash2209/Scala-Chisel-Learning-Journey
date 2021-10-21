package lab1
import org.scalatest._
import chiseltest._
import chisel3._

class RangeCountertest extends FreeSpec with ChiselScalatestTester{

    "RangeCounter" in {
        test (new RangeCounter(3,7.U)){ c=> 
        c.clock.step(100)

        }
    }
}