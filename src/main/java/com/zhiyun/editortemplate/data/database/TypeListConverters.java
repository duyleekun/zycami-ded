/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database;

import androidx.room.util.StringUtil;
import java.util.Collections;
import java.util.List;

public class TypeListConverters {
    public static String intListToString(List list) {
        return StringUtil.joinIntoString(list);
    }

    public static List stringToIntList(String string2) {
        if (string2 == null) {
            return Collections.emptyList();
        }
        return StringUtil.splitToIntList(string2);
    }
}

