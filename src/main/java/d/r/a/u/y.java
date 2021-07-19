/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 */
package d.r.a.u;

import android.content.Context;
import android.os.Environment;
import d.r.a.u.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public final class y
implements h {
    private static final String b;
    private static final String c;
    private static String d;
    private File a;

    static {
        CharSequence charSequence = new StringBuilder();
        String string2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        charSequence.append(string2);
        string2 = File.separator;
        charSequence.append(string2);
        charSequence.append(".vivo/pushsdk/config");
        charSequence = charSequence.toString();
        b = charSequence;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append(string2);
        stringBuilder.append("config.txt");
        c = stringBuilder.toString();
        d = "SdcardCache";
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Properties c() {
        void var0_3;
        Object object;
        block13: {
            BufferedInputStream bufferedInputStream;
            Properties properties;
            block11: {
                block12: {
                    properties = new Properties();
                    object = null;
                    String string2 = c;
                    FileInputStream fileInputStream = new FileInputStream(string2);
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        properties.load(bufferedInputStream);
                        break block11;
                    }
                    catch (Exception exception) {
                        break block12;
                    }
                    catch (Throwable throwable) {
                        break block13;
                    }
                    catch (Exception exception) {
                        bufferedInputStream = null;
                        object = exception;
                    }
                }
                ((Throwable)object).printStackTrace();
                if (bufferedInputStream == null) return properties;
            }
            try {
                ((InputStream)bufferedInputStream).close();
                return properties;
            }
            catch (IOException iOException) {}
            return properties;
            catch (Throwable throwable) {
                object = bufferedInputStream;
            }
        }
        if (object == null) throw var0_3;
        try {
            ((InputStream)object).close();
        }
        catch (IOException iOException) {
            throw var0_3;
        }
        throw var0_3;
    }

    public final String a(String string2, String string3) {
        return y.c().getProperty(string2, string3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean a(Context object) {
        object = Environment.getExternalStorageState();
        boolean bl2 = "mounted".equals(object);
        boolean bl3 = false;
        if (!bl2) return bl3;
        Object object2 = b;
        object = new File((String)object2);
        boolean bl4 = ((File)object).exists();
        boolean bl5 = true;
        bl2 = !bl4 ? ((File)object).mkdirs() : bl5;
        if (!bl2) return bl2;
        String string2 = c;
        this.a = object2 = new File(string2);
        bl4 = ((File)object2).exists();
        if (bl4) return bl2;
        object = this.a;
        try {
            ((File)object).createNewFile();
            return bl5;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return bl3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(String var1_1, String var2_2) {
        block13: {
            var3_8 = y.c();
            var4_9 = y.c;
            var5_10 = null;
            var3_8.setProperty((String)var1_1, var2_2);
            var1_1 = new FileOutputStream(var4_9);
            var3_8.store((OutputStream)var1_1, null);
            var1_1.flush();
            try {
                var1_1.close();
                return;
            }
            catch (Exception v0) {
                return;
            }
            catch (Throwable var2_3) {
                var5_10 = var1_1;
                break block13;
            }
            catch (Exception var2_4) {
                var5_10 = var1_1;
                ** GOTO lbl-1000
            }
            catch (Throwable var2_5) {
                break block13;
            }
            catch (Exception var2_6) {
                // empty catch block
            }
lbl-1000:
            // 2 sources

            {
                var2_2.printStackTrace();
                if (var5_10 == null) return;
            }
            try {
                var5_10.close();
                return;
            }
            catch (Exception v1) {
                return;
            }
        }
        if (var5_10 == null) throw var2_7;
        try {
            var5_10.close();
        }
        catch (Exception v2) {
            throw var2_7;
        }
        throw var2_7;
    }
}

