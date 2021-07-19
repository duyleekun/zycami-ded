/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Commands$When;
import com.mob.tools.java8.Commands$When$WhenCondition;

public class Commands$When$2
implements Commands$When$WhenCondition {
    public final /* synthetic */ Commands$When this$0;
    public final /* synthetic */ Object val$value;

    public Commands$When$2(Commands$When commands$When, Object object) {
        this.this$0 = commands$When;
        this.val$value = object;
    }

    public boolean when(Object object) {
        boolean bl2;
        Object object2;
        if (object == null && (object2 = this.val$value) == null || object != null && (bl2 = object.equals(object2 = this.val$value))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

