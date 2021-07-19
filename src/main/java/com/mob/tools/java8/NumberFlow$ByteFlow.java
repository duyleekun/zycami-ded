/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Flow;
import com.mob.tools.java8.NumberFlow;
import com.mob.tools.java8.NumberFlow$ByteFlow$1;
import com.mob.tools.java8.NumberFlow$ByteFlow$2;
import com.mob.tools.java8.Optional;
import java.util.List;

public class NumberFlow$ByteFlow
extends NumberFlow {
    public NumberFlow$ByteFlow(Flow flow) {
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
        NumberFlow$ByteFlow$2 numberFlow$ByteFlow$2 = new NumberFlow$ByteFlow$2(this);
        double d11 = (Double)this.inject(d10, numberFlow$ByteFlow$2);
        double d12 = object.size();
        object = d11 / d12;
        Optional optional = new Optional(object);
        return optional;
    }

    public Byte sum() {
        Byte by2 = 0;
        NumberFlow$ByteFlow$1 numberFlow$ByteFlow$1 = new NumberFlow$ByteFlow$1(this);
        return (Byte)this.inject(by2, numberFlow$ByteFlow$1);
    }

    public Byte[] toArray() {
        List list = this.toList();
        boolean bl2 = list.isEmpty();
        if (bl2) {
            return new Byte[0];
        }
        Byte[] byteArray = new Byte[list.size()];
        return list.toArray(byteArray);
    }
}

