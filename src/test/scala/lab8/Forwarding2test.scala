package lab8
import org.scalatest._
import chiseltest._
import chisel3._

class Forwarding2test extends FreeSpec with ChiselScalatestTester{
    "FMem2 lab8" in  {
        test (new Forwarding2){c=>
        // c.io.enable.poke(1.B)
        c.io.wr_en.poke(1.B)
        c.io.addr(0).poke(10.U)
        c.io.dataIn(0).poke(55055.U)
        c.clock.step(1)
        c.io.addr(1).poke(10.U)
        c.io.dataIn(1).poke(555.U)
        c.clock.step(1)
        c.io.rdAddr(0).poke(10.U)
        c.clock.step(1)
        c.io.rdAddr(1).poke(16.U)
        c.clock.step(1)
        
        c.io.mask(0).poke(1.B)
        c.io.mask(1).poke(1.B)
        c.io.mask(2).poke(0.B)
        c.io.mask(3).poke(0.B)
        // c.io.dataIn(0).poke(555.U)
        // c.io.dataIn(1).poke(5.U)
        // c.io.dataIn(2).poke(3.U)
        // c.io.dataIn(3).poke(8.U)
        c.clock.step(50)
        }
    }
}

