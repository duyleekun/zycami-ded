/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentUris
 *  android.content.ContentValues
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.DocumentsContract
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Files
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  android.webkit.MimeTypeMap
 *  d.v.e.l.h1
 */
package d.v.e.l;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import d.v.e.f;
import d.v.e.l.h1;
import d.v.e.l.u1;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import m.a.a;

public final class s1 {
    private s1() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    /*
     * WARNING - void declaration
     */
    public static File A(String object, String string2) {
        void var1_3;
        File file = new File((String)object);
        boolean bl2 = file.exists();
        if (!bl2) {
            return null;
        }
        bl2 = file.isFile();
        if (bl2) {
            String string3 = file.getName();
            bl2 = string3.endsWith((String)var1_3);
            if (bl2) {
                return file;
            }
        } else {
            for (File file2 : file.listFiles()) {
                String string4;
                boolean bl3 = file2.isFile();
                if (!(bl3 ? !(bl3 = file2.isHidden()) && (bl3 = (string4 = file2.getName()).endsWith((String)var1_3)) : (bl3 = file2.isDirectory()) && (file2 = s1.A(file2.getPath(), (String)var1_3)) != null && (bl3 = (string4 = file2.getName()).endsWith((String)var1_3)))) continue;
                return file2;
            }
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public static File B(String object, String string2) {
        void var1_3;
        File file = new File((String)object);
        boolean bl2 = file.exists();
        if (!bl2) {
            return null;
        }
        bl2 = file.isFile();
        if (bl2) {
            String string3 = file.getName();
            bl2 = string3.endsWith((String)var1_3);
            if (bl2) {
                return file;
            }
        } else {
            for (File file2 : file.listFiles()) {
                String string4;
                boolean bl3 = file2.isFile();
                if (!(bl3 ? !(bl3 = file2.isHidden()) && (bl3 = (string4 = file2.getName()).endsWith((String)var1_3)) : (bl3 = file2.isDirectory()) && (file2 = s1.B(file2.getPath(), (String)var1_3)) != null && (bl3 = (string4 = file2.getName()).endsWith((String)var1_3)))) continue;
                return file2;
            }
        }
        return null;
    }

    public static String C(File object) {
        boolean bl2 = s1.e0((File)object);
        object = bl2 ? ((File)object).getName() : "";
        return object;
    }

    public static String D(String string2) {
        boolean bl2 = s1.f0(string2);
        if (bl2) {
            File file = new File(string2);
            string2 = s1.C(file);
        } else {
            string2 = "";
        }
        return string2;
    }

    public static String E(String string2) {
        if (string2 != null) {
            string2 = s1.D(string2);
            String string3 = "[.][^.]+$";
            String string4 = "";
            string2 = string2.replaceAll(string3, string4);
        } else {
            string2 = null;
        }
        return string2;
    }

    public static String F(Context object, Uri object2) {
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
            n10 = (int)(s1.P((Uri)object2) ? 1 : 0);
            String string2 = ":";
            if (n10 != 0) {
                object3 = "primary";
                object = TextUtils.split((String)DocumentsContract.getDocumentId((Uri)object2), (String)string2);
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
                n10 = (int)(s1.N((Uri)object2) ? 1 : 0);
                if (n10 != 0) {
                    n11 = (int)(((String)(object2 = DocumentsContract.getDocumentId((Uri)object2))).startsWith((String)(object3 = "raw:")) ? 1 : 0);
                    if (n11 != 0) {
                        return ((String)object2).replaceFirst((String)object3, "");
                    }
                    object3 = Uri.parse((String)"content://downloads/public_downloads");
                    long l10 = Long.valueOf((String)object2);
                    object2 = ContentUris.withAppendedId((Uri)object3, (long)l10);
                    return s1.u((Context)object, (Uri)object2, null, null);
                }
                n10 = (int)(s1.Y((Uri)object2) ? 1 : 0);
                if (n10 != 0) {
                    string2 = "image";
                    object3 = (object2 = TextUtils.split((String)DocumentsContract.getDocumentId((Uri)object2), (String)string2))[0];
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
                    return s1.u((Context)object, uri, "_id=?", object3);
                }
            }
        } else {
            String string3 = "content";
            object3 = object2.getScheme();
            n10 = (int)(string3.equalsIgnoreCase((String)object3) ? 1 : 0);
            if (n10 != 0) {
                n10 = (int)(s1.V((Uri)object2) ? 1 : 0);
                if (n10 != 0) {
                    return object2.getLastPathSegment();
                }
                return s1.u((Context)object, (Uri)object2, null, null);
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

    public static String G(Uri object) {
        String string2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11 && (n10 = (int)(Environment.isExternalStorageLegacy() ? 1 : 0)) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0 && (string2 = s1.F(s1.a(), object)) != null) {
            string2 = s1.a();
            object = s1.F((Context)string2, object);
        } else {
            object = object.toString();
        }
        return object;
    }

    public static String H(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string2;
        }
        return s1.G(Uri.parse((String)string2));
    }

    public static String I(File object) {
        int n10;
        int n11 = s1.e0((File)object);
        String string2 = "";
        if (n11 != 0 && (n11 = ((String)(object = ((File)object).getName())).lastIndexOf(46)) != (n10 = -1)) {
            string2 = ((String)object).substring(++n11);
        }
        return string2;
    }

    public static String J(String string2) {
        boolean bl2 = s1.f0(string2);
        if (bl2) {
            File file = new File(string2);
            string2 = s1.I(file);
        } else {
            string2 = "";
        }
        return string2;
    }

    public static String K(Uri object) {
        object = s1.t().getType(object);
        return MimeTypeMap.getSingleton().getExtensionFromMimeType((String)object);
    }

    public static String L(Context context, String string2) {
        return s1.K(Uri.parse((String)string2));
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static long M(Uri uri) {
        Throwable throwable2222222;
        InputStream inputStream;
        block10: {
            inputStream = null;
            ContentResolver contentResolver = s1.t();
            inputStream = contentResolver.openInputStream(uri);
            int n10 = inputStream.available();
            {
                catch (Throwable throwable2222222) {
                    break block10;
                }
                catch (IOException iOException) {}
                {
                    iOException.printStackTrace();
                    if (inputStream == null) return 0L;
                }
                try {
                    inputStream.close();
                    return 0L;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                return 0L;
            }
            long l10 = n10;
            if (inputStream == null) return l10;
            try {
                inputStream.close();
                return l10;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                return l10;
            }
        }
        if (inputStream == null) throw throwable2222222;
        try {
            inputStream.close();
            throw throwable2222222;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        throw throwable2222222;
    }

    public static boolean N(Uri object) {
        object = object.getAuthority();
        return "com.android.providers.downloads.documents".equals(object);
    }

    public static boolean O(File stringArray) {
        boolean bl2 = s1.e0((File)stringArray);
        boolean bl3 = true;
        if (bl2) {
            block6: {
                block5: {
                    bl2 = false;
                    try {
                        boolean bl4 = stringArray.isDirectory();
                        if (!bl4) break block5;
                    }
                    catch (SecurityException securityException) {
                        securityException.printStackTrace();
                        return false;
                    }
                    stringArray = stringArray.list();
                    int n10 = stringArray.length;
                    if (n10 == 0) break block6;
                }
                bl3 = false;
            }
            return bl3;
        }
        return bl3;
    }

    public static boolean P(Uri object) {
        object = object.getAuthority();
        return "com.android.externalstorage.documents".equals(object);
    }

    public static boolean Q(Uri uri) {
        String string2;
        ContentResolver contentResolver;
        try {
            contentResolver = s1.t();
            string2 = "r";
        }
        catch (Exception exception) {
            return false;
        }
        contentResolver.openFileDescriptor(uri, string2);
        return true;
    }

    public static boolean R(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        return s1.Q(Uri.parse((String)string2));
    }

    public static boolean S(String string2) {
        int n10;
        block6: {
            float f10;
            float f11;
            int n11;
            block5: {
                BitmapFactory.Options options;
                int n12;
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                n11 = 0;
                f11 = 0.0f;
                n10 = 1;
                f10 = Float.MIN_VALUE;
                if (!bl2 && (n12 = ((BitmapFactory.Options)(options = TextUtils.split((String)string2, (String)"\\."))).length) > n10) {
                    n12 = 5;
                    String string3 = "bmp";
                    String string4 = "jpeg";
                    String string5 = "gif";
                    String[] stringArray = new String[]{"jpg", "png", string3, string4, string5};
                    int n13 = ((BitmapFactory.Options)options).length - n10;
                    options = options[n13];
                    for (n13 = 0; n13 < n12; ++n13) {
                        string3 = stringArray[n13];
                        boolean bl3 = string3.equalsIgnoreCase((String)options);
                        if (!bl3) continue;
                        n11 = n10;
                        f11 = f10;
                        break;
                    }
                }
                if (n11 != 0) break block5;
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = n10;
                BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)options);
                int n14 = options.outHeight;
                if (n14 > 0 && (n14 = options.outWidth) > 0) break block6;
            }
            n10 = n11;
            f10 = f11;
        }
        return n10 != 0;
    }

    public static boolean T(File file) {
        boolean bl2;
        if (file != null && (bl2 = file.exists()) && !(bl2 = file.isDirectory())) {
            return file.getAbsolutePath().toLowerCase().endsWith(".mp4");
        }
        return false;
    }

    public static boolean U(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        File file = new File(string2);
        return s1.T(file);
    }

    public static boolean V(Uri object) {
        object = object.getAuthority();
        return "com.google.android.apps.photos.content".equals(object);
    }

    public static boolean W(File object) {
        int n10 = s1.e0((File)object);
        if (n10 != 0) {
            object = s1.I((File)object).toLowerCase();
            ((String)object).hashCode();
            n10 = -1;
            int n11 = ((String)object).hashCode();
            int n12 = 1;
            switch (n11) {
                default: {
                    break;
                }
                case 3268712: {
                    String string2 = "jpeg";
                    boolean bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 2;
                    break;
                }
                case 111145: {
                    String string3 = "png";
                    boolean bl3 = ((String)object).equals(string3);
                    if (!bl3) break;
                    n10 = n12;
                    break;
                }
                case 105441: {
                    String string4 = "jpg";
                    boolean bl4 = ((String)object).equals(string4);
                    if (!bl4) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    return false;
                }
                case 0: 
                case 1: 
                case 2: 
            }
            return n12 != 0;
        }
        return false;
    }

    public static boolean X(String string2) {
        File file;
        boolean bl2;
        boolean bl3 = s1.f0(string2);
        if (bl3 && (bl2 = s1.W(file = new File(string2)))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static boolean Y(Uri object) {
        object = object.getAuthority();
        return "com.android.providers.media.documents".equals(object);
    }

    public static boolean Z(String string2, String string3) {
        if (string2 != null && string3 != null) {
            StringBuilder stringBuilder;
            String string4 = "/";
            boolean bl2 = string2.endsWith(string4);
            if (!bl2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(string4);
                string2 = stringBuilder.toString();
            }
            bl2 = string3.endsWith(string4);
            if (!bl2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(string4);
                string3 = stringBuilder.toString();
            }
            return string2.equalsIgnoreCase(string3);
        }
        return false;
    }

    private static Context a() {
        return f.a().b();
    }

    public static boolean a0(File object) {
        String string2;
        boolean bl2;
        boolean bl3 = s1.e0((File)object);
        if (bl3 && (bl2 = ((String)(object = s1.I((File)object))).endsWith(string2 = "mp4"))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static void b(String object, String object2, boolean bl2) {
        boolean bl3;
        boolean bl4 = ((String)object).equals(object2);
        if (bl4) {
            return;
        }
        File file = new File((String)object);
        object = new File((String)object2);
        if (bl2 && (bl3 = ((File)object).exists())) {
            ((File)object).delete();
        }
        object2 = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream((File)object);
        s1.e((FileInputStream)object2, fileOutputStream);
    }

    public static boolean b0(String string2) {
        File file;
        boolean bl2;
        boolean bl3 = s1.f0(string2);
        if (bl3 && (bl2 = s1.a0(file = new File(string2)))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static boolean c(Context object, String string2, Uri uri) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && uri != null) {
            void var0_5;
            FileInputStream fileInputStream;
            OutputStream outputStream;
            block15: {
                block14: {
                    bl2 = false;
                    outputStream = null;
                    fileInputStream = new FileInputStream(string2);
                    object = object.getContentResolver();
                    outputStream = object.openOutputStream(uri);
                    int n10 = 4096;
                    try {
                        object = new byte[n10];
                    }
                    catch (Exception exception) {
                        break block14;
                    }
                    while (true) {
                        int n11 = ((InputStream)fileInputStream).read((byte[])object);
                        int n12 = -1;
                        if (n11 == n12) break;
                        outputStream.write((byte[])object, 0, n11);
                        outputStream.flush();
                        continue;
                        break;
                    }
                    u1.a(outputStream);
                    u1.a(fileInputStream);
                    return true;
                    catch (Throwable throwable) {
                        fileInputStream = null;
                        break block15;
                    }
                    catch (Exception exception) {
                        fileInputStream = null;
                    }
                }
                try {
                    object.printStackTrace();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                u1.a(outputStream);
                u1.a(fileInputStream);
                return false;
            }
            u1.a(outputStream);
            u1.a(fileInputStream);
            throw var0_5;
        }
        return false;
    }

    public static boolean c0(File file) {
        boolean bl2 = s1.e0(file);
        if (!bl2) {
            return false;
        }
        bl2 = s1.p(file);
        boolean bl3 = bl2 ? true : file.mkdirs();
        return bl3;
    }

    public static boolean d(File object, File file) {
        FileInputStream fileInputStream;
        boolean bl2 = s1.p((File)object);
        if (!bl2) {
            return false;
        }
        bl2 = s1.e0(file);
        if (!bl2) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream((File)object);
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            return false;
        }
        object = new FileOutputStream(file);
        return s1.e(fileInputStream, (FileOutputStream)object);
    }

    public static boolean d0(String string2) {
        File file;
        boolean bl2;
        boolean bl3 = s1.f0(string2);
        if (bl3 && (bl2 = s1.c0(file = new File(string2)))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean e(FileInputStream closeable, FileOutputStream fileOutputStream) {
        void var1_8;
        Closeable closeable2;
        block8: {
            block9: {
                Objects.requireNonNull(closeable);
                Objects.requireNonNull(fileOutputStream);
                closeable2 = null;
                try {
                    closeable = ((FileInputStream)closeable).getChannel();
                }
                catch (Throwable throwable) {
                    closeable = null;
                    break block8;
                }
                catch (IOException iOException) {
                    closeable = null;
                    break block9;
                }
                try {
                    closeable2 = fileOutputStream.getChannel();
                    long l10 = 0L;
                    long l11 = ((FileChannel)closeable).size();
                    ((FileChannel)closeable).transferTo(l10, l11, (WritableByteChannel)closeable2);
                }
                catch (Throwable throwable) {
                    FileChannel fileChannel = closeable2;
                    closeable2 = closeable;
                    closeable = fileChannel;
                    break block8;
                }
                catch (IOException iOException) {
                    FileChannel fileChannel = closeable2;
                    closeable2 = closeable;
                    closeable = fileChannel;
                    break block9;
                }
                u1.a(closeable);
                u1.a(closeable2);
                return true;
            }
            try {
                void var1_6;
                var1_6.printStackTrace();
            }
            catch (Throwable throwable) {
                // empty catch block
                break block8;
            }
            u1.a(closeable2);
            u1.a(closeable);
            return false;
        }
        u1.a(closeable2);
        u1.a(closeable);
        throw var1_8;
    }

    private static boolean e0(File file) {
        boolean bl2;
        if (file != null) {
            bl2 = true;
        } else {
            bl2 = false;
            file = null;
        }
        return bl2;
    }

    public static boolean f(String object, String string2) {
        boolean bl2 = s1.f0((String)object);
        if (bl2 && (bl2 = s1.f0(string2))) {
            File file = new File((String)object);
            object = new File(string2);
            return s1.d(file, (File)object);
        }
        return false;
    }

    private static boolean f0(String string2) {
        boolean bl2;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static boolean g(File file) {
        boolean bl2 = s1.e0(file);
        if (bl2 && (bl2 = file.exists())) {
            String[] stringArray;
            bl2 = file.isDirectory();
            if (bl2 && (stringArray = file.list()) != null) {
                for (String string2 : stringArray) {
                    File file2 = new File(file, string2);
                    boolean bl3 = s1.g(file2);
                    if (bl3) continue;
                    return false;
                }
            }
            return file.delete();
        }
        return true;
    }

    public static List g0(String charSequence) {
        int n10;
        String string2;
        ArrayList<ContentResolver> arrayList = new ArrayList<ContentResolver>();
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        Object object = n11 >= n12 ? "relative_path" : "_data";
        if (n11 < n12) {
            StringBuilder stringBuilder = new StringBuilder();
            string2 = Environment.getExternalStorageDirectory().getPath();
            stringBuilder.append(string2);
            string2 = File.separator;
            stringBuilder.append(string2);
            stringBuilder.append((String)charSequence);
            charSequence = stringBuilder.toString();
        }
        n11 = 1;
        String[] stringArray = new String[n11];
        n12 = 0;
        string2 = null;
        stringArray[0] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object);
        object = "=?";
        ((StringBuilder)charSequence).append((String)object);
        String string3 = ((StringBuilder)charSequence).toString();
        Object object2 = MediaStore.Files.getContentUri((String)"external");
        Object object3 = s1.t();
        int n13 = 0;
        Object[] objectArray = null;
        charSequence = object3.query(object2, null, string3, stringArray, null);
        while ((n10 = charSequence.moveToNext()) != 0) {
            n10 = charSequence.getColumnIndex("_id");
            n10 = charSequence.getInt(n10);
            int n14 = charSequence.getColumnIndex("_display_name");
            object3 = charSequence.getString(n14);
            int n15 = charSequence.getColumnIndex("mime_type");
            object2 = charSequence.getString(n15);
            n13 = 3;
            objectArray = new Object[n13];
            objectArray[0] = object = Integer.valueOf(n10);
            objectArray[n11] = object3;
            n10 = 2;
            objectArray[n10] = object2;
            object = "id = %s ,Name = %s  ,type = %s";
            a.b((String)object, objectArray);
            arrayList.add((ContentResolver)object3);
        }
        charSequence.close();
        return arrayList;
    }

    public static boolean h(String string2) {
        File file;
        boolean bl2;
        boolean bl3 = s1.f0(string2);
        if (bl3 && !(bl2 = s1.g(file = new File(string2)))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static Uri h0(String string2, String string3) {
        boolean bl2;
        Object[] objectArray;
        CharSequence charSequence;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        String string4 = n10 >= n11 ? "relative_path" : "_data";
        if (n10 >= n11) {
            charSequence = string2;
        } else {
            charSequence = new StringBuilder();
            objectArray = Environment.getExternalStorageDirectory().getPath();
            ((StringBuilder)charSequence).append((String)objectArray);
            objectArray = File.separator;
            ((StringBuilder)charSequence).append((String)objectArray);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        n11 = 2;
        String[] stringArray = new String[n11];
        stringArray[0] = charSequence;
        n10 = 1;
        stringArray[n10] = string3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string4);
        stringBuilder.append("=? and ");
        stringBuilder.append("_display_name");
        stringBuilder.append("=?");
        String string5 = stringBuilder.toString();
        string4 = MediaStore.Files.getContentUri((String)"external");
        stringBuilder = s1.t().query((Uri)string4, null, string5, stringArray, null);
        if (stringBuilder != null && (bl2 = stringBuilder.moveToFirst())) {
            objectArray = new Object[n11];
            objectArray[0] = string2;
            objectArray[n10] = string3;
            a.b("----find file  path = %s , name = %s", objectArray);
            int n12 = stringBuilder.getColumnIndex("_id");
            long l10 = stringBuilder.getInt(n12);
            return ContentUris.withAppendedId((Uri)string4, (long)l10);
        }
        return null;
    }

    public static void i(Uri uri) {
        if (uri != null) {
            ContentResolver contentResolver = s1.t();
            try {
                contentResolver.delete(uri, null, null);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static byte[] i0(File object) {
        void var0_5;
        FileInputStream fileInputStream;
        block11: {
            FileInputStream fileInputStream2;
            block10: {
                fileInputStream = null;
                fileInputStream2 = new FileInputStream((File)object);
                long l10 = ((File)object).length();
                int n10 = (int)l10;
                object = new byte[n10];
                try {
                    fileInputStream2.read((byte[])object);
                }
                catch (IOException iOException) {
                    break block10;
                }
                u1.a(fileInputStream2);
                return object;
                catch (Throwable throwable) {
                    break block11;
                }
                catch (IOException iOException) {
                    fileInputStream2 = null;
                }
            }
            try {
                ((Throwable)object).printStackTrace();
            }
            catch (Throwable throwable) {
                fileInputStream = fileInputStream2;
            }
            u1.a(fileInputStream2);
            return null;
        }
        u1.a(fileInputStream);
        throw var0_5;
    }

    public static void j(Uri uri) {
        if (uri != null) {
            ContentResolver contentResolver = s1.t();
            contentResolver.delete(uri, null, null);
        }
    }

    public static boolean j0(Context context, Bitmap bitmap, Uri uri) {
        int n10;
        Bitmap.CompressFormat compressFormat;
        int n11;
        boolean bl2 = false;
        if (bitmap != null && context != null && uri != null && (n11 = h1.C((Context)context, (Bitmap)bitmap, (Bitmap.CompressFormat)(compressFormat = Bitmap.CompressFormat.JPEG), (int)(n10 = 100), (Uri)uri)) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public static String k(String string2) {
        int n10;
        String string3 = ".";
        int n11 = string2.lastIndexOf(string3);
        if (n11 < (n10 = -1)) {
            return string2;
        }
        return string2.substring(0, n11);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean k0(Context var0, byte[] var1_6, Uri var2_7) {
        block9: {
            if (var1_6 == null) return false;
            var3_8 = var1_6.length;
            if (var3_8 == 0) {
                return false;
            }
            if (var2_7 == null) {
                return false;
            }
            var3_8 = 0;
            var4_9 = null;
            try {
                var0 = var0.getContentResolver();
                var0 = var0.openOutputStream((Uri)var2_7);
                var2_7 = new BufferedOutputStream((OutputStream)var0);
            }
            catch (Throwable var0_3) {
                break block9;
            }
            catch (IOException var0_4) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var2_7.write(var1_6);
                var2_7.flush();
            }
            catch (Throwable var0_1) {
                var4_9 = var2_7;
                break block9;
            }
            catch (IOException var0_2) {
                var4_9 = var2_7;
                ** GOTO lbl-1000
            }
            u1.a((Closeable)var2_7);
            return true;
lbl-1000:
            // 2 sources

            {
                var0.printStackTrace();
            }
            u1.a(var4_9);
            return false;
        }
        u1.a(var4_9);
        throw var0_5;
    }

    public static boolean l(File file) {
        boolean bl2;
        boolean bl3 = file.exists();
        if (bl3 && (bl3 = file.isDirectory())) {
            bl2 = true;
        } else {
            try {
                bl2 = file.mkdirs();
            }
            catch (SecurityException securityException) {
                securityException.printStackTrace();
                bl2 = false;
                file = null;
            }
        }
        return bl2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean l0(Bitmap var0, String var1_6) {
        block8: {
            if (var0 == null) return false;
            var2_7 = s1.f0(var1_6);
            if (var2_7 == 0) {
                return false;
            }
            var2_7 = 0;
            var3_8 = null;
            try {
                var5_10 = new FileOutputStream(var1_6);
                var4_9 = new BufferedOutputStream(var5_10);
            }
            catch (Throwable var0_3) {
                break block8;
            }
            catch (IOException var0_4) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var1_6 = Bitmap.CompressFormat.JPEG;
                var2_7 = 100;
                var0.compress((Bitmap.CompressFormat)var1_6, var2_7, (OutputStream)var4_9);
                var4_9.flush();
                var4_9.close();
            }
            catch (Throwable var0_1) {
                var3_8 = var4_9;
                break block8;
            }
            catch (IOException var0_2) {
                var3_8 = var4_9;
                ** GOTO lbl-1000
            }
            u1.a(var4_9);
            return true;
lbl-1000:
            // 2 sources

            {
                var0.printStackTrace();
            }
            u1.a(var3_8);
            return false;
        }
        u1.a(var3_8);
        throw var0_5;
    }

    public static boolean m(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        File file = new File(string2);
        return s1.l(file);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean m0(byte[] var0, String var1_6) {
        block9: {
            if (var0 == null) return false;
            var2_7 = var0.length;
            if (var2_7 == 0) {
                return false;
            }
            var2_7 = (int)s1.f0((String)var1_6);
            if (var2_7 == 0) {
                return false;
            }
            var2_7 = 0;
            var3_8 = null;
            try {
                var4_9 = new FileOutputStream((String)var1_6);
                var1_6 = new BufferedOutputStream(var4_9);
            }
            catch (Throwable var0_3) {
                break block9;
            }
            catch (IOException var0_4) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var1_6.write(var0);
                var1_6.flush();
            }
            catch (Throwable var0_1) {
                var3_8 = var1_6;
                break block9;
            }
            catch (IOException var0_2) {
                var3_8 = var1_6;
                ** GOTO lbl-1000
            }
            u1.a((Closeable)var1_6);
            return true;
lbl-1000:
            // 2 sources

            {
                var0.printStackTrace();
            }
            u1.a(var3_8);
            return false;
        }
        u1.a(var3_8);
        throw var0_5;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean n(String string2) {
        boolean bl2 = false;
        if (string2 == null) {
            return false;
        }
        File file = new File(string2);
        boolean bl3 = file.exists();
        boolean bl4 = true;
        if (bl3) {
            bl3 = file.isFile();
            if (bl3) return bl4;
        }
        try {
            file.createNewFile();
            return bl4;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return bl2;
        }
    }

    public static Uri n0(Context context, String charSequence) {
        File file = new File((String)charSequence);
        charSequence = new StringBuilder();
        String string2 = context.getPackageName();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(".provider");
        charSequence = ((StringBuilder)charSequence).toString();
        return FileProvider.getUriForFile(context, (String)charSequence, file);
    }

    public static boolean o(String string2) {
        return s1.m(s1.v(string2));
    }

    public static int o0(Uri uri, String string2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", string2);
        return s1.t().update(uri, contentValues, null, null);
    }

    public static boolean p(File file) {
        boolean bl2;
        boolean bl3 = s1.e0(file);
        if (bl3 && (bl2 = file.exists())) {
            bl2 = true;
        } else {
            bl2 = false;
            file = null;
        }
        return bl2;
    }

    public static int p0(Uri uri, String string2) {
        ContentValues contentValues = new ContentValues();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        String string3 = n10 >= n11 ? "relative_path" : "_data";
        if (n10 < n11) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = Environment.getExternalStorageDirectory().getPath();
            stringBuilder.append(string4);
            string4 = File.separator;
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        contentValues.put(string3, string2);
        return s1.t().update(uri, contentValues, null, null);
    }

    public static boolean q(String string2) {
        boolean bl2;
        boolean bl3 = s1.r(string2);
        if (!bl3 && !(bl2 = s1.R(string2))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean r(String string2) {
        File file;
        boolean bl2;
        boolean bl3 = s1.f0(string2);
        if (bl3 && (bl2 = s1.p(file = new File(string2)))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static void s(String string2, String string3) {
        if ((string2 = s1.h0(string2, string3)) != null) {
            s1.i((Uri)string2);
        }
    }

    private static ContentResolver t() {
        return s1.a().getContentResolver();
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String u(Context context, Uri object, String string2, String[] objectArray) {
        void var1_9;
        Context context2;
        block9: {
            block10: {
                Object[] objectArray2;
                String string3;
                String string4;
                block8: {
                    block7: {
                        String string5;
                        string4 = "_data";
                        String[] stringArray = new String[]{string4};
                        context2 = null;
                        ContentResolver contentResolver = context.getContentResolver();
                        context = contentResolver.query(object, stringArray, string3, (String[])objectArray2, null);
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
                string3 = "getDataColumn: _data - [%s]";
                int n11 = 1;
                try {
                    void var1_6;
                    objectArray2 = new Object[n11];
                    string4 = null;
                    String string6 = var1_6.getMessage();
                    objectArray2[0] = string6;
                    a.i(string3, objectArray2);
                    if (context == null) return null;
                }
                catch (Throwable throwable) {
                    context2 = context;
                }
            }
            context.close();
            return null;
        }
        if (context2 == null) throw var1_9;
        context2.close();
        throw var1_9;
    }

    public static String v(String string2) {
        File file = new File(string2);
        return file.getParent();
    }

    public static long w(File fileArray) {
        long l10;
        block9: {
            block10: {
                l10 = 0L;
                int n10 = fileArray.exists();
                if (n10 == 0) break block9;
                n10 = fileArray.isDirectory();
                if (n10 == 0) break block10;
                fileArray = fileArray.listFiles();
                if (fileArray == null) break block9;
                n10 = 0;
                while (true) {
                    int n11 = fileArray.length;
                    if (n10 >= n11) break block9;
                    File file = fileArray[n10];
                    long l11 = s1.w(file);
                    l10 += l11;
                    ++n10;
                    continue;
                    break;
                }
            }
            try {
                l10 = fileArray.length();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return l10;
    }

    public static long x(String string2) {
        File file = new File(string2);
        return s1.w(file);
    }

    public static String y(String string2, String string3) {
        int n10;
        String string4;
        int n11;
        if (string2 != null && (n11 = string2.lastIndexOf(string4 = ".")) != (n10 = -1)) {
            int n12 = string2.length();
            string3 = string2.substring(++n11, n12);
        }
        return string3;
    }

    public static String z(String string2) {
        if (string2 != null) {
            String string3 = "/";
            int n10 = string2.lastIndexOf(string3);
            if (n10 > 0) {
                string2 = string2.substring(++n10);
            }
        } else {
            string2 = null;
        }
        return string2;
    }
}

