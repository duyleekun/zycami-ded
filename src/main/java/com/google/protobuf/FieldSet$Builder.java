/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$1;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.LazyField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class FieldSet$Builder {
    private SmallSortedMap fields;
    private boolean hasLazyField;
    private boolean hasNestedBuilders;
    private boolean isMutable;

    private FieldSet$Builder() {
        SmallSortedMap smallSortedMap = SmallSortedMap.newFieldMap(16);
        this(smallSortedMap);
    }

    public /* synthetic */ FieldSet$Builder(FieldSet$1 fieldSet$1) {
        this();
    }

    private FieldSet$Builder(SmallSortedMap smallSortedMap) {
        this.fields = smallSortedMap;
        this.isMutable = true;
    }

    private void ensureIsMutable() {
        boolean bl2 = this.isMutable;
        if (!bl2) {
            SmallSortedMap smallSortedMap = this.fields;
            boolean bl3 = true;
            this.fields = smallSortedMap = FieldSet.access$100(smallSortedMap, bl3);
            this.isMutable = bl3;
        }
    }

    public static FieldSet$Builder fromFieldSet(FieldSet fieldSet) {
        boolean bl2;
        SmallSortedMap smallSortedMap = FieldSet.access$100(FieldSet.access$400(fieldSet), true);
        FieldSet$Builder fieldSet$Builder = new FieldSet$Builder(smallSortedMap);
        fieldSet$Builder.hasLazyField = bl2 = FieldSet.access$300(fieldSet);
        return fieldSet$Builder;
    }

    private void mergeFromField(Map.Entry object) {
        FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite = (FieldSet$FieldDescriptorLite)object.getKey();
        boolean bl2 = (object = object.getValue()) instanceof LazyField;
        if (bl2) {
            object = ((LazyField)object).getValue();
        }
        if (bl2 = fieldSet$FieldDescriptorLite.isRepeated()) {
            boolean bl3;
            ArrayList arrayList = this.getField(fieldSet$FieldDescriptorLite);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            object = ((List)object).iterator();
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                List list = arrayList;
                list = arrayList;
                object2 = FieldSet.access$700(object2);
                list.add(object2);
            }
            object = this.fields;
            ((SmallSortedMap)object).put(fieldSet$FieldDescriptorLite, (Object)arrayList);
        } else {
            WireFormat$JavaType wireFormat$JavaType;
            Object object3 = fieldSet$FieldDescriptorLite.getLiteJavaType();
            if (object3 == (wireFormat$JavaType = WireFormat$JavaType.MESSAGE)) {
                object3 = this.getField(fieldSet$FieldDescriptorLite);
                if (object3 == null) {
                    object3 = this.fields;
                    object = FieldSet.access$700(object);
                    ((SmallSortedMap)object3).put(fieldSet$FieldDescriptorLite, object);
                } else {
                    boolean bl4 = object3 instanceof MessageLite$Builder;
                    if (bl4) {
                        object3 = (MessageLite$Builder)object3;
                        object = (MessageLite)object;
                        fieldSet$FieldDescriptorLite.internalMergeFrom((MessageLite$Builder)object3, (MessageLite)object);
                    } else {
                        object3 = ((MessageLite)object3).toBuilder();
                        object = (MessageLite)object;
                        object = fieldSet$FieldDescriptorLite.internalMergeFrom((MessageLite$Builder)object3, (MessageLite)object).build();
                        object3 = this.fields;
                        ((SmallSortedMap)object3).put(fieldSet$FieldDescriptorLite, object);
                    }
                }
            } else {
                object3 = this.fields;
                object = FieldSet.access$700(object);
                ((SmallSortedMap)object3).put(fieldSet$FieldDescriptorLite, object);
            }
        }
    }

    private static Object replaceBuilder(Object object) {
        boolean bl2 = object instanceof MessageLite$Builder;
        if (bl2) {
            object = ((MessageLite$Builder)object).build();
        }
        return object;
    }

    private static Object replaceBuilders(FieldSet$FieldDescriptorLite object, Object object2) {
        Object object3;
        if (object2 == null) {
            return object2;
        }
        Object object4 = object.getLiteJavaType();
        if (object4 == (object3 = WireFormat$JavaType.MESSAGE)) {
            boolean bl2 = object.isRepeated();
            if (bl2) {
                bl2 = object2 instanceof List;
                if (bl2) {
                    int n10;
                    object = object2;
                    object = (List)object2;
                    object4 = null;
                    for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
                        object3 = object.get(i10);
                        Object object5 = FieldSet$Builder.replaceBuilder(object3);
                        if (object5 == object3) continue;
                        if (object == object2) {
                            object3 = new ArrayList(object);
                            object = object3;
                        }
                        object.set(i10, object5);
                    }
                    return object;
                }
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Repeated field should contains a List but actually contains type: ");
                object2 = object2.getClass();
                ((StringBuilder)object4).append(object2);
                object2 = ((StringBuilder)object4).toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
            return FieldSet$Builder.replaceBuilder(object2);
        }
        return object2;
    }

    private static void replaceBuilders(SmallSortedMap object) {
        int n10;
        int n11;
        Map.Entry entry = null;
        for (n11 = 0; n11 < (n10 = ((SmallSortedMap)object).getNumArrayEntries()); ++n11) {
            Map.Entry entry2 = ((SmallSortedMap)object).getArrayEntryAt(n11);
            FieldSet$Builder.replaceBuilders(entry2);
        }
        object = ((SmallSortedMap)object).getOverflowEntries().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            entry = (Map.Entry)object.next();
            FieldSet$Builder.replaceBuilders(entry);
        }
    }

    private static void replaceBuilders(Map.Entry entry) {
        Object object = (FieldSet$FieldDescriptorLite)entry.getKey();
        Object v10 = entry.getValue();
        object = FieldSet$Builder.replaceBuilders((FieldSet$FieldDescriptorLite)object, v10);
        entry.setValue(object);
    }

    private static void verifyType(WireFormat$FieldType object, Object object2) {
        boolean bl2 = FieldSet.access$500((WireFormat$FieldType)((Object)object), object2);
        if (!bl2) {
            boolean bl3;
            WireFormat$JavaType wireFormat$JavaType;
            if ((object = ((WireFormat$FieldType)((Object)object)).getJavaType()) == (wireFormat$JavaType = WireFormat$JavaType.MESSAGE) && (bl3 = object2 instanceof MessageLite$Builder)) {
                return;
            }
            object = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            throw object;
        }
    }

    public void addRepeatedField(FieldSet$FieldDescriptorLite object, Object object2) {
        this.ensureIsMutable();
        boolean bl2 = object.isRepeated();
        if (bl2) {
            ArrayList<Object> arrayList;
            bl2 = this.hasNestedBuilders;
            if (!bl2 && !(bl2 = object2 instanceof MessageLite$Builder)) {
                bl2 = false;
                arrayList = null;
            } else {
                bl2 = true;
            }
            this.hasNestedBuilders = bl2;
            FieldSet$Builder.verifyType(object.getLiteType(), object2);
            arrayList = this.getField((FieldSet$FieldDescriptorLite)object);
            if (arrayList == null) {
                arrayList = new ArrayList<Object>();
                SmallSortedMap smallSortedMap = this.fields;
                smallSortedMap.put((Comparable)object, (Object)arrayList);
            } else {
                arrayList = arrayList;
            }
            arrayList.add(object2);
            return;
        }
        object = new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        throw object;
    }

    public FieldSet build() {
        Object object = this.fields;
        boolean bl2 = ((AbstractMap)object).isEmpty();
        if (bl2) {
            return FieldSet.emptySet();
        }
        bl2 = false;
        object = null;
        this.isMutable = false;
        SmallSortedMap smallSortedMap = this.fields;
        boolean bl3 = this.hasNestedBuilders;
        if (bl3) {
            smallSortedMap = FieldSet.access$100(smallSortedMap, false);
            FieldSet$Builder.replaceBuilders(smallSortedMap);
        }
        object = new FieldSet(smallSortedMap, null);
        boolean bl4 = this.hasLazyField;
        FieldSet.access$302((FieldSet)object, bl4);
        return object;
    }

    public void clearField(FieldSet$FieldDescriptorLite object) {
        this.ensureIsMutable();
        SmallSortedMap smallSortedMap = this.fields;
        smallSortedMap.remove(object);
        object = this.fields;
        boolean bl2 = ((AbstractMap)object).isEmpty();
        if (bl2) {
            bl2 = false;
            object = null;
            this.hasLazyField = false;
        }
    }

    public Map getAllFields() {
        boolean bl2 = this.hasLazyField;
        if (bl2) {
            SmallSortedMap smallSortedMap = FieldSet.access$100(this.fields, false);
            SmallSortedMap smallSortedMap2 = this.fields;
            boolean bl3 = smallSortedMap2.isImmutable();
            if (bl3) {
                smallSortedMap.makeImmutable();
            } else {
                FieldSet$Builder.replaceBuilders(smallSortedMap);
            }
            return smallSortedMap;
        }
        Map map = this.fields;
        bl2 = map.isImmutable();
        map = bl2 ? this.fields : Collections.unmodifiableMap(this.fields);
        return map;
    }

    public Object getField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite) {
        Object object = this.getFieldAllowBuilders(fieldSet$FieldDescriptorLite);
        return FieldSet$Builder.replaceBuilders(fieldSet$FieldDescriptorLite, object);
    }

    public Object getFieldAllowBuilders(FieldSet$FieldDescriptorLite object) {
        SmallSortedMap smallSortedMap = this.fields;
        boolean bl2 = (object = smallSortedMap.get(object)) instanceof LazyField;
        if (bl2) {
            object = ((LazyField)object).getValue();
        }
        return object;
    }

    public Object getRepeatedField(FieldSet$FieldDescriptorLite fieldSet$FieldDescriptorLite, int n10) {
        boolean bl2 = this.hasNestedBuilders;
        if (bl2) {
            this.ensureIsMutable();
        }
        return FieldSet$Builder.replaceBuilder(this.getRepeatedFieldAllowBuilders(fieldSet$FieldDescriptorLite, n10));
    }

    public Object getRepeatedFieldAllowBuilders(FieldSet$FieldDescriptorLite object, int n10) {
        boolean bl2 = object.isRepeated();
        if (bl2) {
            if ((object = this.getFieldAllowBuilders((FieldSet$FieldDescriptorLite)object)) != null) {
                return ((List)object).get(n10);
            }
            object = new IndexOutOfBoundsException();
            throw object;
        }
        object = new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        throw object;
    }

    public int getRepeatedFieldCount(FieldSet$FieldDescriptorLite object) {
        boolean bl2 = object.isRepeated();
        if (bl2) {
            if ((object = this.getField((FieldSet$FieldDescriptorLite)object)) == null) {
                return 0;
            }
            return ((List)object).size();
        }
        object = new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        throw object;
    }

    public boolean hasField(FieldSet$FieldDescriptorLite object) {
        boolean bl2 = object.isRepeated();
        if (!bl2) {
            boolean bl3;
            SmallSortedMap smallSortedMap = this.fields;
            if ((object = smallSortedMap.get(object)) != null) {
                bl3 = true;
            } else {
                bl3 = false;
                object = null;
            }
            return bl3;
        }
        object = new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        throw object;
    }

    public boolean isInitialized() {
        Object object;
        int n10;
        Iterator iterator2 = null;
        for (int i10 = 0; i10 < (n10 = ((SmallSortedMap)(object = this.fields)).getNumArrayEntries()); ++i10) {
            object = this.fields.getArrayEntryAt(i10);
            n10 = (int)(FieldSet.access$600((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        iterator2 = this.fields.getOverflowEntries().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (Map.Entry)iterator2.next();
            n10 = (int)(FieldSet.access$600((Map.Entry)object) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public void mergeFrom(FieldSet object) {
        Object object2;
        int n10;
        int n11;
        this.ensureIsMutable();
        Map.Entry entry = null;
        for (n11 = 0; n11 < (n10 = ((SmallSortedMap)(object2 = FieldSet.access$400((FieldSet)object))).getNumArrayEntries()); ++n11) {
            object2 = FieldSet.access$400((FieldSet)object).getArrayEntryAt(n11);
            this.mergeFromField((Map.Entry)object2);
        }
        object = FieldSet.access$400((FieldSet)object).getOverflowEntries().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            entry = (Map.Entry)object.next();
            this.mergeFromField(entry);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setField(FieldSet$FieldDescriptorLite object, Object object2) {
        this.ensureIsMutable();
        boolean bl2 = object.isRepeated();
        boolean bl3 = false;
        boolean bl4 = true;
        if (!bl2) {
            WireFormat$FieldType wireFormat$FieldType = object.getLiteType();
            FieldSet$Builder.verifyType(wireFormat$FieldType, object2);
        } else {
            boolean bl5;
            bl2 = object2 instanceof List;
            if (!bl2) {
                object = new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                throw object;
            }
            ArrayList arrayList = new ArrayList();
            object2 = (List)object2;
            arrayList.addAll(object2);
            object2 = arrayList.iterator();
            while (bl5 = object2.hasNext()) {
                Object e10 = object2.next();
                WireFormat$FieldType wireFormat$FieldType = object.getLiteType();
                FieldSet$Builder.verifyType(wireFormat$FieldType, e10);
                boolean bl6 = this.hasNestedBuilders;
                if (!bl6 && !(bl5 = e10 instanceof MessageLite$Builder)) {
                    bl5 = false;
                    e10 = null;
                } else {
                    bl5 = bl4;
                }
                this.hasNestedBuilders = bl5;
            }
            object2 = arrayList;
        }
        bl2 = object2 instanceof LazyField;
        if (bl2) {
            this.hasLazyField = bl4;
        }
        if ((bl2 = this.hasNestedBuilders) || (bl2 = object2 instanceof MessageLite$Builder)) {
            bl3 = bl4;
        }
        this.hasNestedBuilders = bl3;
        this.fields.put((Comparable)object, object2);
    }

    public void setRepeatedField(FieldSet$FieldDescriptorLite object, int n10, Object object2) {
        this.ensureIsMutable();
        boolean bl2 = object.isRepeated();
        if (bl2) {
            Object object3;
            bl2 = this.hasNestedBuilders;
            if (!bl2 && !(bl2 = object2 instanceof MessageLite$Builder)) {
                bl2 = false;
                object3 = null;
            } else {
                bl2 = true;
            }
            this.hasNestedBuilders = bl2;
            object3 = this.getField((FieldSet$FieldDescriptorLite)object);
            if (object3 != null) {
                FieldSet$Builder.verifyType(object.getLiteType(), object2);
                ((List)object3).set(n10, object2);
                return;
            }
            object = new IndexOutOfBoundsException();
            throw object;
        }
        object = new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        throw object;
    }
}

