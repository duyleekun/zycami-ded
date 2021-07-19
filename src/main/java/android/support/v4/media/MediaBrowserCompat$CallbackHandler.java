/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.BadParcelableException
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  android.os.Messenger
 *  android.util.Log
 */
package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MediaBrowserCompat$CallbackHandler
extends Handler {
    private final WeakReference mCallbackImplRef;
    private WeakReference mCallbacksMessengerRef;

    public MediaBrowserCompat$CallbackHandler(MediaBrowserCompat$MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
        WeakReference<MediaBrowserCompat$MediaBrowserServiceCallbackImpl> weakReference;
        this.mCallbackImplRef = weakReference = new WeakReference<MediaBrowserCompat$MediaBrowserServiceCallbackImpl>(mediaBrowserServiceCallbackImpl);
    }

    public void handleMessage(Message message) {
        block29: {
            String string2 = "MediaBrowserCompat";
            Object object = this.mCallbacksMessengerRef;
            if (object != null && (object = ((Reference)object).get()) != null && (object = this.mCallbackImplRef.get()) != null) {
                String string3;
                int n10;
                Object object2;
                Object object3;
                MediaBrowserCompat$MediaBrowserServiceCallbackImpl mediaBrowserCompat$MediaBrowserServiceCallbackImpl;
                block26: {
                    block27: {
                        block28: {
                            object = message.getData();
                            MediaSessionCompat.ensureClassLoader((Bundle)object);
                            mediaBrowserCompat$MediaBrowserServiceCallbackImpl = (MediaBrowserCompat$MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get();
                            object2 = object3 = this.mCallbacksMessengerRef.get();
                            object2 = (Messenger)object3;
                            n10 = 1;
                            int n11 = message.what;
                            string3 = "data_media_item_id";
                            if (n11 == n10) break block26;
                            int n12 = 2;
                            if (n11 == n12) break block27;
                            n12 = 3;
                            if (n11 == n12) break block28;
                            object = new StringBuilder();
                            object3 = "Unhandled message: ";
                            ((StringBuilder)object).append((String)object3);
                            ((StringBuilder)object).append(message);
                            object3 = "\n  Client version: ";
                            ((StringBuilder)object).append((String)object3);
                            ((StringBuilder)object).append(n10);
                            object3 = "\n  Service version: ";
                            ((StringBuilder)object).append((String)object3);
                            n11 = message.arg1;
                            ((StringBuilder)object).append(n11);
                            object = ((StringBuilder)object).toString();
                            Log.w((String)string2, (String)object);
                        }
                        object3 = "data_options";
                        Bundle bundle = object.getBundle(object3);
                        MediaSessionCompat.ensureClassLoader(bundle);
                        object3 = "data_notify_children_changed_options";
                        Bundle bundle2 = object.getBundle(object3);
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        String string4 = object.getString(string3);
                        object3 = "data_media_item_list";
                        ArrayList arrayList = object.getParcelableArrayList(object3);
                        object3 = mediaBrowserCompat$MediaBrowserServiceCallbackImpl;
                        string3 = object2;
                        mediaBrowserCompat$MediaBrowserServiceCallbackImpl.onLoadChildren((Messenger)object2, string4, arrayList, bundle, bundle2);
                    }
                    mediaBrowserCompat$MediaBrowserServiceCallbackImpl.onConnectionFailed((Messenger)object2);
                }
                object3 = "data_root_hints";
                object3 = object.getBundle(object3);
                MediaSessionCompat.ensureClassLoader(object3);
                string3 = object.getString(string3);
                String string5 = "data_media_session_token";
                object = object.getParcelable(string5);
                object = (MediaSessionCompat$Token)object;
                try {
                    mediaBrowserCompat$MediaBrowserServiceCallbackImpl.onServiceConnected((Messenger)object2, string3, (MediaSessionCompat$Token)object, (Bundle)object3);
                }
                catch (BadParcelableException badParcelableException) {
                    object = "Could not unparcel the data.";
                    Log.e((String)string2, (String)object);
                    int n13 = message.what;
                    if (n13 != n10) break block29;
                    mediaBrowserCompat$MediaBrowserServiceCallbackImpl.onConnectionFailed((Messenger)object2);
                }
            }
        }
    }

    public void setCallbacksMessenger(Messenger messenger) {
        WeakReference<Messenger> weakReference;
        this.mCallbacksMessengerRef = weakReference = new WeakReference<Messenger>(messenger);
    }
}

