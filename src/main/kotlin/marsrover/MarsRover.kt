package marsrover

import marsrover.Direction.*
import marsrover.model.Coordinate
import marsrover.model.Position

class MarsRover(private val position: Position) {
    fun execute(commands: String): Position {
        var outputPosition = position
        commands.toCharArray().forEach { command ->
            when (command) {
                'L' -> {
                    outputPosition = turnLeft(outputPosition)
                }
                'R' -> {
                    outputPosition = turnRight(outputPosition)
                }
                'M' -> outputPosition = makeMove(outputPosition)
            }
        }
        return outputPosition
    }

    private fun turnRight(position: Position): Position {
        return Position(position.coordinate,Direction.right(position.direction))
    }

    private fun turnLeft(position: Position): Position {
        return Position(position.coordinate,Direction.left(position.direction))
    }

    private fun makeMove(position: Position): Position {
        var x = position.coordinate.x
        var y = position.coordinate.y
        when (position.direction) {
            E -> x += 1
            W -> x -= 1
            N -> y += 1
            S -> y -= 1
        }
        return Position(Coordinate(x, y), position.direction)
    }
}
