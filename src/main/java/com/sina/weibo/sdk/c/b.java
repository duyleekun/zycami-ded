/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.Context
 *  android.database.Cursor
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.media.MediaMetadataRetriever
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  android.webkit.MimeTypeMap
 */
package com.sina.weibo.sdk.c;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;

public final class b {
    private static String a(Context object, Uri uri, String string2, String[] stringArray) {
        block10: {
            Cursor cursor;
            block9: {
                String string3 = "_data";
                String[] stringArray2 = new String[]{string3};
                cursor = null;
                ContentResolver contentResolver = object.getContentResolver();
                cursor = contentResolver.query(uri, stringArray2, string2, stringArray, null);
                if (cursor == null) break block9;
                int n10 = cursor.moveToFirst();
                if (n10 == 0) break block9;
                try {
                    n10 = cursor.getColumnIndexOrThrow(string3);
                    object = cursor.getString(n10);
                    return object;
                }
                catch (Throwable throwable) {
                    throw throwable;
                }
                catch (Exception exception) {
                    if (cursor == null) break block10;
                }
                finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (cursor == null) break block10;
            cursor.close();
        }
        return b.d(object, uri);
    }

    private static String a(File object) {
        block10: {
            object = ((File)object).getAbsolutePath();
            Object object2 = new BitmapFactory.Options();
            boolean bl2 = true;
            object2.inJustDecodeBounds = bl2;
            BitmapFactory.decodeFile((String)object, (BitmapFactory.Options)object2);
            object = object2.outMimeType;
            object2 = "jpg";
            boolean bl3 = ((String)object).contains((CharSequence)object2);
            if (bl3) break block10;
            object2 = "gif";
            bl3 = ((String)object).contains((CharSequence)object2);
            if (bl3) break block10;
            object2 = "png";
            bl3 = ((String)object).contains((CharSequence)object2);
            if (bl3) break block10;
            object2 = "jpeg";
            try {
                boolean bl4 = ((String)object).contains((CharSequence)object2);
                if (bl4) break block10;
                bl4 = false;
                object = null;
            }
            catch (Exception exception) {
                object = "*/*";
            }
        }
        object = "image/*";
        return object;
    }

    public static boolean a(Context object, Uri object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = b.c((Context)object, object2)));
        if (!bl2) {
            object2 = new File((String)object);
            boolean bl3 = b.b((File)object2);
            if (bl3) {
                return false;
            }
            object = b.a((File)object2);
            bl2 = TextUtils.isEmpty((CharSequence)object);
            return !bl2 && (bl3 = ((String)object).startsWith((String)(object2 = "image/")));
        }
        object = new IllegalArgumentException("get image path is null");
        throw object;
    }

    public static boolean b(Context object, Uri object2) {
        int n10 = TextUtils.isEmpty((CharSequence)(object = b.c((Context)object, (Uri)object2)));
        if (n10 == 0) {
            int n11;
            object2 = new File((String)object);
            boolean bl2 = b.b((File)object2);
            if (bl2) {
                return false;
            }
            object = ((File)object2).getName();
            object2 = ".";
            n10 = ((String)object).lastIndexOf((String)object2);
            boolean bl3 = true;
            if (n10 < 0 || (n10 = (int)(TextUtils.isEmpty((CharSequence)(object = ((String)object).substring(n10))) ? 1 : 0)) != 0 && (n10 = ((String)object).length()) < (n11 = 2)) {
                object = "*/*";
            } else {
                object = ((String)object).substring((int)(bl3 ? 1 : 0)).toLowerCase();
                object2 = MimeTypeMap.getSingleton();
                object = object2.getMimeTypeFromExtension((String)object);
            }
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 == 0 && (bl2 = ((String)object).startsWith((String)(object2 = "video/")))) {
                return bl3;
            }
            return false;
        }
        object = new IllegalArgumentException("get video path is null");
        throw object;
    }

    private static boolean b(File object) {
        boolean bl2;
        Object object2 = ((File)object).getParent();
        if (object2 != null) {
            object2 = ((File)object).getParentFile().getCanonicalFile();
            object = ((File)object).getName();
            File file = new File((File)object2, (String)object);
            object = file;
        }
        return !(bl2 = ((File)(object2 = ((File)object).getCanonicalFile())).equals(object = ((File)object).getAbsoluteFile()));
    }

    private static String c(Context object, Uri object2) {
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
            object3 = object2.getAuthority();
            n10 = (int)("com.android.externalstorage.documents".equals(object3) ? 1 : 0);
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
                String string3 = "com.android.providers.downloads.documents";
                object3 = object2.getAuthority();
                n10 = (int)(string3.equals(object3) ? 1 : 0);
                if (n10 != 0) {
                    object2 = DocumentsContract.getDocumentId((Uri)object2);
                    object3 = Uri.parse((String)"content://downloads/public_downloads");
                    long l10 = Long.valueOf((String)object2);
                    object2 = ContentUris.withAppendedId((Uri)object3, (long)l10);
                    return b.a((Context)object, (Uri)object2, null, null);
                }
                string3 = "com.android.providers.media.documents";
                object3 = object2.getAuthority();
                n10 = (int)(string3.equals(object3) ? 1 : 0);
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
                    return b.a((Context)object, uri, "_id=?", object3);
                }
            }
        } else {
            String string4 = "content";
            object3 = object2.getScheme();
            n10 = (int)(string4.equalsIgnoreCase((String)object3) ? 1 : 0);
            if (n10 != 0) {
                string4 = "com.google.android.apps.photos.content";
                object3 = object2.getAuthority();
                n10 = (int)(string4.equals(object3) ? 1 : 0);
                if (n10 != 0) {
                    return object2.getLastPathSegment();
                }
                return b.d((Context)object, (Uri)object2);
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

    public static String d(Context object, Uri object2) {
        object2 = object2.toString();
        int n10 = ((String)object2).lastIndexOf("/");
        object2 = ((String)object2).substring(n10);
        object = object.getExternalFilesDir(null);
        File file = new File((File)object, (String)object2);
        return file.getAbsolutePath();
    }

    public static long e(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        long l10 = 0L;
        if (bl2) {
            return l10;
        }
        File file = new File(string2);
        bl2 = file.exists();
        if (!bl2) {
            return l10;
        }
        file = new MediaMetadataRetriever();
        file.setDataSource(string2);
        return Long.parseLong(file.extractMetadata(9));
    }
}

