/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 */
package d.c.a.o.l;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import java.io.File;
import java.io.FileNotFoundException;

public class k$b
implements d {
    private static final String[] c = new String[]{"_data"};
    private final Context a;
    private final Uri b;

    public k$b(Context context, Uri uri) {
        this.a = context;
        this.b = uri;
    }

    public Class a() {
        return File.class;
    }

    public void b() {
    }

    public void cancel() {
    }

    public void d(Priority object, d$a d$a) {
        boolean bl2;
        Uri uri;
        Object object2;
        block8: {
            object2 = this.a.getContentResolver();
            uri = this.b;
            String[] stringArray = c;
            object = object2.query(uri, stringArray, null, null, null);
            int n10 = 0;
            object2 = null;
            if (object != null) {
                boolean bl3 = object.moveToFirst();
                if (!bl3) break block8;
                object2 = "_data";
                try {
                    n10 = object.getColumnIndexOrThrow((String)object2);
                    object2 = object.getString(n10);
                }
                finally {
                    object.close();
                }
            }
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object2)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to find file path for: ");
            uri = this.b;
            ((StringBuilder)object2).append(uri);
            object2 = ((StringBuilder)object2).toString();
            object = new FileNotFoundException((String)object2);
            d$a.c((Exception)object);
        } else {
            object = new File((String)object2);
            d$a.e(object);
        }
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

