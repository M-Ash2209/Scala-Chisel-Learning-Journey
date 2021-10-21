package lab1
import org.scalatest._
import chiseltest._
import chisel3._

class counterItest extends FreeSpec with ChiselScalatestTester{

    "RangeCounter" in {
        test (new counterI(3,7)){ c=> 
        c.clock.step(100)

        }
    }
}