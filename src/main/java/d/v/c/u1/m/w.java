/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.u1.m;

import android.widget.PopupWindow;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;

public final class w
implements PopupWindow.OnDismissListener {
    public static final /* synthetic */ w a;

    static {
        w w10;
        a = w10 = new w();
    }

    public final void onDismiss() {
        EditorTemplateEditActivity.Q();
    }
}

