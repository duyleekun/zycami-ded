/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessageLite$1;
import com.google.protobuf.GeneratedMessageLite$ExtendableMessage;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$JavaType;
import java.util.Iterator;
import java.util.Map;

public class GeneratedMessageLite$ExtendableMessage$ExtensionWriter {
    private final Iterator iter;
    private final boolean messageSetWireFormat;
    private Map.Entry next;
    public final /* synthetic */ GeneratedMessageLite$ExtendableMessage this$0;

    private GeneratedMessageLite$ExtendableMessage$ExtensionWriter(GeneratedMessageLite$ExtendableMessage object, boolean bl2) {
        this.this$0 = object;
        this.iter = object = ((GeneratedMessageLite$ExtendableMessage)object).extensions.iterator();
        boolean bl3 = object.hasNext();
        if (bl3) {
            this.next = object = (Map.Entry)object.next();
        }
        this.messageSetWireFormat = bl2;
    }

    public /* synthetic */ GeneratedMessageLite$ExtendableMessage$ExtensionWriter(GeneratedMessageLite$ExtendableMessage generatedMessageLite$ExtendableMessage, boolean bl2, GeneratedMessageLite$1 generatedMessageLite$1) {
        this(generatedMessageLite$ExtendableMessage, bl2);
    }

    public void writeUntil(int n10, CodedOutputStream codedOutputStream) {
        int n11;
        Object object;
        while ((object = this.next) != null && (n11 = ((GeneratedMessageLite$ExtensionDescriptor)(object = (GeneratedMessageLite$ExtensionDescriptor)object.getKey())).getNumber()) < n10) {
            WireFormat$JavaType wireFormat$JavaType;
            Object object2;
            object = (GeneratedMessageLite$ExtensionDescriptor)this.next.getKey();
            boolean bl2 = this.messageSetWireFormat;
            if (bl2 && (object2 = ((GeneratedMessageLite$ExtensionDescriptor)object).getLiteJavaType()) == (wireFormat$JavaType = WireFormat$JavaType.MESSAGE) && !(bl2 = ((GeneratedMessageLite$ExtensionDescriptor)object).isRepeated())) {
                n11 = ((GeneratedMessageLite$ExtensionDescriptor)object).getNumber();
                object2 = (MessageLite)this.next.getValue();
                codedOutputStream.writeMessageSetExtension(n11, (MessageLite)object2);
            } else {
                object2 = this.next.getValue();
                FieldSet.writeField((FieldSet$FieldDescriptorLite)object, object2, codedOutputStream);
            }
            object = this.iter;
            n11 = (int)(object.hasNext() ? 1 : 0);
            if (n11 != 0) {
                this.next = object = (Map.Entry)this.iter.next();
                continue;
            }
            n11 = 0;
            object = null;
            this.next = null;
        }
    }
}

