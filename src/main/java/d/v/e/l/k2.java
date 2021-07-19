/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.usage.StorageStatsManager
 *  android.content.ContentValues
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.StatFs
 *  android.os.storage.StorageManager
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video$Media
 */
package d.v.e.l;

import android.app.usage.StorageStatsManager;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import d.v.e.f;
import d.v.e.l.d1;
import d.v.e.l.s1;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public final class k2 {
    private static final String a = "Zhiyun";
    private static final String b = d1.a().replace(' ', '_');
    private static final File c = k2.a().getCacheDir();
    private static final File d = k2.a().getExternalCacheDir();
    private static final File e = k2.a().getFilesDir();
    private static final File f = k2.q();
    private static File g;

    private k2() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static Uri A(String string2) {
        String string3 = Environment.DIRECTORY_DCIM;
        CharSequence charSequence = new StringBuilder();
        String string4 = b;
        charSequence.append(string4);
        string4 = File.separator;
        charSequence.append(string4);
        charSequence.append("Camera");
        charSequence = charSequence.toString();
        return k2.U(string3, (String)charSequence, string2);
    }

    public static Uri B(String string2) {
        String string3 = Environment.DIRECTORY_DCIM;
        CharSequence charSequence = new StringBuilder();
        String string4 = b;
        charSequence.append(string4);
        string4 = File.separator;
        charSequence.append(string4);
        charSequence.append("Editor");
        charSequence = charSequence.toString();
        return k2.U(string3, (String)charSequence, string2);
    }

    private static File C(String string2) {
        File file = f;
        File file2 = new File(file, string2);
        return file2;
    }

    private static File D(String object, String string2) {
        object = k2.r((String)object);
        File file = new File((File)object, string2);
        return file;
    }

    public static Uri E(String string2, String string3) {
        return k2.L(Environment.DIRECTORY_PICTURES, string2, string3);
    }

    public static Uri F(String string2, String charSequence) {
        ContentValues contentValues = new ContentValues();
        Object object = "_display_name";
        contentValues.put((String)object, (String)charSequence);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            charSequence = new StringBuilder();
            object = Environment.DIRECTORY_MUSIC;
            ((StringBuilder)charSequence).append((String)object);
            object = File.separator;
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            charSequence = "relative_path";
            contentValues.put((String)charSequence, string2);
        } else {
            object = new StringBuilder();
            String string3 = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_MUSIC).getPath();
            ((StringBuilder)object).append(string3);
            string3 = File.separator;
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            object = new File(string2);
            boolean bl2 = ((File)object).exists();
            if (!bl2) {
                ((File)object).mkdirs();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append((String)charSequence);
            string2 = ((StringBuilder)object).toString();
            charSequence = "_data";
            contentValues.put((String)charSequence, string2);
        }
        contentValues.put("mime_type", "audio/mp3");
        string2 = k2.a().getContentResolver();
        charSequence = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        return string2.insert((Uri)charSequence, contentValues);
    }

    public static Uri G(String string2) {
        String string3 = Environment.DIRECTORY_DCIM;
        CharSequence charSequence = new StringBuilder();
        String string4 = b;
        charSequence.append(string4);
        string4 = File.separator;
        charSequence.append(string4);
        charSequence.append("Script");
        charSequence = charSequence.toString();
        return k2.U(string3, (String)charSequence, string2);
    }

    public static Uri H(String string2, String string3) {
        return k2.U(Environment.DIRECTORY_DCIM, string2, string3);
    }

    private static File I(String string2) {
        File file = e;
        File file2 = new File(file, string2);
        return file2;
    }

    public static File J(String object) {
        object = k2.I((String)object);
        s1.c0((File)object);
        return object;
    }

    public static File K() {
        return k2.J("Firmware");
    }

    private static Uri L(String string2, String object, String charSequence) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        String string3 = File.separator;
        stringBuilder.append(string3);
        stringBuilder.append((String)object);
        stringBuilder.append(string3);
        stringBuilder = s1.h0(stringBuilder.toString(), (String)charSequence);
        if (stringBuilder != null) {
            return stringBuilder;
        }
        stringBuilder = new ContentValues();
        CharSequence charSequence2 = "_display_name";
        stringBuilder.put((String)charSequence2, (String)charSequence);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append((String)object);
            string2 = ((StringBuilder)charSequence).toString();
            object = "relative_path";
            stringBuilder.put((String)object, string2);
        } else {
            charSequence2 = new StringBuilder();
            string2 = Environment.getExternalStoragePublicDirectory((String)string2).getPath();
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append(string3);
            ((StringBuilder)charSequence2).append((String)object);
            string2 = ((StringBuilder)charSequence2).toString();
            object = new File(string2);
            n10 = (int)(((File)object).exists() ? 1 : 0);
            if (n10 == 0) {
                ((File)object).mkdirs();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append((String)charSequence);
            string2 = ((StringBuilder)object).toString();
            object = "_data";
            stringBuilder.put((String)object, string2);
        }
        stringBuilder.put("mime_type", "image/jpeg");
        string2 = k2.a().getContentResolver();
        object = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        return string2.insert((Uri)object, (ContentValues)stringBuilder);
    }

    public static File M() {
        return k2.J("assets");
    }

    public static File N() {
        return k2.j("Properties");
    }

    public static File O() {
        return k2.s("Script");
    }

    public static File P(String string2) {
        return k2.t(string2, "Script");
    }

    public static File Q() {
        return k2.j("smallPic");
    }

    public static File R() {
        return k2.j("Splash");
    }

    public static long S() {
        String string2 = e.getPath();
        StatFs statFs = new StatFs(string2);
        return statFs.getTotalBytes();
    }

    public static File T() {
        return k2.J("Uri");
    }

    private static Uri U(String string2, String object, String charSequence) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        String string3 = File.separator;
        stringBuilder.append(string3);
        stringBuilder.append((String)object);
        stringBuilder.append(string3);
        stringBuilder = s1.h0(stringBuilder.toString(), (String)charSequence);
        if (stringBuilder != null) {
            return stringBuilder;
        }
        stringBuilder = new ContentValues();
        CharSequence charSequence2 = "_display_name";
        stringBuilder.put((String)charSequence2, (String)charSequence);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append((String)object);
            string2 = ((StringBuilder)charSequence).toString();
            object = "relative_path";
            stringBuilder.put((String)object, string2);
        } else {
            charSequence2 = new StringBuilder();
            string2 = Environment.getExternalStoragePublicDirectory((String)string2).getPath();
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append(string3);
            ((StringBuilder)charSequence2).append((String)object);
            string2 = ((StringBuilder)charSequence2).toString();
            object = new File(string2);
            n10 = (int)(((File)object).exists() ? 1 : 0);
            if (n10 == 0) {
                ((File)object).mkdirs();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append((String)charSequence);
            string2 = ((StringBuilder)object).toString();
            object = "_data";
            stringBuilder.put((String)object, string2);
        }
        stringBuilder.put("mime_type", "video/mp4");
        string2 = k2.a().getContentResolver();
        object = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        return string2.insert((Uri)object, (ContentValues)stringBuilder);
    }

    public static File V() {
        return k2.j("myWebview");
    }

    private static Context a() {
        return d.v.e.f.a().b();
    }

    public static void b(Uri object, String object2) {
        block28: {
            boolean bl2;
            Object object3;
            Object object4;
            Object object5;
            block29: {
                object5 = k2.a();
                object5 = object5.getContentResolver();
                object = object5.openInputStream((Uri)object);
                object5 = new StringBuilder();
                object4 = k2.a();
                object4 = object4.getCacheDir();
                ((StringBuilder)object5).append(object4);
                object4 = File.separator;
                ((StringBuilder)object5).append((String)object4);
                object3 = "temp";
                ((StringBuilder)object5).append((String)object3);
                object5 = ((StringBuilder)object5).toString();
                if (object == null) break block28;
                object3 = new File((String)object5);
                bl2 = ((File)object3).exists();
                if (bl2) break block29;
                ((File)object3).mkdirs();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object5);
            stringBuilder.append((String)object4);
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            object3 = new File((String)object2);
            object2 = new FileOutputStream((File)object3);
            object5 = new BufferedInputStream((InputStream)object);
            object = new BufferedOutputStream((OutputStream)object2);
            int n10 = 1024;
            object4 = new byte[n10];
            int n11 = ((FilterInputStream)object5).read((byte[])object4);
            while (n11 > 0) {
                bl2 = false;
                stringBuilder = null;
                ((BufferedOutputStream)object).write((byte[])object4, 0, n11);
                ((BufferedOutputStream)object).flush();
                n11 = ((FilterInputStream)object5).read((byte[])object4);
            }
            try {
                ((FilterOutputStream)object).close();
                ((OutputStream)object2).close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static File c() {
        return k2.J("oss_record");
    }

    public static File d() {
        return k2.j("AppUpdate");
    }

    public static long e() {
        int n10 = Build.VERSION.SDK_INT;
        long l10 = 0L;
        int n11 = 26;
        if (n10 >= n11) {
            Object object = (StorageManager)k2.a().getSystemService(StorageManager.class);
            Context context = k2.a();
            Object object2 = StorageStatsManager.class;
            context = (StorageStatsManager)context.getSystemService(object2);
            object2 = Environment.getExternalStorageDirectory();
            object = object.getUuidForPath((File)object2);
            try {
                l10 = context.getFreeBytes((UUID)object);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            return l10;
        }
        Object object = Environment.getExternalStorageDirectory();
        try {
            object = ((File)object).getAbsolutePath();
        }
        catch (Exception exception) {
            return l10;
        }
        StatFs statFs = new StatFs((String)object);
        long l11 = statFs.getBlockSizeLong();
        long l12 = statFs.getAvailableBlocksLong();
        return l11 * l12;
    }

    public static File f() {
        return k2.y("Avatar");
    }

    public static File g(String string2) {
        return k2.t(string2, "Avatar");
    }

    public static File h() {
        return k2.j("Cache");
    }

    private static File i(String string2) {
        File file = c;
        File file2 = new File(file, string2);
        return file2;
    }

    public static File j(String object) {
        object = k2.i((String)object);
        s1.c0((File)object);
        return object;
    }

    public static File k() {
        return k2.s("Camera");
    }

    public static File l(String string2) {
        return k2.t(string2, "Camera");
    }

    public static File m() {
        return k2.J("Editor");
    }

    public static File n() {
        return k2.s("Editor");
    }

    public static File o(String string2) {
        return k2.t(string2, "Editor");
    }

    public static File p() {
        return k2.s("assets");
    }

    private static File q() {
        File file = Environment.getExternalStorageDirectory();
        CharSequence charSequence = new StringBuilder();
        charSequence.append(a);
        Object object = File.separator;
        charSequence.append((String)object);
        object = b;
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        object = new File(file, (String)charSequence);
        return object;
    }

    private static File r(String string2) {
        File file = g;
        if (file == null) {
            file = Environment.getExternalStorageDirectory();
            Comparable<StringBuilder> comparable = new StringBuilder();
            comparable.append(a);
            String string3 = File.separator;
            comparable.append(string3);
            comparable.append(string2);
            string2 = comparable.toString();
            comparable = new File(file, string2);
            g = comparable;
        }
        return g;
    }

    public static File s(String object) {
        object = k2.C((String)object);
        s1.c0((File)object);
        return object;
    }

    public static File t(String object, String string2) {
        object = k2.D((String)object, string2);
        s1.c0((File)object);
        return object;
    }

    public static Uri u(String string2) {
        String string3 = Environment.DIRECTORY_DCIM;
        CharSequence charSequence = new StringBuilder();
        String string4 = b;
        charSequence.append(string4);
        string4 = File.separator;
        charSequence.append(string4);
        charSequence.append("Album");
        charSequence = charSequence.toString();
        return k2.L(string3, (String)charSequence, string2);
    }

    public static Uri v(String string2) {
        String string3 = Environment.DIRECTORY_DCIM;
        CharSequence charSequence = new StringBuilder();
        String string4 = b;
        charSequence.append(string4);
        string4 = File.separator;
        charSequence.append(string4);
        charSequence.append("Album");
        charSequence = charSequence.toString();
        return k2.U(string3, (String)charSequence, string2);
    }

    public static Uri w(String string2) {
        String string3 = Environment.DIRECTORY_DCIM;
        CharSequence charSequence = new StringBuilder();
        String string4 = b;
        charSequence.append(string4);
        string4 = File.separator;
        charSequence.append(string4);
        charSequence.append("Avatar");
        charSequence = charSequence.toString();
        return k2.L(string3, (String)charSequence, string2);
    }

    private static File x(String string2) {
        File file = d;
        File file2 = new File(file, string2);
        return file2;
    }

    public static File y(String object) {
        object = k2.x((String)object);
        s1.c0((File)object);
        return object;
    }

    public static Uri z(String string2) {
        String string3 = Environment.DIRECTORY_DCIM;
        CharSequence charSequence = new StringBuilder();
        String string4 = b;
        charSequence.append(string4);
        string4 = File.separator;
        charSequence.append(string4);
        charSequence.append("Camera");
        charSequence = charSequence.toString();
        return k2.L(string3, (String)charSequence, string2);
    }
}

