/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

fun main() {
    println("Hello, world!!!" + "Curso")
  
    var nombre: String = "Jesús"
    println(nombre)
    
    nombre = "Sandra"
    println("Mi nombre es ${nombre}")
    
    var a: Int = 2
    var b: Int = 10
    
    if( a == b) {
        println("${a} y ${b} son iguales");
    } else {
        println("${a} y ${b} son distintos");
    }
    
    
    val resultado: String = when(a) {
        1 -> "x es 1"
        2 -> "x es 2"
        in 2..10 -> "x está en el rango correcto"
        !in 15..20 -> "No está en este rango"
        else -> "Otro caso"
    }
    
    println("RESUMEN: $resultado")
    
    println("SUMA ${sumar(2, 2)}")
    
    fun verificaRango(n: Int): Boolean {
        return n in 5_000L..10_000L
    }
 
    println(verificaRango(5_999))
    
    iterar()
}


// Ejemplo de función
fun sumar(a: Int, b: Int): Int {
    return a + b
}


// Simplificación de función
fun restar(a: Int, b: Int): Int = a - b


// Extructuras iterativas
fun iterar(): Unit {
    
   // Rango
   for (x:Int in 1..10) {
       println(x)
   }
   
   // Rango con saltos
   for (x:Int in 1..10 step 2) {
       println(x)
   }
   
   // Bucle inverso
   for (x:Int in 10 downTo 1) {
       println(x)
   }
   
   // While
   var i: Int = 0
   while( i < 10) {
       println(i)
       i++
   }
}
	
