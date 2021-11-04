package lab8
import org.scalatest._
import chiseltest._
import chisel3._

class Forwardingtest extends FreeSpec with ChiselScalatestTester{
    "FMem2 lab8" in  {
        test (new Forwarding){c=>
        // c.io.enable.poke(1.B)
        c.io.wr_en.poke(1.B)
        c.io.wrAddr.poke(10.U)
        c.io.wrData.poke(55055.U)
        c.clock.step(1)
        c.io.wrAddr.poke(16.U)
        c.io.wrData.poke(555.U)
        c.clock.step(1)
        c.io.rdAddr.poke(10.U)
        c.clock.step(1)
        c.io.rdAddr.poke(16.U)
        c.clock.step(1)
        // c.io.mask.poke(2.U)
        // c.io.mask(1).poke(1.B)
        // c.io.mask(2).poke(0.B)
        // c.io.mask(3).poke(0.B)
        
        
        // c.io.dataIn(1).poke(5.U)
        // c.io.dataIn(2).poke(3.U)
        // c.io.dataIn(3).poke(8.U)
        c.clock.step(50)
        }
    }
}