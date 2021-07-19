/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Inject;
import com.mob.tools.java8.NumberFlow$ShortFlow;

public class NumberFlow$ShortFlow$2
implements Inject {
    public final /* synthetic */ NumberFlow$ShortFlow this$0;

    public NumberFlow$ShortFlow$2(NumberFlow$ShortFlow numberFlow$ShortFlow) {
        this.this$0 = numberFlow$ShortFlow;
    }

    public Double inject(Short s10, Double d10) {
        double d11 = s10.shortValue();
        double d12 = d10;
        return d11 + d12;
    }
}

