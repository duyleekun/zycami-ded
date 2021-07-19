/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnSystemUiVisibilityChangeListener
 *  android.view.Window
 *  android.widget.ImageView
 */
package d.v.e.l;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.zhiyun.common.util.StatusBarUtil;

public final class g
implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Window c;
    public final /* synthetic */ ImageView d;
    public final /* synthetic */ Context e;

    public /* synthetic */ g(View view, int n10, Window window, ImageView imageView, Context context) {
        this.a = view;
        this.b = n10;
        this.c = window;
        this.d = imageView;
        this.e = context;
    }

    public final void onSystemUiVisibilityChange(int n10) {
        View view = this.a;
        int n11 = this.b;
        Window window = this.c;
        ImageView imageView = this.d;
        Context context = this.e;
        StatusBarUtil.p(view, n11, window, imageView, context, n10);
    }
}

