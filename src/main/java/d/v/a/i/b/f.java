/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.text.TextUtils
 */
package d.v.a.i.b;

import android.content.res.Resources;
import android.text.TextUtils;
import com.zhiyun.account.R$array;
import d.v.a.i.a.w0.a;
import d.v.a.i.b.e;
import d.v.e.l.w1;
import d.v.f.i.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class f {
    public static final String a = "CN";
    public static final String b = "86";

    private static List a(Resources stringArray, int n10) {
        stringArray = g.v((Resources)stringArray, n10);
        ArrayList<e> arrayList = new ArrayList<e>();
        int n11 = stringArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object = TextUtils.split((String)stringArray[i10], (String)"_");
            e e10 = new e();
            int n12 = 3;
            String string2 = object[n12];
            e10.f(string2);
            string2 = w1.a();
            String string3 = "zh_CN".toLowerCase();
            boolean bl2 = string2.equals(string3);
            if (bl2) {
                n12 = 2;
                string2 = object[n12];
                e10.h(string2);
            } else {
                string3 = "zh_TW".toLowerCase();
                n12 = (int)(string2.equals(string3) ? 1 : 0);
                if (n12 != 0) {
                    string2 = object[0];
                    e10.h(string2);
                } else {
                    n12 = 1;
                    string2 = object[n12];
                    e10.h(string2);
                }
            }
            string2 = d.v.a.i.a.w0.a.c(String.valueOf(e10.c()));
            e10.i(string2);
            n12 = 4;
            object = object[n12];
            e10.g((String)object);
            int n13 = 32;
            e10.j(n13);
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static List b(Resources object) {
        boolean bl2;
        Object object2;
        Object object3;
        Object object4;
        boolean bl3;
        int n10 = R$array.country_names_all;
        object = f.a((Resources)object, n10);
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
        Collections.sort(object, treeMap);
        treeMap = new TreeMap<String, Object>();
        object = object.iterator();
        while (bl3 = object.hasNext()) {
            object4 = (e)object.next();
            object3 = ((e)object4).d();
            object2 = treeMap.get(object3);
            object2 = object2 == null ? new ArrayList() : (List)treeMap.get(object3);
            object2.add((Object)object4);
            treeMap.put((String)object3, object2);
        }
        object = new ArrayList();
        object4 = treeMap.keySet().iterator();
        while (bl2 = object4.hasNext()) {
            object3 = (String)object4.next();
            object2 = new e();
            int n11 = 16;
            ((e)object2).j(n11);
            ((e)object2).i((String)object3);
            object.add(object2);
            object3 = (List)treeMap.get(object3);
            object.addAll(object3);
        }
        return object;
    }
}

