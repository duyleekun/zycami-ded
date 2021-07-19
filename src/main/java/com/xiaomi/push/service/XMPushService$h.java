/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.xiaomi.push.service;

import android.content.Intent;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$h
extends XMPushService$i {
    private Intent a;
    public final /* synthetic */ XMPushService a;

    public XMPushService$h(XMPushService xMPushService, Intent intent) {
        this.a = xMPushService;
        super(15);
        this.a = null;
        this.a = intent;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Handle intent action = ");
        String string2 = this.a.getAction();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void a() {
        XMPushService xMPushService = this.a;
        Intent intent = this.a;
        XMPushService.a(xMPushService, intent);
    }
}

