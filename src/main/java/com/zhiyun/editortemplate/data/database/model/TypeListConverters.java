/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.editortemplate.data.database.model;

import android.text.TextUtils;
import androidx.room.util.StringUtil;
import d.v.j.e.f.c.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TypeListConverters {
    public static /* synthetic */ Long a(String string2) {
        return Long.parseLong(string2.trim());
    }

    public static String intListToString(List list) {
        return StringUtil.joinIntoString(list);
    }

    public static String longListToString(List object) {
        object = Arrays.toString(object.toArray());
        String string2 = "";
        return ((String)object).replace("[", string2).replace("]", string2).trim();
    }

    public static List stringToIntList(String string2) {
        if (string2 == null) {
            return Collections.emptyList();
        }
        return StringUtil.splitToIntList(string2);
    }

    public static List stringToLongList(String stream) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)((Object)stream));
        if (bl2) {
            return Collections.emptyList();
        }
        stream = Arrays.stream(((String)((Object)stream)).split(","));
        Object object = a.a;
        stream = stream.map(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }
}

