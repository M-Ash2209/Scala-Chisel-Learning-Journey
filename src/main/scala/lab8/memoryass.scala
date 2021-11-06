package lab8
import chisel3._
import chisel3.util._

class memory_assignment extends Module {
    val io = IO (new Bundle {
    val memory_out = Vec (4 , Output ( UInt (32. W ) ) )
    val requestor = Flipped (Vec(4,Decoupled ( UInt (32. W ) ) ) )
    val enable = (Bool())
    val Readaddr = Input ( UInt (5. W ) )
    val Writeaddr = Input ( UInt (5. W ) )
    // val out = Decoupled ( UInt (32. W ) ) 
    })
    val Memory = Mem (32 , UInt (32. W ) )
    val queue0 = Queue (io.requestor(0),2)
    val queue1 = Queue (io.requestor(1),2)
    val queue2 = Queue (io.requestor(2),2)
    val queue3 = Queue (io.requestor(3),2)
    queue0.nodeq()
    queue1.nodeq()
    queue2.nodeq()
    queue3.nodeq()
  

    val arbi = Module (new Arbiter(UInt(),2))
    arbi.io.in(0)<>queue0
    arbi.io.in(1)<>queue1
    arbi.io.in(2)<>queue2
    arbi.io.in(3)<>queue3
    io.memory_out <> arbi.io.out
    // val output = arbi.io.out
    // when(io.enable){
    // Memory.write(io.Writeaddr,output.asUInt)
    // }
    // io.memory_out := Memory.read(io.Readaddr)



}