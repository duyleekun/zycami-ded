/*
 * Decompiled with CFR 0.151.
 */
package h.q0;

import f.h2.s.q;
import f.h2.t.f0;
import f.x1.n;
import h.i0;
import h.j;
import h.m;
import java.io.Serializable;
import okio.ByteString;
import okio.SegmentedByteString;

public final class e {
    public static final /* synthetic */ void a(SegmentedByteString segmentedByteString, int n10, int n11, q q10) {
        e.l(segmentedByteString, n10, n11, q10);
    }

    public static final int b(int[] nArray, int n10, int n11, int n12) {
        String string2 = "$this$binarySearch";
        f0.p(nArray, string2);
        n12 += -1;
        while (n11 <= n12) {
            int n13 = n11 + n12 >>> 1;
            int n14 = nArray[n13];
            if (n14 < n10) {
                n11 = ++n13;
                continue;
            }
            if (n14 > n10) {
                n12 = n13 += -1;
                continue;
            }
            return n13;
        }
        return -n11 + -1;
    }

    public static final boolean c(SegmentedByteString segmentedByteString, Object object) {
        boolean bl2;
        int n10;
        int n11;
        String string2 = "$this$commonEquals";
        f0.p(segmentedByteString, string2);
        boolean bl3 = true;
        if (!(object == segmentedByteString || (n11 = object instanceof ByteString) != 0 && (n11 = ((ByteString)(object = (ByteString)object)).size()) == (n10 = segmentedByteString.size()) && (bl2 = segmentedByteString.rangeEquals(0, (ByteString)object, 0, n11 = segmentedByteString.size())))) {
            bl3 = false;
            string2 = null;
        }
        return bl3;
    }

    public static final int d(SegmentedByteString segmentedByteString) {
        f0.p(segmentedByteString, "$this$commonGetSize");
        int[] nArray = segmentedByteString.getDirectory$okio();
        int n10 = segmentedByteString.getSegments$okio().length + -1;
        return nArray[n10];
    }

