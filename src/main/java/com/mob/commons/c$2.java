/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.mob.commons;

import android.util.SparseArray;
import com.mob.commons.LockAction;
import com.mob.commons.c;
import com.mob.tools.utils.FileLocker;

public class c$2
implements LockAction {
    public final /* synthetic */ c a;

    public c$2(c c10) {
        this.a = c10;
    }

    public boolean run(FileLocker object) {
        int n10 = 50;
        String[][] stringArray = new String[n10][];
        c c10 = this.a;
        int n11 = c.a(c10, stringArray);
        while (n11 > 0) {
            SparseArray sparseArray = c.a(this.a, stringArray, n11);
            if (sparseArray == null) {
                object = this.a;
                c.a((c)object, false);
                break;
            }
            int n12 = sparseArray.size();
            if (n12 > 0) {
                c c11 = this.a;
                c.a(c11, sparseArray);
            }
            if (n11 < n10) break;
            c10 = this.a;
            n11 = c.a(c10, stringArray);
        }
        return false;
    }
}

