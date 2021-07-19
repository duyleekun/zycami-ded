/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.geetest.sdk.dialog.views;

import com.geetest.sdk.au;
import com.geetest.sdk.dialog.views.a;
import com.geetest.sdk.dialog.views.a$b;
import org.json.JSONObject;

public class a$b$c
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ a$b b;

    public a$b$c(a$b a$b, String string2) {
        this.b = a$b;
        this.a = string2;
    }

    public void run() {
        Object object = this.a;
        Object object2 = new JSONObject((String)object);
        object = "error_code";
        object = object2.getString((String)object);
        Object object3 = "[a-zA-Z]";
        String string2 = "";
        object = ((String)object).replaceAll((String)object3, string2);
        object3 = "user_error";
        object2 = object2.getString((String)object3);
        object3 = this.b;
        object3 = ((a$b)object3).a;
        object3 = com.geetest.sdk.dialog.views.a.a((a)object3);
        try {
            ((au)object3).a((String)object, (String)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = com.geetest.sdk.dialog.views.a.a(this.b.a);
            object3 = new StringBuilder();
            string2 = this.a;
            ((StringBuilder)object3).append(string2);
            string2 = "-->";
            ((StringBuilder)object3).append(string2);
            String string3 = exception.toString();
            ((StringBuilder)object3).append(string3);
            string3 = ((StringBuilder)object3).toString();
            object3 = "202";
            ((au)object).a((String)object3, string3);
        }
    }
}

