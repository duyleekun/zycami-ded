/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.MoreObjects$1;
import com.google.common.base.MoreObjects$ToStringHelper$ValueHolder;
import com.google.common.base.Preconditions;
import java.util.Arrays;

public final class MoreObjects$ToStringHelper {
    private final String className;
    private final MoreObjects$ToStringHelper$ValueHolder holderHead;
    private MoreObjects$ToStringHelper$ValueHolder holderTail;
    private boolean omitNullValues;

    private MoreObjects$ToStringHelper(String string2) {
        MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder;
        this.holderHead = moreObjects$ToStringHelper$ValueHolder = new MoreObjects$ToStringHelper$ValueHolder(null);
        this.holderTail = moreObjects$ToStringHelper$ValueHolder;
        this.omitNullValues = false;
        this.className = string2 = (String)Preconditions.checkNotNull(string2);
    }

    public /* synthetic */ MoreObjects$ToStringHelper(String string2, MoreObjects$1 moreObjects$1) {
        this(string2);
    }

    private MoreObjects$ToStringHelper$ValueHolder addHolder() {
        MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder;
        this.holderTail.next = moreObjects$ToStringHelper$ValueHolder = new MoreObjects$ToStringHelper$ValueHolder(null);
        this.holderTail = moreObjects$ToStringHelper$ValueHolder;
        return moreObjects$ToStringHelper$ValueHolder;
    }

    private MoreObjects$ToStringHelper addHolder(Object object) {
        this.addHolder().value = object;
        return this;
    }

    private MoreObjects$ToStringHelper addHolder(String string2, Object object) {
        MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder = this.addHolder();
        moreObjects$ToStringHelper$ValueHolder.value = object;
        moreObjects$ToStringHelper$ValueHolder.name = string2 = (String)Preconditions.checkNotNull(string2);
        return this;
    }

    public MoreObjects$ToStringHelper add(String string2, char c10) {
        String string3 = String.valueOf(c10);
        return this.addHolder(string2, string3);
    }

    public MoreObjects$ToStringHelper add(String string2, double d10) {
        String string3 = String.valueOf(d10);
        return this.addHolder(string2, string3);
    }

    public MoreObjects$ToStringHelper add(String string2, float f10) {
        String string3 = String.valueOf(f10);
        return this.addHolder(string2, string3);
    }

    public MoreObjects$ToStringHelper add(String string2, int n10) {
        String string3 = String.valueOf(n10);
        return this.addHolder(string2, string3);
    }

    public MoreObjects$ToStringHelper add(String string2, long l10) {
        String string3 = String.valueOf(l10);
        return this.addHolder(string2, string3);
    }

    public MoreObjects$ToStringHelper add(String string2, Object object) {
        return this.addHolder(string2, object);
    }

    public MoreObjects$ToStringHelper add(String string2, boolean bl2) {
        String string3 = String.valueOf(bl2);
        return this.addHolder(string2, string3);
    }

    public MoreObjects$ToStringHelper addValue(char c10) {
        String string2 = String.valueOf(c10);
        return this.addHolder(string2);
    }

    public MoreObjects$ToStringHelper addValue(double d10) {
        String string2 = String.valueOf(d10);
        return this.addHolder(string2);
    }

    public MoreObjects$ToStringHelper addValue(float f10) {
        String string2 = String.valueOf(f10);
        return this.addHolder(string2);
    }

    public MoreObjects$ToStringHelper addValue(int n10) {
        String string2 = String.valueOf(n10);
        return this.addHolder(string2);
    }

    public MoreObjects$ToStringHelper addValue(long l10) {
        String string2 = String.valueOf(l10);
        return this.addHolder(string2);
    }

    public MoreObjects$ToStringHelper addValue(Object object) {
        return this.addHolder(object);
    }

    public MoreObjects$ToStringHelper addValue(boolean bl2) {
        String string2 = String.valueOf(bl2);
        return this.addHolder(string2);
    }

    public MoreObjects$ToStringHelper omitNullValues() {
        this.omitNullValues = true;
        return this;
    }

    public String toString() {
        boolean bl2 = this.omitNullValues;
        StringBuilder stringBuilder = new StringBuilder(32);
        Object object = this.className;
        stringBuilder.append((String)object);
        char c10 = '{';
        stringBuilder.append(c10);
        object = this.holderHead.next;
        Object object2 = "";
        while (object != null) {
            Object object3 = ((MoreObjects$ToStringHelper$ValueHolder)object).value;
            if (!bl2 || object3 != null) {
                char c11;
                stringBuilder.append((String)object2);
                object2 = ((MoreObjects$ToStringHelper$ValueHolder)object).name;
                if (object2 != null) {
                    stringBuilder.append((String)object2);
                    c11 = '=';
                    stringBuilder.append(c11);
                }
                if (object3 != null && (c11 = (char)(((Class)(object2 = object3.getClass())).isArray() ? 1 : 0)) != '\u0000') {
                    c11 = '\u0001';
                    Object[] objectArray = new Object[c11];
                    objectArray[0] = object3;
                    object3 = Arrays.deepToString(objectArray);
                    int n10 = ((String)object3).length() - c11;
                    stringBuilder.append((CharSequence)object3, (int)c11, n10);
                } else {
                    stringBuilder.append(object3);
                }
                object2 = ", ";
            }
            object = ((MoreObjects$ToStringHelper$ValueHolder)object).next;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

