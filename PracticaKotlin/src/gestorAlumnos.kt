import alumnos.Alumno

// Declaración de un objeto singleton.
// Se "instancia" una vez y ya lo tenemos para toda la aplicación
object gestorAlumnos {

    var alumnos: ArrayList<Alumno>? = null
    get() = field
    set(als: ArrayList<Alumno>?) {
        if (als !== null) {
            field = als
        }
    }

    fun buscarAlumno(): Alumno? {
        println("Buscando alumno...")
        return null
    }

    fun registrarAlumno(alumno: Alumno) {
        println("Registrando alumno...")

        // Operador 'Call save' para evitar un "Null pointer excepction"
        alumnos?.add(alumno)
    }
}