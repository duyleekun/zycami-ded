/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.ProviderInfo
 *  android.database.Cursor
 *  android.database.MatrixCursor
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.ParcelFileDescriptor
 *  android.webkit.MimeTypeMap
 */
package cn.sharesdk.framework.utils;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider$PathStrategy;
import cn.sharesdk.framework.utils.ShareSDKFileProvider$a;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public class ShareSDKFileProvider
extends ContentProvider {
    private static final String[] a;
    private static final File b;
    private static HashMap c;
    private ShareSDKFileProvider$PathStrategy d;

    static {
        Serializable serializable;
        a = new String[]{"_display_name", "_size"};
        b = serializable = new File("/");
        serializable = new HashMap();
        c = serializable;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int a(String string2) {
        Object object = "r";
        boolean bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x10000000;
        }
        object = "w";
        bl2 = ((String)object).equals(string2);
        if (bl2) return 0x2C000000;
        object = "wt";
        bl2 = ((String)object).equals(string2);
        if (bl2) return 0x2C000000;
        object = "wa";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x2A000000;
        }
        object = "rw";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x38000000;
        }
        object = "rwt";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x3C000000;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid mode: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static Uri a(Context context, String string2, File file) {
        return ShareSDKFileProvider.a(context, string2).getUriForFile(file);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ShareSDKFileProvider$PathStrategy a(Context object, String charSequence) {
        Object object2;
        Object[] objectArray = c;
        synchronized (objectArray) {
            object2 = c;
            object2 = ((HashMap)object2).get(charSequence);
            object2 = (ShareSDKFileProvider$PathStrategy)object2;
            if (object2 == null) {
                object2 = ShareSDKFileProvider.b((Context)object, (String)charSequence);
                object = c;
                ((HashMap)object).put(charSequence, object2);
            }
        }
        object = SSDKLog.b();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("ShareSDKFileProvider getPathStrategy strat ");
        ((StringBuilder)charSequence).append(object2);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray = new Object[]{};
        ((NLog)object).d(charSequence, objectArray);
        return object2;
    }

    private static File a(File file, String ... stringArray) {
        for (String string2 : stringArray) {
            File file2;
            if (string2 == null) continue;
            file = file2 = new File(file, string2);
        }
        return file;
    }

    public static File[] a(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        Object[] objectArray = null;
        int n11 = 19;
        if (n10 >= n11) {
            NLog nLog = SSDKLog.b();
            objectArray = new Object[]{};
            nLog.d("ShareSDKFileProvider api >= 19", objectArray);
            return object.getExternalFilesDirs(null);
        }
        File[] fileArray = SSDKLog.b();
        Object[] objectArray2 = new Object[]{};
        fileArray.d("ShareSDKFileProvider api <= 19", objectArray2);
        fileArray = new File[1];
        object = object.getExternalFilesDir(null);
        fileArray[0] = object;
        return fileArray;
    }

    private static Object[] a(Object[] objectArray, int n10) {
        Object[] objectArray2 = new Object[n10];
        System.arraycopy(objectArray, 0, objectArray2, 0, n10);
        return objectArray2;
    }

    private static String[] a(String[] stringArray, int n10) {
        String[] stringArray2 = new String[n10];
        System.arraycopy(stringArray, 0, stringArray2, 0, n10);
        return stringArray2;
    }

    private static ShareSDKFileProvider$PathStrategy b(Context object, String object2) {
        String[] stringArray;
        Object object3;
        Object object4;
        CharSequence charSequence;
        Object object5;
        ShareSDKFileProvider$a shareSDKFileProvider$a = new ShareSDKFileProvider$a((String)object2);
        object = object.getFilesDir();
        object2 = "Mob/cache/videos";
        Object object6 = "Mob/cache/images";
        Object[] objectArray = "ShareSDKFileProvider target ";
        if (object != null) {
            object5 = new String[]{object6};
            object5 = ShareSDKFileProvider.a((File)object, (String[])object5);
            shareSDKFileProvider$a.a("imageNameFilesDir", (File)object5);
            object5 = new String[]{object2};
            object5 = ShareSDKFileProvider.a((File)object, (String[])object5);
            shareSDKFileProvider$a.a("videoNameFilesDir", (File)object5);
            object5 = SSDKLog.b();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)objectArray);
            ((StringBuilder)charSequence).append(object);
            charSequence = ((StringBuilder)charSequence).toString();
            object4 = new Object[]{};
            ((NLog)object5).d(charSequence, object4);
        }
        object5 = new StringBuilder();
        charSequence = "Mob/";
        ((StringBuilder)object5).append((String)charSequence);
        object4 = MobSDK.getContext().getPackageName();
        ((StringBuilder)object5).append((String)object4);
        object4 = "/cache/images";
        ((StringBuilder)object5).append((String)object4);
        object5 = ((StringBuilder)object5).toString();
        Object[] objectArray2 = MobSDK.getContext().getCacheDir();
        Object[] objectArray3 = "imageNameExternal";
        String string2 = ".";
        int n10 = 1;
        if (objectArray2 != null) {
            object3 = new String[]{string2};
            object3 = ShareSDKFileProvider.a((File)object, object3);
            stringArray = "cachename";
            shareSDKFileProvider$a.a((String)stringArray, (File)object3);
            object3 = new String[n10];
            object3[0] = object5;
            object5 = ShareSDKFileProvider.a((File)object, object3);
            shareSDKFileProvider$a.a((String)objectArray3, (File)object5);
            object5 = new String[]{object6};
            object = ShareSDKFileProvider.a((File)object, (String[])object5);
            shareSDKFileProvider$a.a((String)objectArray3, (File)object);
            object = SSDKLog.b();
            object5 = new StringBuilder();
            ((StringBuilder)object5).append((String)objectArray);
            ((StringBuilder)object5).append(objectArray2);
            object5 = ((StringBuilder)object5).toString();
            objectArray2 = new Object[]{};
            ((NLog)object).d(object5, objectArray2);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)charSequence);
        object5 = MobSDK.getContext().getPackageName();
        ((StringBuilder)object).append((String)object5);
        ((StringBuilder)object).append((String)object4);
        object = ((StringBuilder)object).toString();
        object5 = new StringBuilder();
        ((StringBuilder)object5).append((String)charSequence);
        objectArray2 = MobSDK.getContext().getPackageName();
        ((StringBuilder)object5).append((String)objectArray2);
        objectArray2 = "/cache/videos";
        ((StringBuilder)object5).append((String)objectArray2);
        object5 = ((StringBuilder)object5).toString();
        object3 = ShareSDKFileProvider.a(MobSDK.getContext());
        int n11 = ((String[])object3).length;
        object3 = n11 > 0 ? object3[0] : null;
        if (object3 != null) {
            stringArray = new String[n10];
            stringArray[0] = object;
            object = ShareSDKFileProvider.a((File)object3, stringArray);
            shareSDKFileProvider$a.a((String)objectArray3, (File)object);
            object = new String[n10];
            object[0] = object5;
            object = ShareSDKFileProvider.a((File)object3, (String[])object);
            shareSDKFileProvider$a.a("videoNameExternal", (File)object);
            object = new String[]{string2};
            object = ShareSDKFileProvider.a((File)object3, (String[])object);
            shareSDKFileProvider$a.a("mihayou", (File)object);
            object = new String[]{"./."};
            object = ShareSDKFileProvider.a((File)object3, (String[])object);
            shareSDKFileProvider$a.a("more", (File)object);
            object = SSDKLog.b();
            object5 = new StringBuilder();
            ((StringBuilder)object5).append((String)objectArray);
            ((StringBuilder)object5).append(object3);
            object5 = ((StringBuilder)object5).toString();
            objectArray3 = new Object[]{};
            ((NLog)object).d(object5, objectArray3);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)charSequence);
        object5 = MobSDK.getContext().getPackageName();
        ((StringBuilder)object).append((String)object5);
        ((StringBuilder)object).append((String)object4);
        object = ((StringBuilder)object).toString();
        object5 = new StringBuilder();
        ((StringBuilder)object5).append((String)charSequence);
        charSequence = MobSDK.getContext().getPackageName();
        ((StringBuilder)object5).append((String)charSequence);
        ((StringBuilder)object5).append((String)objectArray2);
        object5 = ((StringBuilder)object5).toString();
        charSequence = ShareSDKFileProvider.b(MobSDK.getContext());
        int n12 = ((CharSequence)charSequence).length;
        charSequence = n12 > 0 ? charSequence[0] : null;
        if (charSequence != null) {
            object4 = new String[n10];
            object4[0] = object;
            object = ShareSDKFileProvider.a((File)((Object)charSequence), (String[])object4);
            object4 = "imageNameEtc";
            shareSDKFileProvider$a.a((String)object4, (File)object);
            object = new String[n10];
            object[0] = object5;
            object = ShareSDKFileProvider.a((File)((Object)charSequence), (String[])object);
            shareSDKFileProvider$a.a("videoNameEtc", (File)object);
            object = SSDKLog.b();
            object5 = new StringBuilder();
            ((StringBuilder)object5).append((String)objectArray);
            ((StringBuilder)object5).append((Object)charSequence);
            object5 = ((StringBuilder)object5).toString();
            charSequence = new Object[]{};
            ((NLog)object).d(object5, (Object[])charSequence);
        }
        if ((object = b) != null) {
            object6 = new String[]{object6};
            object6 = ShareSDKFileProvider.a(null, (String[])object6);
            object5 = "imageNameRoot";
            shareSDKFileProvider$a.a((String)object5, (File)object6);
            object2 = new String[]{object2};
            object2 = ShareSDKFileProvider.a(null, object2);
            object6 = "videoNameRoot";
            shareSDKFileProvider$a.a((String)object6, (File)object2);
        }
        if ((object2 = Environment.getExternalStorageDirectory()) != null) {
            object6 = new String[]{string2};
            object6 = ShareSDKFileProvider.a((File)object2, (String[])object6);
            shareSDKFileProvider$a.a("externalStDir", (File)object6);
            object6 = SSDKLog.b();
            object5 = new StringBuilder();
            ((StringBuilder)object5).append((String)objectArray);
            ((StringBuilder)object5).append(object2);
            object2 = ((StringBuilder)object5).toString();
            objectArray = new Object[]{};
            ((NLog)object6).d(object2, objectArray);
        }
        object2 = SSDKLog.b();
        object6 = new StringBuilder();
        ((StringBuilder)object6).append("ShareSDKFileProvider !!! target===> ");
        ((StringBuilder)object6).append(object);
        object = ((StringBuilder)object6).toString();
        object6 = new Object[]{};
        object2.d(object, (Object[])object6);
        return shareSDKFileProvider$a;
    }

    public static File[] b(Context object) {
        int n10 = Build.VERSION.SDK_INT;
        Object[] objectArray = null;
        int n11 = 19;
        if (n10 >= n11) {
            NLog nLog = SSDKLog.b();
            objectArray = new Object[]{};
            nLog.d("ShareSDKFileProvider api >= 19", objectArray);
            return object.getExternalCacheDirs();
        }
        File[] fileArray = SSDKLog.b();
        Object[] objectArray2 = new Object[]{};
        fileArray.d("ShareSDKFileProvider api <= 19", objectArray2);
        fileArray = new File[1];
        object = object.getExternalCacheDir();
        fileArray[0] = object;
        return fileArray;
    }

    public void attachInfo(Context object, ProviderInfo object2) {
        super.attachInfo((Context)object, (ProviderInfo)object2);
        boolean bl2 = ((ProviderInfo)object2).exported;
        if (!bl2) {
            bl2 = ((ProviderInfo)object2).grantUriPermissions;
            if (bl2) {
                Object[] objectArray = SSDKLog.b();
                Object[] objectArray2 = new Object[]{};
                objectArray.d("ShareSDKFileProvider attachInfo ", objectArray2);
                object2 = ((ProviderInfo)object2).authority;
                object = ShareSDKFileProvider.a((Context)object, (String)object2);
                this.d = object;
                object = SSDKLog.b();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("ShareSDKFileProvider attachInfo mStrategy===> ");
                objectArray = this.d;
                ((StringBuilder)object2).append(objectArray);
                object2 = ((StringBuilder)object2).toString();
                objectArray = new Object[]{};
                ((NLog)object).d(object2, objectArray);
                return;
            }
            object = SSDKLog.b();
            object2 = new Object[]{};
            ((NLog)object).d("ShareSDKFileProvider attachInfo ===> Provider must grant uri permissions", (Object[])object2);
            object = new SecurityException("Provider must grant uri permissions");
            throw object;
        }
        object = SSDKLog.b();
        object2 = new Object[]{};
        ((NLog)object).d("ShareSDKFileProvider attachInfo ===> Provider must not be exported", (Object[])object2);
        object = new SecurityException("Provider must not be exported");
        throw object;
    }

    public int delete(Uri uri, String string2, String[] stringArray) {
        return (int)(this.d.getFileForUri(uri).delete() ? 1 : 0);
    }

    public String getType(Uri object) {
        int n10;
        String string2 = ((File)(object = this.d.getFileForUri((Uri)object))).getName();
        int n11 = string2.lastIndexOf(n10 = 46);
        if (n11 >= 0) {
            object = ((File)object).getName();
            object = ((String)object).substring(++n11);
            string2 = MimeTypeMap.getSingleton();
            object = string2.getMimeTypeFromExtension((String)object);
            if (object != null) {
                return object;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri object, ContentValues contentValues) {
        object = new UnsupportedOperationException("No external inserts");
        throw object;
    }

    public boolean onCreate() {
        NLog nLog = SSDKLog.b();
        Object[] objectArray = new Object[]{};
        nLog.d("ShareSDKFileProvider onCreate ", objectArray);
        return true;
    }

    public ParcelFileDescriptor openFile(Uri object, String string2) {
        object = this.d.getFileForUri((Uri)object);
        int n10 = ShareSDKFileProvider.a(string2);
        return ParcelFileDescriptor.open((File)object, (int)n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public Cursor query(Uri stringArray, String[] objectArray, String object, String[] objectArray2, String string2) {
        object = this.d;
        stringArray = object.getFileForUri((Uri)stringArray);
        if (objectArray == null) {
            objectArray = a;
        }
        int n10 = objectArray.length;
        object = new String[n10];
        int n11 = objectArray.length;
        objectArray2 = new Object[n11];
        int n12 = objectArray.length;
        int n13 = 0;
        int n14 = 0;
        while (true) {
            block8: {
                int n15;
                block7: {
                    Object object2;
                    Object object3;
                    block6: {
                        if (n13 >= n12) {
                            stringArray = ShareSDKFileProvider.a((String[])object, n14);
                            objectArray = ShareSDKFileProvider.a(objectArray2, n14);
                            object = new MatrixCursor(stringArray, 1);
                            object.addRow(objectArray);
                            return object;
                        }
                        object3 = "_display_name";
                        object2 = objectArray[n13];
                        boolean bl2 = ((String)object3).equals(object2);
                        if (!bl2) break block6;
                        object[n14] = object3;
                        n15 = n14 + 1;
                        objectArray2[n14] = object3 = stringArray.getName();
                        break block7;
                    }
                    object3 = "_size";
                    n15 = ((String)object3).equals(object2);
                    if (n15 == 0) break block8;
                    object[n14] = object3;
                    n15 = n14 + 1;
                    long l10 = stringArray.length();
                    objectArray2[n14] = object3 = Long.valueOf(l10);
                }
                n14 = n15;
            }
            ++n13;
        }
    }

    public int update(Uri object, ContentValues contentValues, String string2, String[] stringArray) {
        object = new UnsupportedOperationException("No external updates");
        throw object;
    }
}

