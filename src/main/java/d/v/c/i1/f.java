/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.i1;

import android.widget.PopupWindow;
import com.zhiyun.cama.main.EditorMainActivity;

public final class f
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ EditorMainActivity a;
    public final /* synthetic */ int b;

    public /* synthetic */ f(EditorMainActivity editorMainActivity, int n10) {
        this.a = editorMainActivity;
        this.b = n10;
    }

    public final void onDismiss() {
        EditorMainActivity editorMainActivity = this.a;
        int n10 = this.b;
        editorMainActivity.z(n10);
    }
}

