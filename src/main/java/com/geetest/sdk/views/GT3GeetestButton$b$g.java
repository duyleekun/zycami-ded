/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.geetest.sdk.views;

import android.text.TextUtils;
import com.geetest.sdk.model.beans.i;
import com.geetest.sdk.utils.o;
import com.geetest.sdk.views.GT3GeetestButton;
import com.geetest.sdk.views.GT3GeetestButton$b;

public class GT3GeetestButton$b$g
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ GT3GeetestButton$b c;

    public GT3GeetestButton$b$g(GT3GeetestButton$b gT3GeetestButton$b, String string2, String string3) {
        this.c = gT3GeetestButton$b;
        this.a = string2;
        this.b = string3;
    }

    public void run() {
        GT3GeetestButton.access$500(this.c.a).b();
        Object object = this.c.a;
        Object object2 = GT3GeetestButton.access$300((GT3GeetestButton)((Object)object));
        String string2 = "gt3_lin_file_shape";
        int n10 = o.a(object2, string2);
        object.setBackgroundResource(n10);
        object = this.c.a;
        boolean bl2 = GT3GeetestButton.access$600((GT3GeetestButton)((Object)object));
        if (bl2) {
            object = GT3GeetestButton.access$700(this.c.a);
            object2 = GT3GeetestButton.access$300(this.c.a);
            string2 = "gt3logogray";
            n10 = o.d(object2, string2);
            object.setImageResource(n10);
        }
        object = GT3GeetestButton.access$1300(this.c.a);
        object2 = this.a;
        object.setText((CharSequence)object2);
        object = GT3GeetestButton.access$1300(this.c.a);
        n10 = 0;
        object2 = null;
        object.setVisibility(0);
        object = this.a;
        bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && (bl2 = ((String)(object = this.a)).startsWith(string2 = "_")) && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b)))) {
            object = GT3GeetestButton.access$800(this.c.a);
            string2 = this.b;
            object.setText((CharSequence)string2);
        } else {
            string2 = "";
            object = this.a;
            bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)object);
            if (bl2) {
                object = GT3GeetestButton.access$800(this.c.a);
                string2 = this.b;
                object.setText((CharSequence)string2);
            } else {
                object = GT3GeetestButton.access$800(this.c.a);
                string2 = i.f();
                object.setText((CharSequence)string2);
            }
        }
        GT3GeetestButton.access$1100(this.c.a).setVisibility(0);
        object = GT3GeetestButton.access$1100(this.c.a);
        object2 = i.j();
        object.setText((CharSequence)object2);
        GT3GeetestButton.access$800(this.c.a).setTextColor(-10395295);
        GT3GeetestButton.access$800(this.c.a).setAlpha(1.0f);
        GT3GeetestButton.access$1002(this.c.a, true);
    }
}

