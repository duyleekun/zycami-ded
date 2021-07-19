/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bt;
import com.xiaomi.push.bv;
import com.xiaomi.push.bw;
import com.xiaomi.push.bx;
import com.xiaomi.push.cb;
import com.xiaomi.push.cb$a;
import com.xiaomi.push.ch;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bu
implements Runnable {
    private String a;
    private WeakReference a;

    public bu(String string2, WeakReference weakReference) {
        this.a = string2;
        this.a = weakReference;
    }

    public void run() {
        long l10;
        Object object = this.a;
        if (object == null) {
            return;
        }
        if ((object = (Context)((Reference)object).get()) == null) {
            return;
        }
        Object object2 = this.a;
        long l11 = ch.a((String)object2);
        long l12 = l11 - (l10 = bt.a);
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 > 0) {
            object2 = bx.a(this.a);
            bw bw2 = bw.a(this.a);
            ((cb$a)object2).a(bw2);
            Object object4 = this.a;
            int n10 = 1000;
            object4 = bv.a((Context)object, (String)object4, n10);
            bw2.a((cb$a)object4);
            object = cb.a((Context)object);
            ((cb)object).a((cb$a)object2);
        } else {
            object = "=====> do not need clean db";
            b.b((String)object);
        }
    }
}

