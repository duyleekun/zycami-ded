/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

public class ToolbarWidgetWrapper$2
extends ViewPropertyAnimatorListenerAdapter {
    private boolean mCanceled = false;
    public final /* synthetic */ ToolbarWidgetWrapper this$0;
    public final /* synthetic */ int val$visibility;

    public ToolbarWidgetWrapper$2(ToolbarWidgetWrapper toolbarWidgetWrapper, int n10) {
        this.this$0 = toolbarWidgetWrapper;
        this.val$visibility = n10;
    }

    public void onAnimationCancel(View view) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(View object) {
        boolean bl2 = this.mCanceled;
        if (!bl2) {
            object = this.this$0.mToolbar;
            int n10 = this.val$visibility;
            object.setVisibility(n10);
        }
    }

    public void onAnimationStart(View view) {
        this.this$0.mToolbar.setVisibility(0);
    }
}

