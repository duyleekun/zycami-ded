/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMPushService$f
extends XMPushService$i {
    public final /* synthetic */ XMPushService a;
    public Exception a;
    public int b;

    public XMPushService$f(XMPushService xMPushService, int n10, Exception exception) {
        this.a = xMPushService;
        super(2);
        this.b = n10;
        this.a = exception;
    }

    public String a() {
        return "disconnect the connection.";
    }

    public void a() {
        XMPushService xMPushService = this.a;
        int n10 = this.b;
        Exception exception = this.a;
        xMPushService.a(n10, exception);
    }
}

