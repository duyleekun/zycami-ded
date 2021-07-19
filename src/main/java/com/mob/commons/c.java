/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.SparseArray
 */
package com.mob.commons;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.MobProductCollector;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b;
import com.mob.commons.b.d;
import com.mob.commons.c$1;
import com.mob.commons.c$2;
import com.mob.commons.e;
import com.mob.commons.i;
import com.mob.commons.j;
import com.mob.commons.k;
import com.mob.commons.l;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SQLiteHelper;
import com.mob.tools.utils.SQLiteHelper$SingleTableDB;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

public class c
implements Handler.Callback {
    private static c a;
    private Handler b;
    private SQLiteHelper$SingleTableDB c;
    private Hashon d;
    private Random e;
    private boolean f = true;

    private c() {
        Object object = new Hashon();
        this.d = object;
        this.e = object = new Random();
        object = MobHandlerThread.newHandler("d", (Handler.Callback)this);
        this.b = object;
        this.b();
        this.c();
    }

    private int a(SparseArray sparseArray) {
        SQLiteHelper$SingleTableDB singleTableDB;
        String string2;
        String string3 = ")";
        String string4 = "time in (";
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = sparseArray.size();
        Object object = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            block27: {
                c10 = stringBuilder.length();
                if (c10 <= '\u0000') break block27;
                string2 = ", ";
                stringBuilder.append(string2);
            }
            c10 = '\'';
            stringBuilder.append(c10);
            Object object2 = sparseArray.valueAt(i10);
            object2 = (String)object2;
            stringBuilder.append((String)object2);
            stringBuilder.append(c10);
            continue;
        }
        sparseArray = null;
        try {
            singleTableDB = this.b();
        }
        catch (Throwable throwable) {
            try {
                object = MobLog.getInstance();
            }
            catch (Throwable throwable2) {
                MobLog.getInstance().w(throwable2);
                return 0;
            }
            ((NLog)object).w(throwable);
            SQLiteHelper$SingleTableDB singleTableDB2 = this.b();
            object = new StringBuilder();
            ((StringBuilder)object).append(string4);
            string4 = stringBuilder.toString();
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            return SQLiteHelper.delete(singleTableDB2, string3, null);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string4);
        string2 = stringBuilder.toString();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        return SQLiteHelper.delete(singleTableDB, (String)object, null);
    }

    public static /* synthetic */ int a(c c10, SparseArray sparseArray) {
        return c10.a(sparseArray);
    }

    public static /* synthetic */ int a(c c10, String[][] stringArray) {
        return c10.a(stringArray);
    }

    /*
     * Exception decompiling
     */
    private int a(String[][] var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [20[DOLOOP]], but top level block is 21[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static /* synthetic */ SparseArray a(c c10, String[][] stringArray, int n10) {
        return c10.a(stringArray, n10);
    }

    /*
     * Loose catch block
     * Could not resolve type clashes
     */
    private SparseArray a(String[][] object, int n10) {
        SparseArray sparseArray;
        block85: {
            int n11;
            Object object2;
            Object object3;
            int n12;
            ArrayList<SparseArray> arrayList;
            Object object4;
            Object object5;
            Object object6;
            block84: {
                sparseArray = new SparseArray();
                object6 = new HashMap();
                object5 = MobSDK.getContext();
                object5 = DeviceHelper.getInstance((Context)object5);
                object4 = "plat";
                int n13 = ((DeviceHelper)object5).getPlatformCode();
                arrayList = n13;
                ((HashMap)object6).put(object4, arrayList);
                object4 = "device";
                arrayList = ((DeviceHelper)object5).getDeviceKey();
                ((HashMap)object6).put(object4, arrayList);
                object4 = "mac";
                arrayList = ((DeviceHelper)object5).getMacAddress();
                ((HashMap)object6).put(object4, arrayList);
                object4 = "model";
                arrayList = ((DeviceHelper)object5).getModel();
                ((HashMap)object6).put(object4, arrayList);
                object4 = "duid";
                arrayList = DeviceAuthorizer.authorize(null);
                ((HashMap)object6).put(object4, arrayList);
                object4 = "imei";
                arrayList = ((DeviceHelper)object5).getIMEI();
                ((HashMap)object6).put(object4, arrayList);
                object4 = "serialno";
                arrayList = ((DeviceHelper)object5).getSerialno();
                ((HashMap)object6).put(object4, arrayList);
                object4 = "networktype";
                arrayList = ((DeviceHelper)object5).getDetailNetworkTypeForStatic();
                ((HashMap)object6).put(object4, arrayList);
                object4 = "dataNetworkType";
                n13 = ((DeviceHelper)object5).getDataNtType();
                arrayList = n13;
                ((HashMap)object6).put(object4, arrayList);
                object4 = new ArrayList();
                object5 = ((DeviceHelper)object5).getManufacturer();
                object5 = Data.rawMD5((String)object5);
                n13 = 0;
                arrayList = null;
                for (n12 = 0; n12 < n10; ++n12) {
                    block83: {
                        object3 = object /* !! */ [n12];
                        int n14 = 1;
                        object2 = object3[n14];
                        int n15 = 2;
                        object2 = Base64.decode((String)object2, (int)n15);
                        object2 = Data.AES128Decode((byte[])object5, (byte[])object2);
                        String string2 = "utf-8";
                        Object object7 = new String((byte[])object2, string2);
                        object2 = ((String)object7).trim();
                        object7 = this.d;
                        object2 = ((Hashon)object7).fromJson((String)object2);
                        if (object2 == null) break block83;
                        n15 = (int)(((HashMap)object2).isEmpty() ? 1 : 0);
                        if (n15 != 0) break block83;
                        object7 = "type";
                        object7 = ((HashMap)object2).get(object7);
                        object7 = ResHelper.forceCast(object7, null);
                        object7 = (String)object7;
                        n15 = (int)(this.a((String)object7) ? 1 : 0);
                        if (n15 == 0) continue;
                    }
                    object3 = object3[0];
                    sparseArray.put(n12, object3);
                    try {
                        ((ArrayList)object4).add(object2);
                        continue;
                    }
                    catch (Throwable throwable) {
                        object2 = MobLog.getInstance();
                        ((NLog)object2).w(throwable);
                    }
                }
                n11 = ((ArrayList)object4).isEmpty();
                if (n11 == 0) break block84;
                {
                    catch (Throwable throwable) {
                        i.e(null);
                        MobLog.getInstance().w(throwable);
                        return null;
                    }
                }
                object /* !! */  = new SparseArray();
                return object /* !! */ ;
            }
            object /* !! */  = "datas";
            ((HashMap)object6).put(object /* !! */ , object4);
            object /* !! */  = "token";
            Object object8 = l.a();
            object8 = ((l)object8).b();
            ((HashMap)object6).put(object /* !! */ , object8);
            arrayList = new ArrayList<SparseArray>();
            object8 = "appkey";
            object5 = MobSDK.getAppkey();
            object /* !! */  = new KVPair((String)object8, object5);
            arrayList.add(object /* !! */ );
            object8 = "m";
            object5 = this.d;
            object6 = ((Hashon)object5).fromHashMap((HashMap)object6);
            object6 = this.b((String)object6);
            object /* !! */  = new KVPair((String)object8, object6);
            arrayList.add(object /* !! */ );
            object3 = new ArrayList();
            object8 = "User-Identity";
            object6 = MobProductCollector.getUserIdentity();
            object /* !! */  = new KVPair((String)object8, object6);
            ((ArrayList)object3).add(object /* !! */ );
            n10 = 68;
            object8 = k.a(n10);
            object6 = MobSDK.getContext();
            object6 = com.mob.commons.b.d.d((Context)object6);
            object /* !! */  = new KVPair((String)object8, object6);
            ((ArrayList)object3).add(object /* !! */ );
            object2 = new NetworkHelper$NetworkTimeOut();
            n11 = 30000;
            ((NetworkHelper$NetworkTimeOut)object2).readTimout = n11;
            ((NetworkHelper$NetworkTimeOut)object2).connectionTimeout = n11;
            object5 = new NetworkHelper();
            object4 = com.mob.commons.c.e();
            n12 = 0;
            object /* !! */  = ((NetworkHelper)object5).httpPost((String)object4, arrayList, null, (ArrayList)object3, (NetworkHelper$NetworkTimeOut)object2);
            object8 = this.d;
            object /* !! */  = ((Hashon)object8).fromJson((String)object /* !! */ );
            object8 = "200";
            object6 = "status";
            object /* !! */  = object /* !! */ .get(object6);
            object /* !! */  = String.valueOf(object /* !! */ );
            n11 = (int)(((String)object8).equals(object /* !! */ ) ? 1 : 0);
            if (n11 != 0) break block85;
            i.e(null);
        }
        return sparseArray;
    }

    public static c a() {
        Class<c> clazz = c.class;
        synchronized (clazz) {
            c c10 = a;
            if (c10 == null) {
                a = c10 = new c();
            }
            c10 = a;
            return c10;
        }
    }

    public static /* synthetic */ Hashon a(c c10) {
        return c10.d;
    }

    public static /* synthetic */ boolean a(c c10, boolean bl2) {
        c10.f = bl2;
        return bl2;
    }

    private boolean a(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl2 = true;
        if (n10 == 0) {
            long l10;
            long l11;
            String string3 = k.a(19);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.f();
            }
            string3 = k.a(20);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.e();
            }
            string3 = k.a(21);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.g();
            }
            string3 = k.a(22);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.c();
            }
            string3 = k.a(23);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.j();
            }
            string3 = k.a(24);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.k();
            }
            string3 = k.a(25);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.m();
            }
            string3 = k.a(26);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.x();
            }
            string3 = k.a(27);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.o();
            }
            string3 = k.a(28);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.q();
            }
            string3 = k.a(29);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.w();
            }
            string3 = k.a(30);
            n10 = string3.equals(string2);
            long l12 = 0L;
            if (n10 != 0) {
                long l13 = com.mob.commons.b.A();
                long l14 = l13 - l12;
                Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object <= 0) {
                    bl2 = false;
                }
                return bl2;
            }
            string3 = k.a(31);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.B();
            }
            string3 = k.a(32);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                long l15 = com.mob.commons.b.F();
                long l16 = l15 - l12;
                Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object <= 0) {
                    bl2 = false;
                }
                return bl2;
            }
            string3 = k.a(33);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                long l17 = com.mob.commons.b.H();
                long l18 = l17 - l12;
                Object object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                if (object <= 0) {
                    bl2 = false;
                }
                return bl2;
            }
            string3 = k.a(34);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                long l19 = com.mob.commons.b.M();
                long l20 = l19 - l12;
                Object object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                if (object <= 0) {
                    bl2 = false;
                }
                return bl2;
            }
            string3 = k.a(35);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                long l21 = com.mob.commons.b.N();
                long l22 = l21 - l12;
                Object object = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                if (object <= 0) {
                    bl2 = false;
                }
                return bl2;
            }
            string3 = k.a(36);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                long l23 = com.mob.commons.b.O();
                long l24 = l23 - l12;
                Object object = l24 == 0L ? 0 : (l24 < 0L ? -1 : 1);
                if (object <= 0) {
                    bl2 = false;
                }
                return bl2;
            }
            string3 = k.a(37);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                long l25 = com.mob.commons.b.Q();
                long l26 = l25 - l12;
                Object object = l26 == 0L ? 0 : (l26 < 0L ? -1 : 1);
                if (object <= 0) {
                    bl2 = false;
                }
                return bl2;
            }
            string3 = k.a(38);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                return com.mob.commons.b.S();
            }
            string3 = k.a(39);
            n10 = string3.equals(string2);
            if (n10 != 0) {
                long l27 = com.mob.commons.b.T();
                long l28 = l27 - l12;
                Object object = l28 == 0L ? 0 : (l28 < 0L ? -1 : 1);
                if (object <= 0) {
                    bl2 = false;
                }
                return bl2;
            }
            n10 = 40;
            string3 = k.a(n10);
            int n11 = string3.equals(string2);
            if (n11 != 0 && (n11 = (l11 = (l10 = com.mob.commons.b.V()) - l12) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
                bl2 = false;
            }
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private SQLiteHelper$SingleTableDB b() {
        synchronized (this) {
            long l10;
            Object object = this.c;
            if (object != null) return this.c;
            object = MobSDK.getContext();
            String string2 = "comm/dbs/.dh";
            if ((object = ResHelper.getDataCacheFile((Context)object, string2)) == null) return this.c;
            long l11 = ((File)object).length();
            long l12 = l11 - (l10 = 0xC800000L);
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                ((File)object).delete();
                object = MobSDK.getContext();
                string2 = "comm/dbs/.dh";
                object = ResHelper.getDataCacheFile((Context)object, string2);
            }
            object = ((File)object).getAbsolutePath();
            string2 = "DataHeap_1";
            this.c = object = SQLiteHelper.getDatabase((String)object, string2);
            string2 = "time";
            String string3 = "text";
            boolean bl2 = true;
            ((SQLiteHelper$SingleTableDB)object).addField(string2, string3, bl2);
            object = this.c;
            string2 = "data";
            string3 = "text";
            ((SQLiteHelper$SingleTableDB)object).addField(string2, string3, bl2);
            return this.c;
        }
    }

    public static /* synthetic */ SQLiteHelper$SingleTableDB b(c c10) {
        return c10.b();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private File b(Object ... object) {
        File file;
        int n10;
        Object object2;
        block17: {
            Object object3;
            int n11;
            int n12;
            int n13 = 0;
            object2 = null;
            Object object4 = (String)object[0];
            int n14 = 1;
            String string2 = (String)object[n14];
            n10 = 4;
            String string3 = (String)object[n10];
            int n15 = 5;
            String string4 = (String)object[n15];
            boolean bl2 = TextUtils.isEmpty((CharSequence)object4);
            file = null;
            if (bl2) return file;
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) return file;
            File file2 = MobSDK.getContext().getFilesDir();
            Object object5 = k.a(n15);
            File file3 = new File(file2, (String)object5);
            n15 = 2;
            object5 = (byte[])object[n15];
            int n16 = 3;
            try {
                object = object[n16];
                object = String.valueOf(object);
                n12 = Integer.parseInt((String)object);
            }
            catch (Throwable throwable) {
                n12 = 0;
                object = null;
            }
            n16 = 14;
            if (object5 != null && n12 > 0 && (n11 = ((Object)object5).length) >= n12 && (n11 = (int)(((String)object4).equals(object3 = Data.MD5((byte[])object5, 0, n12)) ? 1 : 0)) != 0) {
                object3 = new ByteArrayInputStream((byte[])object5, 0, n12);
            } else {
                object2 = k.a(n16);
                object = new File(file3, (String)object2);
                n13 = ((File)object).exists();
                if (n13 != 0 && (n13 = ((String)object4).equals(object2 = Data.MD5((File)object))) != 0) {
                    object3 = new FileInputStream((File)object);
                } else {
                    object2 = com.mob.commons.d.a();
                    n15 = 20;
                    ((com.mob.commons.d)object2).a(n15);
                    ((File)object).delete();
                    n11 = 0;
                    object3 = null;
                }
            }
            if (object3 == null) return file;
            long l10 = System.currentTimeMillis();
            object = String.valueOf(l10);
            file = new File(file3, (String)object);
            n12 = (int)(file.exists() ? 1 : 0);
            if (n12 == 0) {
                file.mkdirs();
            }
            object2 = new StringBuilder();
            object5 = file.getName();
            ((StringBuilder)object2).append((String)object5);
            object5 = ".zip";
            ((StringBuilder)object2).append((String)object5);
            object2 = ((StringBuilder)object2).toString();
            object = new File(file, (String)object2);
            object2 = new FileOutputStream((File)object);
            Data.AES128Decode(string2, (InputStream)object3, (OutputStream)object2);
            ((InputStream)object3).close();
            ((FileOutputStream)object2).close();
            try {
                object2 = MobSDK.getContext();
                object2 = DeviceHelper.getInstance((Context)object2);
                n14 = 17;
                n14 = (int)(((DeviceHelper)object2).checkADBModel(n14) ? 1 : 0);
                if (n14 != 0 && (n13 = ((DeviceHelper)object2).checkUA()) != 0) {
                    object = com.mob.commons.d.a();
                    n13 = 19;
                    ((com.mob.commons.d)object).a(n13);
                    break block17;
                }
                object2 = com.mob.commons.d.a();
                ((com.mob.commons.d)object2).a(n16);
                com.mob.commons.a.d.a((String)object4, (File)object, string3, string4);
            }
            catch (Throwable throwable) {
                try {}
                catch (Throwable throwable2) {
                    try {
                        ResHelper.deleteFileAndFolder(file);
                        throw throwable2;
                    }
                    catch (Throwable throwable3) {
                        object4 = com.mob.commons.d.a();
                        ((com.mob.commons.d)object4).a(n10, throwable3);
                    }
                    throw throwable2;
                }
                object2 = com.mob.commons.d.a();
                int n17 = 6;
                ((com.mob.commons.d)object2).a(n17, throwable);
                {
                    ResHelper.deleteFileAndFolder(file);
                    return file;
                }
            }
        }
        ResHelper.deleteFileAndFolder(file);
        return file;
        {
            catch (Throwable throwable2) {
                object2 = com.mob.commons.d.a();
                ((com.mob.commons.d)object2).a(n10, throwable2);
                return file;
            }
        }
    }

    private String b(String object) {
        Object object2 = new ByteArrayOutputStream();
        Object object3 = new DataOutputStream((OutputStream)object2);
        long l10 = this.e.nextLong();
        ((DataOutputStream)object3).writeLong(l10);
        l10 = this.e.nextLong();
        ((DataOutputStream)object3).writeLong(l10);
        ((DataOutputStream)object3).flush();
        ((FilterOutputStream)object3).close();
        object2 = ((ByteArrayOutputStream)object2).toByteArray();
        object3 = new ByteArrayOutputStream();
        Object object4 = new GZIPOutputStream((OutputStream)object3);
        Object object5 = new BufferedOutputStream((OutputStream)object4);
        object = ((String)object).getBytes("utf-8");
        ((FilterOutputStream)object5).write((byte[])object);
        ((BufferedOutputStream)object5).flush();
        ((FilterOutputStream)object5).close();
        object = ((ByteArrayOutputStream)object3).toByteArray();
        object = Data.AES128Encode((byte[])object2, (byte[])object);
        object3 = new MobRSA(1024);
        int n10 = 16;
        object4 = new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", n10);
        object5 = new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", n10);
        object2 = ((MobRSA)object3).encode((byte[])object2, (BigInteger)object4, (BigInteger)object5);
        object3 = new ByteArrayOutputStream();
        object4 = new DataOutputStream((OutputStream)object3);
        int n11 = ((Object)object2).length;
        ((DataOutputStream)object4).writeInt(n11);
        ((FilterOutputStream)object4).write((byte[])object2);
        int n12 = ((Object)object).length;
        ((DataOutputStream)object4).writeInt(n12);
        ((FilterOutputStream)object4).write((byte[])object);
        ((DataOutputStream)object4).flush();
        ((FilterOutputStream)object4).close();
        return Base64.encodeToString((byte[])((ByteArrayOutputStream)object3).toByteArray(), (int)2);
    }

    private void b(long l10, HashMap object) {
        Object object2;
        Object object3 = com.mob.commons.e.a("comm/locks/.dhlock");
        boolean bl2 = com.mob.commons.e.a((File)object3, (LockAction)(object2 = new c$1(this, l10, (HashMap)object)));
        if (!bl2) {
            object3 = MobLog.getInstance();
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "DataHeap add log error data type = ";
            stringBuilder.append(string2);
            if (object == null) {
                object = null;
            } else {
                string2 = "type";
                object = ((HashMap)object).get(string2);
            }
            stringBuilder.append(object);
            object = ", updateTime = ";
            stringBuilder.append((String)object);
            stringBuilder.append(l10);
            String string3 = stringBuilder.toString();
            object2 = new Throwable(string3);
            ((NLog)object3).e((Throwable)object2);
        }
    }

    private void c() {
        String string2;
        boolean bl2;
        boolean bl3 = com.mob.commons.b.aa();
        if (bl3) {
            return;
        }
        long l10 = com.mob.commons.b.K();
        Object object = DeviceHelper.getInstance(MobSDK.getContext());
        if (object != null && ((object = ((DeviceHelper)object).getNetworkType()) == null || (bl2 = (string2 = "none").equals(object)))) {
            l10 = 600000L;
        }
        this.b.sendEmptyMessageDelayed(1, l10);
    }

    private boolean d() {
        Object object;
        boolean bl2 = com.mob.commons.b.I();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        Object object2 = DeviceHelper.getInstance(MobSDK.getContext());
        if (object2 == null) {
            return false;
        }
        if ((object2 = ((DeviceHelper)object2).getNetworkType()) != null && !(bl2 = ((String)(object = "none")).equals(object2))) {
            this.f = bl3;
            object2 = com.mob.commons.e.a("comm/locks/.dhlock");
            object = new c$2(this);
            bl2 = com.mob.commons.e.a((File)object2, (LockAction)object);
            boolean bl4 = this.f;
            if (!bl4 || !bl2) {
                bl3 = false;
            }
            return bl3;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private static String e() {
        block6: {
            var0 = i.g();
            var0 = j.b((String)var0);
            return var0;
            ** finally { 
lbl7:
            // 1 sources

            break block6;
            catch (Throwable var1_2) {
                var0 = null;
            }
            var2_4 = MobLog.getInstance();
            var2_4.w((Throwable)var1_3);
        }
        var3_5 = TextUtils.isEmpty((CharSequence)var0);
        if (var3_5) {
            var0 = new StringBuilder();
            var1_3 = j.b();
            var0.append(var1_3);
            var1_3 = "/v5/gcl";
            var0.append(var1_3);
            var0 = var0.toString();
        }
        return var0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(long l10, HashMap object) {
        synchronized (this) {
            int n10;
            boolean bl2 = com.mob.commons.b.aa();
            if (bl2) {
                return;
            }
            Message message = new Message();
            message.what = n10 = 2;
            Object object2 = new Object[n10];
            Object object3 = l10;
            Object[] objectArray = null;
            object2[0] = object3;
            int n11 = 1;
            object2[n11] = object;
            message.obj = object2;
            if (object != null) {
                object3 = MobLog.getInstance();
                object2 = new StringBuilder();
                String string2 = "type: ";
                ((StringBuilder)object2).append(string2);
                string2 = "type";
                object = ((HashMap)object).get(string2);
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                objectArray = new Object[]{};
                ((NLog)object3).d(object, objectArray);
            }
            object3 = this.b;
            object3.sendMessage(message);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Object ... object) {
        com.mob.commons.d d11;
        int n10 = 4;
        try {
            d11 = com.mob.commons.d.a();
            int n11 = 13;
            d11.a(n11);
            object = this.b((Object[])object);
        }
        catch (Throwable throwable) {
            d11 = null;
            try {
                com.mob.commons.d d10 = com.mob.commons.d.a();
                int n11 = 5;
                d10.a(n11, throwable);
            }
            catch (Throwable throwable2) {
                try {
                    ResHelper.deleteFileAndFolder(null);
                    throw throwable2;
                }
                catch (Throwable throwable3) {
                    com.mob.commons.d d10 = com.mob.commons.d.a();
                    d10.a(n10, throwable3);
                }
                throw throwable2;
            }
            try {
                ResHelper.deleteFileAndFolder(null);
                return;
            }
            catch (Throwable throwable2) {
                d11 = com.mob.commons.d.a();
                d11.a(n10, throwable2);
            }
            return;
        }
        ResHelper.deleteFileAndFolder((File)object);
    }

    public boolean handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 == n12) {
                long l10;
                object = (Object[])object.obj;
                Object object2 = object[0];
                Long l11 = -1;
                long l12 = (Long)(object2 = (Long)ResHelper.forceCast(object2, l11));
                long l13 = l12 - (l10 = 0L);
                n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n10 > 0) {
                    object = (HashMap)object[n11];
                    this.b(l12, (HashMap)object);
                    this.c();
                }
            }
        } else {
            object = this.b;
            object.removeMessages(n11);
            boolean bl2 = this.d();
            if (!bl2) {
                this.c();
            }
        }
        return false;
    }
}

