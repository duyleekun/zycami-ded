/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.provider.DocumentsContract
 */
package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.documentfile.provider.DocumentFile;
import androidx.documentfile.provider.DocumentsContractApi19;

public class SingleDocumentFile
extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    public SingleDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    public boolean canRead() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.canRead(context, uri);
    }

    public boolean canWrite() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.canWrite(context, uri);
    }

    public DocumentFile createDirectory(String object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public DocumentFile createFile(String object, String string2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean delete() {
        Context context;
        try {
            context = this.mContext;
        }
        catch (Exception exception) {
            return false;
        }
        context = context.getContentResolver();
        Uri uri = this.mUri;
        return DocumentsContract.deleteDocument((ContentResolver)context, (Uri)uri);
    }

    public boolean exists() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.exists(context, uri);
    }

    public String getName() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.getName(context, uri);
    }

    public String getType() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.getType(context, uri);
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDirectory() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.isDirectory(context, uri);
    }

    public boolean isFile() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.isFile(context, uri);
    }

    public boolean isVirtual() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.isVirtual(context, uri);
    }

    public long lastModified() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.lastModified(context, uri);
    }

    public long length() {
        Context context = this.mContext;
        Uri uri = this.mUri;
        return DocumentsContractApi19.length(context, uri);
    }

    public DocumentFile[] listFiles() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean renameTo(String object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

