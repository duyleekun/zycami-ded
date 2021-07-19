/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow;
import com.mob.tools.java8.NumberFlow;
import com.mob.tools.java8.NumberFlow$ShortFlow$1;
import com.mob.tools.java8.NumberFlow$ShortFlow$2;
import com.mob.tools.java8.Optional;
import java.util.List;

public class NumberFlow$ShortFlow
extends NumberFlow {
    public NumberFlow$ShortFlow(Flow flow) {
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
        NumberFlow$ShortFlow$2 numberFlow$ShortFlow$2 = new NumberFlow$ShortFlow$2(this);
        double d11 = (Double)this.inject(d10, numberFlow$ShortFlow$2);
        double d12 = object.size();
        object = d11 / d12;
        Optional optional = new Optional(object);
        return optional;
    }

    public Short sum() {
        Short s10 = 0;
        NumberFlow$ShortFlow$1 numberFlow$ShortFlow$1 = new NumberFlow$ShortFlow$1(this);
        return (Short)this.inject(s10, numberFlow$ShortFlow$1);
    }

    public Short[] toArray() {
        List list = this.toList();
        boolean bl2 = list.isEmpty();
        if (bl2) {
            return new Short[0];
        }
        Short[] shortArray = new Short[list.size()];
        return list.toArray(shortArray);
    }
}

