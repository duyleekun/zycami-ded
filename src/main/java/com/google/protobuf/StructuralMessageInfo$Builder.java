/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.FieldInfo;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtoSyntax;
import com.google.protobuf.StructuralMessageInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StructuralMessageInfo$Builder {
    private int[] checkInitialized = null;
    private Object defaultInstance;
    private final List fields;
    private boolean messageSetWireFormat;
    private ProtoSyntax syntax;
    private boolean wasBuilt;

    public StructuralMessageInfo$Builder() {
        ArrayList arrayList;
        this.fields = arrayList = new ArrayList();
    }

    public StructuralMessageInfo$Builder(int n10) {
        ArrayList arrayList;
        this.fields = arrayList = new ArrayList(n10);
    }

    public StructuralMessageInfo build() {
        boolean bl2 = this.wasBuilt;
        if (!bl2) {
            Object object = this.syntax;
            if (object != null) {
                this.wasBuilt = true;
                Collections.sort(this.fields);
                ProtoSyntax protoSyntax = this.syntax;
                boolean bl3 = this.messageSetWireFormat;
                int[] nArray = this.checkInitialized;
                Object object2 = this.fields;
                FieldInfo[] fieldInfoArray = new FieldInfo[]{};
                object2 = object2.toArray(fieldInfoArray);
                fieldInfoArray = object2;
                fieldInfoArray = object2;
                Object object3 = this.defaultInstance;
                object2 = object;
                object = new StructuralMessageInfo(protoSyntax, bl3, nArray, fieldInfoArray, object3);
                return object;
            }
            object = new IllegalStateException("Must specify a proto syntax");
            throw object;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Builder can only build once");
        throw illegalStateException;
    }

    public void withCheckInitialized(int[] nArray) {
        this.checkInitialized = nArray;
    }

    public void withDefaultInstance(Object object) {
        this.defaultInstance = object;
    }

    public void withField(FieldInfo object) {
        boolean bl2 = this.wasBuilt;
        if (!bl2) {
            this.fields.add(object);
            return;
        }
        object = new IllegalStateException("Builder can only build once");
        throw object;
    }

    public void withMessageSetWireFormat(boolean bl2) {
        this.messageSetWireFormat = bl2;
    }

    public void withSyntax(ProtoSyntax protoSyntax) {
        this.syntax = protoSyntax = (ProtoSyntax)((Object)Internal.checkNotNull((Object)protoSyntax, "syntax"));
    }
}

