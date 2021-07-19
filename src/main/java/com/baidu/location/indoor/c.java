/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import java.util.ArrayList;

public class c
extends ArrayList {
    private int a = 0;

    public c(int n10) {
        this.a = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean add(Object object) {
        synchronized (this) {
            int n10 = this.size();
            int n11 = this.a;
            if (n10 == n11) {
                n10 = 0;
                this.remove(0);
            }
            n10 = this.size();
            this.add(n10, object);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        synchronized (this) {
            int n10 = this.size();
            int n11 = 3;
            if (n10 <= n11) {
                return;
            }
            n10 = this.size();
            n10 /= 2;
            while (true) {
                n11 = n10 + -1;
                if (n10 <= 0) {
                    return;
                }
                n10 = 0;
                Object var3_3 = null;
                this.remove(0);
                n10 = n11;
            }
        }
    }
}

