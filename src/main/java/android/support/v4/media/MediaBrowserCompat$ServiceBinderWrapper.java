/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.Parcelable
 *  android.os.Process
 */
package android.support.v4.media;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.support.v4.os.ResultReceiver;
import androidx.core.app.BundleCompat;

public class MediaBrowserCompat$ServiceBinderWrapper {
    private Messenger mMessenger;
    private Bundle mRootHints;

    public MediaBrowserCompat$ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
        Messenger messenger;
        this.mMessenger = messenger = new Messenger(iBinder);
        this.mRootHints = bundle;
    }

    private void sendRequest(int n10, Bundle bundle, Messenger messenger) {
        Message message = Message.obtain();
        message.what = n10;
        message.arg1 = 1;
        message.setData(bundle);
        message.replyTo = messenger;
        this.mMessenger.send(message);
    }

    public void addSubscription(String string2, IBinder iBinder, Bundle bundle, Messenger messenger) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", string2);
        BundleCompat.putBinder(bundle2, "data_callback_token", iBinder);
        bundle2.putBundle("data_options", bundle);
        this.sendRequest(3, bundle2, messenger);
    }

    public void connect(Context object, Messenger messenger) {
        Bundle bundle = new Bundle();
        object = object.getPackageName();
        bundle.putString("data_package_name", (String)object);
        int n10 = Process.myPid();
        bundle.putInt("data_calling_pid", n10);
        object = this.mRootHints;
        bundle.putBundle("data_root_hints", (Bundle)object);
        this.sendRequest(1, bundle, messenger);
    }

    public void disconnect(Messenger messenger) {
        this.sendRequest(2, null, messenger);
    }

    public void getMediaItem(String string2, ResultReceiver resultReceiver, Messenger messenger) {
        Bundle bundle = new Bundle();
        bundle.putString("data_media_item_id", string2);
        bundle.putParcelable("data_result_receiver", (Parcelable)resultReceiver);
        this.sendRequest(5, bundle, messenger);
    }

    public void registerCallbackMessenger(Context object, Messenger messenger) {
        Bundle bundle = new Bundle();
        object = object.getPackageName();
        bundle.putString("data_package_name", (String)object);
        int n10 = Process.myPid();
        bundle.putInt("data_calling_pid", n10);
        object = this.mRootHints;
        bundle.putBundle("data_root_hints", (Bundle)object);
        this.sendRequest(6, bundle, messenger);
    }

    public void removeSubscription(String string2, IBinder iBinder, Messenger messenger) {
        Bundle bundle = new Bundle();
        bundle.putString("data_media_item_id", string2);
        BundleCompat.putBinder(bundle, "data_callback_token", iBinder);
        this.sendRequest(4, bundle, messenger);
    }

    public void search(String string2, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_search_query", string2);
        bundle2.putBundle("data_search_extras", bundle);
        bundle2.putParcelable("data_result_receiver", (Parcelable)resultReceiver);
        this.sendRequest(8, bundle2, messenger);
    }

    public void sendCustomAction(String string2, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_custom_action", string2);
        bundle2.putBundle("data_custom_action_extras", bundle);
        bundle2.putParcelable("data_result_receiver", (Parcelable)resultReceiver);
        this.sendRequest(9, bundle2, messenger);
    }

    public void unregisterCallbackMessenger(Messenger messenger) {
        this.sendRequest(7, null, messenger);
    }
}

