/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.h2.t.u;
import f.q1;
import g.h0.l.d;
import g.h0.l.g;
import g.h0.l.g$d;
import g.s;
import h.k;
import h.k0;
import h.m;
import h.o0;
import java.util.List;

public final class g$b
implements k0 {
    private final m a;
    private s b;
    private boolean c;
    private boolean d;
    public final /* synthetic */ g e;

    public g$b(g object, boolean bl2) {
        this.e = object;
        this.d = bl2;
        this.a = object = new m();
    }

    public /* synthetic */ g$b(g g10, boolean bl2, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            bl2 = false;
        }
        this(g10, bl2);
    }

    /*
     * Loose catch block
     */
    private final void a(boolean bl2) {
        g g10 = this.e;
        synchronized (g10) {
            Object object;
            long l10;
            Object object2;
            block47: {
                long l11;
                Object object3;
                long l12;
                object2 = this.e;
                object2 = ((g)object2).u();
                ((k)object2).v();
                while (true) {
                    object2 = this.e;
                    l12 = ((g)object2).t();
                    object3 = this.e;
                    l11 = ((g)object3).s();
                    long l13 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                    if (l13 < 0) break;
                    l13 = (long)this.d;
                    if (l13 != false) break;
                    l13 = (long)this.c;
                    if (l13 != false) break;
                    object2 = this.e;
                    object2 = ((g)object2).i();
                    if (object2 != null) break;
                    object2 = this.e;
                    ((g)object2).J();
                    continue;
                    break;
                }
                object2 = this.e;
                {
                    catch (Throwable throwable) {
                        throw throwable;
                    }
                }
                object2 = ((g)object2).u();
                ((g$d)object2).D();
                object2 = this.e;
                ((g)object2).c();
                object2 = this.e;
                l12 = ((g)object2).s();
                object3 = this.e;
                l11 = ((g)object3).t();
                l12 -= l11;
                object3 = this.a;
                l11 = ((m)object3).S0();
                l10 = Math.min(l12, l11);
                object2 = this.e;
                long l14 = ((g)object2).t() + l10;
                ((g)object2).G(l14);
                if (!bl2) break block47;
                object = this.a;
                l12 = ((m)object).S0();
                bl2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                if (bl2) break block47;
                object = this.e;
                object = ((g)object).i();
                if (object != null) break block47;
                bl2 = true;
            }
            bl2 = false;
            object = null;
            object = q1.a;
            object = this.e.u();
            ((k)object).v();
            try {
                object = this.e;
                d d10 = ((g)object).h();
                object = this.e;
                int n10 = ((g)object).k();
                m m10 = this.a;
                d10.m1(n10, bl2, m10, l10);
                return;
            }
            finally {
                this.e.u().D();
            }
            catch (Throwable throwable) {
                object2 = this.e;
                object2 = ((g)object2).u();
                ((g$d)object2).D();
                throw throwable;
            }
            finally {
            }
        }
    }

    public final s B() {
        return this.b;
    }

    public final void C(boolean bl2) {
        this.c = bl2;
    }

    public final void D(boolean bl2) {
        this.d = bl2;
    }

    public final void E(s s10) {
        this.b = s10;
    }

    public void close() {
        Object object = this.e;
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            stringBuilder.append((String)object2);
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            AssertionError assertionError = new AssertionError(object);
            throw assertionError;
        }
        object = this.e;
        synchronized (object) {
            boolean bl3;
            Object object3;
            block24: {
                boolean bl4;
                long l10;
                long l11;
                Object object4;
                Object object5;
                g g10;
                int n10;
                block26: {
                    block25: {
                        block23: {
                            block22: {
                                bl2 = this.c;
                                if (!bl2) break block22;
                                return;
                            }
                            object3 = this.e;
                            object3 = object3.i();
                            n10 = 0;
                            g10 = null;
                            bl3 = true;
                            if (object3 == null) {
                                bl2 = bl3;
                                break block23;
                            }
                            bl2 = false;
                            object3 = null;
                        }
                        try {
                            object5 = q1.a;
                            object = this.e.p();
                            object4 = ((g$b)object).d;
                            if (object4 != 0) break block24;
                            object = this.a;
                            l11 = ((m)object).S0();
                            long l12 = l11 - (l10 = 0L);
                            object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                            if (object4 <= 0) break block25;
                        }
                        catch (Throwable throwable) {
                            throw throwable;
                        }
                        finally {
                        }
                        object4 = bl3;
                        break block26;
                    }
                    object4 = 0;
                    object = null;
                }
                object5 = this.b;
                if (object5 != null) {
                    bl4 = bl3;
                } else {
                    bl4 = false;
                    object5 = null;
                }
                if (bl4) {
                    long l13;
                    while ((object4 = (Object)((l13 = (l11 = ((m)(object = this.a)).S0()) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1))) > 0) {
                        this.a(false);
                    }
                    object = this.e.h();
                    g10 = this.e;
                    n10 = g10.k();
                    object5 = this.b;
                    f0.m(object5);
                    object5 = g.h0.d.W((s)object5);
                    ((d)object).n1(n10, bl2, (List)object5);
                } else if (object4 != 0) {
                    long l14;
                    long l15;
                    while ((object4 = (Object)((l15 = (l14 = ((m)(object = this.a)).S0()) - l10) == 0L ? 0 : (l15 < 0L ? -1 : 1))) > 0) {
                        this.a(bl3);
                    }
                } else if (bl2) {
                    object5 = this.e.h();
                    object = this.e;
                    int n11 = ((g)object).k();
                    boolean bl5 = true;
                    long l16 = 0L;
                    ((d)object5).m1(n11, bl5, null, l16);
                }
            }
            object = this.e;
            synchronized (object) {
                this.c = bl3;
                object3 = q1.a;
                this.e.h().flush();
                this.e.b();
                return;
            }
        }
    }

    public void flush() {
        Object object = this.e;
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            stringBuilder.append((String)object2);
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            AssertionError assertionError = new AssertionError(object);
            throw assertionError;
        }
        object = this.e;
        synchronized (object) {
            long l10;
            long l11;
            long l12;
            long l13;
            Object object3 = this.e;
            ((g)object3).c();
            object3 = q1.a;
            while ((l13 = (l12 = (l11 = ((m)(object = this.a)).S0()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                l13 = 0;
                this.a(false);
                object = this.e.h();
                ((d)object).flush();
            }
            return;
            finally {
            }
        }
    }

    public final boolean h() {
        return this.c;
    }

    public final boolean q() {
        return this.d;
    }

    public void t(m object, long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        f0.p(object, "source");
        Object object2 = this.e;
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(object2))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            charSequence.append((String)object3);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(object2);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
        object2 = this.a;
        ((m)object2).t((m)object, l10);
        while ((l14 = (l13 = (l12 = ((m)(object = this.a)).S0()) - (l11 = 16384L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0) {
            l14 = 0;
            object = null;
            this.a(false);
        }
    }

    public o0 timeout() {
        return this.e.u();
    }
}

