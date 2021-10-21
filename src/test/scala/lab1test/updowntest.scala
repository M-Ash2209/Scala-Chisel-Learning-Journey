package lab1
import org.scalatest._
import chiseltest._
import chisel3._

class updowntest extends FreeSpec with ChiselScalatestTester{

    "updownCounter" in {
        test (new updown (3)){ c=> 
        c.clock.step(100)

        }
    }
}