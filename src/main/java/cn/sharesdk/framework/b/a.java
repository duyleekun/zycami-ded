/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.text.TextUtils
 *  android.util.Base64
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.framework.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.b.a.e;
import cn.sharesdk.framework.b.b;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.b.c;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

public class a {
    private static a a;
    private c b;
    private DeviceHelper c;
    private e d;
    private boolean e = true;

    private a() {
        Object object = new c();
        this.b = object;
        this.d = object = cn.sharesdk.framework.b.a.e.a();
        this.c = object = DeviceHelper.getInstance(MobSDK.getContext());
    }

    public static a a() {
        a a10 = a;
        if (a10 == null) {
            a = a10 = new a();
        }
        return a;
    }

    private String a(Bitmap object, b b10) {
        File file = File.createTempFile("bm_tmp", ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        object.compress(compressFormat, 100, (OutputStream)fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        object = file.getAbsolutePath();
        return this.a((String)object, b10);
    }

    /*
     * Enabled aggressive block sorting
     */
    private String a(String string2, b object) {
        double d10;
        float f10;
        float f11;
        float f12;
        float f13;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        float f14 = 0.0f;
        Object object2 = null;
        if (bl2) return null;
        Object object3 = new File(string2);
        bl2 = ((File)object3).exists();
        if (!bl2) {
            return null;
        }
        String string3 = "none";
        object3 = this.c.getNetworkType();
        boolean bl3 = string3.equals(object3);
        if (bl3) return null;
        bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (bl2) {
            return null;
        }
        object3 = BitmapHelper.getBmpFormat((String)string2);
        f14 = 200.0f;
        b b10 = cn.sharesdk.framework.b.b.b;
        if (object == b10) {
            f14 = 600.0f;
        }
        object = new BitmapFactory.Options();
        bl3 = true;
        float f15 = Float.MIN_VALUE;
        ((BitmapFactory.Options)object).inJustDecodeBounds = bl3;
        BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)object);
        ((BitmapFactory.Options)object).inJustDecodeBounds = false;
        int n10 = ((BitmapFactory.Options)object).outWidth;
        int n11 = ((BitmapFactory.Options)object).outHeight;
        if (n10 >= n11 && (f13 = (f12 = (f11 = (float)n11) - f14) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) > 0) {
            f10 = (float)n11 / f14;
            d10 = Math.ceil(f10);
        } else {
            if (n10 >= n11) return this.d(string2);
            f10 = n10;
            float f16 = f10 - f14;
            n11 = (int)(f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1));
            if (n11 <= 0) return this.d(string2);
            f10 = (float)n10 / f14;
            d10 = Math.ceil(f10);
        }
        n11 = (int)d10;
        if (n11 <= 0) {
            n11 = (int)(bl3 ? 1 : 0);
            f10 = f15;
        }
        object2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)object2).inSampleSize = n11;
        ((BitmapFactory.Options)object2).inPurgeable = bl3;
        ((BitmapFactory.Options)object2).inInputShareable = bl3;
        string2 = BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)object2);
        string2.getHeight();
        string2.getWidth();
        object = new StringBuilder();
        ((StringBuilder)object).append(".");
        object2 = object3.name().toLowerCase();
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object = File.createTempFile("bm_tmp2", (String)object);
        object2 = new FileOutputStream((File)object);
        string2.compress((Bitmap.CompressFormat)object3, 80, (OutputStream)object2);
        ((OutputStream)object2).flush();
        ((FileOutputStream)object2).close();
        string2 = ((File)object).getAbsolutePath();
        return this.d(string2);
    }

    private String a(String string2, String object, int n10, String object2) {
        int n11;
        String string3;
        int n12;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string2;
        }
        Object object3 = new ArrayList();
        object = Pattern.compile((String)object);
        Object object4 = ((Pattern)object).matcher(string2);
        while ((n12 = ((Matcher)object4).find()) != 0) {
            int n13;
            string3 = ((Matcher)object4).group();
            if (string3 == null || (n13 = string3.length()) <= 0) continue;
            ((ArrayList)object3).add(string3);
        }
        int n14 = ((ArrayList)object3).size();
        if (n14 == 0) {
            return string2;
        }
        object4 = this.b;
        Object object5 = ((c)object4).a(string2, (ArrayList)object3, n10, (String)object2);
        if (object5 != null && (n11 = object5.size()) > 0) {
            object2 = "data";
            bl2 = object5.containsKey(object2);
            if (!bl2) {
                return string2;
            }
            object5 = (ArrayList)object5.get(object2);
            object2 = new HashMap();
            object5 = object5.iterator();
            while (bl2 = object5.hasNext()) {
                object3 = (HashMap)object5.next();
                object4 = String.valueOf(((HashMap)object3).get("surl"));
                string3 = "source";
                object3 = String.valueOf(((HashMap)object3).get(string3));
                ((HashMap)object2).put(object3, object4);
            }
            object = ((Pattern)object).matcher(string2);
            object5 = new StringBuilder();
            bl2 = false;
            object3 = null;
            n14 = 0;
            object4 = null;
            while ((n12 = ((Matcher)object).find()) != 0) {
                n12 = ((Matcher)object).start();
                object4 = string2.substring(n14, n12);
                object5.append((String)object4);
                object4 = ((Matcher)object).group();
                object4 = (String)((HashMap)object2).get(object4);
                object5.append((String)object4);
                n14 = ((Matcher)object).end();
            }
            int n15 = string2.length();
            string2 = string2.substring(n14, n15);
            object5.append(string2);
            string2 = object5.toString();
            object = SSDKLog.b();
            n10 = 1;
            object5 = new Object[n10];
            object5[0] = string2;
            object2 = "> SERVER_SHORT_LINK_URL content after replace link ===  %s";
            ((NLog)object).i(object2, object5);
        }
        return string2;
    }

    private void a(cn.sharesdk.framework.b.b.b b10) {
        Object object = this.d;
        boolean bl2 = ((e)object).d();
        String string2 = b10.c;
        if (bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            object = b10.f;
            int n10 = 16;
            object = ((String)object).substring(0, n10);
            b10.c = object = Data.Base64AES(string2, (String)object);
        } else {
            bl2 = false;
            object = null;
            b10.d = null;
            b10.c = null;
        }
    }

    private void a(f f10) {
        e e10 = this.d;
        int n10 = e10.f();
        e e11 = this.d;
        boolean bl2 = e11.d();
        f$a f$a = f10.d;
        int n11 = 1;
        if (n10 == n11) {
            Object object;
            ArrayList arrayList;
            n10 = 0;
            e10 = null;
            if (f$a != null && (arrayList = f$a.e) != null) {
                n11 = arrayList.size();
            } else {
                n11 = 0;
                arrayList = null;
            }
            Object object2 = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                object = (String)f$a.e.get(i10);
                Object object3 = cn.sharesdk.framework.b.b.a;
                boolean bl3 = TextUtils.isEmpty((CharSequence)(object = this.a((String)object, (b)((Object)object3))));
                if (bl3) continue;
                object3 = f$a.d;
                ((ArrayList)object3).add(object);
            }
            if (f$a != null && (arrayList = f$a.f) != null) {
                n11 = arrayList.size();
            } else {
                n11 = 0;
                arrayList = null;
            }
            while (n10 < n11) {
                object2 = (Bitmap)f$a.f.get(n10);
                object = cn.sharesdk.framework.b.b.a;
                boolean bl4 = TextUtils.isEmpty((CharSequence)(object2 = this.a((Bitmap)object2, (b)((Object)object))));
                if (!bl4) {
                    object = f$a.d;
                    ((ArrayList)object).add(object2);
                }
                ++n10;
            }
        } else {
            f10.d = null;
        }
        if (!bl2) {
            f10.m = null;
        }
    }

    private boolean a(String string2, boolean bl2) {
        return this.b.a(string2, bl2);
    }

    private String d(String object) {
        int n10;
        object = this.b.c((String)object);
        Object object2 = null;
        if (object != null && (n10 = ((HashMap)object).size()) > 0) {
            int n11;
            String string2 = "status";
            boolean n112 = ((HashMap)object).containsKey(string2);
            if (!n112) {
                return null;
            }
            n10 = ResHelper.parseInt(string2 = String.valueOf(((HashMap)object).get(string2)));
            if (n10 != (n11 = 200)) {
                return null;
            }
            string2 = "url";
            boolean bl2 = ((HashMap)object).containsKey(string2);
            if (bl2) {
                object2 = object = ((HashMap)object).get(string2);
                object2 = (String)object;
            }
        }
        return object2;
    }

    private String e(String object) {
        int n10;
        int n11;
        object = ((String)object).getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        object = new ByteArrayOutputStream();
        Object object2 = new GZIPOutputStream((OutputStream)object);
        int n12 = 1024;
        byte[] byArray = new byte[n12];
        while ((n11 = byteArrayInputStream.read(byArray, 0, n12)) != (n10 = -1)) {
            ((GZIPOutputStream)object2).write(byArray, 0, n11);
        }
        ((DeflaterOutputStream)object2).flush();
        ((DeflaterOutputStream)object2).close();
        object2 = ((ByteArrayOutputStream)object).toByteArray();
        ((OutputStream)object).flush();
        ((ByteArrayOutputStream)object).close();
        byteArrayInputStream.close();
        return Base64.encodeToString((byte[])object2, (int)2);
    }

    public String a(Bitmap bitmap) {
        Object object = this.d;
        boolean bl2 = object.k();
        if (!bl2) {
            return null;
        }
        try {
            object = cn.sharesdk.framework.b.b.b;
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
        return this.a(bitmap, (b)((Object)object));
    }

    public String a(String string2, int n10, boolean bl2, String string3) {
        block13: {
            String string4;
            block14: {
                Object object;
                try {
                    object = this.d;
                }
                catch (Throwable throwable) {
                    SSDKLog.b().d(throwable);
                    return string2;
                }
                boolean bl3 = ((e)object).k();
                if (!bl3) break block13;
                object = this.d;
                bl3 = ((e)object).e();
                if (!bl3) break block13;
                object = this.c;
                object = ((DeviceHelper)object).getNetworkType();
                String string5 = "none";
                boolean bl4 = string5.equals(object);
                if (bl4) break block13;
                bl3 = TextUtils.isEmpty((CharSequence)object);
                if (bl3) break block13;
                if (!bl2) break block14;
                string4 = "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>";
                string4 = this.a(string2, string4, n10, string3);
                if (string4 == null) break block14;
                bl3 = string4.equals(string2);
                if (bl3) break block14;
                return string4;
            }
            string4 = "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+";
            String string6 = this.a(string2, string4, n10, string3);
            if (string6 == null) break block13;
            bl2 = string6.equals(string2);
            if (bl2) break block13;
            return string6;
        }
        return string2;
    }

    /*
     * Unable to fully structure code
     */
    public void a(cn.sharesdk.framework.b.b.c var1_1) {
        block16: {
            block17: {
                block15: {
                    var2_3 = this.d;
                    var3_4 = var2_3.k();
                    if (var3_4) break block15;
                    return;
                }
                var3_4 = var1_1 instanceof cn.sharesdk.framework.b.b.b;
                if (!var3_4) break block17;
                var2_3 = var1_1;
                var2_3 = (cn.sharesdk.framework.b.b.b)var1_1;
                this.a((cn.sharesdk.framework.b.b.b)var2_3);
                ** GOTO lbl24
            }
            var3_4 = var1_1 instanceof f;
            if (!var3_4) ** GOTO lbl24
            var2_3 = var1_1;
            var2_3 = (f)var1_1;
            this.a((f)var2_3);
lbl24:
            // 3 sources

            var2_3 = this.d;
            var3_4 = var2_3.c();
            if (var3_4) ** GOTO lbl32
            var3_4 = false;
            var2_3 = null;
            var1_1.l = null;
lbl32:
            // 2 sources

            var2_3 = this.d;
            var4_5 = var2_3.b();
            var6_6 = 0L;
            var8_7 = var4_5 == var6_6 ? 0 : (var4_5 < var6_6 ? -1 : 1);
            if (var8_7 != false) break block16;
            var2_3 = this.b;
            var4_5 = var2_3.b();
        }
        var6_6 = System.currentTimeMillis() - var4_5;
        var1_1.e = var6_6;
        var2_3 = this.b;
        try {
            var2_3.a(var1_1);
        }
        catch (Throwable var1_2) {
            var2_3 = SSDKLog.b();
            var2_3.d(var1_2);
        }
    }

    public void a(String string2) {
        boolean bl2;
        c c10 = this.b;
        if (c10 != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            c10 = this.b;
            c10.a(string2);
        }
    }

    public void a(HashMap hashMap) {
        Object object = this.b;
        try {
            ((c)object).b(hashMap);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            ((NLog)object).d(throwable);
        }
    }

    public String b(String string2) {
        Object object = this.d;
        boolean bl2 = object.k();
        if (!bl2) {
            return null;
        }
        try {
            object = cn.sharesdk.framework.b.b.b;
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
        return this.a(string2, (b)((Object)object));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b() {
        int n10;
        long l10;
        Object object;
        Object object2;
        Object object3;
        block28: {
            block27: {
                boolean bl2;
                block26: {
                    object3 = "res";
                    object2 = this.c;
                    object2 = ((DeviceHelper)object2).getNetworkType();
                    object = "none";
                    bl2 = ((String)object).equals(object2);
                    if (bl2) return;
                    int n11 = TextUtils.isEmpty((CharSequence)object2);
                    if (n11 != 0) return;
                    l10 = 86400000L;
                    Object object4 = this.d;
                    object4 = ((e)object4).l();
                    long l11 = (Long)object4;
                    long l12 = System.currentTimeMillis();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(l11);
                    int n12 = 5;
                    int n13 = calendar.get(n12);
                    calendar.setTimeInMillis(l12);
                    int n14 = calendar.get(n12);
                    long l13 = (l12 -= l11) - l10;
                    n11 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (n11 >= 0 || n13 != n14) break block26;
                    return;
                }
                object2 = this.b;
                object2 = ((c)object2).a();
                bl2 = ((HashMap)object2).containsKey(object3);
                if (!bl2) break block27;
                object = "true";
                object3 = ((HashMap)object2).get(object3);
                object3 = String.valueOf(object3);
                n10 = ((String)object).equals(object3);
                break block28;
            }
            n10 = 1;
        }
        object = this.d;
        ((e)object).a(n10 != 0);
        if (object2 == null) return;
        n10 = ((HashMap)object2).size();
        if (n10 <= 0) return;
        object3 = this.d;
        l10 = System.currentTimeMillis();
        try {
            ((e)object3).b(l10);
            return;
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
        }
    }

    public HashMap c(String string2) {
        c c10;
        try {
            c10 = this.b;
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
        return c10.d(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Object object = "assigns";
        Object object2 = "serpaths";
        Object object3 = "switchs";
        Object object4 = "timestamp";
        Object object5 = "status";
        try {
            int n10;
            boolean bl2;
            String string2;
            CharSequence charSequence;
            boolean bl3;
            int n11;
            Object object6 = this.c;
            object6 = ((DeviceHelper)object6).getNetworkType();
            Object object7 = "none";
            int n12 = ((String)object7).equals(object6);
            if (n12 != 0) return;
            boolean bl4 = TextUtils.isEmpty((CharSequence)object6);
            if (bl4) {
                return;
            }
            object6 = this.d;
            bl4 = ((e)object6).k();
            if (!bl4) {
                return;
            }
            object6 = this.d;
            long l10 = System.currentTimeMillis();
            ((e)object6).a(l10);
            object6 = this.b;
            object6 = ((c)object6).c();
            n12 = ((HashMap)object6).containsKey(object5);
            if (n12 != 0) {
                object5 = ((HashMap)object6).get(object5);
                n11 = ResHelper.parseInt((String)(object5 = String.valueOf(object5)));
                if (n11 == (n12 = -200)) {
                    object = SSDKLog.b();
                    object2 = "error";
                    object2 = ((HashMap)object6).get(object2);
                    object2 = (String)object2;
                    boolean bl5 = false;
                    object3 = null;
                    object3 = new Object[]{};
                    ((NLog)object).d(object2, (Object[])object3);
                    return;
                }
            }
            if ((n11 = ((HashMap)object6).containsKey(object4)) != 0) {
                object4 = ((HashMap)object6).get(object4);
                object4 = String.valueOf(object4);
                long l11 = ResHelper.parseLong((String)object4);
                l10 = System.currentTimeMillis() - l11;
                object4 = this.d;
                object5 = "service_time";
                object7 = l10;
                ((e)object4).a((String)object5, (Long)object7);
            }
            if (bl3 = ((HashMap)object6).containsKey(object3)) {
                object3 = ((HashMap)object6).get(object3);
                if ((object3 = (HashMap)object3) != null) {
                    object4 = "device";
                    object4 = ((HashMap)object3).get(object4);
                    object4 = String.valueOf(object4);
                    object5 = "share";
                    object5 = ((HashMap)object3).get(object5);
                    object5 = String.valueOf(object5);
                    object7 = "auth";
                    object7 = ((HashMap)object3).get(object7);
                    object7 = String.valueOf(object7);
                    charSequence = "backflow";
                    charSequence = ((HashMap)object3).get(charSequence);
                    charSequence = String.valueOf(charSequence);
                    string2 = "loginplus";
                    string2 = ((HashMap)object3).get(string2);
                    string2 = String.valueOf(string2);
                    Object object8 = "linkcard";
                    object3 = ((HashMap)object3).get(object8);
                    object3 = String.valueOf(object3);
                    object8 = this.d;
                    ((e)object8).b((String)object4);
                    object4 = this.d;
                    ((e)object4).d((String)object5);
                    object4 = this.d;
                    ((e)object4).c((String)object7);
                    object4 = this.d;
                    ((e)object4).a((String)charSequence);
                    object4 = this.d;
                    ((e)object4).e(string2);
                    object4 = this.d;
                    ((e)object4).f((String)object3);
                }
            }
            if (!(bl2 = ((HashMap)object6).containsKey(object2))) return;
            object2 = ((HashMap)object6).get(object2);
            if ((object2 = (HashMap)object2) == null) return;
            object3 = "defhost";
            object3 = ((HashMap)object2).get(object3);
            object3 = String.valueOf(object3);
            object4 = "defport";
            object4 = ((HashMap)object2).get(object4);
            object4 = String.valueOf(object4);
            n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
            object6 = ":";
            if (n11 == 0 && (n11 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0)) == 0) {
                object5 = "443";
                n11 = (int)(((String)object5).equals(object4) ? 1 : 0);
                if (n11 == 0 && (n11 = (int)(((String)(object5 = "80")).equals(object4) ? 1 : 0)) == 0) {
                    object5 = this.b;
                    object7 = new StringBuilder();
                    object3 = MobSDK.checkRequestUrl((String)object3);
                    ((StringBuilder)object7).append((String)object3);
                    ((StringBuilder)object7).append((String)object6);
                    ((StringBuilder)object7).append((String)object4);
                    object3 = ((StringBuilder)object7).toString();
                    ((c)object5).b((String)object3);
                } else {
                    object4 = this.b;
                    object3 = MobSDK.checkRequestUrl((String)object3);
                    ((c)object4).b((String)object3);
                }
            }
            object3 = new HashMap();
            bl3 = ((HashMap)object2).containsKey(object);
            if (!bl3) return;
            object = ((HashMap)object2).get(object);
            if ((object = (HashMap)object) != null && (n10 = ((HashMap)object).size()) != 0) {
                object2 = ((HashMap)object).keySet();
                object2 = object2.iterator();
                while (true) {
                    if (!(bl3 = object2.hasNext())) {
                        object = this.b;
                        ((c)object).a((HashMap)object3);
                        return;
                    }
                    object4 = object2.next();
                    object4 = (String)object4;
                    object5 = ((HashMap)object).get(object4);
                    object5 = (HashMap)object5;
                    object7 = "host";
                    object7 = ((HashMap)object5).get(object7);
                    object7 = String.valueOf(object7);
                    charSequence = "port";
                    object5 = ((HashMap)object5).get(charSequence);
                    object5 = String.valueOf(object5);
                    boolean bl6 = TextUtils.isEmpty((CharSequence)object4);
                    if (bl6 || (bl6 = TextUtils.isEmpty((CharSequence)object7)) || (bl6 = TextUtils.isEmpty((CharSequence)object5))) continue;
                    charSequence = new StringBuilder();
                    string2 = "http://";
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append((String)object7);
                    ((StringBuilder)charSequence).append((String)object6);
                    ((StringBuilder)charSequence).append((String)object5);
                    object5 = ((StringBuilder)charSequence).toString();
                    ((HashMap)object3).put(object4, object5);
                }
            }
            object = this.b;
            n10 = 0;
            object2 = null;
            ((c)object).a((HashMap)null);
            return;
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
        }
    }

    public void d() {
        block26: {
            block24: {
                int n10;
                boolean bl2;
                Object object;
                Object object2;
                block25: {
                    object2 = this.c;
                    object2 = ((DeviceHelper)object2).getNetworkType();
                    object = "none";
                    bl2 = ((String)object).equals(object2);
                    if (bl2) break block24;
                    boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
                    if (bl3) break block24;
                    object2 = this.d;
                    bl3 = ((e)object2).k();
                    if (bl3) break block25;
                    return;
                }
                object2 = this.b;
                try {
                    object2 = ((c)object2).e();
                    bl2 = false;
                    object = null;
                    n10 = 0;
                }
                catch (Throwable throwable) {
                    object = SSDKLog.b();
                    ((NLog)object).d(throwable);
                }
                while (true) {
                    boolean bl4;
                    Object object3;
                    Object object4;
                    block28: {
                        boolean bl5;
                        block27: {
                            int n11 = ((ArrayList)object2).size();
                            if (n10 >= n11) break block26;
                            object4 = ((ArrayList)object2).get(n10);
                            object4 = (cn.sharesdk.framework.b.a.c)object4;
                            object3 = ((cn.sharesdk.framework.b.a.c)object4).b;
                            bl4 = ((ArrayList)object3).size();
                            bl5 = true;
                            if (bl4 != bl5) break block27;
                            object3 = ((cn.sharesdk.framework.b.a.c)object4).a;
                            bl4 = this.a((String)object3, false);
                            break block28;
                        }
                        object3 = ((cn.sharesdk.framework.b.a.c)object4).a;
                        object3 = this.e((String)object3);
                        bl4 = this.a((String)object3, bl5);
                    }
                    if (bl4) {
                        object3 = this.b;
                        object4 = ((cn.sharesdk.framework.b.a.c)object4).b;
                        ((c)object3).a((ArrayList)object4);
                    }
                    ++n10;
                }
            }
            return;
        }
    }

    public HashMap e() {
        c c10;
        try {
            c10 = this.b;
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            HashMap hashMap = new HashMap();
            return hashMap;
        }
        return c10.f();
    }

    public HashMap f() {
        Object object = this.d;
        boolean bl2 = ((e)object).k();
        if (!bl2 && (bl2 = ((e)(object = this.d)).m())) {
            object = new Object();
            return object;
        }
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            this.d.b(false);
            SSDKLog.b().d(throwable);
            HashMap hashMap = new HashMap();
            return hashMap;
        }
        object = ((c)object).d();
        e e10 = this.d;
        boolean bl3 = true;
        e10.b(bl3);
        return object;
    }
}

