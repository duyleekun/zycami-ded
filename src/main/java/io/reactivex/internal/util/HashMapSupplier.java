/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class HashMapSupplier
extends Enum
implements Callable {
    public static final /* enum */ HashMapSupplier INSTANCE;
    private static final /* synthetic */ HashMapSupplier[] a;

    static {
        HashMapSupplier hashMapSupplier;
        INSTANCE = hashMapSupplier = new HashMapSupplier("INSTANCE", 0);
        HashMapSupplier[] hashMapSupplierArray = new HashMapSupplier[]{hashMapSupplier};
        a = hashMapSupplierArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HashMapSupplier() {
        void var2_-1;
        void var1_-1;
    }

    public static Callable asCallable() {
        return INSTANCE;
    }

    public static HashMapSupplier valueOf(String string2) {
        return Enum.valueOf(HashMapSupplier.class, string2);
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[])a.clone();
    }

    public Map call() {
        HashMap hashMap = new HashMap();
        return hashMap;
    }
}

