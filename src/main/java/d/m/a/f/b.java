/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.util.Log
 */
package d.m.a.f;

import android.os.Environment;
import android.util.Log;
import java.io.File;

public class b {
    public static String a(String string2) {
        String string3;
        Object object = Environment.getExternalStorageDirectory();
        Object object2 = new File((File)object, string3 = "AAA-gif/testGif");
        boolean bl2 = ((File)object2).exists();
        if (!bl2 && !(bl2 = ((File)object2).mkdirs())) {
            object = "PathUtils";
            string3 = "Failed to create file dir path";
            Log.e((String)object, (String)string3);
        }
        object = new StringBuilder();
        object2 = ((File)object2).getAbsolutePath();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("/");
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
    }
}

