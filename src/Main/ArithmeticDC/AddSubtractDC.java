package ArithmeticDC;

import DataClass.*;

import java.util.HashMap;

public class AddSubtractDC extends CompoundDataClass {

  public AddSubtractDC(int minimumRequiredSetValues) {
    super(minimumRequiredSetValues);
  }

  @Override
  public CompoundDataClassBrick makeBrick() {
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
  public CompoundDataClassBrick makeBrick(String name, CompoundDataClassBrick outer) {
    HashMap<String, DataClassBrick> addSubtractDCBInners = new HashMap<>();
    CompoundDataClassBrick addSubtractDCB = CompoundDataClassBrick.make(name, outer, this, addSubtractDCBInners);

    WholeNumberDC wholeNumberDC = (WholeNumberDC) getInner("wholeNumber");
    PrimitiveDataClassBrick addOp1DCB = wholeNumberDC.makeBrick("addOp1", addSubtractDCB);
    PrimitiveDataClassBrick addOp2DCB = wholeNumberDC.makeBrick("addOp2", addSubtractDCB);
    PrimitiveDataClassBrick sumDCB = wholeNumberDC.makeBrick("sum", addSubtractDCB);

    addSubtractDCBInners.put("addOp1", addOp1DCB);
    addSubtractDCBInners.put("addOp2", addOp2DCB);
    addSubtractDCBInners.put("sum", sumDCB);

    return addSubtractDCB.initInners(addSubtractDCBInners);
  }

}
