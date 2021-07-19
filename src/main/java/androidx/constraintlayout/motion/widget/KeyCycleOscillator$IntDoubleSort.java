/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.widget;

public class KeyCycleOscillator$IntDoubleSort {
    private KeyCycleOscillator$IntDoubleSort() {
    }

    private static int partition(int[] nArray, float[] fArray, int n10, int n11) {
        int n12 = nArray[n11];
        int n13 = n10;
        while (n10 < n11) {
            int n14 = nArray[n10];
            if (n14 <= n12) {
                KeyCycleOscillator$IntDoubleSort.swap(nArray, fArray, n13, n10);
                ++n13;
            }
            ++n10;
        }
        KeyCycleOscillator$IntDoubleSort.swap(nArray, fArray, n13, n11);
        return n13;
    }

    public static void sort(int[] nArray, float[] fArray, int n10, int n11) {
        int n12 = nArray.length + 10;
        int[] nArray2 = new int[n12];
        int n13 = 0;
        nArray2[0] = n11;
        n11 = 1;
        nArray2[n11] = n10;
        n10 = 2;
        while (n10 > 0) {
            int n14;
            n10 += -1;
            n13 = nArray2[n10];
            int n15 = nArray2[n10 += -1];
            if (n13 >= n15) continue;
            int n16 = KeyCycleOscillator$IntDoubleSort.partition(nArray, fArray, n13, n15);
            int n17 = n10 + 1;
            nArray2[n10] = n14 = n16 + -1;
            n10 = n17 + 1;
            nArray2[n17] = n13;
            n13 = n10 + 1;
            nArray2[n10] = n15;
            n10 = n13 + 1;
            nArray2[n13] = n16 += n11;
        }
    }

    private static void swap(int[] nArray, float[] fArray, int n10, int n11) {
        float f10;
        int n12;
        int n13 = nArray[n10];
        nArray[n10] = n12 = nArray[n11];
        nArray[n11] = n13;
        float f11 = fArray[n10];
        fArray[n10] = f10 = fArray[n11];
        fArray[n11] = f11;
    }
}

