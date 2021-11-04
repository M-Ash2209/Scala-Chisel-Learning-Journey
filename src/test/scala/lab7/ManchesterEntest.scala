package lab7
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3 . util . _

class ManchesterEntest extends FreeSpec with ChiselScalatestTester{
    "manchester lab7" in  {
        test (new ManchesterEn){c=>
        c.io.in.poke(1.U)
        c.io.start.poke(1.B)


        c.clock.step(50)
        }
    }
}