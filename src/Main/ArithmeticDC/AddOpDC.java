package ArithmeticDC;

import DataClass.*;

public class AddOpDC extends PrimitiveDataClass {

  public AddOpDC(DataForm defaultDF) {
    super(defaultDF);
  }

  @Override
  public PrimitiveDataClassBrick makeBrick(String name, CompoundDataClassBrick outer) {
    return null;
  }

  @Override
  public boolean isValidInput(Object val) {
    return false;
  }

  @Override
  public PrimitiveDataClassBrick makeBrick(String name, Object val, CompoundDataClassBrick outer) {
    return null;
  }

}
