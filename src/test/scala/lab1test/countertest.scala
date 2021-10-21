package lab1
import org.scalatest._
import chiseltest._
import chisel3._

class countertest extends FreeSpec with ChiselScalatestTester{

    "counter" in {
        test (new counter(4.U)){ c=> 
        c.clock.step(100)

        }
    }
}