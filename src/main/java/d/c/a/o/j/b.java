/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.util.Log
 */
package d.c.a.o.j;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import java.io.IOException;

public abstract class b
implements d {
    private static final String d = "AssetPathFetcher";
    private final String a;
    private final AssetManager b;
    private Object c;

    public b(AssetManager assetManager, String string2) {
        this.b = assetManager;
        this.a = string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b() {
        Object object = this.c;
        if (object == null) {
            return;
        }
        try {
            this.c(object);
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public abstract void c(Object var1);

    public void cancel() {
    }

    public void d(Priority object, d$a d$a) {
        String string2;
        try {
            object = this.b;
        }
        catch (IOException iOException) {
            String string3 = "AssetPathFetcher";
            boolean bl2 = Log.isLoggable((String)string3, (int)3);
            if (bl2) {
                string2 = "Failed to load data from asset manager";
                Log.d((String)string3, (String)string2, (Throwable)iOException);
            }
            d$a.c(iOException);
            return;
        }
        string2 = this.a;
        object = this.e((AssetManager)object, string2);
        this.c = object;
        d$a.e(object);
    }

    public abstract Object e(AssetManager var1, String var2);

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

