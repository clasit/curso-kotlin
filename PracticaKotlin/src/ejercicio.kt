import alumnos.Cientifico

// ===========================================================================
// EJERCICIO
// - Crear 10 alumnos de tipo científico
// - Crear una clase CentroCertificador con un método
//   obtenerAprobados que devolverá los alumnos con 8 o más de media.
// - Se requiere un listado de los alumnos aprobados
// ===========================================================================

fun main(args: Array<String>) {
    val al1: Cientifico = Cientifico("Al1", "Al1", 24, listOf(5.5, 4.5))
    val al2: Cientifico = Cientifico("Al2", "Al2", 24, listOf(9.0, 8.0))

    val alumnos: ArrayList<Cientifico> = arrayListOf<Cientifico>(al1, al2)

    for(x in 1..10) {
        val nota1: Double = Math.random() * 10
        val nota2: Double = Math.random() * 10
        val al: Cientifico = Cientifico("Nombre$x", "Apellido$x", 24, listOf(nota1, nota2))
        alumnos.add(al)
    }

    CentroCertificador.obtenerAprobados(alumnos).forEach{
        println("${it.nombre} ${it.apellido} Nota: ${it.notaMedia()}")
    }
}