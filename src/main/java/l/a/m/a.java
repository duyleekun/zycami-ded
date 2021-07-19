/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package l.a.m;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import l.a.m.e;
import l.a.o.d;

public class a
extends e {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String g(Context object, String object2) {
        Object object3 = d.b((Context)object);
        Object object4 = new File((String)object3, (String)object2);
        object4 = ((File)object4).getAbsolutePath();
        try {
            object = object.getAssets();
            object3 = new StringBuilder();
            String string2 = "skins";
            ((StringBuilder)object3).append(string2);
            string2 = File.separator;
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            object = object.open((String)object2);
            object2 = new FileOutputStream((String)object4);
            int n10 = 1024;
            object3 = new byte[n10];
            while (true) {
                int n11;
                int n12;
                if ((n12 = ((InputStream)object).read((byte[])object3)) == (n11 = -1)) {
                    ((OutputStream)object2).close();
                    ((InputStream)object).close();
                    return object4;
                }
                n11 = 0;
                ((OutputStream)object2).write((byte[])object3, 0, n12);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return object4;
    }

    public String c(Context context, String string2, int n10) {
        return null;
    }

    public String f(Context context, String string2) {
        return this.g(context, string2);
    }

    public int getType() {
        return 0;
    }
}

