/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Filter;
import com.mob.tools.java8.Flow;
import java.util.HashSet;

public class Flow$2
implements Filter {
    private HashSet output;
    public final /* synthetic */ Flow this$0;

    public Flow$2(Flow hashSet) {
        this.this$0 = hashSet;
        this.output = hashSet = new HashSet();
    }

    public boolean filter(Object object) {
        HashSet hashSet = this.output;
        boolean bl2 = hashSet.contains(object);
        if (bl2) {
            return false;
        }
        this.output.add(object);
        return true;
    }
}

