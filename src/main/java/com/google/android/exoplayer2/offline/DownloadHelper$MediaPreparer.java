/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Message
 */
package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadHelper$LiveContentUnsupportedException;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.k0.d;
import java.io.IOException;
import java.util.ArrayList;

public final class DownloadHelper$MediaPreparer
implements MediaSource$MediaSourceCaller,
MediaPeriod$Callback,
Handler.Callback {
    private static final int DOWNLOAD_HELPER_CALLBACK_MESSAGE_FAILED = 1;
    private static final int DOWNLOAD_HELPER_CALLBACK_MESSAGE_PREPARED = 0;
    private static final int MESSAGE_CHECK_FOR_FAILURE = 1;
    private static final int MESSAGE_CONTINUE_LOADING = 2;
    private static final int MESSAGE_PREPARE_SOURCE = 0;
    private static final int MESSAGE_RELEASE = 3;
    private final Allocator allocator;
    private final DownloadHelper downloadHelper;
    private final Handler downloadHelperHandler;
    public MediaPeriod[] mediaPeriods;
    private final MediaSource mediaSource;
    private final Handler mediaSourceHandler;
    private final HandlerThread mediaSourceThread;
    private final ArrayList pendingMediaPeriods;
    private boolean released;
    public Timeline timeline;

    public DownloadHelper$MediaPreparer(MediaSource object, DownloadHelper downloadHelper) {
        this.mediaSource = object;
        this.downloadHelper = downloadHelper;
        this.allocator = object = new DefaultAllocator(true, 65536);
        object = new ArrayList();
        this.pendingMediaPeriods = object;
        object = new d(this);
        object = Util.createHandlerForCurrentOrMainLooper((Handler.Callback)object);
        this.downloadHelperHandler = object;
        object = new HandlerThread("ExoPlayer:DownloadHelper");
        this.mediaSourceThread = object;
        object.start();
        object = Util.createHandler(object.getLooper(), this);
        this.mediaSourceHandler = object;
        object.sendEmptyMessage(0);
    }

    public static /* synthetic */ boolean a(DownloadHelper$MediaPreparer downloadHelper$MediaPreparer, Message message) {
        return downloadHelper$MediaPreparer.handleDownloadHelperCallbackMessage(message);
    }

    private boolean handleDownloadHelperCallbackMessage(Message object) {
        boolean bl2 = this.released;
        if (bl2) {
            return false;
        }
        boolean bl3 = ((Message)object).what;
        boolean bl4 = true;
        if (bl3) {
            if (bl3 != bl4) {
                return false;
            }
            this.release();
            DownloadHelper downloadHelper = this.downloadHelper;
            object = (IOException)Util.castNonNull(((Message)object).obj);
            DownloadHelper.access$300(downloadHelper, (IOException)object);
            return bl4;
        }
        DownloadHelper.access$200(this.downloadHelper);
        return bl4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 == 0) {
            this.mediaSource.prepareSource(this, null);
            this.mediaSourceHandler.sendEmptyMessage(n11);
            return n11 != 0;
        }
        if (n10 != n11) {
            int n12 = 2;
            if (n10 == n12) {
                ArrayList arrayList = this.pendingMediaPeriods;
                object = (MediaPeriod)((Message)object).obj;
                n10 = arrayList.contains(object);
                if (n10 == 0) return n11 != 0;
                long l10 = 0L;
                object.continueLoading(l10);
                return n11 != 0;
            }
            int n13 = 3;
            if (n10 != n13) {
                return false;
            }
            object = this.mediaPeriods;
            if (object != null) {
                for (Object object2 : object) {
                    MediaSource mediaSource = this.mediaSource;
                    mediaSource.releasePeriod((MediaPeriod)object2);
                }
            }
            this.mediaSource.releaseSource(this);
            this.mediaSourceHandler.removeCallbacksAndMessages(null);
            this.mediaSourceThread.quit();
            return n11 != 0;
        }
        try {
            object = this.mediaPeriods;
            if (object == null) {
                object = this.mediaSource;
                object.maybeThrowSourceInfoRefreshError();
            } else {
                int n14;
                int n15;
                while (n15 < (n14 = ((ArrayList)(object = this.pendingMediaPeriods)).size())) {
                    object = this.pendingMediaPeriods;
                    object = ((ArrayList)object).get(n15);
                    object = (MediaPeriod)object;
                    object.maybeThrowPrepareError();
                    ++n15;
                }
            }
            object = this.mediaSourceHandler;
            long l11 = 100;
            object.sendEmptyMessageDelayed(n11, l11);
            return n11 != 0;
        }
        catch (IOException iOException) {
            Handler handler = this.downloadHelperHandler;
            Message message = handler.obtainMessage(n11, (Object)iOException);
            message.sendToTarget();
        }
        return n11 != 0;
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ArrayList arrayList = this.pendingMediaPeriods;
        boolean bl2 = arrayList.contains(mediaPeriod);
        if (bl2) {
            arrayList = this.mediaSourceHandler;
            int n10 = 2;
            mediaPeriod = arrayList.obtainMessage(n10, mediaPeriod);
            mediaPeriod.sendToTarget();
        }
    }

    public void onPrepared(MediaPeriod object) {
        ArrayList arrayList = this.pendingMediaPeriods;
        arrayList.remove(object);
        object = this.pendingMediaPeriods;
        boolean bl2 = ((ArrayList)object).isEmpty();
        if (bl2) {
            this.mediaSourceHandler.removeMessages(1);
            object = this.downloadHelperHandler;
            arrayList = null;
            object.sendEmptyMessage(0);
        }
    }

    public void onSourceInfoRefreshed(MediaSource object, Timeline object2) {
        long l10;
        Object object3;
        object = this.timeline;
        if (object != null) {
            return;
        }
        object = new Timeline$Window();
        int n10 = 0;
        int n11 = (object = ((Timeline)object2).getWindow(0, (Timeline$Window)object)).isLive();
        if (n11 != 0) {
            object = this.downloadHelperHandler;
            object2 = new DownloadHelper$LiveContentUnsupportedException();
            object.obtainMessage(1, object2).sendToTarget();
            return;
        }
        this.timeline = object2;
        object = new MediaPeriod[((Timeline)object2).getPeriodCount()];
        this.mediaPeriods = object;
        n11 = 0;
        object = null;
        while (true) {
            object3 = this.mediaPeriods;
            int n12 = ((MediaPeriod[])object3).length;
            l10 = 0L;
            if (n11 >= n12) break;
            object3 = this.mediaSource;
            Object object4 = ((Timeline)object2).getUidOfPeriod(n11);
            Object object5 = new MediaSource$MediaPeriodId(object4);
            object4 = this.allocator;
            this.mediaPeriods[n11] = object3 = object3.createPeriod((MediaSource$MediaPeriodId)object5, (Allocator)object4, l10);
            object5 = this.pendingMediaPeriods;
            ((ArrayList)object5).add(object3);
            ++n11;
        }
        n11 = ((MediaPeriod[])object3).length;
        while (n10 < n11) {
            object2 = object3[n10];
            object2.prepare(this, l10);
            ++n10;
        }
    }

    public void release() {
        boolean bl2 = this.released;
        if (bl2) {
            return;
        }
        this.released = true;
        this.mediaSourceHandler.sendEmptyMessage(3);
    }
}

