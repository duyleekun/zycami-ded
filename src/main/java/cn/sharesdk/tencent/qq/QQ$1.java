/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.tencent.qq;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qq.c;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;

public class QQ$1
implements AuthorizeListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ QQ b;

    public QQ$1(QQ qQ, c c10) {
        this.b = qQ;
        this.a = c10;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = QQ.j(this.b);
        if (platformActionListener != null) {
            platformActionListener = QQ.k(this.b);
            QQ qQ = this.b;
            int n10 = 1;
            platformActionListener.onCancel(qQ, n10);
        }
    }

    public void onComplete(Bundle object) {
        String string2 = object.getString("open_id");
        String string3 = object.getString("access_token");
        String string4 = object.getString("expires_in");
        QQ.c(this.b).putToken(string3);
        Object object2 = QQ.d(this.b);
        String string5 = "";
        ((PlatformDb)object2).putTokenSecret(string5);
        object2 = this.b;
        object2 = QQ.e((QQ)object2);
        long l10 = ResHelper.parseLong(string4);
        try {
            ((PlatformDb)object2).putExpiresIn(l10);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).w(throwable);
        }
        QQ.f(this.b).putUserId(string2);
        string4 = "pf";
        object2 = object.getString(string4);
        string5 = "pfkey";
        String string6 = object.getString(string5);
        String string7 = "pay_token";
        object = object.getString(string7);
        QQ.g(this.b).put(string4, (String)object2);
        QQ.h(this.b).put(string5, string6);
        QQ.i(this.b).put(string7, (String)object);
        this.a.b(string2);
        this.a.d(string3);
        this.a.a();
        QQ.a(this.b, 1, null);
    }

    public void onError(Throwable throwable) {
        PlatformActionListener platformActionListener = QQ.a(this.b);
        if (platformActionListener != null) {
            platformActionListener = QQ.b(this.b);
            QQ qQ = this.b;
            int n10 = 1;
            platformActionListener.onError(qQ, n10, throwable);
        }
    }
}

