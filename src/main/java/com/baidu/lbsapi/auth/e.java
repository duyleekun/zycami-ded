/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.baidu.lbsapi.auth;

import android.content.Context;
import com.baidu.lbsapi.auth.ErrorMessage;
import com.baidu.lbsapi.auth.a;
import com.baidu.lbsapi.auth.e$a;
import com.baidu.lbsapi.auth.f;
import com.baidu.lbsapi.auth.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    private Context a;
    private List b = null;
    private e$a c = null;

    public e(Context context) {
        this.a = context;
    }

    public static /* synthetic */ List a(e e10) {
        return e10.b;
    }

    private List a(HashMap hashMap, String[] object) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object != null && (n10 = ((String[])object).length) > 0) {
            int n11;
            Object var5_5 = null;
            for (n10 = 0; n10 < (n11 = ((String[])object).length); ++n10) {
                String string2;
                boolean bl2;
                HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
                Object object2 = hashMap.keySet().iterator();
                while (bl2 = object2.hasNext()) {
                    string2 = ((String)object2.next()).toString();
                    Object v10 = hashMap.get(string2);
                    hashMap2.put(string2, v10);
                }
                object2 = object[n10];
                string2 = "mcode";
                hashMap2.put(string2, object2);
                arrayList.add(hashMap2);
            }
        } else {
            boolean bl3;
            object = new HashMap();
            Iterator iterator2 = hashMap.keySet().iterator();
            while (bl3 = iterator2.hasNext()) {
                String string3 = ((String)iterator2.next()).toString();
                Object v11 = hashMap.get(string3);
                ((HashMap)object).put(string3, v11);
            }
            arrayList.add(object);
        }
        return arrayList;
    }

    public static /* synthetic */ void a(e e10, List list) {
        e10.a(list);
    }

    private void a(String object) {
        JSONObject jSONObject;
        String string2;
        block9: {
            string2 = "status";
            if (object == null) {
                object = "";
            }
            int n10 = -1;
            jSONObject = new JSONObject((String)object);
            boolean bl2 = jSONObject.has(string2);
            if (bl2) break block9;
            try {
                jSONObject.put(string2, n10);
            }
            catch (JSONException jSONException) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(string2, n10);
                }
                catch (JSONException jSONException2) {
                    jSONException2.printStackTrace();
                }
            }
        }
        if ((object = this.c) != null) {
            string2 = jSONObject.toString();
            object.a(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(List object) {
        String string2;
        Object object2;
        String string3;
        int n10;
        int n11;
        Serializable serializable = new StringBuilder();
        ((StringBuilder)serializable).append("syncConnect start Thread id = ");
        long l10 = Thread.currentThread().getId();
        String string4 = String.valueOf(l10);
        ((StringBuilder)serializable).append(string4);
        serializable = ((StringBuilder)serializable).toString();
        com.baidu.lbsapi.auth.a.a((String)((Object)serializable));
        if (object == null || (n11 = object.size()) == 0) {
            com.baidu.lbsapi.auth.a.c("syncConnect failed,params list is null or size is 0");
            return;
        }
        serializable = new ArrayList();
        string4 = null;
        int n12 = 0;
        String string5 = null;
        while (true) {
            n10 = object.size();
            string3 = "status";
            if (n12 >= n10) break;
            object2 = new StringBuilder();
            string2 = "syncConnect resuest ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(n12);
            ((StringBuilder)object2).append("  start!!!");
            com.baidu.lbsapi.auth.a.a(((StringBuilder)object2).toString());
            object2 = (HashMap)object.get(n12);
            Context context = this.a;
            Object object3 = new g(context);
            boolean bl2 = ((g)object3).a();
            if (bl2) {
                if ((object2 = ((g)object3).a((HashMap)object2)) == null) {
                    object2 = "";
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(n12);
                ((StringBuilder)object3).append("  result:");
                ((StringBuilder)object3).append((String)object2);
                string2 = ((StringBuilder)object3).toString();
                com.baidu.lbsapi.auth.a.a(string2);
                serializable.add(object2);
                try {
                    int n13;
                    string2 = new JSONObject((String)object2);
                    boolean bl3 = string2.has(string3);
                    if (bl3 && (n13 = string2.getInt(string3)) == 0) {
                        string3 = "auth end and break";
                        com.baidu.lbsapi.auth.a.a(string3);
                        this.a((String)object2);
                        return;
                    }
                }
                catch (JSONException jSONException) {
                    object2 = "continue-------------------------------";
                    com.baidu.lbsapi.auth.a.a((String)object2);
                }
            } else {
                object2 = "Current network is not available.";
                com.baidu.lbsapi.auth.a.a((String)object2);
                object2 = ErrorMessage.a((String)object2);
                serializable.add(object2);
            }
            object2 = "syncConnect end";
            com.baidu.lbsapi.auth.a.a((String)object2);
            ++n12;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("--iiiiii:");
        ((StringBuilder)object2).append(n12);
        ((StringBuilder)object2).append("<><>paramList.size():");
        int n14 = object.size();
        ((StringBuilder)object2).append(n14);
        string2 = "<><>authResults.size():";
        ((StringBuilder)object2).append(string2);
        n14 = serializable.size();
        ((StringBuilder)object2).append(n14);
        object2 = ((StringBuilder)object2).toString();
        com.baidu.lbsapi.auth.a.a((String)object2);
        n10 = object.size();
        if (n10 <= 0) return;
        int n15 = object.size();
        if (n12 != n15) return;
        n15 = serializable.size();
        if (n15 <= 0) return;
        n15 = serializable.size();
        if (n12 != n15) return;
        if ((n12 += -1) <= 0) return;
        try {
            string5 = (String)serializable.get(n12);
            string5 = string5;
            object = new JSONObject(string5);
            n12 = (int)(object.has(string3) ? 1 : 0);
            if (n12 == 0) return;
            n15 = object.getInt(string3);
            if (n15 == 0) return;
            object = "i-1 result is not 0,return first result";
            com.baidu.lbsapi.auth.a.a((String)object);
            object = serializable.get(0);
            object = (String)object;
            this.a((String)object);
            return;
        }
        catch (JSONException jSONException) {
            serializable = new StringBuilder();
            string4 = "JSONException:";
            ((StringBuilder)serializable).append(string4);
            String string6 = jSONException.getMessage();
            ((StringBuilder)serializable).append(string6);
            string6 = ErrorMessage.a(((StringBuilder)serializable).toString());
            this.a(string6);
        }
    }

    public void a(HashMap object, String[] object2, e$a e$a) {
        this.b = object = this.a((HashMap)object, (String[])object2);
        this.c = e$a;
        object2 = new f(this);
        object = new Thread((Runnable)object2);
        ((Thread)object).start();
    }
}

