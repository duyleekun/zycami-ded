/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.media.MediaMetadataRetriever
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.MediaStore$Files
 */
package d.v.e.l;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import d.v.e.f;
import d.v.e.h.d;
import d.v.e.l.a2$a;
import d.v.e.l.s1;
import java.io.File;
import java.util.Objects;

public final class a2 {
    private a2() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static void a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uri);
        context.sendBroadcast(intent);
    }

    public static void b(Context context, String string2) {
        File file = new File(string2);
        string2 = Uri.fromFile((File)file);
        a2.a(context, (Uri)string2);
    }

    /*
     * WARNING - void declaration
     */
    public static boolean c(String string2) {
        void var3_6;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("_data = \"");
        stringBuilder.append(string2);
        stringBuilder.append("\"");
        string2 = stringBuilder.toString();
        stringBuilder = MediaStore.Files.getContentUri((String)"external");
        ContentResolver contentResolver = f.a().c().getContentResolver();
        int bl2 = contentResolver.delete((Uri)stringBuilder, string2, null);
        if (bl2 > 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            string2 = null;
        }
        return (boolean)var3_6;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a2$a d(String var0) {
        block7: {
            var1_6 = Build.VERSION.SDK_INT;
            var2_7 = 29;
            var3_8 = null;
            try {
                var4_9 = new MediaMetadataRetriever();
            }
            catch (Throwable var0_3) {
                break block7;
            }
            catch (IllegalArgumentException var0_4) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var4_9.setDataSource((String)var0);
                var5_10 = 18;
                var0 = var4_9.extractMetadata(var5_10);
                var6_11 = d.a((String)var0);
                var5_10 = 19;
                var0 = var4_9.extractMetadata(var5_10);
                var7_12 = d.a((String)var0);
                var5_10 = 9;
                var0 = var4_9.extractMetadata(var5_10);
                var8_13 = d.a((String)var0);
                var5_10 = 24;
                var0 = var4_9.extractMetadata(var5_10);
                var10_14 = d.a((String)var0);
                var0 = new a2$a(var6_11, var7_12, var8_13, var10_14);
                if (var1_6 < var2_7) return var0;
            }
            catch (Throwable var0_1) {
                var3_8 = var4_9;
                break block7;
            }
            catch (IllegalArgumentException var0_2) {
                var3_8 = var4_9;
                ** GOTO lbl-1000
            }
            var4_9.close();
            return var0;
lbl-1000:
            // 2 sources

            {
                var0.printStackTrace();
                var0 = new a2$a();
                if (var3_8 == null) return var0;
                if (var1_6 < var2_7) return var0;
            }
            var3_8.close();
            return var0;
        }
        if (var3_8 == null) throw var0_5;
        if (var1_6 < var2_7) throw var0_5;
        var3_8.close();
        throw var0_5;
    }

    public static boolean e(Context context, String string2) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(string2);
        Uri uri = MediaStore.Files.getContentUri((String)"external");
        context = context.getContentResolver();
        boolean bl2 = true;
        String[] stringArray = new String[bl2];
        stringArray[0] = string2;
        string2 = "_data LIKE ? ";
        int n10 = context.delete(uri, string2, stringArray);
        if (n10 <= 0) {
            bl2 = false;
        }
        return bl2;
    }

    public static void f(Context context, String string2) {
        a2.g(context, string2, null);
    }

    public static void g(Context context, String string2, MediaScannerConnection.OnScanCompletedListener onScanCompletedListener) {
        boolean bl2 = s1.q(string2);
        if (!bl2) {
            return;
        }
        String[] stringArray = new String[]{string2};
        MediaScannerConnection.scanFile((Context)context, (String[])stringArray, null, (MediaScannerConnection.OnScanCompletedListener)onScanCompletedListener);
    }
}

