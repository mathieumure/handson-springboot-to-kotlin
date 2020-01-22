fun createPokemon(name: String, type: List<String>) =
    Pokemon("Pokemon $name", type)

fun createPokemon() = Pokemon()

interface Animal {
    fun sayMyName(): String
}

class Pokemon(
    var name: String = "Any pokemon",
    var types: List<String> = listOf(),
    var level: Int = 1
): Animal {
    fun raise() {
        level++
    }

    override fun sayMyName() = name
}

var mathieu = createPokemon("Mathieu", listOf("Terre", "Air", "Feu"))
mathieu = createPokemon("Olivier", listOf("Feu", "Terre", "Air"))
// ou mathieu = createPokemon()

println(mathieu.name)
mathieu.name = "quelque chose d'autre" // Fonction car "var name: String", et non val
println(mathieu.name)

println(mathieu.level)
mathieu.raise()
println(mathieu.level)

// Afficher les types du pokemon par le 3ème caractère "it[2]"
println(mathieu.types.sortedBy { it[2] })

// Transformer la liste en une String séparée par des ","
println(mathieu.types.toExcel())
fun List<String>.toExcel() : String {
    return this.joinToString(",")
}
