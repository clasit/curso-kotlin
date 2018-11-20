import alumnos.Alumno
import alumnos.Cientifico
import temarios.Temario


fun main(args: Array<String>) {
    val javier: Alumno = Alumno("Javier", "Lopez", 24)
    val maria: Alumno = Alumno("Maria", "Gomez", 34)
    val pedro: Alumno = Alumno("Pedro", "García", 46)


    val jaime: Cientifico = Cientifico("Jaime", "Rodrigo", 24, listOf(9.0, 6.5))
    val sandra: Cientifico = Cientifico("Sandra", "Gimenez", 24, listOf(9.0, 6.0))


    // Se pueden añadir los alumno "Científicos" a la lista de "Alumnos"
    val alumnos = listOf<Alumno>(javier, maria, pedro, jaime, sandra)
    val alumnosCientificos = listOf<Cientifico>(jaime, sandra)


    // ===========================================================================
    println( "${jaime.nombre} ${jaime.notaMedia()}" )
    println( "${sandra.nombre} ${sandra.notaMedia()}" )

    var acum = 0.0
    for (alumno in alumnosCientificos) {
        acum += alumno.notaMedia()
    }
    println(acum / alumnosCientificos.size)
    // ===========================================================================


    for (alumno in alumnos) {
        alumno.estudiar(Temario("Kotlin", 8))
        println()
    }

    println(alumnos.get(0).edad)


    // alumnos.get(0).trabajo()
    // javier.trabajo()

    jaime.notaMedia()
    // alumnos.get(4).notaMedia()
}