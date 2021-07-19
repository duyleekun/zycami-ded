/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.a.a;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.d.d;
import com.huawei.updatesdk.b.a.a.a;
import java.util.HashMap;
import java.util.Map;

public class b {
    private static b b;
    private final Map a;

    private b() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public static b a() {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            b b10 = b;
            if (b10 == null) {
                b = b10 = new b();
            }
            b10 = b;
            return b10;
        }
    }

    public String a(PackageInfo object) {
        boolean bl2;
        Object object2;
        if (object != null && (object2 = object.packageName) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = object.applicationInfo.sourceDir)))) {
            int n10;
            long l10;
            long l11;
            long l12;
            long l13;
            object2 = this.a;
            Object object3 = object.packageName;
            if ((object2 = (a)object2.get(object3)) != null && (l13 = (l12 = (l11 = ((a)object2).b()) - (l10 = object.lastUpdateTime)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false && (l13 = (long)((a)object2).c()) == (n10 = object.versionCode)) {
                return ((a)object2).a();
            }
            object2 = new StringBuilder();
            l11 = object.lastUpdateTime;
            ((StringBuilder)object2).append(l11);
            l13 = object.versionCode;
            ((StringBuilder)object2).append((int)l13);
            object3 = object.packageName;
            ((StringBuilder)object2).append((String)object3);
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("packagekey");
            Object object4 = object.packageName;
            ((StringBuilder)object3).append((String)object4);
            object3 = ((StringBuilder)object3).toString();
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("fileshakey");
            String string2 = object.packageName;
            ((StringBuilder)object4).append(string2);
            object4 = ((StringBuilder)object4).toString();
            string2 = ((StringBuilder)object2).toString();
            Object object5 = com.huawei.updatesdk.b.b.a.d().c((String)object3);
            boolean bl3 = TextUtils.equals((CharSequence)string2, (CharSequence)object5) ^ true;
            if (bl3) {
                object5 = com.huawei.updatesdk.b.b.a.d();
                object2 = ((StringBuilder)object2).toString();
                ((com.huawei.updatesdk.b.b.a)object5).a((String)object3, (String)object2);
            }
            if ((l13 = (long)TextUtils.isEmpty((CharSequence)(object2 = com.huawei.updatesdk.b.b.a.d().c((String)object4)))) != false || bl3) {
                object2 = d.a(object.applicationInfo.sourceDir, "SHA-256");
                object3 = com.huawei.updatesdk.b.b.a.d();
                ((com.huawei.updatesdk.b.b.a)object3).a((String)object4, (String)object2);
            }
            object3 = new a();
            ((a)object3).a((String)object2);
            long l14 = object.lastUpdateTime;
            ((a)object3).a(l14);
            n10 = object.versionCode;
            ((a)object3).a(n10);
            object4 = this.a;
            object = object.packageName;
            object4.put(object, object3);
            return object2;
        }
        return null;
    }
}

