/*
 * Decompiled with CFR 0.151.
 */
package androidx.annotation;

import androidx.annotation.InspectableProperty$EnumEntry;
import androidx.annotation.InspectableProperty$FlagEntry;
import androidx.annotation.InspectableProperty$ValueType;

public @interface InspectableProperty {
    public int attributeId();

    public InspectableProperty$EnumEntry[] enumMapping();

    public InspectableProperty$FlagEntry[] flagMapping();

    public boolean hasAttributeId();

    public String name();

    public InspectableProperty$ValueType valueType();
}

