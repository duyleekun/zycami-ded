/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$MapFieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$OneofAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$RepeatedEnumFieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$RepeatedMessageFieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$SingularEnumFieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$SingularMessageFieldAccessor;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable$SingularStringFieldAccessor;

public final class GeneratedMessageV3$FieldAccessorTable {
    private String[] camelCaseNames;
    private final Descriptors$Descriptor descriptor;
    private final GeneratedMessageV3$FieldAccessorTable$FieldAccessor[] fields;
    private volatile boolean initialized;
    private final GeneratedMessageV3$FieldAccessorTable$OneofAccessor[] oneofs;

    public GeneratedMessageV3$FieldAccessorTable(Descriptors$Descriptor generatedMessageV3$FieldAccessorTable$OneofAccessorArray, String[] objectArray) {
        this.descriptor = generatedMessageV3$FieldAccessorTable$OneofAccessorArray;
        this.camelCaseNames = objectArray;
        objectArray = new GeneratedMessageV3$FieldAccessorTable$FieldAccessor[generatedMessageV3$FieldAccessorTable$OneofAccessorArray.getFields().size()];
        this.fields = objectArray;
        generatedMessageV3$FieldAccessorTable$OneofAccessorArray = new GeneratedMessageV3$FieldAccessorTable$OneofAccessor[generatedMessageV3$FieldAccessorTable$OneofAccessorArray.getOneofs().size()];
        this.oneofs = generatedMessageV3$FieldAccessorTable$OneofAccessorArray;
        this.initialized = false;
    }

    public GeneratedMessageV3$FieldAccessorTable(Descriptors$Descriptor descriptors$Descriptor, String[] stringArray, Class clazz, Class clazz2) {
        this(descriptors$Descriptor, stringArray);
        this.ensureFieldAccessorsInitialized(clazz, clazz2);
    }

