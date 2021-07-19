/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper;

public class DragStartHelper$2
implements View.OnTouchListener {
    public final /* synthetic */ DragStartHelper this$0;

    public DragStartHelper$2(DragStartHelper dragStartHelper) {
        this.this$0 = dragStartHelper;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.this$0.onTouch(view, motionEvent);
    }
}

