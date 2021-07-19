/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.xiaomi.push.service;

import android.os.SystemClock;
import com.xiaomi.push.service.g;
import com.xiaomi.push.service.g$b;
import com.xiaomi.push.service.g$c$a;
import com.xiaomi.push.service.g$d;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class g$c
extends Thread {
    private volatile long a;
    private g$c$a a;
    private volatile boolean a = false;
    private long b;
    private boolean b = 50;
    private boolean c;

    public g$c(String string2, boolean bl2) {
        g$c$a g$c$a;
        this.a = g$c$a = new g$c$a(null);
        this.setName(string2);
        this.setDaemon(bl2);
        this.start();
    }

    public static /* synthetic */ g$c$a a(g$c g$c) {
        return g$c.a;
    }

    public static /* synthetic */ void a(g$c g$c, g$d g$d) {
        g$c.a(g$d);
    }

    private void a(g$d g$d) {
        this.a.a(g$d);
        this.notify();
    }

    public static /* synthetic */ boolean a(g$c g$c) {
        return g$c.b;
    }

    public static /* synthetic */ boolean a(g$c g$c, boolean bl2) {
        g$c.c = bl2;
        return bl2;
    }

    public void a() {
        synchronized (this) {
            boolean bl2 = true;
            this.b = bl2;
            g$c$a g$c$a = this.a;
            g$c$a.a();
            this.notify();
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a() {
        void var1_5;
        boolean bl2 = this.a;
        if (bl2) {
            long l10 = SystemClock.uptimeMillis();
            long l11 = this.a;
            long l12 = (l10 -= l11) - (l11 = 600000L);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                return (boolean)var1_5;
            }
        }
        boolean bl3 = false;
        return (boolean)var1_5;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        while (true) {
            block31: {
                synchronized (this) {
                    long l10;
                    int n10;
                    Object object = this.b;
                    if (object != 0) {
                        return;
                    }
                    g$c$a g$c$a = this.a;
                    object = g$c$a.a();
                    if (object != 0) {
                        object = this.c;
                        if (object != 0) {
                            return;
                        }
                        this.wait();
                        break block31;
                    }
                    long l11 = g.a();
                    Object object2 = this.a;
                    object2 = ((g$c$a)object2).a();
                    Object object3 = ((g$d)object2).a;
                    synchronized (object3) {
                        block32: {
                            n10 = ((g$d)object2).a;
                            if (n10 == 0) break block32;
                            g$c$a = this.a;
                            g$c$a.b(0);
                            break block31;
                        }
                        l10 = ((g$d)object2).a - l11;
                    }
                    l11 = 0L;
                    long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    long l13 = 50;
                    if (l12 > 0) {
                        l11 = this.b;
                        long l14 = l10 - l11;
                        Object object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                        if (object4 > 0) {
                            l10 = l11;
                        }
                        this.b = l11 += l13;
                        long l15 = 500L;
                        long l16 = l11 - l15;
                        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                        if (object > 0) {
                            this.b = l15;
                        }
                        this.wait(l10);
                        break block31;
                    }
                    this.b = l13;
                    object3 = ((g$d)object2).a;
                    synchronized (object3) {
                        Object object5 = this.a;
                        object5 = ((g$c$a)object5).a();
                        l10 = ((g$d)object5).a;
                        l13 = ((g$d)object2).a;
                        n10 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
                        if (n10 != 0) {
                            object5 = this.a;
                            n10 = g$c$a.a((g$c$a)object5, (g$d)object2);
                        } else {
                            n10 = 0;
                            object5 = null;
                        }
                        boolean bl2 = ((g$d)object2).a;
                        if (bl2) {
                            g$c$a = this.a;
                            int n11 = g$c$a.a(g$c$a, (g$d)object2);
                            g$c$a.b(n11);
                            break block31;
                        } else {
                            l10 = ((g$d)object2).a;
                            ((g$d)object2).a(l10);
                            g$c$a g$c$a2 = this.a;
                            g$c$a2.b(n10);
                            ((g$d)object2).a = l11;
                            // MONITOREXIT @DISABLED, blocks:[16, 20, 27, 14] lbl74 : MonitorExitStatement: MONITOREXIT : var6_5
                            // MONITOREXIT @DISABLED, blocks:[20, 27, 14] lbl75 : MonitorExitStatement: MONITOREXIT : this
                            object = 1;
                            try {
                                long l17;
                                this.a = l17 = SystemClock.uptimeMillis();
                                this.a = object;
                                g$b g$b = ((g$d)object2).a;
                                g$b.run();
                                this.a = false;
                            }
                            catch (Throwable throwable) {
                                synchronized (this) {
                                    this.b = object;
                                    throw throwable;
                                }
                            }
                        }
                    }
                    catch (InterruptedException interruptedException) {}
                }
            }
        }
    }
}

