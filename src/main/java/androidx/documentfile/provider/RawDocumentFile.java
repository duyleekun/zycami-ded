/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Log
 *  android.webkit.MimeTypeMap
 */
package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RawDocumentFile
extends DocumentFile {
    private File mFile;

    public RawDocumentFile(DocumentFile documentFile, File file) {
        super(documentFile);
        this.mFile = file;
    }

    private static boolean deleteContents(File fileArray) {
        fileArray = fileArray.listFiles();
        boolean bl2 = true;
        if (fileArray != null) {
            for (File file : fileArray) {
                boolean bl3 = file.isDirectory();
                if (bl3) {
                    bl3 = RawDocumentFile.deleteContents(file);
                    bl2 &= bl3;
                }
                if (bl3 = file.delete()) continue;
                CharSequence charSequence = new StringBuilder();
                String string2 = "Failed to delete ";
                charSequence.append(string2);
                charSequence.append(file);
                charSequence = charSequence.toString();
                String string3 = "DocumentFile";
                Log.w((String)string3, (String)charSequence);
                bl2 = false;
                charSequence = null;
            }
        }
        return bl2;
    }

    private static String getTypeForName(String string2) {
        int n10 = string2.lastIndexOf(46);
        if (n10 >= 0) {
            string2 = string2.substring(++n10).toLowerCase();
            MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
            string2 = mimeTypeMap.getMimeTypeFromExtension(string2);
            if (string2 != null) {
                return string2;
            }
        }
        return "application/octet-stream";
    }

    public boolean canRead() {
        return this.mFile.canRead();
    }

    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    public DocumentFile createDirectory(String object) {
        File file = this.mFile;
        File file2 = new File(file, (String)object);
        boolean bl2 = file2.isDirectory();
        if (!bl2 && !(bl2 = file2.mkdir())) {
            return null;
        }
        object = new RawDocumentFile(this, file2);
        return object;
    }

    public DocumentFile createFile(String object, String object2) {
        Object object3 = MimeTypeMap.getSingleton();
        object = object3.getExtensionFromMimeType((String)object);
        if (object != null) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(".");
            ((StringBuilder)object3).append((String)object);
            object2 = ((StringBuilder)object3).toString();
        }
        object3 = this.mFile;
        object = new File((File)object3, (String)object2);
        try {
            ((File)object).createNewFile();
        }
        catch (IOException iOException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to createFile: ");
            ((StringBuilder)object2).append(iOException);
            String string2 = ((StringBuilder)object2).toString();
            Log.w((String)"DocumentFile", (String)string2);
            return null;
        }
        object2 = new RawDocumentFile(this, (File)object);
        return object2;
    }

    public boolean delete() {
        RawDocumentFile.deleteContents(this.mFile);
        return this.mFile.delete();
    }

    public boolean exists() {
        return this.mFile.exists();
    }

    public String getName() {
        return this.mFile.getName();
    }

    public String getType() {
        File file = this.mFile;
        boolean bl2 = file.isDirectory();
        if (bl2) {
            return null;
        }
        return RawDocumentFile.getTypeForName(this.mFile.getName());
    }

    public Uri getUri() {
        return Uri.fromFile((File)this.mFile);
    }

    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    public boolean isFile() {
        return this.mFile.isFile();
    }

    public boolean isVirtual() {
        return false;
    }

    public long lastModified() {
        return this.mFile.lastModified();
    }

    public long length() {
        return this.mFile.length();
    }

    public DocumentFile[] listFiles() {
        ArrayList<RawDocumentFile> arrayList = new ArrayList<RawDocumentFile>();
        Object[] objectArray = this.mFile.listFiles();
        if (objectArray != null) {
            for (Object object : objectArray) {
                RawDocumentFile rawDocumentFile = new RawDocumentFile(this, (File)object);
                arrayList.add(rawDocumentFile);
            }
        }
        objectArray = new DocumentFile[arrayList.size()];
        return (DocumentFile[])arrayList.toArray(objectArray);
    }

    public boolean renameTo(String object) {
        object = this.mFile;
        File file = this.mFile.getParentFile();
        File file2 = new File(file, (String)object);
        boolean bl2 = ((File)object).renameTo(file2);
        if (bl2) {
            this.mFile = file2;
            return true;
        }
        return false;
    }
}

