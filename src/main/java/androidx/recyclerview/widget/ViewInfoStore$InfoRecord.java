/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo;

public class ViewInfoStore$InfoRecord {
    public static final int FLAG_APPEAR = 2;
    public static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
    public static final int FLAG_APPEAR_PRE_AND_POST = 14;
    public static final int FLAG_DISAPPEARED = 1;
    public static final int FLAG_POST = 8;
    public static final int FLAG_PRE = 4;
    public static final int FLAG_PRE_AND_POST = 12;
    public static Pools$Pool sPool;
    public int flags;
    public RecyclerView$ItemAnimator$ItemHolderInfo postInfo;
    public RecyclerView$ItemAnimator$ItemHolderInfo preInfo;

    static {
        Pools$SimplePool pools$SimplePool = new Pools$SimplePool(20);
        sPool = pools$SimplePool;
    }

    private ViewInfoStore$InfoRecord() {
    }

    public static void drainCache() {
        Object object;
        while ((object = sPool.acquire()) != null) {
        }
    }

    public static ViewInfoStore$InfoRecord obtain() {
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord)sPool.acquire();
        if (viewInfoStore$InfoRecord == null) {
            viewInfoStore$InfoRecord = new ViewInfoStore$InfoRecord();
        }
        return viewInfoStore$InfoRecord;
    }

    public static void recycle(ViewInfoStore$InfoRecord viewInfoStore$InfoRecord) {
        viewInfoStore$InfoRecord.flags = 0;
        viewInfoStore$InfoRecord.preInfo = null;
        viewInfoStore$InfoRecord.postInfo = null;
        sPool.release(viewInfoStore$InfoRecord);
    }
}

