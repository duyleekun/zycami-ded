/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$TextGenerator;
import com.google.protobuf.TextFormatEscaper;
import com.google.protobuf.TypeRegistry;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Field;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class TextFormat$Printer {
    private static final TextFormat$Printer DEFAULT;
    private final boolean escapeNonAscii;
    private final TypeRegistry typeRegistry;

    static {
        TextFormat$Printer textFormat$Printer;
        TypeRegistry typeRegistry = TypeRegistry.getEmptyTypeRegistry();
        DEFAULT = textFormat$Printer = new TextFormat$Printer(true, typeRegistry);
    }

    private TextFormat$Printer(boolean bl2, TypeRegistry typeRegistry) {
        this.escapeNonAscii = bl2;
        this.typeRegistry = typeRegistry;
    }

    public static /* synthetic */ void access$000(UnknownFieldSet unknownFieldSet, TextFormat$TextGenerator textGenerator) {
        TextFormat$Printer.printUnknownFields(unknownFieldSet, textGenerator);
    }

    public static /* synthetic */ TextFormat$Printer access$100() {
        return DEFAULT;
    }

    private void print(MessageOrBuilder messageOrBuilder, TextFormat$TextGenerator textGenerator) {
        String string2;
        String string3 = messageOrBuilder.getDescriptorForType().getFullName();
        boolean bl2 = string3.equals(string2 = "google.protobuf.Any");
        if (bl2 && (bl2 = this.printAny(messageOrBuilder, textGenerator))) {
            return;
        }
        this.printMessage(messageOrBuilder, textGenerator);
    }

    private boolean printAny(MessageOrBuilder object, TextFormat$TextGenerator textFormat$TextGenerator) {
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type2;
        Object object2 = object.getDescriptorForType();
        boolean bl2 = true;
        Object object3 = ((Descriptors$Descriptor)object2).findFieldByNumber((int)(bl2 ? 1 : 0));
        object2 = ((Descriptors$Descriptor)object2).findFieldByNumber(2);
        if (object3 != null && (descriptors$FieldDescriptor$Type2 = ((Descriptors$FieldDescriptor)object3).getType()) == (descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.STRING) && object2 != null && (descriptors$FieldDescriptor$Type2 = ((Descriptors$FieldDescriptor)object2).getType()) == (descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.BYTES)) {
            block9: {
                boolean bl3 = ((String)(object3 = (String)object.getField((Descriptors$FieldDescriptor)object3))).isEmpty();
                if (bl3) {
                    return false;
                }
                object = object.getField((Descriptors$FieldDescriptor)object2);
                try {
                    object2 = this.typeRegistry;
                }
                catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
                object2 = ((TypeRegistry)object2).getDescriptorForTypeUrl((String)object3);
                if (object2 != null) break block9;
                return false;
            }
            object2 = DynamicMessage.getDefaultInstance((Descriptors$Descriptor)object2);
            object2 = ((DynamicMessage)object2).newBuilderForType();
            object = (ByteString)object;
            object2.mergeFrom((ByteString)object);
            textFormat$TextGenerator.print("[");
            textFormat$TextGenerator.print((CharSequence)object3);
            textFormat$TextGenerator.print("] {");
            textFormat$TextGenerator.eol();
            textFormat$TextGenerator.indent();
            this.print((MessageOrBuilder)object2, textFormat$TextGenerator);
            textFormat$TextGenerator.outdent();
            textFormat$TextGenerator.print("}");
            textFormat$TextGenerator.eol();
            return bl2;
        }
        return false;
    }

    private void printField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object iterator2, TextFormat$TextGenerator textFormat$TextGenerator) {
        boolean bl2 = descriptors$FieldDescriptor.isRepeated();
        if (bl2) {
            iterator2 = ((List)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                Object e10 = iterator2.next();
                this.printSingleField(descriptors$FieldDescriptor, e10, textFormat$TextGenerator);
            }
        } else {
            this.printSingleField(descriptors$FieldDescriptor, iterator2, textFormat$TextGenerator);
        }
    }

    private void printFieldValue(Descriptors$FieldDescriptor object, Object object2, TextFormat$TextGenerator textFormat$TextGenerator) {
        Object object3 = TextFormat$1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
        object = ((Descriptors$FieldDescriptor)object).getType();
        int n10 = ((Enum)object).ordinal();
        n10 = object3[n10];
        object3 = "\"";
        switch (n10) {
            default: {
                break;
            }
            case 17: 
            case 18: {
                object2 = (Message)object2;
                this.print((MessageOrBuilder)object2, textFormat$TextGenerator);
                break;
            }
            case 16: {
                object2 = (Descriptors$EnumValueDescriptor)object2;
                object = ((Descriptors$EnumValueDescriptor)object2).getName();
                textFormat$TextGenerator.print((CharSequence)object);
                break;
            }
            case 15: {
                textFormat$TextGenerator.print((CharSequence)object3);
                n10 = object2 instanceof ByteString;
                if (n10 != 0) {
                    object2 = (ByteString)object2;
                    object = TextFormat.escapeBytes((ByteString)object2);
                    textFormat$TextGenerator.print((CharSequence)object);
                } else {
                    object2 = (byte[])object2;
                    object = TextFormat.escapeBytes((byte[])object2);
                    textFormat$TextGenerator.print((CharSequence)object);
                }
                textFormat$TextGenerator.print((CharSequence)object3);
                break;
            }
            case 14: {
                textFormat$TextGenerator.print((CharSequence)object3);
                n10 = (int)(this.escapeNonAscii ? 1 : 0);
                if (n10 != 0) {
                    object2 = (String)object2;
                    object = TextFormatEscaper.escapeText((String)object2);
                } else {
                    object = TextFormat.escapeDoubleQuotesAndBackslashes((String)object2);
                    object2 = "\n";
                    String string2 = "\\n";
                    object = ((String)object).replace((CharSequence)object2, string2);
                }
                textFormat$TextGenerator.print((CharSequence)object);
                textFormat$TextGenerator.print((CharSequence)object3);
                break;
            }
            case 12: 
            case 13: {
                object2 = (Long)object2;
                long l10 = (Long)object2;
                object = TextFormat.unsignedToString(l10);
                textFormat$TextGenerator.print((CharSequence)object);
                break;
            }
            case 10: 
            case 11: {
                object2 = (Integer)object2;
                n10 = (Integer)object2;
                object = TextFormat.unsignedToString(n10);
                textFormat$TextGenerator.print((CharSequence)object);
                break;
            }
            case 9: {
                object2 = (Double)object2;
                object = ((Double)object2).toString();
                textFormat$TextGenerator.print((CharSequence)object);
                break;
            }
            case 8: {
                object2 = (Float)object2;
                object = ((Float)object2).toString();
                textFormat$TextGenerator.print((CharSequence)object);
                break;
            }
            case 7: {
                object2 = (Boolean)object2;
                object = ((Boolean)object2).toString();
                textFormat$TextGenerator.print((CharSequence)object);
                break;
            }
            case 4: 
            case 5: 
            case 6: {
                object2 = (Long)object2;
                object = ((Long)object2).toString();
                textFormat$TextGenerator.print((CharSequence)object);
                break;
            }
            case 1: 
            case 2: 
            case 3: {
                object2 = (Integer)object2;
                object = ((Integer)object2).toString();
                textFormat$TextGenerator.print((CharSequence)object);
            }
        }
    }

    private void printMessage(MessageOrBuilder messageOrBuilder, TextFormat$TextGenerator textFormat$TextGenerator) {
        boolean bl2;
        Iterator iterator2 = messageOrBuilder.getAllFields().entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)entry.getKey();
            entry = entry.getValue();
            this.printField(descriptors$FieldDescriptor, entry, textFormat$TextGenerator);
        }
        TextFormat$Printer.printUnknownFields(messageOrBuilder.getUnknownFields(), textFormat$TextGenerator);
    }

    private void printSingleField(Descriptors$FieldDescriptor object, Object object2, TextFormat$TextGenerator textFormat$TextGenerator) {
        Object object3;
        Object object4;
        boolean bl2 = object.isExtension();
        if (bl2) {
            textFormat$TextGenerator.print("[");
            object4 = object.getContainingType().getOptions();
            bl2 = ((DescriptorProtos$MessageOptions)object4).getMessageSetWireFormat();
            if (bl2 && (object4 = object.getType()) == (object3 = Descriptors$FieldDescriptor$Type.MESSAGE) && (bl2 = object.isOptional()) && (object4 = object.getExtensionScope()) == (object3 = object.getMessageType())) {
                object4 = object.getMessageType().getFullName();
                textFormat$TextGenerator.print((CharSequence)object4);
            } else {
                object4 = object.getFullName();
                textFormat$TextGenerator.print((CharSequence)object4);
            }
            object4 = "]";
            textFormat$TextGenerator.print((CharSequence)object4);
        } else {
            object4 = object.getType();
            if (object4 == (object3 = Descriptors$FieldDescriptor$Type.GROUP)) {
                object4 = object.getMessageType().getName();
                textFormat$TextGenerator.print((CharSequence)object4);
            } else {
                object4 = object.getName();
                textFormat$TextGenerator.print((CharSequence)object4);
            }
        }
        object4 = object.getJavaType();
        object3 = Descriptors$FieldDescriptor$JavaType.MESSAGE;
        if (object4 == object3) {
            object4 = " {";
            textFormat$TextGenerator.print((CharSequence)object4);
            textFormat$TextGenerator.eol();
            textFormat$TextGenerator.indent();
        } else {
            object4 = ": ";
            textFormat$TextGenerator.print((CharSequence)object4);
        }
        this.printFieldValue((Descriptors$FieldDescriptor)object, object2, textFormat$TextGenerator);
        object = object.getJavaType();
        if (object == object3) {
            textFormat$TextGenerator.outdent();
            object = "}";
            textFormat$TextGenerator.print((CharSequence)object);
        }
        textFormat$TextGenerator.eol();
    }

    private static void printUnknownField(int n10, int n11, List object, TextFormat$TextGenerator textFormat$TextGenerator) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            String string2 = String.valueOf(n10);
            textFormat$TextGenerator.print(string2);
            string2 = ": ";
            textFormat$TextGenerator.print(string2);
            TextFormat$Printer.printUnknownFieldValue(n11, e10, textFormat$TextGenerator);
            textFormat$TextGenerator.eol();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void printUnknownFieldValue(int n10, Object object, TextFormat$TextGenerator object2) {
        int n11 = WireFormat.getTagWireType(n10);
        if (n11 == 0) {
            object = (Long)object;
            long l10 = (Long)object;
            String string2 = TextFormat.unsignedToString(l10);
            ((TextFormat$TextGenerator)object2).print(string2);
            return;
        }
        int n12 = 1;
        if (n11 == n12) {
            Object[] objectArray = new Object[n12];
            objectArray[0] = object = (Long)object;
            object = "0x%016x";
            String string3 = String.format(null, (String)object, objectArray);
            ((TextFormat$TextGenerator)object2).print(string3);
            return;
        }
        int n13 = 2;
        if (n11 != n13) {
            n13 = 3;
            if (n11 == n13) {
                object = (UnknownFieldSet)object;
                TextFormat$Printer.printUnknownFields((UnknownFieldSet)object, (TextFormat$TextGenerator)object2);
                return;
            }
            n13 = 5;
            if (n11 == n13) {
                Object[] objectArray = new Object[n12];
                objectArray[0] = object = (Integer)object;
                object = "0x%08x";
                String string4 = String.format(null, (String)object, objectArray);
                ((TextFormat$TextGenerator)object2).print(string4);
                return;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Bad tag: ");
            ((StringBuilder)object2).append(n10);
            String string5 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string5);
            throw object;
        }
        Object object3 = object;
        try {
            ByteString byteString = (ByteString)object;
            UnknownFieldSet unknownFieldSet = UnknownFieldSet.parseFrom(byteString);
            String string6 = "{";
            ((TextFormat$TextGenerator)object2).print(string6);
            ((TextFormat$TextGenerator)object2).eol();
            ((TextFormat$TextGenerator)object2).indent();
            TextFormat$Printer.printUnknownFields(unknownFieldSet, (TextFormat$TextGenerator)object2);
            ((TextFormat$TextGenerator)object2).outdent();
            String string7 = "}";
            ((TextFormat$TextGenerator)object2).print(string7);
            return;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            String string8 = "\"";
            ((TextFormat$TextGenerator)object2).print(string8);
            object = TextFormat.escapeBytes((ByteString)object);
            ((TextFormat$TextGenerator)object2).print((CharSequence)object);
            ((TextFormat$TextGenerator)object2).print(string8);
            return;
        }
    }

    private static void printUnknownFields(UnknownFieldSet object, TextFormat$TextGenerator textFormat$TextGenerator) {
        boolean bl2;
        object = ((UnknownFieldSet)object).asMap().entrySet().iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            Map.Entry entry = (Map.Entry)object.next();
            int n10 = (Integer)entry.getKey();
            Object object2 = (UnknownFieldSet$Field)entry.getValue();
            String string2 = null;
            List list = ((UnknownFieldSet$Field)object2).getVarintList();
            TextFormat$Printer.printUnknownField(n10, 0, list, textFormat$TextGenerator);
            list = ((UnknownFieldSet$Field)object2).getFixed32List();
            TextFormat$Printer.printUnknownField(n10, 5, list, textFormat$TextGenerator);
            list = ((UnknownFieldSet$Field)object2).getFixed64List();
            TextFormat$Printer.printUnknownField(n10, 1, list, textFormat$TextGenerator);
            int n11 = 2;
            list = ((UnknownFieldSet$Field)object2).getLengthDelimitedList();
            TextFormat$Printer.printUnknownField(n10, n11, list, textFormat$TextGenerator);
            Iterator iterator2 = ((UnknownFieldSet$Field)object2).getGroupList().iterator();
            while (bl3 = iterator2.hasNext()) {
                object2 = (UnknownFieldSet)iterator2.next();
                string2 = ((Integer)entry.getKey()).toString();
                textFormat$TextGenerator.print(string2);
                string2 = " {";
                textFormat$TextGenerator.print(string2);
                textFormat$TextGenerator.eol();
                textFormat$TextGenerator.indent();
                TextFormat$Printer.printUnknownFields((UnknownFieldSet)object2, textFormat$TextGenerator);
                textFormat$TextGenerator.outdent();
                object2 = "}";
                textFormat$TextGenerator.print((CharSequence)object2);
                textFormat$TextGenerator.eol();
            }
        }
    }

    public TextFormat$Printer escapingNonAscii(boolean bl2) {
        TypeRegistry typeRegistry = this.typeRegistry;
        TextFormat$Printer textFormat$Printer = new TextFormat$Printer(bl2, typeRegistry);
        return textFormat$Printer;
    }

    public void print(MessageOrBuilder messageOrBuilder, Appendable object) {
        object = TextFormat.access$200((Appendable)object);
        this.print(messageOrBuilder, (TextFormat$TextGenerator)object);
    }

    public void print(UnknownFieldSet unknownFieldSet, Appendable object) {
        object = TextFormat.access$200((Appendable)object);
        TextFormat$Printer.printUnknownFields(unknownFieldSet, (TextFormat$TextGenerator)object);
    }

    public void printField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, Appendable object2) {
        object2 = TextFormat.access$200((Appendable)object2);
        this.printField(descriptors$FieldDescriptor, object, (TextFormat$TextGenerator)object2);
    }

    public String printFieldToString(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
        }
        catch (IOException iOException) {
            object = new IllegalStateException(iOException);
            throw object;
        }
        this.printField(descriptors$FieldDescriptor, object, stringBuilder);
        return stringBuilder.toString();
    }

    public void printFieldValue(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, Appendable object2) {
        object2 = TextFormat.access$200((Appendable)object2);
        this.printFieldValue(descriptors$FieldDescriptor, object, (TextFormat$TextGenerator)object2);
    }

    public String printToString(MessageOrBuilder messageOrBuilder) {
        Serializable serializable;
        try {
            serializable = new StringBuilder();
        }
        catch (IOException iOException) {
            serializable = new IllegalStateException(iOException);
            throw serializable;
        }
        this.print(messageOrBuilder, (Appendable)((Object)serializable));
        return ((StringBuilder)serializable).toString();
    }

    public String printToString(UnknownFieldSet unknownFieldSet) {
        Serializable serializable;
        try {
            serializable = new StringBuilder();
        }
        catch (IOException iOException) {
            serializable = new IllegalStateException(iOException);
            throw serializable;
        }
        this.print(unknownFieldSet, (Appendable)((Object)serializable));
        return ((StringBuilder)serializable).toString();
    }

    public String shortDebugString(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        TextFormat$TextGenerator textFormat$TextGenerator;
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            textFormat$TextGenerator = TextFormat.access$300(stringBuilder);
        }
        catch (IOException iOException) {
            object = new IllegalStateException(iOException);
            throw object;
        }
        this.printField(descriptors$FieldDescriptor, object, textFormat$TextGenerator);
        return stringBuilder.toString();
    }

    public String shortDebugString(MessageOrBuilder messageOrBuilder) {
        TextFormat$TextGenerator textFormat$TextGenerator;
        Serializable serializable;
        try {
            serializable = new StringBuilder();
            textFormat$TextGenerator = TextFormat.access$300((Appendable)((Object)serializable));
        }
        catch (IOException iOException) {
            serializable = new IllegalStateException(iOException);
            throw serializable;
        }
        this.print(messageOrBuilder, textFormat$TextGenerator);
        return ((StringBuilder)serializable).toString();
    }

    public String shortDebugString(UnknownFieldSet unknownFieldSet) {
        TextFormat$TextGenerator textFormat$TextGenerator;
        Serializable serializable;
        try {
            serializable = new StringBuilder();
            textFormat$TextGenerator = TextFormat.access$300((Appendable)((Object)serializable));
        }
        catch (IOException iOException) {
            serializable = new IllegalStateException(iOException);
            throw serializable;
        }
        TextFormat$Printer.printUnknownFields(unknownFieldSet, textFormat$TextGenerator);
        return ((StringBuilder)serializable).toString();
    }

    public TextFormat$Printer usingTypeRegistry(TypeRegistry object) {
        Object object2 = this.typeRegistry;
        TypeRegistry typeRegistry = TypeRegistry.getEmptyTypeRegistry();
        if (object2 == typeRegistry) {
            boolean bl2 = this.escapeNonAscii;
            object2 = new TextFormat$Printer(bl2, (TypeRegistry)object);
            return object2;
        }
        object = new IllegalArgumentException("Only one typeRegistry is allowed.");
        throw object;
    }
}

