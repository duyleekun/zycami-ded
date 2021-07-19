/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;
import com.xiaomi.push.bb;
import com.xiaomi.push.bb$a;
import com.xiaomi.push.fh;
import com.xiaomi.push.fi;
import com.xiaomi.push.fj;
import com.xiaomi.push.fv;
import com.xiaomi.push.hd;
import com.xiaomi.push.he$a;
import com.xiaomi.push.hf;
import com.xiaomi.push.i;
import com.xiaomi.push.jc;
import com.xiaomi.push.ji;
import com.xiaomi.push.jo$a;
import com.xiaomi.push.jq;
import com.xiaomi.push.js;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.be;
import com.xiaomi.push.service.be$a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class he {
    private int a;
    private long a;
    private bb a;
    private hd a;
    private String a;
    private boolean a = false;

    public he() {
        bb bb2;
        this.a = bb2 = bb.a();
    }

    private fi a(bb$a object) {
        int n10 = ((bb$a)object).a;
        if (n10 == 0) {
            object = ((bb$a)object).a;
            n10 = object instanceof fi;
            object = n10 != 0 ? (fi)object : null;
        } else {
            fi fi2 = this.a();
            fh fh2 = fh.ac;
            int n11 = fh2.a();
            fi2.a(n11);
            n11 = ((bb$a)object).a;
            fi2.c(n11);
            object = ((bb$a)object).a;
            fi2.c((String)object);
            object = fi2;
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private fj a(int n10) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.a;
        fj fj2 = new fj((String)object, arrayList);
        object = this.a.a;
        boolean bl2 = az.d((Context)object);
        if (!bl2) {
            object = i.m((Context)this.a.a);
            fj2.a((String)object);
        }
        object = new jq(n10);
        Object object2 = new jo$a();
        object2 = ((jo$a)object2).a((js)object);
        try {
            fj2.b((ji)object2);
        }
        catch (jc jc2) {}
        LinkedList linkedList = this.a.a();
        try {
            int n11;
            while ((n11 = linkedList.size()) > 0) {
                int n12;
                Object object3 = linkedList.getLast();
                object3 = (bb$a)object3;
                if ((object3 = this.a((bb$a)object3)) != null) {
                    ((fi)object3).b((ji)object2);
                }
                if ((n12 = ((jq)object).a_()) > n10) {
                    return fj2;
                }
                if (object3 != null) {
                    arrayList.add(object3);
                }
                linkedList.removeLast();
            }
            return fj2;
        }
        catch (jc | NoSuchElementException exception) {}
        return fj2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static hd a() {
        he he2 = he$a.a;
        synchronized (he2) {
            return he2.a;
        }
    }

    public static he a() {
        return he$a.a;
    }

    private void a() {
        Object object = this.a;
        if (object != 0) {
            long l10 = System.currentTimeMillis();
            long l11 = this.a;
            int n10 = this.a;
            long l12 = (l10 -= l11) - (l11 = (long)n10);
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                object = 0;
                this.a = false;
                this.a = l10 = 0L;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public fi a() {
        synchronized (this) {
            fi fi2 = new fi();
            Object object = this.a;
            object = ((hd)object).a;
            object = az.a((Context)object);
            fi2.a((String)object);
            int n10 = 0;
            object = null;
            fi2.a = 0;
            fi2.b = n10 = 1;
            long l10 = System.currentTimeMillis();
            long l11 = 1000L;
            n10 = (int)(l10 /= l11);
            fi2.d(n10);
            return fi2;
        }
    }

    public fj a() {
        synchronized (this) {
            fj fj2;
            block8: {
                int n10;
                block9: {
                    n10 = 0;
                    fj2 = null;
                    boolean bl2 = this.b();
                    if (!bl2) break block8;
                    n10 = 750;
                    fv fv2 = this.a;
                    fv2 = fv2.a;
                    bl2 = az.d((Context)fv2);
                    if (bl2) break block9;
                    n10 = 375;
                }
                fj2 = this.a(n10);
            }
            return fj2;
            finally {
            }
        }
    }

    public void a(int n10) {
        if (n10 > 0) {
            int n11 = 604800000;
            if ((n10 *= 1000) > n11) {
                n10 = n11;
            }
            if ((n11 = this.a) != n10 || (n11 = (int)(this.a ? 1 : 0)) == 0) {
                long l10;
                n11 = 1;
                this.a = n11;
                this.a = l10 = System.currentTimeMillis();
                this.a = n10;
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "enable dot duration = ";
                stringBuilder.append(string2);
                stringBuilder.append(n10);
                stringBuilder.append(" start = ");
                long l11 = this.a;
                stringBuilder.append(l11);
                String string3 = stringBuilder.toString();
                b.c(string3);
            }
        }
    }

    public void a(fi fi2) {
        synchronized (this) {
            bb bb2 = this.a;
            bb2.a(fi2);
            return;
        }
    }

    public void a(XMPushService object) {
        synchronized (this) {
            Object object2 = new hd((XMPushService)object);
            this.a = object2;
            object = "";
            this.a = object;
            object = be.a();
            object2 = new hf(this);
            ((be)object).a((be$a)object2);
            return;
        }
    }

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        bb bb2;
        this.a();
        int n10 = this.a;
        if (n10 != 0 && (n10 = (bb2 = this.a).a()) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            bb2 = null;
        }
        return n10 != 0;
    }
}

