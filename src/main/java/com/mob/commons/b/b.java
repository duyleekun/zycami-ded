/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.mob.commons.b;

import android.content.Context;
import android.text.TextUtils;
import com.mob.commons.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class b {
    private static b a;
    private Context b;
    private HashMap c;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private b(Context object) {
        this.b = object;
        Object object2 = new HashMap();
        this.c = object2;
        object2 = ".msas";
        try {
            object = com.mob.commons.b.b.a((Context)object, (String)object2);
            object = com.mob.commons.b.b.a((File)object);
            object = (HashMap)object;
            if (object == null) return;
            int n10 = ((HashMap)object).size();
            if (n10 <= 0) return;
            object2 = this.c;
            ((HashMap)object2).putAll(object);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    public static b a(Context object) {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            b b10 = a;
            if (b10 == null) {
                a = b10 = new b((Context)object);
            }
            object = a;
            return object;
        }
    }

    private static File a(Context object, String string2) {
        block7: {
            File file;
            block8: {
                try {
                    object = com.mob.commons.b.b.b((Context)object);
                    if (object == null) break block7;
                }
                catch (Throwable throwable) {}
                file = new File((String)object, string2);
                object = file.getParentFile();
                boolean bl2 = ((File)object).exists();
                if (bl2) break block8;
                object = file.getParentFile();
                ((File)object).mkdirs();
            }
            return file;
        }
        return null;
    }

    private static Object a(File object) {
        block7: {
            try {
                boolean bl2 = ((File)object).exists();
                if (!bl2) break block7;
            }
            catch (Throwable throwable) {}
            InputStream inputStream = new FileInputStream((File)object);
            object = new GZIPInputStream(inputStream);
            inputStream = new ObjectInputStream((InputStream)object);
            object = ((ObjectInputStream)inputStream).readObject();
            ((ObjectInputStream)inputStream).close();
            return object;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean a(File object, Object object2) {
        try {
            Object object3;
            boolean bl2 = ((File)object).exists();
            if (bl2) {
                ((File)object).delete();
            }
            if (!(bl2 = ((File)(object3 = ((File)object).getParentFile())).exists())) {
                object3 = ((File)object).getParentFile();
                ((File)object3).mkdirs();
            }
            ((File)object).createNewFile();
            object3 = new FileOutputStream((File)object);
            object = new GZIPOutputStream((OutputStream)object3);
            object3 = new ObjectOutputStream((OutputStream)object);
            ((ObjectOutputStream)object3).writeObject(object2);
            ((ObjectOutputStream)object3).flush();
            ((ObjectOutputStream)object3).close();
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private static String b(Context object) {
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        object = object.getFilesDir().getAbsolutePath();
        ((StringBuilder)comparable).append((String)object);
        ((StringBuilder)comparable).append("/Mob/");
        object = ((StringBuilder)comparable).toString();
        comparable = new Comparable<StringBuilder>((String)object);
        boolean bl2 = ((File)comparable).exists();
        if (!bl2) {
            ((File)comparable).mkdirs();
        }
        return object;
    }

    public HashMap a() {
        synchronized (this) {
            HashMap hashMap = this.c;
            return hashMap;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(String object, String object2, String string2, String string3, boolean bl2) {
        synchronized (this) {
            try {
                boolean bl3;
                boolean bl4;
                boolean bl5;
                HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                int n10 = TextUtils.isEmpty((CharSequence)object);
                if (n10 == 0) {
                    n10 = 69;
                    String string4 = k.a(n10);
                    hashMap.put(string4, object);
                }
                if (!(bl5 = TextUtils.isEmpty((CharSequence)object2))) {
                    int n11 = 75;
                    object = k.a(n11);
                    hashMap.put(object, object2);
                }
                if (!(bl4 = TextUtils.isEmpty((CharSequence)string2))) {
                    int n12 = 70;
                    object = k.a(n12);
                    hashMap.put(object, string2);
                }
                if (!(bl3 = TextUtils.isEmpty((CharSequence)string3))) {
                    int n13 = 71;
                    object = k.a(n13);
                    hashMap.put(object, string3);
                }
                int n14 = 74;
                object = k.a(n14);
                object2 = bl2;
                hashMap.put(object, object2);
                object = this.b;
                object2 = ".msas";
                object = com.mob.commons.b.b.a((Context)object, (String)object2);
                return com.mob.commons.b.b.a((File)object, hashMap);
            }
            catch (Throwable throwable) {
                return false;
            }
        }
    }
}

