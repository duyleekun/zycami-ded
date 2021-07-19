/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Inject;
import com.mob.tools.java8.NumberFlow$FloatFlow;

public class NumberFlow$FloatFlow$2
implements Inject {
    public final /* synthetic */ NumberFlow$FloatFlow this$0;

    public NumberFlow$FloatFlow$2(NumberFlow$FloatFlow numberFlow$FloatFlow) {
        this.this$0 = numberFlow$FloatFlow;
    }

    public Double inject(Float f10, Double d10) {
        double d11 = f10.floatValue();
        double d12 = d10;
        return d11 + d12;
    }
}

