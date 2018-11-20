
fun main() {

    //==================================================================
    // Funciones Lamda
    //==================================================================

    // Los parentesis definen una 'sequence'. Una sequencia del 1 al 100.
    // Se hace un cast de sequencia a una lista
    val items = (1..100).toList()

    for (numero in items) {
        println(numero)
    }



    //==================================================================
    // Funciones Lamda
    //==================================================================

    // Ejemplo 1:
    val sumarL: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    var resultado = sumarL(12, 5)
    println("Resultado Suma = ${ resultado }")


    // Ejemplo 2: Sin inferencia de tipos
    val sumar2: (Int, Int) -> Int = { x: Int, y: Int -> x + y }


    // Ejemplo 3:
    val resta: (Int, Int) -> Int
    resta = ::restar                // (!) Con los '::' se puede 'apuntar' a una función. Se inyecta la función
    resultado = resta(10, 5)
    println("Resultado Resta= ${ resultado }")


    // Ejemplo 4: A procesar le podemos asignar cualquier función que tenga la misma 'signature' (Int, Int) -> Int
    var procesar: (Int, Int) -> Int
    procesar = ::sumar      // Se hace referencia a una función
    resultado = procesar(10 , 10)
    println("Resultado Procesar (sumar) = ${ resultado }")

    procesar = resta        // Se hace referencia a una variable que a su vez hace referencia a una función
    resultado = procesar(10 , 10)
    println("Resultado Procesar (restar) = ${ resultado }")


    // Ejemplo 5
    val printResult: (String) -> Unit = { m -> println(m) }
    printResult("Soy una función Lamda que imprime un mensaje")

    val printResult2 = {println("Soy una función Lamda que no recibe parámetros") }
    printResult2()


    // Ejemplo 6
    val items2 = (1..1000).toList()

    // A map se le pasa la dirección de la función cuadrado
    var cuadrados = items.map(::cuadrado)
    println(cuadrados)


    // Ejemplo 7: Simplificación usando una función Lamda
    cuadrados = items.map({x: Int -> x*x})
    println(cuadrados)


    // Ejemplo 8: Simplificando usando la palabra reservada 'it'
    cuadrados = items.map({it * it})
    println(cuadrados)


    // Ejemplo 9: Simplificación máxima. Como map sólo recibe un argumento, se puede dejar así de simple.
    cuadrados = items.map{it * it}
    println(cuadrados)


    // Ejemplo 10: Se concatena 'take' (selecciona los 5 primero elementos) a 'map'
    cuadrados = items.take(5).map{it * it}
    println(cuadrados)


    // Ejemplo 11: Filtado de elementos de una colección
    var pares: List<Int> = items.filter{ it%2 == 0 }
    println(pares)


    // Ejemplo 12: Ejecución de una función a la que le pasamos

    // Opción 1
    descargarDatosInternet("http://...", { println("Operación finalizada") })

    // Opción 2: Se puede simplificar, sacando la Lamda
    descargarDatosInternet("http://...") { println("Operación finalizada") }


    // Ejemplo 13: Multiplicar sólo los números pares x2
    var funcionMultiplicaPares = { x: Int -> if (x%2 == 0) 2*x else x }
    var multiplicarPares =  items.map( funcionMultiplicaPares )
    println(multiplicarPares)
}


fun restar(x: Int, y: Int ): Int = x - y
fun sumar(x: Int, y: Int ): Int = x + y
fun cuadrado(x: Int): Int = x * x
fun par(x: Int): Boolean = x%2 == 0


// Función de tipo "High Order". Una función que recibe otra función como parámetro
fun descargarDatosInternet(url: String, operacionCompleta:() -> Unit) {

    // Simulación de descarga de datos
    operacionCompleta()
}