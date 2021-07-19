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

public final class l
implements View.OnTouchListener {
    public static final /* synthetic */ l a;

    static {
        l l10;
        a = l10 = new l();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return EditorSpeedFragment.t0(view, motionEvent);
    }
}

