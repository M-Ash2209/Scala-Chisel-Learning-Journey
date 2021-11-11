package lab8
import org.scalatest._
import chiseltest._
import chisel3._

class memoryasstest extends FreeSpec with ChiselScalatestTester{
    "Arbitor Memory lab8" in  {
        test (new memory_assignment){c=>
        c.io.requestor(0).bits.poke(24.U)
       
        c.io.requestor(0).valid.poke(1.B)
        c.io.requestor(1).bits.poke(4.U)
        c.io.requestor(3).bits.poke(6.U)
        
        c.io.requestor(1).bits.poke(7.U)
        c.io.requestor(2).bits.poke(5.U)
        c.io.requestor(3).bits.poke(6.U)
        
        c.io.requestor(1).valid.poke(1.B)
        c.io.requestor(2).valid.poke(1.B)
        c.io.requestor(3).valid.poke(1.B)
        c.io.Readaddr.poke(8.U)
        c.io.Writeaddr.poke(8.U)
        c.io.enable.poke(1.B)
        
        c.clock.step(50)}}}