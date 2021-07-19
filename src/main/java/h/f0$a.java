/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.q1;
import h.f0;
import h.k0;
import h.m;
import h.o0;
import h.o0$b;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class f0$a
implements k0 {
    private final o0 a;
    public final /* synthetic */ f0 b;

    public f0$a(f0 object) {
        this.b = object;
        this.a = object = new o0();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Object object;
        long l10;
        Object object2;
        Object object3 = this.b.g();
        synchronized (object3) {
            object2 = this.b;
            Object object4 = ((f0)object2).k();
            if (object4 != 0) {
                return;
            }
            object2 = this.b;
            if ((object2 = ((f0)object2).i()) == null) {
                object2 = this.b;
                object4 = ((f0)object2).l();
                if (object4 != 0) {
                    object2 = this.b;
                    long l11 = ((m)(object2 = ((f0)object2).g())).S0();
                    long l12 = l11 - (l10 = 0L);
                    object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object4 > 0) {
                        String string2 = "source is closed";
                        object2 = new IOException(string2);
                        throw object2;
                    }
                }
                object2 = this.b;
                boolean bl2 = true;
                ((f0)object2).o(bl2);
                object2 = this.b;
                object2 = ((f0)object2).g();
                if (object2 == null) {
                    String string3 = "null cannot be cast to non-null type java.lang.Object";
                    object2 = new NullPointerException(string3);
                    throw object2;
                }
                object2.notifyAll();
                object4 = 0;
                object2 = null;
            }
            object = q1.a;
        }
        if (object2 == null) return;
        object3 = this.b;
        object = object2.timeout();
        object3 = ((f0)object3).q().timeout();
        l10 = ((o0)object).j();
        o0$b o0$b = o0.e;
        long l13 = ((o0)object3).j();
        long l14 = ((o0)object).j();
        long l15 = o0$b.a(l13, l14);
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        ((o0)object).i(l15, timeUnit);
        boolean bl3 = ((o0)object).f();
        if (bl3) {
            l15 = ((o0)object).d();
            boolean bl4 = ((o0)object3).f();
            if (bl4) {
                l14 = ((o0)object).d();
                long l16 = ((o0)object3).d();
                l14 = Math.min(l14, l16);
                ((o0)object).e(l14);
            }
            try {
                object2.close();
                ((o0)object).i(l10, timeUnit);
            }
            catch (Throwable throwable) {
                timeUnit = TimeUnit.NANOSECONDS;
                ((o0)object).i(l10, timeUnit);
                boolean bl5 = ((o0)object3).f();
                if (!bl5) throw throwable;
                ((o0)object).e(l15);
                throw throwable;
            }
            boolean bl6 = ((o0)object3).f();
            if (!bl6) return;
            ((o0)object).e(l15);
            return;
        }
        bl3 = ((o0)object3).f();
        if (bl3) {
            l15 = ((o0)object3).d();
            ((o0)object).e(l15);
        }
        try {
            object2.close();
            ((o0)object).i(l10, timeUnit);
        }
        catch (Throwable throwable) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            ((o0)object).i(l10, timeUnit2);
            boolean bl7 = ((o0)object3).f();
            if (!bl7) throw throwable;
            ((o0)object).a();
            throw throwable;
        }
        boolean bl8 = ((o0)object3).f();
        if (!bl8) return;
        ((o0)object).a();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void flush() {
        Object object = this.b.g();
        synchronized (object) {
            Object object2;
            block29: {
                block30: {
                    long l11;
                    block31: {
                        block32: {
                            object2 = this.b;
                            boolean n10 = ((f0)object2).k() ^ true;
                            if (!n10) break block29;
                            object2 = this.b;
                            boolean bl3 = ((f0)object2).h();
                            if (bl3) break block30;
                            object2 = this.b;
                            object2 = ((f0)object2).i();
                            if (object2 != null) break block31;
                            object2 = this.b;
                            boolean bl4 = ((f0)object2).l();
                            if (!bl4) break block32;
                            object2 = this.b;
                            object2 = ((f0)object2).g();
                            long l12 = ((m)object2).S0();
                            l11 = 0L;
                            long l13 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                            if (l13 <= 0) break block32;
                            String string2 = "source is closed";
                            object2 = new IOException(string2);
                            throw object2;
                        }
                        boolean bl5 = false;
                        object2 = null;
                    }
                    Object object4 = q1.a;
                    if (object2 == null) return;
                    object = this.b;
                    object4 = object2.timeout();
                    object = ((f0)object).q().timeout();
                    l11 = ((o0)object4).j();
                    Object object3 = o0.e;
                    long l14 = ((o0)object).j();
                    long l15 = ((o0)object4).j();
                    long l10 = object3.a(l14, l15);
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    ((o0)object4).i(l10, timeUnit);
                    boolean bl2 = ((o0)object4).f();
                    if (bl2) {
                        l10 = ((o0)object4).d();
                        boolean bl6 = ((o0)object).f();
                        if (bl6) {
                            l15 = ((o0)object4).d();
                            long l16 = ((o0)object).d();
                            l15 = Math.min(l15, l16);
                            ((o0)object4).e(l15);
                        }
                        try {
                            object2.flush();
                            ((o0)object4).i(l11, timeUnit);
                        }
                        catch (Throwable throwable) {
                            timeUnit = TimeUnit.NANOSECONDS;
                            ((o0)object4).i(l11, timeUnit);
                            boolean bl7 = ((o0)object).f();
                            if (!bl7) throw throwable;
                            ((o0)object4).e(l10);
                            throw throwable;
                        }
                        boolean bl8 = ((o0)object).f();
                        if (!bl8) return;
                        ((o0)object4).e(l10);
                        return;
                    }
                    bl2 = ((o0)object).f();
                    if (bl2) {
                        l10 = ((o0)object).d();
                        ((o0)object4).e(l10);
                    }
                    try {
                        object2.flush();
                        ((o0)object4).i(l11, timeUnit);
                    }
                    catch (Throwable throwable) {
                        object3 = TimeUnit.NANOSECONDS;
                        ((o0)object4).i(l11, (TimeUnit)((Object)object3));
                        boolean bl9 = ((o0)object).f();
                        if (!bl9) throw throwable;
                        ((o0)object4).a();
                        throw throwable;
                    }
                    boolean bl10 = ((o0)object).f();
                    if (!bl10) return;
                    ((o0)object4).a();
                    return;
                }
                String string3 = "canceled";
                object2 = new IOException(string3);
                throw object2;
            }
            object2 = "closed";
            object2 = object2.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object2);
            throw illegalStateException;
            finally {
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void t(m object, long l10) {
        Object object2;
        Object object3;
        void var2_4;
        Object object4;
        f.h2.t.f0.p(object, "source");
        Object object5 = this.b.g();
        synchronized (object5) {
            block20: {
                long l11;
                void cfr_temp_0;
                int n10;
                object4 = this.b;
                Object object6 = ((f0)object4).k() ^ true;
                if (!object6) {
                    object = "closed";
                    object = object.toString();
                    IllegalStateException string5 = new IllegalStateException((String)object);
                    throw string5;
                }
                object4 = this.b;
                object6 = ((f0)object4).h();
                if (object6) {
                    String timeUnit = "canceled";
                    object = new IOException(timeUnit);
                    throw object;
                }
                while ((n10 = (cfr_temp_0 = var2_4 - (l11 = 0L)) == 0 ? 0 : (cfr_temp_0 < 0 ? -1 : 1)) > 0) {
                    object3 = this.b;
                    if ((object3 = ((f0)object3).i()) == null) {
                        object3 = this.b;
                        n10 = ((f0)object3).l();
                        if (n10) {
                            String string3 = "source is closed";
                            object = new IOException(string3);
                            throw object;
                        }
                        object3 = this.b;
                        long l12 = ((f0)object3).j();
                        Object object7 = this.b;
                        long l13 = ((m)(object7 = ((f0)object7).g())).S0();
                        long l14 = (l12 -= l13) - l11;
                        object6 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                        if (!object6) {
                            object4 = this.a;
                            object2 = this.b;
                            object2 = ((f0)object2).g();
                            ((o0)object4).k(object2);
                            object4 = this.b;
                            object6 = ((f0)object4).h();
                            if (!object6) continue;
                            String string2 = "canceled";
                            object = new IOException(string2);
                            throw object;
                        }
                        l11 = Math.min(l12, (long)var2_4);
                        object3 = this.b;
                        object3 = ((f0)object3).g();
                        ((m)object3).t((m)object, l11);
                        var2_4 -= l11;
                        object4 = this.b;
                        object4 = ((f0)object4).g();
                        if (object4 == null) {
                            String string2 = "null cannot be cast to non-null type java.lang.Object";
                            object = new NullPointerException(string2);
                            throw object;
                        }
                        object4.notifyAll();
                        continue;
                    }
                    break block20;
                }
                n10 = 0;
                object3 = null;
            }
            object4 = q1.a;
        }
        if (object3 == null) return;
        object5 = this.b;
        object4 = object3.timeout();
        object5 = ((f0)object5).q().timeout();
        long l15 = ((o0)object4).j();
        object2 = o0.e;
        long l16 = ((o0)object5).j();
        long l17 = ((o0)object4).j();
        l16 = ((o0$b)object2).a(l16, l17);
        object2 = TimeUnit.NANOSECONDS;
        ((o0)object4).i(l16, (TimeUnit)((Object)object2));
        boolean bl2 = ((o0)object4).f();
        if (bl2) {
            l16 = ((o0)object4).d();
            boolean bl3 = ((o0)object5).f();
            if (bl3) {
                l17 = ((o0)object4).d();
                long l18 = ((o0)object5).d();
                l17 = Math.min(l17, l18);
                ((o0)object4).e(l17);
            }
            try {
                object3.t((m)object, (long)var2_4);
                ((o0)object4).i(l15, (TimeUnit)((Object)object2));
            }
            catch (Throwable throwable) {
                TimeUnit string4 = TimeUnit.NANOSECONDS;
                ((o0)object4).i(l15, string4);
                boolean bl4 = ((o0)object5).f();
                if (!bl4) throw throwable;
                ((o0)object4).e(l16);
                throw throwable;
            }
            boolean bl5 = ((o0)object5).f();
            if (!bl5) return;
            ((o0)object4).e(l16);
            return;
        }
        bl2 = ((o0)object5).f();
        if (bl2) {
            l16 = ((o0)object5).d();
            ((o0)object4).e(l16);
        }
        try {
            object3.t((m)object, (long)var2_4);
            ((o0)object4).i(l15, (TimeUnit)((Object)object2));
        }
        catch (Throwable throwable) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            ((o0)object4).i(l15, timeUnit);
            boolean bl5 = ((o0)object5).f();
            if (!bl5) throw throwable;
            ((o0)object4).a();
            throw throwable;
        }
        boolean bl6 = ((o0)object5).f();
        if (!bl6) return;
        ((o0)object4).a();
    }

    public o0 timeout() {
        return this.a;
    }
}

