/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.j.a.f;

import android.content.Context;
import d.j.a.f.c.i;
import java.io.InputStream;

public abstract class b {
    private final Context a;
    private InputStream b;

    public b(Context context) {
        this.a = context;
    }

    public final void a() {
        i.b(this.b);
    }

    public abstract InputStream b(Context var1);

    public InputStream c() {
        InputStream inputStream = this.b;
        if (inputStream == null) {
            inputStream = this.a;
            this.b = inputStream = this.b((Context)inputStream);
        }
        return this.b;
    }
}

