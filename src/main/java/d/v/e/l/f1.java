/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.AssetManager
 *  android.text.TextUtils
 */
package d.v.e.l;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import d.v.e.f;
import d.v.e.l.s1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.Consumer;
import m.a.a;

public class f1 {
    public static boolean a(String string2) {
        AssetManager assetManager = f.a().c().getAssets();
        try {
            assetManager.open(string2);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    private static void b(AssetManager object, String object2, String object3, Consumer object4) {
        String[] stringArray = object.list((String)object2);
        int n10 = stringArray.length;
        if (n10 > 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append((String)object3);
            String string22 = File.separator;
            charSequence.append(string22);
            charSequence.append((String)object2);
            charSequence = charSequence.toString();
            s1.d0((String)charSequence);
            for (String string22 : stringArray) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object2);
                String string3 = File.separator;
                stringBuilder.append(string3);
                stringBuilder.append(string22);
                string22 = stringBuilder.toString();
                f1.b((AssetManager)object, string22, (String)object3, (Consumer)object4);
            }
        } else {
            int n11;
            int n12;
            if ((object = f1.h((AssetManager)object, (String)object2)) == null) {
                if (object4 != null) {
                    object4.accept(object2);
                }
                return;
            }
            object4 = new File((String)object3, (String)object2);
            s1.d0(((File)object4).getParent());
            object2 = new FileOutputStream((File)object4);
            int n13 = 0x100000;
            object3 = new byte[n13];
            while ((n12 = ((InputStream)object).read((byte[])object3)) != (n11 = -1)) {
                ((FileOutputStream)object2).write((byte[])object3, 0, n12);
            }
            ((OutputStream)object2).flush();
            ((InputStream)object).close();
            ((FileOutputStream)object2).close();
        }
    }

    public static boolean c(String[] stringArray, String string2) {
        return f1.d(stringArray, string2, null);
    }

    public static boolean d(String[] stringArray, String string2, Consumer consumer) {
        int n10;
        if (stringArray != null && (n10 = stringArray.length) != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) == 0) {
            int n11;
            s1.d0(string2);
            AssetManager assetManager = f.a().c().getAssets();
            try {
                n11 = stringArray.length;
            }
            catch (IOException iOException) {
                a.f(iOException);
            }
            for (int i10 = 0; i10 < n11; ++i10) {
                String string3 = stringArray[i10];
                f1.b(assetManager, string3, string2, consumer);
                continue;
            }
            return true;
        }
        return false;
    }

    public static String[] e(String string2) {
        AssetManager assetManager = f.a().c().getAssets();
        try {
            return assetManager.list(string2);
        }
        catch (IOException iOException) {
            return null;
        }
    }

    public static AssetFileDescriptor f(String string2) {
        f f10 = f.a();
        f10 = f10.c();
        f10 = f10.getAssets();
        try {
            string2 = f10.openFd(string2);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            string2 = null;
        }
        return string2;
    }

    public static long g(String string2) {
        long l10;
        AssetManager assetManager = f.a().c().getAssets();
        int n10 = 0;
        if (assetManager == null) {
            return 0;
        }
        string2 = assetManager.openFd(string2);
        try {
            l10 = string2.getLength();
        }
        catch (IOException iOException) {
            a.f(iOException);
        }
        n10 = (int)l10;
        return n10;
    }

    private static InputStream h(AssetManager assetManager, String string2) {
        try {
            return assetManager.open(string2);
        }
        catch (Exception exception) {
            return null;
        }
    }
}

