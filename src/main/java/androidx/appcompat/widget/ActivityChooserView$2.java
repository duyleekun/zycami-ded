/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ActionProvider;

public class ActivityChooserView$2
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$2(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    public void onGlobalLayout() {
        Object object = this.this$0;
        boolean bl2 = ((ActivityChooserView)object).isShowingPopup();
        if (bl2) {
            object = this.this$0;
            bl2 = object.isShown();
            if (!bl2) {
                object = this.this$0.getListPopupWindow();
                ((ListPopupWindow)object).dismiss();
            } else {
                this.this$0.getListPopupWindow().show();
                object = this.this$0.mProvider;
                if (object != null) {
                    boolean bl3 = true;
                    ((ActionProvider)object).subUiVisibilityChanged(bl3);
                }
            }
        }
    }
}

