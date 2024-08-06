package telran.range;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.range.exceptions.OutOfRangeMaxValueException;

public class RangeTest {
    public static final int MIN = 50;
    public static final int MAX = 100;
    Range range = Range.getRange(MIN, MAX);
@Test
void wrongRangeCreatingTest() {
    assertThrowsExactly(IllegalArgumentException.class, () -> Range.getRange(MIN -1 , MAX));
}
// @Test
// void rightNumberTest() {
//     range.checkNumber(55);
// }
// @Test
// void wrongNumberTest() {
//     assertThrowsExactly(OutOfRangeMaxValueException.class, null, null);
// }
}
