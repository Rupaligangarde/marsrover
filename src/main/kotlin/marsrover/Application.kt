package marsrover

import marsrover.model.Coordinate
import marsrover.model.Plateau
import marsrover.model.Position

fun main(args: Array<String>) {
    print("Enter plateau coordinates:")
    val plateauCoordinateValue = readLine()!!.split(" ")
    val plateau = Plateau(Coordinate(
            x = plateauCoordinateValue.first().toInt(),
            y = plateauCoordinateValue.last().toInt()
    ))

    print("Enter rover's position:")
    val roverLocation = readLine()!!.trim().split(" ")

    val roverPosition = Position(Coordinate(roverLocation.first().toInt(), roverLocation[1].toInt()), Direction.valueOf(roverLocation.last()))

    if (!Validator().validateLocation(plateau, roverPosition)) {
        print("Rover's Position should be within plateau!!")
        return
    }

    print("Enter series of instructions telling the rover how to explore the plateau:")
    val command = readLine()!!
    val marsRover = MarsRover(roverPosition)
    val resultedLocation = marsRover.execute(command)
     print("expected Location: ${resultedLocation.coordinate.x} ${resultedLocation.coordinate.y} ${resultedLocation.direction}")
}