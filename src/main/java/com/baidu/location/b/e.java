/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.d;
import com.baidu.location.b.d$c;
import java.util.Comparator;

public class e
implements Comparator {
    public final /* synthetic */ d a;

    public e(d d10) {
        this.a = d10;
    }

    public int a(d$c d$c, d$c d$c2) {
        int n10 = d$c.b;
        int n11 = d$c2.b;
        if (n10 > n11) {
            return -1;
        }
        if (n10 == n11) {
            return 0;
        }
        return 1;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        object = (d$c)object;
        object2 = (d$c)object2;
        return this.a((d$c)object, (d$c)object2);
    }
}

