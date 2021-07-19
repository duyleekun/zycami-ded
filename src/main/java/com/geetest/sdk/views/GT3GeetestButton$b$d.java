/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.views;

import com.geetest.sdk.model.beans.i;
import com.geetest.sdk.utils.o;
import com.geetest.sdk.views.GT3GeetestButton;
import com.geetest.sdk.views.GT3GeetestButton$b;

public class GT3GeetestButton$b$d
implements Runnable {
    public final /* synthetic */ GT3GeetestButton$b a;

    public GT3GeetestButton$b$d(GT3GeetestButton$b gT3GeetestButton$b) {
        this.a = gT3GeetestButton$b;
    }

    public void run() {
        GT3GeetestButton.access$500(this.a.a).f();
        GT3GeetestButton gT3GeetestButton = this.a.a;
        int n10 = o.a(GT3GeetestButton.access$300(gT3GeetestButton), "gt3_lin_wait_shape");
        gT3GeetestButton.setBackgroundResource(n10);
        GT3GeetestButton.access$800(this.a.a).setTextColor(-6842473);
        gT3GeetestButton = GT3GeetestButton.access$800(this.a.a);
        String string2 = i.k();
        gT3GeetestButton.setText(string2);
        GT3GeetestButton.access$800(this.a.a).setAlpha(1.0f);
    }
}

