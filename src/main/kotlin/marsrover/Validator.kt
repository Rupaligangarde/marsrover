package marsrover

import marsrover.model.Plateau
import marsrover.model.Position

class Validator {
    fun validateLocation(plateau: Plateau, position: Position): Boolean {
        return position.coordinate.x < plateau.coordinate.x && position.coordinate.y < plateau.coordinate.y
    }
}
