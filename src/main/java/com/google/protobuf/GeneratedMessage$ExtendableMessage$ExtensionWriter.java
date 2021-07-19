/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$ExtendableMessage;
import com.google.protobuf.LazyField$LazyEntry;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat$JavaType;
import java.util.Iterator;
import java.util.Map;

public class GeneratedMessage$ExtendableMessage$ExtensionWriter {
    private final Iterator iter;
    private final boolean messageSetWireFormat;
    private Map.Entry next;
    public final /* synthetic */ GeneratedMessage$ExtendableMessage this$0;

    private GeneratedMessage$ExtendableMessage$ExtensionWriter(GeneratedMessage$ExtendableMessage object, boolean bl2) {
        this.this$0 = object;
        this.iter = object = GeneratedMessage$ExtendableMessage.access$600((GeneratedMessage$ExtendableMessage)object).iterator();
        boolean bl3 = object.hasNext();
        if (bl3) {
            this.next = object = (Map.Entry)object.next();
        }
        this.messageSetWireFormat = bl2;
    }

    public /* synthetic */ GeneratedMessage$ExtendableMessage$ExtensionWriter(GeneratedMessage$ExtendableMessage extendableMessage, boolean bl2, GeneratedMessage.1 var3_3) {
        this(extendableMessage, bl2);
    }

    public void writeUntil(int n10, CodedOutputStream codedOutputStream) {
        int n11;
        Object object;
        while ((object = this.next) != null && (n11 = ((Descriptors$FieldDescriptor)(object = (Descriptors$FieldDescriptor)object.getKey())).getNumber()) < n10) {
            WireFormat$JavaType wireFormat$JavaType;
            Object object2;
            object = (Descriptors$FieldDescriptor)this.next.getKey();
            boolean bl2 = this.messageSetWireFormat;
            if (bl2 && (object2 = ((Descriptors$FieldDescriptor)object).getLiteJavaType()) == (wireFormat$JavaType = WireFormat$JavaType.MESSAGE) && !(bl2 = ((Descriptors$FieldDescriptor)object).isRepeated())) {
                object2 = this.next;
                bl2 = object2 instanceof LazyField$LazyEntry;
                if (bl2) {
                    n11 = ((Descriptors$FieldDescriptor)object).getNumber();
                    object2 = ((LazyField$LazyEntry)this.next).getField().toByteString();
                    codedOutputStream.writeRawMessageSetExtension(n11, (ByteString)object2);
                } else {
                    n11 = ((Descriptors$FieldDescriptor)object).getNumber();
                    object2 = (Message)this.next.getValue();
                    codedOutputStream.writeMessageSetExtension(n11, (MessageLite)object2);
                }
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

