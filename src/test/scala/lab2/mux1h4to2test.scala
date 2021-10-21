package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class mux1h4to2test extends FreeSpec with ChiselScalatestTester{
    "Mux Encoder" in  {
        test (new mux1h4to2()){ c =>
        c.io.in0.poke(3.U)
        c.io.in1.poke(1.U)
        c.io.in2.poke(5.U)
        c.io.in3.poke(2.U) 
        c.io.sel0.poke(4.U)
        c.io.sel.poke(1.U)
        c.io.out.expect(3.U)      
        c.io.out0.expect(5.U)
        c.clock.step(100)
        }
    }
}


