/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.Parcelable
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;
import java.util.ArrayList;
import java.util.List;

public class MediaBrowserServiceCompat$ServiceCallbacksCompat
implements MediaBrowserServiceCompat$ServiceCallbacks {
    public final Messenger mCallbacks;

    public MediaBrowserServiceCompat$ServiceCallbacksCompat(Messenger messenger) {
        this.mCallbacks = messenger;
    }

    private void sendRequest(int n10, Bundle bundle) {
        Message message = Message.obtain();
        message.what = n10;
        message.arg1 = 2;
        message.setData(bundle);
        this.mCallbacks.send(message);
    }

    public IBinder asBinder() {
        return this.mCallbacks.getBinder();
    }

    public void onConnect(String string2, MediaSessionCompat$Token mediaSessionCompat$Token, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extra_service_version", 2);
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", string2);
        bundle2.putParcelable("data_media_session_token", (Parcelable)mediaSessionCompat$Token);
        bundle2.putBundle("data_root_hints", bundle);
        this.sendRequest(1, bundle2);
    }

    public void onConnectFailed() {
        this.sendRequest(2, null);
    }

    public void onLoadChildren(String object, List object2, Bundle bundle, Bundle bundle2) {
        Bundle bundle3 = new Bundle();
        String string2 = "data_media_item_id";
        bundle3.putString(string2, (String)object);
        bundle3.putBundle("data_options", bundle);
        object = "data_notify_children_changed_options";
        bundle3.putBundle((String)object, bundle2);
        if (object2 != null) {
            boolean bl2 = object2 instanceof ArrayList;
            object2 = bl2 ? (ArrayList)object2 : (object = new ArrayList(object2));
            object = "data_media_item_list";
            bundle3.putParcelableArrayList((String)object, (ArrayList)object2);
        }
        this.sendRequest(3, bundle3);
    }
}

