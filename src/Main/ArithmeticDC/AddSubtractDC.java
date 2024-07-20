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
  public ConflictsCheckResult conflictsCheck(CompoundDataClassBrick addSubtractDCB, String targetName, Object targetVal) {
    ConflictsCheckResult ccr;
    boolean addOp1IsSet = targetName.equals("addOp1") || addSubtractDCB.getInner("addOp1").isComplete();
    boolean addOp2IsSet = targetName.equals("addOp2") || addSubtractDCB.getInner("addOp2").isComplete();
    boolean sumIsSet = targetName.equals("sum") || addSubtractDCB.getInner("sum").isComplete();
    if(addOp1IsSet && addOp2IsSet && sumIsSet) {
      PrimitiveDataClassBrick addOp1 = (PrimitiveDataClassBrick) addSubtractDCB.getInner("addOp1");
      PrimitiveDataClassBrick addOp2 = (PrimitiveDataClassBrick) addSubtractDCB.getInner("addOp2");
      PrimitiveDataClassBrick sum = (PrimitiveDataClassBrick) addSubtractDCB.getInner("sum");
      ccr = addOps1And2ConflictWithSum(addOp1, addOp2, sum);
    } else {
      ccr = ConflictsCheckResult.maybe;
    }
    return ccr;
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
