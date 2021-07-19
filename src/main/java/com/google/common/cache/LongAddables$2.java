/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Supplier;
import com.google.common.cache.LongAddable;
import com.google.common.cache.LongAddables$PureJavaLongAddable;

public final class LongAddables$2
implements Supplier {
    public LongAddable get() {
        LongAddables$PureJavaLongAddable longAddables$PureJavaLongAddable = new LongAddables$PureJavaLongAddable(null);
        return longAddables$PureJavaLongAddable;
    }
}

