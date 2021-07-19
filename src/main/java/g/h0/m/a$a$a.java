/*
 * Decompiled with CFR 0.151.
 */
package g.h0.m;

import f.h2.t.f0;
import g.h0.m.a;
import h.k0;
import h.m0;
import h.z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class a$a$a
implements a {
    public void a(File object) {
        f0.p(object, "directory");
        Object object2 = ((File)object).listFiles();
        if (object2 != null) {
            int n10 = ((File[])object2).length;
            Object var5_5 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                File file = object2[i10];
                String string2 = "file";
                f0.o(file, string2);
                boolean bl2 = file.isDirectory();
                if (bl2) {
                    this.a(file);
                }
                if (bl2 = file.delete()) {
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("failed to delete ");
                ((StringBuilder)object2).append(file);
                object2 = ((StringBuilder)object2).toString();
                object = new IOException((String)object2);
                throw object;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not a readable directory: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IOException((String)object);
        throw object2;
    }

    public boolean b(File file) {
        f0.p(file, "file");
        return file.exists();
    }

    public k0 c(File object) {
        Object object2 = "file";
        f0.p(object, (String)object2);
        try {
            object = z.a((File)object);
        }
        catch (FileNotFoundException fileNotFoundException) {
            object2 = ((File)object).getParentFile();
            ((File)object2).mkdirs();
            object = z.a((File)object);
        }
        return object;
    }

    public long d(File file) {
        f0.p(file, "file");
        return file.length();
    }

    public m0 e(File file) {
        f0.p(file, "file");
        return z.l(file);
    }

    public k0 f(File object) {
        f0.p(object, "file");
        int n10 = 1;
        try {
            object = z.k((File)object, false, n10, null);
        }
        catch (FileNotFoundException fileNotFoundException) {
            File file = ((File)object).getParentFile();
            file.mkdirs();
            object = z.k((File)object, false, n10, null);
        }
        return object;
    }

    public void g(File object, File file) {
        f0.p(object, "from");
        Object object2 = "to";
        f0.p(file, (String)object2);
        this.h(file);
        boolean bl2 = ((File)object).renameTo(file);
        if (bl2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to rename ");
        stringBuilder.append(object);
        stringBuilder.append(" to ");
        stringBuilder.append(file);
        object = stringBuilder.toString();
        object2 = new IOException((String)object);
        throw object2;
    }

    public void h(File object) {
        Object object2 = "file";
        f0.p(object, (String)object2);
        boolean bl2 = ((File)object).delete();
        if (!bl2 && (bl2 = ((File)object).exists())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to delete ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IOException((String)object);
            throw object2;
        }
    }

    public String toString() {
        return "FileSystem.SYSTEM";
    }
}

