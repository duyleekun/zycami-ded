/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 */
package cn.sharesdk.framework.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.a;
import cn.sharesdk.framework.b;
import cn.sharesdk.framework.b.a.d;
import cn.sharesdk.framework.b.a.e;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class c {
    private static MobCommunicator i;
    private e a;
    private DeviceHelper b;
    private NetworkHelper c;
    private Hashon d;
    private String e;
    private String f;
    private boolean g;
    private HashMap h;

    public c() {
        Object object = cn.sharesdk.framework.b.a.e.a();
        this.a = object;
        this.b = object = DeviceHelper.getInstance(MobSDK.getContext());
        this.c = object = new NetworkHelper();
        this.d = object = new Hashon();
        object = this.a;
        String string2 = "buffered_server_paths";
        object = ((e)object).j(string2);
        object = (HashMap)object;
        try {
            this.h = object;
        }
        catch (Throwable throwable) {
            object = new HashMap();
            this.h = object;
        }
        this.h();
    }

    private String e(String string2) {
        Object object = this.a;
        boolean n10 = ((e)object).c();
        Object object2 = this.a;
        boolean bl2 = ((e)object2).d();
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objectArray = this.b.getPackageName();
        Object[] objectArray2 = "utf-8";
        objectArray = Data.urlEncode((String)objectArray, (String)objectArray2);
        stringBuilder.append((String)objectArray);
        objectArray = "|";
        stringBuilder.append((String)objectArray);
        String string3 = Data.urlEncode(this.b.getAppVersionName(), (String)objectArray2);
        stringBuilder.append(string3);
        stringBuilder.append((String)objectArray);
        string3 = Data.urlEncode(String.valueOf(ShareSDK.SDK_VERSION_CODE), (String)objectArray2);
        stringBuilder.append(string3);
        stringBuilder.append((String)objectArray);
        int n11 = this.b.getPlatformCode();
        string3 = Data.urlEncode(String.valueOf(n11), (String)objectArray2);
        stringBuilder.append(string3);
        stringBuilder.append((String)objectArray);
        string3 = Data.urlEncode(this.b.getDetailNetworkTypeForStatic(), (String)objectArray2);
        stringBuilder.append(string3);
        stringBuilder.append((String)objectArray);
        string3 = "|||||";
        if (n10) {
            int n12 = this.b.getOSVersionInt();
            object = Data.urlEncode(String.valueOf(n12), (String)objectArray2);
            stringBuilder.append((String)object);
            stringBuilder.append((String)objectArray);
            object = Data.urlEncode(this.b.getScreenSize(), (String)objectArray2);
            stringBuilder.append((String)object);
            stringBuilder.append((String)objectArray);
            object = Data.urlEncode(this.b.getManufacturer(), (String)objectArray2);
            stringBuilder.append((String)object);
            stringBuilder.append((String)objectArray);
            object = Data.urlEncode(this.b.getModel(), (String)objectArray2);
            stringBuilder.append((String)object);
            stringBuilder.append((String)objectArray);
            object = Data.urlEncode(this.b.getCarrier(), (String)objectArray2);
            stringBuilder.append((String)object);
            stringBuilder.append((String)objectArray);
        } else {
            stringBuilder.append(string3);
        }
        boolean bl3 = false;
        object = null;
        if (bl2) {
            stringBuilder.append(string2);
        } else {
            object2 = "\\|";
            string2 = string2.split((String)object2)[0];
            stringBuilder.append(string2);
            stringBuilder.append(string3);
        }
        string2 = stringBuilder.toString();
        object2 = SSDKLog.b();
        int n13 = 1;
        objectArray = new Object[n13];
        objectArray[0] = string2;
        ((NLog)object2).i("shorLinkMsg ===>>>>", objectArray);
        object2 = this.b.getDeviceKey();
        int n14 = 2;
        objectArray2 = new Object[n14];
        objectArray2[0] = object2;
        objectArray2[n13] = object = MobSDK.getAppkey();
        return Base64.encodeToString((byte[])Data.AES128Encode(Data.rawMD5(String.format("%s:%s", objectArray2)), string2), (int)n14);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static MobCommunicator g() {
        Class<c> clazz = c.class;
        synchronized (clazz) {
            MobCommunicator mobCommunicator = i;
            if (mobCommunicator != null) return i;
            int n10 = 1024;
            String string2 = "bb7addd7e33383b74e82aba9b1d274c73aea6c0c71fcc88730270f630dbe490e1d162004f74e9532f98e17004630fbea9b346de63c23e83a7dfad70dd47cebfd";
            String string3 = "288e7c44e01569a905386e6341baabfcde63ec37d0f0835cc662c299a5d0072970808a7fa434f0a51fa581d09d5ec4350ba5d548eafbe1fd956fb3afd678c1fb6134c904668652ec5cceb5d85da337a0f2f13ea457cca74a01b3ba0f4c809ad30d382bba2562ec9b996ae44c3700731c1b914997ef826331759e4084a019a03f";
            i = mobCommunicator = new MobCommunicator(n10, string2, string3);
            return i;
        }
    }

    private void h() {
        Object object = "api.share.mob.com";
        CharSequence charSequence = new StringBuilder();
        CharSequence charSequence2 = this.b.getPackageName();
        charSequence.append((String)charSequence2);
        charSequence.append("/");
        charSequence2 = this.b.getAppVersionName();
        charSequence.append((String)charSequence2);
        charSequence = charSequence.toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("Android/");
        int n10 = this.b.getOSVersionInt();
        ((StringBuilder)charSequence2).append(n10);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        CharSequence charSequence3 = new StringBuilder();
        charSequence3.append((String)charSequence);
        charSequence = " ";
        charSequence3.append((String)charSequence);
        String string2 = "ShareSDK/3.8.4";
        charSequence3.append(string2);
        charSequence3.append((String)charSequence);
        charSequence3.append((String)charSequence2);
        charSequence = charSequence3.toString();
        this.e = charSequence;
        charSequence = MobSDK.dynamicModifyUrl((String)object);
        try {
            this.f = charSequence;
        }
        catch (Throwable throwable) {
            object = MobSDK.checkRequestUrl((String)object);
            this.f = object;
            object = SSDKLog.b();
            charSequence2 = new StringBuilder();
            charSequence3 = "001 dynamicModifyUrl catch, no problem ";
            ((StringBuilder)charSequence2).append((String)charSequence3);
            ((StringBuilder)charSequence2).append(throwable);
            String string3 = ((StringBuilder)charSequence2).toString();
            charSequence2 = new Object[]{};
            ((NLog)object).d(string3, (Object[])charSequence2);
        }
        this.g = true;
    }

    private String i() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.f;
        stringBuilder.append(string2);
        stringBuilder.append("/conn");
        return stringBuilder.toString();
    }

    private String j() {
        boolean bl2;
        Serializable serializable = this.h;
        String string2 = "/date";
        if (serializable != null && (bl2 = ((HashMap)serializable).containsKey(string2))) {
            serializable = new StringBuilder();
            String string3 = (String)this.h.get(string2);
            ((StringBuilder)serializable).append(string3);
            ((StringBuilder)serializable).append(string2);
            return ((StringBuilder)serializable).toString();
        }
        serializable = new StringBuilder();
        String string4 = this.f;
        ((StringBuilder)serializable).append(string4);
        ((StringBuilder)serializable).append(string2);
        return ((StringBuilder)serializable).toString();
    }

    private String k() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.f;
        stringBuilder.append(string2);
        stringBuilder.append("/conf5");
        return stringBuilder.toString();
    }

    private String l() {
        String string2 = "up.mob.com/upload/image";
        try {
            return MobSDK.dynamicModifyUrl(string2);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            objectArray.append("002 dynamicModifyUrl catch, no problem ");
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            nLog.d(string3, objectArray);
            return MobSDK.checkRequestUrl(string2);
        }
    }

    private String m() {
        boolean bl2;
        Serializable serializable = this.h;
        String string2 = "/log4";
        if (serializable != null && (bl2 = ((HashMap)serializable).containsKey(string2))) {
            serializable = new StringBuilder();
            String string3 = (String)this.h.get(string2);
            ((StringBuilder)serializable).append(string3);
            ((StringBuilder)serializable).append(string2);
            return ((StringBuilder)serializable).toString();
        }
        serializable = new StringBuilder();
        String string4 = this.f;
        ((StringBuilder)serializable).append(string4);
        ((StringBuilder)serializable).append(string2);
        return ((StringBuilder)serializable).toString();
    }

    private String n() {
        String string2 = "l.mob.com/url/shareSdkEncryptMapping.do";
        try {
            return MobSDK.dynamicModifyUrl(string2);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            objectArray.append("003 dynamicModifyUrl catch, no problem ");
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            nLog.d(string3, objectArray);
            return MobSDK.checkRequestUrl(string2);
        }
    }

    private String o() {
        boolean bl2;
        Serializable serializable = this.h;
        String string2 = "/snsconf";
        if (serializable != null && (bl2 = ((HashMap)serializable).containsKey(string2))) {
            serializable = new StringBuilder();
            String string3 = (String)this.h.get(string2);
            ((StringBuilder)serializable).append(string3);
            ((StringBuilder)serializable).append(string2);
            return ((StringBuilder)serializable).toString();
        }
        serializable = new StringBuilder();
        String string4 = this.f;
        ((StringBuilder)serializable).append(string4);
        ((StringBuilder)serializable).append(string2);
        return ((StringBuilder)serializable).toString();
    }

    public HashMap a() {
        int n10;
        Object[] objectArray = new ArrayList();
        Object object = MobSDK.getAppkey();
        Object object2 = new KVPair("appkey", object);
        objectArray.add(object2);
        ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
        object = cn.sharesdk.framework.a.a.a();
        object2 = new KVPair("User-Identity", object);
        arrayList.add((KVPair)object2);
        NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
        networkHelper$NetworkTimeOut.readTimout = n10 = 30000;
        networkHelper$NetworkTimeOut.connectionTimeout = n10;
        object2 = this.c;
        object = this.i();
        object2 = ((NetworkHelper)object2).httpPost((String)object, (ArrayList)objectArray, null, arrayList, networkHelper$NetworkTimeOut);
        object = SSDKLog.b();
        objectArray = new Object[]{object2};
        ((NLog)object).i(" isConnectToServer response == %s", objectArray);
        return this.d.fromJson((String)object2);
    }

    public HashMap a(String hashMap, ArrayList object, int n10, String string2) {
        int n11;
        Object object2;
        String string3;
        String string4;
        boolean bl2 = this.g;
        if (!bl2) {
            return null;
        }
        hashMap = new ArrayList();
        ArrayList<String> arrayList = MobSDK.getAppkey();
        String string5 = "key";
        KVPair kVPair = new KVPair(string5, arrayList);
        ((ArrayList)((Object)hashMap)).add(kVPair);
        kVPair = null;
        int n12 = 0;
        arrayList = null;
        while (true) {
            int n13 = ((ArrayList)object).size();
            string4 = "urls";
            if (n12 >= n13) break;
            string3 = ((String)((ArrayList)object).get(n12)).toString();
            object2 = new KVPair(string4, string3);
            ((ArrayList)((Object)hashMap)).add(object2);
            ++n12;
        }
        object2 = this.b.getDeviceKey();
        string3 = "deviceid";
        arrayList = new ArrayList<String>(string3, object2);
        ((ArrayList)((Object)hashMap)).add(arrayList);
        object2 = String.valueOf(n10);
        String string6 = "snsplat";
        arrayList = new ArrayList<String>(string6, object2);
        ((ArrayList)((Object)hashMap)).add(arrayList);
        string2 = this.e(string2);
        n12 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n12 != 0) {
            return null;
        }
        object2 = "m";
        arrayList = new ArrayList<String>((String)object2, (Object)string2);
        ((ArrayList)((Object)hashMap)).add(arrayList);
        hashMap = new ArrayList();
        String string7 = cn.sharesdk.framework.a.a.a();
        String string8 = "User-Identity";
        arrayList = new ArrayList<String>(string8, (Object)string7);
        ((ArrayList)((Object)hashMap)).add(arrayList);
        hashMap = new NetworkHelper$NetworkTimeOut();
        ((NetworkHelper$NetworkTimeOut)hashMap).readTimout = n12 = 5000;
        ((NetworkHelper$NetworkTimeOut)hashMap).connectionTimeout = n12;
        hashMap = new HashMap();
        arrayList = MobSDK.getAppkey();
        hashMap.put(string5, arrayList);
        arrayList = new ArrayList<String>();
        string5 = null;
        for (int i10 = 0; i10 < (n11 = ((ArrayList)object).size()); ++i10) {
            string7 = (String)((ArrayList)object).get(i10);
            string8 = "UTF-8";
            string7 = URLEncoder.encode(string7, string8);
            arrayList.add(string7);
        }
        hashMap.put(string4, arrayList);
        object = this.b.getDeviceKey();
        hashMap.put(string3, object);
        object = n10;
        hashMap.put(string6, object);
        int n14 = TextUtils.isEmpty((CharSequence)string2);
        if (n14 != 0) {
            return null;
        }
        hashMap.put(object2, string2);
        object = cn.sharesdk.framework.b.c.g();
        Object[] objectArray = this.n();
        hashMap = (HashMap)((MobCommunicator)object).requestSynchronized(hashMap, (String)objectArray, false);
        object = SSDKLog.b();
        n10 = 1;
        objectArray = new Object[n10];
        objectArray[0] = hashMap;
        string2 = "> SERVER_SHORT_LINK_URL  resp: %s";
        ((NLog)object).i(string2, objectArray);
        n14 = hashMap.size();
        if (n14 == 0) {
            this.g = false;
            return null;
        }
        object = hashMap.get("data");
        if (object == null) {
            return null;
        }
        return hashMap;
    }

    public void a(cn.sharesdk.framework.b.b.c c10) {
        String string2 = c10.toString();
        long l10 = c10.e;
        cn.sharesdk.framework.b.a.d.a(string2, l10);
    }

    public void a(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            Object object = SSDKLog.b();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("duid === ");
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Object[] objectArray = new Object[]{};
            ((NLog)object).d(charSequence, objectArray);
            object = new StringBuilder();
            charSequence = this.e;
            ((StringBuilder)object).append((String)charSequence);
            charSequence = " ";
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(string2);
            this.e = string2 = ((StringBuilder)object).toString();
        }
    }

    public void a(ArrayList arrayList) {
        cn.sharesdk.framework.b.a.d.a(arrayList);
    }

    public void a(HashMap hashMap) {
        this.h = hashMap;
        this.a.a("buffered_server_paths", hashMap);
    }

    public boolean a(String object, boolean n10) {
        block32: {
            boolean bl2;
            block33: {
                boolean bl3;
                block31: {
                    try {
                        bl3 = MobSDK.isMob();
                        bl2 = true;
                        if (bl3) break block31;
                        return bl2;
                    }
                    catch (Throwable throwable) {
                        SSDKLog.b().d(throwable);
                        return false;
                    }
                }
                Object object2 = this.b;
                object2 = ((DeviceHelper)object2).getDetailNetworkTypeForStatic();
                Object[] objectArray = "none";
                bl3 = objectArray.equals(object2);
                if (bl3) break block32;
                ArrayList<Object> arrayList = new ArrayList<Object>();
                objectArray = "m";
                object2 = new KVPair((String)objectArray, object);
                arrayList.add(object2);
                object2 = "t";
                Object object3 = n10 != 0 ? "1" : "0";
                object = new KVPair((String)object2, object3);
                arrayList.add(object);
                ArrayList<Object> arrayList2 = new ArrayList<Object>();
                object3 = "User-Identity";
                object2 = cn.sharesdk.framework.a.a.a();
                object = new KVPair((String)object3, object2);
                arrayList2.add(object);
                NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
                int n11 = 30000;
                networkHelper$NetworkTimeOut.readTimout = n11;
                networkHelper$NetworkTimeOut.connectionTimeout = n11;
                objectArray = this.c;
                String string2 = this.m();
                object = objectArray.httpPost(string2, arrayList, null, arrayList2, networkHelper$NetworkTimeOut);
                object3 = SSDKLog.b();
                object2 = "> Upload All Log  resp: %s";
                objectArray = new Object[bl2];
                objectArray[0] = object;
                ((NLog)object3).i(object2, objectArray);
                n10 = TextUtils.isEmpty((CharSequence)object);
                if (n10 != 0) break block33;
                object3 = this.d;
                object = ((Hashon)object3).fromJson((String)object);
                object3 = "status";
                object = ((HashMap)object).get(object3);
                object = (Integer)object;
                n11 = (Integer)object;
                n10 = 200;
                if (n11 == n10) break block33;
                return false;
            }
            return bl2;
        }
        String string3 = "network is disconnected!";
        object = new IllegalStateException(string3);
        throw object;
    }

    public long b() {
        long l10;
        Object object = this.a;
        boolean bl2 = ((e)object).k();
        if (!bl2) {
            return 0L;
        }
        object = this.c;
        Object object2 = this.j();
        boolean bl3 = false;
        try {
            object = ((NetworkHelper)object).httpGet((String)object2, null, null, null);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
            object = "{}";
        }
        object = this.d.fromJson((String)object);
        object2 = "timestamp";
        bl3 = ((HashMap)object).containsKey(object2);
        if (bl3) {
            object = ((HashMap)object).get(object2);
            object = String.valueOf(object);
            long l11 = ResHelper.parseLong((String)object);
            l10 = System.currentTimeMillis() - l11;
            object = this.a;
            object2 = "service_time";
            Long l12 = l10;
            try {
                ((e)object).a((String)object2, l12);
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).d(throwable);
                e e10 = this.a;
                l10 = e10.b();
            }
        } else {
            object = this.a;
            l10 = ((e)object).b();
        }
        return l10;
    }

    public void b(String string2) {
        this.f = string2;
    }

    public void b(HashMap object) {
        object = this.d.fromHashMap((HashMap)object);
        this.a.g((String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap c() {
        int n10;
        Object object;
        Object[] objectArray;
        Object object2;
        block7: {
            int n11;
            object2 = "error";
            objectArray = MobSDK.getAppkey();
            Object object3 = new ArrayList();
            object = new KVPair("appkey", objectArray);
            ((ArrayList)object3).add(object);
            String string2 = this.b.getDeviceKey();
            object = new KVPair("device", string2);
            ((ArrayList)object3).add(object);
            string2 = String.valueOf(this.b.getPlatformCode());
            object = new KVPair("plat", string2);
            ((ArrayList)object3).add(object);
            string2 = this.b.getPackageName();
            object = new KVPair("apppkg", string2);
            ((ArrayList)object3).add(object);
            string2 = String.valueOf(this.b.getAppVersion());
            object = new KVPair("appver", string2);
            ((ArrayList)object3).add(object);
            string2 = String.valueOf(ShareSDK.SDK_VERSION_CODE);
            object = new KVPair("sdkver", string2);
            ((ArrayList)object3).add(object);
            string2 = this.b.getDetailNetworkTypeForStatic();
            object = new KVPair("networktype", string2);
            ((ArrayList)object3).add(object);
            ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
            string2 = cn.sharesdk.framework.a.a.a();
            object = new KVPair("User-Identity", string2);
            arrayList.add((KVPair)object);
            NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
            networkHelper$NetworkTimeOut.readTimout = n11 = 10000;
            networkHelper$NetworkTimeOut.connectionTimeout = n11;
            object = this.c;
            string2 = this.k();
            boolean bl2 = false;
            object = ((NetworkHelper)object).httpPost(string2, (ArrayList)object3, null, arrayList, networkHelper$NetworkTimeOut);
            n10 = 1;
            try {
                object3 = new Hashon();
                object3 = ((Hashon)object3).fromJson((String)object);
                bl2 = ((HashMap)object3).containsKey(object2);
                if (bl2) {
                    object2 = ((HashMap)object3).get(object2);
                    boolean bl3 = ((String)(object2 = String.valueOf(object2))).contains((CharSequence)(object3 = "'appkey' is illegal"));
                    if (bl3) {
                        bl3 = TextUtils.isEmpty((CharSequence)objectArray);
                        if (bl3) {
                            object2 = cn.sharesdk.framework.b.a();
                            ((b)object2).b();
                            break block7;
                        } else {
                            cn.sharesdk.framework.a.a = n10;
                        }
                    }
                    break block7;
                }
                boolean bl4 = TextUtils.isEmpty((CharSequence)objectArray);
                if (!bl4) {
                    cn.sharesdk.framework.a.b = objectArray;
                }
            }
            catch (Throwable throwable) {
                objectArray = SSDKLog.b();
                objectArray.d(throwable);
            }
        }
        object2 = SSDKLog.b();
        objectArray = new Object[n10];
        objectArray[0] = object;
        ((NLog)object2).i(" get server config response == %s", objectArray);
        return this.d.fromJson((String)object);
    }

    public HashMap c(String object) {
        KVPair kVPair = new KVPair("file", object);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = cn.sharesdk.framework.a.a.a();
        object = new KVPair("User-Identity", object2);
        arrayList.add(object);
        object2 = this.c;
        Object[] objectArray = this.l();
        object = ((NetworkHelper)object2).httpPost((String)objectArray, null, kVPair, arrayList, null);
        object2 = SSDKLog.b();
        objectArray = new Object[]{object};
        ((NLog)object2).i("upload file response == %s", objectArray);
        return this.d.fromJson((String)object);
    }

    public HashMap d() {
        int n10;
        ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
        String string2 = MobSDK.getAppkey();
        Object object = new KVPair("appkey", string2);
        arrayList.add((KVPair)object);
        string2 = this.b.getDeviceKey();
        object = new KVPair("device", string2);
        arrayList.add((KVPair)object);
        ArrayList<KVPair> arrayList2 = new ArrayList<KVPair>();
        string2 = cn.sharesdk.framework.a.a.a();
        object = new KVPair("User-Identity", string2);
        arrayList2.add((KVPair)object);
        NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
        networkHelper$NetworkTimeOut.readTimout = n10 = 10000;
        networkHelper$NetworkTimeOut.connectionTimeout = n10;
        object = this.c;
        string2 = this.o();
        object = ((NetworkHelper)object).httpPost(string2, arrayList, null, arrayList2, networkHelper$NetworkTimeOut);
        return this.d.fromJson((String)object);
    }

    public HashMap d(String object) {
        object = Base64.decode((String)object, (int)2);
        String string2 = this.b.getDeviceKey();
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = MobSDK.getAppkey();
        stringBuilder.append(string3);
        stringBuilder.append(":");
        stringBuilder.append(string2);
        object = Data.AES128Decode(Data.rawMD5(stringBuilder.toString()), (byte[])object);
        string2 = new String((byte[])object, "UTF-8");
        object = string2.trim();
        return this.d.fromJson((String)object);
    }

    public ArrayList e() {
        ArrayList arrayList = cn.sharesdk.framework.b.a.d.a();
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public HashMap f() {
        String string2 = this.a.i();
        return this.d.fromJson(string2);
    }
}

