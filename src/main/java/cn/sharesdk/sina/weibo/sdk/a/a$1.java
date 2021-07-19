/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package cn.sharesdk.sina.weibo.sdk.a;

import android.view.MotionEvent;
import android.view.View;
import cn.sharesdk.sina.weibo.sdk.a.a;

public class a$1
implements View.OnTouchListener {
    public final /* synthetic */ a a;

    public a$1(a a10) {
        this.a = a10;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        if (n10 == 0) {
            int n11 = -1;
            view.setBackgroundColor(n11);
        } else {
            int n12 = motionEvent.getAction();
            if (n12 == (n10 = 1)) {
                n12 = -131587;
                view.setBackgroundColor(n12);
            }
        }
        return false;
    }
}

