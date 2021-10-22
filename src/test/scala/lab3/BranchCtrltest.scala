// package lab3
// import org.scalatest._
// import chiseltest._
// import chisel3._
// import chisel3.util._

// class BranchCtrltest extends FreeSpec with ChiselScalatestTester{
//     "Branching" in  {
//         test (new BranchCtrl){ c =>
//         c.io.branch.poke(0.B)
//         c.io.y.poke(12.S)
//         c.io.x.poke(12.S)
      
//         c.io.sel.poke(16.U)
//         c.io.br_taken.expect(1.B)
//         c.io.out.expect(1.S) 
//         //c.alu.io.out1.expect(1.B)     
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

class BranchCtrltest extends FreeSpec with ChiselScalatestTester {
    "Branching " in {
        test ( new BranchCtrl ) { c =>
        // ALU operations
            // val array_op = Array ( ALU_ADD , ALU_SUB , ALU_AND , ALU_OR , ALU_XOR , ALU_SLT ,
            // ALU_SLL , ALU_SLTU , ALU_SRL , ALU_SRA , ALU_COPY_A , ALU_COPY_B , ALU_XXX )
            for ( i <- 0 until 100) {
                // println(s"*********$i**********")
                val src_a = Random . nextLong () & 0xFFFFFFFFL
                val src_b = Random . nextLong () & 0xFFFFFFFFL
                val opr = Random . nextInt (24)
                val brc = Random . nextInt (1)
                println(s"*********$i**********")
                println(s"*********$opr**********")
                println(s"*********$brc**********")
                println(s"*********$src_a**********")
                println(s"*********$src_b**********")
                

                    c . io . x . poke ( src_a . S )
                    c . io . y . poke ( src_b . S )
                    c . io . sel. poke ( opr.U )
                    c . io . branch. poke ( brc.B )
                    c . clock . step (1)
                    // c . io . out . expect ( result1.U )
                
            }
            c . clock . step (200)
        }
    }
}