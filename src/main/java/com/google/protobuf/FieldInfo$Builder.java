/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.FieldInfo;
import com.google.protobuf.FieldInfo$1;
import com.google.protobuf.FieldType;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$EnumVerifier;
import com.google.protobuf.OneofInfo;
import java.lang.reflect.Field;

public final class FieldInfo$Builder {
    private Field cachedSizeField;
    private boolean enforceUtf8;
    private Internal$EnumVerifier enumVerifier;
    private Field field;
    private int fieldNumber;
    private Object mapDefaultEntry;
    private OneofInfo oneof;
    private Class oneofStoredType;
    private Field presenceField;
    private int presenceMask;
    private boolean required;
    private FieldType type;

    private FieldInfo$Builder() {
    }

    public /* synthetic */ FieldInfo$Builder(FieldInfo$1 fieldInfo$1) {
        this();
    }

    public FieldInfo build() {
        Object object = this.oneof;
        if (object != null) {
            int n10 = this.fieldNumber;
            FieldType fieldType = this.type;
            Class clazz = this.oneofStoredType;
            boolean bl2 = this.enforceUtf8;
            Internal$EnumVerifier internal$EnumVerifier = this.enumVerifier;
            return FieldInfo.forOneofMemberField(n10, fieldType, (OneofInfo)object, clazz, bl2, internal$EnumVerifier);
        }
        Object object2 = this.mapDefaultEntry;
        if (object2 != null) {
            Field field = this.field;
            int n11 = this.fieldNumber;
            Internal$EnumVerifier internal$EnumVerifier = this.enumVerifier;
            return FieldInfo.forMapField(field, n11, object2, internal$EnumVerifier);
        }
        Object object3 = this.presenceField;
        if (object3 != null) {
            boolean bl3 = this.required;
            if (bl3) {
                Field field = this.field;
                int n12 = this.fieldNumber;
                FieldType fieldType = this.type;
                int n13 = this.presenceMask;
                boolean bl4 = this.enforceUtf8;
                Internal$EnumVerifier internal$EnumVerifier = this.enumVerifier;
                return FieldInfo.forProto2RequiredField(field, n12, fieldType, object3, n13, bl4, internal$EnumVerifier);
            }
            Field field = this.field;
            int n14 = this.fieldNumber;
            FieldType fieldType = this.type;
            int n15 = this.presenceMask;
            boolean bl5 = this.enforceUtf8;
            Internal$EnumVerifier internal$EnumVerifier = this.enumVerifier;
            return FieldInfo.forProto2OptionalField(field, n14, fieldType, object3, n15, bl5, internal$EnumVerifier);
        }
        object2 = this.enumVerifier;
        if (object2 != null) {
            Field field = this.cachedSizeField;
            if (field == null) {
                field = this.field;
                int n16 = this.fieldNumber;
                FieldType fieldType = this.type;
                return FieldInfo.forFieldWithEnumVerifier(field, n16, fieldType, (Internal$EnumVerifier)object2);
            }
            object = this.field;
            int n17 = this.fieldNumber;
            object3 = this.type;
            return FieldInfo.forPackedFieldWithEnumVerifier((Field)object, n17, (FieldType)((Object)object3), (Internal$EnumVerifier)object2, field);
        }
        object2 = this.cachedSizeField;
        if (object2 == null) {
            object2 = this.field;
            int n18 = this.fieldNumber;
            object = this.type;
            boolean bl6 = this.enforceUtf8;
            return FieldInfo.forField((Field)object2, n18, (FieldType)((Object)object), bl6);
        }
        Field field = this.field;
        int n19 = this.fieldNumber;
        FieldType fieldType = this.type;
        return FieldInfo.forPackedField(field, n19, fieldType, (Field)object2);
    }

    public FieldInfo$Builder withCachedSizeField(Field field) {
        this.cachedSizeField = field;
        return this;
    }

    public FieldInfo$Builder withEnforceUtf8(boolean bl2) {
        this.enforceUtf8 = bl2;
        return this;
    }

    public FieldInfo$Builder withEnumVerifier(Internal$EnumVerifier internal$EnumVerifier) {
        this.enumVerifier = internal$EnumVerifier;
        return this;
    }

    public FieldInfo$Builder withField(Field object) {
        OneofInfo oneofInfo = this.oneof;
        if (oneofInfo == null) {
            this.field = object;
            return this;
        }
        object = new IllegalStateException("Cannot set field when building a oneof.");
        throw object;
    }

    public FieldInfo$Builder withFieldNumber(int n10) {
        this.fieldNumber = n10;
        return this;
    }

    public FieldInfo$Builder withMapDefaultEntry(Object object) {
        this.mapDefaultEntry = object;
        return this;
    }

    public FieldInfo$Builder withOneof(OneofInfo object, Class clazz) {
        Field field = this.field;
        if (field == null && (field = this.presenceField) == null) {
            this.oneof = object;
            this.oneofStoredType = clazz;
            return this;
        }
        object = new IllegalStateException("Cannot set oneof when field or presenceField have been provided");
        throw object;
    }

    public FieldInfo$Builder withPresence(Field field, int n10) {
        this.presenceField = field = (Field)Internal.checkNotNull(field, "presenceField");
        this.presenceMask = n10;
        return this;
    }

    public FieldInfo$Builder withRequired(boolean bl2) {
        this.required = bl2;
        return this;
    }

    public FieldInfo$Builder withType(FieldType fieldType) {
        this.type = fieldType;
        return this;
    }
}

