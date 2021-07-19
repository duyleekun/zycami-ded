/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.DropDownListView;

public class DropDownListView$ResolveHoverRunnable
implements Runnable {
    public final /* synthetic */ DropDownListView this$0;

    public DropDownListView$ResolveHoverRunnable(DropDownListView dropDownListView) {
        this.this$0 = dropDownListView;
    }

    public void cancel() {
        DropDownListView dropDownListView = this.this$0;
        dropDownListView.mResolveHoverRunnable = null;
        dropDownListView.removeCallbacks(this);
    }

    public void post() {
        this.this$0.post(this);
    }

    public void run() {
        DropDownListView dropDownListView = this.this$0;
        dropDownListView.mResolveHoverRunnable = null;
        dropDownListView.drawableStateChanged();
    }
}

