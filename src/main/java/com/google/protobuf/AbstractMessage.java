/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessage$BuilderParent;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.TextFormat;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractMessage
extends AbstractMessageLite
implements Message {
    public int memoizedSize = -1;

    private static boolean compareBytes(Object object, Object object2) {
        boolean bl2 = object instanceof byte[];
        if (bl2 && (bl2 = object2 instanceof byte[])) {
            object = (byte[])object;
            object2 = (byte[])object2;
            return Arrays.equals((byte[])object, (byte[])object2);
        }
        object = AbstractMessage.toByteString(object);
        object2 = AbstractMessage.toByteString(object2);
        return ((ByteString)object).equals(object2);
    }

    public static boolean compareFields(Map map, Map map2) {
        int n10;
        int n11 = map.size();
        if (n11 != (n10 = map2.size())) {
            return false;
        }
        Iterator iterator2 = map.keySet().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)iterator2.next();
            boolean bl2 = map2.containsKey(descriptors$FieldDescriptor);
            if (!bl2) {
                return false;
            }
            Object object = map.get(descriptors$FieldDescriptor);
            Object object2 = map2.get(descriptors$FieldDescriptor);
            Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type2 = descriptors$FieldDescriptor.getType();
            if (descriptors$FieldDescriptor$Type2 == (descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.BYTES)) {
                n10 = (int)(descriptors$FieldDescriptor.isRepeated() ? 1 : 0);
                if (n10 != 0) {
                    int n12;
                    object = (List)object;
                    object2 = (List)object2;
                    n10 = object.size();
                    if (n10 != (n12 = object2.size())) {
                        return false;
                    }
                    descriptors$FieldDescriptor = null;
                    for (n10 = 0; n10 < (n12 = object.size()); ++n10) {
                        descriptors$FieldDescriptor$Type2 = object.get(n10);
                        n12 = (int)(AbstractMessage.compareBytes((Object)descriptors$FieldDescriptor$Type2, (Object)(descriptors$FieldDescriptor$Type = object2.get(n10))) ? 1 : 0);
                        if (n12 != 0) continue;
                        return false;
                    }
                    continue;
                }
                n10 = (int)(AbstractMessage.compareBytes(object, object2) ? 1 : 0);
                if (n10 != 0) continue;
                return false;
            }
            n10 = (int)(descriptors$FieldDescriptor.isMapField() ? 1 : 0);
            if (!(n10 != 0 ? (n10 = (int)(AbstractMessage.compareMapField(object, object2) ? 1 : 0)) == 0 : (n10 = (int)(object.equals(object2) ? 1 : 0)) == 0)) continue;
            return false;
        }
        return true;
    }

    private static boolean compareMapField(Object object, Object object2) {
        object = AbstractMessage.convertMapEntryListToMap((List)object);
        object2 = AbstractMessage.convertMapEntryListToMap((List)object2);
        return MapFieldLite.equals((Map)object, (Map)object2);
    }

    private static Map convertMapEntryListToMap(List object) {
        boolean bl2;
        int n10;
        boolean bl3 = object.isEmpty();
        if (bl3) {
            return Collections.emptyMap();
        }
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        object = object.iterator();
        Object object2 = (Message)object.next();
        Descriptors$GenericDescriptor descriptors$GenericDescriptor = object2.getDescriptorForType();
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = descriptors$GenericDescriptor.findFieldByName("key");
        Object object3 = object2.getField((Descriptors$FieldDescriptor)(descriptors$GenericDescriptor = descriptors$GenericDescriptor.findFieldByName("value")));
        boolean bl4 = object3 instanceof Descriptors$EnumValueDescriptor;
        if (bl4) {
            n10 = ((Descriptors$EnumValueDescriptor)object3).getNumber();
            object3 = n10;
        }
        object2 = object2.getField(descriptors$FieldDescriptor);
        hashMap.put(object2, object3);
        while (bl2 = object.hasNext()) {
            object2 = (Message)object.next();
            object3 = object2.getField((Descriptors$FieldDescriptor)descriptors$GenericDescriptor);
            bl4 = object3 instanceof Descriptors$EnumValueDescriptor;
            if (bl4) {
                n10 = ((Descriptors$EnumValueDescriptor)object3).getNumber();
                object3 = n10;
            }
            object2 = object2.getField(descriptors$FieldDescriptor);
            hashMap.put(object2, object3);
        }
        return hashMap;
    }

    /*
     * WARNING - void declaration
     */
    public static int hashBoolean(boolean bl2) {
        void var0_3;
        if (bl2) {
            int n10 = 1231;
        } else {
            int n11 = 1237;
        }
        return (int)var0_3;
    }

    public static int hashEnum(Internal$EnumLite internal$EnumLite) {
        return internal$EnumLite.getNumber();
    }

    public static int hashEnumList(List object) {
        int n10;
        object = object.iterator();
        int n11 = 1;
        while ((n10 = object.hasNext()) != 0) {
            Internal$EnumLite internal$EnumLite = (Internal$EnumLite)object.next();
            n11 *= 31;
            n10 = AbstractMessage.hashEnum(internal$EnumLite);
            n11 += n10;
        }
        return n11;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int hashFields(int n10, Map iterator2) {
        iterator2 = iterator2.entrySet().iterator();
        int n11;
        while ((n11 = iterator2.hasNext()) != 0) {
            Object object = iterator2.next();
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)object.getKey();
            object = object.getValue();
            n10 *= 37;
            int n12 = descriptors$FieldDescriptor.getNumber();
            n10 += n12;
            n12 = (int)(descriptors$FieldDescriptor.isMapField() ? 1 : 0);
            if (n12 != 0) {
                n10 *= 53;
                n11 = AbstractMessage.hashMapField(object);
            } else {
                Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
                Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type2 = descriptors$FieldDescriptor.getType();
                if (descriptors$FieldDescriptor$Type2 != (descriptors$FieldDescriptor$Type = Descriptors$FieldDescriptor$Type.ENUM)) {
                    n10 *= 53;
                    n11 = object.hashCode();
                } else {
                    boolean bl2 = descriptors$FieldDescriptor.isRepeated();
                    if (bl2) {
                        object = (List)object;
                        n10 *= 53;
                        n11 = Internal.hashEnumList((List)object);
                    } else {
                        n10 *= 53;
                        object = (Internal$EnumLite)object;
                        n11 = Internal.hashEnum((Internal$EnumLite)object);
                    }
                }
            }
            n10 += n11;
        }
        return n10;
    }

    public static int hashLong(long l10) {
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }

    private static int hashMapField(Object object) {
        return MapFieldLite.calculateHashCodeForMap(AbstractMessage.convertMapEntryListToMap((List)object));
    }

    private static ByteString toByteString(Object object) {
        boolean bl2 = object instanceof byte[];
        if (bl2) {
            return ByteString.copyFrom((byte[])object);
        }
        return (ByteString)object;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof Message;
        if (!bl4) {
            return false;
        }
        object = (Message)object;
        Object object3 = this.getDescriptorForType();
        if (object3 != (object2 = object.getDescriptorForType())) {
            return false;
        }
        object3 = this.getAllFields();
        bl4 = AbstractMessage.compareFields((Map)object3, (Map)(object2 = object.getAllFields()));
        if (!bl4 || !(bl2 = ((UnknownFieldSet)(object3 = this.getUnknownFields())).equals(object = object.getUnknownFields()))) {
            bl3 = false;
        }
        return bl3;
    }

    public List findInitializationErrors() {
        return MessageReflection.findMissingFields(this);
    }

    public String getInitializationErrorString() {
        return MessageReflection.delimitWithCommas(this.findInitializationErrors());
    }

    public int getMemoizedSerializedSize() {
        return this.memoizedSize;
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor object) {
        object = new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        throw object;
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        Map map = this.getAllFields();
        this.memoizedSize = n10 = MessageReflection.getSerializedSize(this, map);
        return n10;
    }

    public boolean hasOneof(Descriptors$OneofDescriptor object) {
        object = new UnsupportedOperationException("hasOneof() is not implemented.");
        throw object;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 == 0) {
            int n11 = this.getDescriptorForType().hashCode();
            n10 = 779 + n11;
            Object object = this.getAllFields();
            n10 = AbstractMessage.hashFields(n10, (Map)object) * 29;
            object = this.getUnknownFields();
            n11 = ((UnknownFieldSet)object).hashCode();
            this.memoizedHashCode = n10 += n11;
        }
        return n10;
    }

    public boolean isInitialized() {
        return MessageReflection.isInitialized(this);
    }

    public Message$Builder newBuilderForType(AbstractMessage$BuilderParent object) {
        object = new UnsupportedOperationException("Nested builder is not supported for this type.");
        throw object;
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return AbstractMessage$Builder.newUninitializedMessageException(this);
    }

    public void setMemoizedSerializedSize(int n10) {
        this.memoizedSize = n10;
    }

    public final String toString() {
        return TextFormat.printer().printToString(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Map map = this.getAllFields();
        MessageReflection.writeMessageTo(this, map, codedOutputStream, false);
    }
}

