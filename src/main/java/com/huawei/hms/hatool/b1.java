/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.b1$a;
import com.huawei.hms.hatool.c;
import com.huawei.hms.hatool.c1;
import com.huawei.hms.hatool.d1;
import com.huawei.hms.hatool.e1;
import com.huawei.hms.hatool.f;
import com.huawei.hms.hatool.o;
import com.huawei.hms.hatool.p;
import com.huawei.hms.hatool.r_0;
import com.huawei.hms.hatool.v;
import com.huawei.hms.hatool.v0;
import com.huawei.hms.hatool.x;
import com.huawei.hms.hatool.x0;
import com.huawei.hms.hatool.y;
import d.j.f.a.a.h.c.d;
import java.util.List;
import java.util.Map;

public class b1
extends v {
    public static c1 a(String object, String object2) {
        c1 c12 = v.a((String)object, (String)object2);
        v0 v02 = x0.a().c((String)object, (String)object2);
        Object object3 = x0.a();
        boolean bl2 = c.c((String)object, (String)object2);
        object3 = ((x0)object3).a(bl2);
        c12.g((String)object3);
        object3 = c.o((String)object, (String)object2);
        c12.f((String)object3);
        object3 = x0.a();
        object = ((x0)object3).f((String)object, (String)object2);
        c12.c((String)object);
        object = v02.a();
        object2 = b1$a.a;
        Object object4 = ((Enum)object).ordinal();
        object4 = object2[object4];
        Object object5 = 1;
        if (object4 != object5) {
            object5 = 2;
            if (object4 != object5) {
                object5 = 3;
                if (object4 == object5) {
                    object = v02.b();
                    c12.e((String)object);
                }
            } else {
                object = v02.b();
                c12.b((String)object);
            }
        } else {
            object = v02.b();
            c12.d((String)object);
        }
        return c12;
    }

    public static d1 a(String object, String string2, String string3, String object2) {
        object = v.a((String)object, string2, string3, (String)object2);
        object2 = x0.a();
        boolean bl2 = c.c(string2, string3);
        string2 = ((x0)object2).a(bl2);
        long l10 = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = b.c();
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        string2 = d.b(stringBuilder.toString());
        string3 = String.valueOf(l10);
        ((o)object).f(string3);
        ((d1)object).g(string2);
        return object;
    }

    public static e1 a(String string2, String string3, String object) {
        object = v.a(string2, string3, (String)object);
        Object object2 = x0.a().e(string3, string2);
        String string4 = (String)object2.first;
        ((e1)object).f(string4);
        object2 = (String)object2.second;
        ((e1)object).g((String)object2);
        object2 = f.b();
        ((e1)object).h((String)object2);
        string2 = x0.a().d(string3, string2);
        ((p)object).d(string2);
        return object;
    }

    public static r_0 a(List list, String string2, String string3, String object, String string4) {
        String string5 = "generate UploadData";
        y.c("hmsSdk", string5);
        r_0 r_02 = v.a();
        if (r_02 == null) {
            return null;
        }
        object = b1.a(x.f().a(), string2, string3, (String)object);
        r_02.a((o)object);
        object = b1.a(string2, string3);
        r_02.a((c1)object);
        object = b1.a(string3, string2, string4);
        r_02.a((p)object);
        string2 = c.g(string2, string3);
        r_02.a(string2);
        r_02.a(list);
        return r_02;
    }

    public static Map b(String object, String string2, String object2) {
        object2 = v.b((String)object, (String)object2);
        if ((object = c.i((String)object, string2)) == null) {
            return object2;
        }
        object2.putAll(object);
        return object2;
    }
}

