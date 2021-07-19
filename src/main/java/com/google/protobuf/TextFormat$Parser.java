/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageReflection$BuilderAdapter;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$ParseException;
import com.google.protobuf.TextFormat$Parser$Builder;
import com.google.protobuf.TextFormat$Parser$SingularOverwritePolicy;
import com.google.protobuf.TextFormat$Parser$UnknownField;
import com.google.protobuf.TextFormat$Parser$UnknownField$Type;
import com.google.protobuf.TextFormat$Tokenizer;
import com.google.protobuf.TextFormatParseInfoTree$Builder;
import com.google.protobuf.TextFormatParseLocation;
import com.google.protobuf.TypeRegistry;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

public class TextFormat$Parser {
    private static final int BUFFER_SIZE = 4096;
    private final boolean allowUnknownEnumValues;
    private final boolean allowUnknownExtensions;
    private final boolean allowUnknownFields;
    private TextFormatParseInfoTree$Builder parseInfoTreeBuilder;
    private final TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy;
    private final TypeRegistry typeRegistry;

    private TextFormat$Parser(TypeRegistry typeRegistry, boolean bl2, boolean bl3, boolean bl4, TextFormat$Parser$SingularOverwritePolicy textFormat$Parser$SingularOverwritePolicy, TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder) {
        this.typeRegistry = typeRegistry;
        this.allowUnknownFields = bl2;
        this.allowUnknownEnumValues = bl3;
        this.allowUnknownExtensions = bl4;
        this.singularOverwritePolicy = textFormat$Parser$SingularOverwritePolicy;
        this.parseInfoTreeBuilder = textFormatParseInfoTree$Builder;
    }

    public /* synthetic */ TextFormat$Parser(TypeRegistry typeRegistry, boolean bl2, boolean bl3, boolean bl4, TextFormat$Parser$SingularOverwritePolicy textFormat$Parser$SingularOverwritePolicy, TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder, TextFormat$1 textFormat$1) {
        this(typeRegistry, bl2, bl3, bl4, textFormat$Parser$SingularOverwritePolicy, textFormatParseInfoTree$Builder);
    }

