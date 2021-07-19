/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.c.a.o.k.y;

import android.content.Context;
import d.c.a.o.k.y.d$c;
import java.io.File;

public class g$a
implements d$c {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public g$a(Context context, String string2) {
        this.a = context;
        this.b = string2;
    }

    private File b() {
        File file = this.a.getCacheDir();
        if (file == null) {
            return null;
        }
        Object object = this.b;
        if (object != null) {
            String string2 = this.b;
            object = new File(file, string2);
            return object;
        }
        return file;
    }

    public File a() {
        boolean bl2;
        boolean bl3;
        Object object = this.b();
        if (object != null && (bl3 = ((File)object).exists())) {
            return object;
        }
        File file = this.a.getExternalCacheDir();
        if (file != null && (bl2 = file.canWrite())) {
            object = this.b;
            if (object != null) {
                String string2 = this.b;
                object = new File(file, string2);
                return object;
            }
            return file;
        }
        return object;
    }
}

