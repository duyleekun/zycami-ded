/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.Service;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public abstract class Service$ServiceEvent {
    private static final int PLATFORM = 1;
    public Service service;

    public Service$ServiceEvent(Service service) {
        this.service = service;
    }

    public HashMap filterShareContent(int n10, Platform$ShareParams hashMap, HashMap objectArray) {
        Object object = ShareSDK.platformIdToName(n10);
        try {
            object = ShareSDK.getPlatform((String)object);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray2 = new StringBuilder();
            String string2 = "ShareSDK Service filterShareContent catch: ";
            objectArray2.append(string2);
            objectArray2.append(throwable);
            object = objectArray2.toString();
            objectArray2 = new Object[]{};
            nLog.d(object, objectArray2);
            n10 = 0;
            object = null;
        }
        if (object == null) {
            return null;
        }
        object = ((Platform)object).filterShareContent((Platform$ShareParams)((Object)hashMap), (HashMap)objectArray);
        hashMap = new HashMap<String, Object[]>();
        objectArray = ((f$a)object).a;
        hashMap.put("shareID", objectArray);
        objectArray = new Hashon();
        object = ((f$a)object).toString();
        object = objectArray.fromJson((String)object);
        hashMap.put("shareContent", (Object[])object);
        object = SSDKLog.b();
        objectArray = new Object[]{hashMap};
        ((NLog)object).i("filterShareContent ==>>%s", objectArray);
        return hashMap;
    }

    public HashMap toMap() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object = DeviceHelper.getInstance(MobSDK.getContext());
        Object object2 = ((DeviceHelper)object).getDeviceKey();
        hashMap.put("deviceid", object2);
        object2 = MobSDK.getAppkey();
        hashMap.put("appkey", object2);
        object2 = ((DeviceHelper)object).getPackageName();
        hashMap.put("apppkg", object2);
        object2 = ((DeviceHelper)object).getAppVersion();
        hashMap.put("appver", object2);
        object2 = this.service.getServiceVersionInt();
        hashMap.put("sdkver", object2);
        object2 = 1;
        hashMap.put("plat", object2);
        object2 = ((DeviceHelper)object).getDetailNetworkTypeForStatic();
        hashMap.put("networktype", object2);
        object = ((DeviceHelper)object).getDeviceDataNotAES();
        hashMap.put("deviceData", object);
        return hashMap;
    }

    public final String toString() {
        Hashon hashon = new Hashon();
        HashMap hashMap = this.toMap();
        return hashon.fromHashMap(hashMap);
    }
}

