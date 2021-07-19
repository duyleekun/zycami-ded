/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil$Diagonal;

public class DiffUtil$Snake {
    public int endX;
    public int endY;
    public boolean reverse;
    public int startX;
    public int startY;

    public int diagonalSize() {
        int n10 = this.endX;
        int n11 = this.startX;
        n10 -= n11;
        n11 = this.endY;
        int n12 = this.startY;
        return Math.min(n10, n11 -= n12);
    }

    public boolean hasAdditionOrRemoval() {
        int n10 = this.endY;
        int n11 = this.startY;
        n10 -= n11;
        n11 = this.endX;
        int n12 = this.startX;
        n10 = n10 != (n11 -= n12) ? 1 : 0;
        return n10 != 0;
    }

    public boolean isAddition() {
        int n10 = this.endY;
        int n11 = this.startY;
        n10 -= n11;
        n11 = this.endX;
        int n12 = this.startX;
        n10 = n10 > (n11 -= n12) ? 1 : 0;
        return n10 != 0;
    }

    public DiffUtil$Diagonal toDiagonal() {
        boolean bl2 = this.hasAdditionOrRemoval();
        if (bl2) {
            bl2 = this.reverse;
            if (bl2) {
                int n10 = this.startX;
                int n11 = this.startY;
                int n12 = this.diagonalSize();
                DiffUtil$Diagonal diffUtil$Diagonal = new DiffUtil$Diagonal(n10, n11, n12);
                return diffUtil$Diagonal;
            }
            bl2 = this.isAddition();
            if (bl2) {
                int n13 = this.startX;
                int n14 = this.startY + 1;
                int n15 = this.diagonalSize();
                DiffUtil$Diagonal diffUtil$Diagonal = new DiffUtil$Diagonal(n13, n14, n15);
                return diffUtil$Diagonal;
            }
            int n16 = this.startX + 1;
            int n17 = this.startY;
            int n18 = this.diagonalSize();
            DiffUtil$Diagonal diffUtil$Diagonal = new DiffUtil$Diagonal(n16, n17, n18);
            return diffUtil$Diagonal;
        }
        int n19 = this.startX;
        int n20 = this.startY;
        int n21 = this.endX - n19;
        DiffUtil$Diagonal diffUtil$Diagonal = new DiffUtil$Diagonal(n19, n20, n21);
        return diffUtil$Diagonal;
    }
}

