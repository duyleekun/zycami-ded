/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.h2.t.u;
import f.x1.x;
import h.c0;
import h.m;
import h.m0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okio.ByteString;

public final class c0$a {
    private c0$a() {
    }

    public /* synthetic */ c0$a(u u10) {
        this();
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void a(long l10, m m10, int n10, List list, int n11, int n12, List list2) {
        ByteString byteString;
        long l11;
        int n13;
        int n14;
        int n15;
        int n16;
        Object object;
        Object object2;
        int n17;
        c0$a c0$a = this;
        m m11 = m10;
        int n18 = n10;
        List list3 = list;
        int n19 = n11;
        int n20 = n12;
        List list4 = list2;
        if (n11 < n12) {
            n17 = 1;
        } else {
            n17 = 0;
            object2 = null;
        }
        Object object3 = "Failed requirement.";
        if (n17 == 0) {
            String string2 = object3.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        for (n17 = n19; n17 < n20; ++n17) {
            object = (ByteString)list3.get(n17);
            n16 = ((ByteString)object).size();
            if (n16 >= n18) {
                n16 = 1;
            } else {
                n16 = 0;
                object = null;
            }
            if (n16 != 0) continue;
            String string3 = object3.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
            throw illegalArgumentException;
        }
        object2 = (ByteString)list.get(n11);
        int n21 = n20 + -1;
        object3 = (ByteString)list3.get(n21);
        n16 = ((ByteString)object2).size();
        int n22 = -1;
        if (n18 == n16) {
            n17 = ((Number)list4.get(n19)).intValue();
            object = (ByteString)list3.get(++n19);
            n15 = n19;
            n19 = n17;
            object2 = object;
        } else {
            n15 = n19;
            n19 = n22;
        }
        n16 = ((ByteString)object2).getByte(n18);
        int n23 = ((ByteString)object3).getByte(n18);
        int n24 = 2;
        if (n16 != n23) {
            n14 = 1;
            for (n13 = n15 + 1; n13 < n20; ++n13) {
                n17 = n13 + -1;
                object2 = (ByteString)list3.get(n17);
                if ((n17 = (int)((ByteString)object2).getByte(n18)) == (n21 = (int)((ByteString)(object3 = (ByteString)list3.get(n13))).getByte(n18))) continue;
                ++n14;
            }
            long l12 = c0$a.c(m11);
            l12 = l10 + l12;
            long l13 = n24;
            l12 += l13;
            n13 = n14 * 2;
            l13 = n13;
            l11 = l12 + l13;
            m11.e1(n14);
            m11.e1(n19);
            for (n19 = n15; n19 < n20; ++n19) {
                byteString = (ByteString)list3.get(n19);
                n13 = byteString.getByte(n18);
                if (n19 != n15) {
                    n14 = n19 + -1;
                    ByteString byteString2 = (ByteString)list3.get(n14);
                    if (n13 == (n14 = (int)byteString2.getByte(n18))) continue;
                }
                m11.e1(n13 &= 0xFF);
            }
        } else {
            String string4;
            byte by2;
            byte by3;
            n16 = ((ByteString)object2).size();
            n23 = ((ByteString)object3).size();
            n16 = Math.min(n16, n23);
            n22 = 0;
            Object var39_47 = null;
            for (n23 = n18; n23 < n16 && (by3 = ((ByteString)object2).getByte(n23)) == (by2 = ((ByteString)object3).getByte(n23)); ++n22, ++n23) {
            }
            long l14 = c0$a.c(m11);
            l14 = l10 + l14;
            long l15 = n24;
            l14 += l15;
            l15 = n22;
            l14 += l15;
            l15 = 1L;
            l14 += l15;
            n21 = -n22;
            m11.e1(n21);
            m11.e1(n19);
            n21 = n18 + n22;
            while (n18 < n21) {
                n19 = ((ByteString)object2).getByte(n18) & 0xFF;
                m11.e1(n19);
                ++n18;
            }
            n19 = n15 + 1;
            if (n19 != n20) {
                m m12 = new m();
                long l16 = c0$a.c(m12) + l14;
                n19 = (int)l16;
                n17 = -1;
                m11.e1(n19 *= n17);
                c0$a c0$a2 = this;
                object2 = m12;
                object = list;
                n23 = n12;
                List list5 = list2;
                this.a(l14, m12, n21, list, n15, n12, list2);
                m11.v(m12);
                return;
            }
            Serializable serializable = (ByteString)list3.get(n15);
            n19 = ((ByteString)serializable).size();
            if (n21 == n19) {
                by3 = 1;
            } else {
                by3 = 0;
                string4 = null;
            }
            if (by3 != 0) {
                serializable = (Number)list4.get(n15);
                n19 = ((Number)serializable).intValue();
                m11.e1(n19);
                return;
            }
            string4 = "Check failed.".toString();
            serializable = new IllegalStateException(string4);
            throw serializable;
        }
        Object object4 = new m();
        while (true) {
            int n25;
            Object object5;
            m m13;
            block24: {
                if (n15 >= n20) {
                    m13 = object4;
                    m11.v((m0)object4);
                    return;
                }
                object5 = (ByteString)list3.get(n15);
                n19 = ((ByteString)object5).getByte(n18);
                for (n14 = n13 = n15 + 1; n14 < n20; ++n14) {
                    object2 = (ByteString)list3.get(n14);
                    n17 = ((ByteString)object2).getByte(n18);
                    if (n19 == n17) continue;
                    n23 = n14;
                    break block24;
                }
                n23 = n20;
            }
            if (n13 == n23 && (n19 = n18 + 1) == (n13 = (byteString = (ByteString)list3.get(n15)).size())) {
                object5 = (Number)list4.get(n15);
                n19 = ((Number)object5).intValue();
                m11.e1(n19);
                n25 = n23;
                m13 = object4;
            } else {
                long l17 = c0$a.c((m)object4);
                l17 = l11 + l17;
                n19 = (int)l17 * n22;
                m11.e1(n19);
                n21 = n18 + 1;
                object5 = this;
                long l18 = l11;
                object2 = object4;
                object = list;
                n25 = n23;
                m13 = object4;
                object4 = list2;
                this.a(l11, (m)object2, n21, list, n15, n23, list2);
            }
            object4 = m13;
            n15 = n25;
            n22 = -1;
        }
    }

    public static /* synthetic */ void b(c0$a c0$a, long l10, m m10, int n10, List list, int n11, int n12, List list2, int n13, Object object) {
        long l11;
        int n14 = n13 & 1;
        long l12 = n14 != 0 ? (l11 = 0L) : l10;
        n14 = n13 & 4;
        int n15 = n14 != 0 ? 0 : n10;
        n14 = n13 & 0x10;
        int n16 = n14 != 0 ? 0 : n11;
        n14 = n13 & 0x20;
        int n17 = n14 != 0 ? (n14 = list.size()) : n12;
        c0$a.a(l12, m10, n15, list, n16, n17, list2);
    }

    private final long c(m m10) {
        long l10 = m10.S0();
        long l11 = 4;
        return l10 / l11;
    }

    public final c0 d(ByteString ... byteStringArray) {
        int n10;
        Object object;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        Object object22;
        Object object3 = byteStringArray;
        Object object4 = "byteStrings";
        f0.p(byteStringArray, (String)object4);
        int n17 = byteStringArray.length;
        int n18 = 1;
        int n19 = 0;
        if (n17 == 0) {
            n17 = n18;
        } else {
            n17 = 0;
            object4 = null;
        }
        if (n17 != 0) {
            object4 = new ByteString[]{};
            int[] nArray = new int[]{0, -1};
            object3 = new c0((ByteString[])object4, nArray, null);
            return object3;
        }
        object4 = ArraysKt___ArraysKt.Ey(byteStringArray);
        x.m0((List)object4);
        int n20 = ((ByteString[])object3).length;
        Object object5 = new ArrayList(n20);
        for (Object object22 : object3) {
            n16 = -1;
            object22 = n16;
            object5.add(object22);
        }
        Object object6 = new Integer[]{};
        object5 = object5.toArray((T[])object6);
        object6 = "null cannot be cast to non-null type kotlin.Array<T>";
        Objects.requireNonNull(object5, (String)object6);
        n20 = ((Integer[])object5).length;
        object5 = Arrays.copyOf(object5, n20);
        List list = CollectionsKt__CollectionsKt.P(object5);
        int n21 = ((ByteString[])object3).length;
        int n22 = 0;
        for (n15 = 0; n15 < n21; ++n15) {
            object6 = object3[n15];
            n14 = n22 + 1;
            n13 = 0;
            n16 = 0;
            object22 = null;
            n12 = 6;
            n11 = 0;
            object = null;
            object5 = object4;
            n10 = CollectionsKt__CollectionsKt.x((List)object4, (Comparable)object6, 0, 0, n12, null);
            object6 = n22;
            list.set(n10, object6);
            n22 = n14;
        }
        object5 = (ByteString)object4.get(0);
        n10 = object5.size();
        if (n10 > 0) {
            n10 = n18;
        } else {
            n10 = 0;
            object5 = null;
        }
        if (n10 != 0) {
            Serializable serializable;
            n10 = 0;
            object5 = null;
            while (n10 < (n20 = object4.size())) {
                object6 = (ByteString)object4.get(n10);
                n16 = n13 = n10 + 1;
                while (n16 < (n12 = object4.size()) && (n11 = ((ByteString)(serializable = (ByteString)object4.get(n16))).startsWith((ByteString)object6)) != 0) {
                    n11 = ((ByteString)serializable).size();
                    if (n11 != (n21 = ((ByteString)object6).size())) {
                        n11 = n18;
                    } else {
                        n11 = 0;
                        object = null;
                    }
                    if (n11 != 0) {
                        serializable = (Number)list.get(n16);
                        n12 = ((Number)serializable).intValue();
                        if (n12 > (n11 = ((Number)(object = (Number)list.get(n10))).intValue())) {
                            object4.remove(n16);
                            list.remove(n16);
                            continue;
                        }
                        ++n16;
                        continue;
                    }
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("duplicate option: ");
                    ((StringBuilder)object3).append(serializable);
                    object3 = ((StringBuilder)object3).toString();
                    object3 = object3.toString();
                    object4 = new IllegalArgumentException((String)object3);
                    throw object4;
                }
                n10 = n13;
            }
            Object object7 = new m();
            long l10 = 0L;
            n12 = 0;
            serializable = null;
            n21 = 0;
            n15 = 0;
            n22 = 53;
            n14 = 0;
            object5 = this;
            object22 = object7;
            object = object4;
            c0$a.b(this, l10, (m)object7, 0, (List)object4, 0, 0, list, n22, null);
            object4 = this;
            long l11 = this.c((m)object7);
            n10 = (int)l11;
            object5 = new int[n10];
            while ((n20 = (int)(((m)object7).V() ? 1 : 0)) == 0) {
                n20 = n19 + 1;
                n13 = ((m)object7).readInt();
                object5[n19] = n13;
                n19 = n20;
            }
            n19 = ((Object)object3).length;
            object3 = Arrays.copyOf(object3, n19);
            f0.o(object3, "java.util.Arrays.copyOf(this, size)");
            object3 = (ByteString[])object3;
            object7 = new c0((ByteString[])object3, (int[])object5, null);
            return object7;
        }
        object4 = this;
        String string2 = "the empty byte string is not a supported option".toString();
        object3 = new IllegalArgumentException(string2);
        throw object3;
    }
}

