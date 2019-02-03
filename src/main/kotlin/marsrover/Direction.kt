package marsrover

enum class Direction {
    E,
    W,
    N,
    S;

    companion object {
        fun left(direction: Direction): Direction {
            return when (direction) {
                E -> N
                N -> W
                W -> S
                S -> E
            }
        }

        fun right(direction: Direction): Direction {
            return when (direction) {
                E -> S
                S -> W
                W -> N
                N -> E
            }
        }
    }
}