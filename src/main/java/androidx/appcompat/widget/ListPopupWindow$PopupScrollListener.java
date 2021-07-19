/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 */
package androidx.appcompat.widget;

import android.os.Handler;
import android.widget.AbsListView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.ListPopupWindow$ResizePopupRunnable;

public class ListPopupWindow$PopupScrollListener
implements AbsListView.OnScrollListener {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$PopupScrollListener(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public void onScroll(AbsListView absListView, int n10, int n11, int n12) {
    }

    public void onScrollStateChanged(AbsListView object, int n10) {
        int n11 = 1;
        if (n10 == n11 && (n11 = (int)(((ListPopupWindow)(object = this.this$0)).isInputMethodNotNeeded() ? 1 : 0)) == 0 && (object = this.this$0.mPopup.getContentView()) != null) {
            object = this.this$0;
            Handler handler = ((ListPopupWindow)object).mHandler;
            object = ((ListPopupWindow)object).mResizePopupRunnable;
            handler.removeCallbacks((Runnable)object);
            object = this.this$0.mResizePopupRunnable;
            ((ListPopupWindow$ResizePopupRunnable)object).run();
        }
    }
}

