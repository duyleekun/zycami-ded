/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.i1;

import android.widget.PopupWindow;
import com.zhiyun.cama.main.EditorMainActivity;

public final class h
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ EditorMainActivity a;

    public /* synthetic */ h(EditorMainActivity editorMainActivity) {
        this.a = editorMainActivity;
    }

    public final void onDismiss() {
        EditorMainActivity.r(this.a);
    }
}

