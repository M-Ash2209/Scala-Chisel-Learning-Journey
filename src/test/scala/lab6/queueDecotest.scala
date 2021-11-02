package lab6
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class queueDecotest extends FreeSpec with ChiselScalatestTester{
    "queueDeco lab6."  in {
     test (new queueDeco){ c =>
        c.io.in0.valid.poke(1.B)
        c.io.in0.bits.poke(26.U)
        // c.io.in1.valid.poke(1.B)
        // c.io.in1.bits.poke(25.U)
        // c.io.in2.valid.poke(0.B)
        // c.io.in2.bits.poke(0.U)
        
        c.clock.step(1)

        c.io.out.ready.poke(1.B)

        // c.io.out.valid.expect(1.B)
        // c.io.out.bits.expect(24.U)
        
        c.clock.step(50)
        }
    }
}