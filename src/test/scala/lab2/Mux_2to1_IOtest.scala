package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class Mux_2to1_IOtest extends FreeSpec with ChiselScalatestTester{
    "Mux 2to1without construct" in  {
        test (new Mux2to1()){ c =>
        c.io.in_A.poke(5.U)
        c.io.in_B.poke(2.U)
        c.io.select.poke(0.B)
        c.clock.step(10)
        //c.io.out.expect(5.U)
        c.clock.step(100)
        }
    }
}


