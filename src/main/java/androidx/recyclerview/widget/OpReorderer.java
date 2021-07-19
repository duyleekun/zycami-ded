/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper$UpdateOp;
import androidx.recyclerview.widget.OpReorderer$Callback;
import java.util.List;

public class OpReorderer {
    public final OpReorderer$Callback mCallback;

    public OpReorderer(OpReorderer$Callback opReorderer$Callback) {
        this.mCallback = opReorderer$Callback;
    }

    private int getLastMoveOutOfOrder(List list) {
        int n10 = list.size();
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        while (n10 >= 0) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp)list.get(n10);
            int n13 = adapterHelper$UpdateOp.cmd;
            int n14 = 8;
            if (n13 == n14) {
                if (n12 != 0) {
                    return n10;
                }
            } else {
                n12 = n11;
            }
            n10 += -1;
        }
        return -1;
    }

    private void swapMoveAdd(List list, int n10, AdapterHelper$UpdateOp adapterHelper$UpdateOp, int n11, AdapterHelper$UpdateOp adapterHelper$UpdateOp2) {
        int n12 = adapterHelper$UpdateOp.itemCount;
        int n13 = adapterHelper$UpdateOp2.positionStart;
        int n14 = n12 < n13 ? -1 : 0;
        int n15 = adapterHelper$UpdateOp.positionStart;
        if (n15 < n13) {
            ++n14;
        }
        if (n13 <= n15) {
            n13 = adapterHelper$UpdateOp2.itemCount;
            adapterHelper$UpdateOp.positionStart = n15 += n13;
        }
        if ((n13 = adapterHelper$UpdateOp2.positionStart) <= n12) {
            n15 = adapterHelper$UpdateOp2.itemCount;
            adapterHelper$UpdateOp.itemCount = n12 += n15;
        }
        adapterHelper$UpdateOp2.positionStart = n13 += n14;
        list.set(n10, adapterHelper$UpdateOp2);
        list.set(n11, adapterHelper$UpdateOp);
    }

    private void swapMoveOp(List list, int n10, int n11) {
        Object e10;
        Object object = e10 = list.get(n10);
        object = (AdapterHelper$UpdateOp)e10;
        Object object2 = e10 = list.get(n11);
        object2 = (AdapterHelper$UpdateOp)e10;
        int n12 = ((AdapterHelper$UpdateOp)object2).cmd;
        int n13 = 1;
        if (n12 != n13) {
            n13 = 2;
            if (n12 != n13) {
                n13 = 4;
                if (n12 == n13) {
                    this.swapMoveUpdate(list, n10, (AdapterHelper$UpdateOp)object, n11, (AdapterHelper$UpdateOp)object2);
                }
            } else {
                this.swapMoveRemove(list, n10, (AdapterHelper$UpdateOp)object, n11, (AdapterHelper$UpdateOp)object2);
            }
        } else {
            this.swapMoveAdd(list, n10, (AdapterHelper$UpdateOp)object, n11, (AdapterHelper$UpdateOp)object2);
        }
    }

    public void reorderOps(List list) {
        int n10;
        int n11;
        while ((n11 = this.getLastMoveOutOfOrder(list)) != (n10 = -1)) {
            n10 = n11 + 1;
            this.swapMoveOp(list, n11, n10);
        }
    }

    public void swapMoveRemove(List object, int n10, AdapterHelper$UpdateOp adapterHelper$UpdateOp, int n11, AdapterHelper$UpdateOp adapterHelper$UpdateOp2) {
        int n12;
        int n13;
        int n14;
        int n15 = adapterHelper$UpdateOp.positionStart;
        int n16 = adapterHelper$UpdateOp.itemCount;
        int n17 = 0;
        int n18 = 1;
        if (n15 < n16) {
            n14 = adapterHelper$UpdateOp2.positionStart;
            if (n14 == n15 && (n14 = adapterHelper$UpdateOp2.itemCount) == (n15 = n16 - n15)) {
                n15 = 0;
                n17 = n18;
            } else {
                n15 = 0;
            }
        } else {
            n14 = adapterHelper$UpdateOp2.positionStart;
            n13 = n16 + 1;
            if (n14 == n13 && (n14 = adapterHelper$UpdateOp2.itemCount) == (n15 -= n16)) {
                n15 = n18;
                n17 = n18;
            } else {
                n15 = n18;
            }
        }
        n14 = adapterHelper$UpdateOp2.positionStart;
        n13 = 2;
        if (n16 < n14) {
            adapterHelper$UpdateOp2.positionStart = n14 -= n18;
        } else {
            n12 = adapterHelper$UpdateOp2.itemCount;
            if (n16 < (n14 += n12)) {
                adapterHelper$UpdateOp2.itemCount = n12 -= n18;
                adapterHelper$UpdateOp.cmd = n13;
                adapterHelper$UpdateOp.itemCount = n18;
                n10 = adapterHelper$UpdateOp2.itemCount;
                if (n10 == 0) {
                    object.remove(n11);
                    object = this.mCallback;
                    object.recycleUpdateOp(adapterHelper$UpdateOp2);
                }
                return;
            }
        }
        n16 = adapterHelper$UpdateOp.positionStart;
        n14 = adapterHelper$UpdateOp2.positionStart;
        n12 = 0;
        AdapterHelper$UpdateOp adapterHelper$UpdateOp3 = null;
        if (n16 <= n14) {
            adapterHelper$UpdateOp2.positionStart = n14 += n18;
        } else {
            int n19 = adapterHelper$UpdateOp2.itemCount;
            int n20 = n14 + n19;
            if (n16 < n20) {
                n14 = n14 + n19 - n16;
                OpReorderer$Callback opReorderer$Callback = this.mCallback;
                adapterHelper$UpdateOp3 = opReorderer$Callback.obtainUpdateOp(n13, n16 += n18, n14, null);
                n16 = adapterHelper$UpdateOp.positionStart;
                n18 = adapterHelper$UpdateOp2.positionStart;
                adapterHelper$UpdateOp2.itemCount = n16 -= n18;
            }
        }
        if (n17 != 0) {
            object.set(n10, adapterHelper$UpdateOp2);
            object.remove(n11);
            this.mCallback.recycleUpdateOp(adapterHelper$UpdateOp);
            return;
        }
        if (n15 != 0) {
            if (adapterHelper$UpdateOp3 != null) {
                n15 = adapterHelper$UpdateOp.positionStart;
                n16 = adapterHelper$UpdateOp3.positionStart;
                if (n15 > n16) {
                    n16 = adapterHelper$UpdateOp3.itemCount;
                    adapterHelper$UpdateOp.positionStart = n15 -= n16;
                }
                if ((n15 = adapterHelper$UpdateOp.itemCount) > (n16 = adapterHelper$UpdateOp3.positionStart)) {
                    n16 = adapterHelper$UpdateOp3.itemCount;
                    adapterHelper$UpdateOp.itemCount = n15 -= n16;
                }
            }
            if ((n15 = adapterHelper$UpdateOp.positionStart) > (n16 = adapterHelper$UpdateOp2.positionStart)) {
                n16 = adapterHelper$UpdateOp2.itemCount;
                adapterHelper$UpdateOp.positionStart = n15 -= n16;
            }
            if ((n15 = adapterHelper$UpdateOp.itemCount) > (n16 = adapterHelper$UpdateOp2.positionStart)) {
                n16 = adapterHelper$UpdateOp2.itemCount;
                adapterHelper$UpdateOp.itemCount = n15 -= n16;
            }
        } else {
            if (adapterHelper$UpdateOp3 != null) {
                n15 = adapterHelper$UpdateOp.positionStart;
                n16 = adapterHelper$UpdateOp3.positionStart;
                if (n15 >= n16) {
                    n16 = adapterHelper$UpdateOp3.itemCount;
                    adapterHelper$UpdateOp.positionStart = n15 -= n16;
                }
                if ((n15 = adapterHelper$UpdateOp.itemCount) >= (n16 = adapterHelper$UpdateOp3.positionStart)) {
                    n16 = adapterHelper$UpdateOp3.itemCount;
                    adapterHelper$UpdateOp.itemCount = n15 -= n16;
                }
            }
            if ((n15 = adapterHelper$UpdateOp.positionStart) >= (n16 = adapterHelper$UpdateOp2.positionStart)) {
                n16 = adapterHelper$UpdateOp2.itemCount;
                adapterHelper$UpdateOp.positionStart = n15 -= n16;
            }
            if ((n15 = adapterHelper$UpdateOp.itemCount) >= (n16 = adapterHelper$UpdateOp2.positionStart)) {
                n16 = adapterHelper$UpdateOp2.itemCount;
                adapterHelper$UpdateOp.itemCount = n15 -= n16;
            }
        }
        object.set(n10, adapterHelper$UpdateOp2);
        int n21 = adapterHelper$UpdateOp.positionStart;
        n15 = adapterHelper$UpdateOp.itemCount;
        if (n21 != n15) {
            object.set(n11, adapterHelper$UpdateOp);
        } else {
            object.remove(n11);
        }
        if (adapterHelper$UpdateOp3 != null) {
            object.add(n10, adapterHelper$UpdateOp3);
        }
    }

    /*
     * Unable to fully structure code
     */
    public void swapMoveUpdate(List var1_1, int var2_2, AdapterHelper$UpdateOp var3_3, int var4_4, AdapterHelper$UpdateOp var5_5) {
        block9: {
            var6_6 = var3_3.itemCount;
            var7_7 = var5_5.positionStart;
            var8_8 = 4;
            var9_9 = null;
            var10_10 = 1;
            if (var6_6 >= var7_7) break block9;
            var5_5.positionStart = var7_7 -= var10_10;
            ** GOTO lbl-1000
        }
        var11_11 = var5_5.itemCount;
        if (var6_6 < (var7_7 += var11_11)) {
            var5_5.itemCount = var11_11 -= var10_10;
            var12_12 = this.mCallback;
            var7_7 = var3_3.positionStart;
            var13_13 = var5_5.payload;
            var12_12 = var12_12.obtainUpdateOp(var8_8, var7_7, var10_10, var13_13);
        } else lbl-1000:
        // 2 sources

        {
            var6_6 = 0;
            var12_12 = null;
        }
        var7_7 = var3_3.positionStart;
        var11_11 = var5_5.positionStart;
        if (var7_7 <= var11_11) {
            var5_5.positionStart = var11_11 += var10_10;
        } else {
            var14_14 = var5_5.itemCount;
            var15_15 = var11_11 + var14_14;
            if (var7_7 < var15_15) {
                var11_11 = var11_11 + var14_14 - var7_7;
                var9_9 = this.mCallback;
                var16_16 = var5_5.payload;
                var9_9 = var9_9.obtainUpdateOp(var8_8, var7_7 += var10_10, var11_11, var16_16);
                var5_5.itemCount = var7_7 = var5_5.itemCount - var11_11;
            }
        }
        var1_1.set(var4_4, var3_3);
        var17_17 = var5_5.itemCount;
        if (var17_17 > 0) {
            var1_1.set(var2_2, var5_5);
        } else {
            var1_1.remove(var2_2);
            var3_3 = this.mCallback;
            var3_3.recycleUpdateOp(var5_5);
        }
        if (var12_12 != null) {
            var1_1.add(var2_2, var12_12);
        }
        if (var9_9 != null) {
            var1_1.add(var2_2, var9_9);
        }
    }
}

