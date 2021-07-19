/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.widget.PopupWindow
 */
package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ListPopupWindow;

public class ListPopupWindow$PopupTouchInterceptor
implements View.OnTouchListener {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$PopupTouchInterceptor(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public boolean onTouch(View object, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        int n10;
        PopupWindow popupWindow2;
        int n11 = motionEvent.getAction();
        float f10 = motionEvent.getX();
        int n12 = (int)f10;
        float f11 = motionEvent.getY();
        int n13 = (int)f11;
        if (n11 == 0 && (popupWindow2 = this.this$0.mPopup) != null && (n10 = popupWindow2.isShowing()) != 0 && n12 >= 0 && n12 < (n10 = (popupWindow2 = this.this$0.mPopup).getWidth()) && n13 >= 0 && n13 < (n12 = (popupWindow = this.this$0.mPopup).getHeight())) {
            object = this.this$0;
            motionEvent = object.mHandler;
            object = object.mResizePopupRunnable;
            long l10 = 250L;
            motionEvent.postDelayed((Runnable)object, l10);
        } else {
            n13 = 1;
            f11 = Float.MIN_VALUE;
            if (n11 == n13) {
                object = this.this$0;
                motionEvent = object.mHandler;
                object = object.mResizePopupRunnable;
                motionEvent.removeCallbacks((Runnable)object);
            }
        }
        return false;
    }
}

