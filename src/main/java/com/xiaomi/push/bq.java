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

public class bq
extends ai$a {
    public final /* synthetic */ bp a;

    public bq(bp bp2) {
        this.a = bp2;
    }

    public int a() {
        return 10052;
    }

    public void run() {
        b.c("exec== mUploadJob");
        Object object = bp.a(this.a);
        if (object != null) {
            object = bp.a(this.a);
            Object object2 = bp.a(this.a);
            object.a((Context)object2);
            object = this.a;
            object2 = "upload_time";
            bp.a((bp)object, (String)object2);
        }
    }
}

