/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.geetest.sdk.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.geetest.sdk.views.GT3GeetestButton;

public class GT3GeetestButton$a
implements View.OnClickListener {
    public final /* synthetic */ Context a;

    public GT3GeetestButton$a(GT3GeetestButton gT3GeetestButton, Context context) {
        this.a = context;
    }

    public void onClick(View object) {
        object = "http://www.geetest.com/first_page";
        object = Uri.parse((String)object);
        String string2 = "android.intent.action.VIEW";
        Intent intent = new Intent(string2, (Uri)object);
        object = this.a;
        try {
            object.startActivity(intent);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

