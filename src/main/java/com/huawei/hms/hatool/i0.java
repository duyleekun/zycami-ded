/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.a0;
import com.huawei.hms.hatool.b0;
import com.huawei.hms.hatool.b1;
import com.huawei.hms.hatool.l0;
import com.huawei.hms.hatool.m0;
import com.huawei.hms.hatool.n0;
import com.huawei.hms.hatool.y;
import java.util.List;
import java.util.Map;

public class i0
implements m0 {
    public byte[] a;
    public String b;
    public String c;
    public String d;
    public String e;
    public List f;

    public i0(byte[] byArray, String string2, String string3, String string4, String string5, List list) {
        byArray = (byte[])byArray.clone();
        this.a = byArray;
        this.b = string2;
        this.c = string3;
        this.e = string4;
        this.d = string5;
        this.f = list;
    }

    public final b0 a(Map map) {
        String string2 = this.b;
        byte[] byArray = this.a;
        return a0.a(string2, byArray, map);
    }

    public final Map a() {
        String string2 = this.c;
        String string3 = this.e;
        String string4 = this.d;
        return b1.b(string2, string3, string4);
    }

    public final void b() {
        List list = this.f;
        String string2 = this.c;
        String string3 = this.d;
        String string4 = this.e;
        l0 l02 = new l0(list, string2, string3, string4);
        n0.b().a(l02);
    }

    public void run() {
        String string2 = "hmsSdk";
        y.c(string2, "send data running");
        Object object = this.a();
        object = this.a((Map)object);
        int n10 = ((b0)object).a();
        int n11 = 200;
        if (n10 != n11) {
            this.b();
        } else {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:");
            Object[] objectArray = this.d;
            charSequence.append((String)objectArray);
            charSequence = charSequence.toString();
            int n12 = 3;
            objectArray = new Object[n12];
            String string3 = this.e;
            objectArray[0] = string3;
            string3 = this.c;
            int n13 = 1;
            objectArray[n13] = string3;
            object = n10;
            int n14 = 2;
            objectArray[n14] = object;
            y.b(string2, (String)charSequence, objectArray);
        }
    }
}

