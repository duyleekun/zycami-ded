/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.d.i.e;

import android.content.Context;
import d.v.d.h.c;
import d.v.d.i.a.a;
import java.io.File;
import java.util.Objects;

public class e
extends a {
    public e(Context object) {
        object = this.o((Context)object);
        this.a = object;
    }

    private String o(Context object) {
        object = object.getExternalFilesDir(null);
        Objects.requireNonNull(object);
        return ((File)object).getAbsolutePath();
    }

    public String n() {
        return d.v.d.h.c.b((String)this.a, ".jpg", null);
    }

    public void p(String string2) {
        super.set(string2);
    }
}

