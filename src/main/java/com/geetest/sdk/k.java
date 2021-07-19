/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.content.Context;
import android.util.Pair;
import com.geetest.sdk.i;
import com.geetest.sdk.k$a;
import com.geetest.sdk.k$b;
import com.geetest.sdk.l;
import com.geetest.sdk.p;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    private k() {
    }

    public /* synthetic */ k(k$a k$a) {
        this();
    }

    public static k a() {
        return k$b.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a(Context object) {
        long l10;
        Object object2 = "$unknown";
        JSONObject jSONObject = new JSONObject();
        if (object == null) {
            return jSONObject.toString();
        }
        String string2 = i.b(object, "gt_fp");
        String string3 = "gt_ts";
        long l11 = i.a(object, string3);
        long l12 = l11 - (l10 = 0L);
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 == false) {
            l11 = System.currentTimeMillis();
            i.a(object, string3, l11);
        }
        try {
            boolean bl2;
            block9: {
                String string4;
                String string5;
                block8: {
                    boolean bl3;
                    string3 = p.a(object);
                    boolean bl4 = i.a(string2);
                    if (bl4 && !(bl3 = i.a(string3))) {
                        string2 = i.c(object, string3);
                    }
                    string5 = "bd";
                    jSONObject.put(string5, (Object)string3);
                    string3 = l.a(object);
                    string5 = "e";
                    string4 = "d";
                    if (string3 == null) break block8;
                    object2 = ((Pair)string3).first;
                    jSONObject.put(string4, object2);
                    object2 = ((Pair)string3).second;
                    jSONObject.put(string5, object2);
                    bl2 = i.a(string2);
                    if (bl2) {
                        object2 = ((Pair)string3).first;
                        bl2 = i.a((String)(object2 = (String)object2));
                        if (!bl2) {
                            object2 = ((Pair)string3).first;
                            object2 = (String)object2;
                            string2 = i.c(object, (String)object2);
                        }
                    }
                    break block9;
                }
                jSONObject.put(string4, object2);
                jSONObject.put(string5, object2);
            }
            if (bl2 = i.a(string2)) {
                object2 = UUID.randomUUID();
                object2 = ((UUID)object2).toString();
                string2 = i.c(object, (String)object2);
            }
            String string6 = "fp";
            jSONObject.put(string6, (Object)string2);
            String string7 = "ts";
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(l11);
            string2 = "";
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            jSONObject.put(string7, object2);
            String string8 = "ver";
            object2 = "1.0.0";
            jSONObject.put(string8, object2);
            String string9 = "client_type";
            object2 = "android";
            jSONObject.put(string9, object2);
            return jSONObject.toString();
        }
        catch (JSONException jSONException) {
            return jSONObject.toString();
        }
    }
}

