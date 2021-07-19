/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ChildHelper$Bucket;
import androidx.recyclerview.widget.ChildHelper$Callback;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;
import java.util.List;

public class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    public final ChildHelper$Bucket mBucket;
    public final ChildHelper$Callback mCallback;
    public final List mHiddenViews;

    public ChildHelper(ChildHelper$Callback arrayList) {
        this.mCallback = arrayList;
        arrayList = new ArrayList();
        this.mBucket = arrayList;
        this.mHiddenViews = arrayList = new ArrayList();
    }

    private int getOffset(int n10) {
        int n11;
        int n12 = -1;
        if (n10 < 0) {
            return n12;
        }
        ChildHelper$Callback childHelper$Callback = this.mCallback;
        int n13 = childHelper$Callback.getChildCount();
        for (int i10 = n10; i10 < n13; i10 += n11) {
            ChildHelper$Bucket childHelper$Bucket;
            ChildHelper$Bucket childHelper$Bucket2 = this.mBucket;
            n11 = childHelper$Bucket2.countOnesBefore(i10);
            n11 = i10 - n11;
            if ((n11 = n10 - n11) != 0) continue;
            while ((n10 = (int)((childHelper$Bucket = this.mBucket).get(i10) ? 1 : 0)) != 0) {
                ++i10;
            }
            return i10;
        }
        return n12;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        List list = this.mHiddenViews;
        boolean bl2 = list.remove(view);
        if (bl2) {
            this.mCallback.onLeftHiddenState(view);
            return true;
        }
        return false;
    }

    public void addView(View view, int n10, boolean bl2) {
        if (n10 < 0) {
            ChildHelper$Callback childHelper$Callback = this.mCallback;
            n10 = childHelper$Callback.getChildCount();
        } else {
            n10 = this.getOffset(n10);
        }
        ChildHelper$Bucket childHelper$Bucket = this.mBucket;
        childHelper$Bucket.insert(n10, bl2);
        if (bl2) {
            this.hideViewInternal(view);
        }
        this.mCallback.addView(view, n10);
    }

    public void addView(View view, boolean bl2) {
        this.addView(view, -1, bl2);
    }

    public void attachViewToParent(View view, int n10, ViewGroup.LayoutParams layoutParams, boolean bl2) {
        if (n10 < 0) {
            ChildHelper$Callback childHelper$Callback = this.mCallback;
            n10 = childHelper$Callback.getChildCount();
        } else {
            n10 = this.getOffset(n10);
        }
        ChildHelper$Bucket childHelper$Bucket = this.mBucket;
        childHelper$Bucket.insert(n10, bl2);
        if (bl2) {
            this.hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, n10, layoutParams);
    }

    public void detachViewFromParent(int n10) {
        n10 = this.getOffset(n10);
        this.mBucket.remove(n10);
        this.mCallback.detachViewFromParent(n10);
    }

    public View findHiddenNonRemovedView(int n10) {
        List list = this.mHiddenViews;
        int n11 = list.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            boolean bl2;
            View view = (View)this.mHiddenViews.get(i10);
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCallback.getChildViewHolder(view);
            int n12 = recyclerView$ViewHolder.getLayoutPosition();
            if (n12 != n10 || (n12 = (int)(recyclerView$ViewHolder.isInvalid() ? 1 : 0)) != 0 || (bl2 = recyclerView$ViewHolder.isRemoved())) continue;
            return view;
        }
        return null;
    }

    public View getChildAt(int n10) {
        n10 = this.getOffset(n10);
        return this.mCallback.getChildAt(n10);
    }

    public int getChildCount() {
        int n10 = this.mCallback.getChildCount();
        int n11 = this.mHiddenViews.size();
        return n10 - n11;
    }

    public View getUnfilteredChildAt(int n10) {
        return this.mCallback.getChildAt(n10);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View object) {
        Object object2 = this.mCallback;
        int n10 = object2.indexOfChild((View)object);
        if (n10 >= 0) {
            this.mBucket.set(n10);
            this.hideViewInternal((View)object);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view is not a child, cannot hide ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public int indexOfChild(View view) {
        int n10;
        ChildHelper$Callback childHelper$Callback = this.mCallback;
        int n11 = childHelper$Callback.indexOfChild(view);
        if (n11 == (n10 = -1)) {
            return n10;
        }
        ChildHelper$Bucket childHelper$Bucket = this.mBucket;
        boolean bl2 = childHelper$Bucket.get(n11);
        if (bl2) {
            return n10;
        }
        n10 = this.mBucket.countOnesBefore(n11);
        return n11 - n10;
    }

    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        List list = this.mHiddenViews;
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            Object object = this.mCallback;
            View view = (View)this.mHiddenViews.get(i10);
            object.onLeftHiddenState(view);
            object = this.mHiddenViews;
            object.remove(i10);
        }
        this.mCallback.removeAllViews();
    }

    public void removeView(View view) {
        ChildHelper$Callback childHelper$Callback = this.mCallback;
        int n10 = childHelper$Callback.indexOfChild(view);
        if (n10 < 0) {
            return;
        }
        ChildHelper$Bucket childHelper$Bucket = this.mBucket;
        boolean bl2 = childHelper$Bucket.remove(n10);
        if (bl2) {
            this.unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(n10);
    }

    public void removeViewAt(int n10) {
        View view = this.mCallback.getChildAt(n10 = this.getOffset(n10));
        if (view == null) {
            return;
        }
        ChildHelper$Bucket childHelper$Bucket = this.mBucket;
        boolean bl2 = childHelper$Bucket.remove(n10);
        if (bl2) {
            this.unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(n10);
    }

    public boolean removeViewIfHidden(View view) {
        ChildHelper$Callback childHelper$Callback = this.mCallback;
        int n10 = childHelper$Callback.indexOfChild(view);
        boolean bl2 = true;
        int n11 = -1;
        if (n10 == n11) {
            this.unhideViewInternal(view);
            return bl2;
        }
        ChildHelper$Bucket childHelper$Bucket = this.mBucket;
        n11 = (int)(childHelper$Bucket.get(n10) ? 1 : 0);
        if (n11 != 0) {
            this.mBucket.remove(n10);
            this.unhideViewInternal(view);
            this.mCallback.removeViewAt(n10);
            return bl2;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.mBucket.toString();
        stringBuilder.append(string2);
        stringBuilder.append(", hidden list:");
        int n10 = this.mHiddenViews.size();
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public void unhide(View object) {
        Object object2 = this.mCallback;
        int n10 = object2.indexOfChild((View)object);
        if (n10 >= 0) {
            Object object3 = this.mBucket;
            boolean bl2 = ((ChildHelper$Bucket)object3).get(n10);
            if (bl2) {
                this.mBucket.clear(n10);
                this.unhideViewInternal((View)object);
                return;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("trying to unhide a view that was not hidden");
            ((StringBuilder)object3).append(object);
            object = ((StringBuilder)object3).toString();
            object2 = new RuntimeException((String)object);
            throw object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view is not a child, cannot hide ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }
}

