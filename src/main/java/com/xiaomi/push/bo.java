/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bn;
import com.xiaomi.push.fs;
import com.xiaomi.push.fv;
import java.text.DateFormat;
import java.util.Date;

public class bo
implements fv {
    public final /* synthetic */ bn a;

    public bo(bn bn2) {
        this.a = bn2;
    }

    public void a(fs object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("[Slim] ");
        Object object2 = bn.a(this.a);
        Date date = new Date();
        object2 = ((DateFormat)object2).format(date);
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" Connection reconnected (");
        int n10 = bn.a(this.a).hashCode();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(")");
        b.c(((StringBuilder)object).toString());
    }

    public void a(fs object, int n10, Exception serializable) {
        object = new StringBuilder();
        ((StringBuilder)object).append("[Slim] ");
        Object object2 = bn.a(this.a);
        serializable = new Date();
        object2 = ((DateFormat)object2).format((Date)serializable);
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" Connection closed (");
        n10 = bn.a(this.a).hashCode();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(")");
        b.c(((StringBuilder)object).toString());
    }

    public void a(fs object, Exception exception) {
        object = new StringBuilder();
        ((StringBuilder)object).append("[Slim] ");
        Object object2 = bn.a(this.a);
        Date date = new Date();
        object2 = ((DateFormat)object2).format(date);
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" Reconnection failed due to an exception (");
        int n10 = bn.a(this.a).hashCode();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(")");
        b.c(((StringBuilder)object).toString());
        exception.printStackTrace();
    }

    public void b(fs object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("[Slim] ");
        Object object2 = bn.a(this.a);
        Date date = new Date();
        object2 = ((DateFormat)object2).format(date);
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" Connection started (");
        int n10 = bn.a(this.a).hashCode();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(")");
        b.c(((StringBuilder)object).toString());
    }
}

