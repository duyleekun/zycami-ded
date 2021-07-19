/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.MetadataKey;
import com.google.common.flogger.backend.Metadata;
import com.google.common.flogger.util.Checks;
import java.util.Arrays;

public final class LogContext$MutableMetadata
extends Metadata {
    private static final int INITIAL_KEY_VALUE_CAPACITY = 4;
    private int keyValueCount;
    private Object[] keyValuePairs;

    public LogContext$MutableMetadata() {
        Object[] objectArray = new Object[8];
        this.keyValuePairs = objectArray;
        this.keyValueCount = 0;
    }

    private int indexOf(MetadataKey metadataKey) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.keyValueCount); ++i10) {
            Object object = this.keyValuePairs;
            int n11 = i10 * 2;
            n10 = (int)((object = object[n11]).equals(metadataKey) ? 1 : 0);
            if (n10 == 0) continue;
            return i10;
        }
        return -1;
    }

    public void addValue(MetadataKey object, Object object2) {
        int n10;
        Object[] objectArray;
        int n11;
        int n12 = object.canRepeat();
        String string2 = "metadata value";
        if (n12 == 0 && (n12 = this.indexOf((MetadataKey)object)) != (n11 = -1)) {
            object = this.keyValuePairs;
            n12 = n12 * 2 + 1;
            object[n12] = object2 = Checks.checkNotNull(object2, string2);
            return;
        }
        n12 = (this.keyValueCount + 1) * 2;
        Object[] objectArray2 = this.keyValuePairs;
        int n13 = objectArray2.length;
        if (n12 > n13) {
            n12 = objectArray2.length * 2;
            this.keyValuePairs = objectArray = Arrays.copyOf(objectArray2, n12);
        }
        objectArray = this.keyValuePairs;
        n11 = this.keyValueCount * 2;
        objectArray[n11] = object = Checks.checkNotNull(object, "metadata key");
        object = this.keyValuePairs;
        n12 = this.keyValueCount * 2 + 1;
        object[n12] = object2 = Checks.checkNotNull(object2, string2);
        this.keyValueCount = n10 = this.keyValueCount + 1;
    }

    public Object findValue(MetadataKey object) {
        int n10;
        int n11 = this.indexOf((MetadataKey)object);
        if (n11 != (n10 = -1)) {
            Object[] objectArray = this.keyValuePairs;
            n11 = n11 * 2 + 1;
            Object object2 = objectArray[n11];
            object = ((MetadataKey)object).cast(object2);
        } else {
            object = null;
        }
        return object;
    }

    public MetadataKey getKey(int n10) {
        int n11 = this.keyValueCount;
        if (n10 < n11) {
            Object[] objectArray = this.keyValuePairs;
            return (MetadataKey)objectArray[n10 *= 2];
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }

    public Object getValue(int n10) {
        int n11 = this.keyValueCount;
        if (n10 < n11) {
            Object[] objectArray = this.keyValuePairs;
            n10 = n10 * 2 + 1;
            return objectArray[n10];
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }

    public void removeAllValues(MetadataKey objectArray) {
        int n10 = this.indexOf((MetadataKey)objectArray);
        if (n10 >= 0) {
            Object[] objectArray2;
            int n11;
            int n12;
            int n13;
            for (n13 = (n10 *= 2) + 2; n13 < (n12 = (n11 = this.keyValueCount) * 2); n13 += 2) {
                Object object;
                Object object2 = this.keyValuePairs[n13];
                n12 = (int)(object2.equals(objectArray) ? 1 : 0);
                if (n12 != 0) continue;
                objectArray2 = this.keyValuePairs;
                objectArray2[n10] = object2;
                n11 = n10 + 1;
                int n14 = n13 + 1;
                objectArray2[n11] = object = objectArray2[n14];
                n10 += 2;
            }
            int n15 = n13 - n10 >> 1;
            this.keyValueCount = n11 -= n15;
            while (n10 < n13) {
                objectArray = this.keyValuePairs;
                n11 = n10 + 1;
                n12 = 0;
                objectArray2 = null;
                objectArray[n10] = null;
                n10 = n11;
            }
        }
    }

    public int size() {
        return this.keyValueCount;
    }

    public String toString() {
        int n10;
        StringBuilder stringBuilder = new StringBuilder("Metadata{");
        for (int i10 = 0; i10 < (n10 = this.size()); ++i10) {
            stringBuilder.append(" '");
            Object object = this.getKey(i10);
            stringBuilder.append(object);
            stringBuilder.append("': ");
            object = this.getValue(i10);
            stringBuilder.append(object);
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}

