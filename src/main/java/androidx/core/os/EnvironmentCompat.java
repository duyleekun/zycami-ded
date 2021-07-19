/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.util.Log
 */
package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    private EnvironmentCompat() {
    }

    public static String getStorageState(File object) {
        block8: {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 >= n11) {
                return Environment.getExternalStorageState((File)object);
            }
            n11 = 19;
            if (n10 >= n11) {
                return Environment.getStorageState((File)object);
            }
            object = ((File)object).getCanonicalPath();
            Object object2 = Environment.getExternalStorageDirectory();
            object2 = ((File)object2).getCanonicalPath();
            boolean bl2 = ((String)object).startsWith((String)object2);
            if (!bl2) break block8;
            try {
                return Environment.getExternalStorageState();
            }
            catch (IOException iOException) {
                object2 = new StringBuilder();
                String string2 = "Failed to resolve canonical path: ";
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(iOException);
                String string3 = ((StringBuilder)object2).toString();
                object2 = TAG;
                Log.w((String)object2, (String)string3);
            }
        }
        return MEDIA_UNKNOWN;
    }
}

