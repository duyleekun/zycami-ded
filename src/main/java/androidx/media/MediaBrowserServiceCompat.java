/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.util.Log
 */
package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserServiceCompat$1;
import androidx.media.MediaBrowserServiceCompat$2;
import androidx.media.MediaBrowserServiceCompat$3;
import androidx.media.MediaBrowserServiceCompat$4;
import androidx.media.MediaBrowserServiceCompat$BrowserRoot;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi28;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase;
import androidx.media.MediaBrowserServiceCompat$Result;
import androidx.media.MediaBrowserServiceCompat$ServiceHandler;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat
extends Service {
    public static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-5f;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    public static final int RESULT_ERROR = 255;
    public static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    public static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    public static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    public static final String TAG = "MBServiceCompat";
    public final MediaBrowserServiceCompat$ConnectionRecord mConnectionFromFwk;
    public final ArrayMap mConnections;
    public MediaBrowserServiceCompat$ConnectionRecord mCurConnection;
    public final MediaBrowserServiceCompat$ServiceHandler mHandler;
    private MediaBrowserServiceCompat$MediaBrowserServiceImpl mImpl;
    public final ArrayList mPendingConnections;
    public MediaSessionCompat$Token mSession;

    static {
        DEBUG = Log.isLoggable((String)TAG, (int)3);
    }

    public MediaBrowserServiceCompat() {
        MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord;
        Object object = mediaBrowserServiceCompat$ConnectionRecord;
        this.mConnectionFromFwk = mediaBrowserServiceCompat$ConnectionRecord = new MediaBrowserServiceCompat$ConnectionRecord(this, "android.media.session.MediaController", -1, -1, null, null);
        object = new ArrayList();
        this.mPendingConnections = object;
        this.mConnections = object = new ArrayMap();
        object = new MediaBrowserServiceCompat$ServiceHandler(this);
        this.mHandler = object;
    }

    public void addSubscription(String string2, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, IBinder iBinder, Bundle bundle) {
        boolean bl2;
        ArrayList<Object> arrayList = (ArrayList<Object>)mediaBrowserServiceCompat$ConnectionRecord.subscriptions.get(string2);
        if (arrayList == null) {
            arrayList = new ArrayList<Object>();
        }
        Object object = arrayList.iterator();
        while (bl2 = object.hasNext()) {
            Pair pair = (Pair)object.next();
            Object object2 = pair.first;
            if (iBinder != object2 || !(bl2 = MediaBrowserCompatUtils.areSameOptions(bundle, (Bundle)(pair = (Bundle)pair.second)))) continue;
            return;
        }
        object = new Pair(iBinder, bundle);
        arrayList.add(object);
        mediaBrowserServiceCompat$ConnectionRecord.subscriptions.put(string2, arrayList);
        this.performLoadChildren(string2, mediaBrowserServiceCompat$ConnectionRecord, bundle, null);
        this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
        this.onSubscribe(string2, bundle);
        this.mCurConnection = null;
    }

    public List applyOptions(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        String string2 = "android.media.browse.extra.PAGE";
        int n10 = -1;
        int n11 = bundle.getInt(string2, n10);
        String string3 = "android.media.browse.extra.PAGE_SIZE";
        int n12 = bundle.getInt(string3, n10);
        if (n11 == n10 && n12 == n10) {
            return list;
        }
        n10 = n12 * n11;
        int n13 = n10 + n12;
        if (n11 >= 0 && n12 >= (n11 = 1) && n10 < (n12 = list.size())) {
            n12 = list.size();
            if (n13 > n12) {
                n13 = list.size();
            }
            return list.subList(n10, n13);
        }
        return Collections.emptyList();
    }

    public void attachToBaseContext(Context context) {
        this.attachBaseContext(context);
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public final MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    public MediaSessionCompat$Token getSessionToken() {
        return this.mSession;
    }

    public boolean isValidPackage(String string2, int n10) {
        if (string2 == null) {
            return false;
        }
        PackageManager packageManager = this.getPackageManager();
        for (String string3 : packageManager.getPackagesForUid(n10)) {
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo object, String string2, Bundle bundle) {
        if (object != null) {
            if (string2 != null) {
                if (bundle != null) {
                    this.mImpl.notifyChildrenChanged((MediaSessionManager$RemoteUserInfo)object, string2, bundle);
                    return;
                }
                object = new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
                throw object;
            }
            object = new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
            throw object;
        }
        object = new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        throw object;
    }

    public void notifyChildrenChanged(String object) {
        if (object != null) {
            this.mImpl.notifyChildrenChanged((String)object, null);
            return;
        }
        object = new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        throw object;
    }

    public void notifyChildrenChanged(String object, Bundle bundle) {
        if (object != null) {
            if (bundle != null) {
                this.mImpl.notifyChildrenChanged((String)object, bundle);
                return;
            }
            object = new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
            throw object;
        }
        object = new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        throw object;
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            MediaBrowserServiceCompat$MediaBrowserServiceImplApi28 mediaBrowserServiceCompat$MediaBrowserServiceImplApi28 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi28(this);
            this.mImpl = mediaBrowserServiceCompat$MediaBrowserServiceImplApi28;
        } else {
            n11 = 26;
            if (n10 >= n11) {
                MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 mediaBrowserServiceCompat$MediaBrowserServiceImplApi26 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi26(this);
                this.mImpl = mediaBrowserServiceCompat$MediaBrowserServiceImplApi26;
            } else {
                n11 = 23;
                if (n10 >= n11) {
                    MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 mediaBrowserServiceCompat$MediaBrowserServiceImplApi23 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi23(this);
                    this.mImpl = mediaBrowserServiceCompat$MediaBrowserServiceImplApi23;
                } else {
                    n11 = 21;
                    if (n10 >= n11) {
                        MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21 = new MediaBrowserServiceCompat$MediaBrowserServiceImplApi21(this);
                        this.mImpl = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
                    } else {
                        MediaBrowserServiceCompat$MediaBrowserServiceImplBase mediaBrowserServiceCompat$MediaBrowserServiceImplBase = new MediaBrowserServiceCompat$MediaBrowserServiceImplBase(this);
                        this.mImpl = mediaBrowserServiceCompat$MediaBrowserServiceImplBase;
                    }
                }
            }
        }
        this.mImpl.onCreate();
    }

    public void onCustomAction(String string2, Bundle bundle, MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result) {
        mediaBrowserServiceCompat$Result.sendError(null);
    }

    public abstract MediaBrowserServiceCompat$BrowserRoot onGetRoot(String var1, int var2, Bundle var3);

    public abstract void onLoadChildren(String var1, MediaBrowserServiceCompat$Result var2);

    public void onLoadChildren(String string2, MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result, Bundle bundle) {
        mediaBrowserServiceCompat$Result.setFlags(1);
        this.onLoadChildren(string2, mediaBrowserServiceCompat$Result);
    }

    public void onLoadItem(String string2, MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result) {
        mediaBrowserServiceCompat$Result.setFlags(2);
        mediaBrowserServiceCompat$Result.sendResult(null);
    }

    public void onSearch(String string2, Bundle bundle, MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result) {
        mediaBrowserServiceCompat$Result.setFlags(4);
        mediaBrowserServiceCompat$Result.sendResult(null);
    }

    public void onSubscribe(String string2, Bundle bundle) {
    }

    public void onUnsubscribe(String string2) {
    }

    public void performCustomAction(String string2, Bundle bundle, MediaBrowserServiceCompat$ConnectionRecord object, ResultReceiver object2) {
        MediaBrowserServiceCompat$4 mediaBrowserServiceCompat$4 = new MediaBrowserServiceCompat$4(this, string2, (ResultReceiver)object2);
        this.mCurConnection = object;
        this.onCustomAction(string2, bundle, mediaBrowserServiceCompat$4);
        object = null;
        this.mCurConnection = null;
        boolean bl2 = mediaBrowserServiceCompat$4.isDone();
        if (bl2) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" extras=");
        ((StringBuilder)object2).append(bundle);
        string2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public void performLoadChildren(String string2, MediaBrowserServiceCompat$ConnectionRecord object, Bundle object2, Bundle object3) {
        MediaBrowserServiceCompat$1 mediaBrowserServiceCompat$1 = new MediaBrowserServiceCompat$1(this, string2, (MediaBrowserServiceCompat$ConnectionRecord)object, string2, (Bundle)object2, (Bundle)object3);
        this.mCurConnection = object;
        if (object2 == null) {
            this.onLoadChildren(string2, mediaBrowserServiceCompat$1);
        } else {
            this.onLoadChildren(string2, mediaBrowserServiceCompat$1, (Bundle)object2);
        }
        object2 = null;
        this.mCurConnection = null;
        boolean bl2 = mediaBrowserServiceCompat$1.isDone();
        if (bl2) {
            return;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("onLoadChildren must call detach() or sendResult() before returning for package=");
        object = ((MediaBrowserServiceCompat$ConnectionRecord)object).pkg;
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append(" id=");
        ((StringBuilder)object3).append(string2);
        string2 = ((StringBuilder)object3).toString();
        object2 = new IllegalStateException(string2);
        throw object2;
    }

    public void performLoadItem(String string2, MediaBrowserServiceCompat$ConnectionRecord object, ResultReceiver object2) {
        MediaBrowserServiceCompat$2 mediaBrowserServiceCompat$2 = new MediaBrowserServiceCompat$2(this, string2, (ResultReceiver)object2);
        this.mCurConnection = object;
        this.onLoadItem(string2, mediaBrowserServiceCompat$2);
        object = null;
        this.mCurConnection = null;
        boolean bl2 = mediaBrowserServiceCompat$2.isDone();
        if (bl2) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("onLoadItem must call detach() or sendResult() before returning for id=");
        ((StringBuilder)object2).append(string2);
        string2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public void performSearch(String string2, Bundle object, MediaBrowserServiceCompat$ConnectionRecord object2, ResultReceiver resultReceiver) {
        MediaBrowserServiceCompat$3 mediaBrowserServiceCompat$3 = new MediaBrowserServiceCompat$3(this, string2, resultReceiver);
        this.mCurConnection = object2;
        this.onSearch(string2, (Bundle)object, mediaBrowserServiceCompat$3);
        object = null;
        this.mCurConnection = null;
        boolean bl2 = mediaBrowserServiceCompat$3.isDone();
        if (bl2) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("onSearch must call detach() or sendResult() before returning for query=");
        ((StringBuilder)object2).append(string2);
        string2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public boolean removeSubscription(String string2, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, IBinder object) {
        boolean bl2;
        block19: {
            boolean bl3 = true;
            bl2 = false;
            if (object == null) {
                object = mediaBrowserServiceCompat$ConnectionRecord.subscriptions;
                object = ((HashMap)object).remove(string2);
                if (object == null) {
                    bl3 = false;
                }
                this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
                this.onUnsubscribe(string2);
                this.mCurConnection = null;
                return bl3;
            }
            Object object2 = mediaBrowserServiceCompat$ConnectionRecord.subscriptions;
            object2 = ((HashMap)object2).get(string2);
            object2 = (List)object2;
            if (object2 == null) break block19;
            Iterator iterator2 = object2.iterator();
            while (true) {
                boolean bl4 = iterator2.hasNext();
                if (!bl4) break;
                Object object3 = iterator2.next();
                object3 = (Pair)object3;
                object3 = ((Pair)object3).first;
                if (object != object3) continue;
                iterator2.remove();
                bl2 = bl3;
                continue;
                break;
            }
            int n10 = object2.size();
            if (n10 != 0) break block19;
            object = mediaBrowserServiceCompat$ConnectionRecord.subscriptions;
            ((HashMap)object).remove(string2);
        }
        return bl2;
        finally {
            this.mCurConnection = mediaBrowserServiceCompat$ConnectionRecord;
            this.onUnsubscribe(string2);
            this.mCurConnection = null;
        }
    }

    public void setSessionToken(MediaSessionCompat$Token object) {
        if (object != null) {
            MediaSessionCompat$Token mediaSessionCompat$Token = this.mSession;
            if (mediaSessionCompat$Token == null) {
                this.mSession = object;
                this.mImpl.setSessionToken((MediaSessionCompat$Token)object);
                return;
            }
            object = new IllegalStateException("The session token has already been set");
            throw object;
        }
        object = new IllegalArgumentException("Session token may not be null");
        throw object;
    }
}

