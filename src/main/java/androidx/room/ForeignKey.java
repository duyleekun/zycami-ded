/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

public @interface ForeignKey {
    public static final int CASCADE = 5;
    public static final int NO_ACTION = 1;
    public static final int RESTRICT = 2;
    public static final int SET_DEFAULT = 4;
    public static final int SET_NULL = 3;

    public String[] childColumns();

    public boolean deferred();

    public Class entity();

    public int onDelete();

    public int onUpdate();

    public String[] parentColumns();
}

