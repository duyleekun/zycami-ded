/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Commands$When;
import com.mob.tools.java8.Commands$When$WhenCondition;

public class Commands$When$1
implements Commands$When$WhenCondition {
    public final /* synthetic */ Commands$When this$0;
    public final /* synthetic */ boolean val$condition;

    public Commands$When$1(Commands$When commands$When, boolean bl2) {
        this.this$0 = commands$When;
        this.val$condition = bl2;
    }

    public boolean when(Object object) {
        return this.val$condition;
    }
}

