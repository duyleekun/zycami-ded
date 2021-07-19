/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ConditionVariable
 */
package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;

public class SimpleCache$1
extends Thread {
    public final /* synthetic */ SimpleCache this$0;
    public final /* synthetic */ ConditionVariable val$conditionVariable;

    public SimpleCache$1(SimpleCache simpleCache, String string2, ConditionVariable conditionVariable) {
        this.this$0 = simpleCache;
        this.val$conditionVariable = conditionVariable;
        super(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        SimpleCache simpleCache = this.this$0;
        synchronized (simpleCache) {
            Object object = this.val$conditionVariable;
            object.open();
            object = this.this$0;
            SimpleCache.access$000((SimpleCache)object);
            object = this.this$0;
            object = SimpleCache.access$100((SimpleCache)object);
            object.onCacheInitialized();
            return;
        }
    }
}

