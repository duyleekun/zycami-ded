/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 */
package l.a.q.g0;

import android.content.Context;
import android.content.res.Resources;

public class o {
    private static int a(Context object, String string2, String string3) {
        Resources resources = object.getResources();
        object = object.getApplicationInfo().packageName;
        return resources.getIdentifier(string2, string3, (String)object);
    }

    public static int b(Context context, String string2) {
        return o.a(context, string2, "string");
    }
}

