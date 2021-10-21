package lab1
import org.scalatest._
import chiseltest._
import chisel3._

class counterStest extends FreeSpec with ChiselScalatestTester{

    "counter" in {
        test (new counterS(4.U)){ c=> 
        c.clock.step(100)

        }
    }
}