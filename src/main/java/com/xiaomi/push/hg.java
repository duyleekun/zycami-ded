/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fh;
import com.xiaomi.push.fi;
import com.xiaomi.push.gz;
import com.xiaomi.push.hc;
import com.xiaomi.push.hc$a;
import com.xiaomi.push.he;
import com.xiaomi.push.hg$a;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap$b;
import java.io.Serializable;
import java.util.Hashtable;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class hg {
    private static final int a = fh.c.a();

    public static void a() {
        int n10 = a;
        hg.a(0, n10);
    }

    public static void a(int n10) {
        fi fi2 = he.a().a();
        int n11 = fh.ac.a();
        fi2.a(n11);
        fi2.c(n10);
        he.a().a(fi2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(int n10, int n11) {
        Class<hg> clazz = hg.class;
        synchronized (clazz) {
            Object object;
            int n12 = 0xFFFFFF;
            if (n11 < n12) {
                n10 = n10 << 24 | n11;
                Hashtable hashtable = hg$a.a;
                object = n10;
                long l10 = System.currentTimeMillis();
                Long l11 = l10;
                hashtable.put(object, l11);
                return;
            }
            object = "stats key should less than 16777215";
            try {
                b.d((String)object);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
        }
    }

    public static void a(int n10, int n11, int n12, String string2, int n13) {
        fi fi2 = he.a().a();
        n10 = (byte)n10;
        fi2.a((byte)n10);
        fi2.a(n11);
        fi2.b(n12);
        fi2.b(string2);
        fi2.c(n13);
        he.a().a(fi2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(int n10, int n11, String string2, int n12) {
        Class<hg> clazz = hg.class;
        synchronized (clazz) {
            long l10 = System.currentTimeMillis();
            n10 = n10 << 24 | n11;
            Object object = hg$a.a;
            Serializable serializable = Integer.valueOf(n10);
            boolean bl2 = ((Hashtable)object).containsKey(serializable);
            if (bl2) {
                object = he.a();
                object = ((he)object).a();
                ((fi)object).a(n11);
                serializable = hg$a.a;
                Object object2 = n10;
                object2 = ((Hashtable)serializable).get(object2);
                object2 = (Long)object2;
                long l11 = (Long)object2;
                n10 = (int)(l10 -= l11);
                ((fi)object).b(n10);
                ((fi)object).b(string2);
                n10 = -1;
                if (n12 > n10) {
                    ((fi)object).c(n12);
                }
                object2 = he.a();
                ((he)object2).a((fi)object);
                object2 = hg$a.a;
                Integer n13 = n11;
                ((Hashtable)object2).remove(n13);
            } else {
                String string3 = "stats key not found";
                b.d(string3);
            }
            return;
        }
    }

    public static void a(XMPushService xMPushService, ap$b ap$b) {
        gz gz2 = new gz(xMPushService, ap$b);
        gz2.a();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(String object, int n10, Exception object2) {
        Object object3;
        fi fi2 = he.a().a();
        if (n10 > 0) {
            object2 = fh.i;
            int n11 = ((fh)((Object)object2)).a();
            fi2.a(n11);
            fi2.b((String)object);
            fi2.b(n10);
            object = he.a();
            ((he)object).a(fi2);
            return;
        }
        try {
            object3 = hc.a((Exception)object2);
        }
        catch (NullPointerException nullPointerException) {
            return;
        }
        object2 = ((hc$a)object3).a;
        int n12 = ((fh)((Object)object2)).a();
        fi2.a(n12);
        object3 = ((hc$a)object3).a;
        fi2.c((String)object3);
        fi2.b((String)object);
        object = he.a();
        ((he)object).a(fi2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(String object, Exception object2) {
        try {
            object2 = hc.b((Exception)object2);
        }
        catch (NullPointerException nullPointerException) {
            return;
        }
        Object object3 = he.a();
        object3 = ((he)object3).a();
        fh fh2 = ((hc$a)object2).a;
        int n10 = fh2.a();
        ((fi)object3).a(n10);
        object2 = ((hc$a)object2).a;
        ((fi)object3).c((String)object2);
        ((fi)object3).b((String)object);
        object = he.a();
        ((he)object).a((fi)object3);
    }

    public static byte[] a() {
        Object object = he.a().a();
        object = object != null ? (Object)iw.a((ix)object) : null;
        return object;
    }

    public static void b() {
        int n10 = a;
        hg.a(0, n10, null, -1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void b(String object, Exception object2) {
        try {
            object2 = hc.d((Exception)object2);
        }
        catch (NullPointerException nullPointerException) {
            return;
        }
        Object object3 = he.a();
        object3 = ((he)object3).a();
        fh fh2 = ((hc$a)object2).a;
        int n10 = fh2.a();
        ((fi)object3).a(n10);
        object2 = ((hc$a)object2).a;
        ((fi)object3).c((String)object2);
        ((fi)object3).b((String)object);
        object = he.a();
        ((he)object).a((fi)object3);
    }
}

