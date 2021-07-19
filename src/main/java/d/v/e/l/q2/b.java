/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l.q2;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.zhiyun.common.util.gson.AutoValue_GsonValueBean$GsonTypeAdapter;

public abstract class b {
    public static TypeAdapter a(Gson gson) {
        AutoValue_GsonValueBean$GsonTypeAdapter autoValue_GsonValueBean$GsonTypeAdapter = new AutoValue_GsonValueBean$GsonTypeAdapter(gson);
        return autoValue_GsonValueBean$GsonTypeAdapter;
    }
}

