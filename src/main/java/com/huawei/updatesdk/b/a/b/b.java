/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.os.Build$VERSION
 *  android.util.ArraySet
 */
package com.huawei.updatesdk.b.a.b;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.ArraySet;
import com.huawei.updatesdk.a.a.d.g;
import com.huawei.updatesdk.b.a.b.a;
import com.huawei.updatesdk.b.a.b.a$a;
import com.huawei.updatesdk.b.a.b.c;
import com.huawei.updatesdk.b.a.b.c$a;
import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

    private static void a(a a10) {
        Map map = com.huawei.updatesdk.b.a.b.b.a().a;
        String string2 = a10.c();
        map.put(string2, a10);
    }

    private static ArrayList b(PackageInfo object) {
        boolean bl2;
        a a10 = new a();
        ArrayList<String> arrayList = ((PackageInfo)object).packageName;
        a10.a((String)((Object)arrayList));
        object = object.applicationInfo.sourceDir;
        arrayList = new ArrayList<String>((String)object);
        boolean bl3 = ((File)((Object)arrayList)).exists();
        Iterator iterator2 = null;
        if (!bl3) {
            return null;
        }
        long l10 = ((File)((Object)arrayList)).lastModified();
        a10.a(l10);
        object = c.a((File)((Object)arrayList));
        arrayList = ((c$a)object).a;
        if (arrayList != null && !(bl2 = arrayList.isEmpty()) && (arrayList = ((c$a)object).b) != null && !(bl2 = arrayList.isEmpty())) {
            boolean bl4;
            arrayList = new ArrayList<String>();
            iterator2 = ((c$a)object).a.entrySet().iterator();
            while (bl4 = iterator2.hasNext()) {
                ArraySet arraySet = ((c$a)object).b;
                Object object2 = (Map.Entry)iterator2.next();
                String string2 = (String)object2.getKey();
                boolean bl5 = arraySet.contains((Object)string2);
                if (!bl5) continue;
                object2 = ((ArraySet)object2.getValue()).iterator();
                while (bl5 = object2.hasNext()) {
                    string2 = g.a(((PublicKey)object2.next()).getEncoded());
                    arrayList.add(string2);
                }
            }
            object = new a$a();
            ((a$a)object).a(arrayList);
            a10.a((a$a)object);
            com.huawei.updatesdk.b.a.b.b.a(a10);
            return arrayList;
        }
        com.huawei.updatesdk.b.a.b.b.a(a10);
        return null;
    }

    public List a(PackageInfo object) {
        Object object2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11 && object != null && (object2 = object.applicationInfo.sourceDir) != null) {
            long l10;
            long l11;
            File file = new File((String)object2);
            long l12 = file.lastModified();
            object2 = com.huawei.updatesdk.b.a.b.b.a().a;
            String string2 = object.packageName;
            if ((object2 = (a)object2.get(string2)) != null && (n11 = (int)((l11 = (l10 = ((a)object2).b()) - l12) == 0L ? 0 : (l11 < 0L ? -1 : 1))) == 0) {
                object = ((a)object2).a();
                if (object == null) {
                    return null;
                }
                return ((a)object2).a().a();
            }
            return com.huawei.updatesdk.b.a.b.b.b(object);
        }
        return null;
    }
}

