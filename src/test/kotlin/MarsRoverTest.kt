import marsrover.MarsRover
import marsrover.model.Coordinate
import marsrover.Direction
import marsrover.model.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MarsRoverTest {
    @Test
    fun shouldExecuteLeftCommand() {
        val marsRover = MarsRover(Position(Coordinate(1, 2), Direction.N))
        val command = "L"

        val actualPosition = marsRover.execute(command)

        assertEquals(Direction.W, actualPosition.direction)
    }

    @Test
    fun shouldExecuteRightCommand() {
        val marsRover = MarsRover(Position(Coordinate(1, 2), Direction.N))
        val command = "R"

        val actualPosition = marsRover.execute(command)

        assertEquals(Direction.E, actualPosition.direction)
    }

    @Test
    fun shouldExecuteMoveCommand() {
        val marsRover = MarsRover(Position(Coordinate(1, 2), Direction.N))
        val command = "M"

        val expectedPosition = Position(Coordinate(1, 3), Direction.N)
        val expectedCoordinate = expectedPosition.coordinate

        val actualPosition = marsRover.execute(command).coordinate

        assertEquals(expectedCoordinate.y, actualPosition.y)

    }

    @Test
    fun shouldExecuteLeftThenRightCommand() {
        val marsRover = MarsRover(Position(Coordinate(1, 2), Direction.N))
        val command = "LL"

        val expectedPosition = Position(Coordinate(1, 2), Direction.S)

        val actualPosition = marsRover.execute(command)

        assertEquals(expectedPosition.direction, actualPosition.direction)

    }

    @Test
    fun shouldExecuteLeftThenRightThenMoveCommand() {
        val marsRover = MarsRover(Position(Coordinate(1, 2), Direction.N))
        val command = "LLM"

        val expectedPosition = Position(Coordinate(1, 1), Direction.S)

        val actualPosition = marsRover.execute(command)

        assertEquals(expectedPosition.coordinate.y, actualPosition.coordinate.y)
    }

    @Test
    fun shouldExecuteLMLMLMLMMCommand() {
        val marsRover = MarsRover(Position(Coordinate(1, 2), Direction.N))
        val command = "LMLMLMLMM"

        val expectedPosition = Position(Coordinate(1, 3), Direction.N)

        val actualPosition = marsRover.execute(command)

        assertEquals(expectedPosition.coordinate.x, actualPosition.coordinate.x)
        assertEquals(expectedPosition.coordinate.y, actualPosition.coordinate.y)
        assertEquals(expectedPosition.direction, actualPosition.direction)
    }

    @Test
    fun shouldExecuteMMRMMRMRRMCommand() {
        val marsRover = MarsRover(Position(Coordinate(3, 3), Direction.E))
        val command = "MMRMMRMRRM"

        val expectedPosition = Position(Coordinate(5, 1), Direction.E)

        val actualPosition = marsRover.execute(command)

        Assertions.assertEquals(expectedPosition.coordinate.y, actualPosition.coordinate.y)
    }
}