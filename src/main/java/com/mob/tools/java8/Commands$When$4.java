/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Commands$When;
import com.mob.tools.java8.Commands$When$WhenCondition;

public class Commands$When$4
implements Commands$When$WhenCondition {
    public final /* synthetic */ Commands$When this$0;
    public final /* synthetic */ Class val$type;

    public Commands$When$4(Commands$When commands$When, Class clazz) {
        this.this$0 = commands$When;
        this.val$type = clazz;
    }

    public boolean when(Object object) {
        boolean bl2;
        Class clazz = this.val$type;
        if (clazz != null && (bl2 = clazz.isInstance(object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

