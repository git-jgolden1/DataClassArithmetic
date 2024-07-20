package ArithmeticDC;

import DataClass.*;

import java.util.HashMap;

public class ArithmeticDC extends CompoundDataClass {

  public ArithmeticDC(int minimumRequiredSetValues) {
    super(minimumRequiredSetValues);
  }

  @Override
  public CompoundDataClassBrick makeBrick() {
    return makeBrick("arithmetic", null);
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
  public CompoundDataClassBrick makeBrick(String name, CompoundDataClassBrick outer) {
    HashMap<String, DataClassBrick> arithmeticDCBInners = new HashMap<>();
    CompoundDataClassBrick arithmeticDCB = CompoundDataClassBrick.make(name, outer, this, arithmeticDCBInners);

    AddSubtractDC addSubtractDC = (AddSubtractDC) getInner("addSubtract");
    CompoundDataClassBrick addSubtractDCB = addSubtractDC.makeBrick("addSubtract", arithmeticDCB);

    arithmeticDCBInners.put("addSubtract", addSubtractDCB);

    return arithmeticDCB.initInners(arithmeticDCBInners);

  }

}
