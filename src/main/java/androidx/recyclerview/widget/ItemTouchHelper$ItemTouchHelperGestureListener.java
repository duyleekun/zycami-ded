/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class ItemTouchHelper$ItemTouchHelperGestureListener
extends GestureDetector.SimpleOnGestureListener {
    private boolean mShouldReactToLongPress = true;
    public final /* synthetic */ ItemTouchHelper this$0;

    public ItemTouchHelper$ItemTouchHelperGestureListener(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    public void doNotReactToLongPress() {
        this.mShouldReactToLongPress = false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public void onLongPress(MotionEvent object) {
        Object object2;
        boolean bl2 = this.mShouldReactToLongPress;
        if (!bl2) {
            return;
        }
        Object object3 = this.this$0.findChildView((MotionEvent)object);
        if (object3 != null && (object3 = ((RecyclerView)(object2 = this.this$0.mRecyclerView)).getChildViewHolder((View)object3)) != null) {
            object2 = this.this$0;
            Object object4 = ((ItemTouchHelper)object2).mCallback;
            object2 = ((ItemTouchHelper)object2).mRecyclerView;
            boolean n10 = ((ItemTouchHelper$Callback)object4).hasDragFlag((RecyclerView)object2, (RecyclerView$ViewHolder)object3);
            if (!n10) {
                return;
            }
            object2 = null;
            int n11 = object.getPointerId(0);
            object4 = this.this$0;
            int n12 = ((ItemTouchHelper)object4).mActivePointerId;
            if (n11 == n12) {
                int n13 = object.findPointerIndex(n12);
                float f10 = object.getX(n13);
                float f11 = object.getY(n13);
                object2 = this.this$0;
                ((ItemTouchHelper)object2).mInitialTouchX = f10;
                ((ItemTouchHelper)object2).mInitialTouchY = f11;
                f11 = 0.0f;
                ((ItemTouchHelper)object2).mDy = 0.0f;
                ((ItemTouchHelper)object2).mDx = 0.0f;
                object = ((ItemTouchHelper)object2).mCallback;
                boolean bl3 = ((ItemTouchHelper$Callback)object).isLongPressDragEnabled();
                if (bl3) {
                    object = this.this$0;
                    int n14 = 2;
                    ((ItemTouchHelper)object).select((RecyclerView$ViewHolder)object3, n14);
                }
            }
        }
    }
}

