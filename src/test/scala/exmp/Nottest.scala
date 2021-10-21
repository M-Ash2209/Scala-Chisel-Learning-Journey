package exmp
import org.scalatest._
import chiseltest._
import chisel3._

class Nottest extends FreeSpec with ChiselScalatestTester{

    "And Gate Test" in {
        test (new Not()){ c=> 
        c.io.a.poke(1.U)
        c.clock.step(1)
        c.io.otp.expect(0.U)
        c.clock.step(10)

        }
    }
}