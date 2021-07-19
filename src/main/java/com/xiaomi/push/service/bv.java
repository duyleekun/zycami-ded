/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.az;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;
import com.xiaomi.push.service.w;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bv
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;

    public bv(XMPushService xMPushService, int n10) {
        this.a = xMPushService;
        super(n10);
    }

    public String a() {
        return "prepare the mi push account.";
    }

    public void a() {
        w.a(this.a);
        XMPushService xMPushService = this.a;
        boolean bl2 = az.b((Context)xMPushService);
        if (bl2) {
            xMPushService = this.a;
            boolean bl3 = true;
            xMPushService.a(bl3);
        }
    }
}

