/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.view.View
 *  android.view.View$OnSystemUiVisibilityChangeListener
 *  android.view.Window
 */
package d.v.e.l;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import com.zhiyun.common.util.StatusBarUtil;

public final class e
implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Window c;
    public final /* synthetic */ ColorDrawable d;
    public final /* synthetic */ View e;
    public final /* synthetic */ Context f;

    public /* synthetic */ e(View view, int n10, Window window, ColorDrawable colorDrawable, View view2, Context context) {
        this.a = view;
        this.b = n10;
        this.c = window;
        this.d = colorDrawable;
        this.e = view2;
        this.f = context;
    }

    public final void onSystemUiVisibilityChange(int n10) {
        View view = this.a;
        int n11 = this.b;
        Window window = this.c;
        ColorDrawable colorDrawable = this.d;
        View view2 = this.e;
        Context context = this.f;
        StatusBarUtil.q(view, n11, window, colorDrawable, view2, context, n10);
    }
}

