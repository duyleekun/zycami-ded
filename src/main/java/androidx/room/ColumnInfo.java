/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

public @interface ColumnInfo {
    public static final int BINARY = 2;
    public static final int BLOB = 5;
    public static final String INHERIT_FIELD_NAME = "[field-name]";
    public static final int INTEGER = 3;
    public static final int LOCALIZED = 5;
    public static final int NOCASE = 3;
    public static final int REAL = 4;
    public static final int RTRIM = 4;
    public static final int TEXT = 2;
    public static final int UNDEFINED = 1;
    public static final int UNICODE = 6;
    public static final int UNSPECIFIED = 1;
    public static final String VALUE_UNSPECIFIED = "[value-unspecified]";

    public int collate();

    public String defaultValue();

    public boolean index();

    public String name();

    public int typeAffinity();
}

