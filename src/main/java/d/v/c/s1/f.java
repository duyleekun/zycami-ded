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

public final class f
implements View.OnTouchListener {
    public static final /* synthetic */ f a;

    static {
        f f10;
        a = f10 = new f();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return EditorSpeedFragment.y0(view, motionEvent);
    }
}

