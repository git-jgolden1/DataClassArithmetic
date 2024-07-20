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
    boolean addOp1IsOrWillBeSet = targetName.equals("addOp1") || addSubtractDCB.getInner("addOp1").isComplete();
    boolean addOp2IsOrWillBeSet = targetName.equals("addOp2") || addSubtractDCB.getInner("addOp2").isComplete();
    boolean sumIsOrWillBeSet = targetName.equals("sum") || addSubtractDCB.getInner("sum").isComplete();
    if(addOp1IsOrWillBeSet && addOp2IsOrWillBeSet && sumIsOrWillBeSet) {
      PrimitiveDataClassBrick addOp1 = (PrimitiveDataClassBrick) addSubtractDCB.getInner("addOp1");
      PrimitiveDataClassBrick addOp2 = (PrimitiveDataClassBrick) addSubtractDCB.getInner("addOp2");
      PrimitiveDataClassBrick sum = (PrimitiveDataClassBrick) addSubtractDCB.getInner("sum");
      ccr = addOpsConflictWithSum((int)addOp1.getVal(), (int)addOp2.getVal(), (int)sum.getVal());
    } else {
      ccr = ConflictsCheckResult.maybe;
    }
    return ccr;
  }

  private ConflictsCheckResult addOpsConflictWithSum(int addOp1, int addOp2, int sum) {
    if(addOp1 + addOp2 == sum) {
      return ConflictsCheckResult.no;
    } else {
      return ConflictsCheckResult.yes;
    }
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
