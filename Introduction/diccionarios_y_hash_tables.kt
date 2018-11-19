// Ejemplo diccionarios y hash tables

fun main() {
	val alumnos = mapOf("111111111H" to "Amparo", 
                              "222222222H" to "Belén", 
                              "333333333H" to "Carla", 
                              "444444444H" to "Davinia")
    
    println(alumnos.keys)
    println(alumnos.values)
    
    val resultado: String = buscarAlumnosPorDni("333333333H", alumnos) ?: ""
    println( resultado )
    
    
    // =====================================================================
    // MAPA MUTABLE
    
    println("=====================================================================")    
    val alumnosMutable = hashMapOf("111111111H" to "Amparo", 
                              "222222222H" to "Belén", 
                              "333333333H" to "Carla", 
                              "444444444H" to "Davinia")
    
    alumnosMutable.put("555666777K", "David")
    println(alumnosMutable)
}


fun buscarAlumnosPorDni(dni: String, alumnos: Map<String, String>): String {
    // return alumnos[dni]
    // return alumnos.get(dni)
    return alumnos.getOrDefault(dni, "No encontrado")
}