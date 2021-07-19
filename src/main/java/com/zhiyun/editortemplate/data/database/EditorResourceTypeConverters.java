/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.editortemplate.data.database;

import android.text.TextUtils;
import com.zhiyun.editorinterface.EditConfig$ResourceType;

public class EditorResourceTypeConverters {
    public static EditConfig$ResourceType stringToType(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return null;
        }
        return EditConfig$ResourceType.valueOf(string2);
    }

    public static String typeToString(EditConfig$ResourceType object) {
        object = object != null ? ((EditConfig$ResourceType)object).getDirName() : "";
        return object;
    }
}

