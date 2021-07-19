/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Inject;
import com.mob.tools.java8.NumberFlow$ByteFlow;

public class NumberFlow$ByteFlow$2
implements Inject {
    public final /* synthetic */ NumberFlow$ByteFlow this$0;

    public NumberFlow$ByteFlow$2(NumberFlow$ByteFlow numberFlow$ByteFlow) {
        this.this$0 = numberFlow$ByteFlow;
    }

    public Double inject(Byte by2, Double d10) {
        double d11 = by2.byteValue();
        double d12 = d10;
        return d11 + d12;
    }
}

