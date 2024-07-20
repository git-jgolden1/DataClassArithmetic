package ArithmeticDC;

import DataClass.CompoundDataClassBrick;
import DataClass.DataClassBrick;
import DataClass.PrimitiveDataClassBrick;
import DataClass.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    assertFalse(arithmeticDCB.isComplete());
  }

  @Test
  void putSafe() {
    //1 = addOp1 can be putSafe if no values are set
    Result r = addOp1DCB.putSafe(1);
    assertNull(r.getError());
    assertEquals(1, addOp1DCB.getVal());

    //2 = addOp2 can also be putSafe if no sum is set
    r = addOp2DCB.putSafe(2);
    assertNull(r.getError());
    assertEquals(2, addOp2DCB.getVal());

    //3 = sum can be putSafe if no conflicts exist with addOps

  }

}
