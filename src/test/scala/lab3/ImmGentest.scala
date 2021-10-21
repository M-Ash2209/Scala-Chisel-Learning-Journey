package lab3
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class ImmGentest extends FreeSpec with ChiselScalatestTester{
    "Immediate Gen" in  {
        test (new ImmGen){ c =>
        
        c.io.PC.poke(12.U)
        c.io.instr.poke(239848.S)
      
         
        c.clock.step(100)
        }
    }
}