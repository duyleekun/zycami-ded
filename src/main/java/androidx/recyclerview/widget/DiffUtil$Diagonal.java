/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public class DiffUtil$Diagonal {
    public final int size;
    public final int x;
    public final int y;

    public DiffUtil$Diagonal(int n10, int n11, int n12) {
        this.x = n10;
        this.y = n11;
        this.size = n12;
    }

    public int endX() {
        int n10 = this.x;
        int n11 = this.size;
        return n10 + n11;
    }

    public int endY() {
        int n10 = this.y;
        int n11 = this.size;
        return n10 + n11;
    }
}

