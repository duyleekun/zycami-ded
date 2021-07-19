/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import com.mob.commons.LockAction;
import com.mob.commons.b;
import com.mob.commons.b$4;
import com.mob.commons.d;
import com.mob.tools.utils.FileLocker;

public class b$4$1
implements LockAction {
    public final /* synthetic */ b$4 a;

    public b$4$1(b$4 b$4) {
        this.a = b$4;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean run(FileLocker object) {
        Object object2;
        try {
            object = b.au();
            synchronized (object) {
                object2 = this.a;
                object2 = ((b$4)object2).a;
            }
        }
        catch (Throwable throwable) {
            object2 = d.a();
            int n10 = 1;
            ((d)object2).a(n10, throwable);
            return false;
        }
        {
            b.a((String)object2);
        }
        {
            object = this.a;
            b$4.a((b$4)object);
            return false;
        }
    }
}

