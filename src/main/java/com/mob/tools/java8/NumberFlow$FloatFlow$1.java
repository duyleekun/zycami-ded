/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Inject;
import com.mob.tools.java8.NumberFlow$FloatFlow;

public class NumberFlow$FloatFlow$1
implements Inject {
    public final /* synthetic */ NumberFlow$FloatFlow this$0;

    public NumberFlow$FloatFlow$1(NumberFlow$FloatFlow numberFlow$FloatFlow) {
        this.this$0 = numberFlow$FloatFlow;
    }

    public Float inject(Float f10, Float f11) {
        float f12 = f10.floatValue();
        float f13 = f11.floatValue();
        return Float.valueOf(f12 + f13);
    }
}

