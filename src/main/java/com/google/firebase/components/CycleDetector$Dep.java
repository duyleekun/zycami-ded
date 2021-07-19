/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.CycleDetector$1;

public class CycleDetector$Dep {
    private final Class anInterface;
    private final boolean set;

    private CycleDetector$Dep(Class clazz, boolean bl2) {
        this.anInterface = clazz;
        this.set = bl2;
    }

    public /* synthetic */ CycleDetector$Dep(Class clazz, boolean bl2, CycleDetector$1 cycleDetector$1) {
        this(clazz, bl2);
    }

    public static /* synthetic */ boolean access$100(CycleDetector$Dep cycleDetector$Dep) {
        return cycleDetector$Dep.set;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof CycleDetector$Dep;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (CycleDetector$Dep)object;
            Class clazz = ((CycleDetector$Dep)object).anInterface;
            Class clazz2 = this.anInterface;
            bl2 = clazz.equals(clazz2);
            if (bl2 && (bl4 = ((CycleDetector$Dep)object).set) == (bl2 = this.set)) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.anInterface.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = Boolean.valueOf(this.set).hashCode();
        return n10 ^ n11;
    }
}

