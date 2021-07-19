/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.s1;

import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.cama.speed.EditorSpeedFragment;

public final class g
implements View.OnTouchListener {
    public static final /* synthetic */ g a;

    static {
        g g10;
        a = g10 = new g();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return EditorSpeedFragment.j0(view, motionEvent);
    }
}

