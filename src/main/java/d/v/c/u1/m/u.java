/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.u1.m;

import android.widget.PopupWindow;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;

public final class u
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ EditorTemplateEditActivity a;

    public /* synthetic */ u(EditorTemplateEditActivity editorTemplateEditActivity) {
        this.a = editorTemplateEditActivity;
    }

    public final void onDismiss() {
        EditorTemplateEditActivity.w(this.a);
    }
}

