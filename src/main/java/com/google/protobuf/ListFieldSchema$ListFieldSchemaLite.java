/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.ListFieldSchema;
import com.google.protobuf.ListFieldSchema$1;
import com.google.protobuf.UnsafeUtil;
import java.util.List;

public final class ListFieldSchema$ListFieldSchemaLite
extends ListFieldSchema {
    private ListFieldSchema$ListFieldSchemaLite() {
        super(null);
    }

    public /* synthetic */ ListFieldSchema$ListFieldSchemaLite(ListFieldSchema$1 listFieldSchema$1) {
        this();
    }

    public static Internal$ProtobufList getProtobufList(Object object, long l10) {
        return (Internal$ProtobufList)UnsafeUtil.getObject(object, l10);
    }

    public void makeImmutableListAt(Object object, long l10) {
        ListFieldSchema$ListFieldSchemaLite.getProtobufList(object, l10).makeImmutable();
    }

    public void mergeListsAt(Object object, Object object2, long l10) {
        Internal$ProtobufList internal$ProtobufList = ListFieldSchema$ListFieldSchemaLite.getProtobufList(object, l10);
        object2 = ListFieldSchema$ListFieldSchemaLite.getProtobufList(object2, l10);
        int n10 = internal$ProtobufList.size();
        int n11 = object2.size();
        if (n10 > 0 && n11 > 0) {
            boolean bl2 = internal$ProtobufList.isModifiable();
            if (!bl2) {
                internal$ProtobufList = internal$ProtobufList.mutableCopyWithCapacity(n11 += n10);
            }
            internal$ProtobufList.addAll(object2);
        }
        if (n10 > 0) {
            object2 = internal$ProtobufList;
        }
        UnsafeUtil.putObject(object, l10, object2);
    }

    public List mutableListAt(Object object, long l10) {
        Internal$ProtobufList internal$ProtobufList = ListFieldSchema$ListFieldSchemaLite.getProtobufList(object, l10);
        int n10 = internal$ProtobufList.isModifiable();
        if (n10 == 0) {
            n10 = internal$ProtobufList.size();
            n10 = n10 == 0 ? 10 : (n10 *= 2);
            internal$ProtobufList = internal$ProtobufList.mutableCopyWithCapacity(n10);
            UnsafeUtil.putObject(object, l10, (Object)internal$ProtobufList);
        }
        return internal$ProtobufList;
    }
}

