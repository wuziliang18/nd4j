package org.nd4j.autodiff.functions.impl.binary.transform.scalar;

import org.nd4j.autodiff.ArrayField;
import org.nd4j.autodiff.functions.AbstractScalarFunction;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;

import java.util.List;

public class ScalarMax extends AbstractScalarFunction {

    public ScalarMax() {
    }

    public ScalarMax(SameDiff sameDiff, DifferentialFunction i_v, int[] shape, Object[] extraArgs) {
        super(sameDiff, i_v, shape, extraArgs);
    }

    public ScalarMax(SameDiff sameDiff, DifferentialFunction i_v, Object[] extraArgs) {
        super(sameDiff, i_v, extraArgs);
    }

    public ScalarMax(SameDiff sameDiff, DifferentialFunction i_v, boolean inPlace, Object[] extraArgs) {
        super(sameDiff,i_v,inPlace,extraArgs);
    }


    /**
     * Get the value of this function
     *
     * @return
     */
    @Override
    public ArrayField doGetValue() {
        if(scalarValue == null) {
            scalarValue = (Number) extraArgs[0];
        }

        return arg().getValue(true).max(scalarValue.doubleValue());
    }

    @Override
    public String functionName() {
        return new org.nd4j.linalg.api.ops.impl.scalar.ScalarMax().name();
    }

    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> i_v1) {
        throw new UnsupportedOperationException();
    }
}
