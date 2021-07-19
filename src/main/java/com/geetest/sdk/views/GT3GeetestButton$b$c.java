/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.views;

import com.geetest.sdk.model.beans.i;
import com.geetest.sdk.utils.o;
import com.geetest.sdk.views.GT3GeetestButton;
import com.geetest.sdk.views.GT3GeetestButton$b;

public class GT3GeetestButton$b$c
implements Runnable {
    public final /* synthetic */ GT3GeetestButton$b a;

    public GT3GeetestButton$b$c(GT3GeetestButton$b gT3GeetestButton$b) {
        this.a = gT3GeetestButton$b;
    }

    public void run() {
        GT3GeetestButton.access$500(this.a.a).g();
        GT3GeetestButton gT3GeetestButton = this.a.a;
        Object object = GT3GeetestButton.access$300(gT3GeetestButton);
        String string2 = "gt3_lin_bg_shape";
        int n10 = o.a(object, string2);
        gT3GeetestButton.setBackgroundResource(n10);
        gT3GeetestButton = this.a.a;
        boolean bl2 = GT3GeetestButton.access$600(gT3GeetestButton);
        if (bl2) {
            gT3GeetestButton = GT3GeetestButton.access$700(this.a.a);
            object = GT3GeetestButton.access$300(this.a.a);
            string2 = "gt3logogray";
            n10 = o.d(object, string2);
            gT3GeetestButton.setImageResource(n10);
        }
        gT3GeetestButton = GT3GeetestButton.access$800(this.a.a);
        object = i.a();
        gT3GeetestButton.setText((CharSequence)object);
        GT3GeetestButton.access$800(this.a.a).setTextColor(-13092808);
        GT3GeetestButton.access$800(this.a.a).setAlpha(1.0f);
    }
}

