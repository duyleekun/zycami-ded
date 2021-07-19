/*
 * Decompiled with CFR 0.151.
 */
package com.mob;

import com.mob.tools.proguard.PublicMemberKeeper;

public class RHolder
implements PublicMemberKeeper {
    private static RHolder a;
    private int b;
    private int c;
    private int d;

    private RHolder() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static RHolder getInstance() {
        Object object = a;
        if (object != null) return a;
        object = RHolder.class;
        synchronized (object) {
            RHolder rHolder = a;
            if (rHolder != null) return a;
            a = rHolder = new RHolder();
            return a;
        }
    }

    public int getActivityThemeId() {
        return this.b;
    }

    public int getDialogLayoutId() {
        return this.c;
    }

    public int getDialogThemeId() {
        return this.d;
    }

    public RHolder setActivityThemeId(int n10) {
        this.b = n10;
        return a;
    }

    public RHolder setDialogLayoutId(int n10) {
        this.c = n10;
        return a;
    }

    public RHolder setDialogThemeId(int n10) {
        this.d = n10;
        return a;
    }
}

