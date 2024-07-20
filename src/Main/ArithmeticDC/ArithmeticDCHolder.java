package ArithmeticDC;

import DataClass.*;

public class ArithmeticDCHolder extends DCHolder {
  public final JavaIntDF javaIntDF = new JavaIntDF(0);
  public final ArithmeticDC arithmeticDC = new ArithmeticDC(1); //will increase as more arithmetic dc's get added
  public final AddSubtractDC addSubtractDC = new AddSubtractDC(2);
  public final AddOpDC addOpDC = new AddOpDC(javaIntDF);
  public final SumDC sumDC = new SumDC(javaIntDF);

  public ArithmeticDCHolder() {
    addSubtractDC.putInner("addOp1", addOpDC);
    addSubtractDC.putInner("addOp2", addOpDC);
    addSubtractDC.putInner("sum", sumDC);
    arithmeticDC.putInner("addSubtract", addSubtractDC);
  }

}
