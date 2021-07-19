/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.u1.m;

import android.widget.PopupWindow;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;

public final class z
implements PopupWindow.OnDismissListener {
    public static final /* synthetic */ z a;

    static {
        z z10;
        a = z10 = new z();
    }

    public final void onDismiss() {
        EditorTemplateEditActivity.R();
    }
}

