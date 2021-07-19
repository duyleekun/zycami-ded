/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hj {
    private static HashMap a(Context context, List object) {
        int n10;
        if (object != null && (n10 = object.size()) != 0) {
            boolean bl2;
            HashMap<String, ArrayList<hq>> hashMap = new HashMap<String, ArrayList<hq>>();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                hq hq2 = (hq)object.next();
                hj.a(context, hq2);
                ArrayList<hq> arrayList = hq2.c();
                arrayList = (ArrayList)hashMap.get(arrayList);
                if (arrayList == null) {
                    arrayList = new ArrayList<hq>();
                    String string2 = hq2.c();
                    hashMap.put(string2, arrayList);
                }
                arrayList.add(hq2);
            }
            return hashMap;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(Context object, hl hl2, HashMap object2) {
        boolean bl2;
        object = ((HashMap)object2).entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object3;
            object2 = (Map.Entry)object.next();
            try {
                object3 = object2.getValue();
            }
            catch (Exception exception) {
                continue;
            }
            if ((object3 = (ArrayList)object3) == null) continue;
            int n10 = ((ArrayList)object3).size();
            if (n10 == 0) continue;
            n10 = 0;
            Object object4 = null;
            object4 = ((ArrayList)object3).get(0);
            object4 = (hq)object4;
            object4 = ((hq)object4).e();
            object2 = object2.getKey();
            object2 = (String)object2;
            hl2.a((List)object3, (String)object4, (String)object2);
        }
    }

    public static void a(Context object, hl hl2, List object2) {
        int n10;
        if ((object2 = hj.a((Context)object, (List)object2)) != null && (n10 = ((HashMap)object2).size()) != 0) {
            hj.a((Context)object, hl2, (HashMap)object2);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:");
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object).append(l10);
        b.a(((StringBuilder)object).toString());
    }

    private static void a(Context object, hq hq2) {
        boolean bl2;
        String string2;
        boolean bl3 = hq2.a;
        if (bl3) {
            string2 = "push_sdk_channel";
            hq2.a(string2);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)(string2 = hq2.d()))) {
            string2 = bi.a();
            hq2.f(string2);
        }
        long l10 = System.currentTimeMillis();
        hq2.b(l10);
        string2 = hq2.e();
        bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            object = object.getPackageName();
            hq2.e((String)object);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)(object = hq2.c()))) {
            object = hq2.e();
            hq2.e((String)object);
        }
    }
}

