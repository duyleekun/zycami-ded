/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ListFieldSchema$1;
import com.google.protobuf.ListFieldSchema$ListFieldSchemaFull;
import com.google.protobuf.ListFieldSchema$ListFieldSchemaLite;
import java.util.List;

public abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE;
    private static final ListFieldSchema LITE_INSTANCE;

    static {
        ListFieldSchema listFieldSchema = new ListFieldSchema$ListFieldSchemaFull(null);
        FULL_INSTANCE = listFieldSchema;
        listFieldSchema = new ListFieldSchema$ListFieldSchemaLite(null);
        LITE_INSTANCE = listFieldSchema;
    }

    private ListFieldSchema() {
    }

    public /* synthetic */ ListFieldSchema(ListFieldSchema$1 listFieldSchema$1) {
        this();
    }

    public static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    public static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    public abstract void makeImmutableListAt(Object var1, long var2);

    public abstract void mergeListsAt(Object var1, Object var2, long var3);

    public abstract List mutableListAt(Object var1, long var2);
}

