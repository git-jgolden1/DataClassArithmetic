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
    assertFalse(addSubtractDCB.isComplete());

    //2 = addOp2 can also be putSafe if no sum is set
    r = addOp2DCB.putSafe(2);
    assertNull(r.getError());
    assertEquals(2, addOp2DCB.getVal());
    assertTrue(addSubtractDCB.isComplete());

    //3 = sum can be putSafe if no conflicts exist with addOps
    r = sumDCB.putSafe(3);
    assertNull(r.getError());
    assertEquals(3, sumDCB.getVal());
    assertTrue(addSubtractDCB.isComplete());

    //4 = sum CAN'T be putSafe if conflicts DO exist with addOps
    r = sumDCB.putSafe(4);
    assertNotNull(r.getError());
    assertEquals(3, sumDCB.getVal());
    assertTrue(addSubtractDCB.isComplete());

    //5 = op1 CAN'T be putSafe if conflicts DO exist with addOp2 and sum
    r = addOp1DCB.putSafe(0);
    assertNotNull(r.getError());
    assertEquals(1, addOp1DCB.getVal());
    assertTrue(addSubtractDCB.isComplete());

    //6 = op2 CAN'T be putSafe if conflicts DO exist with addOp1 and sum
    r = addOp2DCB.putSafe(5);
    assertNotNull(r.getError());
    assertEquals(2, addOp2DCB.getVal());
    assertTrue(addSubtractDCB.isComplete());

  }

}
