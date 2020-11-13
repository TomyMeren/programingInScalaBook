package bobsrockets {
  class Shipp
}

package bobsrockets.fleets {
  class Fleett {
    // Doesn't compile! Ship is not in scope.
    def addShip() = { new bobsrockets.Ship }
  }
}
