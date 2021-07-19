/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public class DiffUtil$Range {
    public int newListEnd;
    public int newListStart;
    public int oldListEnd;
    public int oldListStart;

    public DiffUtil$Range() {
    }

    public DiffUtil$Range(int n10, int n11, int n12, int n13) {
        this.oldListStart = n10;
        this.oldListEnd = n11;
        this.newListStart = n12;
        this.newListEnd = n13;
    }

    public int newSize() {
        int n10 = this.newListEnd;
        int n11 = this.newListStart;
        return n10 - n11;
    }

    public int oldSize() {
        int n10 = this.oldListEnd;
        int n11 = this.oldListStart;
        return n10 - n11;
    }
}

