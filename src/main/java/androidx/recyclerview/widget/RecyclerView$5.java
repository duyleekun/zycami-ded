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
import androidx.recyclerview.widget.ChildHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class RecyclerView$5
implements ChildHelper$Callback {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$5(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void addView(View view, int n10) {
        this.this$0.addView(view, n10);
        this.this$0.dispatchChildAttached(view);
    }

    public void attachViewToParent(View object, int n10, ViewGroup.LayoutParams object2) {
        RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(object);
        if (recyclerView$ViewHolder != null) {
            boolean bl2 = recyclerView$ViewHolder.isTmpDetached();
            if (!bl2 && !(bl2 = recyclerView$ViewHolder.shouldIgnore())) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Called attach on a child which is not detached: ");
                charSequence.append(recyclerView$ViewHolder);
                object2 = this.this$0.exceptionLabel();
                charSequence.append((String)object2);
                charSequence = charSequence.toString();
                object = new IllegalArgumentException((String)charSequence);
                throw object;
            }
            recyclerView$ViewHolder.clearTmpDetachFlag();
        }
        RecyclerView.access$000(this.this$0, object, n10, object2);
    }

    public void detachViewFromParent(int n10) {
        Object object = this.getChildAt(n10);
        if (object != null && (object = RecyclerView.getChildViewHolderInt((View)object)) != null) {
            boolean bl2;
            boolean n11 = ((RecyclerView$ViewHolder)object).isTmpDetached();
            if (n11 && !(bl2 = ((RecyclerView$ViewHolder)object).shouldIgnore())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("called detach on an already detached child ");
                stringBuilder.append(object);
                object = this.this$0.exceptionLabel();
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            int n12 = 256;
            ((RecyclerView$ViewHolder)object).addFlags(n12);
        }
        RecyclerView.access$100(this.this$0, n10);
    }

    public View getChildAt(int n10) {
        return this.this$0.getChildAt(n10);
    }

    public int getChildCount() {
        return this.this$0.getChildCount();
    }

    public RecyclerView$ViewHolder getChildViewHolder(View view) {
        return RecyclerView.getChildViewHolderInt(view);
    }

    public int indexOfChild(View view) {
        return this.this$0.indexOfChild(view);
    }

    public void onEnteredHiddenState(View object) {
        if ((object = RecyclerView.getChildViewHolderInt((View)object)) != null) {
            RecyclerView recyclerView = this.this$0;
            ((RecyclerView$ViewHolder)object).onEnteredHiddenState(recyclerView);
        }
    }

    public void onLeftHiddenState(View object) {
        if ((object = RecyclerView.getChildViewHolderInt((View)object)) != null) {
            RecyclerView recyclerView = this.this$0;
            ((RecyclerView$ViewHolder)object).onLeftHiddenState(recyclerView);
        }
    }

    public void removeAllViews() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            RecyclerView recyclerView = this.this$0;
            recyclerView.dispatchChildDetached(view);
            view.clearAnimation();
        }
        this.this$0.removeAllViews();
    }

    public void removeViewAt(int n10) {
        View view = this.this$0.getChildAt(n10);
        if (view != null) {
            RecyclerView recyclerView = this.this$0;
            recyclerView.dispatchChildDetached(view);
            view.clearAnimation();
        }
        this.this$0.removeViewAt(n10);
    }
}