    public static /* synthetic */ Descriptors$Descriptor access$000(GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable) {
        return generatedMessageV3$FieldAccessorTable.descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable$OneofAccessor access$100(GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable, Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return generatedMessageV3$FieldAccessorTable.getOneof(descriptors$OneofDescriptor);
    }

    public static /* synthetic */ boolean access$1200(Descriptors$FileDescriptor descriptors$FileDescriptor) {
        return GeneratedMessageV3$FieldAccessorTable.supportFieldPresence(descriptors$FileDescriptor);
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable$FieldAccessor access$200(GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable, Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return generatedMessageV3$FieldAccessorTable.getField(descriptors$FieldDescriptor);
    }

    private GeneratedMessageV3$FieldAccessorTable$FieldAccessor getField(Descriptors$FieldDescriptor object) {
        Descriptors$Descriptor descriptors$Descriptor;
        GeneratedMessageV3$FieldAccessorTable$FieldAccessor[] generatedMessageV3$FieldAccessorTable$FieldAccessorArray = ((Descriptors$FieldDescriptor)object).getContainingType();
        if (generatedMessageV3$FieldAccessorTable$FieldAccessorArray == (descriptors$Descriptor = this.descriptor)) {
            boolean bl2 = ((Descriptors$FieldDescriptor)object).isExtension();
            if (!bl2) {
                generatedMessageV3$FieldAccessorTable$FieldAccessorArray = this.fields;
                int n10 = ((Descriptors$FieldDescriptor)object).getIndex();
                return generatedMessageV3$FieldAccessorTable$FieldAccessorArray[n10];
            }
            object = new IllegalArgumentException("This type does not have extensions.");
            throw object;
        }
        object = new IllegalArgumentException("FieldDescriptor does not match message type.");
        throw object;
    }

    private GeneratedMessageV3$FieldAccessorTable$OneofAccessor getOneof(Descriptors$OneofDescriptor object) {
        Descriptors$Descriptor descriptors$Descriptor;
        GeneratedMessageV3$FieldAccessorTable$OneofAccessor[] generatedMessageV3$FieldAccessorTable$OneofAccessorArray = ((Descriptors$OneofDescriptor)object).getContainingType();
        if (generatedMessageV3$FieldAccessorTable$OneofAccessorArray == (descriptors$Descriptor = this.descriptor)) {
            generatedMessageV3$FieldAccessorTable$OneofAccessorArray = this.oneofs;
            int n10 = ((Descriptors$OneofDescriptor)object).getIndex();
            return generatedMessageV3$FieldAccessorTable$OneofAccessorArray[n10];
        }
        object = new IllegalArgumentException("OneofDescriptor does not match message type.");
        throw object;
    }

    private static boolean supportFieldPresence(Descriptors$FileDescriptor object) {
        boolean bl2;
        Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax;
        if ((object = object.getSyntax()) == (descriptors$FileDescriptor$Syntax = Descriptors$FileDescriptor$Syntax.PROTO2)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public GeneratedMessageV3$FieldAccessorTable ensureFieldAccessorsInitialized(Class clazz, Class clazz2) {
        int n10 = this.initialized;
        if (n10 != 0) {
            return this;
        }
        synchronized (this) {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            n10 = this.initialized;
            if (n10 != 0) {
                return this;
            }
            GeneratedMessageV3$FieldAccessorTable$FieldAccessor[] generatedMessageV3$FieldAccessorTable$FieldAccessorArray = this.fields;
            n10 = generatedMessageV3$FieldAccessorTable$FieldAccessorArray.length;
            int n11 = 0;
            int n12 = 0;
            GeneratedMessageV3$FieldAccessorTable$OneofAccessor[] generatedMessageV3$FieldAccessorTable$OneofAccessorArray = null;
            while (true) {
                block25: {
                    String[] stringArray;
                    Object object5;
                    block26: {
                        boolean bl2 = false;
                        object5 = null;
                        if (n12 >= n10) break;
                        object4 = this.descriptor;
                        object4 = object4.getFields();
                        object4 = object4.get(n12);
                        object3 = object4;
                        object3 = (Descriptors$FieldDescriptor)object4;
                        if ((object4 = ((Descriptors$FieldDescriptor)object3).getContainingOneof()) != null) {
                            object5 = this.camelCaseNames;
                            object4 = ((Descriptors$FieldDescriptor)object3).getContainingOneof();
                            int n13 = object4.getIndex() + n10;
                            object5 = object5[n13];
                        }
                        stringArray = object5;
                        bl2 = ((Descriptors$FieldDescriptor)object3).isRepeated();
                        if (!bl2) break block26;
                        object5 = ((Descriptors$FieldDescriptor)object3).getJavaType();
                        if (object5 == (object4 = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                            bl2 = ((Descriptors$FieldDescriptor)object3).isMapField();
                            if (bl2) {
                                object5 = this.fields;
                                object2 = this.camelCaseNames;
                                object2 = object2[n12];
                                object5[n12] = object4 = new GeneratedMessageV3$FieldAccessorTable$MapFieldAccessor((Descriptors$FieldDescriptor)object3, (String)object2, clazz, clazz2);
                                break block25;
                            } else {
                                object5 = this.fields;
                                object2 = this.camelCaseNames;
                                object2 = object2[n12];
                                object5[n12] = object4 = new GeneratedMessageV3$FieldAccessorTable$RepeatedMessageFieldAccessor((Descriptors$FieldDescriptor)object3, (String)object2, clazz, clazz2);
                            }
                            break block25;
                        } else {
                            object5 = ((Descriptors$FieldDescriptor)object3).getJavaType();
                            if (object5 == (object4 = Descriptors$FieldDescriptor$JavaType.ENUM)) {
                                object5 = this.fields;
                                object2 = this.camelCaseNames;
                                object2 = object2[n12];
                                object5[n12] = object4 = new GeneratedMessageV3$FieldAccessorTable$RepeatedEnumFieldAccessor((Descriptors$FieldDescriptor)object3, (String)object2, clazz, clazz2);
                                break block25;
                            } else {
                                object5 = this.fields;
                                object2 = this.camelCaseNames;
                                object2 = object2[n12];
                                object5[n12] = object4 = new GeneratedMessageV3$FieldAccessorTable$RepeatedFieldAccessor((Descriptors$FieldDescriptor)object3, (String)object2, clazz, clazz2);
                            }
                        }
                        break block25;
                    }
                    object5 = ((Descriptors$FieldDescriptor)object3).getJavaType();
                    if (object5 == (object4 = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                        object5 = this.fields;
                        object2 = this.camelCaseNames;
                        object = object2[n12];
                        object2 = object4;
                        object5[n12] = object4 = new GeneratedMessageV3$FieldAccessorTable$SingularMessageFieldAccessor((Descriptors$FieldDescriptor)object3, (String)object, clazz, clazz2, (String)stringArray);
                    } else {
                        object5 = ((Descriptors$FieldDescriptor)object3).getJavaType();
                        if (object5 == (object4 = Descriptors$FieldDescriptor$JavaType.ENUM)) {
                            object5 = this.fields;
                            object2 = this.camelCaseNames;
                            object = object2[n12];
                            object2 = object4;
                            object5[n12] = object4 = new GeneratedMessageV3$FieldAccessorTable$SingularEnumFieldAccessor((Descriptors$FieldDescriptor)object3, (String)object, clazz, clazz2, (String)stringArray);
                        } else {
                            object5 = ((Descriptors$FieldDescriptor)object3).getJavaType();
                            if (object5 == (object4 = Descriptors$FieldDescriptor$JavaType.STRING)) {
                                object5 = this.fields;
                                object2 = this.camelCaseNames;
                                object = object2[n12];
                                object2 = object4;
                                object5[n12] = object4 = new GeneratedMessageV3$FieldAccessorTable$SingularStringFieldAccessor((Descriptors$FieldDescriptor)object3, (String)object, clazz, clazz2, (String)stringArray);
                            } else {
                                object5 = this.fields;
                                object2 = this.camelCaseNames;
                                object = object2[n12];
                                object2 = object4;
                                object5[n12] = object4 = new GeneratedMessageV3$FieldAccessorTable$SingularFieldAccessor((Descriptors$FieldDescriptor)object3, (String)object, clazz, clazz2, (String)stringArray);
                            }
                        }
                    }
                }
                ++n12;
            }
            generatedMessageV3$FieldAccessorTable$OneofAccessorArray = this.oneofs;
            n12 = generatedMessageV3$FieldAccessorTable$OneofAccessorArray.length;
            while (true) {
                if (n11 >= n12) {
                    boolean bl3;
                    this.initialized = bl3 = true;
                    this.camelCaseNames = null;
                    return this;
                }
                object4 = this.oneofs;
                object3 = this.descriptor;
                object = this.camelCaseNames;
                int n14 = n11 + n10;
                object = object[n14];
                object2 = new GeneratedMessageV3$FieldAccessorTable$OneofAccessor((Descriptors$Descriptor)object3, (String)object, clazz, clazz2);
                object4[n11] = object2;
                ++n11;
            }
        }
    }
}

