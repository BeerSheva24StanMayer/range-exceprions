package telran.range;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

public class BrokenFloorTest {
    private int getMinimalBrokenFloor(BallBrokenFloor bbf) {
        int dFloor = 1;
        int upFloor = Integer.MAX_VALUE;
        int minFloor = -1;
        while (dFloor <= upFloor) {
            int midFloor = upFloor - (upFloor - dFloor) / 2;
            try {
                bbf.checkFloor(midFloor);
                dFloor = midFloor + 1;
            } catch (IllegalArgumentException e) {
                upFloor = upFloor / 2;

            } catch (Exception e) {
                minFloor = midFloor;
                upFloor = midFloor - 1;
            }
        }
        return minFloor;
    }

    @Test
    void minimalBrokenFloorTest() {
        int[] floors = { 200, 17, 1001, 2000 };
        for (int i = 0; i < floors.length; i++) {
            BallBrokenFloor bbf = new BallBrokenFloor(floors[i]);
            assertEquals(bbf.getMinBrokenFloor(), getMinimalBrokenFloor(bbf));
        }
    }
}
