/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.net.Uri
 */
package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader$ForceLoadContentObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader
extends AsyncTaskLoader {
    public CancellationSignal mCancellationSignal;
    public Cursor mCursor;
    public final Loader$ForceLoadContentObserver mObserver;
    public String[] mProjection;
    public String mSelection;
    public String[] mSelectionArgs;
    public String mSortOrder;
    public Uri mUri;

    public CursorLoader(Context object) {
        super((Context)object);
        super(this);
        this.mObserver = object;
    }

    public CursorLoader(Context object, Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3) {
        super((Context)object);
        super(this);
        this.mObserver = object;
        this.mUri = uri;
        this.mProjection = stringArray;
        this.mSelection = string2;
        this.mSelectionArgs = stringArray2;
        this.mSortOrder = string3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            CancellationSignal cancellationSignal = this.mCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
            return;
        }
    }

    public void deliverResult(Cursor cursor) {
        boolean bl2;
        boolean bl3 = this.isReset();
        if (bl3) {
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        Cursor cursor2 = this.mCursor;
        this.mCursor = cursor;
        boolean bl4 = this.isStarted();
        if (bl4) {
            super.deliverResult(cursor);
        }
        if (cursor2 != null && cursor2 != cursor && !(bl2 = cursor2.isClosed())) {
            cursor2.close();
        }
    }

    public void dump(String string2, FileDescriptor object, PrintWriter printWriter, String[] stringArray) {
        super.dump(string2, (FileDescriptor)object, printWriter, stringArray);
        printWriter.print(string2);
        printWriter.print("mUri=");
        object = this.mUri;
        printWriter.println(object);
        printWriter.print(string2);
        printWriter.print("mProjection=");
        object = Arrays.toString(this.mProjection);
        printWriter.println((String)object);
        printWriter.print(string2);
        printWriter.print("mSelection=");
        object = this.mSelection;
        printWriter.println((String)object);
        printWriter.print(string2);
        printWriter.print("mSelectionArgs=");
        object = Arrays.toString(this.mSelectionArgs);
        printWriter.println((String)object);
        printWriter.print(string2);
        printWriter.print("mSortOrder=");
        object = this.mSortOrder;
        printWriter.println((String)object);
        printWriter.print(string2);
        printWriter.print("mCursor=");
        object = this.mCursor;
        printWriter.println(object);
        printWriter.print(string2);
        printWriter.print("mContentChanged=");
        boolean bl2 = this.mContentChanged;
        printWriter.println(bl2);
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    public String getSortOrder() {
        return this.mSortOrder;
    }

    public Uri getUri() {
        return this.mUri;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Cursor loadInBackground() {
        CancellationSignal cancellationSignal;
        boolean bl2;
        synchronized (this) {
            bl2 = this.isLoadInBackgroundCanceled();
            if (bl2) {
                OperationCanceledException operationCanceledException = new OperationCanceledException();
                throw operationCanceledException;
            }
            this.mCancellationSignal = cancellationSignal = new CancellationSignal();
        }
        bl2 = false;
        cancellationSignal = null;
        try {
            Context context = this.getContext();
            Object object = context.getContentResolver();
            Uri uri = this.mUri;
            String[] stringArray = this.mProjection;
            String string2 = this.mSelection;
            String[] stringArray2 = this.mSelectionArgs;
            String string3 = this.mSortOrder;
            CancellationSignal cancellationSignal2 = this.mCancellationSignal;
            context = ContentResolverCompat.query(object, uri, stringArray, string2, stringArray2, string3, cancellationSignal2);
            if (context == null) return context;
            try {
                context.getCount();
                object = this.mObserver;
                context.registerContentObserver((ContentObserver)object);
                return context;
            }
            catch (RuntimeException runtimeException) {
                context.close();
                throw runtimeException;
            }
        }
        finally {
            synchronized (this) {
                this.mCancellationSignal = null;
            }
        }
    }

    public void onCanceled(Cursor cursor) {
        boolean bl2;
        if (cursor != null && !(bl2 = cursor.isClosed())) {
            cursor.close();
        }
    }

    public void onReset() {
        boolean bl2;
        super.onReset();
        this.onStopLoading();
        Cursor cursor = this.mCursor;
        if (cursor != null && !(bl2 = cursor.isClosed())) {
            cursor = this.mCursor;
            cursor.close();
        }
        this.mCursor = null;
    }

    public void onStartLoading() {
        boolean bl2;
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            this.deliverResult(cursor);
        }
        if ((bl2 = this.takeContentChanged()) || (cursor = this.mCursor) == null) {
            this.forceLoad();
        }
    }

    public void onStopLoading() {
        this.cancelLoad();
    }

    public void setProjection(String[] stringArray) {
        this.mProjection = stringArray;
    }

    public void setSelection(String string2) {
        this.mSelection = string2;
    }

    public void setSelectionArgs(String[] stringArray) {
        this.mSelectionArgs = stringArray;
    }

    public void setSortOrder(String string2) {
        this.mSortOrder = string2;
    }

    public void setUri(Uri uri) {
        this.mUri = uri;
    }
}

