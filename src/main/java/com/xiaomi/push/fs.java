/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 */
package com.xiaomi.push;

import android.content.Context;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;
import com.xiaomi.push.be;
import com.xiaomi.push.bn;
import com.xiaomi.push.fl;
import com.xiaomi.push.fs$a;
import com.xiaomi.push.ft;
import com.xiaomi.push.fv;
import com.xiaomi.push.fx;
import com.xiaomi.push.fy;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.at;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class fs {
    private static final AtomicInteger a;
    public static boolean a;
    public int a;
    public long a;
    public ft a;
    public ge a;
    public XMPushService a;
    public String a;
    private final Collection a;
    private LinkedList a;
    public final Map a = -1;
    public final int b;
    public volatile long b;
    public String b;
    public final Map b;
    private int c;
    public volatile long c;
    public long d;
    private long e;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object = new AtomicInteger(0);
        a = object;
        a = false;
        object = "smack.debugEnabled";
        try {
            boolean bl2;
            a = bl2 = Boolean.getBoolean((String)object);
        }
        catch (Exception exception) {}
        fy.a();
    }

    public fs(XMPushService xMPushService, ft ft2) {
        int n10;
        long l10;
        this.b = l10 = 0L;
        this.c = l10;
        Object object = new LinkedList();
        this.a = object;
        this.a = object;
        super();
        this.a = object;
        super();
        this.b = object;
        this.a = null;
        this.a = object = "";
        this.b = object;
        this.c = 2;
        this.b = n10 = a.getAndIncrement();
        this.e = l10;
        this.d = l10;
        this.a = ft2;
        this.a = xMPushService;
        this.b();
    }

    private String a(int n10) {
        int n11 = 1;
        if (n10 == n11) {
            return "connected";
        }
        if (n10 == 0) {
            return "connecting";
        }
        n11 = 2;
        if (n10 == n11) {
            return "disconnected";
        }
        return "unknown";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10) {
        LinkedList linkedList = this.a;
        synchronized (linkedList) {
            int n11 = 1;
            if (n10 == n11) {
                LinkedList linkedList2 = this.a;
                linkedList2.clear();
            } else {
                LinkedList linkedList3 = this.a;
                Serializable serializable = Integer.valueOf(n10);
                long l10 = System.currentTimeMillis();
                Long l11 = l10;
                Pair pair = new Pair((Object)serializable, (Object)l11);
                linkedList3.add(pair);
                serializable = this.a;
                n10 = ((LinkedList)serializable).size();
                n11 = 6;
                if (n10 > n11) {
                    serializable = this.a;
                    n11 = 0;
                    linkedList3 = null;
                    ((LinkedList)serializable).remove(0);
                }
            }
            return;
        }
    }

    public int a() {
        return this.a;
    }

    public long a() {
        return this.c;
    }

    public ft a() {
        return this.a;
    }

    public String a() {
        return this.a.c();
    }

    public void a(int n10, int n11, Exception exception) {
        Object object;
        int n12 = this.c;
        int n13 = 2;
        int n14 = 1;
        if (n10 != n12) {
            int n15 = 3;
            Object[] objectArray = new Object[n15];
            objectArray[0] = object = this.a(n12);
            objectArray[n14] = object = this.a(n10);
            objectArray[n13] = object = at.a(n11);
            object = String.format("update the connection status. %1$s -> %2$s : %3$s ", objectArray);
            com.xiaomi.channel.commonutils.logger.b.a((String)object);
        }
        if ((n12 = (int)(az.b((Context)(object = this.a)) ? 1 : 0)) != 0) {
            this.a(n10);
        }
        n12 = 10;
        if (n10 == n14) {
            Object object2 = this.a;
            ((XMPushService)object2).a(n12);
            n11 = this.c;
            if (n11 != 0) {
                object2 = "try set connected while not connecting.";
                com.xiaomi.channel.commonutils.logger.b.a((String)object2);
            }
            this.c = n10;
            Iterator iterator2 = this.a.iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object2 = (fv)iterator2.next();
                object2.a(this);
            }
        } else if (n10 == 0) {
            Object object3;
            n11 = this.c;
            if (n11 != n13) {
                object3 = "try set connecting while not disconnected.";
                com.xiaomi.channel.commonutils.logger.b.a((String)object3);
            }
            this.c = n10;
            Iterator iterator3 = this.a.iterator();
            while ((n11 = (int)(iterator3.hasNext() ? 1 : 0)) != 0) {
                object3 = (fv)iterator3.next();
                object3.b(this);
            }
        } else if (n10 == n13) {
            Object object4 = this.a;
            ((XMPushService)object4).a(n12);
            n12 = this.c;
            if (n12 == 0) {
                Iterator iterator4 = this.a.iterator();
                while ((n12 = (int)(iterator4.hasNext() ? 1 : 0)) != 0) {
                    object = (fv)iterator4.next();
                    if (exception == null) {
                        String string2 = "disconnect while connecting";
                        object4 = new CancellationException(string2);
                    } else {
                        object4 = exception;
                    }
                    object.a(this, (Exception)object4);
                }
            } else if (n12 == n14) {
                object = this.a.iterator();
                while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    object4 = (fv)object.next();
                    object4.a(this, n11, exception);
                }
            }
            this.c = n10;
        }
    }

    public void a(fv fv2) {
        if (fv2 == null) {
            return;
        }
        Collection collection = this.a;
        boolean bl2 = collection.contains(fv2);
        if (!bl2) {
            collection = this.a;
            collection.add(fv2);
        }
    }

    public void a(fx fx2, gf gf2) {
        Objects.requireNonNull(fx2, "Packet listener is null.");
        fs$a fs$a = new fs$a(fx2, gf2);
        this.a.put(fx2, fs$a);
    }

    public abstract void a(gj var1);

    public abstract void a(ap$b var1);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(String string2) {
        synchronized (this) {
            block13: {
                int n10 = this.c;
                if (n10 != 0) break block13;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "setChallenge hash = ";
                stringBuilder.append(string3);
                string3 = be.a(string2);
                int n11 = 8;
                string3 = string3.substring(0, n11);
                stringBuilder.append(string3);
                String string4 = stringBuilder.toString();
                com.xiaomi.channel.commonutils.logger.b.a(string4);
                this.a = string2;
                int n12 = 1;
                n10 = 0;
                Object var3_6 = null;
                this.a(n12, 0, null);
                return;
            }
            string2 = "ignore setChallenge because connection was disconnected";
            com.xiaomi.channel.commonutils.logger.b.a(string2);
            return;
        }
    }

    public abstract void a(String var1, String var2);

    public abstract void a(fl[] var1);

    public boolean a() {
        return false;
    }

    public boolean a(long l10) {
        synchronized (this) {
            long l11;
            block4: {
                block3: {
                    long l12 = this.e;
                    l11 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                    if (l11 < 0) break block3;
                    l11 = 1;
                    break block4;
                }
                l11 = 0;
                Object var6_4 = null;
            }
            return (boolean)l11;
        }
    }

    public int b() {
        return this.c;
    }

    public String b() {
        return this.a.b();
    }

    public void b() {
        Object object = this.a;
        boolean bl2 = ((ft)object).a();
        if (bl2 && (object = this.a) == null) {
            int n10;
            bl2 = false;
            object = null;
            Object[] objectArray = "smack.debuggerClass";
            try {
                objectArray = System.getProperty((String)objectArray);
            }
            catch (Throwable throwable) {
                n10 = 0;
                objectArray = null;
            }
            if (objectArray != null) {
                try {
                    object = Class.forName((String)objectArray);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            if (object == null) {
                this.a = object = new bn(this);
            } else {
                Class clazz;
                n10 = 3;
                try {
                    objectArray = new Class[n10];
                    clazz = fs.class;
                }
                catch (Exception exception) {
                    objectArray = new IllegalArgumentException("Can't initialize the configured debugger!", exception);
                    throw objectArray;
                }
                objectArray[0] = clazz;
                clazz = Writer.class;
                int n11 = 1;
                objectArray[n11] = clazz;
                int n12 = 2;
                Class<Reader> clazz2 = Reader.class;
                objectArray[n12] = clazz2;
                object = ((Class)object).getConstructor((Class<?>[])objectArray);
                objectArray = new Object[n11];
                objectArray[0] = this;
                object = ((Constructor)object).newInstance(objectArray);
                object = (ge)object;
                this.a = object;
            }
        }
    }

    public abstract void b(int var1, Exception var2);

    public abstract void b(fl var1);

    public void b(fv fv2) {
        this.a.remove(fv2);
    }

    public void b(fx fx2, gf gf2) {
        Objects.requireNonNull(fx2, "Packet listener is null.");
        fs$a fs$a = new fs$a(fx2, gf2);
        this.b.put(fx2, fs$a);
    }

    public abstract void b(boolean var1);

    public boolean b() {
        int n10 = this.c;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public void c() {
        synchronized (this) {
            long l10 = System.currentTimeMillis();
            this.e = l10;
            return;
        }
    }

    public boolean c() {
        int n10 = this.c;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d() {
        LinkedList linkedList = this.a;
        synchronized (linkedList) {
            LinkedList linkedList2 = this.a;
            linkedList2.clear();
            return;
        }
    }

    public boolean d() {
        synchronized (this) {
            long l10 = System.currentTimeMillis();
            long l11 = this.e;
            l10 -= l11;
            int n10 = fy.a();
            l11 = n10;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 < 0) {
                l12 = 1;
            } else {
                l12 = 0;
                Object var7_5 = null;
            }
            return (boolean)l12;
        }
    }

    public boolean e() {
        synchronized (this) {
            long l10 = System.currentTimeMillis();
            long l11 = this.d;
            l10 -= l11;
            int n10 = fy.a();
            int n11 = 1;
            long l12 = n10 <<= n11;
            long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (l13 >= 0) {
                n11 = 0;
            }
            return n11 != 0;
        }
    }
}

