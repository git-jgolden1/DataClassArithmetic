package ArithmeticDC;

import DataClass.CompoundDataClassBrick;
import DataClass.DataClassBrick;
import DataClass.PrimitiveDataClassBrick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddSubtractTests {
  ArithmeticDCHolder arithmeticDCHolder = new ArithmeticDCHolder();
  CompoundDataClassBrick arithmeticDCB;
  CompoundDataClassBrick addSubtractDCB;
  PrimitiveDataClassBrick addOp1DCB;
  PrimitiveDataClassBrick addOp2DCB;
  PrimitiveDataClassBrick sumDCB;

  @BeforeEach
  void setupDCBs() {
    arithmeticDCB = arithmeticDCHolder.arithmeticDC.makeBrick();
    addSubtractDCB = (CompoundDataClassBrick) arithmeticDCB.getInner("addSubtract");
    addOp1DCB = (PrimitiveDataClassBrick) addSubtractDCB.getInner("addOp1");
    addOp2DCB = (PrimitiveDataClassBrick) addSubtractDCB.getInner("addOp2");
    sumDCB = (PrimitiveDataClassBrick) addSubtractDCB.getInner("sum");
    assertTrue(arithmeticDCB.isComplete());
  }

  @Test
  void putSafe() {

  }

}
