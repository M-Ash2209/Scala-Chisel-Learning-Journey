package lab5
import chisel3._
import chisel3.util._

// your code for Transaction_in class
// your code for Transaction_out class
class Packet [ T <: Data ]( gen : T ) extends Bundle{
    val data = gen
    val add = UInt(32.W)
  
}
class Router [ T <: Data ]( gen : T ) extends Module {
   val io = IO(new Bundle{
       val in = Input(new Packet(gen))
       val out = Output(new Packet(gen))
   })
    io.in<>io.out
}