    /*
     * WARNING - void declaration
     */
    private void checkUnknownFields(List object) {
        int n10;
        int n11;
        int n12;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return;
        }
        CharSequence charSequence = new StringBuilder("Input contains unknown fields and/or extensions:");
        Object object2 = object.iterator();
        while ((n12 = object2.hasNext()) != 0) {
            Object object3 = (TextFormat$Parser$UnknownField)object2.next();
            n11 = 10;
            ((StringBuilder)charSequence).append((char)n11);
            object3 = ((TextFormat$Parser$UnknownField)object3).message;
            ((StringBuilder)charSequence).append((String)object3);
        }
        boolean bl3 = this.allowUnknownFields;
        if (bl3) {
            object = TextFormat.access$600();
            charSequence = ((StringBuilder)charSequence).toString();
            ((Logger)object).warning((String)charSequence);
            return;
        }
        boolean bl4 = this.allowUnknownExtensions;
        n12 = 1;
        n11 = 0;
        if (bl4) {
            void var8_12;
            block8: {
                boolean bl5;
                object2 = object.iterator();
                n10 = 0;
                while (bl5 = object2.hasNext()) {
                    TextFormat$Parser$UnknownField$Type textFormat$Parser$UnknownField$Type = ((TextFormat$Parser$UnknownField)object2.next()).type;
                    TextFormat$Parser$UnknownField$Type textFormat$Parser$UnknownField$Type2 = TextFormat$Parser$UnknownField$Type.FIELD;
                    if (textFormat$Parser$UnknownField$Type == textFormat$Parser$UnknownField$Type2) {
                        boolean bl6 = false;
                        object2 = null;
                        break block8;
                    }
                    ++n10;
                }
                int n13 = n12;
            }
            if (var8_12 != false) {
                object = TextFormat.access$600();
                charSequence = ((StringBuilder)charSequence).toString();
                ((Logger)object).warning((String)charSequence);
                return;
            }
        } else {
            n10 = 0;
        }
        object = ((TextFormat$Parser$UnknownField)object.get((int)n10)).message.split(":");
        n11 = Integer.parseInt((String)object[0]);
        int n14 = Integer.parseInt((String)object[n12]);
        charSequence = ((StringBuilder)charSequence).toString();
        object2 = new TextFormat$ParseException(n11, n14, (String)charSequence);
        throw object2;
    }

    private Object consumeAnyFieldValue(TextFormat$Tokenizer object, ExtensionRegistry object2, Descriptors$FieldDescriptor object3, TextFormatParseInfoTree$Builder object4, List list) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String string2 = ((TextFormat$Tokenizer)object).consumeIdentifier();
            stringBuilder.append(string2);
            string2 = "]";
            boolean bl2 = ((TextFormat$Tokenizer)object).tryConsume(string2);
            if (bl2) {
                Object object5;
                block9: {
                    boolean bl3;
                    MessageReflection$BuilderAdapter messageReflection$BuilderAdapter;
                    ((TextFormat$Tokenizer)object).tryConsume(":");
                    string2 = "<";
                    bl2 = ((TextFormat$Tokenizer)object).tryConsume(string2);
                    if (bl2) {
                        string2 = ">";
                    } else {
                        ((TextFormat$Tokenizer)object).consume("{");
                        string2 = "}";
                    }
                    object5 = stringBuilder.toString();
                    Object object6 = this.typeRegistry;
                    try {
                        object6 = ((TypeRegistry)object6).getDescriptorForTypeUrl((String)object5);
                        if (object6 == null) break block9;
                        object5 = DynamicMessage.getDefaultInstance((Descriptors$Descriptor)object6).newBuilderForType();
                        messageReflection$BuilderAdapter = new MessageReflection$BuilderAdapter((Message$Builder)object5);
                    }
                    catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Invalid valid type URL. Found: ");
                        ((StringBuilder)object2).append((String)object5);
                        object2 = ((StringBuilder)object2).toString();
                        throw ((TextFormat$Tokenizer)object).parseException((String)object2);
                    }
                    while (!(bl3 = ((TextFormat$Tokenizer)object).tryConsume(string2))) {
                        object6 = this;
                        this.mergeField((TextFormat$Tokenizer)object, (ExtensionRegistry)object2, messageReflection$BuilderAdapter, (TextFormatParseInfoTree$Builder)object4, list);
                    }
                    object = ((Descriptors$FieldDescriptor)object3).getMessageType();
                    object2 = DynamicMessage.getDefaultInstance((Descriptors$Descriptor)object).newBuilderForType();
                    object3 = ((Descriptors$Descriptor)object).findFieldByName("type_url");
                    object4 = stringBuilder.toString();
                    object2.setField((Descriptors$FieldDescriptor)object3, object4);
                    object = ((Descriptors$Descriptor)object).findFieldByName("value");
                    object3 = object5.build().toByteString();
                    object2.setField((Descriptors$FieldDescriptor)object, object3);
                    return object2.build();
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unable to parse Any of type: ");
                ((StringBuilder)object2).append((String)object5);
                ((StringBuilder)object2).append(". Please make sure that the TypeRegistry contains the descriptors for the given types.");
                object2 = ((StringBuilder)object2).toString();
                throw ((TextFormat$Tokenizer)object).parseException((String)object2);
            }
            string2 = "/";
            boolean bl4 = ((TextFormat$Tokenizer)object).tryConsume(string2);
            if (bl4) {
                stringBuilder.append(string2);
                continue;
            }
            string2 = ".";
            bl4 = ((TextFormat$Tokenizer)object).tryConsume(string2);
            if (!bl4) break;
            stringBuilder.append(string2);
        }
        throw ((TextFormat$Tokenizer)object).parseExceptionPreviousToken("Expected a valid type URL.");
    }

    /*
     * Enabled aggressive block sorting
     */
    private void consumeFieldValue(TextFormat$Tokenizer textFormat$Tokenizer, ExtensionRegistry extensionRegistry, MessageReflection$MergeTarget messageReflection$MergeTarget, Descriptors$FieldDescriptor descriptors$FieldDescriptor, ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo, TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder, List list) {
        int n10;
        TextFormat$Parser textFormat$Parser = this;
        MessageReflection$MergeTarget messageReflection$MergeTarget2 = messageReflection$MergeTarget;
        Descriptors$FieldDescriptor descriptors$FieldDescriptor2 = descriptors$FieldDescriptor;
        Object object = extensionRegistry$ExtensionInfo;
        Object object2 = this.singularOverwritePolicy;
        Object object3 = TextFormat$Parser$SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES;
        String string2 = "\".";
        if (object2 == object3 && (n10 = descriptors$FieldDescriptor.isRepeated()) == 0) {
            n10 = messageReflection$MergeTarget.hasField(descriptors$FieldDescriptor);
            if (n10 != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Non-repeated field \"");
                object2 = descriptors$FieldDescriptor.getFullName();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append("\" cannot be overwritten.");
                object = ((StringBuilder)object).toString();
                throw textFormat$Tokenizer.parseExceptionPreviousToken((String)object);
            }
            object2 = descriptors$FieldDescriptor.getContainingOneof();
            if (object2 != null && (n10 = (int)(messageReflection$MergeTarget.hasOneof((Descriptors$OneofDescriptor)(object2 = descriptors$FieldDescriptor.getContainingOneof())) ? 1 : 0)) != 0) {
                object = descriptors$FieldDescriptor.getContainingOneof();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Field \"");
                object3 = descriptors$FieldDescriptor.getFullName();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append("\" is specified along with field \"");
                object3 = messageReflection$MergeTarget.getOneofFieldDescriptor((Descriptors$OneofDescriptor)object).getFullName();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append("\", another member of oneof \"");
                object = ((Descriptors$OneofDescriptor)object).getName();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(string2);
                object = ((StringBuilder)object2).toString();
                throw textFormat$Tokenizer.parseExceptionPreviousToken((String)object);
            }
        }
        object2 = descriptors$FieldDescriptor.getJavaType();
        object3 = Descriptors$FieldDescriptor$JavaType.MESSAGE;
        Object object4 = null;
        if (object2 == object3) {
            object2 = "<";
            n10 = textFormat$Tokenizer.tryConsume((String)object2);
            if (n10 != 0) {
                object2 = ">";
            } else {
                textFormat$Tokenizer.consume("{");
                object2 = "}";
            }
            Object object5 = object2;
            object2 = descriptors$FieldDescriptor.getMessageType().getFullName();
            object3 = "google.protobuf.Any";
            n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n10 != 0 && (n10 = (int)(textFormat$Tokenizer.tryConsume((String)(object2 = "[")) ? 1 : 0)) != 0) {
                object = this;
                object2 = textFormat$Tokenizer;
                object3 = extensionRegistry;
                object4 = descriptors$FieldDescriptor;
                TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder2 = textFormatParseInfoTree$Builder;
                object = this.consumeAnyFieldValue(textFormat$Tokenizer, extensionRegistry, descriptors$FieldDescriptor, textFormatParseInfoTree$Builder, list);
                textFormat$Tokenizer.consume((String)object5);
            } else {
                boolean bl2;
                if (object != null) {
                    object4 = ((ExtensionRegistry$ExtensionInfo)object).defaultInstance;
                }
                MessageReflection$MergeTarget messageReflection$MergeTarget3 = messageReflection$MergeTarget2.newMergeTargetForField(descriptors$FieldDescriptor2, (Message)object4);
                while (!(bl2 = textFormat$Tokenizer.tryConsume((String)object5))) {
                    bl2 = textFormat$Tokenizer.atEnd();
                    if (bl2) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Expected \"");
                        ((StringBuilder)object).append((String)object5);
                        ((StringBuilder)object).append(string2);
                        object = ((StringBuilder)object).toString();
                        throw textFormat$Tokenizer.parseException((String)object);
                    }
                    object = this;
                    object2 = textFormat$Tokenizer;
                    object3 = extensionRegistry;
                    object4 = messageReflection$MergeTarget3;
                    TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder3 = textFormatParseInfoTree$Builder;
                    this.mergeField(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget3, textFormatParseInfoTree$Builder, list);
                }
                object = messageReflection$MergeTarget3.finish();
            }
            object4 = object;
        } else {
            object = TextFormat$1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type;
            object2 = descriptors$FieldDescriptor.getType();
            n10 = ((Enum)object2).ordinal();
            Object object6 = object[n10];
            switch (object6) {
                default: {
                    break;
                }
                case 17: 
                case 18: {
                    object = new RuntimeException("Can't get here.");
                    throw object;
                }
                case 16: {
                    object = descriptors$FieldDescriptor.getEnumType();
                    n10 = (int)(textFormat$Tokenizer.lookingAtInteger() ? 1 : 0);
                    object3 = "Enum type \"";
                    if (n10 != 0) {
                        n10 = textFormat$Tokenizer.consumeInt32();
                        object4 = ((Descriptors$EnumDescriptor)object).findValueByNumber(n10);
                        if (object4 != null) break;
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append((String)object3);
                        String string3 = ((Descriptors$EnumDescriptor)object).getFullName();
                        ((StringBuilder)object4).append(string3);
                        string3 = "\" has no value with number ";
                        ((StringBuilder)object4).append(string3);
                        ((StringBuilder)object4).append(n10);
                        char c10 = '.';
                        ((StringBuilder)object4).append(c10);
                        object4 = ((StringBuilder)object4).toString();
                        boolean bl3 = textFormat$Parser.allowUnknownEnumValues;
                        if (bl3) {
                            TextFormat.access$600().warning((String)object4);
                            return;
                        }
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append((String)object3);
                        object = ((Descriptors$EnumDescriptor)object).getFullName();
                        ((StringBuilder)object4).append((String)object);
                        ((StringBuilder)object4).append(string3);
                        ((StringBuilder)object4).append(n10);
                        ((StringBuilder)object4).append(c10);
                        object = ((StringBuilder)object4).toString();
                        throw textFormat$Tokenizer.parseExceptionPreviousToken((String)object);
                    }
                    object2 = textFormat$Tokenizer.consumeIdentifier();
                    object4 = ((Descriptors$EnumDescriptor)object).findValueByName((String)object2);
                    if (object4 != null) break;
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append((String)object3);
                    object = ((Descriptors$EnumDescriptor)object).getFullName();
                    ((StringBuilder)object4).append((String)object);
                    ((StringBuilder)object4).append("\" has no value named \"");
                    ((StringBuilder)object4).append((String)object2);
                    ((StringBuilder)object4).append(string2);
                    object = ((StringBuilder)object4).toString();
                    n10 = (int)(textFormat$Parser.allowUnknownEnumValues ? 1 : 0);
                    if (n10 == 0) throw textFormat$Tokenizer.parseExceptionPreviousToken((String)object);
                    TextFormat.access$600().warning((String)object);
                    return;
                }
                case 15: {
                    object4 = textFormat$Tokenizer.consumeByteString();
                    break;
                }
                case 14: {
                    object4 = textFormat$Tokenizer.consumeString();
                    break;
                }
                case 12: 
                case 13: {
                    long l10 = textFormat$Tokenizer.consumeUInt64();
                    object4 = l10;
                    break;
                }
                case 10: 
                case 11: {
                    int n11 = textFormat$Tokenizer.consumeUInt32();
                    object4 = n11;
                    break;
                }
                case 9: {
                    double d10 = textFormat$Tokenizer.consumeDouble();
                    object4 = d10;
                    break;
                }
                case 8: {
                    float f10 = textFormat$Tokenizer.consumeFloat();
                    object4 = Float.valueOf(f10);
                    break;
                }
                case 7: {
                    boolean bl4 = textFormat$Tokenizer.consumeBoolean();
                    object4 = bl4;
                    break;
                }
                case 4: 
                case 5: 
                case 6: {
                    long l11 = textFormat$Tokenizer.consumeInt64();
                    object4 = l11;
                    break;
                }
                case 1: 
                case 2: 
                case 3: {
                    int n12 = textFormat$Tokenizer.consumeInt32();
                    object4 = n12;
                }
            }
        }
        boolean bl5 = descriptors$FieldDescriptor.isRepeated();
        if (bl5) {
            messageReflection$MergeTarget2.addRepeatedField(descriptors$FieldDescriptor2, object4);
            return;
        }
        messageReflection$MergeTarget2.setField(descriptors$FieldDescriptor2, object4);
    }

    private void consumeFieldValues(TextFormat$Tokenizer textFormat$Tokenizer, ExtensionRegistry extensionRegistry, MessageReflection$MergeTarget messageReflection$MergeTarget, Descriptors$FieldDescriptor descriptors$FieldDescriptor, ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo, TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder, List list) {
        String string2;
        boolean bl2 = descriptors$FieldDescriptor.isRepeated();
        if (bl2 && (bl2 = textFormat$Tokenizer.tryConsume(string2 = "["))) {
            string2 = "]";
            boolean bl3 = textFormat$Tokenizer.tryConsume(string2);
            if (!bl3) {
                while (true) {
                    this.consumeFieldValue(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, descriptors$FieldDescriptor, extensionRegistry$ExtensionInfo, textFormatParseInfoTree$Builder, list);
                    bl3 = textFormat$Tokenizer.tryConsume(string2);
                    if (!bl3) {
                        String string3 = ",";
                        textFormat$Tokenizer.consume(string3);
                        continue;
                    }
                    break;
                }
            }
        } else {
            this.consumeFieldValue(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, descriptors$FieldDescriptor, extensionRegistry$ExtensionInfo, textFormatParseInfoTree$Builder, list);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void mergeField(TextFormat$Tokenizer textFormat$Tokenizer, ExtensionRegistry extensionRegistry, MessageReflection$MergeTarget messageReflection$MergeTarget, TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder, List list) {
        String string2;
        boolean bl2;
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
        Object object;
        Object object2;
        TextFormat$Tokenizer textFormat$Tokenizer2 = textFormat$Tokenizer;
        TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder2 = textFormatParseInfoTree$Builder;
        List list2 = list;
        int n10 = textFormat$Tokenizer.getLine();
        int n11 = textFormat$Tokenizer.getColumn();
        Descriptors$Descriptor descriptors$Descriptor = messageReflection$MergeTarget.getDescriptorForType();
        String string3 = "[";
        boolean bl3 = textFormat$Tokenizer.tryConsume(string3);
        String string4 = ":\t";
        Object object3 = ".";
        Object object4 = null;
        Object object5 = ":";
        if (bl3) {
            char c10;
            String string5 = textFormat$Tokenizer.consumeIdentifier();
            StringBuilder stringBuilder = new StringBuilder(string5);
            while ((c10 = textFormat$Tokenizer2.tryConsume((String)object3)) != '\u0000') {
                c10 = '.';
                stringBuilder.append(c10);
                String string6 = textFormat$Tokenizer.consumeIdentifier();
                stringBuilder.append(string6);
            }
            object3 = stringBuilder.toString();
            ExtensionRegistry extensionRegistry2 = extensionRegistry;
            object3 = messageReflection$MergeTarget.findExtensionByName(extensionRegistry, (String)object3);
            object2 = "]";
            if (object3 == null) {
                object = new StringBuilder();
                int n12 = textFormat$Tokenizer.getPreviousLine() + 1;
                ((StringBuilder)object).append(n12);
                ((StringBuilder)object).append((String)object5);
                n12 = textFormat$Tokenizer.getPreviousColumn() + 1;
                ((StringBuilder)object).append(n12);
                ((StringBuilder)object).append(string4);
                String string7 = descriptors$Descriptor.getFullName();
                ((StringBuilder)object).append(string7);
                ((StringBuilder)object).append(".[");
                ((StringBuilder)object).append((Object)stringBuilder);
                ((StringBuilder)object).append((String)object2);
                String string8 = ((StringBuilder)object).toString();
                TextFormat$Parser$UnknownField$Type textFormat$Parser$UnknownField$Type = TextFormat$Parser$UnknownField$Type.EXTENSION;
                TextFormat$Parser$UnknownField textFormat$Parser$UnknownField = new TextFormat$Parser$UnknownField(string8, textFormat$Parser$UnknownField$Type);
                list2.add(textFormat$Parser$UnknownField);
            } else {
                Descriptors$Descriptor descriptors$Descriptor2 = ((ExtensionRegistry$ExtensionInfo)object3).descriptor.getContainingType();
                if (descriptors$Descriptor2 != descriptors$Descriptor) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Extension \"");
                    stringBuilder2.append((Object)stringBuilder);
                    stringBuilder2.append("\" does not extend message type \"");
                    String string9 = descriptors$Descriptor.getFullName();
                    stringBuilder2.append(string9);
                    stringBuilder2.append("\".");
                    String string10 = stringBuilder2.toString();
                    throw textFormat$Tokenizer2.parseExceptionPreviousToken(string10);
                }
                object4 = ((ExtensionRegistry$ExtensionInfo)object3).descriptor;
            }
            textFormat$Tokenizer2.consume((String)object2);
            object = object3;
            object2 = object4;
        } else {
            boolean bl4;
            Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
            ExtensionRegistry extensionRegistry3 = extensionRegistry;
            String string11 = textFormat$Tokenizer.consumeIdentifier();
            object2 = descriptors$Descriptor.findFieldByName(string11);
            if (object2 == null) {
                Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type2;
                object2 = Locale.US;
                object2 = string11.toLowerCase((Locale)object2);
                if ((object2 = descriptors$Descriptor.findFieldByName((String)object2)) != null && (object = ((Descriptors$FieldDescriptor)object2).getType()) != (descriptors$FieldDescriptor$Type2 = Descriptors$FieldDescriptor$Type.GROUP)) {
                    object2 = null;
                }
            }
            if (object2 != null && (object = ((Descriptors$FieldDescriptor)object2).getType()) == (descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.GROUP) && !(bl4 = ((String)(object = ((Descriptors$FieldDescriptor)object2).getMessageType().getName())).equals(string11))) {
                object2 = null;
            }
            if (object2 == null) {
                object = new StringBuilder();
                int n13 = textFormat$Tokenizer.getPreviousLine() + 1;
                ((StringBuilder)object).append(n13);
                ((StringBuilder)object).append((String)object5);
                n13 = textFormat$Tokenizer.getPreviousColumn() + 1;
                ((StringBuilder)object).append(n13);
                ((StringBuilder)object).append(string4);
                String string12 = descriptors$Descriptor.getFullName();
                ((StringBuilder)object).append(string12);
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(string11);
                String string13 = ((StringBuilder)object).toString();
                TextFormat$Parser$UnknownField$Type textFormat$Parser$UnknownField$Type = TextFormat$Parser$UnknownField$Type.FIELD;
                TextFormat$Parser$UnknownField textFormat$Parser$UnknownField = new TextFormat$Parser$UnknownField(string13, textFormat$Parser$UnknownField$Type);
                list2.add(textFormat$Parser$UnknownField);
            }
            bl4 = false;
            object = null;
        }
        if (object2 == null) {
            String string14;
            String string15;
            boolean bl5 = textFormat$Tokenizer2.tryConsume((String)object5);
            if (bl5 && !(bl5 = textFormat$Tokenizer2.lookingAt(string15 = "{")) && !(bl5 = textFormat$Tokenizer2.lookingAt(string14 = "<"))) {
                this.skipFieldValue(textFormat$Tokenizer);
                return;
            }
            this.skipFieldMessage(textFormat$Tokenizer);
            return;
        }
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType2 = ((Descriptors$FieldDescriptor)object2).getJavaType();
        if (descriptors$FieldDescriptor$JavaType2 == (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
            textFormat$Tokenizer2.tryConsume((String)object5);
            if (textFormatParseInfoTree$Builder2 != null) {
                TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder3 = textFormatParseInfoTree$Builder2.getBuilderForSubMessageField((Descriptors$FieldDescriptor)object2);
                TextFormat$Parser textFormat$Parser = this;
                TextFormat$Tokenizer textFormat$Tokenizer3 = textFormat$Tokenizer;
                ExtensionRegistry extensionRegistry4 = extensionRegistry;
                object3 = messageReflection$MergeTarget;
                object4 = object2;
                object5 = object;
                TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder4 = textFormatParseInfoTree$Builder3;
                list2 = list;
                this.consumeFieldValues(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, (Descriptors$FieldDescriptor)object2, (ExtensionRegistry$ExtensionInfo)object, textFormatParseInfoTree$Builder3, list);
            } else {
                TextFormat$Parser textFormat$Parser = this;
                TextFormat$Tokenizer textFormat$Tokenizer4 = textFormat$Tokenizer;
                ExtensionRegistry extensionRegistry5 = extensionRegistry;
                object3 = messageReflection$MergeTarget;
                object4 = object2;
                object5 = object;
                TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder5 = textFormatParseInfoTree$Builder;
                list2 = list;
                this.consumeFieldValues(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, (Descriptors$FieldDescriptor)object2, (ExtensionRegistry$ExtensionInfo)object, textFormatParseInfoTree$Builder, list);
            }
        } else {
            textFormat$Tokenizer2.consume((String)object5);
            TextFormat$Parser textFormat$Parser = this;
            TextFormat$Tokenizer textFormat$Tokenizer5 = textFormat$Tokenizer;
            ExtensionRegistry extensionRegistry6 = extensionRegistry;
            object3 = messageReflection$MergeTarget;
            object4 = object2;
            object5 = object;
            TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder6 = textFormatParseInfoTree$Builder;
            list2 = list;
            this.consumeFieldValues(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, (Descriptors$FieldDescriptor)object2, (ExtensionRegistry$ExtensionInfo)object, textFormatParseInfoTree$Builder, list);
        }
        if (textFormatParseInfoTree$Builder2 != null) {
            TextFormatParseLocation textFormatParseLocation = TextFormatParseLocation.create(n10, n11);
            textFormatParseInfoTree$Builder2.setLocation((Descriptors$FieldDescriptor)object2, textFormatParseLocation);
        }
        if (bl2 = textFormat$Tokenizer2.tryConsume(string2 = ";")) return;
        String string16 = ",";
        textFormat$Tokenizer2.tryConsume(string16);
    }

    private void mergeField(TextFormat$Tokenizer textFormat$Tokenizer, ExtensionRegistry extensionRegistry, MessageReflection$MergeTarget messageReflection$MergeTarget, List list) {
        TextFormatParseInfoTree$Builder textFormatParseInfoTree$Builder = this.parseInfoTreeBuilder;
        this.mergeField(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, textFormatParseInfoTree$Builder, list);
    }

    public static TextFormat$Parser$Builder newBuilder() {
        TextFormat$Parser$Builder textFormat$Parser$Builder = new TextFormat$Parser$Builder();
        return textFormat$Parser$Builder;
    }

    private void skipField(TextFormat$Tokenizer textFormat$Tokenizer) {
        String string2 = "[";
        boolean bl2 = textFormat$Tokenizer.tryConsume(string2);
        if (bl2) {
            do {
                textFormat$Tokenizer.consumeIdentifier();
            } while (bl2 = textFormat$Tokenizer.tryConsume(string2 = "."));
            string2 = "]";
            textFormat$Tokenizer.consume(string2);
        } else {
            textFormat$Tokenizer.consumeIdentifier();
        }
        string2 = ":";
        bl2 = textFormat$Tokenizer.tryConsume(string2);
        if (bl2 && !(bl2 = textFormat$Tokenizer.lookingAt(string2 = "<")) && !(bl2 = textFormat$Tokenizer.lookingAt(string2 = "{"))) {
            this.skipFieldValue(textFormat$Tokenizer);
        } else {
            this.skipFieldMessage(textFormat$Tokenizer);
        }
        string2 = ";";
        bl2 = textFormat$Tokenizer.tryConsume(string2);
        if (!bl2) {
            string2 = ",";
            textFormat$Tokenizer.tryConsume(string2);
        }
    }

    private void skipFieldMessage(TextFormat$Tokenizer textFormat$Tokenizer) {
        boolean bl2;
        String string2 = "<";
        boolean bl3 = textFormat$Tokenizer.tryConsume(string2);
        String string3 = ">";
        String string4 = "}";
        if (bl3) {
            string2 = string3;
        } else {
            textFormat$Tokenizer.consume("{");
            string2 = string4;
        }
        while (!(bl2 = textFormat$Tokenizer.lookingAt(string3)) && !(bl2 = textFormat$Tokenizer.lookingAt(string4))) {
            this.skipField(textFormat$Tokenizer);
        }
        textFormat$Tokenizer.consume(string2);
    }

    private void skipFieldValue(TextFormat$Tokenizer textFormat$Tokenizer) {
        boolean bl2 = textFormat$Tokenizer.tryConsumeString();
        if (bl2) {
            while (bl2 = textFormat$Tokenizer.tryConsumeString()) {
            }
            return;
        }
        bl2 = textFormat$Tokenizer.tryConsumeIdentifier();
        if (!(bl2 || (bl2 = textFormat$Tokenizer.tryConsumeInt64()) || (bl2 = textFormat$Tokenizer.tryConsumeUInt64()) || (bl2 = textFormat$Tokenizer.tryConsumeDouble()) || (bl2 = textFormat$Tokenizer.tryConsumeFloat()))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Invalid field value: ");
            String string2 = TextFormat$Tokenizer.access$800(textFormat$Tokenizer);
            charSequence.append(string2);
            charSequence = charSequence.toString();
            throw textFormat$Tokenizer.parseException((String)charSequence);
        }
    }

    private static StringBuilder toStringBuilder(Readable readable) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = 4096;
        CharBuffer charBuffer = CharBuffer.allocate(n10);
        int n11;
        int n12;
        while ((n12 = readable.read(charBuffer)) != (n11 = -1)) {
            charBuffer.flip();
            n11 = 0;
            stringBuilder.append(charBuffer, 0, n12);
        }
        return stringBuilder;
    }

    public void merge(CharSequence object, ExtensionRegistry extensionRegistry, Message$Builder cloneable) {
        boolean bl2 = false;
        TextFormat$Tokenizer textFormat$Tokenizer = new TextFormat$Tokenizer((CharSequence)object, null);
        object = new MessageReflection$BuilderAdapter((Message$Builder)cloneable);
        cloneable = new ArrayList();
        while (!(bl2 = textFormat$Tokenizer.atEnd())) {
            this.mergeField(textFormat$Tokenizer, extensionRegistry, (MessageReflection$MergeTarget)object, (List)((Object)cloneable));
        }
        this.checkUnknownFields((List)((Object)cloneable));
    }

    public void merge(CharSequence charSequence, Message$Builder message$Builder) {
        ExtensionRegistry extensionRegistry = ExtensionRegistry.getEmptyRegistry();
        this.merge(charSequence, extensionRegistry, message$Builder);
    }

    public void merge(Readable object, ExtensionRegistry extensionRegistry, Message$Builder message$Builder) {
        object = TextFormat$Parser.toStringBuilder((Readable)object);
        this.merge((CharSequence)object, extensionRegistry, message$Builder);
    }

    public void merge(Readable readable, Message$Builder message$Builder) {
        ExtensionRegistry extensionRegistry = ExtensionRegistry.getEmptyRegistry();
        this.merge(readable, extensionRegistry, message$Builder);
    }
}

