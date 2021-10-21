package lab1
import org.scalatest._
import chiseltest._
import chisel3._

class AdderWithOffsettest extends FreeSpec with ChiselScalatestTester{

    "AdderWithOffset" in {
        test (new AdderWithOffset()){ c=> 
        c.io.x.poke(1.S)
        c.io.y.poke(1.U)
        c.clock.step(1)
        c.io.z.expect(25.U)
        c.clock.step(10)
        c.clock.step(100)

        }
    }
}