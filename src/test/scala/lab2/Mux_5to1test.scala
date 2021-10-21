package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class Mux_5to1test extends FreeSpec with ChiselScalatestTester{
        "Mux 5to1 " in  {
        test (new Mux_5to1()){ c => 
        c.io.s0.poke(1.B)
        c.io.s1.poke(0.B)
        c.io.s2.poke(0.B)
        c.io.out.expect(8.U)      

        c.clock.step(100)
        }
    }
}
