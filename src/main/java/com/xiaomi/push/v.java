/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.u;
import com.xiaomi.push.w;
import java.io.File;
import java.io.IOException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class v
implements Runnable {
    private Context a;
    private File a;
    private Runnable a;

    private v(Context context, File file) {
        this.a = context;
        this.a = file;
    }

    public /* synthetic */ v(Context context, File file, w w10) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        w w10 = new w(context, file, runnable);
        w10.run();
    }

    public abstract void a(Context var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Throwable throwable2;
        u u10;
        block8: {
            u10 = null;
            try {
                try {
                    Object object;
                    Object object2 = this.a;
                    if (object2 == null) {
                        object = this.a;
                        object = object.getFilesDir();
                        String string2 = "default_locker";
                        this.a = object2 = new File((File)object, string2);
                    }
                    object2 = this.a;
                    object = this.a;
                    u10 = u.a((Context)object2, (File)object);
                    object2 = this.a;
                    if (object2 != null) {
                        object2.run();
                    }
                    object2 = this.a;
                    this.a((Context)object2);
                    if (u10 == null) return;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    if (u10 == null) return;
                }
            }
            catch (Throwable throwable2) {
                break block8;
            }
            u10.a();
            return;
        }
        if (u10 == null) throw throwable2;
        u10.a();
        throw throwable2;
    }
}

