package lab5
import org.scalatest._
import chiseltest._
import chisel3._

class operatortest extends FreeSpec with ChiselScalatestTester{
    "Reduce sys" in  {

        test (new operator(2,UInt(16. W ))( _ + _ )){ c =>
        c.io.in1(0).poke(12.U)
        c.io.in1(1).poke(3.U)
        c.io.out(0).expect(15.U)
        c.io.out(1).expect(15.U)
        c.clock.step(100)
        }
    }
}