    public static final int e(SegmentedByteString segmentedByteString) {
        Object object = "$this$commonHashCode";
        f0.p(segmentedByteString, (String)object);
        int n10 = segmentedByteString.getHashCode$okio();
        if (n10 != 0) {
            return n10;
        }
        object = segmentedByteString.getSegments$okio();
        n10 = ((Object)object).length;
        int n11 = 1;
        int n12 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int[] nArray = segmentedByteString.getDirectory$okio();
            int n13 = n10 + i10;
            int n14 = nArray[n13];
            int[] nArray2 = segmentedByteString.getDirectory$okio();
            n13 = nArray2[i10];
            byte[] byArray = segmentedByteString.getSegments$okio()[i10];
            n12 = n13 - n12 + n14;
            while (n14 < n12) {
                n11 *= 31;
                byte by2 = byArray[n14];
                n11 += by2;
                ++n14;
            }
            n12 = n13;
        }
        segmentedByteString.setHashCode$okio(n11);
        return n11;
    }

    public static final byte f(SegmentedByteString object, int n10) {
        int n11;
        f0.p(object, "$this$commonInternalGet");
        int[] nArray = ((SegmentedByteString)object).getDirectory$okio();
        Object object2 = ((SegmentedByteString)object).getSegments$okio();
        Object object3 = ((byte[][])object2).length + -1;
        long l10 = nArray[object3];
        long l11 = n10;
        long l12 = 1L;
        j.e(l10, l11, l12);
        int n12 = e.n((SegmentedByteString)object, n10);
        if (n12 == 0) {
            object3 = 0;
            object2 = null;
        } else {
            object2 = ((SegmentedByteString)object).getDirectory$okio();
            n11 = n12 + -1;
            object3 = object2[n11];
        }
        int[] nArray2 = ((SegmentedByteString)object).getDirectory$okio();
        int n13 = ((SegmentedByteString)object).getSegments$okio().length + n12;
        n11 = nArray2[n13];
        object = ((SegmentedByteString)object).getSegments$okio()[n12];
        n10 = n10 - object3 + n11;
        return (byte)object[n10];
    }

    public static final boolean g(SegmentedByteString segmentedByteString, int n10, ByteString byteString, int n11, int n12) {
        int n13;
        f0.p(segmentedByteString, "$this$commonRangeEquals");
        f0.p(byteString, "other");
        if (n10 >= 0 && n10 <= (n13 = segmentedByteString.size() - n12)) {
            n12 += n10;
            n13 = e.n(segmentedByteString, n10);
            while (n10 < n12) {
                int n14;
                Object[] objectArray;
                int n15;
                if (n13 == 0) {
                    n15 = 0;
                    objectArray = null;
                } else {
                    objectArray = segmentedByteString.getDirectory$okio();
                    n14 = n13 + -1;
                    n15 = objectArray[n14];
                }
                int[] nArray = segmentedByteString.getDirectory$okio();
                n14 = nArray[n13] - n15;
                int[] nArray2 = segmentedByteString.getDirectory$okio();
                byte[][] byArray = segmentedByteString.getSegments$okio();
                int n16 = byArray.length + n13;
                int n17 = nArray2[n16];
                n14 += n15;
                n14 = Math.min(n12, n14) - n10;
                n15 = n10 - n15;
                n17 += n15;
                objectArray = segmentedByteString.getSegments$okio()[n13];
                n15 = (int)(byteString.rangeEquals(n11, (byte[])objectArray, n17, n14) ? 1 : 0);
                if (n15 == 0) {
                    return false;
                }
                n11 += n14;
                n10 += n14;
                ++n13;
            }
            return true;
        }
        return false;
    }

    public static final boolean h(SegmentedByteString segmentedByteString, int n10, byte[] byArray, int n11, int n12) {
        int n13;
        f0.p(segmentedByteString, "$this$commonRangeEquals");
        f0.p(byArray, "other");
        if (n10 >= 0 && n10 <= (n13 = segmentedByteString.size() - n12) && n11 >= 0 && n11 <= (n13 = byArray.length - n12)) {
            n12 += n10;
            n13 = e.n(segmentedByteString, n10);
            while (n10 < n12) {
                int n14;
                Object[] objectArray;
                int n15;
                if (n13 == 0) {
                    n15 = 0;
                    objectArray = null;
                } else {
                    objectArray = segmentedByteString.getDirectory$okio();
                    n14 = n13 + -1;
                    n15 = objectArray[n14];
                }
                int[] nArray = segmentedByteString.getDirectory$okio();
                n14 = nArray[n13] - n15;
                int[] nArray2 = segmentedByteString.getDirectory$okio();
                byte[][] byArray2 = segmentedByteString.getSegments$okio();
                int n16 = byArray2.length + n13;
                int n17 = nArray2[n16];
                n14 += n15;
                n14 = Math.min(n12, n14) - n10;
                n15 = n10 - n15;
                n17 += n15;
                objectArray = segmentedByteString.getSegments$okio()[n13];
                n15 = (int)(j.d((byte[])objectArray, n17, byArray, n11, n14) ? 1 : 0);
                if (n15 == 0) {
                    return false;
                }
                n11 += n14;
                n10 += n14;
                ++n13;
            }
            return true;
        }
        return false;
    }

    public static final ByteString i(SegmentedByteString object, int n10, int n11) {
        f0.p(object, "$this$commonSubstring");
        Object object2 = 0;
        int n12 = 1;
        int n13 = n10 >= 0 ? n12 : 0;
        if (n13 != 0) {
            n13 = ((ByteString)object).size();
            n13 = n11 <= n13 ? n12 : 0;
            String string2 = "endIndex=";
            if (n13 != 0) {
                byte[][] byArray;
                int n14;
                n13 = n11 - n10;
                if (n13 >= 0) {
                    n14 = n12;
                } else {
                    n14 = 0;
                    byArray = null;
                }
                if (n14 != 0) {
                    int n15;
                    if (n10 == 0 && n11 == (n15 = ((ByteString)object).size())) {
                        return object;
                    }
                    if (n10 == n11) {
                        return ByteString.EMPTY;
                    }
                    n15 = e.n((SegmentedByteString)object, n10);
                    n11 -= n12;
                    n11 = e.n((SegmentedByteString)object, n11);
                    byArray = ((SegmentedByteString)object).getSegments$okio();
                    int n16 = n11 + 1;
                    byArray = (byte[][])n.M1((Object[])byArray, n15, n16);
                    n16 = byArray.length * 2;
                    int[] nArray = new int[n16];
                    if (n15 <= n11) {
                        int n17 = 0;
                        int n18 = n15;
                        while (true) {
                            int n19;
                            int[] nArray2 = ((SegmentedByteString)object).getDirectory$okio();
                            nArray[n17] = n19 = Math.min(nArray2[n18] - n10, n13);
                            n19 = n17 + 1;
                            int n20 = byArray.length;
                            n17 += n20;
                            int[] nArray3 = ((SegmentedByteString)object).getDirectory$okio();
                            byte[][] byArray2 = ((SegmentedByteString)object).getSegments$okio();
                            int n21 = byArray2.length + n18;
                            nArray[n17] = n20 = nArray3[n21];
                            if (n18 == n11) break;
                            ++n18;
                            n17 = n19;
                        }
                    }
                    if (n15 != 0) {
                        object = ((SegmentedByteString)object).getDirectory$okio();
                        object2 = object[n15 -= n12];
                    }
                    int n22 = byArray.length;
                    n11 = nArray[n22];
                    nArray[n22] = n11 += (n10 -= object2);
                    object = new SegmentedByteString(byArray, nArray);
                    return object;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(n11);
                ((StringBuilder)object).append(" < beginIndex=");
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                object = object.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            Serializable serializable = new StringBuilder();
            serializable.append(string2);
            serializable.append(n11);
            serializable.append(" > length(");
            int n23 = ((ByteString)object).size();
            serializable.append(n23);
            serializable.append(')');
            object = serializable.toString();
            object = object.toString();
            serializable = new IllegalArgumentException((String)object);
            throw serializable;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("beginIndex=");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" < 0");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final byte[] j(SegmentedByteString segmentedByteString) {
        f0.p(segmentedByteString, "$this$commonToByteArray");
        int n10 = segmentedByteString.size();
        byte[] byArray = new byte[n10];
        byte[][] byArray2 = segmentedByteString.getSegments$okio();
        int n11 = byArray2.length;
        int n12 = 0;
        int n13 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            int[] nArray = segmentedByteString.getDirectory$okio();
            int n14 = n11 + i10;
            int n15 = nArray[n14];
            int[] nArray2 = segmentedByteString.getDirectory$okio();
            n14 = nArray2[i10];
            byte[] byArray3 = segmentedByteString.getSegments$okio()[i10];
            n12 = n14 - n12;
            int n16 = n15 + n12;
            n.W0(byArray3, byArray, n13, n15, n16);
            n13 += n12;
            n12 = n14;
        }
        return byArray;
    }

    public static final void k(SegmentedByteString segmentedByteString, m m10, int n10, int n11) {
        f0.p(segmentedByteString, "$this$commonWrite");
        String string2 = "buffer";
        f0.p(m10, string2);
        n11 += n10;
        int n12 = e.n(segmentedByteString, n10);
        while (n10 < n11) {
            int n13;
            Object object;
            int n14;
            if (n12 == 0) {
                n14 = 0;
                object = null;
            } else {
                object = segmentedByteString.getDirectory$okio();
                n13 = n12 + -1;
                n14 = object[n13];
            }
            int[] nArray = segmentedByteString.getDirectory$okio();
            n13 = nArray[n12] - n14;
            Object object2 = segmentedByteString.getDirectory$okio();
            int n15 = segmentedByteString.getSegments$okio().length + n12;
            int n16 = object2[n15];
            n13 += n14;
            n13 = Math.min(n11, n13) - n10;
            n14 = n10 - n14;
            int n17 = n16 + n14;
            byte[] byArray = segmentedByteString.getSegments$okio()[n12];
            object = new i0;
            int n18 = n17 + n13;
            boolean bl2 = true;
            object(byArray, n17, n18, bl2, false);
            object2 = m10.a;
            if (object2 == null) {
                object.g = object;
                object.f = object;
                m10.a = object;
            } else {
                f0.m(object2);
                object2 = ((i0)object2).g;
                f0.m(object2);
                ((i0)object2).c((i0)object);
            }
            n10 += n13;
            ++n12;
        }
        long l10 = m10.S0();
        long l11 = segmentedByteString.size();
        m10.O0(l10 += l11);
    }

    private static final void l(SegmentedByteString segmentedByteString, int n10, int n11, q q10) {
        int n12 = e.n(segmentedByteString, n10);
        while (n10 < n11) {
            int n13;
            Object[] objectArray;
            int n14;
            if (n12 == 0) {
                n14 = 0;
                objectArray = null;
            } else {
                objectArray = segmentedByteString.getDirectory$okio();
                n13 = n12 + -1;
                n14 = objectArray[n13];
            }
            int[] nArray = segmentedByteString.getDirectory$okio();
            n13 = nArray[n12] - n14;
            Object object = segmentedByteString.getDirectory$okio();
            int n15 = segmentedByteString.getSegments$okio().length + n12;
            int n16 = object[n15];
            n13 += n14;
            n13 = Math.min(n11, n13) - n10;
            n14 = n10 - n14;
            objectArray = segmentedByteString.getSegments$okio()[n12];
            object = n16 += n14;
            Integer n17 = n13;
            q10.invoke(objectArray, object, n17);
            n10 += n13;
            ++n12;
        }
    }

    public static final void m(SegmentedByteString segmentedByteString, q q10) {
        f0.p(segmentedByteString, "$this$forEachSegment");
        f0.p(q10, "action");
        byte[][] byArray = segmentedByteString.getSegments$okio();
        int n10 = byArray.length;
        int n11 = 0;
        Integer n12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = segmentedByteString.getDirectory$okio();
            int n13 = n10 + i10;
            int n14 = object[n13];
            int[] nArray = segmentedByteString.getDirectory$okio();
            n13 = nArray[i10];
            byte[] byArray2 = segmentedByteString.getSegments$okio()[i10];
            object = n14;
            n12 = n13 - n11;
            q10.invoke(byArray2, object, n12);
            n11 = n13;
        }
    }

    public static final int n(SegmentedByteString object, int n10) {
        f0.p(object, "$this$segment");
        int[] nArray = ((SegmentedByteString)object).getDirectory$okio();
        object = ((SegmentedByteString)object).getSegments$okio();
        int n11 = ((Object)object).length;
        n11 = e.b(nArray, ++n10, 0, n11);
        if (n11 < 0) {
            n11 ^= 0xFFFFFFFF;
        }
        return n11;
    }
}

