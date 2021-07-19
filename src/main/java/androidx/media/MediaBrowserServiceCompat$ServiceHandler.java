/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.Messenger
 *  android.util.Log
 */
package androidx.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacks;
import androidx.media.MediaBrowserServiceCompat$ServiceCallbacksCompat;

public final class MediaBrowserServiceCompat$ServiceHandler
extends Handler {
    private final MediaBrowserServiceCompat$ServiceBinderImpl mServiceBinderImpl;
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$ServiceHandler(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl;
        this.this$0 = mediaBrowserServiceCompat;
        this.mServiceBinderImpl = mediaBrowserServiceCompat$ServiceBinderImpl = new MediaBrowserServiceCompat$ServiceBinderImpl(mediaBrowserServiceCompat);
    }

    public void handleMessage(Message object) {
        Object object2 = object.getData();
        int n10 = object.what;
        Object object3 = "data_callback_token";
        Object object4 = "data_calling_uid";
        Object object5 = "data_calling_pid";
        String string2 = "data_package_name";
        String string3 = "data_root_hints";
        Object object6 = "data_result_receiver";
        String string4 = "data_media_item_id";
        switch (n10) {
            default: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unhandled message: ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append("\n  Service version: ");
                n10 = 2;
                ((StringBuilder)object2).append(n10);
                String string5 = "\n  Client version: ";
                ((StringBuilder)object2).append(string5);
                int n11 = object.arg1;
                ((StringBuilder)object2).append(n11);
                object = ((StringBuilder)object2).toString();
                object2 = "MBServiceCompat";
                Log.w((String)object2, (String)object);
                break;
            }
            case 9: {
                Bundle bundle = object2.getBundle("data_custom_action_extras");
                MediaSessionCompat.ensureClassLoader(bundle);
                object3 = this.mServiceBinderImpl;
                object4 = object2.getString("data_custom_action");
                object2 = (ResultReceiver)object2.getParcelable((String)object6);
                object = object.replyTo;
                object5 = new MediaBrowserServiceCompat$ServiceCallbacksCompat((Messenger)object);
                ((MediaBrowserServiceCompat$ServiceBinderImpl)object3).sendCustomAction((String)object4, bundle, (ResultReceiver)object2, (MediaBrowserServiceCompat$ServiceCallbacks)object5);
                break;
            }
            case 8: {
                Bundle bundle = object2.getBundle("data_search_extras");
                MediaSessionCompat.ensureClassLoader(bundle);
                object3 = this.mServiceBinderImpl;
                object4 = object2.getString("data_search_query");
                object2 = (ResultReceiver)object2.getParcelable((String)object6);
                object = object.replyTo;
                object5 = new MediaBrowserServiceCompat$ServiceCallbacksCompat((Messenger)object);
                ((MediaBrowserServiceCompat$ServiceBinderImpl)object3).search((String)object4, bundle, (ResultReceiver)object2, (MediaBrowserServiceCompat$ServiceCallbacks)object5);
                break;
            }
            case 7: {
                object2 = this.mServiceBinderImpl;
                object = object.replyTo;
                MediaBrowserServiceCompat$ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat = new MediaBrowserServiceCompat$ServiceCallbacksCompat((Messenger)object);
                ((MediaBrowserServiceCompat$ServiceBinderImpl)object2).unregisterCallbacks(mediaBrowserServiceCompat$ServiceCallbacksCompat);
                break;
            }
            case 6: {
                object6 = object2.getBundle(string3);
                MediaSessionCompat.ensureClassLoader((Bundle)object6);
                object3 = this.mServiceBinderImpl;
                object = object.replyTo;
                MediaBrowserServiceCompat$ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat = new MediaBrowserServiceCompat$ServiceCallbacksCompat((Messenger)object);
                object = object2.getString(string2);
                int n12 = object2.getInt((String)object5);
                int n13 = object2.getInt((String)object4);
                object4 = mediaBrowserServiceCompat$ServiceCallbacksCompat;
                object5 = object;
                ((MediaBrowserServiceCompat$ServiceBinderImpl)object3).registerCallbacks(mediaBrowserServiceCompat$ServiceCallbacksCompat, (String)object, n12, n13, (Bundle)object6);
                break;
            }
            case 5: {
                MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl = this.mServiceBinderImpl;
                object3 = object2.getString(string4);
                object2 = (ResultReceiver)object2.getParcelable((String)object6);
                object = object.replyTo;
                object4 = new MediaBrowserServiceCompat$ServiceCallbacksCompat((Messenger)object);
                mediaBrowserServiceCompat$ServiceBinderImpl.getMediaItem((String)object3, (ResultReceiver)object2, (MediaBrowserServiceCompat$ServiceCallbacks)object4);
                break;
            }
            case 4: {
                MediaBrowserServiceCompat$ServiceBinderImpl mediaBrowserServiceCompat$ServiceBinderImpl = this.mServiceBinderImpl;
                object4 = object2.getString(string4);
                object2 = BundleCompat.getBinder((Bundle)object2, (String)object3);
                object = object.replyTo;
                object3 = new MediaBrowserServiceCompat$ServiceCallbacksCompat((Messenger)object);
                mediaBrowserServiceCompat$ServiceBinderImpl.removeSubscription((String)object4, (IBinder)object2, (MediaBrowserServiceCompat$ServiceCallbacks)object3);
                break;
            }
            case 3: {
                Bundle bundle = object2.getBundle("data_options");
                MediaSessionCompat.ensureClassLoader(bundle);
                object4 = this.mServiceBinderImpl;
                object5 = object2.getString(string4);
                object2 = BundleCompat.getBinder((Bundle)object2, (String)object3);
                object = object.replyTo;
                object3 = new MediaBrowserServiceCompat$ServiceCallbacksCompat((Messenger)object);
                ((MediaBrowserServiceCompat$ServiceBinderImpl)object4).addSubscription((String)object5, (IBinder)object2, bundle, (MediaBrowserServiceCompat$ServiceCallbacks)object3);
                break;
            }
            case 2: {
                object2 = this.mServiceBinderImpl;
                object = object.replyTo;
                MediaBrowserServiceCompat$ServiceCallbacksCompat mediaBrowserServiceCompat$ServiceCallbacksCompat = new MediaBrowserServiceCompat$ServiceCallbacksCompat((Messenger)object);
                ((MediaBrowserServiceCompat$ServiceBinderImpl)object2).disconnect(mediaBrowserServiceCompat$ServiceCallbacksCompat);
                break;
            }
            case 1: {
                string3 = object2.getBundle(string3);
                MediaSessionCompat.ensureClassLoader((Bundle)string3);
                object3 = this.mServiceBinderImpl;
                String string6 = object2.getString(string2);
                int n14 = object2.getInt((String)object5);
                int n15 = object2.getInt((String)object4);
                object = object.replyTo;
                object6 = new MediaBrowserServiceCompat$ServiceCallbacksCompat((Messenger)object);
                object4 = string6;
                ((MediaBrowserServiceCompat$ServiceBinderImpl)object3).connect(string6, n14, n15, (Bundle)string3, (MediaBrowserServiceCompat$ServiceCallbacks)object6);
            }
        }
    }

    public void postOrRun(Runnable runnable) {
        Thread thread;
        Thread thread2 = Thread.currentThread();
        if (thread2 == (thread = this.getLooper().getThread())) {
            runnable.run();
        } else {
            this.post(runnable);
        }
    }

    public boolean sendMessageAtTime(Message message, long l10) {
        Bundle bundle = message.getData();
        ClassLoader classLoader = MediaBrowserCompat.class.getClassLoader();
        bundle.setClassLoader(classLoader);
        int n10 = Binder.getCallingUid();
        bundle.putInt("data_calling_uid", n10);
        n10 = Binder.getCallingPid();
        String string2 = "data_calling_pid";
        if (n10 > 0) {
            bundle.putInt(string2, n10);
        } else {
            n10 = (int)(bundle.containsKey(string2) ? 1 : 0);
            if (n10 == 0) {
                n10 = -1;
                bundle.putInt(string2, n10);
            }
        }
        return super.sendMessageAtTime(message, l10);
    }
}

