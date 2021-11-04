package lab7
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class FSM1test extends FreeSpec with ChiselScalatestTester{
    "FSM1 6s lab7" in  {
        test (new FSM1){c=>
        c.io.f1.poke(0.B)
        c.io.f2.poke(1.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(0.B)


        c.clock.step(50)
        }
    }
}