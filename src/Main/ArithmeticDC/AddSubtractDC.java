package ArithmeticDC;

import DataClass.*;

public class AddSubtractDC extends CompoundDataClass {

  public AddSubtractDC(int minimumRequiredSetValues) {
    super(minimumRequiredSetValues);
  }

  @Override
  public DataClassBrick makeBrick() {
    return null;
  }

  @Override
  public Result<DataClassBrick> calcInternal(String name, CompoundDataClassBrick outerAsBrick) {
    return null;
  }

  @Override
  public ConflictsCheckResult conflictsCheck(CompoundDataClassBrick brick, String targetName, Object targetVal) {
    return null;
  }

  @Override
  public DataClassBrick makeBrick(String name, CompoundDataClassBrick outer) {
    return null;
  }

}
