/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.OperationCanceledException
 */
package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.OperationCanceledException;
import androidx.core.os.CancellationSignal;

public final class ContentResolverCompat {
    private ContentResolverCompat() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Cursor query(ContentResolver contentResolver, Uri uri, String[] stringArray, String string2, String[] stringArray2, String string3, CancellationSignal object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            Exception exception2;
            block7: {
                block6: {
                    if (object != null) {
                        try {
                            object = ((CancellationSignal)object).getCancellationSignalObject();
                            break block6;
                        }
                        catch (Exception exception2) {
                            break block7;
                        }
                    }
                    object = null;
                }
                CancellationSignal cancellationSignal = object;
                cancellationSignal = (android.os.CancellationSignal)object;
                return contentResolver.query(uri, stringArray, string2, stringArray2, string3, (android.os.CancellationSignal)cancellationSignal);
            }
            boolean bl2 = exception2 instanceof OperationCanceledException;
            if (bl2) {
                androidx.core.os.OperationCanceledException operationCanceledException = new androidx.core.os.OperationCanceledException();
                throw operationCanceledException;
            }
            throw exception2;
        }
        if (object != null) {
            ((CancellationSignal)object).throwIfCanceled();
        }
        return contentResolver.query(uri, stringArray, string2, stringArray2, string3);
    }
}

