/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.DefaultDownloadIndex;
import com.google.android.exoplayer2.offline.DefaultDownloaderFactory;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadIndex;
import com.google.android.exoplayer2.offline.DownloadManager$DownloadUpdate;
import com.google.android.exoplayer2.offline.DownloadManager$InternalHandler;
import com.google.android.exoplayer2.offline.DownloadManager$Listener;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.DownloaderFactory;
import com.google.android.exoplayer2.offline.WritableDownloadIndex;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher$Listener;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$Factory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.k0.h;
import d.h.a.a.k0.j;
import d.h.a.a.k0.m;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

public final class DownloadManager {
    public static final int DEFAULT_MAX_PARALLEL_DOWNLOADS = 3;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    public static final Requirements DEFAULT_REQUIREMENTS;
    private static final int MSG_ADD_DOWNLOAD = 6;
    private static final int MSG_CONTENT_LENGTH_CHANGED = 10;
    private static final int MSG_DOWNLOAD_UPDATE = 2;
    private static final int MSG_INITIALIZE = 0;
    private static final int MSG_INITIALIZED = 0;
    private static final int MSG_PROCESSED = 1;
    private static final int MSG_RELEASE = 12;
    private static final int MSG_REMOVE_ALL_DOWNLOADS = 8;
    private static final int MSG_REMOVE_DOWNLOAD = 7;
    private static final int MSG_SET_DOWNLOADS_PAUSED = 1;
    private static final int MSG_SET_MAX_PARALLEL_DOWNLOADS = 4;
    private static final int MSG_SET_MIN_RETRY_COUNT = 5;
    private static final int MSG_SET_NOT_MET_REQUIREMENTS = 2;
    private static final int MSG_SET_STOP_REASON = 3;
    private static final int MSG_TASK_STOPPED = 9;
    private static final int MSG_UPDATE_PROGRESS = 11;
    private static final String TAG = "DownloadManager";
    private int activeTaskCount;
    private final Handler applicationHandler;
    private final Context context;
    private final WritableDownloadIndex downloadIndex;
    private List downloads;
    private boolean downloadsPaused;
    private boolean initialized;
    private final DownloadManager$InternalHandler internalHandler;
    private final CopyOnWriteArraySet listeners;
    private int maxParallelDownloads;
    private int minRetryCount;
    private int notMetRequirements;
    private int pendingMessages;
    private final RequirementsWatcher$Listener requirementsListener;
    private RequirementsWatcher requirementsWatcher;
    private boolean waitingForRequirements;

    static {
        Requirements requirements;
        DEFAULT_REQUIREMENTS = requirements = new Requirements(1);
    }

    public DownloadManager(Context context, DatabaseProvider databaseProvider, Cache cache, DataSource$Factory dataSource$Factory) {
        m m10 = m.a;
        this(context, databaseProvider, cache, dataSource$Factory, m10);
    }

    public DownloadManager(Context context, DatabaseProvider object, Cache object2, DataSource$Factory dataSource$Factory, Executor executor) {
        DefaultDownloadIndex defaultDownloadIndex = new DefaultDownloadIndex((DatabaseProvider)object);
        CacheDataSource$Factory cacheDataSource$Factory = new CacheDataSource$Factory();
        object2 = cacheDataSource$Factory.setCache((Cache)object2).setUpstreamDataSourceFactory(dataSource$Factory);
        object = new DefaultDownloaderFactory((CacheDataSource$Factory)object2, executor);
        this(context, defaultDownloadIndex, (DownloaderFactory)object);
    }

    public DownloadManager(Context context, WritableDownloadIndex object, DownloaderFactory object2) {
        int n10;
        Handler handler;
        boolean bl2;
        Context context2;
        this.context = context2 = context.getApplicationContext();
        this.downloadIndex = object;
        this.maxParallelDownloads = 3;
        this.minRetryCount = 5;
        this.downloadsPaused = bl2 = true;
        Object object3 = Collections.emptyList();
        this.downloads = object3;
        this.listeners = object3;
        object3 = new j(this);
        this.applicationHandler = handler = Util.createHandlerForCurrentOrMainLooper((Handler.Callback)object3);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        int n11 = this.maxParallelDownloads;
        int n12 = this.minRetryCount;
        boolean bl3 = this.downloadsPaused;
        Object object4 = object3;
        object3 = new DownloadManager$InternalHandler(handlerThread, (WritableDownloadIndex)object, (DownloaderFactory)object2, handler, n11, n12, bl3);
        this.internalHandler = object3;
        this.requirementsListener = object = new h(this);
        object4 = DEFAULT_REQUIREMENTS;
        this.requirementsWatcher = object2 = new RequirementsWatcher(context, (RequirementsWatcher$Listener)object, (Requirements)object4);
        this.notMetRequirements = n10 = ((RequirementsWatcher)object2).start();
        this.pendingMessages = (int)(bl2 ? 1 : 0);
        object3.obtainMessage(0, n10, 0).sendToTarget();
    }

