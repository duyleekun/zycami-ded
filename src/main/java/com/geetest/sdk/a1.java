/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.sdk.a4;
import com.geetest.sdk.a6;
import com.geetest.sdk.ar;
import com.geetest.sdk.aw;
import com.geetest.sdk.az;
import com.geetest.sdk.j;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.utils.l;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a1
extends aw {
    private static final String l = "a1";
    private b j;
    private Map k;

    private a1(String string2, Context context) {
        super(string2, context);
    }

    public static a1 a(Context context, b b10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("https://");
        Object object = b10.b();
        charSequence.append((String)object);
        charSequence.append("/ajax.php?gt=");
        object = b10.k();
        charSequence.append((String)object);
        charSequence.append("&challenge=");
        object = b10.c();
        charSequence.append((String)object);
        charSequence.append("&client_type=android&lang=");
        object = b10.m();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        object = new a1((String)charSequence, context);
        ((aw)object).a(0);
        ((a1)object).j = b10;
        ((aw)object).c("Ajax");
        ((aw)object).a(true);
        return object;
    }

    /*
     * Loose catch block
     */
    public boolean a(int n10, az az2, JSONObject object) {
        Object object2 = "error_code";
        CharSequence charSequence = object.optString("user_error");
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        boolean bl3 = true;
        if (!bl2) {
            String string2;
            block18: {
                string2 = "utf-8";
                try {
                    charSequence = URLDecoder.decode((String)charSequence, string2);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                string2 = object.optString((String)object2);
                if (string2 == null) break block18;
                String string3 = "[a-zA-Z]";
                String string4 = "";
                {
                    catch (Exception exception) {
                        exception.printStackTrace();
                        charSequence = new StringBuilder();
                        object = object.toString();
                        ((StringBuilder)charSequence).append((String)object);
                        ((StringBuilder)charSequence).append(": ");
                        String string5 = exception.toString();
                        ((StringBuilder)charSequence).append(string5);
                        string5 = ((StringBuilder)charSequence).toString();
                        az2.a = string5;
                        return false;
                    }
                }
                string2 = string2.replaceAll(string3, string4);
            }
            az2.a = charSequence;
            charSequence = new JSONObject();
            charSequence.put((String)object2, (Object)string2);
            az2.b = charSequence;
            return bl3;
        }
        object2 = "data";
        charSequence = object.optJSONObject((String)object2);
        Object object3 = ":  ";
        if (charSequence == null) {
            charSequence = new StringBuilder();
            object = object.toString();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append((String)object3);
            object2 = this.a((String)object2);
            ((StringBuilder)charSequence).append((String)object2);
            az2.a = object2 = ((StringBuilder)charSequence).toString();
            return false;
        }
        object2 = "result";
        String string6 = charSequence.optString((String)object2);
        boolean bl4 = TextUtils.isEmpty((CharSequence)string6);
        if (bl4) {
            charSequence = new StringBuilder();
            object = object.toString();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append((String)object3);
            object2 = this.a((String)object2);
            ((StringBuilder)charSequence).append((String)object2);
            az2.a = object2 = ((StringBuilder)charSequence).toString();
            return false;
        }
        this.j.j(string6);
        object2 = this.j.j();
        if (object2 == null) {
            az2.a = "GetTypeBean is null";
            return false;
        }
        object2 = this.j.j().b();
        if (object2 == null) {
            az2.a = "GetTypeBean JsonObject is null";
            return false;
        }
        object2 = this.j.j().b();
        n10 = (int)(object2.has(string6) ? 1 : 0);
        if (n10 != 0) {
            object2 = this.j;
            object3 = ((b)object2).j().b().optString(string6);
            ((b)object2).l((String)object3);
        } else {
            object2 = this.j;
            bl2 = false;
            object3 = null;
            ((b)object2).l(null);
        }
        object2 = "validate";
        bl2 = charSequence.has((String)object2);
        if (bl2) {
            object3 = this.j;
            object2 = charSequence.optString((String)object2);
            ((b)object3).m((String)object2);
        }
        az2.a = "OK";
        az2.b = object;
        return bl3;
    }

    public Map c() {
        int n10;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        String string2 = "gzip";
        hashMap.put("Accept-Encoding", string2);
        hashMap.put("Content-Encoding", string2);
        Object object = this.j;
        if (object != null) {
            object = ((b)object).b();
            string2 = "Host";
            hashMap.put(string2, object);
        }
        if ((object = (Object)this.f) == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((Object)object).length;
        }
        object = String.valueOf(n10);
        hashMap.put("Content-Length", object);
        return hashMap;
    }

    public boolean e() {
        return super.e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            String string2;
            int n10;
            Context context = this.b;
            String string3 = ar.a(context);
            Object object = this.j;
            object = ((b)object).p();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            Object object2 = "]";
            String string4 = "[";
            String string5 = "";
            if (!bl2) {
                object = this.j;
                object = ((b)object).p();
                object = ((String)object).replace(string4, string5);
                object = ((String)object).replace((CharSequence)object2, string5);
            } else {
                bl2 = false;
                object = null;
            }
            Object object3 = this.j;
            object3 = ((b)object3).n();
            boolean bl3 = TextUtils.isEmpty((CharSequence)object3);
            if (!bl3) {
                object3 = this.j;
                object3 = ((b)object3).n();
                object2 = ((String)object3).replace((CharSequence)object2, string5);
                object2 = ((String)object2).replace(string4, string5);
                string4 = "{";
                object2 = ((String)object2).replace(string4, string5);
                string4 = "}";
                object2 = ((String)object2).replace(string4, string5);
            } else {
                n10 = 0;
                object2 = null;
            }
            string4 = new JSONObject();
            object3 = " ";
            if (string3 != null) {
                string2 = string3.replaceAll((String)object3, string5);
                String string6 = "mi";
                string4.put(string6, (Object)string2);
            }
            if (object != null) {
                object = ((String)object).replaceAll((String)object3, string5);
                string2 = "m";
                string4.put(string2, object);
            }
            if (object2 != null) {
                object = ((String)object2).replaceAll((String)object3, string5);
                object2 = "light";
                string4.put((String)object2, object);
            }
            object = new JSONObject();
            object2 = this.j;
            this.k = object2 = ((b)object2).s();
            if (object2 != null && (n10 = object2.size()) > 0) {
                object2 = "ci";
                object3 = this.k;
                string5 = new JSONObject((Map)object3);
                object.put((String)object2, (Object)string5);
            }
            if ((n10 = object.length()) > 0) {
                object2 = "ep";
                object = object.toString();
                string4.put((String)object2, object);
            }
            object = "sign";
            object2 = "e6OXZ8q2cdJQctncOhd4qyT8iR32jZwU";
            byte[] byArray = a6.a(string3, (String)object2);
            string4.put((String)object, (Object)byArray);
            String string7 = "gid";
            object = com.geetest.sdk.j.a();
            object2 = this.b;
            object2 = object2.getApplicationContext();
            object = ((j)object).a((Context)object2);
            string4.put(string7, object);
            String string8 = "gt";
            object = this.j;
            object = ((b)object).k();
            jSONObject.put(string8, object);
            String string9 = "challenge";
            object = this.j;
            object = ((b)object).c();
            jSONObject.put(string9, object);
            String string10 = "client_type";
            object = "android";
            jSONObject.put(string10, object);
            String string11 = l;
            object = new StringBuilder();
            object2 = "ajax add info: ";
            ((StringBuilder)object).append((String)object2);
            object2 = string4.toString();
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            com.geetest.sdk.utils.l.d(string11, (String)object);
            String string12 = "w";
            object = string4.toString();
            object2 = this.j;
            object2 = ((b)object2).a();
            object = a4.b((String)object, (String)object2);
            jSONObject.put(string12, object);
            return jSONObject;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            String string13 = l;
            String string14 = exception.toString();
            com.geetest.sdk.utils.l.b(string13, string14);
            return null;
        }
    }
}

