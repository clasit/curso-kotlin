package alumnos

import temarios.Temario


// La palabra open, ex para que se pueda extender de la clase Persona
open class Persona(val nombre: String, val apellido: String, var edad: Int?) {

    init {
        println("Iniciada la clase Persona")
    }

    fun saludar() {
        println("Hola, soy alumno")      // NOTA: El this es opcional
    }
}



// Al pasar loc parámetros indicando 'var' o 'val' se definen como atributos de la clase
open class Alumno(nombre: String, apellido: String, edad: Int?): Persona(nombre, apellido, edad) {

    // El bloque de inicialización se ejecuta ANTES que el constructor
    init {
        println("Iniciada la clase Alumno")
    }

    // Se puede hacer sobrecarga de constructores.
    // con this(nombre, apellido) se llama al constructor primario
    /* constructor(nombre: String, apellido: String, edad: Int): this(nombre, apellido) {
        this.edad = edad
    } */

    // Con 'open' se permite el 'override'
    open fun estudiar(temario: Temario) {
        print("Estudiando... ${temario.contenido}. ")
    }
}



class Cientifico(nombre: String, apellido: String, edad: Int, var notas: List<Double>): Alumno(nombre, apellido, edad) {

    fun trabajo() {
        println("Ciencias")
    }

    fun notaMedia(): Double {

        // FORMA 1
        return notas.sum() / notas.size

        // FORMA 2
        // return notas.reduce{ acc, it -> acc + it } / notas.size

        // FORMA 3
        /* var total = 0.0
        for(nota in notas) {
            total += nota
        }
        return total / notas.size */
    }

    override fun estudiar(temario: Temario) {
        // Ejemplo de copia con asignación: --------------------
        // val temarioCopia: Temario = temario.copy(version = 7)
        // -----------------------------------------------------
        super.estudiar(temario)
        print("Estudio del método científico!")
    }
}