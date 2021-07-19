/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.text.format.Formatter
 *  android.util.Base64
 */
package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.push.ac;
import com.xiaomi.push.bf;
import com.xiaomi.push.bj;
import com.xiaomi.push.h;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
implements IEventProcessor {
    public Context a;
    private HashMap a;

    public a(Context context) {
        this.a(context);
    }

    public static String a(com.xiaomi.clientreport.data.a a10) {
        return String.valueOf(a10.production);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private List a(String var1_1) {
        block12: {
            block13: {
                var2_7 = new ArrayList<String>();
                var3_8 = 4;
                var4_9 = new byte[var3_8];
                var5_10 = new byte[var3_8];
                var6_11 = 0;
                var7_12 = null;
                try {
                    var9_14 = new File(var1_1);
                    var8_13 = new FileInputStream((File)var9_14);
                }
                catch (Throwable var1_4) {
                    break block12;
                }
                catch (Exception var1_5) {
                    // empty catch block
                    ** GOTO lbl-1000
                }
                try {
                    while ((var10_15 = var8_13.read(var4_9)) != (var6_11 = -1)) {
                        block14: {
                            block15: {
                                var9_14 = "eventData read from cache file failed because magicNumber error";
                                if (var10_15 != var3_8) {
                                    while (true) {
                                        b.d((String)var9_14);
                                        break block13;
                                        break;
                                    }
                                }
                                if ((var10_15 = ac.a(var4_9)) != (var11_16 = -573785174)) ** continue;
                                var10_15 = var8_13.read(var5_10);
                                if (var10_15 == var6_11) break block13;
                                if (var10_15 != var3_8) {
                                    var1_1 = "eventData read from cache file failed cause lengthBuffer error";
lbl28:
                                    // 3 sources

                                    while (true) {
                                        b.d(var1_1);
                                        break block13;
                                        break;
                                    }
                                }
                                var10_15 = ac.a(var5_10);
                                if (var10_15 < (var6_11 = 1) || var10_15 > (var6_11 = 4096)) break block14;
                                var7_12 = new byte[var10_15];
                                var12_17 = var8_13.read((byte[])var7_12);
                                if (var12_17 == var10_15) break block15;
                                var1_1 = "eventData read from cache file failed cause buffer size not equal length";
                                ** GOTO lbl28
                            }
                            var1_1 = this.bytesToString((byte[])var7_12);
                            var6_11 = (int)TextUtils.isEmpty((CharSequence)var1_1);
                            if (var6_11 != 0) continue;
                            var2_7.add(var1_1);
                            continue;
                        }
                        var1_1 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
                        ** continue;
                    }
                }
                catch (Throwable var1_2) {
                    var7_12 = var8_13;
                    break block12;
                }
                catch (Exception var1_3) {
                    var7_12 = var8_13;
                    ** GOTO lbl-1000
                }
            }
            y.a(var8_13);
            return var2_7;
lbl-1000:
            // 2 sources

            {
                b.a((Throwable)var1_1);
            }
            y.a(var7_12);
            return var2_7;
        }
        y.a(var7_12);
        throw var1_6;
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        boolean bl2;
        if (fileLock != null && (bl2 = fileLock.isValid())) {
            try {
                fileLock.release();
            }
            catch (IOException iOException) {
                b.a(iOException);
            }
        }
        y.a(randomAccessFile);
    }

    private void a(String object, String arrayList) {
        com.xiaomi.clientreport.manager.a a10 = com.xiaomi.clientreport.manager.a.a(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("24:");
        stringBuilder.append((String)object);
        stringBuilder.append(",");
        stringBuilder.append((String)((Object)arrayList));
        object = stringBuilder.toString();
        object = a10.a(5001, (String)object);
        arrayList = new ArrayList<Object>();
        object = ((EventClientReport)object).toJsonString();
        arrayList.add(object);
        this.a(arrayList);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aArray) {
        void var1_10;
        Object object;
        Object object2;
        BufferedOutputStream bufferedOutputStream;
        block45: {
            BufferedOutputStream bufferedOutputStream2;
            block46: {
                String string2;
                block44: {
                    string2 = null;
                    Object object3 = aArray[0];
                    object3 = this.b((com.xiaomi.clientreport.data.a)object3);
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
                    bufferedOutputStream = null;
                    if (bl2) {
                        return null;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object3);
                    com.xiaomi.clientreport.data.a[] aArray2 = ".lock";
                    ((StringBuilder)object2).append((String)aArray2);
                    object2 = ((StringBuilder)object2).toString();
                    object = new File((String)object2);
                    y.a((File)object);
                    aArray2 = "rw";
                    object2 = new RandomAccessFile((File)object, (String)aArray2);
                    object = ((RandomAccessFile)object2).getChannel();
                    object = ((FileChannel)object).lock();
                    aArray2 = new File((String)object3);
                    int n10 = 1;
                    FileOutputStream fileOutputStream = new FileOutputStream((File)aArray2, n10 != 0);
                    bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                    int n11 = aArray.length;
                    fileOutputStream = null;
                    int n12 = 0;
                    for (int i10 = 0; i10 < n11; ++i10) {
                        Object object4;
                        block42: {
                            Object object5;
                            int n13;
                            block43: {
                                object4 = aArray[i10];
                                if (object4 == null) continue;
                                object4 = ((com.xiaomi.clientreport.data.a)object4).toJsonString();
                                object4 = this.stringToBytes((String)object4);
                                if (object4 == null) break block42;
                                n13 = ((Object)object4).length;
                                if (n13 < n10) break block42;
                                n13 = ((Object)object4).length;
                                int n14 = 4096;
                                if (n13 > n14) break block42;
                                object5 = this.a;
                                n13 = (int)(bj.a(object5, (String)object3) ? 1 : 0);
                                if (n13 != 0) break block43;
                                int n15 = aArray.length - n12;
                                aArray2 = new com.xiaomi.clientreport.data.a[n15];
                                System.arraycopy(aArray, n12, aArray2, 0, n15);
                                y.a(bufferedOutputStream2);
                                this.a((RandomAccessFile)object2, (FileLock)object);
                                return aArray2;
                            }
                            n13 = -573785174;
                            object5 = ac.a(n13);
                            bufferedOutputStream2.write((byte[])object5);
                            n13 = ((Object)object4).length;
                            object5 = ac.a(n13);
                            bufferedOutputStream2.write((byte[])object5);
                            bufferedOutputStream2.write((byte[])object4);
                            bufferedOutputStream2.flush();
                            ++n12;
                            continue;
                        }
                        object4 = "event data throw a invalid item ";
                        try {
                            b.d((String)object4);
                        }
                        catch (Exception exception) {
                            break block44;
                        }
                        continue;
                    }
                    break block46;
                    catch (Throwable throwable) {
                        break block45;
                    }
                    catch (Exception exception) {
                        bufferedOutputStream2 = null;
                        break block44;
                    }
                    catch (Throwable throwable) {
                        bl2 = false;
                        object = null;
                        break block45;
                    }
                    catch (Exception exception) {
                        bl2 = false;
                        object = null;
                        bufferedOutputStream2 = null;
                        break block44;
                    }
                    catch (Throwable throwable) {
                        bl2 = false;
                        object = null;
                        object2 = null;
                        break block45;
                    }
                    catch (Exception exception) {
                        bl2 = false;
                        object = null;
                        object2 = null;
                        bufferedOutputStream2 = null;
                    }
                }
                string2 = "event data write to cache file failed cause exception";
                try {
                    b.a(string2, (Throwable)aArray);
                }
                catch (Throwable throwable) {
                    bufferedOutputStream = bufferedOutputStream2;
                }
            }
            y.a(bufferedOutputStream2);
            this.a((RandomAccessFile)object2, (FileLock)object);
            return null;
        }
        y.a(bufferedOutputStream);
        this.a((RandomAccessFile)object2, (FileLock)object);
        throw var1_10;
    }

    private String b(com.xiaomi.clientreport.data.a object) {
        int n10;
        Object object2 = this.a.getExternalFilesDir("event");
        object = com.xiaomi.clientreport.processor.a.a((com.xiaomi.clientreport.data.a)object);
        CharSequence charSequence = null;
        if (object2 == null) {
            return null;
        }
        CharSequence charSequence2 = new StringBuilder();
        object2 = ((File)object2).getAbsolutePath();
        charSequence2.append((String)object2);
        object2 = File.separator;
        charSequence2.append((String)object2);
        charSequence2.append((String)object);
        object = charSequence2.toString();
        object2 = null;
        for (int i10 = 0; i10 < (n10 = 100); ++i10) {
            charSequence2 = new StringBuilder();
            charSequence2.append((String)object);
            charSequence2.append(i10);
            charSequence2 = charSequence2.toString();
            Context context = this.a;
            boolean bl2 = bj.a(context, (String)charSequence2);
            if (!bl2) continue;
            charSequence = charSequence2;
            break;
        }
        return charSequence;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        block29: {
            var1_1 = this.a;
            var2_6 = "event";
            var3_8 = "eventUploading";
            bj.a((Context)var1_1, var2_6, var3_8);
            var1_1 = bj.a(this.a, var3_8);
            if (var1_1 == null) return;
            var4_9 = var1_1.length;
            if (var4_9 <= 0) {
                return;
            }
            var4_9 = var1_1.length;
            var5_10 = 0;
            var3_8 = null;
            var6_11 = null;
            var7_12 = false;
            var8_13 = null;
            var9_15 = null;
            while (var5_10 < var4_9) {
                block30: {
                    block34: {
                        block32: {
                            block31: {
                                block33: {
                                    block27: {
                                        block28: {
                                            block36: {
                                                block35: {
                                                    var10_16 = var1_1[var5_10];
                                                    if (var10_16 != null) break block35;
                                                    if (var6_11 != null && (var11_23 = var6_11.isValid())) {
                                                        try {
                                                            var6_11.release();
                                                        }
                                                        catch (IOException var10_17) {
                                                            b.a(var10_17);
                                                        }
                                                    }
                                                    y.a(var8_13);
                                                    if (var9_15 == null) break block30;
                                                    break block36;
                                                }
                                                try {
                                                    var12_24 = var10_16.length();
                                                    var14_25 = 0x500000L;
                                                    var16_26 = var12_24 == var14_25 ? 0 : (var12_24 < var14_25 ? -1 : 1);
                                                    if (var16_26 > 0) {
                                                        var17_27 = new StringBuilder();
                                                        var18_28 = "eventData read from cache file failed because ";
                                                        var17_27.append((String)var18_28);
                                                        var18_28 = var10_16.getName();
                                                        var17_27.append((String)var18_28);
                                                        var18_28 = " is too big, length ";
                                                        var17_27.append((String)var18_28);
                                                        var19_29 = var10_16.length();
                                                        var17_27.append(var19_29);
                                                        var17_27 = var17_27.toString();
                                                        b.d((String)var17_27);
                                                        var17_27 = var10_16.getName();
                                                        var18_28 = this.a;
                                                        var14_25 = var10_16.length();
                                                        var18_28 = Formatter.formatFileSize((Context)var18_28, (long)var14_25);
                                                        this.a((String)var17_27, (String)var18_28);
                                                        var10_16.delete();
                                                        if (var6_11 == null || !(var11_23 = var6_11.isValid())) break block27;
                                                        break block28;
                                                    }
                                                    ** GOTO lbl-1000
                                                }
                                                catch (Throwable var1_5) {
                                                    break block29;
                                                }
                                                catch (Exception var10_21) {
                                                    // empty catch block
                                                    ** GOTO lbl-1000
                                                }
                                            }
lbl66:
                                            // 3 sources

                                            while (true) {
                                                var9_15.delete();
                                                break block30;
                                                break;
                                            }
                                        }
                                        try {
                                            var6_11.release();
                                        }
                                        catch (IOException var10_18) {
                                            b.a(var10_18);
                                        }
                                    }
                                    y.a((Closeable)var8_13);
                                    if (var9_15 == null) break block30;
                                    ** GOTO lbl66
lbl-1000:
                                    // 1 sources

                                    {
                                        var17_27 = var10_16.getAbsolutePath();
                                        var21_30 /* !! */  = new StringBuilder();
                                        var21_30 /* !! */ .append((String)var17_27);
                                        var22_31 = ".lock";
                                        var21_30 /* !! */ .append(var22_31);
                                        var21_30 /* !! */  = var21_30 /* !! */ .toString();
                                        var18_28 = new File((String)var21_30 /* !! */ );
                                    }
                                    try {
                                        y.a((File)var18_28);
                                        var21_30 /* !! */  = "rw";
                                        var9_15 = new RandomAccessFile((File)var18_28, (String)var21_30 /* !! */ );
                                    }
                                    catch (Throwable var1_3) {
                                        // empty catch block
                                        break block31;
                                    }
                                    catch (Exception var10_20) {
                                        // empty catch block
                                        break block32;
                                    }
                                    try {
                                        var8_13 = var9_15.getChannel();
                                        var6_11 = var8_13.lock();
                                        var8_13 = this.a((String)var17_27);
                                        this.a((List)var8_13);
                                        var10_16.delete();
                                        if (var6_11 == null || !(var7_12 = var6_11.isValid())) break block33;
                                    }
                                    catch (Throwable var1_2) {
                                        var8_13 = var9_15;
                                        break block31;
                                    }
                                    catch (Exception var10_19) {
                                        var8_13 = var9_15;
                                        break block32;
                                    }
                                    try {
                                        var6_11.release();
                                    }
                                    catch (IOException var8_14) {
                                        b.a(var8_14);
                                    }
                                }
                                y.a((Closeable)var9_15);
                                var18_28.delete();
                                var8_13 = var9_15;
                                var9_15 = var18_28;
                                break block30;
                            }
                            var9_15 = var18_28;
                            break block29;
                        }
                        var9_15 = var18_28;
lbl-1000:
                        // 2 sources

                        {
                            b.a((Throwable)var10_16);
                            if (var6_11 == null || !(var11_23 = var6_11.isValid())) break block34;
                        }
                        try {
                            var6_11.release();
                        }
                        catch (IOException var10_22) {
                            b.a(var10_22);
                        }
                    }
                    y.a(var8_13);
                    if (var9_15 == null) ** break;
                    ** continue;
                }
                ++var5_10;
            }
            return;
        }
        if (var6_11 != null && (var4_9 = (int)var6_11.isValid()) != 0) {
            try {
                var6_11.release();
            }
            catch (IOException var2_7) {
                b.a(var2_7);
            }
        }
        y.a(var8_13);
        if (var9_15 == null) throw var1_4;
        var9_15.delete();
        throw var1_4;
    }

    public void a(Context context) {
        this.a = context;
    }

    public void a(com.xiaomi.clientreport.data.a a10) {
        boolean bl2 = a10 instanceof EventClientReport;
        if (!bl2) {
            return;
        }
        Object object = this.a;
        if (object == null) {
            return;
        }
        object = com.xiaomi.clientreport.processor.a.a(a10 = (EventClientReport)a10);
        ArrayList<com.xiaomi.clientreport.data.a> arrayList = (ArrayList<com.xiaomi.clientreport.data.a>)this.a.get(object);
        if (arrayList == null) {
            arrayList = new ArrayList<com.xiaomi.clientreport.data.a>();
        }
        arrayList.add(a10);
        this.a.put(object, arrayList);
    }

    public void a(List list) {
        bj.a(this.a, list);
    }

    public void a(com.xiaomi.clientreport.data.a[] aArray) {
        int n10;
        if (aArray != null && (n10 = aArray.length) != 0) {
            n10 = 0;
            com.xiaomi.clientreport.data.a a10 = aArray[0];
            if (a10 != null) {
                int n11;
                while ((aArray = this.a(aArray)) != null && (n11 = aArray.length) > 0 && (a10 = aArray[0]) != null) {
                }
                return;
            }
        }
        b.a("event data write to cache file failed because data null");
    }

    public void b() {
        Object object = this.a;
        if (object == null) {
            return;
        }
        int n10 = ((HashMap)object).size();
        if (n10 > 0) {
            boolean bl2;
            object = this.a.keySet().iterator();
            while (bl2 = object.hasNext()) {
                int n11;
                Object object2 = (String)object.next();
                com.xiaomi.clientreport.data.a[] aArray = this.a;
                if ((object2 = (ArrayList)aArray.get(object2)) == null || (n11 = ((ArrayList)object2).size()) <= 0) continue;
                n11 = ((ArrayList)object2).size();
                aArray = new com.xiaomi.clientreport.data.a[n11];
                ((ArrayList)object2).toArray(aArray);
                this.a(aArray);
            }
        }
        this.a.clear();
    }

    /*
     * WARNING - void declaration
     */
    public String bytesToString(byte[] byArray) {
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) >= (n10 = 1)) {
            Object object = com.xiaomi.clientreport.manager.a.a(this.a).a();
            n11 = (int)(((Config)object).isEventEncrypted() ? 1 : 0);
            if (n11 == 0) {
                return bf.a(byArray);
            }
            object = bj.a(this.a);
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 != 0) {
                return null;
            }
            if ((object = (Object)bj.a((String)object)) != null && (n10 = ((Object)object).length) > 0) {
                void var1_8;
                byArray = h.a((byte[])object, byArray);
                n11 = 2;
                byArray = Base64.decode((byte[])byArray, (int)n11);
                try {
                    return bf.a(byArray);
                }
                catch (IllegalBlockSizeException illegalBlockSizeException) {
                }
                catch (BadPaddingException badPaddingException) {
                }
                catch (NoSuchPaddingException noSuchPaddingException) {
                }
                catch (InvalidKeyException invalidKeyException) {
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                }
                catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
                    // empty catch block
                }
                b.a((Throwable)var1_8);
            }
        }
        return null;
    }

    public void setEventMap(HashMap hashMap) {
        this.a = hashMap;
    }

    public byte[] stringToBytes(String object) {
        block7: {
            int n10;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                return null;
            }
            Object object2 = com.xiaomi.clientreport.manager.a.a(this.a).a();
            bl2 = ((Config)object2).isEventEncrypted();
            if (!bl2) {
                return bf.a((String)object);
            }
            object2 = bj.a(this.a);
            object = bf.a((String)object);
            int n11 = TextUtils.isEmpty((CharSequence)object2);
            if (n11 == 0 && object != null && (n11 = ((Object)object).length) > (n10 = 1) && (object2 = (Object)bj.a((String)object2)) != null) {
                n11 = ((Object)object2).length;
                if (n11 <= n10) break block7;
                n11 = 2;
                object = Base64.encode((byte[])object, (int)n11);
                try {
                    return h.b((byte[])object2, (byte[])object);
                }
                catch (Exception exception) {
                    b.a(exception);
                }
            }
        }
        return null;
    }
}

