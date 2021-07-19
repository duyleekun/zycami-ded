/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import cn.sharesdk.framework.utils.QRCodeUtil.g;
import cn.sharesdk.framework.utils.QRCodeUtil.h;
import java.util.ArrayList;
import java.util.List;

public final class m {
    private final g a;
    private final List b;

    public m(g g10) {
        ArrayList<h> arrayList;
        this.a = g10;
        this.b = arrayList = new ArrayList<h>();
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = n10;
        h h10 = new h(g10, nArray);
        arrayList.add(h10);
    }

    private h a(int n10) {
        Object object = this.b;
        int n11 = object.size();
        if (n10 >= n11) {
            object = this.b;
            int n12 = object.size();
            int n13 = 1;
            object = (h)object.get(n12 -= n13);
            List list = this.b;
            for (n12 = list.size(); n12 <= n10; ++n12) {
                g g10 = this.a;
                int n14 = 2;
                int[] nArray = new int[n14];
                nArray[0] = n13;
                int n15 = n12 + -1;
                int n16 = g10.b();
                n15 += n16;
                nArray[n13] = n15 = g10.a(n15);
                Object object2 = new h(g10, nArray);
                object = ((h)object).b((h)object2);
                object2 = this.b;
                object2.add(object);
            }
        }
        return (h)this.b.get(n10);
    }

    public void a(int[] object, int n10) {
        if (n10 != 0) {
            int n11 = ((int[])object).length - n10;
            if (n11 > 0) {
                Object object2 = this.a(n10);
                int[] nArray = new int[n11];
                System.arraycopy(object, 0, nArray, 0, n11);
                g g10 = this.a;
                h h10 = new h(g10, nArray);
                int n12 = 1;
                h10 = h10.a(n10, n12);
                object2 = h10.c((h)object2)[n12].a();
                n12 = ((Object)object2).length;
                n10 -= n12;
                nArray = null;
                for (n12 = 0; n12 < n10; ++n12) {
                    int n13 = n11 + n12;
                    object[n13] = 0;
                }
                n11 += n10;
                n10 = ((Object)object2).length;
                System.arraycopy(object2, 0, object, n11, n10);
                return;
            }
            object = new IllegalArgumentException;
            object("No data bytes provided");
            throw object;
        }
        object = new IllegalArgumentException;
        object("No error correction bytes");
        throw object;
    }
}

