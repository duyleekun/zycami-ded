/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 */
package com.zhiyun.renderengine.business.display;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.b0.b.a;
import d.v.b0.c.e.c$a;
import d.v.b0.d.d;

public class DisplayRender$f
extends d.v.b0.c.e.d {
    public final /* synthetic */ DisplayRender b;

    public DisplayRender$f(DisplayRender displayRender) {
        this.b = displayRender;
    }

    public void run() {
        boolean bl2;
        d d10 = DisplayRender.w(this.b);
        Object object = d10.p();
        String string2 = ((a)object).a;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)(string2 = this.a.b))) && (bl2 = ((String)(object = ((a)object).a)).equals(string2 = this.a.b))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        if (bl2) {
            object = c$a.a(this.a);
            d10.g((a)object);
            object = this.a.e;
            d10.d((Bitmap)object);
        }
    }
}

