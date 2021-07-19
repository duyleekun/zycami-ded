/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 */
package d.v.c.i1;

import android.view.View;
import com.zhiyun.cama.main.EditorMainFragment;

public final class e0
implements View.OnScrollChangeListener {
    public final /* synthetic */ EditorMainFragment a;

    public /* synthetic */ e0(EditorMainFragment editorMainFragment) {
        this.a = editorMainFragment;
    }

    public final void onScrollChange(View view, int n10, int n11, int n12, int n13) {
        this.a.a1(view, n10, n11, n12, n13);
    }
}

