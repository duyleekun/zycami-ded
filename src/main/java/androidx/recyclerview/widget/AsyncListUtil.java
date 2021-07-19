/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseIntArray
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.AsyncListUtil$1;
import androidx.recyclerview.widget.AsyncListUtil$2;
import androidx.recyclerview.widget.AsyncListUtil$DataCallback;
import androidx.recyclerview.widget.AsyncListUtil$ViewCallback;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.ThreadUtil$BackgroundCallback;
import androidx.recyclerview.widget.ThreadUtil$MainThreadCallback;
import androidx.recyclerview.widget.TileList;

public class AsyncListUtil {
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncListUtil";
    public boolean mAllowScrollHints;
    private final ThreadUtil$BackgroundCallback mBackgroundCallback;
    public final ThreadUtil$BackgroundCallback mBackgroundProxy;
    public final AsyncListUtil$DataCallback mDataCallback;
    public int mDisplayedGeneration;
    public int mItemCount;
    private final ThreadUtil$MainThreadCallback mMainThreadCallback;
    public final ThreadUtil$MainThreadCallback mMainThreadProxy;
    public final SparseIntArray mMissingPositions;
    public final int[] mPrevRange;
    public int mRequestedGeneration;
    private int mScrollHint;
    public final Class mTClass;
    public final TileList mTileList;
    public final int mTileSize;
    public final int[] mTmpRange;
    public final int[] mTmpRangeExtended;
    public final AsyncListUtil$ViewCallback mViewCallback;

    public AsyncListUtil(Class object, int n10, AsyncListUtil$DataCallback asyncListUtil$DataCallback, AsyncListUtil$ViewCallback asyncListUtil$ViewCallback) {
        ThreadUtil$MainThreadCallback threadUtil$MainThreadCallback;
        int n11 = 2;
        Object object2 = new int[n11];
        this.mTmpRange = object2;
        object2 = new int[n11];
        this.mPrevRange = object2;
        Object object3 = new int[n11];
        this.mTmpRangeExtended = object3;
        this.mScrollHint = 0;
        this.mItemCount = 0;
        this.mDisplayedGeneration = 0;
        this.mRequestedGeneration = 0;
        object3 = new SparseIntArray;
        this.mMissingPositions = (SparseIntArray)object3;
        object3 = new AsyncListUtil$1;
        super(this);
        this.mMainThreadCallback = object3;
        object2 = new AsyncListUtil$2;
        super(this);
        this.mBackgroundCallback = object2;
        this.mTClass = object;
        this.mTileSize = n10;
        this.mDataCallback = asyncListUtil$DataCallback;
        this.mViewCallback = asyncListUtil$ViewCallback;
        this.mTileList = object = new TileList(n10);
        object = new MessageThreadUtil();
        this.mMainThreadProxy = threadUtil$MainThreadCallback = object.getMainThreadProxy((ThreadUtil$MainThreadCallback)object3);
        this.mBackgroundProxy = object = object.getBackgroundProxy((ThreadUtil$BackgroundCallback)object2);
        this.refresh();
    }

    private boolean isRefreshPending() {
        int n10 = this.mRequestedGeneration;
        int n11 = this.mDisplayedGeneration;
        n10 = n10 != n11 ? 1 : 0;
        return n10 != 0;
    }

    public Object getItem(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.mItemCount)) {
            boolean bl2;
            Object object = this.mTileList.getItemAt(n10);
            if (object == null && !(bl2 = this.isRefreshPending())) {
                SparseIntArray sparseIntArray = this.mMissingPositions;
                sparseIntArray.put(n10, 0);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append(" is not within 0 and ");
        n10 = this.mItemCount;
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public void log(String string2, Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[MAIN] ");
        string2 = String.format(string2, objectArray);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        Log.d((String)TAG, (String)string2);
    }

    public void onRangeChanged() {
        boolean bl2 = this.isRefreshPending();
        if (bl2) {
            return;
        }
        this.updateRange();
        this.mAllowScrollHints = true;
    }

    public void refresh() {
        int n10;
        this.mMissingPositions.clear();
        ThreadUtil$BackgroundCallback threadUtil$BackgroundCallback = this.mBackgroundProxy;
        this.mRequestedGeneration = n10 = this.mRequestedGeneration + 1;
        threadUtil$BackgroundCallback.refresh(n10);
    }

    public void updateRange() {
        Object object = this.mViewCallback;
        int[] nArray = this.mTmpRange;
        ((AsyncListUtil$ViewCallback)object).getItemRangeInto(nArray);
        object = this.mTmpRange;
        nArray = null;
        Object object2 = object[0];
        int n10 = 1;
        Object object3 = object[n10];
        if (object2 <= object3 && (object2 = object[0]) >= 0) {
            Object object4;
            Object object5;
            object2 = object[n10];
            object3 = this.mItemCount;
            if (object2 >= object3) {
                return;
            }
            object2 = this.mAllowScrollHints;
            if (object2 == false) {
                this.mScrollHint = 0;
            } else {
                object2 = object[0];
                object5 = this.mPrevRange;
                object4 = object5[n10];
                if (object2 <= object4 && (object2 = (Object)object5[0]) <= (object4 = (Object)object[n10])) {
                    object2 = object[0];
                    object4 = object5[0];
                    if (object2 < object4) {
                        this.mScrollHint = n10;
                    } else {
                        object2 = object[0];
                        object3 = object5[0];
                        if (object2 > object3) {
                            object2 = 2;
                            this.mScrollHint = (int)object2;
                        }
                    }
                } else {
                    this.mScrollHint = 0;
                }
            }
            Object object6 = this.mPrevRange;
            object3 = object[0];
            object6[0] = (int)object3;
            object3 = object[n10];
            object6[n10] = (int)object3;
            object6 = this.mViewCallback;
            object5 = this.mTmpRangeExtended;
            object4 = this.mScrollHint;
            object6.extendRangeInto((int[])object, (int[])object5, (int)object4);
            object = this.mTmpRangeExtended;
            object2 = this.mTmpRange[0];
            object3 = Math.max((int)object[0], 0);
            object[0] = object2 = (Object)Math.min((int)object2, (int)object3);
            object = this.mTmpRangeExtended;
            object6 = this.mTmpRange;
            object2 = object6[n10];
            object3 = object[n10];
            object4 = this.mItemCount - n10;
            object3 = Math.min((int)object3, object4);
            object[n10] = object2 = (Object)Math.max((int)object2, (int)object3);
            object5 = this.mBackgroundProxy;
            object = this.mTmpRange;
            object4 = object[0];
            Object object7 = object[n10];
            object = this.mTmpRangeExtended;
            Object object8 = object[0];
            Object object9 = object[n10];
            int n11 = this.mScrollHint;
            object5.updateRange((int)object4, (int)object7, (int)object8, (int)object9, n11);
        }
    }
}

