/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.s1;

import android.widget.PopupWindow;
import com.zhiyun.cama.speed.EditorSpeedFragment;

public final class h
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ EditorSpeedFragment a;

    public /* synthetic */ h(EditorSpeedFragment editorSpeedFragment) {
        this.a = editorSpeedFragment;
    }

    public final void onDismiss() {
        this.a.q0();
    }
}

