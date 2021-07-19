/*
 * Decompiled with CFR 0.151.
 */
package androidx.customview.widget;

import androidx.customview.widget.ViewDragHelper;

public class ViewDragHelper$2
implements Runnable {
    public final /* synthetic */ ViewDragHelper this$0;

    public ViewDragHelper$2(ViewDragHelper viewDragHelper) {
        this.this$0 = viewDragHelper;
    }

    public void run() {
        this.this$0.setDragState(0);
    }
}

