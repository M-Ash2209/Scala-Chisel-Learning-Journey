package lab6
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class counterWithXORtest extends FreeSpec with ChiselScalatestTester{
    "counter XOR lab6."  in {
     test (new counterWithXOR){ c =>
        
        
        // c.io.out.expect(4.U)
        
        c.clock.step(50)
        }
    }
}