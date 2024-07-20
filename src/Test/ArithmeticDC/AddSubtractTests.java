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
    AddOpDC addOpDC = arithmeticDCHolder.addOpDC;
    SumDC sumDC = arithmeticDCHolder.sumDC;
    arithmeticDCB = arithmeticDC.makeBrick();
    addSubtractDCB = addSubtractDC.makeBrick();
    addOp1DCB = addOpDC.makeBrick("addOp1", addSubtractDCB);
    addOp2DCB = addOpDC.makeBrick("addOp2", addSubtractDCB);
    sumDCB = sumDC.makeBrick("sum", addSubtractDCB);

  }

  @Test
  void putSafe() {

  }

}
