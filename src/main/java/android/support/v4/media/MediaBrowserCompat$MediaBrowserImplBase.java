/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat$CallbackHandler;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$CustomActionCallback;
import android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$ItemReceiver;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$1;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$2;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$4;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$5;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$6;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl;
import android.support.v4.media.MediaBrowserCompat$SearchCallback;
import android.support.v4.media.MediaBrowserCompat$SearchResultReceiver;
import android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
import android.support.v4.media.MediaBrowserCompat$Subscription;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.util.List;
import java.util.Map;

public class MediaBrowserCompat$MediaBrowserImplBase
implements MediaBrowserCompat$MediaBrowserImpl,
MediaBrowserCompat$MediaBrowserServiceCallbackImpl {
    public static final int CONNECT_STATE_CONNECTED = 3;
    public static final int CONNECT_STATE_CONNECTING = 2;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 0;
    public static final int CONNECT_STATE_SUSPENDED = 4;
    public final MediaBrowserCompat$ConnectionCallback mCallback;
    public Messenger mCallbacksMessenger;
    public final Context mContext;
    private Bundle mExtras;
    public final MediaBrowserCompat$CallbackHandler mHandler;
    private MediaSessionCompat$Token mMediaSessionToken;
    private Bundle mNotifyChildrenChangedOptions;
    public final Bundle mRootHints;
    private String mRootId;
    public MediaBrowserCompat$ServiceBinderWrapper mServiceBinderWrapper;
    public final ComponentName mServiceComponent;
    public MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection mServiceConnection;
    public int mState;
    private final ArrayMap mSubscriptions;

    public MediaBrowserCompat$MediaBrowserImplBase(Context object, ComponentName componentName, MediaBrowserCompat$ConnectionCallback mediaBrowserCompat$ConnectionCallback, Bundle bundle) {
        int n10;
        Object object2;
        this.mHandler = object2 = new MediaBrowserCompat$CallbackHandler(this);
        this.mSubscriptions = object2;
        this.mState = n10 = 1;
        if (object != null) {
            if (componentName != null) {
                if (mediaBrowserCompat$ConnectionCallback != null) {
                    this.mContext = object;
                    this.mServiceComponent = componentName;
                    this.mCallback = mediaBrowserCompat$ConnectionCallback;
                    if (bundle == null) {
                        object = null;
                    } else {
                        super(bundle);
                    }
                    this.mRootHints = object;
                    return;
                }
                super("connection callback must not be null");
                throw object;
            }
            super("service component must not be null");
            throw object;
        }
        super("context must not be null");
        throw object;
    }

    private static String getStateLabel(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("UNKNOWN/");
                            stringBuilder.append(n10);
                            return stringBuilder.toString();
                        }
                        return "CONNECT_STATE_SUSPENDED";
                    }
                    return "CONNECT_STATE_CONNECTED";
                }
                return "CONNECT_STATE_CONNECTING";
            }
            return "CONNECT_STATE_DISCONNECTED";
        }
        return "CONNECT_STATE_DISCONNECTING";
    }

    private boolean isCurrent(Messenger object, String string2) {
        boolean bl2;
        Messenger messenger = this.mCallbacksMessenger;
        boolean bl3 = true;
        if (messenger == object && (bl2 = this.mState) && bl2 != bl3) {
            return bl3;
        }
        bl2 = this.mState;
        if (bl2 && bl2 != bl3) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" for ");
            string2 = this.mServiceComponent;
            ((StringBuilder)object).append((Object)string2);
            ((StringBuilder)object).append(" with mCallbacksMessenger=");
            string2 = this.mCallbacksMessenger;
            ((StringBuilder)object).append((Object)string2);
            ((StringBuilder)object).append(" this=");
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            string2 = "MediaBrowserCompat";
            Log.i((String)string2, (String)object);
        }
        return false;
    }

    public void connect() {
        int n10;
        int n11 = this.mState;
        if (n11 != 0 && n11 != (n10 = 1)) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("connect() called while neigther disconnecting nor disconnected (state=");
            String string2 = MediaBrowserCompat$MediaBrowserImplBase.getStateLabel(this.mState);
            charSequence.append(string2);
            charSequence.append(")");
            charSequence = charSequence.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
            throw illegalStateException;
        }
        this.mState = 2;
        MediaBrowserCompat$CallbackHandler mediaBrowserCompat$CallbackHandler = this.mHandler;
        MediaBrowserCompat$MediaBrowserImplBase$1 mediaBrowserCompat$MediaBrowserImplBase$1 = new MediaBrowserCompat$MediaBrowserImplBase$1(this);
        mediaBrowserCompat$CallbackHandler.post(mediaBrowserCompat$MediaBrowserImplBase$1);
    }

    public void disconnect() {
        this.mState = 0;
        MediaBrowserCompat$CallbackHandler mediaBrowserCompat$CallbackHandler = this.mHandler;
        MediaBrowserCompat$MediaBrowserImplBase$2 mediaBrowserCompat$MediaBrowserImplBase$2 = new MediaBrowserCompat$MediaBrowserImplBase$2(this);
        mediaBrowserCompat$CallbackHandler.post(mediaBrowserCompat$MediaBrowserImplBase$2);
    }

    public void dump() {
        String string2 = "MediaBrowserCompat";
        Log.d((String)string2, (String)"MediaBrowserCompat...");
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("  mServiceComponent=");
        Object object = this.mServiceComponent;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("  mCallback=");
        object = this.mCallback;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("  mRootHints=");
        object = this.mRootHints;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("  mState=");
        object = MediaBrowserCompat$MediaBrowserImplBase.getStateLabel(this.mState);
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("  mServiceConnection=");
        object = this.mServiceConnection;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("  mServiceBinderWrapper=");
        object = this.mServiceBinderWrapper;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("  mCallbacksMessenger=");
        object = this.mCallbacksMessenger;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("  mRootId=");
        object = this.mRootId;
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("  mMediaSessionToken=");
        object = this.mMediaSessionToken;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)string2, (String)charSequence);
    }

    public void forceCloseConnection() {
        MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection = this.mServiceConnection;
        if (mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection != null) {
            Context context = this.mContext;
            context.unbindService((ServiceConnection)mediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection);
        }
        this.mState = 1;
        this.mServiceConnection = null;
        this.mServiceBinderWrapper = null;
        this.mCallbacksMessenger = null;
        this.mHandler.setCallbacksMessenger(null);
        this.mRootId = null;
        this.mMediaSessionToken = null;
    }

    public Bundle getExtras() {
        boolean bl2 = this.isConnected();
        if (bl2) {
            return this.mExtras;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("getExtras() called while not connected (state=");
        String string2 = MediaBrowserCompat$MediaBrowserImplBase.getStateLabel(this.mState);
        charSequence.append(string2);
        charSequence.append(")");
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public void getItem(String object, MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            if (mediaBrowserCompat$ItemCallback != null) {
                bl2 = this.isConnected();
                Object object2 = "MediaBrowserCompat";
                if (!bl2) {
                    Log.i((String)object2, (String)"Not connected, unable to retrieve the MediaItem.");
                    MediaBrowserCompat$CallbackHandler mediaBrowserCompat$CallbackHandler = this.mHandler;
                    object2 = new MediaBrowserCompat$MediaBrowserImplBase$3(this, mediaBrowserCompat$ItemCallback, (String)object);
                    mediaBrowserCompat$CallbackHandler.post((Runnable)object2);
                    return;
                }
                Object object3 = this.mHandler;
                Object object4 = new MediaBrowserCompat$ItemReceiver((String)object, mediaBrowserCompat$ItemCallback, (Handler)object3);
                object3 = this.mServiceBinderWrapper;
                Messenger messenger = this.mCallbacksMessenger;
                try {
                    ((MediaBrowserCompat$ServiceBinderWrapper)object3).getMediaItem((String)object, (ResultReceiver)object4, messenger);
                }
                catch (RemoteException remoteException) {
                    object4 = new StringBuilder();
                    object3 = "Remote error getting media item: ";
                    ((StringBuilder)object4).append((String)object3);
                    ((StringBuilder)object4).append((String)object);
                    object4 = ((StringBuilder)object4).toString();
                    Log.i((String)object2, (String)object4);
                    object4 = this.mHandler;
                    object2 = new MediaBrowserCompat$MediaBrowserImplBase$4(this, mediaBrowserCompat$ItemCallback, (String)object);
                    object4.post((Runnable)object2);
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
        boolean bl2 = this.isConnected();
        if (bl2) {
            return this.mRootId;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("getRoot() called while not connected(state=");
        String string2 = MediaBrowserCompat$MediaBrowserImplBase.getStateLabel(this.mState);
        charSequence.append(string2);
        charSequence.append(")");
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public ComponentName getServiceComponent() {
        boolean bl2 = this.isConnected();
        if (bl2) {
            return this.mServiceComponent;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("getServiceComponent() called while not connected (state=");
        int n10 = this.mState;
        charSequence.append(n10);
        charSequence.append(")");
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public MediaSessionCompat$Token getSessionToken() {
        boolean bl2 = this.isConnected();
        if (bl2) {
            return this.mMediaSessionToken;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("getSessionToken() called while not connected(state=");
        int n10 = this.mState;
        charSequence.append(n10);
        charSequence.append(")");
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public boolean isConnected() {
        int n10 = this.mState;
        int n11 = 3;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public void onConnectionFailed(Messenger object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onConnectFailed for ");
        Object object2 = this.mServiceComponent;
        charSequence.append(object2);
        charSequence = charSequence.toString();
        object2 = "MediaBrowserCompat";
        Log.e((String)object2, (String)charSequence);
        charSequence = "onConnectFailed";
        int n10 = this.isCurrent((Messenger)object, (String)charSequence);
        if (n10 == 0) {
            return;
        }
        n10 = this.mState;
        int n11 = 2;
        if (n10 != n11) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onConnect from service while mState=");
            charSequence = MediaBrowserCompat$MediaBrowserImplBase.getStateLabel(this.mState);
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append("... ignoring");
            object = ((StringBuilder)object).toString();
            Log.w((String)object2, (String)object);
            return;
        }
        this.forceCloseConnection();
        this.mCallback.onConnectionFailed();
    }

    public void onLoadChildren(Messenger object, String string2, List object2, Bundle bundle, Bundle bundle2) {
        Object object3;
        String string3 = "onLoadChildren";
        boolean bl2 = this.isCurrent((Messenger)object, string3);
        if (!bl2) {
            return;
        }
        bl2 = MediaBrowserCompat.DEBUG;
        string3 = "MediaBrowserCompat";
        if (bl2) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("onLoadChildren for ");
            Object object4 = this.mServiceComponent;
            ((StringBuilder)object3).append(object4);
            object4 = " id=";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(string2);
            object3 = ((StringBuilder)object3).toString();
            Log.d((String)string3, (String)object3);
        }
        if ((object3 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(string2)) == null) {
            if (bl2) {
                object = new StringBuilder();
                object2 = "onLoadChildren for id that isn't subscribed id=";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                Log.d((String)string3, (String)object);
            }
            return;
        }
        object = ((MediaBrowserCompat$Subscription)object3).getCallback(bundle);
        if (object != null) {
            string3 = null;
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

    public void onServiceConnected(Messenger object, String object2, MediaSessionCompat$Token object3, Bundle object4) {
        String string2 = "onConnect";
        int n10 = this.isCurrent((Messenger)object, string2);
        if (n10 == 0) {
            return;
        }
        n10 = this.mState;
        int n11 = 2;
        String string3 = "MediaBrowserCompat";
        if (n10 != n11) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onConnect from service while mState=");
            object2 = MediaBrowserCompat$MediaBrowserImplBase.getStateLabel(this.mState);
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append("... ignoring");
            object = ((StringBuilder)object).toString();
            Log.w((String)string3, (String)object);
            return;
        }
        this.mRootId = object2;
        this.mMediaSessionToken = object3;
        this.mExtras = object4;
        this.mState = 3;
        n10 = (int)(MediaBrowserCompat.DEBUG ? 1 : 0);
        if (n10 != 0) {
            object = "ServiceCallbacks.onConnect...";
            Log.d((String)string3, (String)object);
            this.dump();
        }
        object = this.mCallback;
        ((MediaBrowserCompat$ConnectionCallback)object).onConnected();
        object = this.mSubscriptions;
        object = ((ArrayMap)object).entrySet();
        try {
            object = object.iterator();
        }
        catch (RemoteException remoteException) {
            object = "addSubscription failed with RemoteException.";
            Log.d((String)string3, (String)object);
        }
        block22: while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            object2 = object.next();
            object2 = (Map.Entry)object2;
            object3 = object2.getKey();
            object3 = (String)object3;
            object2 = object2.getValue();
            object2 = (MediaBrowserCompat$Subscription)object2;
            object4 = ((MediaBrowserCompat$Subscription)object2).getCallbacks();
            object2 = ((MediaBrowserCompat$Subscription)object2).getOptionsList();
            n11 = 0;
            string2 = null;
            while (true) {
                int n12 = object4.size();
                if (n11 >= n12) continue block22;
                MediaBrowserCompat$ServiceBinderWrapper mediaBrowserCompat$ServiceBinderWrapper = this.mServiceBinderWrapper;
                Object object5 = object4.get(n11);
                object5 = (MediaBrowserCompat$SubscriptionCallback)object5;
                object5 = ((MediaBrowserCompat$SubscriptionCallback)object5).mToken;
                Object object6 = object2.get(n11);
                object6 = (Bundle)object6;
                Messenger messenger = this.mCallbacksMessenger;
                mediaBrowserCompat$ServiceBinderWrapper.addSubscription((String)object3, (IBinder)object5, (Bundle)object6, messenger);
                ++n11;
                continue;
                break;
            }
            break;
        }
    }

    public void search(String object, Bundle object2, MediaBrowserCompat$SearchCallback object3) {
        boolean bl2 = this.isConnected();
        if (bl2) {
            Object object4 = this.mHandler;
            MediaBrowserCompat$SearchResultReceiver mediaBrowserCompat$SearchResultReceiver = new MediaBrowserCompat$SearchResultReceiver((String)object, (Bundle)object2, (MediaBrowserCompat$SearchCallback)object3, (Handler)object4);
            object4 = this.mServiceBinderWrapper;
            Object object5 = this.mCallbacksMessenger;
            try {
                ((MediaBrowserCompat$ServiceBinderWrapper)object4).search((String)object, (Bundle)object2, mediaBrowserCompat$SearchResultReceiver, (Messenger)object5);
            }
            catch (RemoteException remoteException) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Remote error searching items with query: ");
                ((StringBuilder)object4).append((String)object);
                object4 = ((StringBuilder)object4).toString();
                object5 = "MediaBrowserCompat";
                Log.i((String)object5, (String)object4, (Throwable)remoteException);
                MediaBrowserCompat$CallbackHandler mediaBrowserCompat$CallbackHandler = this.mHandler;
                object4 = new MediaBrowserCompat$MediaBrowserImplBase$5(this, (MediaBrowserCompat$SearchCallback)object3, (String)object, (Bundle)object2);
                mediaBrowserCompat$CallbackHandler.post((Runnable)object4);
            }
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("search() called while not connected (state=");
        object3 = MediaBrowserCompat$MediaBrowserImplBase.getStateLabel(this.mState);
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(")");
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public void sendCustomAction(String string2, Bundle bundle, MediaBrowserCompat$CustomActionCallback object) {
        boolean bl2 = this.isConnected();
        if (bl2) {
            block5: {
                Object object2 = this.mHandler;
                MediaBrowserCompat$CustomActionResultReceiver mediaBrowserCompat$CustomActionResultReceiver = new MediaBrowserCompat$CustomActionResultReceiver(string2, bundle, (MediaBrowserCompat$CustomActionCallback)object, (Handler)object2);
                object2 = this.mServiceBinderWrapper;
                Object object3 = this.mCallbacksMessenger;
                try {
                    ((MediaBrowserCompat$ServiceBinderWrapper)object2).sendCustomAction(string2, bundle, mediaBrowserCompat$CustomActionResultReceiver, (Messenger)object3);
                }
                catch (RemoteException remoteException) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Remote error sending a custom action: action=");
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(", extras=");
                    ((StringBuilder)object2).append(bundle);
                    object2 = ((StringBuilder)object2).toString();
                    object3 = "MediaBrowserCompat";
                    Log.i((String)object3, (String)object2, (Throwable)remoteException);
                    if (object == null) break block5;
                    MediaBrowserCompat$CallbackHandler mediaBrowserCompat$CallbackHandler = this.mHandler;
                    object2 = new MediaBrowserCompat$MediaBrowserImplBase$6(this, (MediaBrowserCompat$CustomActionCallback)object, string2, bundle);
                    mediaBrowserCompat$CallbackHandler.post((Runnable)object2);
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
        Object object3;
        Object object4 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(string2);
        if (object4 == null) {
            object4 = new MediaBrowserCompat$Subscription();
            object3 = this.mSubscriptions;
            ((SimpleArrayMap)object3).put(string2, object4);
        }
        object = object == null ? null : (object3 = new Bundle((Bundle)object));
        ((MediaBrowserCompat$Subscription)object4).putCallback((Bundle)object, (MediaBrowserCompat$SubscriptionCallback)object2);
        boolean bl2 = this.isConnected();
        if (bl2) {
            object4 = this.mServiceBinderWrapper;
            object2 = ((MediaBrowserCompat$SubscriptionCallback)object2).mToken;
            object3 = this.mCallbacksMessenger;
            try {
                ((MediaBrowserCompat$ServiceBinderWrapper)object4).addSubscription(string2, (IBinder)object2, (Bundle)object, (Messenger)object3);
            }
            catch (RemoteException remoteException) {
                object = new StringBuilder();
                object2 = "addSubscription failed with RemoteException parentId=";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                string2 = ((StringBuilder)object).toString();
                object = "MediaBrowserCompat";
                Log.d((String)object, (String)string2);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void unsubscribe(String var1_1, MediaBrowserCompat$SubscriptionCallback var2_2) {
        block18: {
            var3_3 = (MediaBrowserCompat$Subscription)this.mSubscriptions.get(var1_1);
            if (var3_3 == null) {
                return;
            }
            if (var2_2 != null) ** GOTO lbl16
            var4_4 = this.isConnected();
            if (!var4_4) break block18;
            var5_5 = this.mServiceBinderWrapper;
            var6_6 = null;
            var7_7 = this.mCallbacksMessenger;
            var5_5.removeSubscription(var1_1, null, var7_7);
            break block18;
lbl16:
            // 1 sources

            var5_5 = var3_3.getCallbacks();
            var6_6 = var3_3.getOptionsList();
            ** try [egrp 5[TRYBLOCK] [6 : 71->78)] { 
lbl20:
            // 3 sources

            for (var8_8 = var5_5.size() + -1; var8_8 >= 0; var8_8 += -1) {
                block19: {
                    var9_9 = var5_5.get(var8_8);
                    if (var9_9 != var2_2) continue;
                    var10_10 = this.isConnected();
                    if (!var10_10) break block19;
                    var9_9 = this.mServiceBinderWrapper;
                    var11_11 = var2_2.mToken;
                    var12_12 = this.mCallbacksMessenger;
                    var9_9.removeSubscription(var1_1, var11_11, var12_12);
                }
                var5_5.remove(var8_8);
                try {
                    var6_6.remove(var8_8);
                }
lbl43:
                // 14 sources

                catch (RemoteException v0) {
                    var5_5 = new StringBuilder();
                    var5_5.append("removeSubscription failed with RemoteException parentId=");
                    var5_5.append(var1_1);
                    var5_5 = var5_5.toString();
                    var6_6 = "MediaBrowserCompat";
                    Log.d((String)var6_6, (String)var5_5);
                    break;
                }
                continue;
            }
        }
        if ((var13_13 = var3_3.isEmpty()) || var2_2 == null) {
            var2_2 = this.mSubscriptions;
            var2_2.remove(var1_1);
        }
    }
}

