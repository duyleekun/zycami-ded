/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import e.a.v0.o;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class ArrayListSupplier
extends Enum
implements Callable,
o {
    public static final /* enum */ ArrayListSupplier INSTANCE;
    private static final /* synthetic */ ArrayListSupplier[] a;

    static {
        ArrayListSupplier arrayListSupplier;
        INSTANCE = arrayListSupplier = new ArrayListSupplier("INSTANCE", 0);
        ArrayListSupplier[] arrayListSupplierArray = new ArrayListSupplier[]{arrayListSupplier};
        a = arrayListSupplierArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ArrayListSupplier() {
        void var2_-1;
        void var1_-1;
    }

    public static Callable asCallable() {
        return INSTANCE;
    }

    public static o asFunction() {
        return INSTANCE;
    }

    public static ArrayListSupplier valueOf(String string2) {
        return Enum.valueOf(ArrayListSupplier.class, string2);
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[])a.clone();
    }

    public List apply(Object arrayList) {
        arrayList = new ArrayList();
        return arrayList;
    }

    public List call() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }
}