    public static /* synthetic */ void a(DownloadManager downloadManager, RequirementsWatcher requirementsWatcher, int n10) {
        downloadManager.onRequirementsStateChanged(requirementsWatcher, n10);
    }

    public static /* synthetic */ boolean b(DownloadManager downloadManager, Message message) {
        return downloadManager.handleMainMessage(message);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean handleMainMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 == 0) {
            List list = (List)object.obj;
            this.onInitialized(list);
            return n11 != 0;
        }
        if (n10 == n11) {
            n10 = object.arg1;
            int n12 = object.arg2;
            this.onMessageProcessed(n10, n12);
            return n11 != 0;
        }
        int n13 = 2;
        if (n10 == n13) {
            DownloadManager$DownloadUpdate downloadManager$DownloadUpdate = (DownloadManager$DownloadUpdate)object.obj;
            this.onDownloadUpdate(downloadManager$DownloadUpdate);
            return n11 != 0;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public static Download mergeRequest(Download download, DownloadRequest downloadRequest, int n10, long l10) {
        int n11;
        Download download2;
        long l11;
        int n12;
        Download download3 = download;
        int n13 = download.state;
        int n14 = 5;
        long l12 = n13 != n14 && (n12 = download.isTerminalState()) == 0 ? (l11 = download.startTimeMs) : l10;
        n12 = 7;
        if (n13 != n14 && n13 != n12) {
            if (n10 != 0) {
                n13 = 1;
            } else {
                n13 = 0;
                download2 = null;
            }
            n11 = n13;
        } else {
            n11 = n12;
        }
        DownloadRequest downloadRequest2 = download3.request.copyWithMergedRequest(downloadRequest);
        download2 = new Download(downloadRequest2, n11, l12, l10, -1, n10, 0);
        return download2;
    }

    private void notifyWaitingForRequirementsChanged() {
        boolean bl2;
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            DownloadManager$Listener downloadManager$Listener = (DownloadManager$Listener)iterator2.next();
            boolean bl3 = this.waitingForRequirements;
            downloadManager$Listener.onWaitingForRequirementsChanged(this, bl3);
        }
    }

    private void onDownloadUpdate(DownloadManager$DownloadUpdate object) {
        Object object2 = Collections.unmodifiableList(((DownloadManager$DownloadUpdate)object).downloads);
        this.downloads = object2;
        object2 = ((DownloadManager$DownloadUpdate)object).download;
        boolean bl2 = this.updateWaitingForRequirements();
        boolean bl3 = ((DownloadManager$DownloadUpdate)object).isRemove;
        if (bl3) {
            object = this.listeners.iterator();
            while (bl3 = object.hasNext()) {
                DownloadManager$Listener downloadManager$Listener = (DownloadManager$Listener)object.next();
                downloadManager$Listener.onDownloadRemoved(this, (Download)object2);
            }
        } else {
            boolean bl4;
            Iterator iterator2 = this.listeners.iterator();
            while (bl4 = iterator2.hasNext()) {
                DownloadManager$Listener downloadManager$Listener = (DownloadManager$Listener)iterator2.next();
                Exception exception = ((DownloadManager$DownloadUpdate)object).finalException;
                downloadManager$Listener.onDownloadChanged(this, (Download)object2, exception);
            }
        }
        if (bl2) {
            this.notifyWaitingForRequirementsChanged();
        }
    }

