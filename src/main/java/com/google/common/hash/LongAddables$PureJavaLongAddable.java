/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.LongAddable;
import com.google.common.hash.LongAddables$1;
import java.util.concurrent.atomic.AtomicLong;

public final class LongAddables$PureJavaLongAddable
extends AtomicLong
implements LongAddable {
    private LongAddables$PureJavaLongAddable() {
    }

    public /* synthetic */ LongAddables$PureJavaLongAddable(LongAddables$1 longAddables$1) {
        this();
    }

    public void add(long l10) {
        this.getAndAdd(l10);
    }

    public void increment() {
        this.getAndIncrement();
    }

    public long sum() {
        return this.get();
    }
}

