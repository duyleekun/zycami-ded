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

public final class g
implements View.OnTouchListener {
    public static final /* synthetic */ g a;

    static {
        g g10;
        a = g10 = new g();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return EditorRecordFragment.l0(view, motionEvent);
    }
}

