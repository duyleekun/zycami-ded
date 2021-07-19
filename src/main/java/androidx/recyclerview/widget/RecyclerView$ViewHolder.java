/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public abstract class RecyclerView$ViewHolder {
    public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    public static final int FLAG_BOUND = 1;
    public static final int FLAG_IGNORE = 128;
    public static final int FLAG_INVALID = 4;
    public static final int FLAG_MOVED = 2048;
    public static final int FLAG_NOT_RECYCLABLE = 16;
    public static final int FLAG_REMOVED = 8;
    public static final int FLAG_RETURNED_FROM_SCRAP = 32;
    public static final int FLAG_TMP_DETACHED = 256;
    public static final int FLAG_UPDATE = 2;
    private static final List FULLUPDATE_PAYLOADS = Collections.emptyList();
    public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = 255;
    public final View itemView;
    public RecyclerView$Adapter mBindingAdapter;
    public int mFlags;
    public boolean mInChangeScrap;
    private int mIsRecyclableCount;
    public long mItemId;
    public int mItemViewType;
    public WeakReference mNestedRecyclerView;
    public int mOldPosition;
    public RecyclerView mOwnerRecyclerView;
    public List mPayloads;
    public int mPendingAccessibilityState;
    public int mPosition;
    public int mPreLayoutPosition;
    public RecyclerView$Recycler mScrapContainer;
    public RecyclerView$ViewHolder mShadowedHolder;
    public RecyclerView$ViewHolder mShadowingHolder;
    public List mUnmodifiedPayloads;
    private int mWasImportantForAccessibilityBeforeHidden;

    public RecyclerView$ViewHolder(View object) {
        long l10;
        int n10;
        this.mPosition = n10 = -1;
        this.mOldPosition = n10;
        this.mItemId = l10 = (long)-1;
        this.mItemViewType = n10;
        this.mPreLayoutPosition = n10;
        this.mShadowedHolder = null;
        this.mShadowingHolder = null;
        this.mPayloads = null;
        this.mUnmodifiedPayloads = null;
        this.mIsRecyclableCount = 0;
        this.mScrapContainer = null;
        this.mInChangeScrap = false;
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        this.mPendingAccessibilityState = n10;
        if (object != null) {
            this.itemView = object;
            return;
        }
        super("itemView may not be null");
        throw object;
    }

    private void createPayloadsIfNeeded() {
        List list = this.mPayloads;
        if (list == null) {
            this.mPayloads = list = new List();
            this.mUnmodifiedPayloads = list = Collections.unmodifiableList(list);
        }
    }

    public void addChangePayload(Object object) {
        int n10 = 1024;
        if (object == null) {
            this.addFlags(n10);
        } else {
            int n11 = this.mFlags;
            if ((n10 &= n11) == 0) {
                this.createPayloadsIfNeeded();
                List list = this.mPayloads;
                list.add(object);
            }
        }
    }

    public void addFlags(int n10) {
        int n11 = this.mFlags;
        this.mFlags = n10 |= n11;
    }

    public void clearOldPosition() {
        int n10;
        this.mOldPosition = n10 = -1;
        this.mPreLayoutPosition = n10;
    }

    public void clearPayload() {
        int n10;
        List list = this.mPayloads;
        if (list != null) {
            list.clear();
        }
        this.mFlags = n10 = this.mFlags & 0xFFFFFBFF;
    }

    public void clearReturnedFromScrapFlag() {
        int n10;
        this.mFlags = n10 = this.mFlags & 0xFFFFFFDF;
    }

    public void clearTmpDetachFlag() {
        int n10;
        this.mFlags = n10 = this.mFlags & 0xFFFFFEFF;
    }

    public boolean doesTransientStatePreventRecycling() {
        View view;
        int n10 = this.mFlags & 0x10;
        if (!n10 && (n10 = (int)(ViewCompat.hasTransientState(view = this.itemView) ? 1 : 0))) {
            n10 = 1;
        } else {
            n10 = 0;
            view = null;
        }
        return n10 != 0;
    }

    public void flagRemovedAndOffsetPosition(int n10, int n11, boolean bl2) {
        this.addFlags(8);
        this.offsetPosition(n11, bl2);
        this.mPosition = n10;
    }

    public final int getAbsoluteAdapterPosition() {
        RecyclerView recyclerView = this.mOwnerRecyclerView;
        if (recyclerView == null) {
            return -1;
        }
        return recyclerView.getAdapterPositionInRecyclerView(this);
    }

    public final int getAdapterPosition() {
        return this.getBindingAdapterPosition();
    }

    public final RecyclerView$Adapter getBindingAdapter() {
        return this.mBindingAdapter;
    }

    public final int getBindingAdapterPosition() {
        Object object = this.mBindingAdapter;
        int n10 = -1;
        if (object == null) {
            return n10;
        }
        object = this.mOwnerRecyclerView;
        if (object == null) {
            return n10;
        }
        if ((object = ((RecyclerView)object).getAdapter()) == null) {
            return n10;
        }
        RecyclerView recyclerView = this.mOwnerRecyclerView;
        int n11 = recyclerView.getAdapterPositionInRecyclerView(this);
        if (n11 == n10) {
            return n10;
        }
        RecyclerView$Adapter recyclerView$Adapter = this.mBindingAdapter;
        return ((RecyclerView$Adapter)object).findRelativeAdapterPositionIn(recyclerView$Adapter, this, n11);
    }

    public final long getItemId() {
        return this.mItemId;
    }

    public final int getItemViewType() {
        return this.mItemViewType;
    }

    public final int getLayoutPosition() {
        int n10 = this.mPreLayoutPosition;
        int n11 = -1;
        if (n10 == n11) {
            n10 = this.mPosition;
        }
        return n10;
    }

    public final int getOldPosition() {
        return this.mOldPosition;
    }

    public final int getPosition() {
        int n10 = this.mPreLayoutPosition;
        int n11 = -1;
        if (n10 == n11) {
            n10 = this.mPosition;
        }
        return n10;
    }

    public List getUnmodifiedPayloads() {
        int n10 = this.mFlags & 0x400;
        if (n10 == 0) {
            List list = this.mPayloads;
            if (list != null && (n10 = list.size()) != 0) {
                return this.mUnmodifiedPayloads;
            }
            return FULLUPDATE_PAYLOADS;
        }
        return FULLUPDATE_PAYLOADS;
    }

    public boolean hasAnyOfTheFlags(int n10) {
        int n11 = this.mFlags;
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isAdapterPositionUnknown() {
        int n10 = this.mFlags & 0x200;
        n10 = !n10 && !(n10 = (int)(this.isInvalid() ? 1 : 0)) ? 0 : 1;
        return n10 != 0;
    }

    public boolean isAttachedToTransitionOverlay() {
        boolean bl2;
        RecyclerView recyclerView;
        ViewParent viewParent = this.itemView.getParent();
        if (viewParent != null && (viewParent = this.itemView.getParent()) != (recyclerView = this.mOwnerRecyclerView)) {
            bl2 = true;
        } else {
            bl2 = false;
            viewParent = null;
        }
        return bl2;
    }

    public boolean isBound() {
        int n10 = this.mFlags;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isInvalid() {
        int n10 = this.mFlags & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public final boolean isRecyclable() {
        View view;
        int n10 = this.mFlags & 0x10;
        if (!n10 && !(n10 = (int)(ViewCompat.hasTransientState(view = this.itemView) ? 1 : 0))) {
            n10 = 1;
        } else {
            n10 = 0;
            view = null;
        }
        return n10 != 0;
    }

    public boolean isRemoved() {
        int n10 = this.mFlags & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isScrap() {
        boolean bl2;
        RecyclerView$Recycler recyclerView$Recycler = this.mScrapContainer;
        if (recyclerView$Recycler != null) {
            bl2 = true;
        } else {
            bl2 = false;
            recyclerView$Recycler = null;
        }
        return bl2;
    }

    public boolean isTmpDetached() {
        int n10 = this.mFlags & 0x100;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isUpdated() {
        int n10 = this.mFlags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean needsUpdate() {
        int n10 = this.mFlags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void offsetPosition(int n10, boolean bl2) {
        int n11;
        int n12 = this.mOldPosition;
        int n13 = -1;
        if (n12 == n13) {
            this.mOldPosition = n12 = this.mPosition;
        }
        if ((n12 = this.mPreLayoutPosition) == n13) {
            this.mPreLayoutPosition = n12 = this.mPosition;
        }
        if (bl2) {
            int n14;
            this.mPreLayoutPosition = n14 = this.mPreLayoutPosition + n10;
        }
        this.mPosition = n11 = this.mPosition + n10;
        Object object = this.itemView.getLayoutParams();
        if (object != null) {
            boolean bl3;
            object = (RecyclerView$LayoutParams)this.itemView.getLayoutParams();
            object.mInsetsDirty = bl3 = true;
        }
    }

    public void onEnteredHiddenState(RecyclerView recyclerView) {
        int n10 = this.mPendingAccessibilityState;
        int n11 = -1;
        if (n10 != n11) {
            this.mWasImportantForAccessibilityBeforeHidden = n10;
        } else {
            View view = this.itemView;
            this.mWasImportantForAccessibilityBeforeHidden = n10 = ViewCompat.getImportantForAccessibility(view);
        }
        recyclerView.setChildImportantForAccessibilityInternal(this, 4);
    }

    public void onLeftHiddenState(RecyclerView recyclerView) {
        int n10 = this.mWasImportantForAccessibilityBeforeHidden;
        recyclerView.setChildImportantForAccessibilityInternal(this, n10);
        this.mWasImportantForAccessibilityBeforeHidden = 0;
    }

    public void resetInternal() {
        int n10;
        this.mFlags = 0;
        this.mPosition = n10 = -1;
        this.mOldPosition = n10;
        this.mItemId = -1;
        this.mPreLayoutPosition = n10;
        this.mIsRecyclableCount = 0;
        this.mShadowedHolder = null;
        this.mShadowingHolder = null;
        this.clearPayload();
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        this.mPendingAccessibilityState = n10;
        RecyclerView.clearNestedRecyclerViewIfNotNested(this);
    }

    public void saveOldPosition() {
        int n10 = this.mOldPosition;
        int n11 = -1;
        if (n10 == n11) {
            this.mOldPosition = n10 = this.mPosition;
        }
    }

    public void setFlags(int n10, int n11) {
        int n12 = this.mFlags;
        int n13 = ~n11;
        this.mFlags = n10 = n10 & n11 | (n12 &= n13);
    }

    public final void setIsRecyclable(boolean bl2) {
        int n10 = 1;
        int n11 = this.mIsRecyclableCount;
        n11 = bl2 ? (n11 -= n10) : (n11 += n10);
        this.mIsRecyclableCount = n11;
        if (n11 < 0) {
            boolean bl3 = false;
            this.mIsRecyclableCount = 0;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            String string2 = "View";
            Log.e((String)string2, (String)charSequence);
        } else if (!bl2 && n11 == n10) {
            int n12;
            this.mFlags = n12 = this.mFlags | 0x10;
        } else if (bl2 && n11 == 0) {
            int n13;
            this.mFlags = n13 = this.mFlags & 0xFFFFFFEF;
        }
    }

    public void setScrapContainer(RecyclerView$Recycler recyclerView$Recycler, boolean bl2) {
        this.mScrapContainer = recyclerView$Recycler;
        this.mInChangeScrap = bl2;
    }

    public boolean shouldBeKeptAsChild() {
        int n10 = this.mFlags & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean shouldIgnore() {
        int n10 = this.mFlags & 0x80;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void stopIgnoring() {
        int n10;
        this.mFlags = n10 = this.mFlags & 0xFFFFFF7F;
    }

    public String toString() {
        Class clazz = this.getClass();
        int n10 = clazz.isAnonymousClass();
        clazz = n10 != 0 ? "ViewHolder" : this.getClass().getSimpleName();
        CharSequence charSequence = new StringBuilder();
        charSequence.append((String)((Object)clazz));
        charSequence.append("{");
        clazz = Integer.toHexString(this.hashCode());
        charSequence.append((String)((Object)clazz));
        charSequence.append(" position=");
        n10 = this.mPosition;
        charSequence.append(n10);
        charSequence.append(" id=");
        long l10 = this.mItemId;
        charSequence.append(l10);
        charSequence.append(", oldPos=");
        n10 = this.mOldPosition;
        charSequence.append(n10);
        charSequence.append(", pLpos:");
        n10 = this.mPreLayoutPosition;
        charSequence.append(n10);
        clazz = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder((String)((Object)clazz));
        n10 = (int)(this.isScrap() ? 1 : 0);
        if (n10 != 0) {
            clazz = " scrap ";
            stringBuilder.append((String)((Object)clazz));
            n10 = (int)(this.mInChangeScrap ? 1 : 0);
            clazz = n10 != 0 ? "[changeScrap]" : "[attachedScrap]";
            stringBuilder.append((String)((Object)clazz));
        }
        if ((n10 = (int)(this.isInvalid() ? 1 : 0)) != 0) {
            clazz = " invalid";
            stringBuilder.append((String)((Object)clazz));
        }
        if ((n10 = (int)(this.isBound() ? 1 : 0)) == 0) {
            clazz = " unbound";
            stringBuilder.append((String)((Object)clazz));
        }
        if ((n10 = (int)(this.needsUpdate() ? 1 : 0)) != 0) {
            clazz = " update";
            stringBuilder.append((String)((Object)clazz));
        }
        if ((n10 = (int)(this.isRemoved() ? 1 : 0)) != 0) {
            clazz = " removed";
            stringBuilder.append((String)((Object)clazz));
        }
        if ((n10 = (int)(this.shouldIgnore() ? 1 : 0)) != 0) {
            clazz = " ignored";
            stringBuilder.append((String)((Object)clazz));
        }
        if ((n10 = (int)(this.isTmpDetached() ? 1 : 0)) != 0) {
            clazz = " tmpDetached";
            stringBuilder.append((String)((Object)clazz));
        }
        if ((n10 = (int)(this.isRecyclable() ? 1 : 0)) == 0) {
            clazz = new StringBuilder();
            ((StringBuilder)((Object)clazz)).append(" not recyclable(");
            int n11 = this.mIsRecyclableCount;
            ((StringBuilder)((Object)clazz)).append(n11);
            charSequence = ")";
            ((StringBuilder)((Object)clazz)).append((String)charSequence);
            clazz = ((StringBuilder)((Object)clazz)).toString();
            stringBuilder.append((String)((Object)clazz));
        }
        if ((n10 = (int)(this.isAdapterPositionUnknown() ? 1 : 0)) != 0) {
            clazz = " undefined adapter position";
            stringBuilder.append((String)((Object)clazz));
        }
        if ((clazz = this.itemView.getParent()) == null) {
            clazz = " no parent";
            stringBuilder.append((String)((Object)clazz));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void unScrap() {
        this.mScrapContainer.unscrapView(this);
    }

    public boolean wasReturnedFromScrap() {
        int n10 = this.mFlags & 0x20;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }
}

