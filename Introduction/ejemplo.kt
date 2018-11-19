import java.lang.Math.PI


fun main() {
    val a: Int = 10
    val b: Int = 15
    println("${sumar(a,b)}")
    println("${restar(a,b)}")
    println("${multiplicar(a,b)}")
    println("${dividir(a,b)}")

    // Invocaci�n por valores por defecto
    println("${restar(a = 10)}")

    // Named parameters. El orden no define los par�metros, sino el nombre
	val multiplicacion: Int = multiplicar( b = 20, a = 10)
    
    // Control de excepciones
    val division: Int? = dividir3(10, 0)
    println("${division}")
    
    
    // Ejemlo de "Elvis operator". Transformar� 'null' a 0.
   	val resultado: Int? = dividir3(10, 0) ?: 0
    println("${resultado}")

    // Ejemplo importaci�n constante matem�tica de una biblioteca de java
     println("${calcularPerimetroCircunferencia(10_000L)}")
}



fun sumar(a: Int, b: Int): Int = a + b


// Asignaci�n de valores por defecto
fun restar(a: Int, b: Int = 1): Int = a - b


fun multiplicar(a: Int, b: Int): Int = a * b


fun dividir(a: Int, b: Int): Int? {
    if( b != 0) {
    	return a / b
    }
    return null
}


// Simplificaci�n del m�todo dividir
fun dividir2(a: Int, b: Int): Int? = if( b != 0) a / b else null


// Controlar excepciones
fun dividir3(a: Int, b: Int): Int? {
    try {
		return a / b
    } catch ( ex: ArithmeticException ) {	// Excepci�n aritm�tica
        return null
    } catch ( ex: Exception ) {				// Excepci�n m�s gen�rica
        return null
    } finally {
        return null
    }
}


fun calcularPerimetroCircunferencia(radio: Int): Double = 2 * PI * radio



