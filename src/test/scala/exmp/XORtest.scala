package exmp
import org.scalatest._
import chiseltest._
import chisel3._

class XORtest extends FreeSpec with ChiselScalatestTester{

    "XOR Gate Test" in {
        test (new XOR()){ c=> 
        c.io.a.poke(0.U)
        c.io.b.poke(1.U)
        c.clock.step(1)
        c.io.otp.expect(1.U)
        c.clock.step(10)

        }
    }
}