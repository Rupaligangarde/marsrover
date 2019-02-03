import marsrover.*
import marsrover.model.Coordinate
import marsrover.model.Plateau
import marsrover.model.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ValidatorTest {
    @Test
    fun shouldCheckIfRoversLocationIsWithinPlateau() {
        val plateau = Plateau(Coordinate(5, 5))
        val position = Position(Coordinate(1, 2), Direction.valueOf("N"))
        Assertions.assertTrue(Validator().validateLocation(plateau, position))
    }
}