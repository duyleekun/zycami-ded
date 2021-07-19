/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.x;
import h.m;
import h.m0;
import h.o0;
import h.o0$b;
import java.io.Closeable;
import java.util.concurrent.TimeUnit;

public final class x$c
implements m0 {
    private final o0 a;
    public final /* synthetic */ x b;

    public x$c(x object) {
        this.b = object;
        this.a = object = new o0();
    }

    public void close() {
        Closeable closeable = x.q(this.b);
        boolean bl2 = f0.g(closeable, this);
        if (bl2) {
            closeable = this.b;
            x.C((x)closeable, null);
        }
    }

    public long read(m m10, long l10) {
        long l11;
        Object object;
        block22: {
            block23: {
                TimeUnit timeUnit;
                long l12;
                long l13;
                o0 o02;
                Object object2;
                block26: {
                    Object object3;
                    x$c x$c;
                    block21: {
                        long l14;
                        block24: {
                            long l15;
                            block25: {
                                block20: {
                                    x$c = this;
                                    object = m10;
                                    l11 = l10;
                                    object3 = "sink";
                                    f0.p(m10, (String)object3);
                                    l14 = 0L;
                                    long l16 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
                                    if (l16 >= 0) {
                                        l16 = 1;
                                    } else {
                                        l16 = 0;
                                        object2 = null;
                                    }
                                    if (l16 == false) break block22;
                                    object2 = x.q(x$c.b);
                                    l16 = (long)f0.g(object2, x$c);
                                    if (l16 == false) break block23;
                                    object2 = x.B(x$c.b).timeout();
                                    o02 = x$c.a;
                                    l13 = ((o0)object2).j();
                                    o0$b o0$b = o0.e;
                                    long l17 = o02.j();
                                    l12 = ((o0)object2).j();
                                    l15 = o0$b.a(l17, l12);
                                    timeUnit = TimeUnit.NANOSECONDS;
                                    ((o0)object2).i(l15, timeUnit);
                                    boolean bl2 = ((o0)object2).f();
                                    if (!bl2) break block24;
                                    l15 = ((o0)object2).d();
                                    boolean bl3 = o02.f();
                                    if (bl3) {
                                        l12 = ((o0)object2).d();
                                        l14 = o02.d();
                                        l14 = Math.min(l12, l14);
                                        ((o0)object2).e(l14);
                                    }
                                    try {
                                        object3 = x$c.b;
                                    }
                                    catch (Throwable throwable) {
                                        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                                        ((o0)object2).i(l13, timeUnit2);
                                        boolean bl4 = o02.f();
                                        if (bl4) {
                                            ((o0)object2).e(l15);
                                        }
                                        throw throwable;
                                    }
                                    l11 = x.a((x)object3, l11);
                                    l14 = 0L;
                                    long l18 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
                                    if (l18 != false) break block20;
                                    l12 = -1;
                                    break block25;
                                }
                                object3 = x$c.b;
                                object3 = x.B((x)object3);
                                l12 = object3.read((m)object, l11);
                            }
                            ((o0)object2).i(l13, timeUnit);
                            boolean bl5 = o02.f();
                            if (bl5) {
                                ((o0)object2).e(l15);
                            }
                            return l12;
                        }
                        boolean bl6 = o02.f();
                        if (bl6) {
                            l14 = o02.d();
                            ((o0)object2).e(l14);
                        }
                        try {
                            object3 = x$c.b;
                        }
                        catch (Throwable throwable) {
                            TimeUnit timeUnit3 = TimeUnit.NANOSECONDS;
                            ((o0)object2).i(l13, timeUnit3);
                            boolean bl7 = o02.f();
                            if (bl7) {
                                ((o0)object2).a();
                            }
                            throw throwable;
                        }
                        l11 = x.a((x)object3, l11);
                        l14 = 0L;
                        bl6 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
                        if (bl6) break block21;
                        l12 = -1;
                        break block26;
                    }
                    object3 = x$c.b;
                    object3 = x.B((x)object3);
                    l12 = object3.read((m)object, l11);
                }
                ((o0)object2).i(l13, timeUnit);
                boolean bl8 = o02.f();
                if (bl8) {
                    ((o0)object2).a();
                }
                return l12;
            }
            String string2 = "closed".toString();
            object = new IllegalStateException(string2);
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l11);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public o0 timeout() {
        return this.a;
    }
}

