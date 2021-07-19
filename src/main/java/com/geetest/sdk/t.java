/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3Listener;
import com.geetest.sdk.bb;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.u;
import com.geetest.sdk.utils.l;
import org.json.JSONObject;

public class t
extends u {
    private static final String f = "t";

    public int a() {
        return 25;
    }

    public void a(bb bb2) {
        Object object = new JSONObject();
        Object object2 = "geetest_challenge";
        Object object3 = bb2.d();
        object3 = ((b)object3).f();
        object.put((String)object2, object3);
        object2 = "geetest_seccode";
        object3 = bb2.d();
        object3 = ((b)object3).g();
        object.put((String)object2, object3);
        object2 = "geetest_validate";
        object3 = bb2.d();
        object3 = ((b)object3).h();
        object.put((String)object2, object3);
        object2 = bb2.b();
        object2 = ((GT3ConfigBean)object2).getListener();
        object = object.toString();
        try {
            ((GT3Listener)object2).onDialogResult((String)object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object2 = f;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("\u62fc\u63a5\u9519\u8bef\uff0c\u9519\u8bef\u7801\u4e3a\uff1a202-->");
            String string2 = exception.toString();
            ((StringBuilder)object3).append(string2);
            object3 = ((StringBuilder)object3).toString();
            l.b((String)object2, (String)object3);
            object2 = new a();
            object3 = new StringBuilder();
            string2 = "onDialogResult error-->";
            ((StringBuilder)object3).append(string2);
            String string3 = exception.toString();
            ((StringBuilder)object3).append(string3);
            string3 = ((StringBuilder)object3).toString();
            ((a)object2).c(string3);
            ((a)object2).b("202");
            long l10 = System.currentTimeMillis();
            long l11 = bb2.j();
            ((a)object2).a(l10 -= l11);
            string3 = bb2.d().c();
            ((a)object2).a(string3);
            bb2.a((a)object2);
            this.b(bb2);
        }
    }
}

