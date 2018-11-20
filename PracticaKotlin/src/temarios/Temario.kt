package temarios

// Es un data class, lo que es el equivalente a POJO (Clases que sólo contienen datos)
// Una clase "data class" importa métodos por defecto, por ejemplo toString()
// ¿Cuando usar data class?
data class Temario(val contenido: String, val version: Int) {
}