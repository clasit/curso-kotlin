package temarios


// Es un data class, lo que es el equivalente a POJO (Clases que sólo contienen datos)
// Una clase "data class" importa métodos por defecto, por ejemplo toString()
// ¿Cuando usar data class?
data class Temario(val contenido: String, val version: Int): Imprimible, Persistente {

    override fun persistir() {
        println("Persistiendo datos...")
    }

    override fun imprimir() {
        println("Imprimiendo doc...")
    }
}

// NOTA: Por defecto todos los métodos una clase son abstractos
interface Imprimible {
    fun imprimir()
}


interface Persistente {
    fun persistir()
}