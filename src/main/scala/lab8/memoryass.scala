package lab8
import chisel3._
import chisel3.util._

class memory_assignment extends Module {
    val io = IO (new Bundle {
    val memory_out = Decoupled(UInt(32.W ))
    val requestor = Vec(4,Flipped(Decoupled ( UInt (32. W ) ) ) )
    val enable = Input(Bool())
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
  
    io.memory_out.valid:=1.B
    val arbi = Module (new Arbiter(UInt(),2))
    arbi.io.in(1)<>queue0
    arbi.io.in(0)<>queue1
    arbi.io.in(1)<>queue2
    arbi.io.in(1)<>queue3
    // io.memory_out<>arbi.io.out
    // arbi.io.out.ready :=1.B
    val output = arbi.io.out 
    output.ready :=1.B
    when(io.enable){
    Memory.write(io.Writeaddr,output.asUInt)
    }
    io.memory_out.bits := Memory.read(io.Readaddr)

}