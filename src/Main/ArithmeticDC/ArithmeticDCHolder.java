package ArithmeticDC;

import DataClass.*;

public class ArithmeticDCHolder extends DCHolder {
  public final JavaIntDF javaIntDF = new JavaIntDF(0);
  public final ArithmeticDC arithmeticDC = new ArithmeticDC(1); //will increase as more arithmetic dc's get added
  public final AddSubtractDC addSubtractDC = new AddSubtractDC(2);
  public WholeNumberDC wholeNumberDC = new WholeNumberDC(javaIntDF);

  public ArithmeticDCHolder() {
    addSubtractDC.putInner("wholeNumber", wholeNumberDC);
    arithmeticDC.putInner("addSubtract", addSubtractDC);
  }

}
