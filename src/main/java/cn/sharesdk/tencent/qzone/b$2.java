/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.tencent.qzone;

import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qzone.b;
import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscriber;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import java.util.ArrayList;

public class b$2
implements RxMob$OnSubscribe {
    public final /* synthetic */ b a;

    public b$2(b b10) {
        this.a = b10;
    }

    public void call(RxMob$Subscriber object) {
        int n10;
        String string2 = "https://graph.qq.com/oauth2.0/me";
        ArrayList<KVPair> arrayList = new ArrayList<KVPair>();
        String string3 = b.a(this.a);
        String string4 = "access_token";
        Object[] objectArray = new KVPair(string4, string3);
        arrayList.add((KVPair)objectArray);
        String string5 = "unionid";
        string3 = "1";
        objectArray = new KVPair(string5, string3);
        arrayList.add((KVPair)objectArray);
        NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
        networkHelper$NetworkTimeOut.readTimout = n10 = 10000;
        networkHelper$NetworkTimeOut.connectionTimeout = n10;
        objectArray = cn.sharesdk.framework.a.b.a();
        b b10 = this.a;
        string3 = null;
        string4 = null;
        objectArray = objectArray.httpPost(string2, arrayList, null, null, networkHelper$NetworkTimeOut);
        try {
            b.a(b10, (String)objectArray);
            ((RxMob$Subscriber)object).onCompleted();
        }
        catch (Throwable throwable) {
            b.b(this.a).getDb().put(string5, "");
            object = SSDKLog.b();
            n10 = 0;
            objectArray = new Object[]{};
            string2 = "qq auth, get unionId fail";
            ((NLog)object).d(string2, objectArray);
        }
    }
}

