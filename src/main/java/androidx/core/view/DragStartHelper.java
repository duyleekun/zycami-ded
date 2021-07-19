/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 */
package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper$1;
import androidx.core.view.DragStartHelper$2;
import androidx.core.view.DragStartHelper$OnDragStartListener;
import androidx.core.view.MotionEventCompat;

public class DragStartHelper {
    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final DragStartHelper$OnDragStartListener mListener;
    private final View.OnLongClickListener mLongClickListener;
    private final View.OnTouchListener mTouchListener;
    private final View mView;

    public DragStartHelper(View view, DragStartHelper$OnDragStartListener dragStartHelper$OnDragStartListener) {
        Object object = new DragStartHelper$1(this);
        this.mLongClickListener = object;
        object = new DragStartHelper$2(this);
        this.mTouchListener = object;
        this.mView = view;
        this.mListener = dragStartHelper$OnDragStartListener;
    }

    public void attach() {
        View view = this.mView;
        View.OnLongClickListener onLongClickListener = this.mLongClickListener;
        view.setOnLongClickListener(onLongClickListener);
        view = this.mView;
        onLongClickListener = this.mTouchListener;
        view.setOnTouchListener((View.OnTouchListener)onLongClickListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(Point point) {
        int n10 = this.mLastTouchX;
        int n11 = this.mLastTouchY;
        point.set(n10, n11);
    }

    public boolean onLongClick(View view) {
        return this.mListener.onDragStart(view, this);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        block4: {
            int n10;
            int n11;
            block1: {
                block2: {
                    int n12;
                    int n13;
                    int n14;
                    block3: {
                        float f10 = motionEvent.getX();
                        n11 = (int)f10;
                        float f11 = motionEvent.getY();
                        n10 = (int)f11;
                        n14 = motionEvent.getAction();
                        if (n14 == 0) break block1;
                        n13 = 1;
                        if (n14 == n13) break block2;
                        int n15 = 2;
                        if (n14 == n15) break block3;
                        int n16 = 3;
                        if (n14 == n16) break block2;
                        break block4;
                    }
                    n14 = (int)(MotionEventCompat.isFromSource(motionEvent, 8194) ? 1 : 0);
                    if (n14 != 0 && (n12 = motionEvent.getButtonState() & n13) != 0 && (n12 = (int)(this.mDragging ? 1 : 0)) == 0 && ((n12 = this.mLastTouchX) != n11 || (n12 = this.mLastTouchY) != n10)) {
                        boolean bl2;
                        this.mLastTouchX = n11;
                        this.mLastTouchY = n10;
                        this.mDragging = bl2 = this.mListener.onDragStart(view, this);
                        return bl2;
                    }
                    break block4;
                }
                this.mDragging = false;
                break block4;
            }
            this.mLastTouchX = n11;
            this.mLastTouchY = n10;
        }
        return false;
    }
}

