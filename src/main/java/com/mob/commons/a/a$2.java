/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.mob.commons.a;

import android.os.Handler;
import com.mob.commons.FBListener;
import com.mob.commons.a.a;
import com.mob.commons.b;
import com.mob.tools.MobHandlerThread;

public class a$2
implements FBListener {
    public final /* synthetic */ a a;

    public a$2(a a10) {
        this.a = a10;
    }

    public void onFBChanged(boolean n10, boolean bl2, long l10) {
        int n11;
        if (bl2) {
            a a10 = this.a;
            long l11 = b.a();
            com.mob.commons.a.a.a(a10, l11);
            a10 = this.a;
            n11 = com.mob.commons.a.a.a(a10);
            if (n11 != 0) {
                a10 = this.a;
                Handler handler = MobHandlerThread.newHandler(a10);
                com.mob.commons.a.a.a(a10, handler);
                a10 = com.mob.commons.a.a.b(this.a);
                handler = null;
                a10.sendEmptyMessage(0);
            }
        }
        n11 = 1;
        if (n10 != 0) {
            a a11;
            if (!bl2) {
                a11 = this.a;
                long l12 = b.a();
                com.mob.commons.a.a.a(a11, l12);
                a11 = com.mob.commons.a.a.b(this.a);
                a11.sendEmptyMessage(n11);
            }
            if ((n10 = com.mob.commons.a.a.c(a11 = this.a)) != 0) {
                a11 = this.a;
                com.mob.commons.a.a.d(a11);
            }
        } else {
            long l13;
            long l14;
            a a12 = this.a;
            n10 = com.mob.commons.a.a.a(a12);
            if (n10 != 0 && (n10 = (l14 = l10 - (l13 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) > 0) {
                com.mob.commons.a.a.e(this.a);
                com.mob.commons.a.a.f(this.a);
                a12 = com.mob.commons.a.a.b(this.a);
                a12.removeMessages(n11);
            }
        }
    }
}

