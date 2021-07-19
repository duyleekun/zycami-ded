/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.twitter;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.twitter.c;
import com.mob.tools.log.NLog;

public class Twitter$1
implements AuthorizeListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ Twitter b;

    public Twitter$1(Twitter twitter, c c10) {
        this.b = twitter;
        this.a = c10;
    }

    public void onCancel() {
        PlatformActionListener platformActionListener = Twitter.k(this.b);
        if (platformActionListener != null) {
            platformActionListener = Twitter.l(this.b);
            Twitter twitter = this.b;
            int n10 = 1;
            platformActionListener.onCancel(twitter, n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete(Bundle object) {
        Object object2 = "oauth_token";
        try {
            Object object3;
            boolean bl2;
            object2 = object.getString((String)object2);
            String string2 = "screen_name";
            string2 = object.getString(string2);
            String string3 = "nickname";
            Object object4 = "user_id";
            if (object2 != null && !(bl2 = ((String)object2).equals(object3 = ""))) {
                String string4 = "platformtools.bh";
                object3 = new RuntimeException(string4);
                object3 = ((Throwable)object3).fillInStackTrace();
                ((Throwable)object3).printStackTrace();
                object3 = "oauth_token_secret";
                object3 = object.getString((String)object3);
                object = object.getString((String)object4);
                object4 = this.b;
                object4 = Twitter.e((Twitter)object4);
                ((PlatformDb)object4).putToken((String)object2);
                object4 = this.b;
                object4 = Twitter.f((Twitter)object4);
                ((PlatformDb)object4).putTokenSecret((String)object3);
                object4 = this.b;
                object4 = Twitter.g((Twitter)object4);
                ((PlatformDb)object4).putUserId((String)object);
                object = this.b;
                object = Twitter.h((Twitter)object);
                ((PlatformDb)object).put(string3, string2);
                object = this.a;
                ((c)object).a((String)object2, (String)object3);
            } else {
                object2 = "tk";
                object2 = object.getString((String)object2);
                object3 = "ts";
                object3 = object.getString((String)object3);
                long l10 = 0L;
                l10 = object.getLong((String)object4, l10);
                object = String.valueOf(l10);
                object4 = this.b;
                object4 = Twitter.a((Twitter)object4);
                ((PlatformDb)object4).putToken((String)object2);
                object2 = this.b;
                object2 = Twitter.b((Twitter)object2);
                ((PlatformDb)object2).putTokenSecret((String)object3);
                object2 = this.b;
                object2 = Twitter.c((Twitter)object2);
                ((PlatformDb)object2).putUserId((String)object);
                object = this.b;
                object = Twitter.d((Twitter)object);
                ((PlatformDb)object).put(string3, string2);
            }
            object = this.b;
            int n10 = 1;
            string2 = null;
            Twitter.a((Twitter)object, n10, null);
            return;
        }
        catch (Exception exception) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(exception);
        }
    }

    public void onError(Throwable throwable) {
        PlatformActionListener platformActionListener = Twitter.i(this.b);
        if (platformActionListener != null) {
            platformActionListener = Twitter.j(this.b);
            Twitter twitter = this.b;
            int n10 = 1;
            platformActionListener.onError(twitter, n10, throwable);
        }
    }
}

