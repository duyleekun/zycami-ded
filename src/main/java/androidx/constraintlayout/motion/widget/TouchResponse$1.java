/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.TouchResponse;

public class TouchResponse$1
implements View.OnTouchListener {
    public final /* synthetic */ TouchResponse this$0;

    public TouchResponse$1(TouchResponse touchResponse) {
        this.this$0 = touchResponse;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}

