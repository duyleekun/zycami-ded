/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 */
package d.v.e.l;

import android.content.Context;
import android.os.Environment;
import d.v.e.f;
import d.v.e.l.s1;
import java.io.File;

public class i1 {
    public static void a() {
        String string2;
        Object object = Environment.getExternalStorageState();
        boolean bl2 = ((String)object).equals(string2 = "mounted");
        if (bl2) {
            object = i1.b().getExternalCacheDir();
            s1.g((File)object);
        }
        s1.g(i1.b().getCacheDir());
    }

    private static Context b() {
        return f.a().b();
    }

    public static long c() {
        long l10;
        Object object;
        long l11;
        block9: {
            l11 = 0L;
            object = Environment.getExternalStorageState();
            String string2 = "mounted";
            boolean bl2 = ((String)object).equals(string2);
            if (!bl2) break block9;
            object = i1.b();
            object = object.getExternalCacheDir();
            l11 = l10 = s1.w((File)object) + l11;
        }
        object = i1.b();
        object = object.getCacheDir();
        try {
            l10 = s1.w((File)object);
            l11 += l10;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return l11;
    }
}

