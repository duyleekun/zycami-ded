/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.preference.PreferenceManager
 */
package d.v.e0.oe;

import android.content.Context;
import android.preference.PreferenceManager;
import com.zhiyun.stabilizer.Stabilizer;

public class o {
    public static String a(Context context, Stabilizer object) {
        context = PreferenceManager.getDefaultSharedPreferences((Context)context);
        String string2 = ((Stabilizer)object).F2();
        object = ((Stabilizer)object).M2();
        return context.getString(string2, (String)object);
    }

    public static void b(Context context, Stabilizer object, String string2) {
        context = PreferenceManager.getDefaultSharedPreferences((Context)context).edit();
        object = ((Stabilizer)object).F2();
        context.putString((String)object, string2).apply();
    }
}

