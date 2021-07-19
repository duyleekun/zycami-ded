/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.ViewInfoStore$InfoRecord;
import androidx.recyclerview.widget.ViewInfoStore$ProcessCallback;

public class ViewInfoStore {
    private static final boolean DEBUG = false;
    public final SimpleArrayMap mLayoutHolderMap;
    public final LongSparseArray mOldChangedHolders;

    public ViewInfoStore() {
        Object object = new SimpleArrayMap();
        this.mLayoutHolderMap = object;
        this.mOldChangedHolders = object = new LongSparseArray();
    }

    private RecyclerView$ItemAnimator$ItemHolderInfo popFromLayoutStep(RecyclerView$ViewHolder object, int n10) {
        block5: {
            block8: {
                RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo;
                ViewInfoStore$InfoRecord viewInfoStore$InfoRecord;
                SimpleArrayMap simpleArrayMap;
                int n11;
                block7: {
                    int n12;
                    block6: {
                        int n13;
                        n11 = this.mLayoutHolderMap.indexOfKey(object);
                        int n14 = 0;
                        simpleArrayMap = null;
                        if (n11 < 0) {
                            return null;
                        }
                        viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.valueAt(n11);
                        if (viewInfoStore$InfoRecord == null || (n13 = (n12 = viewInfoStore$InfoRecord.flags) & n10) == 0) break block5;
                        viewInfoStore$InfoRecord.flags = n14 = ~n10 & n12;
                        n12 = 4;
                        if (n10 != n12) break block6;
                        recyclerView$ItemAnimator$ItemHolderInfo = viewInfoStore$InfoRecord.preInfo;
                        break block7;
                    }
                    n12 = 8;
                    if (n10 != n12) break block8;
                    recyclerView$ItemAnimator$ItemHolderInfo = viewInfoStore$InfoRecord.postInfo;
                }
                if ((n14 &= 0xC) == 0) {
                    simpleArrayMap = this.mLayoutHolderMap;
                    simpleArrayMap.removeAt(n11);
                    ViewInfoStore$InfoRecord.recycle(viewInfoStore$InfoRecord);
                }
                return recyclerView$ItemAnimator$ItemHolderInfo;
            }
            object = new IllegalArgumentException("Must provide flag PRE or POST");
            throw object;
        }
        return null;
    }

