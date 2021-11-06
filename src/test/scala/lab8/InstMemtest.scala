package lab8
import org.scalatest._
import chiseltest._
import chisel3._

class InstMemtest extends FreeSpec with ChiselScalatestTester{
    "IMem lab8" in  {
        test (new InstMem){c=>
        
        c.io.addr.poke(1.U)
        c.io.inst.expect(1049235.U)
        // c.io.wrData.poke(55055.U)
        c.clock.step(50)
        }
    }
}