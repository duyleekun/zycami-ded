/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil$1;
import androidx.recyclerview.widget.DiffUtil$Callback;
import androidx.recyclerview.widget.DiffUtil$CenteredArray;
import androidx.recyclerview.widget.DiffUtil$Diagonal;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.DiffUtil$Range;
import androidx.recyclerview.widget.DiffUtil$Snake;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DiffUtil {
    private static final Comparator DIAGONAL_COMPARATOR;

    static {
        DiffUtil$1 diffUtil$1 = new DiffUtil$1();
        DIAGONAL_COMPARATOR = diffUtil$1;
    }

    private DiffUtil() {
    }

    /*
     * Unable to fully structure code
     */
    private static DiffUtil$Snake backward(DiffUtil$Range var0, DiffUtil$Callback var1_1, DiffUtil$CenteredArray var2_2, DiffUtil$CenteredArray var3_3, int var4_4) {
        var5_5 = var0.oldSize();
        var6_6 = var0.newSize();
        var5_5 = (var5_5 - var6_6) % 2;
        var6_6 = 1;
        var5_5 = var5_5 == 0 ? var6_6 : 0;
        var7_7 = var0.oldSize();
        var8_8 = var0.newSize();
        var7_7 -= var8_8;
        for (var9_9 = var8_8 = -var4_4; var9_9 <= var4_4; var9_9 += 2) {
            if (var9_9 == var8_8) ** GOTO lbl-1000
            if (var9_9 == var4_4) ** GOTO lbl-1000
            var10_10 = var9_9 + 1;
            var10_10 = var3_3.get(var10_10);
            var11_11 = var9_9 + -1;
            if (var10_10 >= (var11_11 = var3_3.get(var11_11))) lbl-1000:
            // 2 sources

            {
                var10_10 = var9_9 + -1;
                var10_10 = var3_3.get(var10_10);
                var11_11 = var10_10 + -1;
            } else lbl-1000:
            // 2 sources

            {
                var10_10 = var9_9 + 1;
                var11_11 = var10_10 = var3_3.get(var10_10);
            }
            var12_12 = var0.newListEnd;
            var13_13 = var0.oldListEnd - var11_11 - var9_9;
            var12_12 -= var13_13;
            var13_13 = var4_4 != 0 && var11_11 == var10_10 ? var12_12 + 1 : var12_12;
            while (var11_11 > (var14_14 = var0.oldListStart) && var12_12 > (var14_14 = var0.newListStart)) {
                var14_14 = var11_11 + -1;
                var15_15 = var12_12 + -1;
                if ((var14_14 = (int)var1_1.areItemsTheSame(var14_14, var15_15)) == 0) break;
                var11_11 += -1;
                var12_12 += -1;
            }
            var3_3.set(var9_9, var11_11);
            if (var5_5 == 0 || (var14_14 = var7_7 - var9_9) < var8_8 || var14_14 > var4_4 || (var14_14 = var2_2.get(var14_14)) < var11_11) continue;
            var0 = new DiffUtil$Snake();
            var0.startX = var11_11;
            var0.startY = var12_12;
            var0.endX = var10_10;
            var0.endY = var13_13;
            var0.reverse = var6_6;
            return var0;
        }
        return null;
    }

    public static DiffUtil$DiffResult calculateDiff(DiffUtil$Callback diffUtil$Callback) {
        return DiffUtil.calculateDiff(diffUtil$Callback, true);
    }

    public static DiffUtil$DiffResult calculateDiff(DiffUtil$Callback diffUtil$Callback, boolean n10) {
        int n11;
        Object object;
        int n12 = diffUtil$Callback.getOldListSize();
        int n13 = diffUtil$Callback.getNewListSize();
        ArrayList<DiffUtil$Diagonal> arrayList = new ArrayList<DiffUtil$Diagonal>();
        Object object2 = new ArrayList();
        int n14 = 0;
        Object object3 = null;
        Object object4 = new DiffUtil$Range(0, n12, 0, n13);
        object2.add(object4);
        n12 = (n12 + n13 + 1) / 2;
        n12 = n12 * 2 + 1;
        DiffUtil$CenteredArray diffUtil$CenteredArray = new DiffUtil$CenteredArray(n12);
        object4 = new DiffUtil$CenteredArray(n12);
        Object object5 = new ArrayList();
        while ((n14 = object2.isEmpty()) == 0) {
            n14 = object2.size() + -1;
            object3 = (DiffUtil$Range)object2.remove(n14);
            object = DiffUtil.midPoint((DiffUtil$Range)object3, diffUtil$Callback, diffUtil$CenteredArray, (DiffUtil$CenteredArray)object4);
            if (object != null) {
                int n15;
                int n16;
                Object object6;
                n11 = ((DiffUtil$Snake)object).diagonalSize();
                if (n11 > 0) {
                    object6 = ((DiffUtil$Snake)object).toDiagonal();
                    arrayList.add((DiffUtil$Diagonal)object6);
                }
                if ((n11 = (int)(object5.isEmpty() ? 1 : 0)) != 0) {
                    object6 = new DiffUtil$Range();
                } else {
                    n11 = object5.size() + -1;
                    object6 = (DiffUtil$Range)object5.remove(n11);
                }
                ((DiffUtil$Range)object6).oldListStart = n16 = ((DiffUtil$Range)object3).oldListStart;
                ((DiffUtil$Range)object6).newListStart = n16 = ((DiffUtil$Range)object3).newListStart;
                ((DiffUtil$Range)object6).oldListEnd = n16 = ((DiffUtil$Snake)object).startX;
                ((DiffUtil$Range)object6).newListEnd = n16 = ((DiffUtil$Snake)object).startY;
                object2.add(object6);
                ((DiffUtil$Range)object3).oldListEnd = n11 = ((DiffUtil$Range)object3).oldListEnd;
                ((DiffUtil$Range)object3).newListEnd = n11 = ((DiffUtil$Range)object3).newListEnd;
                ((DiffUtil$Range)object3).oldListStart = n11 = ((DiffUtil$Snake)object).endX;
                ((DiffUtil$Range)object3).newListStart = n15 = ((DiffUtil$Snake)object).endY;
                object2.add(object3);
                continue;
            }
            object5.add(object3);
        }
        object5 = DIAGONAL_COMPARATOR;
        Collections.sort(arrayList, object5);
        object3 = diffUtil$CenteredArray.backingData();
        object = ((DiffUtil$CenteredArray)object4).backingData();
        object2 = object5;
        object4 = diffUtil$Callback;
        n11 = n10;
        object5 = new DiffUtil$DiffResult(diffUtil$Callback, arrayList, (int[])object3, (int[])object, n10 != 0);
        return object5;
    }

    /*
     * Unable to fully structure code
     */
    private static DiffUtil$Snake forward(DiffUtil$Range var0, DiffUtil$Callback var1_1, DiffUtil$CenteredArray var2_2, DiffUtil$CenteredArray var3_3, int var4_4) {
        var5_5 = var0.oldSize();
        var6_6 = var0.newSize();
        var5_5 = Math.abs(var5_5 - var6_6) % 2;
        var6_6 = 0;
        var7_7 = 1;
        if (var5_5 != var7_7) {
            var7_7 = 0;
        }
        var5_5 = var0.oldSize();
        var8_8 = var0.newSize();
        var5_5 -= var8_8;
        for (var9_9 = var8_8 = -var4_4; var9_9 <= var4_4; var9_9 += 2) {
            if (var9_9 == var8_8) ** GOTO lbl-1000
            if (var9_9 == var4_4) ** GOTO lbl-1000
            var10_10 = var9_9 + 1;
            var10_10 = var2_2.get(var10_10);
            var11_11 = var9_9 + -1;
            if (var10_10 <= (var11_11 = var2_2.get(var11_11))) lbl-1000:
            // 2 sources

            {
                var10_10 = var9_9 + -1;
                var10_10 = var2_2.get(var10_10);
                var11_11 = var10_10 + 1;
            } else lbl-1000:
            // 2 sources

            {
                var10_10 = var9_9 + 1;
                var11_11 = var10_10 = var2_2.get(var10_10);
            }
            var12_12 = var0.newListStart;
            var13_13 = var0.oldListStart;
            var13_13 = var11_11 - var13_13;
            var12_12 = var12_12 + var13_13 - var9_9;
            var13_13 = var4_4 != 0 && var11_11 == var10_10 ? var12_12 + -1 : var12_12;
            while (var11_11 < (var14_14 = var0.oldListEnd) && var12_12 < (var14_14 = var0.newListEnd) && (var14_14 = (int)var1_1.areItemsTheSame(var11_11, var12_12)) != 0) {
                ++var11_11;
                ++var12_12;
            }
            var2_2.set(var9_9, var11_11);
            if (var7_7 == 0 || (var14_14 = var5_5 - var9_9) < (var15_15 = var8_8 + 1) || var14_14 > (var15_15 = var4_4 + -1) || (var14_14 = var3_3.get(var14_14)) > var11_11) continue;
            var0 = new DiffUtil$Snake();
            var0.startX = var10_10;
            var0.startY = var13_13;
            var0.endX = var11_11;
            var0.endY = var12_12;
            var0.reverse = false;
            return var0;
        }
        return null;
    }

    private static DiffUtil$Snake midPoint(DiffUtil$Range diffUtil$Range, DiffUtil$Callback diffUtil$Callback, DiffUtil$CenteredArray diffUtil$CenteredArray, DiffUtil$CenteredArray diffUtil$CenteredArray2) {
        int n10;
        int n11 = diffUtil$Range.oldSize();
        if (n11 >= (n10 = 1) && (n11 = diffUtil$Range.newSize()) >= n10) {
            n11 = diffUtil$Range.oldSize();
            int n12 = diffUtil$Range.newSize();
            n11 = (n11 + n12 + n10) / 2;
            n12 = diffUtil$Range.oldListStart;
            diffUtil$CenteredArray.set(n10, n12);
            n12 = diffUtil$Range.oldListEnd;
            diffUtil$CenteredArray2.set(n10, n12);
            for (n10 = 0; n10 < n11; ++n10) {
                DiffUtil$Snake diffUtil$Snake = DiffUtil.forward(diffUtil$Range, diffUtil$Callback, diffUtil$CenteredArray, diffUtil$CenteredArray2, n10);
                if (diffUtil$Snake != null) {
                    return diffUtil$Snake;
                }
                diffUtil$Snake = DiffUtil.backward(diffUtil$Range, diffUtil$Callback, diffUtil$CenteredArray, diffUtil$CenteredArray2, n10);
                if (diffUtil$Snake == null) continue;
                return diffUtil$Snake;
            }
        }
        return null;
    }
}

