/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import com.geetest.sdk.az;
import com.geetest.sdk.bb;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.c;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.t;
import com.geetest.sdk.utils.u;
import com.geetest.sdk.w$a;
import org.json.JSONObject;

public class w
extends com.geetest.sdk.u {
    private static final String f = "w";

    private az a(int n10, String object, JSONObject object2) {
        Boolean bl2 = Boolean.FALSE;
        n10 = (int)(u.a(n10) ? 1 : 0);
        String string2 = "get\u63a5\u53e3\u8fd4\u56de\u9519\u8bef\uff0c\u9519\u8bef\u7801\u4e3a\uff1a207-->";
        CharSequence charSequence = "0";
        if (n10 == 0) {
            Object object3 = "OK";
            n10 = (int)(((String)object3).equals(object) ? 1 : 0);
            if (n10 == 0) {
                this.b.i().c((String)charSequence);
                object3 = f;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append((String)object);
                string2 = ((StringBuilder)charSequence).toString();
                l.b((String)object3, string2);
                object3 = new a();
                ((a)object3).c((String)object);
                object = object2.optString("error_code");
                ((a)object3).b((String)object);
                long l10 = System.currentTimeMillis();
                long l11 = this.b.j();
                ((a)object3).a(l10 -= l11);
                object = this.b.d().c();
                ((a)object3).a((String)object);
                object = new az(bl2, object3);
                return object;
            }
            object3 = this.b.i();
            object = "1";
            ((c)object3).c((String)object);
            object3 = this.b;
            n10 = ((bb)object3).g();
            int n11 = 2;
            if (n10 == n11 && (object3 = this.b.a()) != null) {
                n11 = (int)(com.geetest.sdk.model.beans.f.a() ? 1 : 0);
                if (n11 != 0) {
                    object3.b();
                } else {
                    object3.e();
                }
            }
            object = Boolean.TRUE;
            object3 = new az(object, null);
            return object3;
        }
        this.b.i().c((String)charSequence);
        Object object4 = f;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        l.b((String)object4, (String)object2);
        object4 = new a();
        ((a)object4).c((String)object);
        ((a)object4).b("207");
        long l12 = System.currentTimeMillis();
        long l13 = this.b.j();
        ((a)object4).a(l12 -= l13);
        object = this.b.d().c();
        ((a)object4).a((String)object);
        object = new az(bl2, object4);
        return object;
    }

    public static /* synthetic */ az a(w w10, int n10, String string2, JSONObject jSONObject) {
        return w10.b(n10, string2, jSONObject);
    }

    private az b(int n10, String object, JSONObject object2) {
        Boolean bl2 = Boolean.FALSE;
        n10 = (int)(u.a(n10) ? 1 : 0);
        CharSequence charSequence = "0";
        if (n10 == 0) {
            Object object3 = "OK";
            n10 = (int)(((String)object3).equals(object) ? 1 : 0);
            if (n10 == 0) {
                this.b.i().i((String)charSequence);
                object3 = f;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("gettype\u63a5\u53e3\u8fd4\u56de\u9519\u8bef\uff0c\u9519\u8bef\u7801\u4e3a\uff1a206-->");
                ((StringBuilder)charSequence).append((String)object);
                charSequence = ((StringBuilder)charSequence).toString();
                l.b((String)object3, (String)charSequence);
                object3 = new a();
                ((a)object3).c((String)object);
                object = object2.optString("error_code");
                ((a)object3).b((String)object);
                long l10 = System.currentTimeMillis();
                long l11 = this.b.j();
                ((a)object3).a(l10 -= l11);
                object = this.b.d().c();
                ((a)object3).a((String)object);
                object = new az(bl2, object3);
                return object;
            }
            this.b.i().i("1");
            object = Boolean.TRUE;
            object3 = new az(object, null);
            return object3;
        }
        this.b.i().i((String)charSequence);
        Object object4 = f;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("gettype\u63a5\u53e3\u8fd4\u56de\u503c\u4e3anull\uff0c\u9519\u8bef\u7801\u4e3a\uff1a206-->");
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        l.b((String)object4, (String)object2);
        object4 = new a();
        ((a)object4).c((String)object);
        ((a)object4).b("206");
        long l12 = System.currentTimeMillis();
        long l13 = this.b.j();
        ((a)object4).a(l12 -= l13);
        object = this.b.d().c();
        ((a)object4).a((String)object);
        object = new az(bl2, object4);
        return object;
    }

    public static /* synthetic */ az b(w w10, int n10, String string2, JSONObject jSONObject) {
        return w10.a(n10, string2, jSONObject);
    }

    public static /* synthetic */ String b() {
        return f;
    }

    public int a() {
        return 5;
    }

    public void a(bb bb2) {
        t t10 = t.a();
        w$a w$a = new w$a(this, bb2);
        t10.a(w$a);
    }
}

