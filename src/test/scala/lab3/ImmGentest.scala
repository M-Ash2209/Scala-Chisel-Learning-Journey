// package lab3
// import org.scalatest._
// import chiseltest._
// import chisel3._
// import chisel3.util._

// class ImmGentest extends FreeSpec with ChiselScalatestTester{
//     "Immediate Gen" in  {
//         test (new ImmGen){ c =>
        
//         c.io.PC.poke(12.U)
//         c.io.instr.poke(239848.S)
      
         
//         c.clock.step(100)
//         }
//     }
// }

package lab3
import chisel3 . _
import chisel3 . util
import org . scalatest . _
import chiseltest . _
import chiseltest . experimental . TestOptionBuilder . _
import chiseltest . internal . VerilatorBackendAnnotation
import scala . util . Random

class ImmGentest extends FreeSpec with ChiselScalatestTester {
    "Imm.Gen " in {
        test ( new ImmGen ) { c =>
        // ALU operations
            // val array_op = Array ( ALU_ADD , ALU_SUB , ALU_AND , ALU_OR , ALU_XOR , ALU_SLT ,
            // ALU_SLL , ALU_SLTU , ALU_SRL , ALU_SRA , ALU_COPY_A , ALU_COPY_B , ALU_XXX )
            for ( i <- 0 until 100) {
                // println(s"*********$i**********")
                val src_ins = Random . nextLong () & 0xFFFFFFFFL
                val src_pc = Random . nextLong () & 0xFFFFFFFFL
            
                println(s"*********$i**********")
                
                println(s"*********$src_ins**********")
                println(s"*********$src_pc**********")
                

                    c . io . instr . poke ( src_ins . S )
                    c . io . PC. poke ( src_pc . U )
                    
                    c . clock . step (1)
                    // c . io . out . expect ( result1.U )
                
            }
            c . clock . step (200)
        }
    }
}