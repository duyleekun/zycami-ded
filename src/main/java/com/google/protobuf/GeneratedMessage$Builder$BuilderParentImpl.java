/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;

public class GeneratedMessage$Builder$BuilderParentImpl
implements GeneratedMessage$BuilderParent {
    public final /* synthetic */ GeneratedMessage$Builder this$0;

    private GeneratedMessage$Builder$BuilderParentImpl(GeneratedMessage$Builder generatedMessage$Builder) {
        this.this$0 = generatedMessage$Builder;
    }

    public /* synthetic */ GeneratedMessage$Builder$BuilderParentImpl(GeneratedMessage$Builder generatedMessage$Builder, GeneratedMessage$1 generatedMessage$1) {
        this(generatedMessage$Builder);
    }

    public void markDirty() {
        this.this$0.onChanged();
    }
}

