/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.al$b;
import com.xiaomi.push.b;
import com.xiaomi.push.c;
import com.xiaomi.push.ej$a;
import com.xiaomi.push.ek$b;
import com.xiaomi.push.gv;
import com.xiaomi.push.i;
import com.xiaomi.push.service.be$a;
import com.xiaomi.push.service.bf;
import com.xiaomi.push.t;
import com.xiaomi.push.y;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class be {
    private static be a;
    private static String a;
    private al$b a;
    private ej$a a;
    private List a;

    static {
        be be2;
        a = be2 = new be();
    }

    private be() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public static /* synthetic */ al$b a(be be2, al$b al$b) {
        be2.a = al$b;
        return al$b;
    }

    public static /* synthetic */ ej$a a(be be2) {
        return be2.a;
    }

    public static /* synthetic */ ej$a a(be be2, ej$a ej$a) {
        be2.a = ej$a;
        return ej$a;
    }

    public static be a() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a() {
        Class<be> clazz = be.class;
        synchronized (clazz) {
            String string2 = a;
            if (string2 != null) return a;
            string2 = t.a();
            String string3 = "XMPushServiceConfig";
            String string4 = null;
            string2 = string2.getSharedPreferences(string3, 0);
            string3 = "DeviceUUID";
            a = string3 = string2.getString(string3, null);
            if (string3 != null) return a;
            string3 = t.a();
            a = string3 = i.a((Context)string3, false);
            if (string3 == null) return a;
            string2 = string2.edit();
            string3 = "DeviceUUID";
            string4 = a;
            string2 = string2.putString(string3, string4);
            string2.commit();
            return a;
        }
    }

    public static /* synthetic */ List a(be be2) {
        return be2.a;
    }

    public static /* synthetic */ void a(be be2) {
        be2.e();
    }

    private void b() {
        ej$a ej$a = this.a;
        if (ej$a == null) {
            this.d();
        }
    }

    private void c() {
        al$b al$b = this.a;
        if (al$b != null) {
            return;
        }
        this.a = al$b = new bf(this);
        gv.a(al$b);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d() {
        Object object;
        Object object2;
        block10: {
            block8: {
                Object object3;
                block9: {
                    object2 = null;
                    object3 = t.a();
                    object = "XMCloudCfg";
                    object3 = object3.openFileInput((String)object);
                    object = new BufferedInputStream((InputStream)object3);
                    try {
                        object2 = b.a((InputStream)object);
                        this.a = object2 = ej$a.b((b)object2);
                        ((BufferedInputStream)object).close();
                        break block8;
                    }
                    catch (Exception exception) {
                        break block9;
                    }
                    catch (Throwable throwable) {
                        object = null;
                        object2 = throwable;
                        break block10;
                    }
                    catch (Exception exception) {
                        object = null;
                        object2 = exception;
                    }
                }
                try {
                    object3 = new StringBuilder();
                    String string2 = "load config failure: ";
                    ((StringBuilder)object3).append(string2);
                    object2 = ((Throwable)object2).getMessage();
                    ((StringBuilder)object3).append((String)object2);
                    object2 = ((StringBuilder)object3).toString();
                    com.xiaomi.channel.commonutils.logger.b.a((String)object2);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            y.a((Closeable)object);
            object2 = this.a;
            if (object2 == null) {
                this.a = object2 = new ej$a();
            }
            return;
        }
        y.a((Closeable)object);
        throw object2;
    }

    private void e() {
        block8: {
            Object object = this.a;
            if (object == null) break block8;
            object = t.a();
            Object object2 = "XMCloudCfg";
            Object object3 = null;
            object = object.openFileOutput((String)object2, 0);
            object2 = new BufferedOutputStream((OutputStream)object);
            object = c.a((OutputStream)object2);
            object3 = this.a;
            try {
                ((ej$a)object3).a((c)object);
                ((c)object).a();
                ((FilterOutputStream)object2).close();
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                object3 = "save config failure: ";
                ((StringBuilder)object2).append((String)object3);
                String string2 = exception.getMessage();
                ((StringBuilder)object2).append(string2);
                string2 = ((StringBuilder)object2).toString();
                com.xiaomi.channel.commonutils.logger.b.a(string2);
            }
        }
    }

    public int a() {
        this.b();
        ej$a ej$a = this.a;
        if (ej$a != null) {
            return ej$a.c();
        }
        return 0;
    }

    public ej$a a() {
        this.b();
        return this.a;
    }

    public void a() {
        synchronized (this) {
            List list = this.a;
            list.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(ek$b ek$b) {
        be$a[] be$aArray;
        int n10;
        int n11 = ek$b.d();
        if (n11 != 0 && (n11 = ek$b.d()) > (n10 = this.a())) {
            this.c();
        }
        synchronized (this) {
            be$aArray = this.a;
            n10 = be$aArray.size();
            be$a[] be$aArray2 = new be$a[n10];
            be$aArray = be$aArray.toArray(be$aArray2);
        }
        n10 = be$aArray.length;
        int n12 = 0;
        while (n12 < n10) {
            be$a be$a = be$aArray[n12];
            be$a.a(ek$b);
            ++n12;
        }
        return;
    }

    public void a(be$a be$a) {
        synchronized (this) {
            List list = this.a;
            list.add(be$a);
            return;
        }
    }
}

