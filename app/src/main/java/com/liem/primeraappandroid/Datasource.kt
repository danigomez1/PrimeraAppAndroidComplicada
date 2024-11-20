package com.liem.primeraappandroid

object Datasource {

    val alumnes = ArrayList<AlumneModel>()

    init {
        alumnes.add(AlumneModel("Dani", 21, "2n DAM"))
        alumnes.add(AlumneModel("Juan", 20, "1r DAM"))
        alumnes.add(AlumneModel("Paquito", 17, "1r SMX"))
        alumnes.add(AlumneModel("Mortadelo", 16, "2n SMX"))
    }

    fun addAlumne(nom: String, edat: Int, curs: String) {
        alumnes.add(AlumneModel(nom, edat, curs))
    }

    fun getAlumneFromCurs(curs: String): ArrayList<AlumneModel> {
        val alumnesCursSelec = ArrayList<AlumneModel>()
        for (alumne in alumnes) {
            if (alumne.curs == curs) {
                alumnesCursSelec.add(alumne)
            }
        }
        return alumnesCursSelec
    }
}