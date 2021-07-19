/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.h2.t.f0;
import java.io.File;

public final class e {
    public static final /* synthetic */ String a(File file, File file2, String string2) {
        return e.b(file, file2, string2);
    }

    private static final String b(File object, File object2, String string2) {
        object = ((File)object).toString();
        StringBuilder stringBuilder = new StringBuilder((String)object);
        if (object2 != null) {
            object = new StringBuilder();
            String string3 = " -> ";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            stringBuilder.append((String)object);
        }
        if (string2 != null) {
            object = new StringBuilder();
            object2 = ": ";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            stringBuilder.append((String)object);
        }
        object = stringBuilder.toString();
        f0.o(object, "sb.toString()");
        return object;
    }
}

