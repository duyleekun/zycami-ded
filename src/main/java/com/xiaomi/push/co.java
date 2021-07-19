/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.Log
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.push.cl;
import com.xiaomi.push.cm;
import com.xiaomi.push.cn;
import com.xiaomi.push.cp;
import com.xiaomi.push.cq;
import com.xiaomi.push.cr;
import com.xiaomi.push.ct;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class co
implements ct {
    private static co a;
    private int a;
    private Context a;
    private cn a;
    private String a;
    private HashMap a;
    private int b;
    private String b;
    private int c;
    private String c;
    private int d;

    public static co a() {
        Class<co> clazz = co.class;
        synchronized (clazz) {
            co co2 = a;
            return co2;
        }
    }

    private String a(ArrayList arrayList, String arrayList2) {
        int n10;
        Object object;
        JSONObject jSONObject = new JSONObject();
        String string2 = this.a;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 == 0) {
            string2 = cr.a(this.a);
            object = "imei";
            jSONObject.put((String)object, (Object)string2);
        }
        jSONObject.put("actionType", (Object)arrayList2);
        long l10 = System.currentTimeMillis();
        jSONObject.put("actionTime", l10);
        arrayList2 = new ArrayList<Object>();
        string2 = null;
        for (n11 = 0; n11 < (n10 = arrayList.size()); ++n11) {
            n10 = 0;
            object = null;
            Object object2 = ((cl)arrayList.get((int)n11)).a;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                object = new JSONObject();
            } else {
                Object object3 = arrayList.get(n11);
                object3 = (cl)object3;
                object3 = ((cl)object3).a;
                try {
                    object = object2 = new JSONObject((String)object3);
                }
                catch (Exception exception) {
                    object2 = "com.xiaomi.miui.ads.pushsdk";
                    object3 = "content \u4e0d\u662fjson\u4e32";
                    Log.e((String)object2, (String)object3);
                }
            }
            if (object == null) {
                object = new JSONObject();
            }
            object2 = (cl)arrayList.get(n11);
            long l11 = ((cl)object2).a;
            String string3 = "adId";
            object.put(string3, l11);
            arrayList2.add(object);
        }
        arrayList = new JSONArray(arrayList2);
        jSONObject.put("adList", (Object)arrayList);
        return Base64.encodeToString((byte[])jSONObject.toString().getBytes(), (int)2);
    }

    private void a(cm objectArray) {
        Object object = this.a;
        Object object2 = objectArray.b;
        int n10 = object.containsKey(object2);
        if (n10 != 0) {
            return;
        }
        this.b = n10 = this.b + 1;
        object = new StringBuilder();
        ((StringBuilder)object).append("send: ");
        int n11 = this.b;
        ((StringBuilder)object).append(n11);
        cr.a(((StringBuilder)object).toString());
        object2 = this.b;
        String string2 = this.c;
        object = new cp(this, (String)object2, string2, (cm)objectArray);
        object2 = this.a;
        string2 = objectArray.b;
        ((HashMap)object2).put(string2, objectArray);
        objectArray = new String[]{};
        object.execute(objectArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(ArrayList object, String string2, int n10) {
        try {
            object = this.a((ArrayList)object, string2);
            string2 = cr.a((String)object);
            cm cm2 = new cm(n10, (String)object, string2);
            boolean bl2 = this.a(cm2);
            if (!bl2) return;
            cm2 = new cm(n10, (String)object, string2);
            this.a(cm2);
            return;
        }
        catch (JSONException jSONException) {
            return;
        }
    }

    private boolean a(cm cm2) {
        Context context = this.a;
        boolean bl2 = cq.a(context);
        if (bl2) {
            return true;
        }
        this.b(cm2);
        return false;
    }

    private void b(cm cm2) {
        int n10;
        this.d = n10 = this.d + 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cacheCount: ");
        int n11 = this.d;
        stringBuilder.append(n11);
        cr.a(stringBuilder.toString());
        this.a.a(cm2);
        this.a.a();
    }

    public void a(cl cl2) {
        long l10 = cl2.a;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<cl>();
        arrayList.add(cl2);
        int n10 = cl2.a;
        this.a(arrayList, "click", n10);
    }

    public void a(Integer object, cm object2) {
        Object object3 = this.a;
        String string2 = ((cm)object2).b;
        boolean n10 = ((HashMap)object3).containsKey(string2);
        if (n10) {
            int n11 = (Integer)object;
            if (n11 != 0) {
                this.c = n11 = this.c + 1;
                object = new StringBuilder();
                ((StringBuilder)object).append("faild: ");
                int n12 = this.c;
                ((StringBuilder)object).append(n12);
                ((StringBuilder)object).append(" ");
                object3 = ((cm)object2).b;
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append("  ");
                object3 = this.a;
                int n13 = ((HashMap)object3).size();
                ((StringBuilder)object).append(n13);
                object = ((StringBuilder)object).toString();
                cr.a((String)object);
                this.b((cm)object2);
            } else {
                this.a = n11 = this.a + 1;
                object = new StringBuilder();
                object3 = "success: ";
                ((StringBuilder)object).append((String)object3);
                int n14 = this.a;
                ((StringBuilder)object).append(n14);
                object = ((StringBuilder)object).toString();
                cr.a((String)object);
            }
            object = this.a;
            object2 = ((cm)object2).b;
            ((HashMap)object).remove(object2);
        }
    }

    public void b(cl cl2) {
        long l10 = cl2.a;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<cl>();
        arrayList.add(cl2);
        int n10 = cl2.a;
        this.a(arrayList, "remove", n10);
    }

    public void c(cl cl2) {
        long l10 = cl2.a;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return;
        }
        ArrayList<cl> arrayList = new ArrayList<cl>();
        arrayList.add(cl2);
        int n10 = cl2.a;
        this.a(arrayList, "received", n10);
    }
}

