/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public class DiffUtil$PostponedUpdate {
    public int currentPos;
    public int posInOwnerList;
    public boolean removal;

    public DiffUtil$PostponedUpdate(int n10, int n11, boolean bl2) {
        this.posInOwnerList = n10;
        this.currentPos = n11;
        this.removal = bl2;
    }
}

