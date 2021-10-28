package lab5
import org.scalatest._
import chiseltest._
import chisel3._

class AdderPtest extends FreeSpec with ChiselScalatestTester{
    "Router sys" in  {

        test (new AdderP(32)){ c =>
        c.io.in0.poke(45.S)
        c.io.in1.poke(55.S)
        c.io.sum.expect(100.S)
        
        c.clock.step(100)
        }
    }
}