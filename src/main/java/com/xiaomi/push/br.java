/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.bp;
import com.xiaomi.push.bu;
import com.xiaomi.push.cb;
import java.lang.ref.WeakReference;

public class br
extends ai$a {
    public final /* synthetic */ bp a;

    public br(bp bp2) {
        this.a = bp2;
    }

    public int a() {
        return 10054;
    }

    public void run() {
        b.c("exec== DbSizeControlJob");
        String string2 = bp.a(this.a);
        Context context = bp.a(this.a);
        WeakReference<Context> weakReference = new WeakReference<Context>(context);
        bu bu2 = new bu(string2, weakReference);
        cb.a(bp.a(this.a)).a(bu2);
        bp.a(this.a, "check_time");
    }
}

