package exmp
import org.scalatest._
import chiseltest._
import chisel3._

class Addtest extends FreeSpec with ChiselScalatestTester{

    "Adder Test" in {
        test (new Add()){ c=> 
        c.io.a.poke("b1".U)
        c.io.b.poke("b1".U)
        c.io.cin.poke("b0".U)
        c.clock.step(1)
        //c.io.otp.expect("b1".U)
        //c.io.cout.expect("b1".U)
        c.clock.step(10)

        }
    }
}