    public void addToAppearedInPreLayoutHolders(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        int n10;
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecord == null) {
            viewInfoStore$InfoRecord = ViewInfoStore$InfoRecord.obtain();
            SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
            simpleArrayMap.put(recyclerView$ViewHolder, viewInfoStore$InfoRecord);
        }
        viewInfoStore$InfoRecord.flags = n10 = viewInfoStore$InfoRecord.flags | 2;
        viewInfoStore$InfoRecord.preInfo = recyclerView$ItemAnimator$ItemHolderInfo;
    }

    public void addToDisappearedInLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int n10;
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecord == null) {
            viewInfoStore$InfoRecord = ViewInfoStore$InfoRecord.obtain();
            SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
            simpleArrayMap.put(recyclerView$ViewHolder, viewInfoStore$InfoRecord);
        }
        viewInfoStore$InfoRecord.flags = n10 = viewInfoStore$InfoRecord.flags | 1;
    }

    public void addToOldChangeHolders(long l10, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.mOldChangedHolders.put(l10, recyclerView$ViewHolder);
    }

    public void addToPostLayout(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        int n10;
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecord == null) {
            viewInfoStore$InfoRecord = ViewInfoStore$InfoRecord.obtain();
            SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
            simpleArrayMap.put(recyclerView$ViewHolder, viewInfoStore$InfoRecord);
        }
        viewInfoStore$InfoRecord.postInfo = recyclerView$ItemAnimator$ItemHolderInfo;
        viewInfoStore$InfoRecord.flags = n10 = viewInfoStore$InfoRecord.flags | 8;
    }

    public void addToPreLayout(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        int n10;
        ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (viewInfoStore$InfoRecord == null) {
            viewInfoStore$InfoRecord = ViewInfoStore$InfoRecord.obtain();
            SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
            simpleArrayMap.put(recyclerView$ViewHolder, viewInfoStore$InfoRecord);
        }
        viewInfoStore$InfoRecord.preInfo = recyclerView$ItemAnimator$ItemHolderInfo;
        viewInfoStore$InfoRecord.flags = n10 = viewInfoStore$InfoRecord.flags | 4;
    }

    public void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    public RecyclerView$ViewHolder getFromOldChangeHolders(long l10) {
        return (RecyclerView$ViewHolder)this.mOldChangedHolders.get(l10);
    }

    public boolean isDisappearing(RecyclerView$ViewHolder object) {
        int n10;
        SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
        object = (ViewInfoStore$InfoRecord)simpleArrayMap.get(object);
        int n11 = 1;
        if (object == null || (n10 = ((ViewInfoStore$InfoRecord)object).flags & n11) == 0) {
            n11 = 0;
            simpleArrayMap = null;
        }
        return n11 != 0;
    }

    public boolean isInPreLayout(RecyclerView$ViewHolder object) {
        boolean bl2;
        SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
        if ((object = (ViewInfoStore$InfoRecord)simpleArrayMap.get(object)) != null && (bl2 = ((ViewInfoStore$InfoRecord)object).flags & 4)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void onDetach() {
        ViewInfoStore$InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.removeFromDisappearedInLayout(recyclerView$ViewHolder);
    }

    public RecyclerView$ItemAnimator$ItemHolderInfo popFromPostLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.popFromLayoutStep(recyclerView$ViewHolder, 8);
    }

    public RecyclerView$ItemAnimator$ItemHolderInfo popFromPreLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return this.popFromLayoutStep(recyclerView$ViewHolder, 4);
    }

    public void process(ViewInfoStore$ProcessCallback viewInfoStore$ProcessCallback) {
        SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
        for (int i10 = simpleArrayMap.size() + -1; i10 >= 0; i10 += -1) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mLayoutHolderMap.keyAt(i10);
            ViewInfoStore$InfoRecord viewInfoStore$InfoRecord = (ViewInfoStore$InfoRecord)this.mLayoutHolderMap.removeAt(i10);
            int n10 = viewInfoStore$InfoRecord.flags;
            int n11 = n10 & 3;
            int n12 = 3;
            if (n11 == n12) {
                viewInfoStore$ProcessCallback.unused(recyclerView$ViewHolder);
            } else {
                RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo;
                RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2;
                n11 = n10 & 1;
                if (n11 != 0) {
                    recyclerView$ItemAnimator$ItemHolderInfo2 = viewInfoStore$InfoRecord.preInfo;
                    if (recyclerView$ItemAnimator$ItemHolderInfo2 == null) {
                        viewInfoStore$ProcessCallback.unused(recyclerView$ViewHolder);
                    } else {
                        recyclerView$ItemAnimator$ItemHolderInfo = viewInfoStore$InfoRecord.postInfo;
                        viewInfoStore$ProcessCallback.processDisappeared(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo2, recyclerView$ItemAnimator$ItemHolderInfo);
                    }
                } else {
                    n11 = n10 & 0xE;
                    n12 = 14;
                    if (n11 == n12) {
                        recyclerView$ItemAnimator$ItemHolderInfo2 = viewInfoStore$InfoRecord.preInfo;
                        recyclerView$ItemAnimator$ItemHolderInfo = viewInfoStore$InfoRecord.postInfo;
                        viewInfoStore$ProcessCallback.processAppeared(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo2, recyclerView$ItemAnimator$ItemHolderInfo);
                    } else {
                        n11 = n10 & 0xC;
                        n12 = 12;
                        if (n11 == n12) {
                            recyclerView$ItemAnimator$ItemHolderInfo2 = viewInfoStore$InfoRecord.preInfo;
                            recyclerView$ItemAnimator$ItemHolderInfo = viewInfoStore$InfoRecord.postInfo;
                            viewInfoStore$ProcessCallback.processPersistent(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo2, recyclerView$ItemAnimator$ItemHolderInfo);
                        } else {
                            n11 = n10 & 4;
                            if (n11 != 0) {
                                recyclerView$ItemAnimator$ItemHolderInfo2 = viewInfoStore$InfoRecord.preInfo;
                                n11 = 0;
                                recyclerView$ItemAnimator$ItemHolderInfo = null;
                                viewInfoStore$ProcessCallback.processDisappeared(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo2, null);
                            } else if ((n10 &= 8) != 0) {
                                recyclerView$ItemAnimator$ItemHolderInfo2 = viewInfoStore$InfoRecord.preInfo;
                                recyclerView$ItemAnimator$ItemHolderInfo = viewInfoStore$InfoRecord.postInfo;
                                viewInfoStore$ProcessCallback.processAppeared(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo2, recyclerView$ItemAnimator$ItemHolderInfo);
                            }
                        }
                    }
                }
            }
            ViewInfoStore$InfoRecord.recycle(viewInfoStore$InfoRecord);
        }
    }

    public void removeFromDisappearedInLayout(RecyclerView$ViewHolder object) {
        int n10;
        SimpleArrayMap simpleArrayMap = this.mLayoutHolderMap;
        if ((object = (ViewInfoStore$InfoRecord)simpleArrayMap.get(object)) == null) {
            return;
        }
        ((ViewInfoStore$InfoRecord)object).flags = n10 = ((ViewInfoStore$InfoRecord)object).flags & 0xFFFFFFFE;
    }

    public void removeViewHolder(RecyclerView$ViewHolder object) {
        Object object2 = this.mOldChangedHolders;
        for (int i10 = ((LongSparseArray)object2).size() + -1; i10 >= 0; i10 += -1) {
            Object object3 = this.mOldChangedHolders.valueAt(i10);
            if (object != object3) continue;
            object3 = this.mOldChangedHolders;
            ((LongSparseArray)object3).removeAt(i10);
            break;
        }
        if ((object = (ViewInfoStore$InfoRecord)((SimpleArrayMap)(object2 = this.mLayoutHolderMap)).remove(object)) != null) {
            ViewInfoStore$InfoRecord.recycle((ViewInfoStore$InfoRecord)object);
        }
    }
}

