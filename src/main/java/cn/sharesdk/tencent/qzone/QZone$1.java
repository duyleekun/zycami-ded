/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.tencent.qzone;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.tencent.qzone.b;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;

public class QZone$1
implements AuthorizeListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ QZone b;

    public QZone$1(QZone qZone, b b10) {
        this.b = qZone;
        this.a = b10;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = QZone.j(this.b);
        if (platformActionListener != null) {
            platformActionListener = QZone.k(this.b);
            QZone qZone = this.b;
            int n10 = 1;
            platformActionListener.onCancel(qZone, n10);
        }
    }

    public void onComplete(Bundle object) {
        String string2 = object.getString("open_id");
        String string3 = object.getString("access_token");
        String string4 = object.getString("expires_in");
        QZone.c(this.b).putToken(string3);
        Object object2 = QZone.d(this.b);
        String string5 = "";
        ((PlatformDb)object2).putTokenSecret(string5);
        object2 = this.b;
        object2 = QZone.e((QZone)object2);
        long l10 = ResHelper.parseLong(string4);
        try {
            ((PlatformDb)object2).putExpiresIn(l10);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
        }
        QZone.f(this.b).putUserId(string2);
        string4 = "pf";
        object2 = object.getString(string4);
        string5 = "pfkey";
        String string6 = object.getString(string5);
        String string7 = "pay_token";
        object = object.getString(string7);
        QZone.g(this.b).put(string4, (String)object2);
        QZone.h(this.b).put(string5, string6);
        QZone.i(this.b).put(string7, (String)object);
        this.a.b(string2);
        this.a.c(string3);
        this.a.a();
        QZone.a(this.b, 1, null);
    }

    public void onError(Throwable throwable) {
        PlatformActionListener platformActionListener = QZone.a(this.b);
        if (platformActionListener != null) {
            platformActionListener = QZone.b(this.b);
            QZone qZone = this.b;
            int n10 = 1;
            platformActionListener.onError(qZone, n10, throwable);
        }
    }
}