    private void onInitialized(List list) {
        boolean bl2;
        boolean bl3;
        this.initialized = bl3 = true;
        this.downloads = list = Collections.unmodifiableList(list);
        boolean bl4 = this.updateWaitingForRequirements();
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            DownloadManager$Listener downloadManager$Listener = (DownloadManager$Listener)iterator2.next();
            downloadManager$Listener.onInitialized(this);
        }
        if (bl4) {
            this.notifyWaitingForRequirementsChanged();
        }
    }

    private void onMessageProcessed(int n10, int n11) {
        int n12;
        this.pendingMessages = n12 = this.pendingMessages - n10;
        this.activeTaskCount = n11;
        n10 = (int)(this.isIdle() ? 1 : 0);
        if (n10 != 0) {
            Iterator iterator2 = this.listeners.iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                DownloadManager$Listener downloadManager$Listener = (DownloadManager$Listener)iterator2.next();
                downloadManager$Listener.onIdle(this);
            }
        }
    }

    private void onRequirementsStateChanged(RequirementsWatcher object, int n10) {
        DownloadManager$Listener downloadManager$Listener;
        boolean bl2;
        object = ((RequirementsWatcher)object).getRequirements();
        int n11 = this.notMetRequirements;
        if (n11 != n10) {
            this.notMetRequirements = n10;
            this.pendingMessages = n11 = this.pendingMessages + 1;
            DownloadManager$InternalHandler downloadManager$InternalHandler = this.internalHandler;
            int n12 = 2;
            bl2 = false;
            downloadManager$Listener = null;
            downloadManager$InternalHandler = downloadManager$InternalHandler.obtainMessage(n12, n10, 0);
            downloadManager$InternalHandler.sendToTarget();
        }
        n11 = (int)(this.updateWaitingForRequirements() ? 1 : 0);
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            downloadManager$Listener = (DownloadManager$Listener)iterator2.next();
            downloadManager$Listener.onRequirementsStateChanged(this, (Requirements)object, n10);
        }
        if (n11 != 0) {
            this.notifyWaitingForRequirementsChanged();
        }
    }

    private void setDownloadsPaused(boolean n10) {
        int n11 = this.downloadsPaused;
        if (n11 == n10) {
            return;
        }
        this.downloadsPaused = n10;
        n11 = this.pendingMessages;
        int n12 = 1;
        this.pendingMessages = n11 += n12;
        DownloadManager$InternalHandler downloadManager$InternalHandler = this.internalHandler;
        boolean bl2 = false;
        DownloadManager$Listener downloadManager$Listener = null;
        downloadManager$InternalHandler = downloadManager$InternalHandler.obtainMessage(n12, n10, 0);
        downloadManager$InternalHandler.sendToTarget();
        n11 = (int)(this.updateWaitingForRequirements() ? 1 : 0);
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            downloadManager$Listener = (DownloadManager$Listener)iterator2.next();
            downloadManager$Listener.onDownloadsPausedChanged(this, n10 != 0);
        }
        if (n11 != 0) {
            this.notifyWaitingForRequirementsChanged();
        }
    }

    private boolean updateWaitingForRequirements() {
        int n10;
        int n11 = this.downloadsPaused;
        int n12 = 1;
        if (n11 == 0 && (n11 = this.notMetRequirements) != 0) {
            Object object;
            for (n11 = 0; n11 < (n10 = (object = this.downloads).size()); ++n11) {
                object = (Download)this.downloads.get(n11);
                n10 = ((Download)object).state;
                if (n10 != 0) continue;
                n11 = n12;
                break;
            }
        } else {
            n11 = 0;
        }
        n10 = this.waitingForRequirements;
        if (n10 == n11) {
            n12 = 0;
        }
        this.waitingForRequirements = n11;
        return n12 != 0;
    }

    public void addDownload(DownloadRequest downloadRequest) {
        this.addDownload(downloadRequest, 0);
    }

    public void addDownload(DownloadRequest downloadRequest, int n10) {
        int n11;
        this.pendingMessages = n11 = this.pendingMessages + 1;
        this.internalHandler.obtainMessage(6, n10, 0, downloadRequest).sendToTarget();
    }

    public void addListener(DownloadManager$Listener downloadManager$Listener) {
        Assertions.checkNotNull(downloadManager$Listener);
        this.listeners.add(downloadManager$Listener);
    }

    public Looper getApplicationLooper() {
        return this.applicationHandler.getLooper();
    }

    public List getCurrentDownloads() {
        return this.downloads;
    }

    public DownloadIndex getDownloadIndex() {
        return this.downloadIndex;
    }

    public boolean getDownloadsPaused() {
        return this.downloadsPaused;
    }

    public int getMaxParallelDownloads() {
        return this.maxParallelDownloads;
    }

    public int getMinRetryCount() {
        return this.minRetryCount;
    }

    public int getNotMetRequirements() {
        return this.notMetRequirements;
    }

    public Requirements getRequirements() {
        return this.requirementsWatcher.getRequirements();
    }

    public boolean isIdle() {
        int n10 = this.activeTaskCount;
        n10 = n10 == 0 && (n10 = this.pendingMessages) == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public boolean isWaitingForRequirements() {
        return this.waitingForRequirements;
    }

    public void pauseDownloads() {
        this.setDownloadsPaused(true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        DownloadManager$InternalHandler downloadManager$InternalHandler = this.internalHandler;
        synchronized (downloadManager$InternalHandler) {
            DownloadManager$InternalHandler downloadManager$InternalHandler2;
            DownloadManager$InternalHandler downloadManager$InternalHandler3 = this.internalHandler;
            int n10 = downloadManager$InternalHandler3.released;
            if (n10 != 0) {
                return;
            }
            n10 = 12;
            downloadManager$InternalHandler3.sendEmptyMessage(n10);
            downloadManager$InternalHandler3 = null;
            n10 = 0;
            Object object = null;
            while (true) {
                downloadManager$InternalHandler2 = this.internalHandler;
                boolean bl2 = downloadManager$InternalHandler2.released;
                if (bl2) break;
                try {
                    ((Object)((Object)downloadManager$InternalHandler2)).wait();
                }
                catch (InterruptedException interruptedException) {
                    n10 = 1;
                }
            }
            if (n10 != 0) {
                object = Thread.currentThread();
                ((Thread)object).interrupt();
            }
            object = this.applicationHandler;
            downloadManager$InternalHandler2 = null;
            object.removeCallbacksAndMessages(null);
            this.downloads = object = Collections.emptyList();
            this.pendingMessages = 0;
            this.activeTaskCount = 0;
            this.initialized = false;
            this.notMetRequirements = 0;
            this.waitingForRequirements = false;
            return;
        }
    }

    public void removeAllDownloads() {
        int n10;
        this.pendingMessages = n10 = this.pendingMessages + 1;
        this.internalHandler.obtainMessage(8).sendToTarget();
    }

    public void removeDownload(String string2) {
        int n10;
        this.pendingMessages = n10 = this.pendingMessages + 1;
        this.internalHandler.obtainMessage(7, string2).sendToTarget();
    }

    public void removeListener(DownloadManager$Listener downloadManager$Listener) {
        this.listeners.remove(downloadManager$Listener);
    }

    public void resumeDownloads() {
        this.setDownloadsPaused(false);
    }

    public void setMaxParallelDownloads(int n10) {
        int n11 = 1;
        int n12 = n10 > 0 ? n11 : 0;
        Assertions.checkArgument(n12 != 0);
        n12 = this.maxParallelDownloads;
        if (n12 == n10) {
            return;
        }
        this.maxParallelDownloads = n10;
        this.pendingMessages = n12 = this.pendingMessages + n11;
        this.internalHandler.obtainMessage(4, n10, 0).sendToTarget();
    }

    public void setMinRetryCount(int n10) {
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        Assertions.checkArgument(n12 != 0);
        n12 = this.minRetryCount;
        if (n12 == n10) {
            return;
        }
        this.minRetryCount = n10;
        this.pendingMessages = n12 = this.pendingMessages + n11;
        this.internalHandler.obtainMessage(5, n10, 0).sendToTarget();
    }

    public void setRequirements(Requirements requirements) {
        Object object = this.requirementsWatcher.getRequirements();
        boolean bl2 = requirements.equals(object);
        if (bl2) {
            return;
        }
        this.requirementsWatcher.stop();
        Context context = this.context;
        RequirementsWatcher$Listener requirementsWatcher$Listener = this.requirementsListener;
        this.requirementsWatcher = object = new RequirementsWatcher(context, requirementsWatcher$Listener, requirements);
        int n10 = ((RequirementsWatcher)object).start();
        object = this.requirementsWatcher;
        this.onRequirementsStateChanged((RequirementsWatcher)object, n10);
    }

    public void setStopReason(String string2, int n10) {
        int n11;
        this.pendingMessages = n11 = this.pendingMessages + 1;
        this.internalHandler.obtainMessage(3, n10, 0, string2).sendToTarget();
    }
}

