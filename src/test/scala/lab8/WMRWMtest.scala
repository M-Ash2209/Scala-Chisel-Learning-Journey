package lab8
import org.scalatest._
import chiseltest._
import chisel3._

class WMRWMtest extends FreeSpec with ChiselScalatestTester{
    "Mem1 lab8" in  {
        test (new WMaskedReadWriteSmem){c=>
        c.io.enable.poke(1.B)
        c.io.write.poke(1.B)
        c.io.addr.poke(10.U)
        c.io.mask.poke(2.U)
        // c.io.mask(1).poke(1.B)
        // c.io.mask(2).poke(0.B)
        // c.io.mask(3).poke(0.B)
        c.io.dataIn.poke(555.U)
        // c.io.dataIn(1).poke(5.U)
        // c.io.dataIn(2).poke(3.U)
        // c.io.dataIn(3).poke(8.U)
        c.clock.step(50)
        }
    }
}