/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.y1.g;

import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.cama.voice.record.EditorRecordFragment;

public final class d
implements View.OnTouchListener {
    public final /* synthetic */ EditorRecordFragment a;

    public /* synthetic */ d(EditorRecordFragment editorRecordFragment) {
        this.a = editorRecordFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.k0(view, motionEvent);
    }
}

