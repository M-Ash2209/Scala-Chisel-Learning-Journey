package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class Mux_8to1_IOtest extends FreeSpec with ChiselScalatestTester{
    "Mux 8to1 with construct" in  {
        test (new Mux_8to1_IO()){ c =>
        c.io.in0.poke(0.B)
        c.io.in1.poke(1.B)
        c.io.in2.poke(0.B)
        c.io.in3.poke(0.B)
        c.io.in4.poke(0.B)
        c.io.in5.poke(0.B)
        c.io.in6.poke(0.B)
        c.io.in7.poke(0.B)
        c.io.sel0.poke(0.B)  
        c.io.sel.poke(1.U)
        c.io.out.expect(1.B)      
        
        c.clock.step(100)
        }
    }
}


