/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

public abstract class ak$a
implements Runnable {
    private String mDescription;
    private int mId;

    public ak$a(int n10, String string2) {
        this.mId = n10;
        this.mDescription = string2;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof ak$a;
        boolean bl2 = false;
        if (n10 != 0) {
            n10 = this.mId;
            object = (ak$a)object;
            int n11 = ((ak$a)object).mId;
            if (n10 == n11) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        return this.mId;
    }

    public abstract void onCallback();

    public final void run() {
        this.onCallback();
    }
}

