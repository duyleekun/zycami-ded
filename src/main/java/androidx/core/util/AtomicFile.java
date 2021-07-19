/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public AtomicFile(File object) {
        File file;
        this.mBaseName = object;
        CharSequence charSequence = new StringBuilder();
        String string2 = ((File)object).getPath();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(".new");
        charSequence = ((StringBuilder)charSequence).toString();
        this.mNewName = file = new File((String)charSequence);
        charSequence = new StringBuilder();
        object = ((File)object).getPath();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(".bak");
        object = ((StringBuilder)charSequence).toString();
        this.mLegacyBackupName = file = new File((String)object);
    }

    private static void rename(File object, File file) {
        String string2;
        CharSequence charSequence;
        boolean bl2 = file.isDirectory();
        String string3 = LOG_TAG;
        if (bl2 && !(bl2 = file.delete())) {
            charSequence = new StringBuilder();
            string2 = "Failed to delete file which is a directory ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(file);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.e((String)string3, (String)charSequence);
        }
        if (!(bl2 = ((File)object).renameTo(file))) {
            charSequence = new StringBuilder();
            string2 = "Failed to rename ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(object);
            ((StringBuilder)charSequence).append(" to ");
            ((StringBuilder)charSequence).append(file);
            object = ((StringBuilder)charSequence).toString();
            Log.e((String)string3, (String)object);
        }
    }

    private static boolean sync(FileOutputStream object) {
        try {
            object = ((FileOutputStream)object).getFD();
        }
        catch (IOException iOException) {
            return false;
        }
        ((FileDescriptor)object).sync();
        return true;
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public void failWrite(FileOutputStream object) {
        Object object2;
        if (object == null) {
            return;
        }
        boolean bl2 = AtomicFile.sync((FileOutputStream)object);
        String string2 = LOG_TAG;
        if (!bl2) {
            object2 = "Failed to sync file output stream";
            Log.e((String)string2, (String)object2);
        }
        try {
            ((FileOutputStream)object).close();
        }
        catch (IOException iOException) {
            object2 = "Failed to close file output stream";
            Log.e((String)string2, (String)object2, (Throwable)iOException);
        }
        object = this.mNewName;
        boolean bl3 = ((File)object).delete();
        if (!bl3) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to delete new file ");
            object2 = this.mNewName;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            Log.e((String)string2, (String)object);
        }
    }

    public void finishWrite(FileOutputStream object) {
        Object object2;
        if (object == null) {
            return;
        }
        boolean bl2 = AtomicFile.sync((FileOutputStream)object);
        String string2 = LOG_TAG;
        if (!bl2) {
            object2 = "Failed to sync file output stream";
            Log.e((String)string2, (String)object2);
        }
        try {
            ((FileOutputStream)object).close();
        }
        catch (IOException iOException) {
            object2 = "Failed to close file output stream";
            Log.e((String)string2, (String)object2, (Throwable)iOException);
        }
        object = this.mNewName;
        object2 = this.mBaseName;
        AtomicFile.rename((File)object, (File)object2);
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public FileInputStream openRead() {
        Object object;
        Object object2 = this.mLegacyBackupName;
        boolean bl2 = ((File)object2).exists();
        if (bl2) {
            object2 = this.mLegacyBackupName;
            object = this.mBaseName;
            AtomicFile.rename((File)object2, (File)object);
        }
        if ((bl2 = ((File)(object2 = this.mNewName)).exists()) && (bl2 = ((File)(object2 = this.mBaseName)).exists()) && !(bl2 = ((File)(object2 = this.mNewName)).delete())) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to delete outdated new file ");
            object = this.mNewName;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = LOG_TAG;
            Log.e((String)object, (String)object2);
        }
        object = this.mBaseName;
        object2 = new FileInputStream((File)object);
        return object2;
    }

    public byte[] readFully() {
        int n10;
        int n11;
        byte[] byArray;
        FileInputStream fileInputStream = this.openRead();
        int n12 = fileInputStream.available();
        try {
            byArray = new byte[n12];
            n11 = 0;
        }
        catch (Throwable throwable) {
            fileInputStream.close();
            throw throwable;
        }
        while (true) {
            n10 = byArray.length - n11;
            break;
        }
        {
            block10: {
                n10 = fileInputStream.read(byArray, n11, n10);
                if (n10 > 0) break block10;
                fileInputStream.close();
                return byArray;
            }
            n11 += n10;
            n10 = fileInputStream.available();
            int n13 = byArray.length - n11;
            if (n10 <= n13) continue;
            n10 += n11;
            byte[] byArray2 = new byte[n10];
            System.arraycopy(byArray, 0, byArray2, 0, n11);
            byArray = byArray2;
            continue;
        }
    }

    public FileOutputStream startWrite() {
        Object object;
        Object object2 = this.mLegacyBackupName;
        boolean bl2 = ((File)object2).exists();
        if (bl2) {
            object2 = this.mLegacyBackupName;
            object = this.mBaseName;
            AtomicFile.rename((File)object2, (File)object);
        }
        try {
            object = this.mNewName;
        }
        catch (FileNotFoundException fileNotFoundException) {
            object2 = this.mNewName.getParentFile();
            bl2 = ((File)object2).mkdirs();
            if (bl2) {
                try {
                    object = this.mNewName;
                }
                catch (FileNotFoundException fileNotFoundException2) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Failed to create new file ");
                    File file = this.mNewName;
                    charSequence.append(file);
                    charSequence = charSequence.toString();
                    object = new IOException((String)charSequence, fileNotFoundException2);
                    throw object;
                }
                object2 = new FileOutputStream((File)object);
                return object2;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to create directory for ");
            File file = this.mNewName;
            ((StringBuilder)object).append(file);
            object = ((StringBuilder)object).toString();
            object2 = new IOException((String)object);
            throw object2;
        }
        object2 = new FileOutputStream((File)object);
        return object2;
    }
}

