// package lab3
// import org.scalatest._
// import chiseltest._
// import chisel3._
// import chisel3.util._

// class ImmGentest extends FreeSpec with ChiselScalatestTester{
//     "Immediate Gen" in  {
//         test (new ImmGen){ c =>
        
//         c.io.PC.poke(12.U)
//         c.io.instr.poke("h03300293".U) 
//         c.io.out.expect(51.S)
      
         
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
        // IMM operations
            val array_ins = Array ( 53478035,5251619)
            for ( i <- 0 until 4) {
                // println(s"*********$i**********")
                val opr_ins =Random . nextInt(2)
                val src_ins = array_ins(opr_ins)

                val src_pc = Random . nextLong () & 0xFFFFFFFFL
                val result = src_ins match {
                    case 53478035 => 51
                    case 5251619 => 4
                }
            
                println(s"*********$i**********")
                println(s"*********$opr_ins**********")
                println(s"*********$src_ins**********")
                println(s"*********$src_pc**********")
                

                c . io . instr . poke ( src_ins.U)
                c . io . PC. poke ( src_pc . U )    
                c . clock . step (1)
                c . io . out . expect ( result.S )
                
            }
            c . clock . step (200)
        }
    }
}