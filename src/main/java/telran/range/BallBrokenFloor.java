package telran.range;

import java.util.Random;

public class BallBrokenFloor {
    int nFloors;
    int minBrokeFloor;

    public BallBrokenFloor(int nFloors) {
        this.nFloors = nFloors;
        minBrokeFloor = new Random().nextInt(1, nFloors + 1);
    }

    public void checkFloor(int floor) throws Exception {
        if (floor > nFloors) {
            throw new IllegalArgumentException();
        }
        if (floor >= minBrokeFloor) {
            throw new Exception("Ball is broken");
        }

    }
    public int getMinBrokenFloor() {
        //used only for testing
        return minBrokeFloor;
    }
}
