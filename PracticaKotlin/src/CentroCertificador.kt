import alumnos.Cientifico

class CentroCertificador {
    companion object {
        fun obtenerAprobados(alumos: List<Cientifico>): List<Cientifico> {
            return alumos.filter { it.notaMedia() >= 8  }
        }
    }
}