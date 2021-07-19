/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.widget.ImageView
 */
package com.zhiyun.cama.me.help;

import android.text.TextUtils;
import android.widget.ImageView;
import com.zhiyun.cama.data.database.model.Feedback$Extras;
import com.zhiyun.image.Images;
import d.v.c.n0.c;
import d.v.c.n0.e;
import d.v.c.w0.oe;
import d.v.e.l.h2;

public class FeedbackDetailAddFragment$a
extends c {
    public int a(int n10) {
        return 2131558696;
    }

    public void b(e object, int n10) {
        object = (oe)((e)object).a;
        Object object2 = (String[])this.getItem(n10);
        ((oe)object).B((Feedback$Extras)object2);
        String string2 = object2.getFiles();
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 == 0) {
            object2 = object2.getFiles().trim().split(",");
            ((oe)object).d.setVisibility(0);
            string2 = ((oe)object).a;
            String string3 = object2[0];
            float f10 = 8.0f;
            int n12 = h2.b(f10);
            Images.G((ImageView)string2, string3, n12);
            n11 = ((String[])object2).length;
            int n13 = 1;
            if (n11 > n13) {
                string2 = ((oe)object).c;
                string3 = object2[n13];
                n12 = h2.b(f10);
                Images.G((ImageView)string2, string3, n12);
            }
            if ((n11 = ((String[])object2).length) > (n13 = 2)) {
                object = ((oe)object).b;
                object2 = object2[n13];
                n11 = h2.b(f10);
                Images.G((ImageView)object, object2, n11);
            }
        } else {
            object = ((oe)object).d;
            n10 = 8;
            object.setVisibility(n10);
        }
    }
}

