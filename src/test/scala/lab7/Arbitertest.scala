package lab7
import org.scalatest._
import chiseltest._
import chisel3._

class Arbitertest extends FreeSpec with ChiselScalatestTester{
    "Arbiter lab7" in  {
        test (new Arbiter){c=>
        c.io.in(0).bits.poke(24.U)
        c.io.out.ready.poke(1.B)
        c.io.in(0).valid.poke(1.B)
        c.io.in(1).bits.poke(4.U)
        c.io.out.ready.poke(1.B)
        c.io.in(1).valid.poke(1.B)
        
        c.clock.step(50)
        }
    }
}