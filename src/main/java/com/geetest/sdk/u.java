/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.ab;
import com.geetest.sdk.ac;
import com.geetest.sdk.ar;
import com.geetest.sdk.ba;
import com.geetest.sdk.bb;
import com.geetest.sdk.g;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.model.beans.c;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.n;
import com.geetest.sdk.v;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class u
implements v {
    private static final String e = "u";
    public u a;
    public bb b;
    public Context c;
    public GT3ConfigBean d;

    public void a(u u10) {
        this.a = u10;
    }

    public void b(bb object) {
        Object object2 = ((bb)object).e();
        Object object3 = e;
        Object object4 = ((bb)object).f().toString();
        l.b((String)object3, (String)object4);
        object3 = ((bb)object).f().clone();
        ((g)object2).a((GT3ErrorBean)object3);
        object2 = n.b;
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 == 0) {
            object2 = new JSONObject();
            object3 = "time";
            long l10 = System.currentTimeMillis();
            object4 = ba.a(l10);
            object2.put((String)object3, object4);
            object3 = "captcha_id";
            object4 = ((bb)object).d();
            object4 = ((b)object4).k();
            object2.put((String)object3, object4);
            object3 = "client_type";
            object4 = "android";
            object2.put((String)object3, object4);
            object3 = "challenge";
            object4 = ((bb)object).d();
            object4 = ((b)object4).c();
            object2.put((String)object3, object4);
            object3 = "exception_desc";
            object4 = ((bb)object).f();
            object4 = ((a)object4).b();
            object2.put((String)object3, object4);
            object3 = "error_code";
            object = ((bb)object).f();
            object = ((a)object).a();
            object2.put((String)object3, object);
            object = "device_type";
            object3 = Build.MODEL;
            object2.put((String)object, object3);
            object = "device_os_version";
            object3 = Build.VERSION.RELEASE;
            object2.put((String)object, object3);
            object = "sdk_version";
            object3 = "4.3.3";
            object2.put((String)object, object3);
            object = object2.toString();
            object2 = ab.ERROR;
            n10 = ((ab)object2).flag;
            ac.b((String)object, n10);
            object = "";
            try {
                n.b = object;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void c(bb bb2) {
        int n10;
        int n11 = this.d(bb2);
        if (n11 == 0) {
            this.b(bb2);
        }
        if ((n11 = this.a()) >= (n10 = bb2.h())) {
            this.a(bb2);
        } else {
            u u10 = this.a;
            if (u10 != null) {
                u10.c(bb2);
            } else {
                this.b(bb2);
            }
        }
    }

    public boolean d(bb object) {
        Context context;
        if (object == null) {
            return false;
        }
        this.b = object;
        this.c = context = ((bb)object).c();
        if (context == null) {
            return false;
        }
        this.d = object = ((bb)object).b();
        return object != null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e(bb object) {
        Object object2 = "success";
        String string2 = "1";
        c c10 = ((bb)object).i();
        JSONObject jSONObject = new JSONObject();
        try {
            boolean bl2;
            String string3 = c10.a();
            boolean bl3 = string2.equals(string3);
            String string4 = "0";
            if (bl3 && (bl3 = string4.equals(string3 = c10.i())) && (bl3 = string4.equals(string3 = c10.c()))) {
                c10.c(string2);
                c10.i(string2);
            }
            if (bl3 = ((String)object2).equals(string3 = c10.f())) {
                c10.g(string2);
            }
            if (!(bl2 = string4.equals(string2 = c10.e()))) {
                string2 = "gt";
                string3 = c10.d();
                jSONObject.put(string2, (Object)string3);
                string2 = "challenge";
                string3 = c10.b();
                jSONObject.put(string2, (Object)string3);
                string2 = c10.h();
                jSONObject.put((String)object2, (Object)string2);
            }
            object2 = "a1";
            string2 = c10.e();
            jSONObject.put((String)object2, (Object)string2);
            object2 = c10.e();
            boolean bl4 = string4.equals(object2);
            if (!bl4 && !(bl4 = ((String)(object2 = "false")).equals(string2 = c10.h()))) {
                object2 = "t";
                string2 = c10.i();
                jSONObject.put((String)object2, (Object)string2);
                object2 = c10.i();
                bl4 = string4.equals(object2);
                if (!bl4) {
                    object2 = "g";
                    string2 = c10.c();
                    jSONObject.put((String)object2, (Object)string2);
                    object2 = c10.c();
                    bl4 = string4.equals(object2);
                    if (!bl4) {
                        object2 = "a";
                        string2 = c10.a();
                        jSONObject.put((String)object2, (Object)string2);
                        object2 = c10.a();
                        bl4 = string4.equals(object2);
                        if (!bl4) {
                            object2 = "r";
                            string2 = c10.g();
                            jSONObject.put((String)object2, (Object)string2);
                            object2 = c10.g();
                            bl4 = string4.equals(object2);
                            if (!bl4) {
                                object2 = "re";
                                string2 = c10.f();
                                jSONObject.put((String)object2, (Object)string2);
                            }
                        }
                    }
                }
            }
            if ((object2 = ((bb)object).f()) != null) {
                object2 = "error";
                object = ((bb)object).f();
                object = ((a)object).a();
                jSONObject.put((String)object2, object);
            }
            object = this.c;
            ar.a((Context)object, jSONObject);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        object = this.d;
        if (object != null && (object = ((GT3ConfigBean)object).getListener()) != null) {
            object = this.d.getListener();
            object2 = jSONObject.toString();
            object.onStatistics((String)object2);
        }
    }
}

