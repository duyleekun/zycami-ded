/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.camera.widget;

import android.view.View;
import com.zhiyun.cama.camera.widget.HintLayout;
import com.zhiyun.cama.camera.widget.HintLayout$b;

public class HintLayout$a {
    public final /* synthetic */ HintLayout a;

    public HintLayout$a(HintLayout hintLayout) {
        this.a = hintLayout;
    }

    public void a(HintLayout$b hintLayout$b, View view) {
        Object object;
        if (hintLayout$b != null && (object = hintLayout$b.d()) != null) {
            object = this.a;
            String string2 = HintLayout$b.a(hintLayout$b);
            ((HintLayout)((Object)object)).d(string2);
            hintLayout$b = hintLayout$b.d();
            hintLayout$b.onClick(view);
        }
    }

    public void b(HintLayout$b hintLayout$b, View view) {
        if (hintLayout$b != null) {
            HintLayout hintLayout = this.a;
            String string2 = HintLayout$b.a(hintLayout$b);
            hintLayout.d(string2);
            hintLayout = hintLayout$b.f();
            if (hintLayout != null) {
                hintLayout$b = hintLayout$b.f();
                hintLayout$b.onClick(view);
            }
        }
    }
}

