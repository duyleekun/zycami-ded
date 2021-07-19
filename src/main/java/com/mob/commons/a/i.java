/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.os.Environment
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.mob.commons.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.e;
import com.mob.commons.k;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class i
extends d {
    private PackageManager a;

    private long a(String iterator2, Long serializable) {
        boolean bl2;
        System.currentTimeMillis();
        long l10 = (Long)serializable;
        serializable = new LinkedList();
        iterator2 = this.b((String)((Object)iterator2));
        if (iterator2 != null && !(bl2 = iterator2.isEmpty())) {
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                serializable = (Long)iterator2.next();
                long l11 = (Long)serializable;
                long l12 = l11 - l10;
                Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object <= 0) continue;
                l10 = (Long)serializable;
            }
        }
        return l10;
    }

    private long a(String object, String object2) {
        long l10;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String)object);
        object = simpleDateFormat.parse((String)object2);
        try {
            l10 = ((Date)object).getTime();
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
            l10 = 0L;
        }
        return l10;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private HashMap a(String object) {
        void var1_15;
        HashMap<Object, Long> hashMap;
        Object object2;
        block70: {
            Object object3;
            block69: {
                void var6_29;
                int n10;
                block68: {
                    object2 = "utf-8";
                    Object object4 = " ";
                    hashMap = new HashMap<Object, Long>();
                    int n11 = 146;
                    Object string5 = null;
                    object3 = k.a(n11);
                    object3 = ReflectHelper.importClass((String)object3);
                    int n12 = 147;
                    CharSequence charSequence = k.a(n12);
                    Object[] objectArray2 = new Object[]{};
                    object3 = ReflectHelper.invokeStaticMethod((String)object3, (String)charSequence, objectArray2);
                    int n13 = 148;
                    String string2 = k.a(n13);
                    n10 = 1;
                    Object[] objectArray22 = new Object[n10];
                    Object[] objectArray3 = new StringBuilder();
                    int n14 = 151;
                    String string3 = k.a(n14);
                    objectArray3.append(string3);
                    objectArray3.append((String)object4);
                    objectArray3.append((String)object);
                    objectArray3 = objectArray3.toString();
                    objectArray22[0] = objectArray3;
                    object3 = ReflectHelper.invokeInstanceMethod(object3, string2, objectArray22);
                    int n15 = 149;
                    String string4 = k.a(n15);
                    objectArray3 = new Object[]{};
                    object3 = ReflectHelper.invokeInstanceMethod(object3, string4, objectArray3);
                    object3 = (InputStream)object3;
                    InputStreamReader inputStreamReader = new InputStreamReader((InputStream)object3, (String)object2);
                    object3 = new BufferedReader(inputStreamReader);
                    String string52 = ((BufferedReader)object3).readLine();
                    int n16 = TextUtils.isEmpty((CharSequence)string52);
                    if (n16 == 0) break block68;
                    Object[] objectArray4 = k.a(n11);
                    objectArray4 = ReflectHelper.importClass((String)objectArray4);
                    String string6 = k.a(n12);
                    Object[] objectArray5 = new Object[]{};
                    objectArray4 = ReflectHelper.invokeStaticMethod((String)objectArray4, string6, objectArray5);
                    String string7 = k.a(n13);
                    objectArray5 = new Object[n10];
                    charSequence = new StringBuilder();
                    n16 = 153;
                    String string8 = k.a(n16);
                    ((StringBuilder)charSequence).append(string8);
                    ((StringBuilder)charSequence).append((String)object4);
                    ((StringBuilder)charSequence).append((String)object);
                    String string9 = ((StringBuilder)charSequence).toString();
                    objectArray5[0] = string9;
                    Object object5 = ReflectHelper.invokeInstanceMethod((Object)objectArray4, string7, objectArray5);
                    object4 = k.a(n15);
                    objectArray4 = new Object[]{};
                    Object object6 = ReflectHelper.invokeInstanceMethod(object5, (String)object4, objectArray4);
                    InputStream inputStream = (InputStream)object6;
                    object4 = new InputStreamReader(inputStream, (String)object2);
                    BufferedReader bufferedReader = new BufferedReader((Reader)object4);
                    String string10 = bufferedReader.readLine();
                    object3 = bufferedReader;
                    String string11 = string10;
                }
                boolean bl2 = TextUtils.isEmpty((CharSequence)var6_29);
                if (bl2) break block69;
                while (true) {
                    String string12;
                    void string2;
                    Object[] objectArray = this.c((String)string2);
                    if (objectArray == null) continue;
                    object2 = objectArray[0];
                    object2 = (String)object2;
                    Object object7 = objectArray[n10];
                    Long l10 = (Long)object7;
                    hashMap.put(object2, l10);
                    if ((string12 = ((BufferedReader)object3).readLine()) != null) continue;
                    break;
                }
            }
            try {
                ((BufferedReader)object3).close();
                return hashMap;
            }
            catch (Throwable throwable) {}
            catch (Throwable throwable) {
                Object object8 = object3;
            }
            break block70;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        object2 = MobLog.getInstance();
        ((NLog)object2).d((Throwable)var1_15);
        return hashMap;
        finally {
            void var6_35;
            if (var6_35 != null) {
                var6_35.close();
            }
        }
    }

    private HashMap a(String string2, byte[] object) {
        try {
            string2 = Data.AES128Decode(string2, (byte[])object);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            Object[] objectArray = new Object[2];
            objectArray[0] = "DUClt";
            String string3 = throwable.getMessage();
            objectArray[1] = string3;
            ((NLog)object).d(throwable, (Object)"[%s] %s", objectArray);
            HashMap hashMap = new HashMap();
            return hashMap;
        }
        object = new Hashon;
        ((Hashon)object)();
        return ((Hashon)object).fromJson(string2);
    }

    private void a(long l10) {
        Object[] objectArray = MobSDK.getContext();
        Object object = "comm/dbs/.dupdcd";
        objectArray = ResHelper.getDataCacheFile((Context)objectArray, (String)object);
        object = new FileOutputStream((File)objectArray);
        objectArray = new DataOutputStream((OutputStream)object);
        try {
            objectArray.writeLong(l10);
            objectArray.flush();
            objectArray.close();
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            int n10 = 2;
            objectArray = new Object[n10];
            objectArray[0] = "DUClt";
            int n11 = 1;
            String string2 = throwable.getMessage();
            objectArray[n11] = string2;
            object = "[%s] %s";
            nLog.d(throwable, object, objectArray);
        }
    }

    private void a(HashMap object) {
        Object object2 = MobSDK.getContext();
        String string2 = "comm/dbs/.dudcd";
        object2 = ResHelper.getDataCacheFile((Context)object2, string2);
        boolean bl2 = true;
        Object object3 = MobSDK.getContext();
        object3 = DeviceHelper.getInstance((Context)object3);
        object3 = ((DeviceHelper)object3).getModel();
        object = this.a((String)object3, (HashMap)object);
        object3 = new FileOutputStream((File)object2);
        object2 = ((FileOutputStream)object3).getChannel();
        object = ByteBuffer.wrap((byte[])object);
        ((FileChannel)object2).write((ByteBuffer)object);
        try {
            ((FileChannel)object2).force(bl2);
            ((AbstractInterruptibleChannel)object2).close();
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            int n10 = 2;
            object3 = new Object[n10];
            String string3 = "DUClt";
            object3[0] = string3;
            String string4 = throwable.getMessage();
            object3[bl2] = string4;
            string2 = "[%s] %s";
            ((NLog)object2).d(throwable, (Object)string2, (Object[])object3);
        }
    }

    private boolean a(PackageInfo packageInfo) {
        packageInfo = packageInfo.applicationInfo;
        int n10 = packageInfo.flags;
        int n11 = n10 & 1;
        int n12 = 0;
        int n13 = 1;
        n11 = n11 == n13 ? n13 : 0;
        if ((n10 &= 0x80) == n13) {
            n10 = n13;
        } else {
            n10 = 0;
            packageInfo = null;
        }
        if (n11 || n10 != 0) {
            n12 = n13;
        }
        return n12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(File object) {
        int n10 = 1;
        if (object == null) return 0 != 0;
        boolean bl2 = ((File)object).isDirectory();
        if (!bl2) return 0 != 0;
        bl2 = false;
        PackageInfo packageInfo = null;
        try {
            PackageManager packageManager = this.a;
            if (packageManager == null) {
                packageManager = MobSDK.getContext();
                this.a = packageManager = packageManager.getPackageManager();
            }
            packageManager = this.a;
            object = ((File)object).getName();
            packageInfo = packageManager.getPackageInfo((String)object, 0);
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            int n11 = 2;
            Object[] objectArray = new Object[n11];
            objectArray[0] = "DUClt";
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Name not found: ";
            stringBuilder.append(string2);
            String string3 = throwable.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            objectArray[n10] = string3;
            string3 = "[%s] %s";
            nLog.d(string3, objectArray);
        }
        if (packageInfo == null) return 0 != 0;
        boolean bl3 = this.a(packageInfo);
        if (bl3) return 0 != 0;
        return n10 != 0;
    }

    private byte[] a(String string2, HashMap object) {
        Object object2 = new Hashon();
        object = ((Hashon)object2).fromHashMap((HashMap)object);
        try {
            return Data.AES128Encode(string2, (String)object);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            Object[] objectArray = new Object[2];
            objectArray[0] = "DUClt";
            String string3 = throwable.getMessage();
            objectArray[1] = string3;
            ((NLog)object2).d(throwable, (Object)"[%s] %s", objectArray);
            return ((String)object).getBytes();
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private List b(String object) {
        void var1_18;
        ArrayList<Long> arrayList;
        Object object2;
        block73: {
            Object object3;
            block71: {
                void var6_32;
                int n10;
                block70: {
                    object2 = "utf-8";
                    Object object4 = " ";
                    arrayList = new ArrayList<Long>();
                    int n11 = 146;
                    Object string5 = null;
                    object3 = k.a(n11);
                    object3 = ReflectHelper.importClass((String)object3);
                    int n12 = 147;
                    CharSequence charSequence = k.a(n12);
                    Object[] objectArray2 = new Object[]{};
                    object3 = ReflectHelper.invokeStaticMethod((String)object3, (String)charSequence, objectArray2);
                    int n13 = 148;
                    String string2 = k.a(n13);
                    n10 = 1;
                    Object[] objectArray22 = new Object[n10];
                    Object[] objectArray3 = new StringBuilder();
                    int n14 = 152;
                    String string3 = k.a(n14);
                    objectArray3.append(string3);
                    objectArray3.append((String)object4);
                    objectArray3.append((String)object);
                    objectArray3 = objectArray3.toString();
                    objectArray22[0] = objectArray3;
                    object3 = ReflectHelper.invokeInstanceMethod(object3, string2, objectArray22);
                    int n15 = 149;
                    String string4 = k.a(n15);
                    objectArray3 = new Object[]{};
                    object3 = ReflectHelper.invokeInstanceMethod(object3, string4, objectArray3);
                    object3 = (InputStream)object3;
                    InputStreamReader inputStreamReader = new InputStreamReader((InputStream)object3, (String)object2);
                    object3 = new BufferedReader(inputStreamReader);
                    String string52 = ((BufferedReader)object3).readLine();
                    int n16 = TextUtils.isEmpty((CharSequence)string52);
                    if (n16 == 0) break block70;
                    Object[] objectArray4 = k.a(n11);
                    objectArray4 = ReflectHelper.importClass((String)objectArray4);
                    String string6 = k.a(n12);
                    Object[] objectArray5 = new Object[]{};
                    objectArray4 = ReflectHelper.invokeStaticMethod((String)objectArray4, string6, objectArray5);
                    String string7 = k.a(n13);
                    objectArray5 = new Object[n10];
                    charSequence = new StringBuilder();
                    n16 = 154;
                    String string8 = k.a(n16);
                    ((StringBuilder)charSequence).append(string8);
                    ((StringBuilder)charSequence).append((String)object4);
                    ((StringBuilder)charSequence).append((String)object);
                    String string9 = ((StringBuilder)charSequence).toString();
                    objectArray5[0] = string9;
                    Object object5 = ReflectHelper.invokeInstanceMethod((Object)objectArray4, string7, objectArray5);
                    object4 = k.a(n15);
                    objectArray4 = new Object[]{};
                    Object object6 = ReflectHelper.invokeInstanceMethod(object5, (String)object4, objectArray4);
                    InputStream inputStream = (InputStream)object6;
                    object4 = new InputStreamReader(inputStream, (String)object2);
                    BufferedReader bufferedReader = new BufferedReader((Reader)object4);
                    String string10 = bufferedReader.readLine();
                    object3 = bufferedReader;
                    String string11 = string10;
                }
                boolean bl2 = TextUtils.isEmpty((CharSequence)var6_32);
                if (bl2) break block71;
                while (true) {
                    String string12;
                    void string2;
                    block72: {
                        String string13 = "-";
                        bl2 = string2.startsWith(string13);
                        if (bl2) break block72;
                        String string14 = "d";
                        bl2 = string2.startsWith(string14);
                        if (!bl2) continue;
                    }
                    Object[] objectArray = this.c((String)string2);
                    if (objectArray == null) continue;
                    object2 = objectArray[0];
                    object2 = (String)object2;
                    Object object7 = objectArray[n10];
                    Long l10 = (Long)object7;
                    arrayList.add(l10);
                    if ((string12 = ((BufferedReader)object3).readLine()) != null) continue;
                    break;
                }
            }
            try {
                ((BufferedReader)object3).close();
                return arrayList;
            }
            catch (Throwable throwable) {}
            catch (Throwable throwable) {
                Object object8 = object3;
            }
            break block73;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        object2 = MobLog.getInstance();
        ((NLog)object2).d((Throwable)var1_18);
        return arrayList;
        finally {
            void var6_38;
            if (var6_38 != null) {
                var6_38.close();
            }
        }
    }

    private Object[] c(String string2) {
        Object[] objectArray;
        block14: {
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            objectArray = null;
            if (bl2) break block14;
            bl2 = false;
            Object[] objectArray2 = null;
            Object object = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";
            object = Pattern.compile((String)object);
            object = ((Pattern)object).matcher(string2);
            boolean bl3 = ((Matcher)object).find();
            if (!bl3) break block14;
            Object object2 = ((Matcher)object).group(0);
            String string3 = "yyyy-MM-dd HH:mm";
            long l10 = this.a(string3, (String)object2);
            object2 = l10;
            int n10 = ((Matcher)object).end();
            int n11 = 1;
            n10 += n11;
            string2 = string2.substring(n10);
            long l11 = (Long)object2;
            long l12 = System.currentTimeMillis();
            n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
            if (n10 > 0) break block14;
            n10 = 2;
            objectArray = new Object[n10];
            objectArray[0] = string2;
            try {
                objectArray[n11] = object2;
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                object2 = new StringBuilder();
                string3 = "Simple err: ";
                ((StringBuilder)object2).append(string3);
                String string4 = throwable.getMessage();
                ((StringBuilder)object2).append(string4);
                string4 = ((StringBuilder)object2).toString();
                objectArray2 = new Object[]{};
                ((NLog)object).d(string4, objectArray2);
            }
        }
        return objectArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h() {
        Object object;
        Object object2;
        i i10 = this;
        String string2 = "DUClt";
        String string3 = "[%s] %s";
        int n10 = 2;
        try {
            Object object3 = MobSDK.getContext();
            object3 = DeviceHelper.getInstance((Context)object3);
            Object object4 = "android.permission.READ_EXTERNAL_STORAGE";
            int n11 = ((DeviceHelper)object3).checkPermission((String)object4);
            if (n11 != 0) {
                object3 = new StringBuilder();
                object4 = Environment.getExternalStorageDirectory();
                ((StringBuilder)object3).append(object4);
                int n12 = 16;
                object4 = k.a(n12);
                ((StringBuilder)object3).append((String)object4);
                object3 = ((StringBuilder)object3).toString();
                object4 = new File((String)object3);
                n12 = (int)(((File)object4).isDirectory() ? 1 : 0);
                if (n12 != 0) {
                    boolean bl2;
                    object4 = this.a((String)object3);
                    if (object4 != null && !(bl2 = ((HashMap)object4).isEmpty())) {
                        boolean bl3;
                        int n13;
                        Object object5;
                        Object object6;
                        boolean bl4;
                        long l10 = b.a();
                        Object object7 = this.j();
                        ArrayList<Object> arrayList = new ArrayList<Object>();
                        HashMap<Object, Object[]> hashMap = new HashMap<Object, Object[]>();
                        object4 = ((HashMap)object4).entrySet();
                        object4 = object4.iterator();
                        while (bl4 = object4.hasNext()) {
                            object6 = object4.next();
                            object6 = (Map.Entry)object6;
                            object5 = object6.getKey();
                            object5 = (String)object5;
                            object6 = object6.getValue();
                            object6 = (Long)object6;
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append((String)object3);
                            ((StringBuilder)object2).append((String)object5);
                            File file = new File((String)(object2 = ((StringBuilder)object2).toString()));
                            n13 = i10.a(file);
                            if (n13 == 0) continue;
                            object2 = file.getName();
                            arrayList.add(object2);
                            object2 = file.getAbsolutePath();
                            long l11 = i10.a((String)object2, (Long)object6);
                            object2 = file.getName();
                            object2 = ((HashMap)object7).get(object2);
                            object2 = (Long)object2;
                            long l12 = 0L;
                            if (object2 != null) {
                                l12 = (Long)object2;
                            }
                            if ((n13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) <= 0) continue;
                            object2 = file.getName();
                            object = l11;
                            ((HashMap)object7).put(object2, object);
                            object2 = file.getName();
                            object = l11;
                            hashMap.put(object2, (Object[])object);
                        }
                        n11 = 0;
                        object3 = null;
                        i10.a = null;
                        object3 = new ArrayList();
                        object2 = ((HashMap)object7).keySet();
                        object2 = object2.iterator();
                        while (bl3 = object2.hasNext()) {
                            object = object2.next();
                            n12 = (int)(arrayList.contains(object = (String)object) ? 1 : 0);
                            if (n12 != 0) continue;
                            ((ArrayList)object3).add(object);
                        }
                        object2 = ((ArrayList)object3).iterator();
                        while (bl3 = object2.hasNext()) {
                            object = object2.next();
                            object = (String)object;
                            ((HashMap)object7).remove(object);
                        }
                        i10.a((HashMap)object7);
                        long l13 = b.a();
                        n12 = (int)(hashMap.isEmpty() ? 1 : 0);
                        if (n12 == 0 || (n12 = (int)(((ArrayList)object3).isEmpty() ? 1 : 0)) == 0) {
                            object4 = new HashMap();
                            object7 = "scanAt";
                            object6 = l10;
                            ((HashMap)object4).put(object7, object6);
                            object7 = "update";
                            ((HashMap)object4).put(object7, hashMap);
                            object7 = "delete";
                            ((HashMap)object4).put(object7, object3);
                            object7 = new HashMap();
                            object6 = "type";
                            object5 = "APP_DIR_ACTIVE";
                            ((HashMap)object7).put(object6, object5);
                            object6 = "data";
                            ((HashMap)object7).put(object6, object4);
                            object4 = "datetime";
                            object6 = l13;
                            ((HashMap)object7).put(object4, object6);
                            object4 = c.a();
                            ((c)object4).a(l13, (HashMap)object7);
                        }
                        l13 = b.a() - l10;
                        object4 = MobLog.getInstance();
                        Object[] objectArray = new Object[n10];
                        StringBuilder stringBuilder = null;
                        objectArray[0] = string2;
                        stringBuilder = new StringBuilder();
                        object7 = "ttl: ";
                        stringBuilder.append((String)object7);
                        int n14 = arrayList.size();
                        stringBuilder.append(n14);
                        object7 = ", u: ";
                        stringBuilder.append((String)object7);
                        n14 = hashMap.size();
                        stringBuilder.append(n14);
                        object7 = ", d: ";
                        stringBuilder.append((String)object7);
                        n11 = ((ArrayList)object3).size();
                        stringBuilder.append(n11);
                        object3 = ", dur: ";
                        stringBuilder.append((String)object3);
                        stringBuilder.append(l13);
                        object3 = " ms";
                        stringBuilder.append((String)object3);
                        object3 = stringBuilder.toString();
                        n13 = 1;
                        objectArray[n13] = object3;
                        ((NLog)object4).i(string3, objectArray);
                        return;
                    }
                    object3 = MobLog.getInstance();
                    Object[] objectArray = new Object[n10];
                    boolean bl5 = false;
                    String string4 = null;
                    objectArray[0] = string2;
                    string4 = "No subs";
                    n12 = 1;
                    objectArray[n12] = string4;
                    ((NLog)object3).d(string3, objectArray);
                    return;
                }
                object3 = MobLog.getInstance();
                Object[] objectArray = new Object[n10];
                boolean bl6 = false;
                String string5 = null;
                objectArray[0] = string2;
                string5 = "Can not read";
                n12 = 1;
                objectArray[n12] = string5;
                ((NLog)object3).d(string3, objectArray);
                return;
            }
            object3 = MobLog.getInstance();
            Object[] objectArray = new Object[n10];
            boolean bl7 = false;
            String string6 = null;
            objectArray[0] = string2;
            string6 = "No permission";
            int n15 = 1;
            objectArray[n15] = string6;
            ((NLog)object3).d(string3, objectArray);
            return;
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            object = new Object[n10];
            object[0] = string2;
            string2 = throwable.getMessage();
            n10 = 1;
            object[n10] = string2;
            ((NLog)object2).d(throwable, (Object)string3, object);
        }
    }

    private long i() {
        Object object = MobSDK.getContext();
        Object object2 = "comm/dbs/.dupdcd";
        boolean bl2 = ((File)(object = ResHelper.getDataCacheFile((Context)object, (String)object2))).exists();
        if (bl2) {
            object2 = new FileInputStream((File)object);
            object = new DataInputStream((InputStream)object2);
            long l10 = ((DataInputStream)object).readLong();
            try {
                ((FilterInputStream)object).close();
                return l10;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                int n10 = 2;
                Object[] objectArray = new Object[n10];
                objectArray[0] = "DUClt";
                int n11 = 1;
                String string2 = throwable.getMessage();
                objectArray[n11] = string2;
                String string3 = "[%s] %s";
                ((NLog)object2).d(throwable, (Object)string3, objectArray);
            }
        }
        return 0L;
    }

    private HashMap j() {
        Object object = MobSDK.getContext();
        Object object2 = "comm/dbs/.dudcd";
        int n10 = (object = ResHelper.getDataCacheFile(object, (String)object2)).exists();
        if (n10 != 0) {
            int n11;
            object2 = new FileInputStream((File)object);
            object = ((FileInputStream)object2).getChannel();
            long l10 = object.size();
            n10 = (int)l10;
            object2 = ByteBuffer.allocate(n10);
            while (true) {
                n11 = object.read((ByteBuffer)object2);
                if (n11 > 0) continue;
                break;
            }
            object = ((ByteBuffer)object2).array();
            object2 = MobSDK.getContext();
            object2 = DeviceHelper.getInstance((Context)object2);
            object2 = ((DeviceHelper)object2).getModel();
            try {
                return this.a((String)object2, (byte[])object);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                n11 = 2;
                Object[] objectArray = new Object[n11];
                objectArray[0] = "DUClt";
                int n12 = 1;
                String string2 = throwable.getMessage();
                objectArray[n12] = string2;
                String string3 = "[%s] %s";
                ((NLog)object2).d(throwable, (Object)string3, objectArray);
            }
        }
        object = new HashMap();
        return object;
    }

    public File a() {
        return e.a("comm/locks/.du_lock");
    }

    public void a(Message message) {
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11) {
            long l10;
            long l11 = b.a();
            long l12 = l11 - (l10 = this.i());
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 >= 0) {
                this.h();
                l10 = b.U();
                long l13 = 1000L;
                this.a(l11 += (l10 *= l13));
                this.a(n11, l10);
            } else {
                this.a(n11, l10 -= l11);
            }
        }
    }

    public boolean b_() {
        long l10;
        long l11 = b.T();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void d() {
        int n10 = 1;
        this.a(n10);
        long l10 = b.T() * 1000L;
        this.a(n10, l10);
    }
}

