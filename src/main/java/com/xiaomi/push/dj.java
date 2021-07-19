/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.aa;
import com.xiaomi.push.dh;
import com.xiaomi.push.di;
import com.xiaomi.push.di$b;
import com.xiaomi.push.di$c;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class dj
extends di$b {
    public final /* synthetic */ int a;
    public final /* synthetic */ di a;
    public File a;
    public final /* synthetic */ String a;
    public final /* synthetic */ Date a;
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Date b;

    public dj(di di2, int n10, Date date, Date date2, String string2, String string3, boolean bl2) {
        this.a = di2;
        this.a = n10;
        this.a = date;
        this.b = date2;
        this.a = string2;
        this.b = string3;
        this.a = bl2;
        super(di2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        boolean bl2 = aa.d();
        if (!bl2) {
            return;
        }
        try {
            Object object = new StringBuilder();
            Object object2 = this.a;
            object2 = di.a((di)object2);
            Date date = null;
            object2 = object2.getExternalFilesDir(null);
            ((StringBuilder)object).append(object2);
            object2 = "/.logcache";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            File file = new File((String)object);
            file.mkdirs();
            boolean bl3 = file.isDirectory();
            if (!bl3) return;
            object = new dh();
            int n10 = this.a;
            ((dh)object).a(n10);
            object2 = this.a;
            object2 = di.a((di)object2);
            date = this.a;
            Date date2 = this.b;
            this.a = file = ((dh)object).a((Context)object2, date, date2, file);
            return;
        }
        catch (NullPointerException nullPointerException) {
            return;
        }
    }

    public void c() {
        boolean bl2;
        Serializable serializable = this.a;
        if (serializable != null && (bl2 = ((File)serializable).exists())) {
            serializable = di.a(this.a);
            di di2 = this.a;
            String string2 = this.a;
            String string3 = this.b;
            File file = this.a;
            boolean bl3 = this.a;
            di$c di$c = new di$c(di2, string2, string3, file, bl3);
            ((ConcurrentLinkedQueue)serializable).add(di$c);
        }
        di.a(this.a, 0L);
    }
}

