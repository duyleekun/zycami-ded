/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Commands$When;
import com.mob.tools.java8.Commands$When$WhenCondition;

public class Commands$When$8
implements Commands$When$WhenCondition {
    public final /* synthetic */ Commands$When this$0;
    public final /* synthetic */ double val$value;

    public Commands$When$8(Commands$When commands$When, double d10) {
        this.this$0 = commands$When;
        this.val$value = d10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean when(Object object) {
        boolean bl2 = false;
        try {
            object = String.valueOf(object);
        }
        catch (Throwable throwable) {
            return bl2;
        }
        object = Double.valueOf((String)object);
        double d10 = (Double)object;
        double d11 = this.val$value;
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (d12 <= 0) return bl2;
        return true;
    }
}

