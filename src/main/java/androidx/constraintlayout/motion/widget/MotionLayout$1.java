/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

public class MotionLayout$1
implements Runnable {
    public final /* synthetic */ MotionLayout this$0;
    public final /* synthetic */ View val$target;

    public MotionLayout$1(MotionLayout motionLayout, View view) {
        this.this$0 = motionLayout;
        this.val$target = view;
    }

    public void run() {
        this.val$target.setNestedScrollingEnabled(true);
    }
}

