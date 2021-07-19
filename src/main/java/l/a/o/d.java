/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 *  android.text.TextUtils
 */
package l.a.o;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class d {
    private static String a(Context context) {
        boolean bl2;
        String string2;
        Object object = Environment.getExternalStorageState();
        boolean bl3 = ((String)object).equals(string2 = "mounted");
        if (bl3 && (object = context.getExternalCacheDir()) != null && ((bl2 = ((File)object).exists()) || (bl2 = ((File)object).mkdirs()))) {
            return ((File)object).getAbsolutePath();
        }
        return context.getCacheDir().getAbsolutePath();
    }

    public static String b(Context object) {
        String string2;
        File file = new File((String)(object = d.a(object)), string2 = "skins");
        boolean bl2 = file.exists();
        if (!bl2) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static boolean c(String string2) {
        File file;
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && (bl2 = (file = new File(string2)).exists())) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }
}

