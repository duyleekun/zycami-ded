/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.backend;

import com.google.common.flogger.backend.Tags$Type;
import java.util.Comparator;

public class Tags$1
implements Comparator {
    public int compare(Object object, Object object2) {
        Tags$Type tags$Type;
        Tags$Type tags$Type2 = Tags$Type.access$100(object);
        int n10 = tags$Type2 == (tags$Type = Tags$Type.access$100(object2)) ? tags$Type2.compare(object, object2) : tags$Type2.compareTo(tags$Type);
        return n10;
    }
}

