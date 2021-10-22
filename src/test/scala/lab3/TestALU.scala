package lab3
import chisel3 . _
import chisel3 . util
import org . scalatest . _
import chiseltest . _
import chiseltest . experimental . TestOptionBuilder . _
import chiseltest . internal . VerilatorBackendAnnotation
import scala . util . Random

class TestALU extends FreeSpec with ChiselScalatestTester {
    "ALUTest" in {
        test ( new ALU ) { c =>
        // ALU operations
            // val array_op = Array ( ALU_ADD , ALU_SUB , ALU_AND , ALU_OR , ALU_XOR , ALU_SLT ,
            // ALU_SLL , ALU_SLTU , ALU_SRL , ALU_SRA , ALU_COPY_A , ALU_COPY_B , ALU_XXX )
            for ( i <- 0 until 100) {
                // println(s"*********$i**********")
                val src_a = Random . nextLong () & 0xFFFFFFFFL
                val src_b = Random . nextLong () & 0xFFFFFFFFL
                val opr = Random . nextInt (32)
                println(s"*********$i**********")
                println(s"*********$opr**********")
                println(s"*********$src_a**********")
                println(s"*********$src_b**********")
                

                    c . io . a . poke ( src_a . S )
                    c . io . b . poke ( src_b . S )
                    c . io . select . poke ( opr.U )
                    c . clock . step (1)
                    // c . io . out . expect ( result1.U )
                
            }
            c . clock . step (200)
        }
    }
}