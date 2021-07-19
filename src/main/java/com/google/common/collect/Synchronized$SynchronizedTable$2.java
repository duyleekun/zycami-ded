/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedTable;
import java.util.Map;

public class Synchronized$SynchronizedTable$2
implements Function {
    public final /* synthetic */ Synchronized$SynchronizedTable this$0;

    public Synchronized$SynchronizedTable$2(Synchronized$SynchronizedTable synchronized$SynchronizedTable) {
        this.this$0 = synchronized$SynchronizedTable;
    }

    public Map apply(Map map) {
        Object object = this.this$0.mutex;
        return Synchronized.map(map, object);
    }
}

