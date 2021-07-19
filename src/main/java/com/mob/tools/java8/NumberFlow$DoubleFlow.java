/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow;
import com.mob.tools.java8.NumberFlow;
import com.mob.tools.java8.NumberFlow$DoubleFlow$1;
import com.mob.tools.java8.NumberFlow$DoubleFlow$2;
import com.mob.tools.java8.Optional;
import java.util.List;

public class NumberFlow$DoubleFlow
extends NumberFlow {
    public NumberFlow$DoubleFlow(Flow flow) {
        super(flow, null);
    }

    public Optional average() {
        Object object = this.toList();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = new Optional(null);
            return object;
        }
        Double d10 = 0.0;
        NumberFlow$DoubleFlow$2 numberFlow$DoubleFlow$2 = new NumberFlow$DoubleFlow$2(this);
        double d11 = (Double)this.inject(d10, numberFlow$DoubleFlow$2);
        double d12 = object.size();
        object = d11 / d12;
        Optional optional = new Optional(object);
        return optional;
    }

    public Double sum() {
        Double d10 = 0.0;
        NumberFlow$DoubleFlow$1 numberFlow$DoubleFlow$1 = new NumberFlow$DoubleFlow$1(this);
        return (Double)this.inject(d10, numberFlow$DoubleFlow$1);
    }

    public Double[] toArray() {
        List list = this.toList();
        boolean bl2 = list.isEmpty();
        if (bl2) {
            return new Double[0];
        }
        Double[] doubleArray = new Double[list.size()];
        return list.toArray(doubleArray);
    }
}

