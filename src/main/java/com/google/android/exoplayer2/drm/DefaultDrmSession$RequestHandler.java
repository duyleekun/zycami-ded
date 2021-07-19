/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  android.util.Pair
 */
package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSession$RequestTask;
import com.google.android.exoplayer2.drm.DefaultDrmSession$UnexpectedDrmSessionException;
import com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest;
import com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest;
import com.google.android.exoplayer2.drm.MediaDrmCallbackException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class DefaultDrmSession$RequestHandler
extends Handler {
    private boolean isReleased;
    public final /* synthetic */ DefaultDrmSession this$0;

    public DefaultDrmSession$RequestHandler(DefaultDrmSession defaultDrmSession, Looper looper) {
        this.this$0 = defaultDrmSession;
        super(looper);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean maybeRetryRequest(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
        int n10;
        DefaultDrmSession$RequestHandler defaultDrmSession$RequestHandler = this;
        Message message2 = message;
        Object object = mediaDrmCallbackException;
        DefaultDrmSession$RequestTask defaultDrmSession$RequestTask = (DefaultDrmSession$RequestTask)message.obj;
        int n11 = defaultDrmSession$RequestTask.allowRetry;
        if (n11 == 0) {
            return false;
        }
        n11 = defaultDrmSession$RequestTask.errorCount;
        int n12 = 1;
        defaultDrmSession$RequestTask.errorCount = n11 += n12;
        Object object2 = DefaultDrmSession.access$200(this.this$0);
        int n13 = object2.getMinimumLoadableRetryCount(n10 = 3);
        if (n11 > n13) {
            return false;
        }
        long l10 = defaultDrmSession$RequestTask.taskId;
        DataSpec dataSpec = mediaDrmCallbackException.dataSpec;
        Uri uri = mediaDrmCallbackException.uriAfterRedirects;
        Map map = mediaDrmCallbackException.responseHeaders;
        long l11 = SystemClock.elapsedRealtime();
        long l12 = SystemClock.elapsedRealtime();
        long l13 = defaultDrmSession$RequestTask.startTimeMs;
        l12 -= l13;
        l13 = mediaDrmCallbackException.bytesLoaded;
        LoadEventInfo loadEventInfo = new LoadEventInfo(l10, dataSpec, uri, map, l11, l12, l13);
        MediaLoadData mediaLoadData = new MediaLoadData(n10);
        object2 = mediaDrmCallbackException.getCause();
        n13 = object2 instanceof IOException;
        if (n13 != 0) {
            object = (IOException)mediaDrmCallbackException.getCause();
        } else {
            object = mediaDrmCallbackException.getCause();
            object = object2 = new DefaultDrmSession$UnexpectedDrmSessionException((Throwable)object);
        }
        object2 = DefaultDrmSession.access$200(defaultDrmSession$RequestHandler.this$0);
        int n14 = defaultDrmSession$RequestTask.errorCount;
        LoadErrorHandlingPolicy$LoadErrorInfo loadErrorHandlingPolicy$LoadErrorInfo = new LoadErrorHandlingPolicy$LoadErrorInfo(loadEventInfo, mediaLoadData, (IOException)object, n14);
        long l14 = object2.getRetryDelayMsFor(loadErrorHandlingPolicy$LoadErrorInfo);
        l13 = -9223372036854775807L;
        n11 = (int)(l14 == l13 ? 0 : (l14 < l13 ? -1 : 1));
        if (n11 == 0) {
            return false;
        }
        synchronized (this) {
            n11 = (int)(defaultDrmSession$RequestHandler.isReleased ? 1 : 0);
            if (n11 == 0) {
                message2 = Message.obtain((Message)message);
                defaultDrmSession$RequestHandler.sendMessageDelayed(message2, l14);
                return true;
            }
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message message) {
        Object object;
        Object object2;
        int n10;
        Object object3;
        block9: {
            object3 = (DefaultDrmSession$RequestTask)message.obj;
            try {
                int n11 = message.what;
                if (n11 != 0) {
                    n10 = 1;
                    if (n11 != n10) {
                        RuntimeException runtimeException = new RuntimeException();
                        throw runtimeException;
                    }
                    object2 = this.this$0;
                    object = ((DefaultDrmSession)object2).callback;
                    object2 = ((DefaultDrmSession)object2).uuid;
                    Object object4 = ((DefaultDrmSession$RequestTask)object3).request;
                    object4 = (ExoMediaDrm$KeyRequest)object4;
                    object2 = object.executeKeyRequest((UUID)object2, (ExoMediaDrm$KeyRequest)object4);
                } else {
                    object2 = this.this$0;
                    object = ((DefaultDrmSession)object2).callback;
                    object2 = ((DefaultDrmSession)object2).uuid;
                    Object object5 = ((DefaultDrmSession$RequestTask)object3).request;
                    object5 = (ExoMediaDrm$ProvisionRequest)object5;
                    object2 = object.executeProvisionRequest((UUID)object2, (ExoMediaDrm$ProvisionRequest)object5);
                }
            }
            catch (Exception exception) {
                object = "DefaultDrmSession";
                String string2 = "Key/provisioning request produced an unexpected exception. Not retrying.";
                Log.w((String)object, string2, exception);
            }
            catch (MediaDrmCallbackException mediaDrmCallbackException) {
                n10 = this.maybeRetryRequest(message, mediaDrmCallbackException);
                if (n10 == 0) break block9;
                return;
            }
        }
        object = DefaultDrmSession.access$200(this.this$0);
        long l10 = ((DefaultDrmSession$RequestTask)object3).taskId;
        object.onLoadTaskConcluded(l10);
        synchronized (this) {
            n10 = (int)(this.isReleased ? 1 : 0);
            if (n10 == 0) {
                object = this.this$0;
                object = ((DefaultDrmSession)object).responseHandler;
                int n12 = message.what;
                object3 = ((DefaultDrmSession$RequestTask)object3).request;
                object3 = Pair.create((Object)object3, (Object)object2);
                message = object.obtainMessage(n12, object3);
                message.sendToTarget();
            }
            return;
        }
    }

    public void post(int n10, Object object, boolean bl2) {
        long l10 = LoadEventInfo.getNewId();
        long l11 = SystemClock.elapsedRealtime();
        DefaultDrmSession$RequestTask defaultDrmSession$RequestTask = new DefaultDrmSession$RequestTask(l10, bl2, l11, object);
        this.obtainMessage(n10, defaultDrmSession$RequestTask).sendToTarget();
    }

    public void release() {
        synchronized (this) {
            boolean bl2 = false;
            Object var2_2 = null;
            this.removeCallbacksAndMessages(null);
            bl2 = true;
            this.isReleased = bl2;
            return;
        }
    }
}

