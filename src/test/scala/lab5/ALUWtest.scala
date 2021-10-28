package lab5
import chisel3 . _
import chisel3 . util
import org . scalatest . _
import chiseltest . _
import scala . util . Random
import ALUOP._

class ALUWtest extends FreeSpec with ChiselScalatestTester {
    "ALU param Test" in {
        test ( new ALUW(32) ) { c =>
        // ALU operations
            val array_op = Array ( ADD , SLL , SLT , SLTU , XOR , SRL ,
            OR , AND , SUB , SRA )
            for ( i <- 0 until 100) {
                // println(s"*********$i**********")
                val src_a = Random . nextLong () & 0xFFFFFFFFL
                val src_b = Random . nextLong () & 0xFFFFFFFFL
                val opr = Random . nextInt (10)
                val aluop = array_op ( opr )
                println(s"*********$i**********")
                println(s"*********$opr**********")
                println(s"*********$src_a**********")
                println(s"*********$src_b**********")
                val result = aluop match {
                    case ADD => src_a.toInt + src_b.toInt
                    case SLL => src_a.toInt << ( src_b.toInt & 0x1F )
                    case SLT => if ( src_a . toInt < src_b . toInt )
                                            1
                                else
                                            0
                    case SLTU => if ( src_a < src_b)
                                            1
                                else
                                            0
                    case XOR => src_a.toInt ^ src_b.toInt 
                    case SRL => src_a.toInt >> ( src_b & 0x1F )
                    case OR => src_a.toInt | src_b.toInt 
                    case AND => src_a.toInt & src_b.toInt
                    case SUB => src_a.toInt - src_b.toInt
                    case SRA => src_a . toInt >> ( src_b & 0x1F )
                    // case BEQ => if ( src_a . toInt == src_b . toInt )
                    //                         1
                    //             else
                    //                         0
                    // case BNE => if ( src_a . toInt != src_b . toInt )
                    //                         1
                    //             else
                    //                         0
                    // case BLT => if ( src_a . toInt < src_b . toInt )
                    //                         1
                    //             else
                    //                         0
                    // case BGE => if ( src_a . toInt > src_b . toInt || src_a . toInt == src_b . toInt )
                    //                         1
                    //             else
                    //                         0
                    // case BLTU => if ( src_a < src_b)
                    //                         1
                    //             else
                    //                         0

                    // case ALU_COPY_A => src_a
                    // case ALU_COPY_B => src_b
                    case _ => 0

                }
                // val brn = if (result ==1 & (opr == 10 |opr == 11 |opr == 12 |opr == 13 |opr == 14))
                //                         1
                // else 
                //                         0
                // val result1 : BigInt = if ( result < 0)
                //     ( BigInt(0xFFFFFFFFL ) + result +1 ) & 0xFFFFFFFFL
                
                // else (result & 0xFFFFFFFFL)
                

                    c . io . arg_x . poke ( src_a . S )
                    c . io . arg_y . poke ( src_b . S )
                    c . io . alu_oper . poke ( aluop )
                    c . clock . step (1)
                    // c . io . out1 . expect ( brn.B)
                    c . io . alu_out . expect ( result.S)
                
            }
            c . clock . step (200)
        }
    }
}
