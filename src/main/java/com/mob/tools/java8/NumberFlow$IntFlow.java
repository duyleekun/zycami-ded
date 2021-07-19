/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow;
import com.mob.tools.java8.NumberFlow;
import com.mob.tools.java8.NumberFlow$IntFlow$1;
import com.mob.tools.java8.NumberFlow$IntFlow$2;
import com.mob.tools.java8.Optional;
import java.util.List;

public class NumberFlow$IntFlow
extends NumberFlow {
    public NumberFlow$IntFlow(Flow flow) {
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
        NumberFlow$IntFlow$2 numberFlow$IntFlow$2 = new NumberFlow$IntFlow$2(this);
        double d11 = (Double)this.inject(d10, numberFlow$IntFlow$2);
        double d12 = object.size();
        object = d11 / d12;
        Optional optional = new Optional(object);
        return optional;
    }

    public Integer sum() {
        Integer n10 = 0;
        NumberFlow$IntFlow$1 numberFlow$IntFlow$1 = new NumberFlow$IntFlow$1(this);
        return (Integer)this.inject(n10, numberFlow$IntFlow$1);
    }

    public Integer[] toArray() {
        List list = this.toList();
        boolean bl2 = list.isEmpty();
        if (bl2) {
            return new Integer[0];
        }
        Integer[] integerArray = new Integer[list.size()];
        return list.toArray(integerArray);
    }
}

