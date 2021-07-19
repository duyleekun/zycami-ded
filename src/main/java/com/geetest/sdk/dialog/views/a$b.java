/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  org.json.JSONObject
 */
package com.geetest.sdk.dialog.views;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.geetest.sdk.au;
import com.geetest.sdk.dialog.views.a;
import com.geetest.sdk.dialog.views.a$a;
import com.geetest.sdk.dialog.views.a$b$a;
import com.geetest.sdk.dialog.views.a$b$b;
import com.geetest.sdk.dialog.views.a$b$c;
import com.geetest.sdk.dialog.views.a$b$d;
import com.geetest.sdk.utils.l;
import org.json.JSONObject;

public class a$b {
    public final /* synthetic */ a a;

    private a$b(a a10) {
        this.a = a10;
    }

    public /* synthetic */ a$b(a a10, a$a a$a) {
        this(a10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void gt3Error(String string2) {
        Context context;
        boolean bl2;
        Context context2;
        au au2;
        Object object;
        l.b("JSInterface-->gt3Error", string2);
        Handler handler = com.geetest.sdk.dialog.views.a.d(this.a);
        if (handler != null) {
            try {
                a a10 = this.a;
                Handler handler2 = com.geetest.sdk.dialog.views.a.d(a10);
                object = this.a;
                object = com.geetest.sdk.dialog.views.a.h((a)object);
                handler2.removeCallbacks((Runnable)object);
                a a11 = this.a;
                Handler handler3 = com.geetest.sdk.dialog.views.a.d(a11);
                int n10 = 1;
                handler3.removeMessages(n10);
            }
            catch (Exception exception) {}
        }
        if ((au2 = com.geetest.sdk.dialog.views.a.a(this.a)) != null && (context2 = com.geetest.sdk.dialog.views.a.e(this.a)) != null && (bl2 = (context = com.geetest.sdk.dialog.views.a.e(this.a)) instanceof Activity)) {
            Activity activity = (Activity)com.geetest.sdk.dialog.views.a.e(this.a);
            object = new a$b$c(this, string2);
            activity.runOnUiThread((Runnable)object);
        }
    }

    public void gtCallBack(String string2, String string3, String object) {
        block14: {
            Object object2 = com.geetest.sdk.dialog.views.a.e();
            CharSequence charSequence = new StringBuilder();
            String string4 = "JSInterface-->gtCallBack-->code: ";
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(string2);
            String string5 = ", message: ";
            ((StringBuilder)charSequence).append(string5);
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            l.b((String)object2, (String)charSequence);
            object2 = com.geetest.sdk.dialog.views.a.e();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(string2);
            string4 = ", result: ";
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string5);
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            l.d((String)object2, (String)object);
            int n10 = Integer.parseInt(string2);
            object = this.a;
            object = com.geetest.sdk.dialog.views.a.e((a)object);
            if (object == null) break block14;
            object = this.a;
            object = com.geetest.sdk.dialog.views.a.e((a)object);
            object = (Activity)object;
            boolean bl2 = object.isFinishing();
            if (bl2) break block14;
            object = this.a;
            object = com.geetest.sdk.dialog.views.a.e((a)object);
            object = (Activity)object;
            object2 = new a$b$a(this, n10, string3);
            try {
                object.runOnUiThread((Runnable)object2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void gtClose() {
        Object object = com.geetest.sdk.dialog.views.a.e();
        String string2 = "JSInterface-->gtClose";
        l.b((String)object, string2);
        object = com.geetest.sdk.dialog.views.a.a(this.a);
        if (object != null) {
            object = com.geetest.sdk.dialog.views.a.a(this.a);
            ((au)object).b();
        }
    }

    public void gtNotify(String object) {
        block18: {
            Object object2 = com.geetest.sdk.dialog.views.a.e();
            CharSequence charSequence = new StringBuilder();
            String string2 = "JSInterface-->gtNotify-->";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            l.b((String)object2, (String)charSequence);
            object2 = new JSONObject((String)object);
            object = "aspect_radio";
            object = object2.getString((String)object);
            int n10 = Integer.parseInt((String)object);
            object2 = this.a;
            com.geetest.sdk.dialog.views.a.a((a)object2, n10);
            object = this.a;
            object = com.geetest.sdk.dialog.views.a.e((a)object);
            if (object == null) break block18;
            object = this.a;
            object = com.geetest.sdk.dialog.views.a.e((a)object);
            object = (Activity)object;
            n10 = (int)(object.isFinishing() ? 1 : 0);
            if (n10 != 0) break block18;
            object = this.a;
            object = com.geetest.sdk.dialog.views.a.e((a)object);
            object = (Activity)object;
            object2 = new a$b$d(this);
            try {
                object.runOnUiThread((Runnable)object2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                object2 = com.geetest.sdk.dialog.views.a.a(this.a);
                charSequence = new StringBuilder();
                string2 = "parse aspect_radio failed-->";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.toString();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                charSequence = "202";
                ((au)object2).a((String)charSequence, string3);
            }
        }
    }

    public void gtReady() {
        boolean bl2;
        String string2 = com.geetest.sdk.dialog.views.a.e();
        Object object = "JSInterface-->gtReady";
        l.b(string2, (String)object);
        string2 = com.geetest.sdk.dialog.views.a.e(this.a);
        if (string2 != null && (bl2 = (string2 = com.geetest.sdk.dialog.views.a.e(this.a)) instanceof Activity)) {
            string2 = (Activity)com.geetest.sdk.dialog.views.a.e(this.a);
            object = new a$b$b(this);
            string2.runOnUiThread((Runnable)object);
        }
    }
}

