/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import java.util.HashMap;
import java.util.Map;

public abstract class LazyInstanceMap {
    private final Map zza;

    public LazyInstanceMap() {
        HashMap hashMap;
        this.zza = hashMap = new HashMap();
    }

    public abstract Object create(Object var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get(Object object) {
        Map map = this.zza;
        synchronized (map) {
            Object object2 = this.zza;
            boolean bl2 = object2.containsKey(object);
            if (bl2) {
                object2 = this.zza;
                return object2.get(object);
            }
            object2 = this.create(object);
            Map map2 = this.zza;
            map2.put(object, object2);
            return object2;
        }
    }
}

