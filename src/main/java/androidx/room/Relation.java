/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.Junction;

public @interface Relation {
    public Junction associateBy();

    public Class entity();

    public String entityColumn();

    public String parentColumn();

    public String[] projection();
}

