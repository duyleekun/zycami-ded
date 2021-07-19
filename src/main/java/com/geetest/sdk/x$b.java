/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.app.Activity;
import android.text.TextUtils;
import com.geetest.sdk.GT3Listener;
import com.geetest.sdk.av;
import com.geetest.sdk.bb;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.u;
import com.geetest.sdk.x;
import com.geetest.sdk.x$a;
import com.geetest.sdk.x$b$a;
import org.json.JSONObject;

public class x$b
extends av {
    private boolean a = false;
    public final /* synthetic */ x b;

    private x$b(x x10) {
        this.b = x10;
    }

    public /* synthetic */ x$b(x x10, x$a x$a) {
        this(x10);
    }

    public void a() {
        int n10 = this.a;
        if (n10 != 0) {
            return;
        }
        Object object = new JSONObject();
        Object object2 = "type";
        Object object3 = "Sensebot";
        object.put((String)object2, object3);
        object2 = "sdkVersion";
        object3 = "4.3.3";
        object.put((String)object2, object3);
        object2 = "challenge";
        object3 = this.b;
        object3 = ((u)object3).b;
        object3 = ((bb)object3).d();
        object3 = ((b)object3).c();
        object.put((String)object2, object3);
        object2 = "duration";
        long l10 = System.currentTimeMillis();
        Object object4 = this.b;
        object4 = ((u)object4).b;
        long l11 = ((bb)object4).j();
        l10 -= l11;
        try {
            object.put((String)object2, l10);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        object2 = this.b.b.b().getListener();
        object = object.toString();
        ((GT3Listener)object2).onDialogReady((String)object);
        this.b.b.e().l();
        object = this.b.b;
        n10 = ((bb)object).g();
        int n11 = 2;
        if (n10 == n11 && (object = this.b.b.a()) != null) {
            object.c();
        }
        this.b.b.i().g("1");
        object = this.b;
        object2 = ((u)object).b;
        ((u)object).e((bb)object2);
    }

    public void a(String object, String object2) {
        boolean bl2;
        boolean bl3;
        this.a = bl3 = true;
        x x10 = this.b;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("webview \u56de\u8c03\u9519\u8bef-->");
        charSequence.append((String)object);
        charSequence.append("-->");
        charSequence.append((String)object2);
        charSequence = charSequence.toString();
        String string2 = "_";
        boolean bl4 = ((String)object).startsWith(string2);
        x.a(x10, (String)object, (String)charSequence, (String)object2, bl4);
        boolean bl5 = TextUtils.isEmpty((CharSequence)object);
        if (!bl5 && !(bl2 = ((String)object).startsWith(string2))) {
            this.b.b.i().g("0");
            object = this.b;
            object2 = ((u)object).b;
            ((u)object).e((bb)object2);
        }
    }

    public void a(boolean bl2, String string2) {
        String string3 = "202";
        String string4 = "webview parse json error-->";
        if (bl2) {
            Object object = this.b;
            object = ((u)object).b;
            object = ((bb)object).d();
            Object object2 = new JSONObject(string2);
            CharSequence charSequence = "geetest_challenge";
            charSequence = object2.getString((String)charSequence);
            ((b)object).d((String)charSequence);
            charSequence = "geetest_validate";
            charSequence = object2.getString((String)charSequence);
            ((b)object).f((String)charSequence);
            charSequence = "geetest_seccode";
            object2 = object2.getString((String)charSequence);
            ((b)object).e((String)object2);
            object = this.b;
            object2 = ((u)object).a;
            object = ((u)object).b;
            try {
                ((u)object2).c((bb)object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                object2 = this.b;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("webview \u89e3\u6790json\u9519\u8bef\uff0c\u9519\u8bef\u7801\uff0c202--->");
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("  Exception: ");
                CharSequence charSequence2 = exception.toString();
                ((StringBuilder)charSequence).append((String)charSequence2);
                charSequence = ((StringBuilder)charSequence).toString();
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append(string4);
                ((StringBuilder)charSequence2).append(string2);
                string2 = "-->";
                ((StringBuilder)charSequence2).append(string2);
                String string5 = exception.toString();
                ((StringBuilder)charSequence2).append(string5);
                string5 = ((StringBuilder)charSequence2).toString();
                x.a((x)object2, string3, (String)charSequence, string5, false);
            }
        } else {
            x x10 = this.b;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("webview \u9a8c\u8bc1\u9519\u8bef\uff0c\u9519\u8bef\u7801\uff0c202--->");
            charSequence.append(string2);
            charSequence = charSequence.toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            x.a(x10, string3, (String)charSequence, string2, false);
        }
    }

    public void b() {
        Activity activity = (Activity)this.b.c;
        x$b$a x$b$a = new x$b$a(this);
        activity.runOnUiThread((Runnable)x$b$a);
    }
}

