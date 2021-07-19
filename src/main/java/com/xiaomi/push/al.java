/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.push.al$a;
import com.xiaomi.push.al$b;
import com.xiaomi.push.am;
import com.xiaomi.push.an;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class al {
    private int a;
    private Handler a;
    private al$a a;
    private volatile al$b a;
    private volatile boolean a = 0;
    private final boolean b;

    public al() {
        this(false);
    }

    public al(boolean bl2) {
        this(bl2, 0);
    }

    public al(boolean bl2, int n10) {
        Looper looper = Looper.getMainLooper();
        am am2 = new am(this, looper);
        this.a = am2;
        this.b = bl2;
        this.a = n10;
    }

    public static /* synthetic */ int a(al al2) {
        return al2.a;
    }

    public static /* synthetic */ Handler a(al al2) {
        return al2.a;
    }

    public static /* synthetic */ al$b a(al al2, al$b al$b) {
        al2.a = al$b;
        return al$b;
    }

    private void a() {
        synchronized (this) {
            boolean bl2 = false;
            Object var2_2 = null;
            this.a = null;
            bl2 = true;
            this.a = bl2;
            return;
        }
    }

    public static /* synthetic */ void a(al al2) {
        al2.a();
    }

    public static /* synthetic */ boolean a(al al2) {
        return al2.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(al$b al$b) {
        synchronized (this) {
            al$a al$a = this.a;
            if (al$a == null) {
                this.a = al$a = new al$a(this);
                boolean bl2 = this.b;
                al$a.setDaemon(bl2);
                al$a = null;
                this.a = false;
                al$a = this.a;
                al$a.start();
            }
            al$a = this.a;
            al$a.a(al$b);
            return;
        }
    }

    public void a(al$b al$b, long l10) {
        Handler handler = this.a;
        an an2 = new an(this, al$b);
        handler.postDelayed((Runnable)an2, l10);
    }
}

