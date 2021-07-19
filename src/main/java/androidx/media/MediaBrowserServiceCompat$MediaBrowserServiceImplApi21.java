/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 *  android.service.media.MediaBrowserService
 */
package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$BrowserRoot;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21;
import androidx.media.MediaBrowserServiceCompat$ResultWrapper;
import androidx.media.MediaBrowserServiceCompat$ServiceHandler;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import java.util.List;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
implements MediaBrowserServiceCompat$MediaBrowserServiceImpl {
    public Messenger mMessenger;
    public final List mRootExtrasList;
    public MediaBrowserService mServiceFwk;
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21(MediaBrowserServiceCompat object) {
        this.this$0 = object;
        this.mRootExtrasList = object;
    }

    public Bundle getBrowserRootHints() {
        Object object = this.mMessenger;
        Bundle bundle = null;
        if (object == null) {
            return null;
        }
        object = this.this$0.mCurConnection;
        if (object != null) {
            object = object.rootHints;
            if (object != null) {
                object = this.this$0.mCurConnection.rootHints;
                bundle = new Bundle((Bundle)object);
            }
            return bundle;
        }
        object = new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        throw object;
    }

    public MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
        Object object = this.this$0.mCurConnection;
        if (object != null) {
            return ((MediaBrowserServiceCompat$ConnectionRecord)object).browserInfo;
        }
        object = new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        throw object;
    }

    public void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String string2, Bundle bundle) {
        this.notifyChildrenChangedForCompat(mediaSessionManager$RemoteUserInfo, string2, bundle);
    }

    public void notifyChildrenChanged(String string2, Bundle bundle) {
        this.notifyChildrenChangedForFramework(string2, bundle);
        this.notifyChildrenChangedForCompat(string2, bundle);
    }

    public void notifyChildrenChangedForCompat(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String string2, Bundle bundle) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4(this, mediaSessionManager$RemoteUserInfo, string2, bundle);
        mediaBrowserServiceCompat$ServiceHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4);
    }

    public void notifyChildrenChangedForCompat(String string2, Bundle bundle) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3(this, string2, bundle);
        mediaBrowserServiceCompat$ServiceHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3);
    }

    public void notifyChildrenChangedForCompatOnHandler(MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, String string2, Bundle bundle) {
        Object object = (List)mediaBrowserServiceCompat$ConnectionRecord.subscriptions.get(string2);
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Pair pair = (Pair)object.next();
                Object object2 = (Bundle)pair.second;
                boolean bl3 = MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle)object2);
                if (!bl3) continue;
                object2 = this.this$0;
                pair = (Bundle)pair.second;
                ((MediaBrowserServiceCompat)((Object)object2)).performLoadChildren(string2, mediaBrowserServiceCompat$ConnectionRecord, (Bundle)pair, bundle);
            }
        }
    }

    public void notifyChildrenChangedForFramework(String string2, Bundle bundle) {
        this.mServiceFwk.notifyChildrenChanged(string2);
    }

    public IBinder onBind(Intent intent) {
        return this.mServiceFwk.onBind(intent);
    }

    public void onCreate() {
        MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21(this, (Context)mediaBrowserServiceCompat);
        this.mServiceFwk = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21;
        mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$MediaBrowserServiceApi21.onCreate();
    }

    /*
     * Unable to fully structure code
     */
    public MediaBrowserServiceCompat$BrowserRoot onGetRoot(String var1_1, int var2_2, Bundle var3_3) {
        var4_4 = -1;
        if (var3_3 == null) ** GOTO lbl-1000
        var5_5 = null;
        var6_6 = "extra_client_version";
        var7_7 = var3_3.getInt((String)var6_6, 0);
        if (var7_7 != 0) {
            var3_3.remove((String)var6_6);
            var6_6 = this.this$0.mHandler;
            this.mMessenger = var5_5 = new Messenger((Handler)var6_6);
            var5_5 = new Bundle();
            var8_8 = 2;
            var5_5.putInt("extra_service_version", var8_8);
            var6_6 = this.mMessenger.getBinder();
            var9_9 = "extra_messenger";
            BundleCompat.putBinder((Bundle)var5_5, (String)var9_9, (IBinder)var6_6);
            var6_6 = this.this$0.mSession;
            if (var6_6 != null) {
                if ((var6_6 = var6_6.getExtraBinder()) == null) {
                    var8_8 = 0;
                    var6_6 = null;
                } else {
                    var6_6 = var6_6.asBinder();
                }
                var9_9 = "extra_session_binder";
                BundleCompat.putBinder((Bundle)var5_5, (String)var9_9, (IBinder)var6_6);
            } else {
                var6_6 = this.mRootExtrasList;
                var6_6.add(var5_5);
            }
            var6_6 = "extra_calling_pid";
            var4_4 = var3_3.getInt((String)var6_6, var4_4);
            var3_3.remove((String)var6_6);
            var10_10 = var4_4;
        } else lbl-1000:
        // 2 sources

        {
            var10_10 = var4_4;
            var7_7 = 0;
            var5_5 = null;
        }
        var12_12 = this.this$0;
        var9_9 = var11_11;
        var11_11 = new MediaBrowserServiceCompat$ConnectionRecord(var12_12, (String)var1_1, var10_10, var2_2, var3_3, null);
        var6_6 = this.this$0;
        var6_6.mCurConnection = var11_11;
        var1_1 = var6_6.onGetRoot((String)var1_1, var2_2, var3_3);
        var13_13 = this.this$0;
        var13_13.mCurConnection = null;
        if (var1_1 == null) {
            return null;
        }
        var3_3 = this.mMessenger;
        if (var3_3 != null) {
            var13_13 = var13_13.mPendingConnections;
            var13_13.add(var11_11);
        }
        if (var5_5 == null) {
            var5_5 = var1_1.getExtras();
        } else {
            var13_13 = var1_1.getExtras();
            if (var13_13 != null) {
                var13_13 = var1_1.getExtras();
                var5_5.putAll((Bundle)var13_13);
            }
        }
        var1_1 = var1_1.getRootId();
        var13_13 = new MediaBrowserServiceCompat$BrowserRoot((String)var1_1, (Bundle)var5_5);
        return var13_13;
    }

    public void onLoadChildren(String string2, MediaBrowserServiceCompat$ResultWrapper object) {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord;
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2(this, string2, (MediaBrowserServiceCompat$ResultWrapper)object);
        object = this.this$0;
        ((MediaBrowserServiceCompat)object).mCurConnection = mediaBrowserServiceCompat$ConnectionRecord = ((MediaBrowserServiceCompat)object).mConnectionFromFwk;
        ((MediaBrowserServiceCompat)((Object)object)).onLoadChildren(string2, mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2);
        this.this$0.mCurConnection = null;
    }

    public void setSessionToken(MediaSessionCompat$Token mediaSessionCompat$Token) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1(this, mediaSessionCompat$Token);
        mediaBrowserServiceCompat$ServiceHandler.postOrRun(mediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1);
    }
}

