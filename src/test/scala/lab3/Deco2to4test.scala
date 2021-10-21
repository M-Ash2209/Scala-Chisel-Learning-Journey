package lab3
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class Deco2to4test extends FreeSpec with ChiselScalatestTester{
    "Decoder"  in {
     test (new Deco2to4()){ c =>
        c.io.in.poke("b00".U)
        c.io.out.valid.expect(1.B)
      
         
        c.clock.step(100)
        }
    }
}