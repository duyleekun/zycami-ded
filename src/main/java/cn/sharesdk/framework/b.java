/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.a;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public class b {
    private static String a = "";
    private static volatile b b;
    private DeviceHelper c;
    private NetworkHelper d;
    private String e;

    private b() {
        Object object = DeviceHelper.getInstance(MobSDK.getContext());
        this.c = object;
        this.d = object = new NetworkHelper();
        this.e = object = MobSDK.checkRequestUrl("api.share.mob.com");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static b a() {
        Class<b> clazz = b.class;
        // MONITORENTER : clazz
        b b10 = b;
        if (b10 == null) {
            // MONITORENTER : clazz
            b10 = b;
            if (b10 == null) {
                b = b10 = new b();
            }
            // MONITOREXIT : clazz
        }
        // MONITOREXIT : clazz
        return b;
    }

    private String c() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.e;
        stringBuilder.append(string2);
        stringBuilder.append("/conf5");
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        String string2 = "error";
        try {
            ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
            String string3 = MobSDK.getAppkey();
            int n10 = TextUtils.isEmpty((CharSequence)string3);
            if (n10 != 0) {
                return;
            }
            Object object = "appkey";
            Object object2 = new KVPair((String)object, string3);
            arrayList.add((KVPair)object2);
            object = "device";
            Object object3 = this.c;
            object3 = ((DeviceHelper)object3).getDeviceKey();
            object2 = new KVPair((String)object, object3);
            arrayList.add((KVPair)object2);
            object = "plat";
            object3 = this.c;
            int n11 = ((DeviceHelper)object3).getPlatformCode();
            object3 = String.valueOf(n11);
            object2 = new KVPair((String)object, object3);
            arrayList.add((KVPair)object2);
            object = "apppkg";
            object3 = this.c;
            object3 = ((DeviceHelper)object3).getPackageName();
            object2 = new KVPair((String)object, object3);
            arrayList.add((KVPair)object2);
            object = "appver";
            object3 = this.c;
            n11 = ((DeviceHelper)object3).getAppVersion();
            object3 = String.valueOf(n11);
            object2 = new KVPair((String)object, object3);
            arrayList.add((KVPair)object2);
            object = "sdkver";
            n11 = ShareSDK.SDK_VERSION_CODE;
            object3 = String.valueOf(n11);
            object2 = new KVPair((String)object, object3);
            arrayList.add((KVPair)object2);
            object = "networktype";
            object3 = this.c;
            object3 = ((DeviceHelper)object3).getDetailNetworkTypeForStatic();
            object2 = new KVPair((String)object, object3);
            arrayList.add((KVPair)object2);
            ArrayList<KVPair> arrayList2 = new ArrayList<KVPair>();
            object = "User-Identity";
            object3 = cn.sharesdk.framework.a.a.a();
            object2 = new KVPair((String)object, object3);
            arrayList2.add((KVPair)object2);
            NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
            networkHelper$NetworkTimeOut.readTimout = n10 = 10000;
            networkHelper$NetworkTimeOut.connectionTimeout = n10;
            object2 = this.d;
            object = this.c();
            n11 = 0;
            object3 = null;
            object2 = ((NetworkHelper)object2).httpPost((String)object, arrayList, null, arrayList2, networkHelper$NetworkTimeOut);
            object = new Hashon();
            object2 = ((Hashon)object).fromJson((String)object2);
            boolean bl2 = ((HashMap)object2).containsKey(string2);
            if (bl2) {
                string2 = ((HashMap)object2).get(string2);
                boolean bl3 = (string2 = String.valueOf(string2)).contains((CharSequence)(object2 = "'appkey' is illegal"));
                if (!bl3) return;
                cn.sharesdk.framework.a.a = bl3 = true;
                return;
            }
            cn.sharesdk.framework.a.b = string3;
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string4 = "updateServerConfig ";
            objectArray.append(string4);
            objectArray.append(throwable);
            String string5 = objectArray.toString();
            boolean bl4 = false;
            objectArray = new Object[]{};
            nLog.d(string5, objectArray);
        }
    }
}

