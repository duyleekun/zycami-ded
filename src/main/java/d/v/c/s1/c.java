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

public final class c
implements View.OnTouchListener {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return EditorSpeedFragment.o0(view, motionEvent);
    }
}

