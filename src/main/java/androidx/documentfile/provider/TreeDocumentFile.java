/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.provider.DocumentsContract
 *  android.util.Log
 */
package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.documentfile.provider.DocumentFile;
import androidx.documentfile.provider.DocumentsContractApi19;
import java.util.ArrayList;

public class TreeDocumentFile
extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    public TreeDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.mContext = context;
        this.mUri = uri;
    }

    private static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            }
            catch (RuntimeException runtimeException) {
                throw runtimeException;
            }
            catch (Exception exception) {}
        }
    }

    private static Uri createFile(Context context, Uri uri, String string2, String string3) {
        try {
            context = context.getContentResolver();
        }
        catch (Exception exception) {
            return null;
        }
        return DocumentsContract.createDocument((ContentResolver)context, (Uri)uri, (String)string2, (String)string3);
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

    public DocumentFile createDirectory(String string2) {
        Object object = this.mContext;
        Uri uri = this.mUri;
        String string3 = "vnd.android.document/directory";
        if ((string2 = TreeDocumentFile.createFile(object, uri, string3, string2)) != null) {
            uri = this.mContext;
            object = new TreeDocumentFile(this, (Context)uri, (Uri)string2);
        } else {
            object = null;
        }
        return object;
    }

    public DocumentFile createFile(String string2, String object) {
        Context context = this.mContext;
        Uri uri = this.mUri;
        if ((string2 = TreeDocumentFile.createFile(context, uri, string2, (String)object)) != null) {
            context = this.mContext;
            object = new TreeDocumentFile(this, context, (Uri)string2);
        } else {
            object = null;
        }
        return object;
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

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DocumentFile[] listFiles() {
        Throwable throwable2;
        Cursor cursor;
        block7: {
            int n10;
            DocumentFile[] documentFileArray = this.mContext.getContentResolver();
            Object object = this.mUri;
            Object object2 = DocumentsContract.getDocumentId((Uri)object);
            object2 = DocumentsContract.buildChildDocumentsUriUsingTree((Uri)object, (String)object2);
            object = new ArrayList();
            int n11 = 0;
            cursor = null;
            Object object3 = "document_id";
            object3 = new String[]{object3};
            Object object4 = null;
            cursor = documentFileArray.query((Uri)object2, (String[])object3, null, null, null);
            while ((n10 = cursor.moveToNext()) != 0) {
                documentFileArray = cursor.getString(0);
                object2 = this.mUri;
                documentFileArray = DocumentsContract.buildDocumentUriUsingTree((Uri)object2, (String)documentFileArray);
                ((ArrayList)object).add(documentFileArray);
            }
            {
                catch (Throwable throwable2) {
                    break block7;
                }
                catch (Exception exception) {}
                object2 = "DocumentFile";
                {
                    object3 = new StringBuilder();
                    object4 = "Failed query: ";
                    ((StringBuilder)object3).append((String)object4);
                    ((StringBuilder)object3).append(exception);
                    documentFileArray = ((StringBuilder)object3).toString();
                    Log.w((String)object2, (String)documentFileArray);
                }
            }
            TreeDocumentFile.closeQuietly((AutoCloseable)cursor);
            documentFileArray = new Uri[((ArrayList)object).size()];
            object = ((ArrayList)object).toArray(documentFileArray);
            n10 = ((Object)object).length;
            documentFileArray = new DocumentFile[n10];
            while (true) {
                int n12;
                if (n11 >= (n12 = ((Object)object).length)) {
                    return documentFileArray;
                }
                object3 = this.mContext;
                object4 = object[n11];
                documentFileArray[n11] = object2 = new TreeDocumentFile(this, (Context)object3, (Uri)object4);
                ++n11;
            }
        }
        TreeDocumentFile.closeQuietly(cursor);
        throw throwable2;
    }

    public boolean renameTo(String string2) {
        block6: {
            Context context;
            try {
                context = this.mContext;
            }
            catch (Exception exception) {}
            context = context.getContentResolver();
            Uri uri = this.mUri;
            string2 = DocumentsContract.renameDocument((ContentResolver)context, (Uri)uri, (String)string2);
            if (string2 == null) break block6;
            this.mUri = string2;
            return true;
        }
        return false;
    }
}

