/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.ForeignKey;
import androidx.room.Index;

public @interface Entity {
    public ForeignKey[] foreignKeys();

    public String[] ignoredColumns();

    public Index[] indices();

    public boolean inheritSuperIndices();

    public String[] primaryKeys();

    public String tableName();
}

