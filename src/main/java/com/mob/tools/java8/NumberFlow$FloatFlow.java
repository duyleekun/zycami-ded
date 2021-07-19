/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow;
import com.mob.tools.java8.NumberFlow;
import com.mob.tools.java8.NumberFlow$FloatFlow$1;
import com.mob.tools.java8.NumberFlow$FloatFlow$2;
import com.mob.tools.java8.Optional;
import java.util.List;

public class NumberFlow$FloatFlow
extends NumberFlow {
    public NumberFlow$FloatFlow(Flow flow) {
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
        NumberFlow$FloatFlow$2 numberFlow$FloatFlow$2 = new NumberFlow$FloatFlow$2(this);
        double d11 = (Double)this.inject(d10, numberFlow$FloatFlow$2);
        double d12 = object.size();
        object = d11 / d12;
        Optional optional = new Optional(object);
        return optional;
    }

    public Float sum() {
        Float f10 = Float.valueOf(0.0f);
        NumberFlow$FloatFlow$1 numberFlow$FloatFlow$1 = new NumberFlow$FloatFlow$1(this);
        return (Float)this.inject(f10, numberFlow$FloatFlow$1);
    }

    public Float[] toArray() {
        List list = this.toList();
        boolean bl2 = list.isEmpty();
        if (bl2) {
            return new Float[0];
        }
        Float[] floatArray = new Float[list.size()];
        return list.toArray(floatArray);
    }
}

