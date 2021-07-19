/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.sina.weibo;

import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.sina.weibo.b;
import com.mob.MobCommunicator;
import com.mob.tools.log.NLog;
import java.util.HashMap;

public class b$1
extends Thread {
    public final /* synthetic */ int a;
    public final /* synthetic */ b b;

    public b$1(b b10, int n10) {
        this.b = b10;
        this.a = n10;
    }

    public void run() {
        Object object = new HashMap();
        Object[] objectArray = cn.sharesdk.sina.weibo.b.a(this.b);
        ((HashMap)object).put("appkey", objectArray);
        objectArray = 1;
        ((HashMap)object).put("plat", objectArray);
        objectArray = this.a;
        ((HashMap)object).put("action", objectArray);
        long l10 = cn.sharesdk.sina.weibo.b.b(this.b);
        objectArray = l10;
        Object object2 = "shareTime";
        ((HashMap)object).put(object2, objectArray);
        objectArray = null;
        object2 = this.b;
        object2 = cn.sharesdk.sina.weibo.b.c((b)object2);
        CharSequence charSequence = "http://lks.share.mob.com/share/shareLog";
        object = ((MobCommunicator)object2).requestSynchronized((HashMap)object, (String)charSequence, false);
        try {
            object = (HashMap)object;
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            charSequence = new StringBuilder();
            String string2 = "LinkCard log up error===> ";
            ((StringBuilder)charSequence).append(string2);
            String string3 = throwable.getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            objectArray = new Object[]{};
            ((NLog)object2).d(string3, objectArray);
        }
    }
}

