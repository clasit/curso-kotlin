// Ejemplo colecciones

fun main() {    
	val alumnos = listOf("Amparo", "Beronica", "Carlos", "David", "Emma", "Francisco")
    println(alumnos[0])
    
    val isAmparo: Boolean  = alumnos.contains("Amparo")
    println(isAmparo)
    
    // Ordenar
    println(alumnos.sorted())
    
    // Recorrer elementos
	println("${listarAlumnos(alumnos)}")
    
    
    // ==============================================================================
    // Ejemplo de extructura mutable
    
   	val alumnosMutable = arrayListOf("Amparo", "Beronica", "Carlos", "David", "Emma", "Francisco")
    println("==============================================================================")
    addAlumno("Jesús", alumnosMutable)
    println(alumnosMutable)
    
    println("==============================================================================")
    delAlumno("Amparo", alumnosMutable)
    println(alumnosMutable)
}


fun listarAlumnos(alumnos: List<String>): Unit {
    for (alumno in alumnos) {
        println(alumno)
    }
}


fun addAlumno(nuevoAlumno: String, alumnos: ArrayList<String>?): Unit {
    if ( nuevoAlumno == null || nuevoAlumno.length == 0 ) {
        return    	
    }
    alumnos?.add(nuevoAlumno);		// Con el '?' ejecutará sólo 'add' si alumnos NO es null
}


fun delAlumno(nuevoAlumno: String, alumnos: ArrayList<String>?): Unit {
    if ( nuevoAlumno == null || nuevoAlumno.length == 0 ) {
        return    	
    }
    alumnos!!.remove(nuevoAlumno);	// '!!' Asegura que nunca será null. Evitamos el checking de null
}									// En algunos casos si que lo sabemos