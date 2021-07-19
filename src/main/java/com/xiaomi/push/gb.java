/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.fz;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService$i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gb
extends XMPushService$i {
    public final /* synthetic */ fz a;
    public final /* synthetic */ Exception a;
    public final /* synthetic */ int b;

    public gb(fz fz2, int n10, int n11, Exception exception) {
        this.a = fz2;
        this.b = n11;
        this.a = exception;
        super(n10);
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("shutdown the connection. ");
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        Exception exception = this.a;
        stringBuilder.append(exception);
        return stringBuilder.toString();
    }

    public void a() {
        XMPushService xMPushService = this.a.b;
        int n10 = this.b;
        Exception exception = this.a;
        xMPushService.a(n10, exception);
    }
}

