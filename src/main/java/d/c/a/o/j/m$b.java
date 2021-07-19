/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ParcelFileDescriptor
 *  android.system.ErrnoException
 *  android.system.Os
 *  android.system.OsConstants
 */
package d.c.a.o.j;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.io.IOException;

public final class m$b {
    private final ParcelFileDescriptor a;

    public m$b(ParcelFileDescriptor parcelFileDescriptor) {
        this.a = parcelFileDescriptor;
    }

    public ParcelFileDescriptor a() {
        Object object;
        try {
            object = this.a;
        }
        catch (ErrnoException errnoException) {
            IOException iOException = new IOException(errnoException);
            throw iOException;
        }
        object = object.getFileDescriptor();
        long l10 = 0L;
        int n10 = OsConstants.SEEK_SET;
        Os.lseek((FileDescriptor)object, (long)l10, (int)n10);
        return this.a;
    }
}

