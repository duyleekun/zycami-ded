/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil$Diagonal;
import java.util.Comparator;

public class DiffUtil$1
implements Comparator {
    public int compare(DiffUtil$Diagonal diffUtil$Diagonal, DiffUtil$Diagonal diffUtil$Diagonal2) {
        int n10 = diffUtil$Diagonal.x;
        int n11 = diffUtil$Diagonal2.x;
        return n10 - n11;
    }
}

