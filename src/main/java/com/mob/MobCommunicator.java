/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.mob;

import android.util.Base64;
import com.mob.MobCommunicator$1;
import com.mob.MobCommunicator$2;
import com.mob.MobCommunicator$3;
import com.mob.MobCommunicator$Callback;
import com.mob.MobCommunicator$NetworkError;
import com.mob.MobSDK;
import com.mob.commons.MobProductCollector;
import com.mob.commons.b.d;
import com.mob.commons.k;
import com.mob.tools.MobLog;
import com.mob.tools.RxMob;
import com.mob.tools.RxMob$Subscribable;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.log.NLog;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.network.StringPart;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

public final class MobCommunicator
implements PublicMemberKeeper {
    private Random a;
    private BigInteger b;
    private BigInteger c;
    private MobRSA d;
    private Hashon e;
    private NetworkHelper f;
    private NetworkHelper$NetworkTimeOut g;

    public MobCommunicator(int n10, String string2, String string3) {
        Object object = new Random();
        this.a = object;
        this.d = object = new MobRSA(n10);
        int n11 = 16;
        Object object2 = new BigInteger(string2, n11);
        this.b = object2;
        object2 = new BigInteger(string3, n11);
        this.c = object2;
        this.e = object2 = new Hashon();
        this.f = object2 = new NetworkHelper();
        this.g = object2 = new NetworkHelper$NetworkTimeOut();
        ((NetworkHelper$NetworkTimeOut)object2).readTimout = 30000;
        ((NetworkHelper$NetworkTimeOut)object2).connectionTimeout = 5000;
    }

    public static /* synthetic */ long a(MobCommunicator mobCommunicator, HttpConnection httpConnection) {
        return mobCommunicator.a(httpConnection);
    }

    private long a(HttpConnection object) {
        long l10;
        int n10;
        String string2 = "Content-Length";
        if ((object = this.a((HttpConnection)object, string2)) != null && (n10 = object.size()) > 0) {
            n10 = 0;
            string2 = null;
            object = (String)object.get(0);
            l10 = Long.parseLong((String)object);
        } else {
            l10 = -1;
        }
        return l10;
    }

    private HttpResponseCallback a(byte[] byArray, String[] stringArray) {
        MobCommunicator$3 mobCommunicator$3 = new MobCommunicator$3(this, stringArray, byArray);
        return mobCommunicator$3;
    }

    public static /* synthetic */ Hashon a(MobCommunicator mobCommunicator) {
        return mobCommunicator.e;
    }

    private Object a(String object) {
        Object object2 = "response is empty";
        String string2 = "error";
        int n10 = -1;
        Integer n11 = n10;
        String string3 = "status";
        if (object != null) {
            Hashon hashon = this.e;
            object = ((String)object).trim();
            boolean bl2 = ((HashMap)(object = hashon.fromJson((String)object))).isEmpty();
            if (!bl2) {
                object2 = ((HashMap)object).get("res");
                if (object2 == null) {
                    object2 = ((HashMap)object).get("data");
                }
                return object2;
            }
            object = new HashMap();
            ((HashMap)object).put(string3, n11);
            ((HashMap)object).put(string2, object2);
            object = this.e.fromHashMap((HashMap)object);
            object2 = new MobCommunicator$NetworkError((String)object);
            throw object2;
        }
        object = new HashMap();
        ((HashMap)object).put(string3, n11);
        ((HashMap)object).put(string2, object2);
        object = this.e.fromHashMap((HashMap)object);
        object2 = new MobCommunicator$NetworkError((String)object);
        throw object2;
    }

    public static /* synthetic */ String a(MobCommunicator mobCommunicator, byte[] byArray, byte[] byArray2) {
        return mobCommunicator.a(byArray, byArray2);
    }

    private String a(byte[] byArray, String object, boolean bl2) {
        Object object2 = "utf-8";
        object = ((String)object).getBytes((String)object2);
        if (bl2) {
            object = this.a((byte[])object);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        object2 = new DataOutputStream(byteArrayOutputStream);
        Object object3 = this.d;
        BigInteger bigInteger = this.b;
        BigInteger bigInteger2 = this.c;
        object3 = ((MobRSA)object3).encode(byArray, bigInteger, bigInteger2);
        int n10 = ((Object)object3).length;
        ((DataOutputStream)object2).writeInt(n10);
        ((FilterOutputStream)object2).write((byte[])object3);
        byArray = Data.AES128Encode(byArray, (byte[])object);
        int n11 = byArray.length;
        ((DataOutputStream)object2).writeInt(n11);
        ((FilterOutputStream)object2).write(byArray);
        ((DataOutputStream)object2).flush();
        ((FilterOutputStream)object2).close();
        return Base64.encodeToString((byte[])byteArrayOutputStream.toByteArray(), (int)2);
    }

    private String a(byte[] byArray, byte[] object) {
        object = Base64.decode((byte[])object, (int)2);
        byArray = Data.AES128Decode(byArray, object);
        object = new String;
        object(byArray, "utf-8");
        return object;
    }

    private ArrayList a(String object, int n10) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        object = MobSDK.getAppSecret();
        stringBuilder.append((String)object);
        object = Data.MD5(stringBuilder.toString());
        Object object2 = new KVPair("sign", object);
        arrayList.add(object2);
        object2 = MobSDK.getAppkey();
        object = new KVPair("key", object2);
        arrayList.add(object);
        String string2 = String.valueOf(n10);
        object = new KVPair("Content-Length", string2);
        arrayList.add(object);
        string2 = MobProductCollector.getUserIdentity();
        object = new KVPair("User-Identity", string2);
        arrayList.add(object);
        string2 = k.a(68);
        object2 = com.mob.commons.b.d.d(MobSDK.getContext());
        object = new KVPair(string2, object2);
        arrayList.add(object);
        return arrayList;
    }

    private ArrayList a(boolean bl2, HashMap object, String object2, int n10) {
        boolean bl3;
        ArrayList<KVPair> arrayList;
        if (bl2) {
            arrayList = this.a((String)object2, n10);
        } else {
            bl2 = false;
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<KVPair>();
        }
        if (object != null && !(bl3 = ((HashMap)object).isEmpty())) {
            object = ((HashMap)object).entrySet().iterator();
            while (bl3 = object.hasNext()) {
                object2 = (Map.Entry)object.next();
                if (object2 == null) continue;
                String string2 = (String)object2.getKey();
                object2 = object2.getValue();
                KVPair kVPair = new KVPair(string2, object2);
                arrayList.add(kVPair);
            }
        }
        return arrayList;
    }

    private List a(HttpConnection object, String string2) {
        boolean bl2;
        if ((object = object.getHeaderFields()) != null && !(bl2 = object.isEmpty())) {
            boolean bl3;
            Iterator iterator2 = object.keySet().iterator();
            while (bl3 = iterator2.hasNext()) {
                boolean bl4;
                String string3 = (String)iterator2.next();
                if (string3 == null || !(bl4 = string3.equals(string2))) continue;
                return (List)object.get(string3);
            }
        }
        return null;
    }

    private byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Random random = this.a;
        long l10 = System.currentTimeMillis();
        random.setSeed(l10);
        long l11 = this.a.nextLong();
        dataOutputStream.writeLong(l11);
        l11 = this.a.nextLong();
        dataOutputStream.writeLong(l11);
        dataOutputStream.flush();
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] a(byte[] byArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(gZIPOutputStream);
        bufferedOutputStream.write(byArray);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public void request(HashMap hashMap, String string2, boolean bl2, MobCommunicator$Callback mobCommunicator$Callback) {
        this.request(true, null, hashMap, string2, bl2, mobCommunicator$Callback);
    }

    public void request(HashMap hashMap, HashMap hashMap2, String string2, boolean bl2, MobCommunicator$Callback mobCommunicator$Callback) {
        this.request(true, hashMap, hashMap2, string2, bl2, mobCommunicator$Callback);
    }

    public void request(boolean bl2, HashMap object, HashMap hashMap, String string2, boolean bl3, MobCommunicator$Callback mobCommunicator$Callback) {
        MobCommunicator$1 mobCommunicator$1 = new MobCommunicator$1(this, bl2, (HashMap)object, hashMap, string2, bl3);
        RxMob$Subscribable rxMob$Subscribable = RxMob.create(mobCommunicator$1);
        object = new MobCommunicator$2(this, mobCommunicator$Callback);
        rxMob$Subscribable.subscribeOnNewThreadAndObserveOnUIThread((RxMob$Subscriber)object);
    }

    public Object requestSynchronized(String string2, String string3, boolean bl2) {
        return this.requestSynchronized(null, string2, string3, bl2);
    }

    public Object requestSynchronized(HashMap hashMap, String string2, String string3, boolean bl2) {
        return this.requestSynchronized(true, hashMap, string2, string3, bl2);
    }

    public Object requestSynchronized(HashMap hashMap, String string2, boolean bl2) {
        return this.requestSynchronized(null, hashMap, string2, bl2);
    }

    public Object requestSynchronized(HashMap hashMap, HashMap hashMap2, String string2, boolean bl2) {
        return this.requestSynchronized(true, hashMap, hashMap2, string2, bl2);
    }

    public Object requestSynchronized(boolean bl2, HashMap object, String charSequence, String objectArray, boolean bl3) {
        Object[] objectArray2 = this.a();
        CharSequence charSequence2 = this.a((byte[])objectArray2, (String)charSequence, bl3);
        byte[] byArray = ((String)charSequence2).getBytes("utf-8");
        int n10 = byArray.length;
        ArrayList arrayList = this.a(bl2, (HashMap)object, (String)charSequence, n10);
        bl2 = true;
        Object object2 = new String[bl2];
        HttpResponseCallback httpResponseCallback = this.a((byte[])objectArray2, (String[])object2);
        StringPart stringPart = new StringPart();
        stringPart.append((String)charSequence2);
        object = MobLog.getInstance();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append(">>>  request: ");
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append("\nurl = ");
        ((StringBuilder)charSequence2).append((String)objectArray);
        ((StringBuilder)charSequence2).append("\nheader = ");
        charSequence = arrayList.toString();
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        bl3 = false;
        charSequence2 = null;
        objectArray2 = new Object[0];
        ((NLog)object).d(charSequence, objectArray2);
        NetworkHelper networkHelper = this.f;
        NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = this.g;
        int n11 = -1;
        networkHelper.rawPost((String)objectArray, arrayList, stringPart, n11, httpResponseCallback, networkHelper$NetworkTimeOut);
        object = object2[0];
        if (object != null) {
            object = MobLog.getInstance();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(">>> response: ");
            objectArray = object2[0];
            ((StringBuilder)charSequence).append((String)objectArray);
            charSequence = ((StringBuilder)charSequence).toString();
            objectArray = new Object[]{};
            ((NLog)object).d(charSequence, objectArray);
            object2 = object2[0];
            return this.a((String)object2);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Object requestSynchronized(boolean bl2, HashMap hashMap, HashMap object, String string2, boolean bl3) {
        Object object2;
        Hashon hashon;
        int n10;
        String string3 = "{}";
        if (object != null && (n10 = ((String)(object = (hashon = this.e).fromHashMap((HashMap)object))).length()) != 0) {
            object2 = object;
            return this.requestSynchronized(bl2, hashMap, (String)object2, string2, bl3);
        }
        object2 = string3;
        return this.requestSynchronized(bl2, hashMap, (String)object2, string2, bl3);
    }
}

