/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public boolean contains(int n10, int n11) {
        int n12;
        int n13 = this.x;
        n10 = n10 >= n13 && n10 < (n13 += (n12 = this.width)) && n11 >= (n10 = this.y) && n11 < (n10 += (n13 = this.height)) ? 1 : 0;
        return n10 != 0;
    }

    public int getCenterX() {
        int n10 = this.x;
        int n11 = this.width;
        return (n10 + n11) / 2;
    }

    public int getCenterY() {
        int n10 = this.y;
        int n11 = this.height;
        return (n10 + n11) / 2;
    }

    public void grow(int n10, int n11) {
        int n12;
        this.x = n12 = this.x - n10;
        this.y = n12 = this.y - n11;
        n12 = this.width;
        this.width = n12 += (n10 *= 2);
        n10 = this.height;
        this.height = n10 += (n11 *= 2);
    }

    public boolean intersects(Rectangle rectangle) {
        int n10;
        int n11;
        int n12 = this.x;
        int n13 = rectangle.x;
        if (n12 >= n13 && n12 < (n13 += (n11 = rectangle.width)) && (n12 = this.y) >= (n13 = rectangle.y) && n12 < (n13 += (n10 = rectangle.height))) {
            n10 = 1;
        } else {
            n10 = 0;
            rectangle = null;
        }
        return n10 != 0;
    }

    public void setBounds(int n10, int n11, int n12, int n13) {
        this.x = n10;
        this.y = n11;
        this.width = n12;
        this.height = n13;
    }
}

