/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.e;
import j$.time.format.f;
import j$.time.format.v;
import j$.time.l;
import j$.time.q.s;
import j$.time.q.u;

final class h
implements f {
    h(int n10) {
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean m(v v10, StringBuilder stringBuilder) {
        long l10;
        int n10;
        Object object;
        StringBuilder stringBuilder2 = stringBuilder;
        Object object2 = j$.time.q.h.G;
        Object object3 = v10;
        object2 = v10.e((u)object2);
        s s10 = v10.d();
        int n11 = (int)(s10.g((u)(object = j$.time.q.h.e)) ? 1 : 0);
        if (n11 != 0) {
            long l11 = v10.d().h((u)object);
            object3 = l11;
        } else {
            n10 = 0;
            object3 = null;
        }
        n11 = 0;
        s10 = null;
        if (object2 == null) {
            return false;
        }
        long l12 = (Long)object2;
        long l13 = 0L;
        long l14 = object3 != null ? (Long)object3 : l13;
        int n12 = ((j$.time.q.h)object).O(l14);
        long l15 = l12 - -62167219200L;
        n10 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        object = ":00";
        long l16 = 1L;
        int n13 = 1;
        long l17 = 62167219200L;
        long l18 = 315569520000L;
        if (n10 >= 0) {
            l12 = l12 - l18 + l17;
            long l19 = Math.floorDiv(l12, l18);
            l16 = l19 + l16;
            l12 = Math.floorMod(l12, l18) - l17;
            object3 = l.f;
            object3 = e.Q(l12, 0, (l)object3);
            Object object4 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
            if (object4 > 0) {
                char c10 = '+';
                stringBuilder2.append(c10);
                stringBuilder2.append(l16);
            }
            stringBuilder2.append(object3);
            n10 = ((e)object3).x();
            if (n10 == 0) {
                stringBuilder2.append((String)object);
            }
        } else {
            l16 = (l12 += l17) / l18;
            l17 = (l12 %= l18) - l17;
            object3 = l.f;
            object3 = e.Q(l17, 0, (l)object3);
            int n14 = stringBuilder.length();
            stringBuilder2.append(object3);
            int n15 = ((e)object3).x();
            if (n15 == 0) {
                stringBuilder2.append((String)object);
            }
            if ((l10 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1)) < 0) {
                long l20;
                n10 = ((e)object3).C();
                if (n10 == (l10 = (long)-10000)) {
                    n10 = n14 + 2;
                    l20 = 1L;
                    object = Long.toString(l16 -= l20);
                    stringBuilder2.replace(n14, n10, (String)object);
                } else {
                    n10 = (int)(l12 == l13 ? 0 : (l12 < l13 ? -1 : 1));
                    if (n10 == 0) {
                        stringBuilder2.insert(n14, l16);
                    } else {
                        l20 = Math.abs(l16);
                        stringBuilder2.insert(n14 += n13, l20);
                    }
                }
            }
        }
        if (n12 > 0) {
            stringBuilder2.append('.');
            n10 = 100000000;
            while (true) {
                char c11;
                l10 = -2;
                if (n12 <= 0 && (c11 = n11 % 3) == '\u0000' && n11 >= l10) break;
                l10 = n12 / n10;
                c11 = (char)(l10 + 48);
                stringBuilder2.append(c11);
                n12 -= (l10 *= n10);
                n10 /= 10;
                ++n11;
            }
        }
        stringBuilder2.append('Z');
        return n13 != 0;
    }

    public String toString() {
        return "Instant()";
    }
}

