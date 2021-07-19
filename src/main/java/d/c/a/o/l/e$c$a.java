/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package d.c.a.o.l;

import android.util.Base64;
import d.c.a.o.l.e$a;
import d.c.a.o.l.e$c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class e$c$a
implements e$a {
    public final /* synthetic */ e$c a;

    public e$c$a(e$c e$c) {
        this.a = e$c;
    }

    public Class a() {
        return InputStream.class;
    }

    public void c(InputStream inputStream) {
        inputStream.close();
    }

    public InputStream d(String object) {
        Object object2 = "data:image";
        boolean n10 = ((String)object).startsWith((String)object2);
        if (n10) {
            int n11;
            int n12 = ((String)object).indexOf(44);
            if (n12 != (n11 = -1)) {
                String string2;
                n11 = 0;
                String string3 = ((String)object).substring(0, n12);
                boolean bl2 = string3.endsWith(string2 = ";base64");
                if (bl2) {
                    int n13 = n12 + 1;
                    object = Base64.decode((String)((String)object).substring(n13), (int)0);
                    object2 = new ByteArrayInputStream((byte[])object);
                    return object2;
                }
                object = new IllegalArgumentException("Not a base64 image data URL.");
                throw object;
            }
            object = new IllegalArgumentException("Missing comma in data URL.");
            throw object;
        }
        object = new IllegalArgumentException("Not a valid image data URL.");
        throw object;
    }
}

