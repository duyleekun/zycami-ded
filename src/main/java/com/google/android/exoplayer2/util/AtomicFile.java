/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.AtomicFile$AtomicFileOutputStream;
import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class AtomicFile {
    private static final String TAG = "AtomicFile";
    private final File backupName;
    private final File baseName;

    public AtomicFile(File object) {
        File file;
        this.baseName = object;
        object = String.valueOf(((File)object).getPath()).concat(".bak");
        this.backupName = file = new File((String)object);
    }

    private void restoreBackup() {
        File file = this.backupName;
        boolean bl2 = file.exists();
        if (bl2) {
            this.baseName.delete();
            file = this.backupName;
            File file2 = this.baseName;
            file.renameTo(file2);
        }
    }

    public void delete() {
        this.baseName.delete();
        this.backupName.delete();
    }

    public void endWrite(OutputStream outputStream) {
        outputStream.close();
        this.backupName.delete();
    }

    public boolean exists() {
        File file = this.baseName;
        boolean bl2 = file.exists();
        if (!bl2 && !(bl2 = (file = this.backupName).exists())) {
            bl2 = false;
            file = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public InputStream openRead() {
        this.restoreBackup();
        File file = this.baseName;
        FileInputStream fileInputStream = new FileInputStream(file);
        return fileInputStream;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public OutputStream startWrite() {
        FileNotFoundException fileNotFoundException222;
        String string2;
        CharSequence charSequence;
        Object object;
        block12: {
            Object object2 = this.baseName;
            boolean bl2 = ((File)object2).exists();
            if (bl2) {
                object2 = this.backupName;
                bl2 = ((File)object2).exists();
                if (!bl2) {
                    object2 = this.baseName;
                    object = this.backupName;
                    bl2 = ((File)object2).renameTo((File)object);
                    if (!bl2) {
                        object2 = String.valueOf(this.baseName);
                        object = String.valueOf(this.backupName);
                        int n10 = String.valueOf(object2).length() + 37;
                        int n11 = String.valueOf(object).length();
                        charSequence = new StringBuilder(n10 += n11);
                        string2 = "Couldn't rename file ";
                        ((StringBuilder)charSequence).append(string2);
                        ((StringBuilder)charSequence).append((String)object2);
                        ((StringBuilder)charSequence).append(" to backup file ");
                        ((StringBuilder)charSequence).append((String)object);
                        object2 = ((StringBuilder)charSequence).toString();
                        object = TAG;
                        Log.w((String)object, (String)object2);
                    }
                } else {
                    object2 = this.baseName;
                    ((File)object2).delete();
                }
            }
            object = this.baseName;
            try {
                return new AtomicFile$AtomicFileOutputStream((File)object);
            }
            catch (FileNotFoundException fileNotFoundException222) {
                boolean bl3;
                object = this.baseName.getParentFile();
                string2 = "Couldn't create ";
                if (object == null || !(bl3 = ((File)object).mkdirs())) break block12;
                try {
                    object = this.baseName;
                }
                catch (FileNotFoundException fileNotFoundException3) {
                    charSequence = String.valueOf(this.baseName);
                    int n12 = String.valueOf(charSequence).length() + 16;
                    StringBuilder stringBuilder = new StringBuilder(n12);
                    stringBuilder.append(string2);
                    stringBuilder.append((String)charSequence);
                    string2 = stringBuilder.toString();
                    object = new IOException(string2, fileNotFoundException3);
                    throw object;
                }
                return new AtomicFile$AtomicFileOutputStream((File)object);
            }
        }
        charSequence = String.valueOf(this.baseName);
        int n13 = String.valueOf(charSequence).length() + 16;
        StringBuilder stringBuilder = new StringBuilder(n13);
        stringBuilder.append(string2);
        stringBuilder.append((String)charSequence);
        string2 = stringBuilder.toString();
        object = new IOException(string2, fileNotFoundException222);
        throw object;
    }
}

