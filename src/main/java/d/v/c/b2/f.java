/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 */
package d.v.c.b2;

import android.view.View;
import com.zhiyun.cama.widget.EditorHorizontalScrollView;

public final class f
implements View.OnScrollChangeListener {
    public final /* synthetic */ EditorHorizontalScrollView a;

    public /* synthetic */ f(EditorHorizontalScrollView editorHorizontalScrollView) {
        this.a = editorHorizontalScrollView;
    }

    public final void onScrollChange(View view, int n10, int n11, int n12, int n13) {
        this.a.e(view, n10, n11, n12, n13);
    }
}

