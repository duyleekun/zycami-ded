/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.Tags$1;
import com.google.common.flogger.backend.Tags$Type$1;
import com.google.common.flogger.backend.Tags$Type$2;
import com.google.common.flogger.backend.Tags$Type$3;
import com.google.common.flogger.backend.Tags$Type$4;

public abstract class Tags$Type
extends Enum {
    private static final /* synthetic */ Tags$Type[] $VALUES;
    public static final /* enum */ Tags$Type BOOLEAN;
    public static final /* enum */ Tags$Type DOUBLE;
    public static final /* enum */ Tags$Type LONG;
    public static final /* enum */ Tags$Type STRING;

    static {
        Tags$Type$1 tags$Type$1 = new Tags$Type$1();
        BOOLEAN = tags$Type$1;
        int n10 = 1;
        Tags$Type$2 tags$Type$2 = new Tags$Type$2();
        STRING = tags$Type$2;
        int n11 = 2;
        Tags$Type$3 tags$Type$3 = new Tags$Type$3();
        LONG = tags$Type$3;
        int n12 = 3;
        Tags$Type$4 tags$Type$4 = new Tags$Type$4();
        DOUBLE = tags$Type$4;
        Tags$Type[] tags$TypeArray = new Tags$Type[4];
        tags$TypeArray[0] = tags$Type$1;
        tags$TypeArray[n10] = tags$Type$2;
        tags$TypeArray[n11] = tags$Type$3;
        tags$TypeArray[n12] = tags$Type$4;
        $VALUES = tags$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Tags$Type() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ Tags$Type(Tags$1 tags$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static /* synthetic */ Tags$Type access$100(Object object) {
        return Tags$Type.of(object);
    }

    private static Tags$Type of(Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            return STRING;
        }
        bl2 = object instanceof Boolean;
        if (bl2) {
            return BOOLEAN;
        }
        bl2 = object instanceof Long;
        if (bl2) {
            return LONG;
        }
        bl2 = object instanceof Double;
        if (bl2) {
            return DOUBLE;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid tag type: ");
        object = object.getClass();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        AssertionError assertionError = new AssertionError(object);
        throw assertionError;
    }

    public static Tags$Type valueOf(String string2) {
        return Enum.valueOf(Tags$Type.class, string2);
    }

    public static Tags$Type[] values() {
        return (Tags$Type[])$VALUES.clone();
    }

    public abstract int compare(Object var1, Object var2);
}

