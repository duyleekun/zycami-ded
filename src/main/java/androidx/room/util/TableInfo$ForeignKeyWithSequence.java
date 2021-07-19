/*
 * Decompiled with CFR 0.151.
 */
package androidx.room.util;

public class TableInfo$ForeignKeyWithSequence
implements Comparable {
    public final String mFrom;
    public final int mId;
    public final int mSequence;
    public final String mTo;

    public TableInfo$ForeignKeyWithSequence(int n10, int n11, String string2, String string3) {
        this.mId = n10;
        this.mSequence = n11;
        this.mFrom = string2;
        this.mTo = string3;
    }

    public int compareTo(TableInfo$ForeignKeyWithSequence tableInfo$ForeignKeyWithSequence) {
        int n10 = this.mId;
        int n11 = tableInfo$ForeignKeyWithSequence.mId;
        if ((n10 -= n11) == 0) {
            n10 = this.mSequence;
            int n12 = tableInfo$ForeignKeyWithSequence.mSequence;
            n10 -= n12;
        }
        return n10;
    }
}

