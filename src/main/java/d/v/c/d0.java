/*
 * Decompiled with CFR 0.151.
 */
package d.v.c;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import d.v.e.l.k2;
import d.v.e.l.s1;
import java.io.File;

public class d0 {
    public static File a() {
        return d0.d("composeCache");
    }

    public static File b(EditConfig$ResourceType object) {
        if (object == null) {
            return d0.c();
        }
        File file = d0.c();
        object = ((EditConfig$ResourceType)object).getDirName();
        File file2 = new File(file, (String)object);
        s1.c0(file2);
        return file2;
    }

    public static File c() {
        return d0.d("Res");
    }

    private static File d(String string2) {
        File file = k2.m();
        File file2 = new File(file, string2);
        s1.c0(file2);
        return file2;
    }
}

