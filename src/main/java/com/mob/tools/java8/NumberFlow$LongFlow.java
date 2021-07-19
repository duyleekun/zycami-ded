/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow;
import com.mob.tools.java8.NumberFlow;
import com.mob.tools.java8.NumberFlow$LongFlow$1;
import com.mob.tools.java8.NumberFlow$LongFlow$2;
import com.mob.tools.java8.Optional;
import java.util.List;

public class NumberFlow$LongFlow
extends NumberFlow {
    public NumberFlow$LongFlow(Flow flow) {
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
        NumberFlow$LongFlow$2 numberFlow$LongFlow$2 = new NumberFlow$LongFlow$2(this);
        double d11 = (Double)this.inject(d10, numberFlow$LongFlow$2);
        double d12 = object.size();
        object = d11 / d12;
        Optional optional = new Optional(object);
        return optional;
    }

    public Long sum() {
        Long l10 = 0L;
        NumberFlow$LongFlow$1 numberFlow$LongFlow$1 = new NumberFlow$LongFlow$1(this);
        return (Long)this.inject(l10, numberFlow$LongFlow$1);
    }

    public Long[] toArray() {
        List list = this.toList();
        boolean bl2 = list.isEmpty();
        if (bl2) {
            return new Long[0];
        }
        Long[] longArray = new Long[list.size()];
        return list.toArray(longArray);
    }
}

