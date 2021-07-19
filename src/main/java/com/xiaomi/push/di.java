/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.aa;
import com.xiaomi.push.al$b;
import com.xiaomi.push.di$b;
import com.xiaomi.push.dj;
import com.xiaomi.push.dk;
import com.xiaomi.push.gv;
import java.io.File;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class di {
    private static volatile di a;
    private Context a;
    private final ConcurrentLinkedQueue a;

    private di(Context object) {
        ConcurrentLinkedQueue<Context> concurrentLinkedQueue;
        this.a = concurrentLinkedQueue = new ConcurrentLinkedQueue<Context>();
        this.a = object;
        super(this);
        concurrentLinkedQueue.add((Context)object);
        this.b(0L);
    }

    public static /* synthetic */ Context a(di di2) {
        return di2.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static di a(Context context) {
        Object object = a;
        if (object == null) {
            object = di.class;
            synchronized (object) {
                di di2 = a;
                if (di2 == null) {
                    a = di2 = new di(context);
                }
            }
        }
        di.a.a = context;
        return a;
    }

    public static /* synthetic */ ConcurrentLinkedQueue a(di di2) {
        return di2.a;
    }

    private void a(long l10) {
        boolean bl2;
        di$b di$b = (di$b)this.a.peek();
        if (di$b != null && (bl2 = di$b.a())) {
            this.b(l10);
        }
    }

    public static /* synthetic */ void a(di di2) {
        di2.b();
    }

    public static /* synthetic */ void a(di di2, long l10) {
        di2.a(l10);
    }

    private void b() {
        block15: {
            boolean bl2 = aa.b();
            if (!bl2 && !(bl2 = aa.a())) {
                CharSequence charSequence = new StringBuilder();
                Object object = this.a;
                File file = null;
                object = object.getExternalFilesDir(null);
                charSequence.append(object);
                object = "/.logcache";
                charSequence.append((String)object);
                charSequence = charSequence.toString();
                File[] fileArray = new File((String)charSequence);
                int n10 = fileArray.exists();
                if (n10 == 0) break block15;
                n10 = fileArray.isDirectory();
                if (n10 == 0) break block15;
                fileArray = fileArray.listFiles();
                n10 = fileArray.length;
                object = null;
                for (int i10 = 0; i10 < n10; ++i10) {
                    try {
                        file = fileArray[i10];
                    }
                    catch (NullPointerException nullPointerException) {}
                    file.delete();
                    continue;
                    break;
                }
            }
        }
    }

    private void b(long l10) {
        Object object = this.a;
        boolean bl2 = ((ConcurrentLinkedQueue)object).isEmpty();
        if (!bl2) {
            object = new dk(this);
            gv.a((al$b)object, l10);
        }
    }

    private void c() {
        Object object;
        boolean bl2;
        while (!(bl2 = ((ConcurrentLinkedQueue)(object = this.a)).isEmpty())) {
            int n10;
            ConcurrentLinkedQueue concurrentLinkedQueue;
            object = (di$b)this.a.peek();
            if (object == null) continue;
            int n11 = ((di$b)object).b();
            if (n11 == 0 && (n11 = (concurrentLinkedQueue = this.a).size()) <= (n10 = 6)) break;
            b.c("remove Expired task");
            concurrentLinkedQueue = this.a;
            concurrentLinkedQueue.remove(object);
        }
    }

    public void a() {
        this.c();
        this.a(0L);
    }

    public void a(String string2, String string3, Date date, Date date2, int n10, boolean bl2) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.a;
        dj dj2 = new dj(this, n10, date, date2, string2, string3, bl2);
        concurrentLinkedQueue.add(dj2);
        this.b(0L);
    }
}

