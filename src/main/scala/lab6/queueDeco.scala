package lab6
import chisel3 . _
import chisel3 . util . _

class queueDeco extends Module {
    val io = IO ( new Bundle {
        val in0 = Flipped ( Decoupled ( UInt (8. W ) ) ) // valid = Input , ready = Output , bits = Input
        // val in1 = Flipped ( Decoupled ( UInt (8. W ) ) )
        // val in2 = Flipped ( Decoupled ( UInt (8. W ) ) )
        val out = Decoupled ( UInt (8. W ) )   // valid = Output , ready =Input , bits = Output
    })
    // io.in0.ready(1.B)
    // io.in1.ready(1.B)
    // io.in2.ready(1.B)
    val queue0 = Queue (io.in0)
    val queue1 = Queue (queue0)
    queue0.nodeq()
    queue1.nodeq()
    when ( queue1.valid && io.out.ready){
        io.out.enq(queue1.deq())
    }.otherwise{
        io.out.bits:=0.U
        io.out.valid:=0.U
    }

}