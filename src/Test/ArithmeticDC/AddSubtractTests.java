package ArithmeticDC;

import DataClass.CompoundDataClassBrick;
import DataClass.PrimitiveDataClassBrick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddSubtractTests {
  ArithmeticDCHolder arithmeticDCHolder = new ArithmeticDCHolder();
  CompoundDataClassBrick arithmeticDCB;
  CompoundDataClassBrick addSubtractDCB;
  PrimitiveDataClassBrick addOp1DCB;
  PrimitiveDataClassBrick addOp2DCB;
  PrimitiveDataClassBrick sumDCB;

  @BeforeEach
  void setupDCBs() {
    ArithmeticDC arithmeticDC = arithmeticDCHolder.arithmeticDC;
    AddSubtractDC addSubtractDC = arithmeticDCHolder.addSubtractDC;
    WholeNumberDC wholeNumberDC = arithmeticDCHolder.wholeNumberDC;
    arithmeticDCB = arithmeticDC.makeBrick();
    addSubtractDCB = addSubtractDC.makeBrick();
    addOp1DCB = wholeNumberDC.makeBrick("addOp1", addSubtractDCB);
    addOp2DCB = wholeNumberDC.makeBrick("addOp2", addSubtractDCB);
    sumDCB = wholeNumberDC.makeBrick("sum", addSubtractDCB);

  }

  @Test
  void putSafe() {

  }

}
