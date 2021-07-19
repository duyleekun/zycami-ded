/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

public class ViewDataBinding$IncludedLayouts {
    public final int[][] indexes;
    public final int[][] layoutIds;
    public final String[][] layouts;

    public ViewDataBinding$IncludedLayouts(int n10) {
        Object object = new String[n10][];
        this.layouts = object;
        object = new int[n10][];
        this.indexes = (int[][])object;
        int[][] nArrayArray = new int[n10][];
        this.layoutIds = nArrayArray;
    }

    public void setIncludes(int n10, String[] stringArray, int[] nArray, int[] nArray2) {
        this.layouts[n10] = stringArray;
        this.indexes[n10] = nArray;
        this.layoutIds[n10] = nArray2;
    }
}

