package telran.range;

import telran.range.exceptions.OutOfRangeMaxValueException;
import telran.range.exceptions.OutOfRangeMinValueException;

public class RangeProcessor {
    private Range range;
    private int counterOfGreaterMax;
    private int counterOfLessMin;
    private int counterOfrightNumbers;

    public RangeProcessor(Range range) {
        this.range = range;
    }

    public void processNumber(int Number) {
        try {       
            range.checkNumber(Number);
            counterOfrightNumbers++;
        }
        catch (OutOfRangeMaxValueException e) {
            //TODO: handle exception
            counterOfGreaterMax++;
        }
        catch (OutOfRangeMinValueException e) {
            //TODO: handle exception
            counterOfLessMin++;
        }
    }
    public int getCounterOfGreaterMax() {
        return counterOfGreaterMax;
    }
    public int getCounterOfLessMin() {
        return counterOfLessMin;
    }
    public int getCounterOfRightNumber() {
        return counterOfrightNumbers;
    }
}

