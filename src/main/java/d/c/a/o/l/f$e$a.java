/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.l.f$d;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class f$e$a
implements f$d {
    public Class a() {
        return InputStream.class;
    }

    public void d(InputStream inputStream) {
        inputStream.close();
    }

    public InputStream e(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        return fileInputStream;
    }
}

