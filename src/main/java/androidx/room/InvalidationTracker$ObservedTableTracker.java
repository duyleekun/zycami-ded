/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import java.util.Arrays;

public class InvalidationTracker$ObservedTableTracker {
    public static final int ADD = 1;
    public static final int NO_OP = 0;
    public static final int REMOVE = 2;
    public boolean mNeedsSync;
    public boolean mPendingSync;
    public final long[] mTableObservers;
    public final int[] mTriggerStateChanges;
    public final boolean[] mTriggerStates;

    public InvalidationTracker$ObservedTableTracker(int n10) {
        long[] lArray = new long[n10];
        this.mTableObservers = lArray;
        boolean[] blArray = new boolean[n10];
        this.mTriggerStates = blArray;
        int[] nArray = new int[n10];
        this.mTriggerStateChanges = nArray;
        Arrays.fill(lArray, 0L);
        Arrays.fill(blArray, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int[] getTablesToSync() {
        synchronized (this) {
            int n10 = this.mNeedsSync;
            if (n10 == 0) return null;
            n10 = this.mPendingSync;
            if (n10 != 0) {
                return null;
            }
            Object[] objectArray = this.mTableObservers;
            n10 = objectArray.length;
            int n11 = 0;
            while (true) {
                int n12 = 1;
                if (n11 >= n10) {
                    this.mPendingSync = n12;
                    this.mNeedsSync = false;
                    return this.mTriggerStateChanges;
                }
                long[] lArray = this.mTableObservers;
                long l10 = lArray[n11];
                long l11 = 0L;
                long l12 = l10 - l11;
                Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object > 0) {
                    object = n12;
                } else {
                    object = 0;
                    lArray = null;
                }
                boolean[] blArray = this.mTriggerStates;
                boolean bl2 = blArray[n11];
                if (object != bl2) {
                    int[] nArray = this.mTriggerStateChanges;
                    if (object == false) {
                        n12 = 2;
                    }
                    nArray[n11] = n12;
                } else {
                    int[] nArray = this.mTriggerStateChanges;
                    nArray[n11] = 0;
                }
                blArray[n11] = object;
                ++n11;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onAdded(int ... nArray) {
        synchronized (this) {
            int n10 = nArray.length;
            int n11 = 0;
            boolean bl2 = false;
            while (n11 < n10) {
                long l10;
                int n12 = nArray[n11];
                long[] lArray = this.mTableObservers;
                long l11 = lArray[n12];
                lArray[n12] = l10 = 1L + l11;
                long l12 = 0L;
                n12 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
                boolean bl3 = true;
                if (n12 == 0) {
                    this.mNeedsSync = bl3;
                    bl2 = bl3;
                }
                ++n11;
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean onRemoved(int ... nArray) {
        synchronized (this) {
            int n10 = nArray.length;
            int n11 = 0;
            boolean bl2 = false;
            while (n11 < n10) {
                long l10;
                int n12 = nArray[n11];
                long[] lArray = this.mTableObservers;
                long l11 = lArray[n12];
                long l12 = 1L;
                lArray[n12] = l10 = l11 - l12;
                n12 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
                boolean bl3 = true;
                if (n12 == 0) {
                    this.mNeedsSync = bl3;
                    bl2 = bl3;
                }
                ++n11;
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSyncCompleted() {
        synchronized (this) {
            Object var1_1 = null;
            this.mPendingSync = false;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resetTriggerState() {
        synchronized (this) {
            boolean bl2;
            boolean[] blArray = this.mTriggerStates;
            Arrays.fill(blArray, false);
            this.mNeedsSync = bl2 = true;
            return;
        }
    }
}

