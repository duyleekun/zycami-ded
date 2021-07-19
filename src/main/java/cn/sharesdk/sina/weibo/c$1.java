/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.sina.weibo.c;
import cn.sharesdk.sina.weibo.i;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

public class c$1
extends Thread {
    public final /* synthetic */ Platform a;
    public final /* synthetic */ String b;
    public final /* synthetic */ c c;

    public c$1(c c10, Platform platform, String string2) {
        this.c = c10;
        this.a = platform;
        this.b = string2;
    }

    /*
     * Loose catch block
     */
    public void run() {
        Object object = "access_token";
        Object object2 = "expires_in";
        String string2 = "remind_in";
        String string3 = "uid";
        Object object3 = this.a;
        object3 = i.a((Platform)object3);
        Object object4 = this.b;
        try {
            object3 = ((i)object3).b((String)object4);
        }
        catch (Throwable throwable) {
            object4 = this.c;
            object4 = cn.sharesdk.sina.weibo.c.a((c)((Object)object4));
            object4.onError(throwable);
            object3 = null;
        }
        if (object3 == null) {
            object = this.c;
            object = cn.sharesdk.sina.weibo.c.b((c)((Object)object));
            string2 = "Authorize token is empty";
            object2 = new Throwable(string2);
            object.onError((Throwable)object2);
            return;
        }
        object4 = new Hashon();
        object3 = ((Hashon)object4).fromJson((String)object3);
        object4 = new Bundle();
        Object object5 = ((HashMap)object3).get(string3);
        object5 = String.valueOf(object5);
        object4.putString(string3, object5);
        string3 = ((HashMap)object3).get(string2);
        string3 = String.valueOf(string3);
        object4.putString(string2, string3);
        string2 = ((HashMap)object3).get(object2);
        string2 = String.valueOf(string2);
        object4.putString((String)object2, string2);
        object2 = ((HashMap)object3).get(object);
        object2 = String.valueOf(object2);
        object4.putString((String)object, (String)object2);
        object = this.c;
        object = cn.sharesdk.sina.weibo.c.c((c)((Object)object));
        object.onComplete((Bundle)object4);
        {
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).d(throwable);
            }
        }
    }
}

