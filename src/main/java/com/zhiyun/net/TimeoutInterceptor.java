/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net;

import g.a0;
import g.c0;
import g.u;
import g.u$a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import m.a.a;

public class TimeoutInterceptor
implements u {
    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c0 intercept(u$a u$a) {
        int n10;
        a0 a02 = u$a.C();
        List list = a02.j("timeout");
        if (list != null && (n10 = list.size()) > 0) {
            int n11;
            Integer n12;
            block6: {
                n10 = 0;
                n12 = null;
                int n13 = 1;
                n11 = -1;
                try {
                }
                catch (NumberFormatException numberFormatException) {
                    Object[] objectArray = new Object[n13];
                    objectArray[0] = list;
                    String string2 = "TimeoutInterceptor \u8d85\u65f6\u65f6\u95f4\u6821\u9a8c\u5f02\u5e38,\u8bf7\u68c0\u67e5\u53c2\u6570, %s";
                    a.z(numberFormatException, string2, objectArray);
                    break block6;
                }
                {
                    Object e10;
                    String string3;
                    for (int i10 = list.size() - n13; i10 >= 0 && (n11 = Integer.parseInt(string3 = (String)(e10 = list.get(i10)))) <= 0; ++i10) {
                    }
                }
            }
            if (n11 > 0) {
                Object[] objectArray = new Object[2];
                String string4 = a02.toString();
                objectArray[0] = string4;
                n12 = n11;
                objectArray[n13] = n12;
                a.i("TimeoutInterceptor \u91cd\u7f6e\u63a5\u53e3\u8d85\u65f6\u65f6\u95f4, timeout: %s, re request:%s", objectArray);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                return u$a.b(n11, timeUnit).g(n11, timeUnit).d(n11, timeUnit).c(a02);
            }
        }
        return u$a.c(a02);
    }
}

