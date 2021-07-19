/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.core.util.Pools$Pool;
import androidx.recyclerview.widget.AdapterHelper$Callback;
import androidx.recyclerview.widget.AdapterHelper$UpdateOp;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.OpReorderer$Callback;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AdapterHelper
implements OpReorderer$Callback {
    private static final boolean DEBUG = false;
    public static final int POSITION_TYPE_INVISIBLE = 0;
    public static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    public final AdapterHelper$Callback mCallback;
    public final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    public Runnable mOnItemProcessedCallback;
    public final OpReorderer mOpReorderer;
    public final ArrayList mPendingUpdates;
    public final ArrayList mPostponedList;
    private Pools$Pool mUpdateOpPool;

    public AdapterHelper(AdapterHelper$Callback adapterHelper$Callback) {
        this(adapterHelper$Callback, false);
    }

    public AdapterHelper(AdapterHelper$Callback object, boolean bl2) {
        ArrayList arrayList = new ArrayList(30);
        this.mUpdateOpPool = arrayList;
        this.mPendingUpdates = arrayList = new ArrayList();
        this.mPostponedList = arrayList = new ArrayList();
        this.mExistingUpdateTypes = 0;
        this.mCallback = object;
        this.mDisableRecycler = bl2;
        this.mOpReorderer = object = new OpReorderer(this);
    }

    private void applyAdd(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        this.postponeAndUpdateViewHolders(adapterHelper$UpdateOp);
    }

    private void applyMove(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        this.postponeAndUpdateViewHolders(adapterHelper$UpdateOp);
    }

    private void applyRemove(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        int n10;
        int n11 = adapterHelper$UpdateOp.positionStart;
        int n12 = adapterHelper$UpdateOp.itemCount + n11;
        int n13 = -1;
        int n14 = n11;
        int n15 = 0;
        while (true) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp2;
            boolean bl2;
            int n16 = 0;
            n10 = 2;
            if (n14 >= n12) break;
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCallback.findViewHolder(n14);
            int n17 = 1;
            float f10 = Float.MIN_VALUE;
            if (recyclerView$ViewHolder == null && !(bl2 = this.canFindInPreLayout(n14))) {
                if (n13 == n17) {
                    adapterHelper$UpdateOp2 = this.obtainUpdateOp(n10, n11, n15, null);
                    this.postponeAndUpdateViewHolders(adapterHelper$UpdateOp2);
                    n13 = n17;
                } else {
                    n13 = 0;
                    adapterHelper$UpdateOp2 = null;
                }
                n16 = 0;
            } else {
                if (n13 == 0) {
                    adapterHelper$UpdateOp2 = this.obtainUpdateOp(n10, n11, n15, null);
                    this.dispatchAndUpdateViewHolders(adapterHelper$UpdateOp2);
                    n13 = n17;
                } else {
                    n13 = 0;
                    adapterHelper$UpdateOp2 = null;
                }
                n16 = n17;
            }
            if (n13 != 0) {
                n14 -= n15;
                n12 -= n15;
                n15 = n17;
            } else {
                ++n15;
            }
            n14 += n17;
            n13 = n16;
        }
        n12 = adapterHelper$UpdateOp.itemCount;
        if (n15 != n12) {
            this.recycleUpdateOp(adapterHelper$UpdateOp);
            adapterHelper$UpdateOp = this.obtainUpdateOp(n10, n11, n15, null);
        }
        if (n13 == 0) {
            this.dispatchAndUpdateViewHolders(adapterHelper$UpdateOp);
        } else {
            this.postponeAndUpdateViewHolders(adapterHelper$UpdateOp);
        }
    }

    private void applyUpdate(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        int n10;
        int n11 = adapterHelper$UpdateOp.positionStart;
        int n12 = adapterHelper$UpdateOp.itemCount + n11;
        int n13 = 0;
        int n14 = -1;
        int n15 = n11;
        while (true) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp2;
            Object object;
            boolean bl2;
            n10 = 4;
            if (n11 >= n12) break;
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCallback.findViewHolder(n11);
            int n16 = 1;
            if (recyclerView$ViewHolder == null && !(bl2 = this.canFindInPreLayout(n11))) {
                if (n14 == n16) {
                    object = adapterHelper$UpdateOp.payload;
                    adapterHelper$UpdateOp2 = this.obtainUpdateOp(n10, n15, n13, object);
                    this.postponeAndUpdateViewHolders(adapterHelper$UpdateOp2);
                    n15 = n11;
                    n13 = 0;
                }
                n14 = 0;
                object = null;
            } else {
                if (n14 == 0) {
                    object = adapterHelper$UpdateOp.payload;
                    adapterHelper$UpdateOp2 = this.obtainUpdateOp(n10, n15, n13, object);
                    this.dispatchAndUpdateViewHolders(adapterHelper$UpdateOp2);
                    n15 = n11;
                    n13 = 0;
                }
                n14 = n16;
            }
            n13 += n16;
            ++n11;
        }
        n11 = adapterHelper$UpdateOp.itemCount;
        if (n13 != n11) {
            Object object = adapterHelper$UpdateOp.payload;
            this.recycleUpdateOp(adapterHelper$UpdateOp);
            adapterHelper$UpdateOp = this.obtainUpdateOp(n10, n15, n13, object);
        }
        if (n14 == 0) {
            this.dispatchAndUpdateViewHolders(adapterHelper$UpdateOp);
        } else {
            this.postponeAndUpdateViewHolders(adapterHelper$UpdateOp);
        }
    }

    private boolean canFindInPreLayout(int n10) {
        ArrayList arrayList = this.mPostponedList;
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp)this.mPostponedList.get(i10);
            int n13 = adapterHelper$UpdateOp.cmd;
            int n14 = 8;
            int n15 = 1;
            if (n13 == n14) {
                n12 = adapterHelper$UpdateOp.itemCount;
                n13 = i10 + 1;
                if ((n12 = this.findPositionOffset(n12, n13)) != n10) continue;
                return n15 != 0;
            }
            if (n13 != n15) continue;
            n12 = adapterHelper$UpdateOp.itemCount + n13;
            for (n13 = adapterHelper$UpdateOp.positionStart; n13 < n12; ++n13) {
                n14 = i10 + 1;
                if ((n14 = this.findPositionOffset(n13, n14)) != n10) continue;
                return n15 != 0;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void dispatchAndUpdateViewHolders(AdapterHelper$UpdateOp object) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16 = ((AdapterHelper$UpdateOp)object).cmd;
        int n17 = 1;
        if (n16 != n17 && n16 != (n15 = 8)) {
            n15 = ((AdapterHelper$UpdateOp)object).positionStart;
            n16 = this.updatePositionWithPostponed(n15, n16);
            n15 = ((AdapterHelper$UpdateOp)object).positionStart;
            n14 = ((AdapterHelper$UpdateOp)object).cmd;
            n13 = 2;
            n12 = 4;
            if (n14 != n13) {
                if (n14 != n12) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("op should be remove or update.");
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                    throw illegalArgumentException;
                }
                n14 = n17;
            } else {
                n14 = 0;
            }
            n11 = n17;
        } else {
            object = new IllegalArgumentException("should not dispatch add or move for pre layout");
            throw object;
        }
        for (int i10 = n17; i10 < (n10 = ((AdapterHelper$UpdateOp)object).itemCount); ++i10) {
            Object object2;
            int n18;
            n10 = ((AdapterHelper$UpdateOp)object).positionStart;
            int n19 = n14 * i10;
            n10 += n19;
            n19 = ((AdapterHelper$UpdateOp)object).cmd;
            n10 = this.updatePositionWithPostponed(n10, n19);
            n19 = ((AdapterHelper$UpdateOp)object).cmd;
            if (!(n19 != n13 ? n19 == n12 && n10 == (n18 = n16 + 1) : n10 == n16)) {
                n18 = 0;
                object2 = null;
            } else {
                n18 = n17;
            }
            if (n18 != 0) {
                ++n11;
                continue;
            }
            object2 = ((AdapterHelper$UpdateOp)object).payload;
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = this.obtainUpdateOp(n19, n16, n11, object2);
            this.dispatchFirstPassAndUpdateViewHolders(adapterHelper$UpdateOp, n15);
            this.recycleUpdateOp(adapterHelper$UpdateOp);
            n16 = ((AdapterHelper$UpdateOp)object).cmd;
            if (n16 == n12) {
                n15 += n11;
            }
            n11 = n17;
            n16 = n10;
        }
        Object object3 = ((AdapterHelper$UpdateOp)object).payload;
        this.recycleUpdateOp((AdapterHelper$UpdateOp)object);
        if (n11 > 0) {
            int n20 = ((AdapterHelper$UpdateOp)object).cmd;
            object = this.obtainUpdateOp(n20, n16, n11, object3);
            this.dispatchFirstPassAndUpdateViewHolders((AdapterHelper$UpdateOp)object, n15);
            this.recycleUpdateOp((AdapterHelper$UpdateOp)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void postponeAndUpdateViewHolders(AdapterHelper$UpdateOp object) {
        Object object2 = this.mPostponedList;
        ((ArrayList)object2).add(object);
        int n10 = ((AdapterHelper$UpdateOp)object).cmd;
        int n11 = 1;
        if (n10 == n11) {
            object2 = this.mCallback;
            n11 = ((AdapterHelper$UpdateOp)object).positionStart;
            int n12 = ((AdapterHelper$UpdateOp)object).itemCount;
            object2.offsetPositionsForAdd(n11, n12);
            return;
        }
        n11 = 2;
        if (n10 == n11) {
            object2 = this.mCallback;
            n11 = ((AdapterHelper$UpdateOp)object).positionStart;
            int n13 = ((AdapterHelper$UpdateOp)object).itemCount;
            object2.offsetPositionsForRemovingLaidOutOrNewView(n11, n13);
            return;
        }
        n11 = 4;
        if (n10 == n11) {
            object2 = this.mCallback;
            n11 = ((AdapterHelper$UpdateOp)object).positionStart;
            int n14 = ((AdapterHelper$UpdateOp)object).itemCount;
            object = ((AdapterHelper$UpdateOp)object).payload;
            object2.markViewHoldersUpdated(n11, n14, object);
            return;
        }
        n11 = 8;
        if (n10 == n11) {
            object2 = this.mCallback;
            n11 = ((AdapterHelper$UpdateOp)object).positionStart;
            int n15 = ((AdapterHelper$UpdateOp)object).itemCount;
            object2.offsetPositionsForMove(n11, n15);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown update op type for ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    private int updatePositionWithPostponed(int n10, int n11) {
        int n12;
        Object object = this.mPostponedList;
        int n13 = ((ArrayList)object).size();
        int n14 = 1;
        n13 -= n14;
        while (true) {
            n12 = 8;
            if (n13 < 0) break;
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp)this.mPostponedList.get(n13);
            int n15 = adapterHelper$UpdateOp.cmd;
            int n16 = 2;
            if (n15 == n12) {
                int n17;
                int n18;
                n12 = adapterHelper$UpdateOp.positionStart;
                n15 = adapterHelper$UpdateOp.itemCount;
                if (n12 < n15) {
                    n18 = n12;
                    n17 = n15;
                } else {
                    n17 = n12;
                    n18 = n15;
                }
                if (n10 >= n18 && n10 <= n17) {
                    if (n18 == n12) {
                        if (n11 == n14) {
                            adapterHelper$UpdateOp.itemCount = ++n15;
                        } else if (n11 == n16) {
                            adapterHelper$UpdateOp.itemCount = n15 += -1;
                        }
                        ++n10;
                    } else {
                        if (n11 == n14) {
                            adapterHelper$UpdateOp.positionStart = ++n12;
                        } else if (n11 == n16) {
                            adapterHelper$UpdateOp.positionStart = n12 += -1;
                        }
                        n10 += -1;
                    }
                } else if (n10 < n12) {
                    if (n11 == n14) {
                        adapterHelper$UpdateOp.positionStart = ++n12;
                        adapterHelper$UpdateOp.itemCount = ++n15;
                    } else if (n11 == n16) {
                        adapterHelper$UpdateOp.positionStart = n12 += -1;
                        adapterHelper$UpdateOp.itemCount = n15 += -1;
                    }
                }
            } else {
                n12 = adapterHelper$UpdateOp.positionStart;
                if (n12 <= n10) {
                    if (n15 == n14) {
                        n12 = adapterHelper$UpdateOp.itemCount;
                        n10 -= n12;
                    } else if (n15 == n16) {
                        n12 = adapterHelper$UpdateOp.itemCount;
                        n10 += n12;
                    }
                } else if (n11 == n14) {
                    adapterHelper$UpdateOp.positionStart = ++n12;
                } else if (n11 == n16) {
                    adapterHelper$UpdateOp.positionStart = n12 += -1;
                }
            }
            n13 += -1;
        }
        ArrayList arrayList = this.mPostponedList;
        for (n11 = arrayList.size() - n14; n11 >= 0; n11 += -1) {
            ArrayList arrayList2;
            object = (AdapterHelper$UpdateOp)this.mPostponedList.get(n11);
            n14 = ((AdapterHelper$UpdateOp)object).cmd;
            if (n14 == n12) {
                n14 = ((AdapterHelper$UpdateOp)object).itemCount;
                int n19 = ((AdapterHelper$UpdateOp)object).positionStart;
                if (n14 != n19 && n14 >= 0) continue;
                arrayList2 = this.mPostponedList;
                arrayList2.remove(n11);
                this.recycleUpdateOp((AdapterHelper$UpdateOp)object);
                continue;
            }
            n14 = ((AdapterHelper$UpdateOp)object).itemCount;
            if (n14 > 0) continue;
            arrayList2 = this.mPostponedList;
            arrayList2.remove(n11);
            this.recycleUpdateOp((AdapterHelper$UpdateOp)object);
        }
        return n10;
    }

    public AdapterHelper addUpdateOp(AdapterHelper$UpdateOp ... adapterHelper$UpdateOpArray) {
        Collections.addAll(this.mPendingUpdates, adapterHelper$UpdateOpArray);
        return this;
    }

    public int applyPendingUpdatesToPosition(int n10) {
        ArrayList arrayList = this.mPendingUpdates;
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp)this.mPendingUpdates.get(i10);
            int n13 = adapterHelper$UpdateOp.cmd;
            int n14 = 1;
            if (n13 != n14) {
                n14 = 2;
                if (n13 != n14) {
                    n14 = 8;
                    if (n13 != n14) continue;
                    n13 = adapterHelper$UpdateOp.positionStart;
                    if (n13 == n10) {
                        n10 = adapterHelper$UpdateOp.itemCount;
                        continue;
                    }
                    if (n13 < n10) {
                        n10 += -1;
                    }
                    if ((n12 = adapterHelper$UpdateOp.itemCount) > n10) continue;
                    ++n10;
                    continue;
                }
                n13 = adapterHelper$UpdateOp.positionStart;
                if (n13 > n10) continue;
                n12 = adapterHelper$UpdateOp.itemCount;
                if ((n13 += n12) > n10) {
                    return -1;
                }
                n10 -= n12;
                continue;
            }
            n13 = adapterHelper$UpdateOp.positionStart;
            if (n13 > n10) continue;
            n12 = adapterHelper$UpdateOp.itemCount;
            n10 += n12;
        }
        return n10;
    }

    public void consumePostponedUpdates() {
        ArrayList arrayList = this.mPostponedList;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            AdapterHelper$Callback adapterHelper$Callback = this.mCallback;
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp)this.mPostponedList.get(i10);
            adapterHelper$Callback.onDispatchSecondPass(adapterHelper$UpdateOp);
        }
        arrayList = this.mPostponedList;
        this.recycleUpdateOpsAndClearList(arrayList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        this.consumePostponedUpdates();
        ArrayList arrayList = this.mPendingUpdates;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            AdapterHelper$Callback adapterHelper$Callback;
            Object object = (AdapterHelper$UpdateOp)this.mPendingUpdates.get(i10);
            int n12 = ((AdapterHelper$UpdateOp)object).cmd;
            int n13 = 1;
            if (n12 != n13) {
                n13 = 2;
                if (n12 != n13) {
                    n13 = 4;
                    if (n12 != n13) {
                        n13 = 8;
                        if (n12 == n13) {
                            this.mCallback.onDispatchSecondPass((AdapterHelper$UpdateOp)object);
                            adapterHelper$Callback = this.mCallback;
                            n13 = ((AdapterHelper$UpdateOp)object).positionStart;
                            n11 = ((AdapterHelper$UpdateOp)object).itemCount;
                            adapterHelper$Callback.offsetPositionsForMove(n13, n11);
                        }
                    } else {
                        this.mCallback.onDispatchSecondPass((AdapterHelper$UpdateOp)object);
                        adapterHelper$Callback = this.mCallback;
                        n13 = ((AdapterHelper$UpdateOp)object).positionStart;
                        int n14 = ((AdapterHelper$UpdateOp)object).itemCount;
                        object = ((AdapterHelper$UpdateOp)object).payload;
                        adapterHelper$Callback.markViewHoldersUpdated(n13, n14, object);
                    }
                } else {
                    this.mCallback.onDispatchSecondPass((AdapterHelper$UpdateOp)object);
                    adapterHelper$Callback = this.mCallback;
                    n13 = ((AdapterHelper$UpdateOp)object).positionStart;
                    n11 = ((AdapterHelper$UpdateOp)object).itemCount;
                    adapterHelper$Callback.offsetPositionsForRemovingInvisible(n13, n11);
                }
            } else {
                this.mCallback.onDispatchSecondPass((AdapterHelper$UpdateOp)object);
                adapterHelper$Callback = this.mCallback;
                n13 = ((AdapterHelper$UpdateOp)object).positionStart;
                n11 = ((AdapterHelper$UpdateOp)object).itemCount;
                adapterHelper$Callback.offsetPositionsForAdd(n13, n11);
            }
            object = this.mOnItemProcessedCallback;
            if (object == null) continue;
            object.run();
        }
        arrayList = this.mPendingUpdates;
        this.recycleUpdateOpsAndClearList(arrayList);
        this.mExistingUpdateTypes = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void dispatchFirstPassAndUpdateViewHolders(AdapterHelper$UpdateOp object, int n10) {
        AdapterHelper$Callback adapterHelper$Callback = this.mCallback;
        adapterHelper$Callback.onDispatchFirstPass((AdapterHelper$UpdateOp)object);
        int n11 = ((AdapterHelper$UpdateOp)object).cmd;
        int n12 = 2;
        if (n11 == n12) {
            adapterHelper$Callback = this.mCallback;
            int n13 = ((AdapterHelper$UpdateOp)object).itemCount;
            adapterHelper$Callback.offsetPositionsForRemovingInvisible(n10, n13);
            return;
        }
        n12 = 4;
        if (n11 == n12) {
            adapterHelper$Callback = this.mCallback;
            n12 = ((AdapterHelper$UpdateOp)object).itemCount;
            object = ((AdapterHelper$UpdateOp)object).payload;
            adapterHelper$Callback.markViewHoldersUpdated(n10, n12, object);
            return;
        }
        object = new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        throw object;
    }

    public int findPositionOffset(int n10) {
        return this.findPositionOffset(n10, 0);
    }

    public int findPositionOffset(int n10, int n11) {
        ArrayList arrayList = this.mPostponedList;
        int n12 = arrayList.size();
        while (n11 < n12) {
            int n13;
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp)this.mPostponedList.get(n11);
            int n14 = adapterHelper$UpdateOp.cmd;
            int n15 = 8;
            if (n14 == n15) {
                n14 = adapterHelper$UpdateOp.positionStart;
                if (n14 == n10) {
                    n10 = adapterHelper$UpdateOp.itemCount;
                } else {
                    if (n14 < n10) {
                        n10 += -1;
                    }
                    if ((n13 = adapterHelper$UpdateOp.itemCount) <= n10) {
                        ++n10;
                    }
                }
            } else {
                n15 = adapterHelper$UpdateOp.positionStart;
                if (n15 <= n10) {
                    int n16 = 2;
                    if (n14 == n16) {
                        n13 = adapterHelper$UpdateOp.itemCount;
                        if (n10 < (n15 += n13)) {
                            return -1;
                        }
                        n10 -= n13;
                    } else {
                        n15 = 1;
                        if (n14 == n15) {
                            n13 = adapterHelper$UpdateOp.itemCount;
                            n10 += n13;
                        }
                    }
                }
            }
            ++n11;
        }
        return n10;
    }

    public boolean hasAnyUpdateTypes(int n10) {
        int n11 = this.mExistingUpdateTypes;
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasPendingUpdates() {
        ArrayList arrayList = this.mPendingUpdates;
        int n10 = arrayList.size();
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            arrayList = null;
        }
        return n10 != 0;
    }

    public boolean hasUpdates() {
        ArrayList arrayList = this.mPostponedList;
        boolean bl2 = arrayList.isEmpty();
        if (!bl2 && !(bl2 = (arrayList = this.mPendingUpdates).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            arrayList = null;
        }
        return bl2;
    }

    public AdapterHelper$UpdateOp obtainUpdateOp(int n10, int n11, int n12, Object object) {
        AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp)this.mUpdateOpPool.acquire();
        if (adapterHelper$UpdateOp == null) {
            adapterHelper$UpdateOp = new AdapterHelper$UpdateOp(n10, n11, n12, object);
        } else {
            adapterHelper$UpdateOp.cmd = n10;
            adapterHelper$UpdateOp.positionStart = n11;
            adapterHelper$UpdateOp.itemCount = n12;
            adapterHelper$UpdateOp.payload = object;
        }
        return adapterHelper$UpdateOp;
    }

    public boolean onItemRangeChanged(int n10, int n11, Object object) {
        int n12 = 0;
        int n13 = 1;
        if (n11 < n13) {
            return false;
        }
        ArrayList arrayList = this.mPendingUpdates;
        int n14 = 4;
        Object object2 = this.obtainUpdateOp(n14, n10, n11, object);
        arrayList.add(object2);
        this.mExistingUpdateTypes = n10 = this.mExistingUpdateTypes | n14;
        object2 = this.mPendingUpdates;
        n10 = ((ArrayList)object2).size();
        if (n10 == n13) {
            n12 = n13;
        }
        return n12;
    }

    public boolean onItemRangeInserted(int n10, int n11) {
        int n12 = 0;
        int n13 = 1;
        if (n11 < n13) {
            return false;
        }
        ArrayList arrayList = this.mPendingUpdates;
        Object object = this.obtainUpdateOp(n13, n10, n11, null);
        arrayList.add(object);
        this.mExistingUpdateTypes = n10 = this.mExistingUpdateTypes | n13;
        object = this.mPendingUpdates;
        n10 = ((ArrayList)object).size();
        if (n10 == n13) {
            n12 = n13;
        }
        return n12 != 0;
    }

    public boolean onItemRangeMoved(int n10, int n11, int n12) {
        int n13 = 0;
        if (n10 == n11) {
            return false;
        }
        int n14 = 1;
        if (n12 == n14) {
            ArrayList arrayList = this.mPendingUpdates;
            int n15 = 8;
            Object object = this.obtainUpdateOp(n15, n10, n11, null);
            arrayList.add(object);
            this.mExistingUpdateTypes = n10 = this.mExistingUpdateTypes | n15;
            object = this.mPendingUpdates;
            n10 = ((ArrayList)object).size();
            if (n10 == n14) {
                n13 = n14;
            }
            return n13;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Moving more than 1 item is not supported yet");
        throw illegalArgumentException;
    }

    public boolean onItemRangeRemoved(int n10, int n11) {
        int n12 = 0;
        int n13 = 1;
        if (n11 < n13) {
            return false;
        }
        ArrayList arrayList = this.mPendingUpdates;
        int n14 = 2;
        Object object = this.obtainUpdateOp(n14, n10, n11, null);
        arrayList.add(object);
        this.mExistingUpdateTypes = n10 = this.mExistingUpdateTypes | n14;
        object = this.mPendingUpdates;
        n10 = ((ArrayList)object).size();
        if (n10 == n13) {
            n12 = n13;
        }
        return n12;
    }

    public void preProcess() {
        Object object = this.mOpReorderer;
        ArrayList arrayList = this.mPendingUpdates;
        ((OpReorderer)object).reorderOps(arrayList);
        object = this.mPendingUpdates;
        int n10 = ((ArrayList)object).size();
        arrayList = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = (AdapterHelper$UpdateOp)this.mPendingUpdates.get(i10);
            int n11 = ((AdapterHelper$UpdateOp)object2).cmd;
            int n12 = 1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 != n12) {
                    n12 = 4;
                    if (n11 != n12) {
                        n12 = 8;
                        if (n11 == n12) {
                            this.applyMove((AdapterHelper$UpdateOp)object2);
                        }
                    } else {
                        this.applyUpdate((AdapterHelper$UpdateOp)object2);
                    }
                } else {
                    this.applyRemove((AdapterHelper$UpdateOp)object2);
                }
            } else {
                this.applyAdd((AdapterHelper$UpdateOp)object2);
            }
            object2 = this.mOnItemProcessedCallback;
            if (object2 == null) continue;
            object2.run();
        }
        this.mPendingUpdates.clear();
    }

    public void recycleUpdateOp(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        boolean bl2 = this.mDisableRecycler;
        if (!bl2) {
            bl2 = false;
            adapterHelper$UpdateOp.payload = null;
            Pools$Pool pools$Pool = this.mUpdateOpPool;
            pools$Pool.release(adapterHelper$UpdateOp);
        }
    }

    public void recycleUpdateOpsAndClearList(List list) {
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp)list.get(i10);
            this.recycleUpdateOp(adapterHelper$UpdateOp);
        }
        list.clear();
    }

    public void reset() {
        ArrayList arrayList = this.mPendingUpdates;
        this.recycleUpdateOpsAndClearList(arrayList);
        arrayList = this.mPostponedList;
        this.recycleUpdateOpsAndClearList(arrayList);
        this.mExistingUpdateTypes = 0;
    }
}

