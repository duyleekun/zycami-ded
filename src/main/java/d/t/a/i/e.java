/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.t.a.i;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.Locale;

public class e {
    private static final String a = "FileUtils";

    private e() {
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String object, String string2) {
        void var1_4;
        Object object2;
        block8: {
            block9: {
                Closeable closeable;
                File file;
                boolean bl2 = ((String)object).equalsIgnoreCase(string2);
                if (bl2) {
                    return;
                }
                bl2 = false;
                object2 = null;
                try {
                    file = new File((String)object);
                    closeable = new FileInputStream(file);
                    object = ((FileInputStream)closeable).getChannel();
                }
                catch (Throwable throwable) {
                    object = null;
                    break block8;
                }
                try {
                    file = new File(string2);
                    closeable = new FileOutputStream(file);
                    object2 = ((FileOutputStream)closeable).getChannel();
                    long l10 = 0L;
                    long l11 = ((FileChannel)object).size();
                    ((FileChannel)object).transferTo(l10, l11, (WritableByteChannel)object2);
                    ((AbstractInterruptibleChannel)object).close();
                    if (object == null) break block9;
                }
                catch (Throwable throwable) {
                    AbstractInterruptibleChannel abstractInterruptibleChannel = object2;
                    object2 = object;
                    object = abstractInterruptibleChannel;
                    break block8;
                }
                ((AbstractInterruptibleChannel)object).close();
            }
            if (object2 != null) {
                ((AbstractInterruptibleChannel)object2).close();
            }
            return;
        }
        if (object2 != null) {
            ((AbstractInterruptibleChannel)object2).close();
        }
        if (object != null) {
            ((AbstractInterruptibleChannel)object).close();
        }
        throw var1_4;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String b(Context context, Uri object, String string2, String[] object2) {
        void var1_10;
        Context context2;
        block9: {
            block10: {
                String string3;
                Object[] objectArray;
                String string4;
                block8: {
                    block7: {
                        String string5;
                        void var3_13;
                        string4 = "_data";
                        String[] stringArray = new String[]{string4};
                        context2 = null;
                        objectArray = context.getContentResolver();
                        context = objectArray.query(object, stringArray, string3, (String[])var3_13, null);
                        if (context == null) break block7;
                        try {
                            int n10 = context.moveToFirst();
                            if (n10 == 0) break block7;
                            n10 = context.getColumnIndexOrThrow(string4);
                            string5 = context.getString(n10);
                            if (context == null) return string5;
                        }
                        catch (IllegalArgumentException illegalArgumentException) {
                            break block8;
                        }
                        context.close();
                        return string5;
                    }
                    if (context == null) return null;
                    break block10;
                    catch (Throwable throwable) {
                        break block9;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        context = null;
                    }
                }
                string3 = a;
                try {
                    void var1_6;
                    Locale locale = Locale.getDefault();
                    string4 = "getDataColumn: _data - [%s]";
                    int n11 = 1;
                    objectArray = new Object[n11];
                    String string6 = var1_6.getMessage();
                    objectArray[0] = string6;
                    String string7 = String.format(locale, string4, objectArray);
                    Log.i((String)string3, (String)string7);
                    if (context == null) return null;
                }
                catch (Throwable throwable) {
                    context2 = context;
                }
            }
            context.close();
            return null;
        }
        if (context2 == null) throw var1_10;
        context2.close();
        throw var1_10;
    }

    public static String c(Context object, Uri object2) {
        Object object3;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        int n12 = 19;
        if (n10 >= n12) {
            n10 = n11;
        } else {
            n10 = 0;
            object3 = null;
        }
        n12 = 0;
        Uri uri = null;
        if (n10 != 0 && (n10 = (int)(DocumentsContract.isDocumentUri((Context)object, (Uri)object2) ? 1 : 0)) != 0) {
            n10 = (int)(e.e((Uri)object2) ? 1 : 0);
            String string2 = ":";
            if (n10 != 0) {
                object3 = "primary";
                object = DocumentsContract.getDocumentId((Uri)object2).split(string2);
                boolean bl2 = object3.equalsIgnoreCase((String)(object2 = object[0]));
                if (bl2) {
                    object2 = new StringBuilder();
                    object3 = Environment.getExternalStorageDirectory();
                    ((StringBuilder)object2).append(object3);
                    ((StringBuilder)object2).append("/");
                    object = object[n11];
                    ((StringBuilder)object2).append((String)object);
                    return ((StringBuilder)object2).toString();
                }
            } else {
                n10 = (int)(e.d((Uri)object2) ? 1 : 0);
                if (n10 != 0) {
                    n10 = (int)(TextUtils.isEmpty((CharSequence)(object2 = DocumentsContract.getDocumentId((Uri)object2))) ? 1 : 0);
                    if (n10 == 0) {
                        object3 = "content://downloads/public_downloads";
                        try {
                            object3 = Uri.parse((String)object3);
                        }
                        catch (NumberFormatException numberFormatException) {
                            object = numberFormatException.getMessage();
                            Log.i((String)a, (String)object);
                            return null;
                        }
                        object2 = Long.valueOf((String)object2);
                        long l10 = (Long)object2;
                        object2 = ContentUris.withAppendedId((Uri)object3, (long)l10);
                        return e.b((Context)object, (Uri)object2, null, null);
                    }
                } else {
                    n10 = (int)(e.g((Uri)object2) ? 1 : 0);
                    if (n10 != 0) {
                        string2 = "image";
                        object3 = (object2 = DocumentsContract.getDocumentId((Uri)object2).split(string2))[0];
                        boolean bl3 = string2.equals(object3);
                        if (bl3) {
                            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else {
                            string2 = "video";
                            bl3 = string2.equals(object3);
                            if (bl3) {
                                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                            } else {
                                string2 = "audio";
                                n10 = (int)(string2.equals(object3) ? 1 : 0);
                                if (n10 != 0) {
                                    uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                                }
                            }
                        }
                        object3 = new String[n11];
                        object3[0] = object2 = object2[n11];
                        return e.b((Context)object, uri, "_id=?", object3);
                    }
                }
            }
        } else {
            String string3 = "content";
            object3 = object2.getScheme();
            n10 = (int)(string3.equalsIgnoreCase((String)object3) ? 1 : 0);
            if (n10 != 0) {
                n10 = (int)(e.f((Uri)object2) ? 1 : 0);
                if (n10 != 0) {
                    return object2.getLastPathSegment();
                }
                return e.b((Context)object, (Uri)object2, null, null);
            }
            object3 = "file";
            object = object2.getScheme();
            boolean bl4 = object3.equalsIgnoreCase((String)object);
            if (bl4) {
                return object2.getPath();
            }
        }
        return null;
    }

    public static boolean d(Uri object) {
        object = object.getAuthority();
        return "com.android.providers.downloads.documents".equals(object);
    }

    public static boolean e(Uri object) {
        object = object.getAuthority();
        return "com.android.externalstorage.documents".equals(object);
    }

    public static boolean f(Uri object) {
        object = object.getAuthority();
        return "com.google.android.apps.photos.content".equals(object);
    }

    public static boolean g(Uri object) {
        object = object.getAuthority();
        return "com.android.providers.media.documents".equals(object);
    }
}

