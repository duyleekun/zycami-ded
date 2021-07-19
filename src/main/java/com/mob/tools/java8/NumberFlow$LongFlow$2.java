/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Inject;
import com.mob.tools.java8.NumberFlow$LongFlow;

public class NumberFlow$LongFlow$2
implements Inject {
    public final /* synthetic */ NumberFlow$LongFlow this$0;

    public NumberFlow$LongFlow$2(NumberFlow$LongFlow numberFlow$LongFlow) {
        this.this$0 = numberFlow$LongFlow;
    }

    public Double inject(Long l10, Double d10) {
        double d11 = l10.longValue();
        double d12 = d10;
        return d11 + d12;
    }
}

