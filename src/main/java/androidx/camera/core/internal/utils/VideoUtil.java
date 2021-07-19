/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.Cursor
 *  android.net.Uri
 */
package androidx.camera.core.internal.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;

public final class VideoUtil {
    private static final String TAG = "VideoUtil";

    private VideoUtil() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getAbsolutePathFromUri(ContentResolver object, Uri object2) {
        void var1_4;
        Object cursor;
        block9: {
            block11: {
                Object[] objectArray;
                Object string3;
                String[] stringArray;
                block8: {
                    block10: {
                        String string4 = "_data";
                        cursor = null;
                        try {
                            stringArray = new String[]{string4};
                            string3 = object;
                            objectArray = object2;
                            cursor = object.query((Uri)object2, stringArray, null, null, null);
                            object = Preconditions.checkNotNull(cursor);
                            object = (Cursor)object;
                        }
                        catch (RuntimeException runtimeException) {
                            // empty catch block
                            break block8;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                            break block9;
                        }
                        try {
                            int n10 = object.getColumnIndexOrThrow(string4);
                            object.moveToFirst();
                            object2 = object.getString(n10);
                            if (object == null) break block10;
                        }
                        catch (Throwable throwable) {
                            cursor = object;
                            break block9;
                        }
                        catch (RuntimeException runtimeException) {
                            cursor = object;
                            break block8;
                        }
                        object.close();
                    }
                    return object2;
                }
                object = TAG;
                string3 = "Failed in getting absolute path for Uri %s with Exception %s";
                int n11 = 2;
                {
                    String string2;
                    objectArray = new Object[n11];
                    stringArray = null;
                    objectArray[0] = object2 = object2.toString();
                    int n12 = 1;
                    string2 = ((Throwable)((Object)string2)).toString();
                    objectArray[n12] = string2;
                    object2 = String.format((String)string3, objectArray);
                    Logger.e((String)object, (String)object2);
                    object = "";
                    if (cursor == null) break block11;
                }
                cursor.close();
            }
            return object;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw var1_4;
    }
}

