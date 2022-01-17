package dev.dankom.pi.item.data.reforge;

import dev.dankom.pi.profile.stat.Stat;
import dev.dankom.pi.type.Operation;
import dev.dankom.util.general.MathUtil;

public class ReforgeModifier {
    private Stat stat;
    private final Operation operation;
    private final int amt;

    public ReforgeModifier(Stat stat, Operation operation, int amt) {
        this.stat = stat;
        this.operation = operation;
        this.amt = amt;
    }

    public Stat getStat() {
        return stat;
    }

    public int modify(int in) {
        int out = in;
        if (operation == Operation.ADD) {
            out += amt;
        } else if (operation == Operation.SUBTRACT) {
            out -= amt;
        } else if (operation == Operation.MULTIPLY) {
            out *= amt;
        } else if (operation == Operation.DIVIDE) {
            out /= amt;
        } else if (operation == Operation.ADD_PERCENT) {
            out += MathUtil.percOf(out, amt);
        } else if (operation == Operation.SUBTRACT_PERCENT) {
            out -= MathUtil.percOf(out, amt);;
        } else if (operation == Operation.MULTIPLY_PERCENT) {
            out *= MathUtil.percOf(out, amt);;
        } else if (operation == Operation.DIVIDE_PERCENT) {
            out /= MathUtil.percOf(out, amt);;
        }
        return out;
    }
}
