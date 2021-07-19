/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.media.browse.MediaBrowser
 *  android.media.browse.MediaBrowser$ConnectionCallback
 *  android.media.browse.MediaBrowser$SubscriptionCallback
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 *  android.os.Process
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat$CallbackHandler;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal;
import android.support.v4.media.MediaBrowserCompat$CustomActionCallback;
import android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$ItemReceiver;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$1;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$2;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$3;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$4;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$5;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$6;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$7;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl;
import android.support.v4.media.MediaBrowserCompat$SearchCallback;
import android.support.v4.media.MediaBrowserCompat$SearchResultReceiver;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
import android.support.v4.media.MediaBrowserCompat$Subscription;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import java.util.List;

public class MediaBrowserCompat$MediaBrowserImplApi21
implements MediaBrowserCompat$MediaBrowserImpl,
MediaBrowserCompat$MediaBrowserServiceCallbackImpl,
MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal {
    public final MediaBrowser mBrowserFwk;
    public Messenger mCallbacksMessenger;
    public final Context mContext;
    public final MediaBrowserCompat$CallbackHandler mHandler;
    private MediaSessionCompat$Token mMediaSessionToken;
    private Bundle mNotifyChildrenChangedOptions;
    public final Bundle mRootHints;
    public MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper;
    public int mServiceVersion;
    private final ArrayMap mSubscriptions;

    public MediaBrowserCompat$MediaBrowserImplApi21(Context context, ComponentName componentName, MediaBrowserCompat$ConnectionCallback mediaBrowserCompat$ConnectionCallback, Bundle bundle) {
        Object object;
        this.mHandler = object = new MediaBrowserCompat$CallbackHandler(this);
        this.mSubscriptions = object;
        this.mContext = context;
        if (bundle != null) {
            super(bundle);
        } else {
            super();
        }
        this.mRootHints = object;
        object.putInt("extra_client_version", 1);
        int n10 = Process.myPid();
        object.putInt("extra_calling_pid", n10);
        mediaBrowserCompat$ConnectionCallback.setInternalConnectionCallback(this);
        mediaBrowserCompat$ConnectionCallback = mediaBrowserCompat$ConnectionCallback.mConnectionCallbackFwk;
        super(context, componentName, (MediaBrowser.ConnectionCallback)mediaBrowserCompat$ConnectionCallback, (Bundle)object);
        this.mBrowserFwk = bundle;
    }

    public void connect() {
        this.mBrowserFwk.connect();
    }

    public void disconnect() {
        Object object;
        Object object2 = this.mServiceBinderWrapper;
        if (object2 != null && (object = this.mCallbacksMessenger) != null) {
            try {
                ((MediaBrowserCompat$ServiceBinderWrapper)object2).unregisterCallbackMessenger((Messenger)object);
            }
            catch (RemoteException remoteException) {
                object2 = "MediaBrowserCompat";
                object = "Remote error unregistering client messenger.";
                Log.i((String)object2, (String)object);
            }
        }
        this.mBrowserFwk.disconnect();
    }

    public Bundle getExtras() {
        return this.mBrowserFwk.getExtras();
    }

    public void getItem(String object, MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            if (mediaBrowserCompat$ItemCallback != null) {
                Object object2 = this.mBrowserFwk;
                bl2 = object2.isConnected();
                Object object3 = "MediaBrowserCompat";
                if (!bl2) {
                    Log.i((String)object3, (String)"Not connected, unable to retrieve the MediaItem.");
                    object2 = this.mHandler;
                    object3 = new MediaBrowserCompat$MediaBrowserImplApi21$1(this, mediaBrowserCompat$ItemCallback, (String)object);
                    object2.post((Runnable)object3);
                    return;
                }
                object2 = this.mServiceBinderWrapper;
                if (object2 == null) {
                    object2 = this.mHandler;
                    object3 = new MediaBrowserCompat$MediaBrowserImplApi21$2(this, mediaBrowserCompat$ItemCallback, (String)object);
                    object2.post((Runnable)object3);
                    return;
                }
                Object object4 = this.mHandler;
                object2 = new MediaBrowserCompat$ItemReceiver((String)object, mediaBrowserCompat$ItemCallback, (Handler)object4);
                object4 = this.mServiceBinderWrapper;
                Messenger messenger = this.mCallbacksMessenger;
                try {
                    ((MediaBrowserCompat$ServiceBinderWrapper)object4).getMediaItem((String)object, (ResultReceiver)object2, messenger);
                }
                catch (RemoteException remoteException) {
                    object2 = new StringBuilder();
                    object4 = "Remote error getting media item: ";
                    object2.append((String)object4);
                    object2.append((String)object);
                    object2 = object2.toString();
                    Log.i((String)object3, (String)object2);
                    object2 = this.mHandler;
                    object3 = new MediaBrowserCompat$MediaBrowserImplApi21$3(this, mediaBrowserCompat$ItemCallback, (String)object);
                    object2.post((Runnable)object3);
                }
                return;
            }
            object = new IllegalArgumentException("cb is null");
            throw object;
        }
        object = new IllegalArgumentException("mediaId is empty");
        throw object;
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mNotifyChildrenChangedOptions;
    }

    public String getRoot() {
        return this.mBrowserFwk.getRoot();
    }

    public ComponentName getServiceComponent() {
        return this.mBrowserFwk.getServiceComponent();
    }

    public MediaSessionCompat$Token getSessionToken() {
        MediaSessionCompat$Token mediaSessionCompat$Token = this.mMediaSessionToken;
        if (mediaSessionCompat$Token == null) {
            this.mMediaSessionToken = mediaSessionCompat$Token = MediaSessionCompat$Token.fromToken(this.mBrowserFwk.getSessionToken());
        }
        return this.mMediaSessionToken;
    }

    public boolean isConnected() {
        return this.mBrowserFwk.isConnected();
    }

    public void onConnected() {
        int n10;
        MediaBrowser mediaBrowser;
        Object object = "MediaBrowserCompat";
        try {
            mediaBrowser = this.mBrowserFwk;
        }
        catch (IllegalStateException illegalStateException) {
            Log.e((String)object, (String)"Unexpected IllegalStateException", (Throwable)illegalStateException);
            return;
        }
        mediaBrowser = mediaBrowser.getExtras();
        if (mediaBrowser == null) {
            return;
        }
        Object object2 = "extra_service_version";
        this.mServiceVersion = n10 = mediaBrowser.getInt((String)object2, 0);
        Object object3 = BundleCompat.getBinder((Bundle)mediaBrowser, "extra_messenger");
        if (object3 != null) {
            Bundle bundle = this.mRootHints;
            this.mServiceBinderWrapper = object2 = new MediaBrowserCompat$ServiceBinderWrapper((IBinder)object3, bundle);
            object2 = this.mHandler;
            object3 = new Messenger((Handler)object2);
            this.mCallbacksMessenger = object3;
            object2 = this.mHandler;
            ((MediaBrowserCompat$CallbackHandler)((Object)object2)).setCallbacksMessenger((Messenger)object3);
            object3 = this.mServiceBinderWrapper;
            object2 = this.mContext;
            bundle = this.mCallbacksMessenger;
            try {
                ((MediaBrowserCompat$ServiceBinderWrapper)object3).registerCallbackMessenger((Context)object2, (Messenger)bundle);
            }
            catch (RemoteException remoteException) {
                object3 = "Remote error registering client messenger.";
                Log.i((String)object, (String)object3);
            }
        }
        if ((object = IMediaSession$Stub.asInterface(BundleCompat.getBinder((Bundle)mediaBrowser, "extra_session_binder"))) != null) {
            mediaBrowser = this.mBrowserFwk.getSessionToken();
            this.mMediaSessionToken = object = MediaSessionCompat$Token.fromToken(mediaBrowser, (IMediaSession)object);
        }
    }

    public void onConnectionFailed() {
    }

    public void onConnectionFailed(Messenger messenger) {
    }

    public void onConnectionSuspended() {
        this.mServiceBinderWrapper = null;
        this.mCallbacksMessenger = null;
        this.mMediaSessionToken = null;
        this.mHandler.setCallbacksMessenger(null);
    }

    public void onLoadChildren(Messenger object, String string2, List object2, Bundle bundle, Bundle bundle2) {
        Messenger messenger = this.mCallbacksMessenger;
        if (messenger != object) {
            return;
        }
        object = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(string2);
        if (object == null) {
            boolean bl2 = MediaBrowserCompat.DEBUG;
            if (bl2) {
                object = new StringBuilder();
                object2 = "onLoadChildren for id that isn't subscribed id=";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                string2 = "MediaBrowserCompat";
                Log.d((String)string2, (String)object);
            }
            return;
        }
        if ((object = ((MediaBrowserCompat$Subscription)object).getCallback(bundle)) != null) {
            messenger = null;
            if (bundle == null) {
                if (object2 == null) {
                    ((MediaBrowserCompat$SubscriptionCallback)object).onError(string2);
                } else {
                    this.mNotifyChildrenChangedOptions = bundle2;
                    ((MediaBrowserCompat$SubscriptionCallback)object).onChildrenLoaded(string2, (List)object2);
                    this.mNotifyChildrenChangedOptions = null;
                }
            } else if (object2 == null) {
                ((MediaBrowserCompat$SubscriptionCallback)object).onError(string2, bundle);
            } else {
                this.mNotifyChildrenChangedOptions = bundle2;
                ((MediaBrowserCompat$SubscriptionCallback)object).onChildrenLoaded(string2, (List)object2, bundle);
                this.mNotifyChildrenChangedOptions = null;
            }
        }
    }

    public void onServiceConnected(Messenger messenger, String string2, MediaSessionCompat$Token mediaSessionCompat$Token, Bundle bundle) {
    }

    public void search(String object, Bundle bundle, MediaBrowserCompat$SearchCallback mediaBrowserCompat$SearchCallback) {
        boolean bl2 = this.isConnected();
        if (bl2) {
            Object object2 = this.mServiceBinderWrapper;
            Object object3 = "MediaBrowserCompat";
            if (object2 == null) {
                Log.i((String)object3, (String)"The connected service doesn't support search.");
                object2 = this.mHandler;
                object3 = new MediaBrowserCompat$MediaBrowserImplApi21$4(this, mediaBrowserCompat$SearchCallback, (String)object, bundle);
                object2.post((Runnable)object3);
                return;
            }
            Object object4 = this.mHandler;
            object2 = new MediaBrowserCompat$SearchResultReceiver((String)object, bundle, mediaBrowserCompat$SearchCallback, (Handler)object4);
            object4 = this.mServiceBinderWrapper;
            Object object5 = this.mCallbacksMessenger;
            try {
                ((MediaBrowserCompat$ServiceBinderWrapper)object4).search((String)object, bundle, (ResultReceiver)object2, (Messenger)object5);
            }
            catch (RemoteException remoteException) {
                object4 = new StringBuilder();
                object5 = "Remote error searching items with query: ";
                ((StringBuilder)object4).append((String)object5);
                ((StringBuilder)object4).append((String)object);
                object4 = ((StringBuilder)object4).toString();
                Log.i((String)object3, (String)object4, (Throwable)remoteException);
                MediaBrowserCompat$CallbackHandler mediaBrowserCompat$CallbackHandler = this.mHandler;
                object3 = new MediaBrowserCompat$MediaBrowserImplApi21$5(this, mediaBrowserCompat$SearchCallback, (String)object, bundle);
                mediaBrowserCompat$CallbackHandler.post((Runnable)object3);
            }
            return;
        }
        object = new IllegalStateException("search() called while not connected");
        throw object;
    }

    public void sendCustomAction(String string2, Bundle bundle, MediaBrowserCompat$CustomActionCallback object) {
        boolean bl2 = this.isConnected();
        if (bl2) {
            block7: {
                Object object2;
                Object object3 = this.mServiceBinderWrapper;
                Object object4 = "MediaBrowserCompat";
                if (object3 == null) {
                    object3 = "The connected service doesn't support sendCustomAction.";
                    Log.i((String)object4, (String)object3);
                    if (object != null) {
                        object3 = this.mHandler;
                        object2 = new MediaBrowserCompat$MediaBrowserImplApi21$6(this, (MediaBrowserCompat$CustomActionCallback)object, string2, bundle);
                        object3.post((Runnable)object2);
                    }
                }
                object2 = this.mHandler;
                object3 = new MediaBrowserCompat$CustomActionResultReceiver(string2, bundle, (MediaBrowserCompat$CustomActionCallback)object, (Handler)object2);
                object2 = this.mServiceBinderWrapper;
                Object object5 = this.mCallbacksMessenger;
                try {
                    ((MediaBrowserCompat$ServiceBinderWrapper)object2).sendCustomAction(string2, bundle, (ResultReceiver)object3, (Messenger)object5);
                }
                catch (RemoteException remoteException) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Remote error sending a custom action: action=");
                    ((StringBuilder)object2).append(string2);
                    object5 = ", extras=";
                    ((StringBuilder)object2).append((String)object5);
                    ((StringBuilder)object2).append(bundle);
                    object2 = ((StringBuilder)object2).toString();
                    Log.i((String)object4, (String)object2, (Throwable)remoteException);
                    if (object == null) break block7;
                    MediaBrowserCompat$CallbackHandler mediaBrowserCompat$CallbackHandler = this.mHandler;
                    object4 = new MediaBrowserCompat$MediaBrowserImplApi21$7(this, (MediaBrowserCompat$CustomActionCallback)object, string2, bundle);
                    mediaBrowserCompat$CallbackHandler.post((Runnable)object4);
                }
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot send a custom action (");
        stringBuilder.append(string2);
        stringBuilder.append(") with extras ");
        stringBuilder.append(bundle);
        stringBuilder.append(" because the browser is not connected to the service.");
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public void subscribe(String string2, Bundle object, MediaBrowserCompat$SubscriptionCallback object2) {
        ArrayMap arrayMap;
        Object object3 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(string2);
        if (object3 == null) {
            object3 = new MediaBrowserCompat$Subscription();
            arrayMap = this.mSubscriptions;
            arrayMap.put(string2, object3);
        }
        ((MediaBrowserCompat$SubscriptionCallback)object2).setSubscription((MediaBrowserCompat$Subscription)object3);
        if (object == null) {
            object = null;
        } else {
            arrayMap = new Bundle((Bundle)object);
            object = arrayMap;
        }
        ((MediaBrowserCompat$Subscription)object3).putCallback((Bundle)object, (MediaBrowserCompat$SubscriptionCallback)object2);
        object3 = this.mServiceBinderWrapper;
        if (object3 == null) {
            object = this.mBrowserFwk;
            object2 = ((MediaBrowserCompat$SubscriptionCallback)object2).mSubscriptionCallbackFwk;
            object.subscribe(string2, (MediaBrowser.SubscriptionCallback)object2);
        } else {
            object2 = ((MediaBrowserCompat$SubscriptionCallback)object2).mToken;
            arrayMap = this.mCallbacksMessenger;
            try {
                ((MediaBrowserCompat$ServiceBinderWrapper)object3).addSubscription(string2, (IBinder)object2, (Bundle)object, (Messenger)arrayMap);
            }
            catch (RemoteException remoteException) {
                object = new StringBuilder();
                object2 = "Remote error subscribing media item: ";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                string2 = ((StringBuilder)object).toString();
                object = "MediaBrowserCompat";
                Log.i((String)object, (String)string2);
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unsubscribe(String var1_1, MediaBrowserCompat$SubscriptionCallback var2_2) {
        block7: {
            block8: {
                block9: {
                    block10: {
                        var3_3 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(var1_1);
                        if (var3_3 == null) {
                            return;
                        }
                        var4_4 = this.mServiceBinderWrapper;
                        if (var4_4 != null) break block9;
                        if (var2_2 != null) break block10;
                        var4_4 = this.mBrowserFwk;
                        var4_4.unsubscribe(var1_1);
                        break block7;
                    }
                    var4_4 = var3_3.getCallbacks();
                    var5_5 = var3_3.getOptionsList();
                    for (var6_7 = var4_4.size() + -1; var6_7 >= 0; var6_7 += -1) {
                        var7_9 = var4_4.get(var6_7);
                        if (var7_9 != var2_2) continue;
                        var4_4.remove(var6_7);
                        var5_5.remove(var6_7);
                    }
                    var8_11 = var4_4.size();
                    if (var8_11 != 0) break block7;
                    var4_4 = this.mBrowserFwk;
                    var4_4.unsubscribe(var1_1);
                    break block7;
                }
                if (var2_2 != null) ** GOTO lbl33
                var5_6 = null;
                try {
                    var9_12 = this.mCallbacksMessenger;
                    var4_4.removeSubscription(var1_1, null, var9_12);
                    break block7;
lbl33:
                    // 1 sources

                    var4_4 = var3_3.getCallbacks();
                    var5_6 = var3_3.getOptionsList();
                    var6_8 = var4_4.size() + -1;
lbl36:
                    // 2 sources

                    while (var6_8 >= 0) {
                        var7_10 /* !! */  = var4_4.get(var6_8);
                        if (var7_10 /* !! */  != var2_2) break block8;
                        ** GOTO lbl-1000
                    }
                    break block7;
                }
                catch (RemoteException v0) {
                    var4_4 = new StringBuilder();
                    var4_4.append("removeSubscription failed with RemoteException parentId=");
                    var4_4.append(var1_1);
                    var4_4 = var4_4.toString();
                    var5_6 = "MediaBrowserCompat";
                    Log.d((String)var5_6, (String)var4_4);
                    break block7;
                }
lbl-1000:
                // 1 sources

                {
                    var7_10 /* !! */  = this.mServiceBinderWrapper;
                    var10_13 = var2_2.mToken;
                    var11_14 = this.mCallbacksMessenger;
                    var7_10 /* !! */ .removeSubscription(var1_1, var10_13, var11_14);
                    var4_4.remove(var6_8);
                    var5_6.remove(var6_8);
                }
            }
            var6_8 += -1;
            ** GOTO lbl36
        }
        var12_15 = var3_3.isEmpty();
        if (var12_15 || var2_2 == null) {
            var2_2 = this.mSubscriptions;
            var2_2.remove(var1_1);
        }
    }
}

