/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.DocumentsContract
 */
package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.documentfile.provider.RawDocumentFile;
import androidx.documentfile.provider.SingleDocumentFile;
import androidx.documentfile.provider.TreeDocumentFile;
import java.io.File;

public abstract class DocumentFile {
    public static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    public DocumentFile(DocumentFile documentFile) {
        this.mParent = documentFile;
    }

    public static DocumentFile fromFile(File file) {
        RawDocumentFile rawDocumentFile = new RawDocumentFile(null, file);
        return rawDocumentFile;
    }

    public static DocumentFile fromSingleUri(Context context, Uri uri) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            SingleDocumentFile singleDocumentFile = new SingleDocumentFile(null, context, uri);
            return singleDocumentFile;
        }
        return null;
    }

    public static DocumentFile fromTreeUri(Context context, Uri uri) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            String string2 = DocumentsContract.getTreeDocumentId((Uri)uri);
            uri = DocumentsContract.buildDocumentUriUsingTree((Uri)uri, (String)string2);
            TreeDocumentFile treeDocumentFile = new TreeDocumentFile(null, context, uri);
            return treeDocumentFile;
        }
        return null;
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return DocumentsContract.isDocumentUri((Context)context, (Uri)uri);
        }
        return false;
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String var1);

    public abstract DocumentFile createFile(String var1, String var2);

    public abstract boolean delete();

    public abstract boolean exists();

    public DocumentFile findFile(String string2) {
        for (DocumentFile documentFile : this.listFiles()) {
            String string3 = documentFile.getName();
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            return documentFile;
        }
        return null;
    }

    public abstract String getName();

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String var1);
}

