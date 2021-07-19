/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.xiaomi.push;

import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.al;
import com.xiaomi.push.al$b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class al$a
extends Thread {
    public final /* synthetic */ al a;
    private final LinkedBlockingQueue a;

    public al$a(al linkedBlockingQueue) {
        this.a = linkedBlockingQueue;
        super("PackageProcessor");
        this.a = linkedBlockingQueue = new LinkedBlockingQueue();
    }

    private void a(int n10, al$b al$b) {
        al al2 = this.a;
        al2 = al.a(al2);
        al al3 = this.a;
        al3 = al.a(al3);
        Message message = al3.obtainMessage(n10, al$b);
        try {
            al2.sendMessage(message);
        }
        catch (Exception exception) {
            b.a(exception);
        }
    }

    public void a(al$b al$b) {
        LinkedBlockingQueue linkedBlockingQueue = this.a;
        try {
            linkedBlockingQueue.add(al$b);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        long l10;
        al al2 = this.a;
        int n10 = al.a(al2);
        if (n10 > 0) {
            al2 = this.a;
            n10 = al.a(al2);
            l10 = n10;
        } else {
            l10 = Long.MAX_VALUE;
        }
        Object object;
        int n11;
        while ((n11 = al.a((al)(object = this.a))) == 0) {
            try {
                object = this.a;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                object = ((LinkedBlockingQueue)object).poll(l10, timeUnit);
                object = (al$b)object;
                al al3 = this.a;
                al.a(al3, (al$b)object);
                if (object != null) {
                    int n12 = 0;
                    Object var7_10 = null;
                    this.a(0, (al$b)object);
                    ((al$b)object).b();
                    n12 = 1;
                    this.a(n12, (al$b)object);
                    continue;
                }
                object = this.a;
                n11 = al.a((al)object);
                if (n11 <= 0) continue;
                object = this.a;
                al.a((al)object);
            }
            catch (InterruptedException interruptedException) {
                b.a(interruptedException);
                continue;
            }
            break;
        }
        return;
    }
}

