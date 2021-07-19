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

public class f$a
implements d$c {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public f$a(Context context, String string2) {
        this.a = context;
        this.b = string2;
    }

    public File a() {
        File file = this.a.getExternalCacheDir();
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
}

