/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import cn.sharesdk.framework.utils.QRCodeUtil.Writer;
import cn.sharesdk.framework.utils.QRCodeUtil.a;
import cn.sharesdk.framework.utils.QRCodeUtil.a.c;
import cn.sharesdk.framework.utils.QRCodeUtil.a.f;
import cn.sharesdk.framework.utils.QRCodeUtil.e;
import java.util.Map;

public final class l
implements Writer {
    private static cn.sharesdk.framework.utils.QRCodeUtil.c a(f object, int n10, int n11, int n12) {
        if ((object = ((f)object).a()) != null) {
            int n13 = object.b();
            int n14 = object.a();
            int n15 = n13 + (n12 *= 2);
            n10 = Math.max(n10, n15);
            n11 = Math.max(n11, n12 += n14);
            n15 = n10 / n15;
            n12 = n11 / n12;
            n12 = Math.min(n15, n12);
            n15 = n13 * n12;
            n15 = (n10 - n15) / 2;
            int n16 = n14 * n12;
            n16 = (n11 - n16) / 2;
            cn.sharesdk.framework.utils.QRCodeUtil.c c10 = new cn.sharesdk.framework.utils.QRCodeUtil.c(n10, n11);
            n10 = 0;
            n11 = 0;
            while (n11 < n14) {
                int n17 = 0;
                int n18 = n15;
                while (n17 < n13) {
                    byte by2;
                    byte by3 = object.a(n17, n11);
                    if (by3 == (by2 = 1)) {
                        c10.a(n18, n16, n12, n12);
                    }
                    ++n17;
                    n18 += n12;
                }
                ++n11;
                n16 += n12;
            }
            return c10;
        }
        object = new IllegalStateException();
        throw object;
    }

    public cn.sharesdk.framework.utils.QRCodeUtil.c encode(String string2, a a10, int n10, int n11) {
        return this.encode(string2, a10, n10, n11, null);
    }

    public cn.sharesdk.framework.utils.QRCodeUtil.c encode(String object, a object2, int n10, int n11, Map map) {
        boolean n12 = ((String)object).isEmpty();
        if (!n12) {
            Object object3 = a.l;
            if (object2 == object3) {
                if (n10 >= 0 && n11 >= 0) {
                    int n13;
                    object2 = cn.sharesdk.framework.utils.QRCodeUtil.f.a;
                    int n14 = 4;
                    if (map != null) {
                        e e10 = e.a;
                        boolean bl2 = map.containsKey((Object)e10);
                        if (bl2) {
                            object2 = cn.sharesdk.framework.utils.QRCodeUtil.f.valueOf(map.get((Object)e10).toString());
                        }
                        if (bl2 = map.containsKey((Object)(e10 = e.f))) {
                            object3 = map.get((Object)e10).toString();
                            n13 = Integer.parseInt((String)object3);
                        }
                    }
                    return l.a(c.a((String)object, (cn.sharesdk.framework.utils.QRCodeUtil.f)((Object)object2), map), n10, n11, n13);
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Requested dimensions are too small: ");
                ((StringBuilder)object2).append(n10);
                ((StringBuilder)object2).append('x');
                ((StringBuilder)object2).append(n11);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can only encode QR_CODE, but got ");
            stringBuilder.append(object2);
            object2 = stringBuilder.toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        object = new IllegalArgumentException("Found empty contents");
        throw object;
    }
}

