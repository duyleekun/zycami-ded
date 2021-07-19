/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Supplier;
import com.google.common.hash.LongAddable;
import com.google.common.hash.LongAddables$1;
import com.google.common.hash.LongAddables$2;
import com.google.common.hash.LongAdder;

public final class LongAddables {
    private static final Supplier SUPPLIER;

    static {
        Object object = new LongAdder();
        try {
            object = new LongAddables$1();
        }
        catch (Throwable throwable) {
            object = new LongAddables$2();
        }
        SUPPLIER = object;
    }

    public static LongAddable create() {
        return (LongAddable)SUPPLIER.get();
    }
}

