package lab3
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class ALUtest extends FreeSpec with ChiselScalatestTester{
    "ALU" in  {
        test (new ALU){ c =>
        c.io.a.poke(-8.S)
        c.io.b.poke(1.S)
      
        c.io.select.poke(5.U)
        c.io.out.expect(-4.S) 
       // c.io.out1.expect(1.B)     
        c.clock.step(100)
        }
    }
}