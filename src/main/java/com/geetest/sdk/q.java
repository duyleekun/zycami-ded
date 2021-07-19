/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.text.TextUtils;
import com.geetest.sdk.a8;
import com.geetest.sdk.bb;
import com.geetest.sdk.bb$a;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.model.beans.c;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.u;
import org.json.JSONObject;

public class q
extends com.geetest.sdk.u {
    private static final String f = "q";

    private void a(int n10, String object, JSONObject object2) {
        Object object3 = f;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "API1 result-->";
        stringBuilder.append(string2);
        object2 = object2 == null ? " null" : object2.toString();
        stringBuilder.append((String)object2);
        object2 = stringBuilder.toString();
        l.b((String)object3, (String)object2);
        n10 = (int)(u.a(n10) ? 1 : 0);
        if (n10 == 0) {
            this.b.i().e("1");
            Object object4 = this.b.i();
            object = this.b.d().k();
            ((c)object4).d((String)object);
            object4 = this.b.i();
            object = this.b.d().c();
            ((c)object4).b((String)object);
            object4 = this.b.d();
            n10 = (int)(((b)object4).w() ? 1 : 0);
            if (n10 != 0) {
                this.b.i().h("true");
                object4 = this.a;
                object = this.b;
                ((com.geetest.sdk.u)object4).c((bb)object);
            } else {
                l.b((String)object3, "\u8fdb\u5165\u5b95\u673a\u6a21\u5f0f\uff01\uff01\uff01");
                object4 = this.b;
                n10 = ((bb)object4).g();
                int n11 = 2;
                if (n10 == n11 && (object4 = this.b.a()) != null) {
                    object4.f();
                }
                this.b.i().h("false");
                object4 = this.b;
                object = bb$a.SHUTDOWN;
                ((bb)object4).k = object;
                object4 = a8.a(((bb)object4).d().c());
                object = this.b.d();
                object2 = this.b.d().c();
                ((b)object).d((String)object2);
                object = this.b.d();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object4);
                object3 = "|jordan";
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                ((b)object).e((String)object2);
                this.b.d().f((String)object4);
                object4 = this.b;
                n11 = 22;
                ((bb)object4).b(n11);
                object4 = this.a;
                object = this.b;
                ((com.geetest.sdk.u)object4).c((bb)object);
                object4 = this.b;
                this.e((bb)object4);
            }
        } else {
            this.b.i().e("0");
            Object object5 = new StringBuilder();
            ((StringBuilder)object5).append("api1\u63a5\u53e3\u9519\u8bef\uff0c\u9519\u8bef\u7801\u4e3a\uff1a205-->");
            ((StringBuilder)object5).append((String)object);
            object5 = ((StringBuilder)object5).toString();
            l.b((String)object3, (String)object5);
            object5 = new a();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("  {1.\u68c0\u67e5\u7f51\u7edc\u662f\u5426\u5f02\u5e38; 2.\u68c0\u67e5api1\u662f\u5426\u6709\u6570\u636e\u8fd4\u56de\uff0c\u5982\u679c\u6709\u6570\u636e\u8fd4\u56de\u662f\u5426\u7b26\u5408\u89c4\u5219; 3.\u68c0\u67e5\u662f\u5426\u548c\u670d\u52a1\u6b63\u5e38\u901a\u4fe1 }");
            object = ((StringBuilder)object2).toString();
            ((a)object5).c((String)object);
            ((a)object5).b("205");
            long l10 = System.currentTimeMillis();
            object3 = this.b;
            long l11 = ((bb)object3).j();
            ((a)object5).a(l10 -= l11);
            boolean bl2 = false;
            ((a)object5).a(null);
            object = this.b;
            ((bb)object).a((a)object5);
            object5 = this.b;
            this.e((bb)object5);
            object5 = this.b;
            this.b((bb)object5);
        }
    }

    public int a() {
        return 1;
    }

    public void a(bb object) {
        JSONObject jSONObject = this.d.getApi1Json();
        object = ((bb)object).d();
        this.a((b)object, jSONObject);
    }

    public void a(b object, JSONObject jSONObject) {
        int n10 = -1;
        if (jSONObject == null) {
            this.a(n10, "api1 result is null !", null);
            return;
        }
        String string2 = "data";
        int n11 = jSONObject.has(string2);
        String string3 = "-->absent gt";
        String string4 = "OK";
        String string5 = "-->absent challenge";
        String string6 = "gt";
        String string7 = "challenge";
        String string8 = "success";
        if (n11 != 0) {
            if ((string2 = jSONObject.optJSONObject(string2)) == null) {
                object = new StringBuilder();
                string2 = jSONObject.toString();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append("-->absent data");
                object = ((StringBuilder)object).toString();
                this.a(n10, (String)object, jSONObject);
                return;
            }
            n11 = string2.optInt(string8);
            boolean bl2 = TextUtils.isEmpty((CharSequence)(string7 = string2.optString(string7)));
            if (bl2) {
                object = new StringBuilder();
                string2 = jSONObject.toString();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(string5);
                object = ((StringBuilder)object).toString();
                this.a(n10, (String)object, jSONObject);
                return;
            }
            boolean bl3 = TextUtils.isEmpty((CharSequence)(string2 = string2.optString(string6)));
            if (bl3) {
                object = new StringBuilder();
                string2 = jSONObject.toString();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(string3);
                object = ((StringBuilder)object).toString();
                this.a(n10, (String)object, jSONObject);
                return;
            }
            ((b)object).c(string7);
            ((b)object).g(string2);
            ((b)object).b(n11);
            this.a(0, string4, jSONObject);
        } else {
            int n12 = jSONObject.optInt(string8);
            String string9 = jSONObject.optString(string7);
            boolean bl4 = TextUtils.isEmpty((CharSequence)string9);
            if (bl4) {
                object = new StringBuilder();
                string2 = jSONObject.toString();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(string5);
                object = ((StringBuilder)object).toString();
                this.a(n10, (String)object, jSONObject);
                return;
            }
            string5 = jSONObject.optString(string6);
            boolean bl5 = TextUtils.isEmpty((CharSequence)string5);
            if (bl5) {
                object = new StringBuilder();
                string2 = jSONObject.toString();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(string3);
                object = ((StringBuilder)object).toString();
                this.a(n10, (String)object, jSONObject);
                return;
            }
            ((b)object).c(string9);
            ((b)object).g(string5);
            ((b)object).b(n12);
            this.a(0, string4, jSONObject);
        }
    }
}

