/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package com.yalantis.ucrop.view;

import android.graphics.RectF;
import com.yalantis.ucrop.view.UCropView;
import d.t.a.f.d;

public class UCropView$b
implements d {
    public final /* synthetic */ UCropView a;

    public UCropView$b(UCropView uCropView) {
        this.a = uCropView;
    }

    public void a(RectF rectF) {
        UCropView.b(this.a).setCropRect(rectF);
    }
}

