/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConstructorConstructor$9
implements ObjectConstructor {
    public final /* synthetic */ ConstructorConstructor this$0;

    public ConstructorConstructor$9(ConstructorConstructor constructorConstructor) {
        this.this$0 = constructorConstructor;
    }

    public Object construct() {
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        return concurrentSkipListMap;
    }
}

