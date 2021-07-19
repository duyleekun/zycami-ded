/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.bg$a;
import java.util.concurrent.ConcurrentHashMap;

public class bh
implements Runnable {
    public final /* synthetic */ bg a;

    public bh(bg bg2) {
        this.a = bg2;
    }

    public void run() {
        Object object;
        Object object2 = this.a;
        object2 = bg.a((bg)object2);
        object2 = ((ConcurrentHashMap)object2).values();
        try {
            object2 = object2.iterator();
        }
        catch (Exception exception) {
            object = new StringBuilder();
            String string2 = "Sync job exception :";
            ((StringBuilder)object).append(string2);
            String string3 = exception.getMessage();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            b.a(string3);
        }
        while (true) {
            boolean bl2 = object2.hasNext();
            if (!bl2) break;
            object = object2.next();
            object = (bg$a)object;
            ((bg$a)object).run();
            continue;
            break;
        }
        bg.a(this.a, false);
    }
}

