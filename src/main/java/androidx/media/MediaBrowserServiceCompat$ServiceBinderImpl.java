/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.text.TextUtils
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$1;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$2;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$3;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$4;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$5;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$6;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$7;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$8;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$9;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;
import androidx.media.MediaBrowserServiceCompat$ServiceHandler;

public class MediaBrowserServiceCompat$ServiceBinderImpl {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$ServiceBinderImpl(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
    }

    public void addSubscription(String string2, IBinder iBinder, Bundle bundle, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$ServiceBinderImpl$3 mediaBrowserServiceCompat$ServiceBinderImpl$3 = new MediaBrowserServiceCompat$ServiceBinderImpl$3(this, mediaBrowserServiceCompat$ServiceCallbacks, string2, iBinder, bundle);
        mediaBrowserServiceCompat$ServiceHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$3);
    }

    public void connect(String string2, int n10, int n11, Bundle object, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        Object object2 = this.this$0;
        boolean bl2 = object2.isValidPackage(string2, n11);
        if (bl2) {
            object2 = this.this$0.mHandler;
            MediaBrowserServiceCompat$ServiceBinderImpl$1 mediaBrowserServiceCompat$ServiceBinderImpl$1 = new MediaBrowserServiceCompat$ServiceBinderImpl$1(this, mediaBrowserServiceCompat$ServiceCallbacks, string2, n10, n11, (Bundle)object);
            ((MediaBrowserServiceCompat$ServiceHandler)((Object)object2)).postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$1);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Package/uid mismatch: uid=");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(" package=");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void disconnect(MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$ServiceBinderImpl$2 mediaBrowserServiceCompat$ServiceBinderImpl$2 = new MediaBrowserServiceCompat$ServiceBinderImpl$2(this, mediaBrowserServiceCompat$ServiceCallbacks);
        mediaBrowserServiceCompat$ServiceHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$2);
    }

    public void getMediaItem(String string2, ResultReceiver resultReceiver, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && resultReceiver != null) {
            MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
            MediaBrowserServiceCompat$ServiceBinderImpl$5 mediaBrowserServiceCompat$ServiceBinderImpl$5 = new MediaBrowserServiceCompat$ServiceBinderImpl$5(this, mediaBrowserServiceCompat$ServiceCallbacks, string2, resultReceiver);
            mediaBrowserServiceCompat$ServiceHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$5);
        }
    }

    public void registerCallbacks(MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks, String string2, int n10, int n11, Bundle bundle) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$ServiceBinderImpl$6 mediaBrowserServiceCompat$ServiceBinderImpl$6 = new MediaBrowserServiceCompat$ServiceBinderImpl$6(this, mediaBrowserServiceCompat$ServiceCallbacks, n11, string2, n10, bundle);
        mediaBrowserServiceCompat$ServiceHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$6);
    }

    public void removeSubscription(String string2, IBinder iBinder, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$ServiceBinderImpl$4 mediaBrowserServiceCompat$ServiceBinderImpl$4 = new MediaBrowserServiceCompat$ServiceBinderImpl$4(this, mediaBrowserServiceCompat$ServiceCallbacks, string2, iBinder);
        mediaBrowserServiceCompat$ServiceHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$4);
    }

    public void search(String string2, Bundle bundle, ResultReceiver resultReceiver, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && resultReceiver != null) {
            MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
            MediaBrowserServiceCompat$ServiceBinderImpl$8 mediaBrowserServiceCompat$ServiceBinderImpl$8 = new MediaBrowserServiceCompat$ServiceBinderImpl$8(this, mediaBrowserServiceCompat$ServiceCallbacks, string2, bundle, resultReceiver);
            mediaBrowserServiceCompat$ServiceHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$8);
        }
    }

    public void sendCustomAction(String string2, Bundle bundle, ResultReceiver resultReceiver, MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && resultReceiver != null) {
            MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
            MediaBrowserServiceCompat$ServiceBinderImpl$9 mediaBrowserServiceCompat$ServiceBinderImpl$9 = new MediaBrowserServiceCompat$ServiceBinderImpl$9(this, mediaBrowserServiceCompat$ServiceCallbacks, string2, bundle, resultReceiver);
            mediaBrowserServiceCompat$ServiceHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$9);
        }
    }

    public void unregisterCallbacks(MediaBrowserServiceCompat$ServiceCallbacks mediaBrowserServiceCompat$ServiceCallbacks) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$ServiceBinderImpl$7 mediaBrowserServiceCompat$ServiceBinderImpl$7 = new MediaBrowserServiceCompat$ServiceBinderImpl$7(this, mediaBrowserServiceCompat$ServiceCallbacks);
        mediaBrowserServiceCompat$ServiceHandler.postOrRun(mediaBrowserServiceCompat$ServiceBinderImpl$7);
    }
}

