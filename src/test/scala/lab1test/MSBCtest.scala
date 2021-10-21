package lab1
import org.scalatest._
import chiseltest._
import chisel3._

class MSBCtest extends FreeSpec with ChiselScalatestTester{

    "MSBCounter" in {
        test (new MSBC(3,4.U)){ c=> 
        c.clock.step(100)

        }
    }
}