/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.i0;
import h.j0;
import h.m;
import java.io.Closeable;
import java.io.Serializable;
import java.util.Arrays;

public final class m$a
implements Closeable {
    public m a;
    public boolean b;
    private i0 c;
    public long d = -1;
    public byte[] e;
    public int f;
    public int g;

    public m$a() {
        int n10;
        this.f = n10 = -1;
        this.g = n10;
    }

    public final int B(long l10) {
        Object object = this.a;
        if (object != null) {
            long l11;
            int n10 = -1;
            long l12 = n10;
            long l13 = l10 - l12;
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 >= 0 && (object2 = (l11 = l10 - (l12 = ((m)object).S0())) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
                long l14;
                l12 = -1;
                long l15 = l10 - l12;
                object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object2 != false && (object2 = (l14 = l10 - (l12 = ((m)object).S0())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
                    int n11;
                    i0 i02;
                    long l16;
                    long l17;
                    long l18 = 0L;
                    long l19 = ((m)object).S0();
                    i0 i03 = ((m)object).a;
                    i0 i04 = this.c;
                    if (i04 != null) {
                        l17 = this.d;
                        int n12 = this.f;
                        f0.m(i04);
                        int n13 = i04.b;
                        l16 = n12 -= n13;
                        long l20 = (l17 -= l16) - l10;
                        n13 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
                        if (n13 > 0) {
                            i02 = this.c;
                            i04 = i03;
                            i03 = i02;
                            l19 = l17;
                        } else {
                            i0 i05;
                            i04 = i05 = this.c;
                            l18 = l17;
                        }
                    } else {
                        i04 = i03;
                    }
                    l17 = l19 - l10;
                    l16 = l10 - l18;
                    long l21 = l17 == l16 ? 0 : (l17 < l16 ? -1 : 1);
                    if (l21 > 0) {
                        while (true) {
                            f0.m(i04);
                            n11 = i04.c;
                            int n14 = i04.b;
                            l17 = (long)(n11 - n14) + l18;
                            long l22 = l10 == l17 ? 0 : (l10 < l17 ? -1 : 1);
                            if (l22 >= 0) {
                                l19 = n11 -= n14;
                                l18 += l19;
                                i04 = i04.f;
                                continue;
                            }
                            break;
                        }
                    } else {
                        while ((n10 = (int)(l19 == l10 ? 0 : (l19 < l10 ? -1 : 1))) > 0) {
                            f0.m(i03);
                            i03 = i03.g;
                            f0.m(i03);
                            n10 = i03.c;
                            object2 = i03.b;
                            l18 = n10 -= object2;
                            l19 -= l18;
                        }
                        l18 = l19;
                        i04 = i03;
                    }
                    if ((n11 = (int)(this.b ? 1 : 0)) != 0) {
                        f0.m(i04);
                        n11 = (int)(i04.d ? 1 : 0);
                        if (n11 != 0) {
                            i02 = i04.f();
                            i0 i06 = ((m)object).a;
                            if (i06 == i04) {
                                ((m)object).a = i02;
                            }
                            i04 = i04.c(i02);
                            object = i04.g;
                            f0.m(object);
                            ((i0)object).b();
                        }
                    }
                    this.c = i04;
                    this.d = l10;
                    f0.m(i04);
                    object = i04.a;
                    this.e = (byte[])object;
                    int n15 = i04.b;
                    int n16 = (int)(l10 - l18);
                    this.f = n15 += n16;
                    this.g = n16 = i04.c;
                    return n16 - n15;
                }
                this.c = null;
                this.d = l10;
                this.e = null;
                this.f = n10;
                this.g = n10;
                return n10;
            }
            object2 = 2;
            Object[] objectArray = new Object[object2];
            Object object3 = Long.valueOf(l10);
            objectArray[0] = object3;
            Long l23 = ((m)object).S0();
            objectArray[1] = l23;
            object3 = Arrays.copyOf(objectArray, (int)object2);
            object3 = String.format("offset=%s > size=%s", object3);
            f0.o(object3, "java.lang.String.format(format, *args)");
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException((String)object3);
            throw arrayIndexOutOfBoundsException;
        }
        String string2 = "not attached to a buffer".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public final long a(int n10) {
        int n11 = 1;
        int n12 = 0;
        int n13 = n10 > 0 ? n11 : 0;
        if (n13 != 0) {
            Object object;
            n13 = 8192;
            if (n10 > n13) {
                n11 = 0;
                object = null;
            }
            if (n11 != 0) {
                object = this.a;
                if (object != null) {
                    n12 = this.b;
                    if (n12 != 0) {
                        long l10 = ((m)object).S0();
                        Object object2 = ((m)object).V0(n10);
                        n12 = ((i0)object2).c;
                        n12 = 8192 - n12;
                        ((i0)object2).c = n13;
                        long l11 = n12;
                        long l12 = l10 + l11;
                        ((m)object).O0(l12);
                        this.c = object2;
                        this.d = l10;
                        object2 = ((i0)object2).a;
                        this.e = (byte[])object2;
                        this.f = n10 = 8192 - n12;
                        this.g = n13;
                        return l11;
                    }
                    object = "expandBuffer() only permitted for read/write buffers".toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object);
                    throw illegalStateException;
                }
                object = "not attached to a buffer".toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)object);
                throw illegalStateException;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("minByteCount > Segment.SIZE: ");
            ((StringBuilder)object).append(n10);
            String string2 = ((StringBuilder)object).toString();
            string2 = string2.toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        Serializable serializable = new StringBuilder();
        serializable.append("minByteCount <= 0: ");
        serializable.append(n10);
        String string3 = serializable.toString();
        string3 = string3.toString();
        serializable = new IllegalArgumentException(string3);
        throw serializable;
    }

    public void close() {
        int n10;
        Object object = this.a;
        if (object != null) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            this.a = null;
            this.c = null;
            this.d = -1;
            this.e = null;
            this.f = n10 = -1;
            this.g = n10;
            return;
        }
        String string2 = "not attached to a buffer".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final int h() {
        IllegalStateException illegalStateException;
        long l10 = this.d;
        m m10 = this.a;
        f0.m(m10);
        long l11 = m10.S0();
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            l12 = 1;
        } else {
            l12 = 0;
            illegalStateException = null;
        }
        if (l12 != false) {
            l10 = this.d;
            l11 = -1;
            long l13 = l10 - l11;
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object == false) {
                l10 = 0L;
            } else {
                object = this.g;
                int n10 = this.f;
                l11 = object -= n10;
                l10 += l11;
            }
            return this.B(l10);
        }
        String string2 = "no more bytes".toString();
        illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final long q(long l10) {
        m$a m$a = this;
        long l11 = l10;
        Object object = this.a;
        if (object == null) {
            String string2 = "not attached to a buffer".toString();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        boolean bl2 = this.b;
        if (!bl2) {
            String string3 = "resizeBuffer() only permitted for read/write buffers".toString();
            IllegalStateException illegalStateException = new IllegalStateException(string3);
            throw illegalStateException;
        }
        long l12 = ((m)object).S0();
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        int n10 = 1;
        long l14 = 0L;
        if (l13 <= 0) {
            int n11;
            Object object2 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
            int n12 = object2 >= 0 ? n10 : 0;
            if (n12 == 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("newSize < 0: ");
                ((StringBuilder)object).append(l11);
                String string4 = ((StringBuilder)object).toString();
                string4 = string4.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
                throw illegalArgumentException;
            }
            long l15 = l12 - l11;
            while ((n10 = (int)(l15 == l14 ? 0 : (l15 < l14 ? -1 : 1))) > 0) {
                i0 i02 = ((m)object).a;
                f0.m(i02);
                i02 = i02.g;
                f0.m(i02);
                int n13 = i02.c;
                int n14 = i02.b;
                n14 = n13 - n14;
                long l16 = n14;
                long l17 = l16 == l15 ? 0 : (l16 < l15 ? -1 : 1);
                if (l17 <= 0) {
                    i0 i03;
                    ((m)object).a = i03 = i02.b();
                    j0.d(i02);
                    l15 -= l16;
                    continue;
                }
                int n15 = (int)l15;
                i02.c = n13 -= n15;
                break;
            }
            Object var24_24 = null;
            m$a.c = null;
            m$a.d = l11;
            m$a.e = null;
            m$a.f = n11 = -1;
            m$a.g = n11;
        } else if (l13 > 0) {
            long l18;
            long l19 = l10 - l12;
            int n16 = n10;
            while ((l18 = l19 == l14 ? 0 : (l19 < l14 ? -1 : 1)) > 0) {
                int n17;
                int n18;
                i0 i04 = ((m)object).V0(n10);
                int n19 = i04.c;
                long l20 = 8192 - n19;
                l20 = Math.min(l19, l20);
                n19 = (int)l20;
                i04.c = n18 = i04.c + n19;
                long l21 = n19;
                l19 -= l21;
                if (n17 != 0) {
                    m$a.c = i04;
                    m$a.d = l12;
                    byte[] byArray = i04.a;
                    m$a.e = byArray;
                    m$a.f = n17 = n18 - n19;
                    m$a.g = n18;
                    n17 = 0;
                    byArray = null;
                }
                n10 = 1;
            }
        }
        ((m)object).O0(l11);
        return l12;
    }
}

