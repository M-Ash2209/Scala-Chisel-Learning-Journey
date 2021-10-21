package exmp
import org.scalatest._
import chiseltest._
import chisel3._

class Andtest extends FreeSpec with ChiselScalatestTester{

    "And Gate Test" in {
        test (new And()){ c=> 
        c.io.a.poke(1.U)
        c.io.b.poke(1.U)
        c.clock.step(1)
        c.io.otp.expect(1.U)
        c.clock.step(10)

        }
    }
}