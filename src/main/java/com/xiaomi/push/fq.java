/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.a;
import com.xiaomi.push.ek$j;
import com.xiaomi.push.fk;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fp;
import com.xiaomi.push.fr;
import com.xiaomi.push.fs;
import com.xiaomi.push.fs$a;
import com.xiaomi.push.ft;
import com.xiaomi.push.fz;
import com.xiaomi.push.gd;
import com.xiaomi.push.gj;
import com.xiaomi.push.gx;
import com.xiaomi.push.hg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.be;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class fq
extends fz {
    private fm a;
    private fn a;
    private Thread a;
    private byte[] a;

    public fq(XMPushService xMPushService, ft ft2) {
        super(xMPushService, ft2);
    }

    private fl a(boolean bl2) {
        Object object;
        fp fp2 = new fp();
        if (bl2) {
            object = "1";
            fp2.a((String)object);
        }
        if ((object = (Object)hg.a()) != null) {
            ek$j ek$j = new ek$j();
            object = com.xiaomi.push.a.a((byte[])object);
            ek$j.a((a)object);
            object = ek$j.a();
            ek$j = null;
            fp2.a((byte[])object, null);
        }
        return fp2;
    }

    public static /* synthetic */ fm a(fq fq2) {
        return fq2.a;
    }

    private void h() {
        Object object;
        try {
            object = ((fz)this).a;
        }
        catch (Exception exception) {
            object = new gd("Error to init reader and writer", exception);
            throw object;
        }
        object = ((Socket)object).getInputStream();
        Object object2 = new fm((InputStream)object, this);
        this.a = object2;
        object = ((fz)this).a;
        object = ((Socket)object).getOutputStream();
        object2 = new fn((OutputStream)object, this);
        this.a = object2;
        object = new StringBuilder();
        String string2 = "Blob Reader (";
        ((StringBuilder)object).append(string2);
        int n10 = ((fs)this).b;
        ((StringBuilder)object).append(n10);
        string2 = ")";
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        object2 = new fr(this, (String)object);
        this.a = object2;
        ((Thread)object2).start();
    }

    public void a() {
        synchronized (this) {
            this.h();
            fn fn2 = this.a;
            fn2.a();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, Exception exception) {
        synchronized (this) {
            Object object = this.a;
            if (object != null) {
                ((fm)object).b();
                this.a = null;
            }
            if ((object = this.a) != null) {
                try {
                    ((fn)object).b();
                }
                catch (Exception exception2) {
                    com.xiaomi.channel.commonutils.logger.b.a(exception2);
                }
                this.a = null;
            }
            this.a = null;
            super.a(n10, exception);
            return;
        }
    }

    public void a(fl fl2) {
        Object object;
        int n10;
        Object object2;
        if (fl2 == null) {
            return;
        }
        int n11 = fl2.a();
        if (n11 != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("[Slim] RCV blob chid=");
            n10 = fl2.a();
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append("; id=");
            object = fl2.e();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("; errCode=");
            n10 = fl2.b();
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append("; err=");
            object = fl2.c();
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            com.xiaomi.channel.commonutils.logger.b.a((String)object2);
        }
        if ((n11 = fl2.a()) == 0) {
            object = "PING";
            object2 = fl2.a();
            n11 = (int)(((String)object).equals(object2) ? 1 : 0);
            if (n11 != 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("[Slim] RCV ping id=");
                object = fl2.e();
                ((StringBuilder)object2).append((String)object);
                object2 = ((StringBuilder)object2).toString();
                com.xiaomi.channel.commonutils.logger.b.a((String)object2);
                this.g();
            } else {
                object = "CLOSE";
                object2 = fl2.a();
                n11 = (int)(((String)object).equals(object2) ? 1 : 0);
                if (n11 != 0) {
                    n11 = 13;
                    n10 = 0;
                    object = null;
                    this.c(n11, null);
                }
            }
        }
        object2 = ((fs)this).a.values().iterator();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            object = (fs$a)object2.next();
            ((fs$a)object).a(fl2);
        }
    }

    public void a(gj object) {
        object = fl.a((gj)object, null);
        this.b((fl)object);
    }

    public void a(ap$b ap$b) {
        synchronized (this) {
            String string2 = this.c();
            fk.a(ap$b, string2, (fs)this);
            return;
        }
    }

    public void a(String string2, String string3) {
        synchronized (this) {
            fk.a(string2, string3, (fs)this);
            return;
        }
    }

    public void a(boolean bl2) {
        Object object = this.a;
        if (object != null) {
            fl fl2 = this.a(bl2);
            object = new StringBuilder();
            ((StringBuilder)object).append("[Slim] SND ping id=");
            String string2 = fl2.e();
            ((StringBuilder)object).append(string2);
            com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)object).toString());
            this.b(fl2);
            this.f();
            return;
        }
        gd gd2 = new gd("The BlobWriter is null.");
        throw gd2;
    }

    public void a(fl[] flArray) {
        for (fl fl2 : flArray) {
            this.b(fl2);
        }
    }

    public boolean a() {
        return true;
    }

    public byte[] a() {
        synchronized (this) {
            boolean bl2;
            Object object = this.a;
            if (object == null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = (Object)((fs)this).a)))) {
                object = be.a();
                Object object2 = new StringBuilder();
                String string2 = ((fs)this).a;
                int n10 = string2.length();
                string2 = string2.substring(n10 /= 2);
                ((StringBuilder)object2).append(string2);
                int n11 = object.length();
                object = object.substring(n11 /= 2);
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                object2 = ((fs)this).a;
                object2 = ((String)object2).getBytes();
                object = object.getBytes();
                this.a = object = ay.a((byte[])object2, object);
            }
            object = this.a;
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(fl object) {
        Object object2 = this.a;
        if (object2 == null) {
            object = new gd("the writer is null.");
            throw object;
        }
        try {
            long l10;
            int n10 = ((fn)object2).a((fl)object);
            ((fs)this).d = l10 = System.currentTimeMillis();
            String string2 = ((fl)object).f();
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                XMPushService xMPushService = ((fs)this).a;
                long l11 = n10;
                boolean bl3 = true;
                long l12 = System.currentTimeMillis();
                gx.a((Context)xMPushService, string2, l11, false, bl3, l12);
            }
            object2 = ((fs)this).b;
            object2 = object2.values();
            object2 = object2.iterator();
            while (true) {
                if (!(bl2 = object2.hasNext())) {
                    return;
                }
                Object object3 = object2.next();
                object3 = (fs$a)object3;
                ((fs$a)object3).a((fl)object);
            }
        }
        catch (Exception exception) {
            object2 = new gd(exception);
            throw object2;
        }
    }

    public void b(gj gj2) {
        boolean bl2;
        if (gj2 == null) {
            return;
        }
        Iterator iterator2 = ((fs)this).a.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            fs$a fs$a = (fs$a)iterator2.next();
            fs$a.a(gj2);
        }
    }
}

