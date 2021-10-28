package lab5
import org.scalatest._
import chiseltest._
import chisel3._

class Routertest extends FreeSpec with ChiselScalatestTester{
    "Router sys" in  {

        test (new Router(SInt(32.W))){ c =>
        c.io.in.add.poke(44.U)
        c.io.in.data.poke(54.S)
        c.io.out.add.expect(44.U)
        c.io.out.data.expect(54.S)
        c.clock.step(100)
        }
    }
}