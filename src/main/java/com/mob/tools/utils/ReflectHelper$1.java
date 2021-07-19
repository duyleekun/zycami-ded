/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.utils;

import com.mob.tools.utils.ReflectHelper$ReflectRunnable;
import java.util.Map;

public final class ReflectHelper$1
implements ReflectHelper$ReflectRunnable {
    public final /* synthetic */ Map.Entry val$ent;

    public ReflectHelper$1(Map.Entry entry) {
        this.val$ent = entry;
    }

    public Object run(Object[] objectArray) {
        return ((Object[])((ReflectHelper$ReflectRunnable)this.val$ent.getValue()).run(objectArray))[0];
    }
}

