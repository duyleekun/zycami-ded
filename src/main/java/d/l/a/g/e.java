/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.l.a.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import d.l.a.g.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class e {
    private static final String a = "SdcardUtil";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(Context object, String charSequence) {
        String string2;
        Object object3;
        String string3;
        block15: {
            Object object2;
            string3 = a;
            object3 = "android.permission.READ_EXTERNAL_STORAGE";
            boolean bl2 = b.a((Context)object, (String)object3);
            if (!bl2) {
                return "";
            }
            bl2 = false;
            object = null;
            try {
                object2 = ".deviceid";
                object3 = new File((String)charSequence, (String)object2);
                boolean bl3 = ((File)object3).exists();
                if (!bl3) {
                    return null;
                }
                charSequence = new StringBuilder();
                object2 = new FileReader((File)object3);
                object3 = new BufferedReader((Reader)object2);
            }
            catch (Throwable throwable) {
                object3 = null;
                break block15;
            }
            try {
                boolean bl4;
                object2 = ((BufferedReader)object3).readLine();
                while (!(bl4 = TextUtils.isEmpty((CharSequence)object2))) {
                    ((StringBuilder)charSequence).append((String)object2);
                    object2 = ((BufferedReader)object3).readLine();
                }
                object = ((StringBuilder)charSequence).toString();
            }
            catch (Throwable throwable) {
                break block15;
            }
            try {
                ((BufferedReader)object3).close();
                return object;
            }
            catch (Exception exception) {
                charSequence = exception.toString();
                Log.e((String)string3, (String)charSequence);
            }
            return object;
        }
        try {
            string2 = ((Throwable)((Object)string2)).toString();
            Log.e((String)string3, (String)string2);
            if (object3 == null) return null;
        }
        catch (Throwable throwable) {
            if (object3 == null) throw throwable;
            try {
                ((BufferedReader)object3).close();
                throw throwable;
            }
            catch (Exception exception) {
                string2 = exception.toString();
                Log.e((String)string3, (String)string2);
            }
            throw throwable;
        }
        try {
            ((BufferedReader)object3).close();
            return null;
        }
        catch (Exception exception) {
            string2 = exception.toString();
            Log.e((String)string3, (String)string2);
        }
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(Context var0, String var1_3, String var2_6) {
        block15: {
            block16: {
                var3_7 = "SdcardUtil";
                var4_8 = "android.permission.WRITE_EXTERNAL_STORAGE";
                var5_9 = b.a((Context)var0, (String)var4_8);
                if (!var5_9) {
                    return;
                }
                var5_9 = false;
                var0 = null;
                var4_8 = new File((String)var1_3);
                var6_10 = var4_8.exists();
                if (!var6_10) {
                    var4_8.mkdirs();
                }
                if (!(var8_12 = (var1_3 = new File((File)var4_8, var7_11 = ".deviceid")).exists())) {
                    var8_12 = true;
                    var1_3.setWritable(var8_12);
                    var1_3.createNewFile();
                }
                var4_8 = new FileWriter((File)var1_3);
                var1_3 = new BufferedWriter((Writer)var4_8);
                var1_3.write(var2_6);
                try {}
                catch (Exception v0) {
                    var0 = v0.toString();
                    Log.e((String)var3_7, (String)var0);
                    return;
                }
                break block16;
                catch (Throwable var1_4) {
                    break block15;
                }
                catch (Exception var1_5) {
                    // empty catch block
                    ** GOTO lbl-1000
                }
                catch (Throwable var0_1) {
                    var9_13 = var1_3;
                    var1_3 = var0_1;
                    var0 = var9_13;
                    break block15;
                }
                catch (Exception var0_2) {
                    var9_14 = var1_3;
                    var1_3 = var0_2;
                    var0 = var9_14;
                    ** GOTO lbl-1000
                }
            }
            var1_3.flush();
            var1_3.close();
            return;
lbl-1000:
            // 2 sources

            {
                var1_3 = var1_3.toString();
                Log.e((String)var3_7, (String)var1_3);
                if (var0 == null) return;
            }
            {
                var0.flush();
                var0.close();
                return;
            }
        }
        if (var0 == null) throw var1_3;
        try {
            var0.flush();
            var0.close();
            throw var1_3;
        }
        catch (Exception v1) {
            var0 = v1.toString();
            Log.e((String)var3_7, (String)var0);
        }
        throw var1_3;
    }
}

