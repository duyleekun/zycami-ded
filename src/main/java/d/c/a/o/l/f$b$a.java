/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 */
package d.c.a.o.l;

import android.os.ParcelFileDescriptor;
import d.c.a.o.l.f$d;
import java.io.File;

public class f$b$a
implements f$d {
    public Class a() {
        return ParcelFileDescriptor.class;
    }

    public void d(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    public ParcelFileDescriptor e(File file) {
        return ParcelFileDescriptor.open((File)file, (int)0x10000000);
    }
}

