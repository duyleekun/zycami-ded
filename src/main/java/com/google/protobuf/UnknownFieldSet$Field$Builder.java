/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class UnknownFieldSet$Field$Builder {
    private UnknownFieldSet$Field result;

    private UnknownFieldSet$Field$Builder() {
    }

    public static /* synthetic */ UnknownFieldSet$Field$Builder access$300() {
        return UnknownFieldSet$Field$Builder.create();
    }

    private static UnknownFieldSet$Field$Builder create() {
        UnknownFieldSet$Field unknownFieldSet$Field;
        UnknownFieldSet$Field$Builder unknownFieldSet$Field$Builder = new UnknownFieldSet$Field$Builder();
        unknownFieldSet$Field$Builder.result = unknownFieldSet$Field = new UnknownFieldSet$Field(null);
        return unknownFieldSet$Field$Builder;
    }

    public UnknownFieldSet$Field$Builder addFixed32(int n10) {
        Object object = UnknownFieldSet$Field.access$600(this.result);
        if (object == null) {
            object = this.result;
            ArrayList arrayList = new ArrayList();
            UnknownFieldSet$Field.access$602((UnknownFieldSet$Field)object, arrayList);
        }
        object = UnknownFieldSet$Field.access$600(this.result);
        Integer n11 = n10;
        object.add(n11);
        return this;
    }

    public UnknownFieldSet$Field$Builder addFixed64(long l10) {
        Object object = UnknownFieldSet$Field.access$700(this.result);
        if (object == null) {
            object = this.result;
            ArrayList arrayList = new ArrayList();
            UnknownFieldSet$Field.access$702((UnknownFieldSet$Field)object, arrayList);
        }
        object = UnknownFieldSet$Field.access$700(this.result);
        Long l11 = l10;
        object.add(l11);
        return this;
    }

    public UnknownFieldSet$Field$Builder addGroup(UnknownFieldSet unknownFieldSet) {
        Object object = UnknownFieldSet$Field.access$900(this.result);
        if (object == null) {
            object = this.result;
            ArrayList arrayList = new ArrayList();
            UnknownFieldSet$Field.access$902((UnknownFieldSet$Field)object, arrayList);
        }
        UnknownFieldSet$Field.access$900(this.result).add(unknownFieldSet);
        return this;
    }

    public UnknownFieldSet$Field$Builder addLengthDelimited(ByteString byteString) {
        Object object = UnknownFieldSet$Field.access$800(this.result);
        if (object == null) {
            object = this.result;
            ArrayList arrayList = new ArrayList();
            UnknownFieldSet$Field.access$802((UnknownFieldSet$Field)object, arrayList);
        }
        UnknownFieldSet$Field.access$800(this.result).add(byteString);
        return this;
    }

    public UnknownFieldSet$Field$Builder addVarint(long l10) {
        Object object = UnknownFieldSet$Field.access$500(this.result);
        if (object == null) {
            object = this.result;
            ArrayList arrayList = new ArrayList();
            UnknownFieldSet$Field.access$502((UnknownFieldSet$Field)object, arrayList);
        }
        object = UnknownFieldSet$Field.access$500(this.result);
        Long l11 = l10;
        object.add(l11);
        return this;
    }

    public UnknownFieldSet$Field build() {
        List list;
        Object object = UnknownFieldSet$Field.access$500(this.result);
        if (object == null) {
            object = this.result;
            list = Collections.emptyList();
            UnknownFieldSet$Field.access$502((UnknownFieldSet$Field)object, list);
        } else {
            object = this.result;
            list = Collections.unmodifiableList(UnknownFieldSet$Field.access$500((UnknownFieldSet$Field)object));
            UnknownFieldSet$Field.access$502((UnknownFieldSet$Field)object, list);
        }
        object = UnknownFieldSet$Field.access$600(this.result);
        if (object == null) {
            object = this.result;
            list = Collections.emptyList();
            UnknownFieldSet$Field.access$602((UnknownFieldSet$Field)object, list);
        } else {
            object = this.result;
            list = Collections.unmodifiableList(UnknownFieldSet$Field.access$600((UnknownFieldSet$Field)object));
            UnknownFieldSet$Field.access$602((UnknownFieldSet$Field)object, list);
        }
        object = UnknownFieldSet$Field.access$700(this.result);
        if (object == null) {
            object = this.result;
            list = Collections.emptyList();
            UnknownFieldSet$Field.access$702((UnknownFieldSet$Field)object, list);
        } else {
            object = this.result;
            list = Collections.unmodifiableList(UnknownFieldSet$Field.access$700((UnknownFieldSet$Field)object));
            UnknownFieldSet$Field.access$702((UnknownFieldSet$Field)object, list);
        }
        object = UnknownFieldSet$Field.access$800(this.result);
        if (object == null) {
            object = this.result;
            list = Collections.emptyList();
            UnknownFieldSet$Field.access$802((UnknownFieldSet$Field)object, list);
        } else {
            object = this.result;
            list = Collections.unmodifiableList(UnknownFieldSet$Field.access$800((UnknownFieldSet$Field)object));
            UnknownFieldSet$Field.access$802((UnknownFieldSet$Field)object, list);
        }
        object = UnknownFieldSet$Field.access$900(this.result);
        if (object == null) {
            object = this.result;
            list = Collections.emptyList();
            UnknownFieldSet$Field.access$902((UnknownFieldSet$Field)object, list);
        } else {
            object = this.result;
            list = Collections.unmodifiableList(UnknownFieldSet$Field.access$900((UnknownFieldSet$Field)object));
            UnknownFieldSet$Field.access$902((UnknownFieldSet$Field)object, list);
        }
        object = this.result;
        this.result = null;
        return object;
    }

    public UnknownFieldSet$Field$Builder clear() {
        UnknownFieldSet$Field unknownFieldSet$Field;
        this.result = unknownFieldSet$Field = new UnknownFieldSet$Field(null);
        return this;
    }

    public UnknownFieldSet$Field$Builder mergeFrom(UnknownFieldSet$Field object) {
        ArrayList arrayList;
        Object object2 = UnknownFieldSet$Field.access$500((UnknownFieldSet$Field)object);
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            object2 = UnknownFieldSet$Field.access$500(this.result);
            if (object2 == null) {
                object2 = this.result;
                arrayList = new ArrayList();
                UnknownFieldSet$Field.access$502((UnknownFieldSet$Field)object2, arrayList);
            }
            object2 = UnknownFieldSet$Field.access$500(this.result);
            arrayList = UnknownFieldSet$Field.access$500((UnknownFieldSet$Field)object);
            object2.addAll(arrayList);
        }
        if (!(bl2 = (object2 = UnknownFieldSet$Field.access$600((UnknownFieldSet$Field)object)).isEmpty())) {
            object2 = UnknownFieldSet$Field.access$600(this.result);
            if (object2 == null) {
                object2 = this.result;
                arrayList = new ArrayList();
                UnknownFieldSet$Field.access$602((UnknownFieldSet$Field)object2, arrayList);
            }
            object2 = UnknownFieldSet$Field.access$600(this.result);
            arrayList = UnknownFieldSet$Field.access$600((UnknownFieldSet$Field)object);
            object2.addAll(arrayList);
        }
        if (!(bl2 = (object2 = UnknownFieldSet$Field.access$700((UnknownFieldSet$Field)object)).isEmpty())) {
            object2 = UnknownFieldSet$Field.access$700(this.result);
            if (object2 == null) {
                object2 = this.result;
                arrayList = new ArrayList();
                UnknownFieldSet$Field.access$702((UnknownFieldSet$Field)object2, arrayList);
            }
            object2 = UnknownFieldSet$Field.access$700(this.result);
            arrayList = UnknownFieldSet$Field.access$700((UnknownFieldSet$Field)object);
            object2.addAll(arrayList);
        }
        if (!(bl2 = (object2 = UnknownFieldSet$Field.access$800((UnknownFieldSet$Field)object)).isEmpty())) {
            object2 = UnknownFieldSet$Field.access$800(this.result);
            if (object2 == null) {
                object2 = this.result;
                arrayList = new ArrayList();
                UnknownFieldSet$Field.access$802((UnknownFieldSet$Field)object2, arrayList);
            }
            object2 = UnknownFieldSet$Field.access$800(this.result);
            arrayList = UnknownFieldSet$Field.access$800((UnknownFieldSet$Field)object);
            object2.addAll(arrayList);
        }
        if (!(bl2 = (object2 = UnknownFieldSet$Field.access$900((UnknownFieldSet$Field)object)).isEmpty())) {
            object2 = UnknownFieldSet$Field.access$900(this.result);
            if (object2 == null) {
                object2 = this.result;
                arrayList = new ArrayList();
                UnknownFieldSet$Field.access$902((UnknownFieldSet$Field)object2, arrayList);
            }
            object2 = UnknownFieldSet$Field.access$900(this.result);
            object = UnknownFieldSet$Field.access$900((UnknownFieldSet$Field)object);
            object2.addAll(object);
        }
        return this;
    }
}

