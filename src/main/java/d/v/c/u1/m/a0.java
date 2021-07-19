/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 */
package d.v.c.u1.m;

import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;
import d.v.f.f.c;
import d.v.h.e.a;

public final class a0
implements c {
    public final /* synthetic */ EditorTemplateEditActivity a;

    public /* synthetic */ a0(EditorTemplateEditActivity editorTemplateEditActivity) {
        this.a = editorTemplateEditActivity;
    }

    public final boolean a(View view, int n10, Object object, MotionEvent motionEvent) {
        EditorTemplateEditActivity editorTemplateEditActivity = this.a;
        object = (a)object;
        return editorTemplateEditActivity.y(view, n10, (a)object, motionEvent);
    }
}

