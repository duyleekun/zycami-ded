/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.view.View
 *  android.view.animation.Interpolator
 */
package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.widget.ItemTouchHelper$Callback$1;
import androidx.recyclerview.widget.ItemTouchHelper$Callback$2;
import androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation;
import androidx.recyclerview.widget.ItemTouchHelper$ViewDropHandler;
import androidx.recyclerview.widget.ItemTouchUIUtil;
import androidx.recyclerview.widget.ItemTouchUIUtilImpl;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.List;

public abstract class ItemTouchHelper$Callback {
    private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
    public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000L;
    public static final int RELATIVE_DIR_FLAGS = 0x303030;
    private static final Interpolator sDragScrollInterpolator;
    private static final Interpolator sDragViewScrollCapInterpolator;
    private int mCachedMaxScrollSpeed = -1;

    static {
        Object object = new ItemTouchHelper$Callback$1();
        sDragScrollInterpolator = object;
        object = new ItemTouchHelper$Callback$2();
        sDragViewScrollCapInterpolator = object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int convertToRelativeDirection(int n10, int n11) {
        int n12 = 789516;
        int n13 = n10 & n12;
        if (n13 == 0) {
            return n10;
        }
        int n14 = ~n13;
        n10 &= n14;
        if (n11 == 0) {
            n11 = n13 << 2;
            return n10 | n11;
        }
        n11 = n13 << 1;
        n13 = 0xFFF3F3F3 & n11;
        n10 |= n13;
        n11 = (n11 & n12) << 2;
        return n10 | n11;
    }

    public static ItemTouchUIUtil getDefaultUIUtil() {
        return ItemTouchUIUtilImpl.INSTANCE;
    }

    private int getMaxDragScroll(RecyclerView recyclerView) {
        int n10 = this.mCachedMaxScrollSpeed;
        int n11 = -1;
        if (n10 == n11) {
            int n12;
            recyclerView = recyclerView.getResources();
            n10 = R$dimen.item_touch_helper_max_drag_scroll_per_frame;
            this.mCachedMaxScrollSpeed = n12 = recyclerView.getDimensionPixelSize(n10);
        }
        return this.mCachedMaxScrollSpeed;
    }

    public static int makeFlag(int n10, int n11) {
        return n11 << (n10 *= 8);
    }

    public static int makeMovementFlags(int n10, int n11) {
        int n12 = n11 | n10;
        n12 = ItemTouchHelper$Callback.makeFlag(0, n12);
        n11 = ItemTouchHelper$Callback.makeFlag(1, n11) | n12;
        return ItemTouchHelper$Callback.makeFlag(2, n10) | n11;
    }

    public boolean canDropOver(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        return true;
    }

    public RecyclerView$ViewHolder chooseDropTarget(RecyclerView$ViewHolder recyclerView$ViewHolder, List list, int n10, int n11) {
        RecyclerView$ViewHolder recyclerView$ViewHolder2 = recyclerView$ViewHolder;
        View view = recyclerView$ViewHolder.itemView;
        int n12 = view.getWidth();
        n12 = n10 + n12;
        View view2 = recyclerView$ViewHolder.itemView;
        int n13 = view2.getHeight();
        n13 = n11 + n13;
        View view3 = recyclerView$ViewHolder.itemView;
        int n14 = view3.getLeft();
        n14 = n10 - n14;
        View view4 = recyclerView$ViewHolder.itemView;
        int n15 = view4.getTop();
        n15 = n11 - n15;
        int n16 = list.size();
        RecyclerView$ViewHolder recyclerView$ViewHolder3 = null;
        int n17 = -1;
        for (int i10 = 0; i10 < n16; ++i10) {
            View view5;
            int n18;
            View view6;
            int n19;
            View view7;
            int n20;
            RecyclerView$ViewHolder recyclerView$ViewHolder4 = (RecyclerView$ViewHolder)list.get(i10);
            if (n14 > 0 && (n20 = (view7 = recyclerView$ViewHolder4.itemView).getRight() - n12) < 0 && (n19 = (view6 = recyclerView$ViewHolder4.itemView).getRight()) > (n18 = (view5 = recyclerView$ViewHolder2.itemView).getRight()) && (n20 = Math.abs(n20)) > n17) {
                recyclerView$ViewHolder3 = recyclerView$ViewHolder4;
                n17 = n20;
            }
            if (n14 < 0 && (n20 = (view7 = recyclerView$ViewHolder4.itemView).getLeft() - n10) > 0 && (n19 = (view6 = recyclerView$ViewHolder4.itemView).getLeft()) < (n18 = (view5 = recyclerView$ViewHolder2.itemView).getLeft()) && (n20 = Math.abs(n20)) > n17) {
                recyclerView$ViewHolder3 = recyclerView$ViewHolder4;
                n17 = n20;
            }
            if (n15 < 0 && (n20 = (view7 = recyclerView$ViewHolder4.itemView).getTop() - n11) > 0 && (n19 = (view6 = recyclerView$ViewHolder4.itemView).getTop()) < (n18 = (view5 = recyclerView$ViewHolder2.itemView).getTop()) && (n20 = Math.abs(n20)) > n17) {
                recyclerView$ViewHolder3 = recyclerView$ViewHolder4;
                n17 = n20;
            }
            if (n15 <= 0 || (n20 = (view7 = recyclerView$ViewHolder4.itemView).getBottom() - n13) >= 0 || (n19 = (view6 = recyclerView$ViewHolder4.itemView).getBottom()) <= (n18 = (view5 = recyclerView$ViewHolder2.itemView).getBottom()) || (n20 = Math.abs(n20)) <= n17) continue;
            recyclerView$ViewHolder3 = recyclerView$ViewHolder4;
            n17 = n20;
        }
        return recyclerView$ViewHolder3;
    }

    public void clearView(RecyclerView object, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        object = ItemTouchUIUtilImpl.INSTANCE;
        recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
        object.clearView((View)recyclerView$ViewHolder);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int convertToAbsoluteDirection(int n10, int n11) {
        int n12 = 0x303030;
        int n13 = n10 & n12;
        if (n13 == 0) {
            return n10;
        }
        int n14 = ~n13;
        n10 &= n14;
        if (n11 == 0) {
            n11 = n13 >> 2;
            return n10 | n11;
        }
        n11 = n13 >> 1;
        n13 = 0xFFCFCFCF & n11;
        n10 |= n13;
        n11 = (n11 & n12) >> 2;
        return n10 | n11;
    }

    public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int n10 = this.getMovementFlags(recyclerView, recyclerView$ViewHolder);
        int n11 = ViewCompat.getLayoutDirection((View)recyclerView);
        return this.convertToAbsoluteDirection(n10, n11);
    }

    public long getAnimationDuration(RecyclerView object, int n10, float f10, float f11) {
        object = ((RecyclerView)object).getItemAnimator();
        int n11 = 8;
        if (object == null) {
            long l10 = n10 == n11 ? 200L : 250L;
            return l10;
        }
        long l11 = n10 == n11 ? ((RecyclerView$ItemAnimator)object).getMoveDuration() : ((RecyclerView$ItemAnimator)object).getRemoveDuration();
        return l11;
    }

    public int getBoundingBoxMargin() {
        return 0;
    }

    public float getMoveThreshold(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return 0.5f;
    }

    public abstract int getMovementFlags(RecyclerView var1, RecyclerView$ViewHolder var2);

    public float getSwipeEscapeVelocity(float f10) {
        return f10;
    }

    public float getSwipeThreshold(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return 0.5f;
    }

    public float getSwipeVelocityThreshold(float f10) {
        return f10;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        void var3_7;
        int n10;
        int n11 = this.getAbsoluteMovementFlags(recyclerView, recyclerView$ViewHolder);
        n11 = n11 & (n10 = 0xFF0000);
        if (n11 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            recyclerView = null;
        }
        return (boolean)var3_7;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        void var3_7;
        int n10;
        int n11 = this.getAbsoluteMovementFlags(recyclerView, recyclerView$ViewHolder);
        n11 = n11 & (n10 = 65280);
        if (n11 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            recyclerView = null;
        }
        return (boolean)var3_7;
    }

    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int n10, int n11, int n12, long l10) {
        int n13 = this.getMaxDragScroll(recyclerView);
        n12 = Math.abs(n11);
        float f10 = Math.signum(n11);
        int n14 = (int)f10;
        float f11 = n12;
        float f12 = 1.0f;
        f11 *= f12;
        float f13 = n10;
        f11 /= f13;
        f13 = Math.min(f12, f11);
        float f14 = n14 *= n13;
        Interpolator interpolator2 = sDragViewScrollCapInterpolator;
        f13 = interpolator2.getInterpolation(f13);
        n13 = (int)(f14 *= f13);
        long l11 = 2000L;
        long l12 = l10 - l11;
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n10 <= 0) {
            f13 = l10;
            n12 = 1157234688;
            f11 = 2000.0f;
            f12 = f13 / f11;
        }
        f14 = n13;
        Interpolator interpolator3 = sDragScrollInterpolator;
        f13 = interpolator3.getInterpolation(f12);
        n13 = (int)(f14 *= f13);
        if (n13 == 0) {
            if (n11 > 0) {
                n13 = 1;
                f14 = Float.MIN_VALUE;
            } else {
                n13 = -1;
                f14 = 0.0f / 0.0f;
            }
        }
        return n13;
    }

    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    public boolean isLongPressDragEnabled() {
        return true;
    }

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, float f10, float f11, int n10, boolean bl2) {
        ItemTouchUIUtil itemTouchUIUtil = ItemTouchUIUtilImpl.INSTANCE;
        View view = recyclerView$ViewHolder.itemView;
        itemTouchUIUtil.onDraw(canvas, recyclerView, view, f10, f11, n10, bl2);
    }

    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, float f10, float f11, int n10, boolean bl2) {
        ItemTouchUIUtil itemTouchUIUtil = ItemTouchUIUtilImpl.INSTANCE;
        View view = recyclerView$ViewHolder.itemView;
        itemTouchUIUtil.onDrawOver(canvas, recyclerView, view, f10, f11, n10, bl2);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, List list, int n10, float f10, float f11) {
        boolean bl2;
        int n11;
        float f12;
        float f13;
        RecyclerView$ViewHolder recyclerView$ViewHolder2;
        int n12 = list.size();
        Object object = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            object = (ItemTouchHelper$RecoverAnimation)list.get(i10);
            ((ItemTouchHelper$RecoverAnimation)object).update();
            int n13 = canvas.save();
            recyclerView$ViewHolder2 = ((ItemTouchHelper$RecoverAnimation)object).mViewHolder;
            f13 = ((ItemTouchHelper$RecoverAnimation)object).mX;
            f12 = ((ItemTouchHelper$RecoverAnimation)object).mY;
            n11 = ((ItemTouchHelper$RecoverAnimation)object).mActionState;
            bl2 = false;
            object = this;
            this.onChildDraw(canvas, recyclerView, recyclerView$ViewHolder2, f13, f12, n11, false);
            canvas.restoreToCount(n13);
        }
        if (recyclerView$ViewHolder != null) {
            n12 = canvas.save();
            bl2 = true;
            object = this;
            recyclerView$ViewHolder2 = recyclerView$ViewHolder;
            f13 = f10;
            f12 = f11;
            n11 = n10;
            this.onChildDraw(canvas, recyclerView, recyclerView$ViewHolder, f10, f11, n10, bl2);
            canvas.restoreToCount(n12);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, List list, int n10, float f10, float f11) {
        Object object;
        boolean bl2;
        int n11;
        float f12;
        float f13;
        RecyclerView$ViewHolder recyclerView$ViewHolder2;
        Object object2;
        int n12;
        List list2 = list;
        int n13 = list.size();
        int n14 = 0;
        for (n12 = 0; n12 < n13; ++n12) {
            object2 = (ItemTouchHelper$RecoverAnimation)list2.get(n12);
            int n15 = canvas.save();
            recyclerView$ViewHolder2 = ((ItemTouchHelper$RecoverAnimation)object2).mViewHolder;
            f13 = ((ItemTouchHelper$RecoverAnimation)object2).mX;
            f12 = ((ItemTouchHelper$RecoverAnimation)object2).mY;
            n11 = ((ItemTouchHelper$RecoverAnimation)object2).mActionState;
            bl2 = false;
            object2 = this;
            object = canvas;
            this.onChildDrawOver(canvas, recyclerView, recyclerView$ViewHolder2, f13, f12, n11, false);
            canvas.restoreToCount(n15);
        }
        if (recyclerView$ViewHolder != null) {
            n12 = canvas.save();
            bl2 = true;
            object2 = this;
            object = canvas;
            recyclerView$ViewHolder2 = recyclerView$ViewHolder;
            f13 = f10;
            f12 = f11;
            n11 = n10;
            this.onChildDrawOver(canvas, recyclerView, recyclerView$ViewHolder, f10, f11, n10, bl2);
            canvas.restoreToCount(n12);
        }
        int n16 = 1;
        n13 -= n16;
        while (n13 >= 0) {
            boolean bl3;
            object = (ItemTouchHelper$RecoverAnimation)list2.get(n13);
            boolean bl4 = object.mEnded;
            if (bl4 && !(bl3 = object.mIsPendingCleanup)) {
                list2.remove(n13);
            } else if (!bl4) {
                n14 = n16;
            }
            n13 += -1;
        }
        if (n14 != 0) {
            recyclerView.invalidate();
        }
    }

    public abstract boolean onMove(RecyclerView var1, RecyclerView$ViewHolder var2, RecyclerView$ViewHolder var3);

    public void onMoved(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, RecyclerView$ViewHolder recyclerView$ViewHolder2, int n11, int n12, int n13) {
        boolean bl2;
        Object object = recyclerView.getLayoutManager();
        boolean bl22 = object instanceof ItemTouchHelper$ViewDropHandler;
        if (bl22) {
            object = (ItemTouchHelper$ViewDropHandler)object;
            recyclerView = recyclerView$ViewHolder.itemView;
            recyclerView$ViewHolder = recyclerView$ViewHolder2.itemView;
            object.prepareForDrop((View)recyclerView, (View)recyclerView$ViewHolder, n12, n13);
            return;
        }
        boolean n14 = ((RecyclerView$LayoutManager)object).canScrollHorizontally();
        if (n14) {
            recyclerView$ViewHolder = recyclerView$ViewHolder2.itemView;
            int n15 = ((RecyclerView$LayoutManager)object).getDecoratedLeft((View)recyclerView$ViewHolder);
            if (n15 <= (n12 = recyclerView.getPaddingLeft())) {
                recyclerView.scrollToPosition(n11);
            }
            recyclerView$ViewHolder = recyclerView$ViewHolder2.itemView;
            int n16 = ((RecyclerView$LayoutManager)object).getDecoratedRight((View)recyclerView$ViewHolder);
            n12 = recyclerView.getWidth();
            n13 = recyclerView.getPaddingRight();
            if (n16 >= (n12 -= n13)) {
                recyclerView.scrollToPosition(n11);
            }
        }
        if (bl2 = ((RecyclerView$LayoutManager)object).canScrollVertically()) {
            recyclerView$ViewHolder = recyclerView$ViewHolder2.itemView;
            int n17 = ((RecyclerView$LayoutManager)object).getDecoratedTop((View)recyclerView$ViewHolder);
            if (n17 <= (n12 = recyclerView.getPaddingTop())) {
                recyclerView.scrollToPosition(n11);
            }
            recyclerView$ViewHolder = recyclerView$ViewHolder2.itemView;
            int n18 = ((RecyclerView$LayoutManager)object).getDecoratedBottom((View)recyclerView$ViewHolder);
            n10 = recyclerView.getHeight();
            int n19 = recyclerView.getPaddingBottom();
            if (n18 >= (n10 -= n19)) {
                recyclerView.scrollToPosition(n11);
            }
        }
    }

    public void onSelectedChanged(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        if (recyclerView$ViewHolder != null) {
            ItemTouchUIUtil itemTouchUIUtil = ItemTouchUIUtilImpl.INSTANCE;
            recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
            itemTouchUIUtil.onSelected((View)recyclerView$ViewHolder);
        }
    }

    public abstract void onSwiped(RecyclerView$ViewHolder var1, int var2);
}

