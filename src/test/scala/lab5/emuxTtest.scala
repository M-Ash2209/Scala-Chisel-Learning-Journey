package lab5
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class emuxTtest extends FreeSpec with ChiselScalatestTester{
    "EMUXT PARAM"  in {
     test (new emuxT){ c =>
        c.io.in1.poke(25.S)
        c.io.in2.poke(35.S)
        c.io.sel.poke(1.B)
        c.io.out.expect(25.S)
        // c.io.sel.poke(1.U)
        // }
        c.clock.step(50)
        }
    }
}