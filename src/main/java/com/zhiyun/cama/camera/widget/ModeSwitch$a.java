/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.HorizontalScrollView
 */
package com.zhiyun.cama.camera.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.zhiyun.cama.camera.widget.ModeSwitch;

public class ModeSwitch$a
implements Runnable {
    public final /* synthetic */ ModeSwitch a;

    public ModeSwitch$a(ModeSwitch modeSwitch) {
        this.a = modeSwitch;
    }

    public void run() {
        int n10 = ModeSwitch.a(this.a);
        int n11 = this.a.getWidth() / 2;
        ModeSwitch modeSwitch = this.a;
        Object object = ModeSwitch.b(modeSwitch);
        Object object2 = ModeSwitch.c(modeSwitch, (ViewGroup)object, n10 += n11);
        if (object2 != null) {
            modeSwitch = ModeSwitch.b(this.a);
            n11 = modeSwitch.indexOfChild((View)object2);
            object = this.a;
            ModeSwitch.d((ModeSwitch)object, (HorizontalScrollView)object, (View)object2);
            ModeSwitch.g(this.a, n11);
            ModeSwitch.h(this.a);
            object2 = ModeSwitch.i(this.a);
            if (object2 != null) {
                object2 = ModeSwitch.i(this.a);
                modeSwitch = this.a;
                n11 = ModeSwitch.f(modeSwitch) + -1;
                object2.a(n11);
            }
        }
    }
}

