/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Inject;
import com.mob.tools.java8.NumberFlow$IntFlow;

public class NumberFlow$IntFlow$2
implements Inject {
    public final /* synthetic */ NumberFlow$IntFlow this$0;

    public NumberFlow$IntFlow$2(NumberFlow$IntFlow numberFlow$IntFlow) {
        this.this$0 = numberFlow$IntFlow;
    }

    public Double inject(Integer n10, Double d10) {
        double d11 = n10.intValue();
        double d12 = d10;
        return d11 + d12;
    }
}

