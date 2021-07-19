/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 */
package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnItemTouchListener;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class ItemTouchHelper$2
implements RecyclerView$OnItemTouchListener {
    public final /* synthetic */ ItemTouchHelper this$0;

    public ItemTouchHelper$2(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    public boolean onInterceptTouchEvent(RecyclerView object, MotionEvent motionEvent) {
        object = this.this$0.mGestureDetector;
        ((GestureDetectorCompat)object).onTouchEvent(motionEvent);
        int n10 = motionEvent.getActionMasked();
        int n11 = 1;
        if (n10 == 0) {
            float f10;
            int n12;
            object = this.this$0;
            ((ItemTouchHelper)object).mActivePointerId = n12 = motionEvent.getPointerId(0);
            object = this.this$0;
            ((ItemTouchHelper)object).mInitialTouchX = f10 = motionEvent.getX();
            object = this.this$0;
            ((ItemTouchHelper)object).mInitialTouchY = f10 = motionEvent.getY();
            this.this$0.obtainVelocityTracker();
            object = this.this$0;
            Object object2 = ((ItemTouchHelper)object).mSelected;
            if (object2 == null && (object = ((ItemTouchHelper)object).findAnimation(motionEvent)) != null) {
                object2 = this.this$0;
                float f11 = ((ItemTouchHelper)object2).mInitialTouchX;
                float f12 = ((ItemTouchHelper$RecoverAnimation)object).mX;
                ((ItemTouchHelper)object2).mInitialTouchX = f11 -= f12;
                f11 = ((ItemTouchHelper)object2).mInitialTouchY;
                f12 = ((ItemTouchHelper$RecoverAnimation)object).mY;
                ((ItemTouchHelper)object2).mInitialTouchY = f11 -= f12;
                Object object3 = ((ItemTouchHelper$RecoverAnimation)object).mViewHolder;
                ((ItemTouchHelper)object2).endRecoverAnimation((RecyclerView$ViewHolder)object3, n11 != 0);
                object2 = this.this$0.mPendingCleanup;
                object3 = object.mViewHolder.itemView;
                n12 = (int)(object2.remove(object3) ? 1 : 0);
                if (n12 != 0) {
                    object2 = this.this$0;
                    object3 = ((ItemTouchHelper)object2).mCallback;
                    object2 = ((ItemTouchHelper)object2).mRecyclerView;
                    RecyclerView$ViewHolder recyclerView$ViewHolder = ((ItemTouchHelper$RecoverAnimation)object).mViewHolder;
                    ((ItemTouchHelper$Callback)object3).clearView((RecyclerView)object2, recyclerView$ViewHolder);
                }
                object2 = this.this$0;
                object3 = ((ItemTouchHelper$RecoverAnimation)object).mViewHolder;
                n10 = ((ItemTouchHelper$RecoverAnimation)object).mActionState;
                ((ItemTouchHelper)object2).select((RecyclerView$ViewHolder)object3, n10);
                object = this.this$0;
                n12 = ((ItemTouchHelper)object).mSelectedFlags;
                ((ItemTouchHelper)object).updateDxDy(motionEvent, n12, 0);
            }
        } else {
            int n13 = 3;
            float f13 = 4.2E-45f;
            int n14 = -1;
            float f14 = 0.0f / 0.0f;
            if (n10 != n13 && n10 != n11) {
                ItemTouchHelper itemTouchHelper = this.this$0;
                n13 = itemTouchHelper.mActivePointerId;
                if (n13 != n14 && (n13 = motionEvent.findPointerIndex(n13)) >= 0) {
                    ItemTouchHelper itemTouchHelper2 = this.this$0;
                    itemTouchHelper2.checkSelectForSwipe(n10, motionEvent, n13);
                }
            } else {
                object = this.this$0;
                ((ItemTouchHelper)object).mActivePointerId = n14;
                n13 = 0;
                f13 = 0.0f;
                Object var7_11 = null;
                ((ItemTouchHelper)object).select(null, 0);
            }
        }
        if ((object = this.this$0.mVelocityTracker) != null) {
            object.addMovement(motionEvent);
        }
        if ((object = this.this$0.mSelected) == null) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean bl2) {
        if (!bl2) {
            return;
        }
        this.this$0.select(null, 0);
    }

    public void onTouchEvent(RecyclerView object, MotionEvent object2) {
        block11: {
            int n10;
            block8: {
                RecyclerView$ViewHolder recyclerView$ViewHolder;
                ItemTouchHelper itemTouchHelper;
                int n11;
                int n12;
                block9: {
                    block10: {
                        this.this$0.mGestureDetector.onTouchEvent((MotionEvent)object2);
                        object = this.this$0.mVelocityTracker;
                        if (object != null) {
                            object.addMovement(object2);
                        }
                        object = this.this$0;
                        n12 = ((ItemTouchHelper)object).mActivePointerId;
                        n10 = -1;
                        if (n12 == n10) {
                            return;
                        }
                        n12 = object2.getActionMasked();
                        ItemTouchHelper itemTouchHelper2 = this.this$0;
                        n11 = itemTouchHelper2.mActivePointerId;
                        if ((n11 = object2.findPointerIndex(n11)) >= 0) {
                            itemTouchHelper = this.this$0;
                            itemTouchHelper.checkSelectForSwipe(n12, (MotionEvent)object2, n11);
                        }
                        itemTouchHelper = this.this$0;
                        recyclerView$ViewHolder = itemTouchHelper.mSelected;
                        if (recyclerView$ViewHolder == null) {
                            return;
                        }
                        int n13 = 0;
                        int n14 = 1;
                        if (n12 == n14) break block8;
                        int n15 = 2;
                        if (n12 == n15) break block9;
                        n11 = 3;
                        if (n12 == n11) break block10;
                        n10 = 6;
                        if (n12 == n10) {
                            n12 = object2.getActionIndex();
                            n10 = object2.getPointerId(n12);
                            itemTouchHelper2 = this.this$0;
                            int n16 = itemTouchHelper2.mActivePointerId;
                            if (n10 == n16) {
                                if (n12 == 0) {
                                    n13 = n14;
                                }
                                itemTouchHelper2.mActivePointerId = n10 = object2.getPointerId(n13);
                                ItemTouchHelper itemTouchHelper3 = this.this$0;
                                n11 = itemTouchHelper3.mSelectedFlags;
                                itemTouchHelper3.updateDxDy((MotionEvent)object2, n11, n12);
                            }
                        }
                        break block11;
                    }
                    object = itemTouchHelper.mVelocityTracker;
                    if (object == null) break block8;
                    object.clear();
                    break block8;
                }
                if (n11 >= 0) {
                    n12 = itemTouchHelper.mSelectedFlags;
                    itemTouchHelper.updateDxDy((MotionEvent)object2, n12, n11);
                    this.this$0.moveIfNecessary(recyclerView$ViewHolder);
                    object = this.this$0;
                    object2 = ((ItemTouchHelper)object).mRecyclerView;
                    object = ((ItemTouchHelper)object).mScrollRunnable;
                    object2.removeCallbacks((Runnable)object);
                    this.this$0.mScrollRunnable.run();
                    object = this.this$0.mRecyclerView;
                    object.invalidate();
                }
                break block11;
            }
            object = this.this$0;
            object2 = null;
            ((ItemTouchHelper)object).select(null, 0);
            object = this.this$0;
            ((ItemTouchHelper)object).mActivePointerId = n10;
        }
    }
}

