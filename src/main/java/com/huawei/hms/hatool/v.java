/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.c1;
import com.huawei.hms.hatool.d1;
import com.huawei.hms.hatool.e1;
import com.huawei.hms.hatool.r_0;
import com.huawei.hms.hatool.x;
import com.huawei.hms.hatool.x0;
import com.huawei.hms.hatool.y;
import java.util.HashMap;
import java.util.Map;

public class v {
    public static c1 a(String string2, String string3) {
        c1 c12 = new c1();
        string2 = x0.a().a(string2, string3);
        c12.a(string2);
        return c12;
    }

    public static d1 a(String charSequence, String string2, String string3, String string4) {
        d1 d12 = new d1();
        d12.a((String)charSequence);
        charSequence = b.c();
        d12.b((String)charSequence);
        d12.e(string2);
        d12.c(string4);
        charSequence = new StringBuffer("hmshi");
        ((StringBuffer)charSequence).append(string3);
        ((StringBuffer)charSequence).append("qrt");
        charSequence = ((StringBuffer)charSequence).toString();
        d12.d((String)charSequence);
        return d12;
    }

    public static e1 a(String string2, String string3, String string4) {
        e1 e12 = new e1();
        String string5 = b.g();
        e12.c(string5);
        string5 = b.i();
        e12.e(string5);
        e12.a(string4);
        string2 = x0.a().b(string3, string2);
        e12.b(string2);
        return e12;
    }

    public static r_0 a() {
        Object object = "hmsSdk";
        y.c((String)object, "generate UploadData EventModelHandlerBase");
        x.f().d();
        String string2 = x.f().a();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            y.f((String)object, "event chifer is empty");
            return null;
        }
        string2 = x.f().c();
        object = new r_0(string2);
        return object;
    }

    public static Map b(String objectArray, String string2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string3 = b.c();
        hashMap.put("App-Id", string3);
        string3 = b.d();
        hashMap.put("App-Ver", string3);
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.308");
        string3 = Build.MODEL;
        hashMap.put("Device-Type", string3);
        hashMap.put("servicetag", objectArray);
        objectArray = new Object[]{string2};
        y.a("hmsSdk", "sendData RequestId : %s", objectArray);
        hashMap.put("Request-Id", string2);
        return hashMap;
    }
}

