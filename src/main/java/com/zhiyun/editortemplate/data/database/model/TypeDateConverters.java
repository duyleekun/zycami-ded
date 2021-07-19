/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model;

import java.sql.Date;

public class TypeDateConverters {
    public static Long dateToTimestamp(Date comparable) {
        if (comparable == null) {
            comparable = null;
        } else {
            long l10 = comparable.getTime();
            comparable = l10;
        }
        return comparable;
    }

    public static Date fromTimestamp(Long comparable) {
        if (comparable == null) {
            comparable = null;
        } else {
            long l10 = comparable;
            Date date = new Date(l10);
            comparable = date;
        }
        return comparable;
    }
}

