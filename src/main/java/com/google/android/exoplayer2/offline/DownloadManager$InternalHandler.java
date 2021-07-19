/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadManager$DownloadUpdate;
import com.google.android.exoplayer2.offline.DownloadManager$Task;
import com.google.android.exoplayer2.offline.DownloadProgress;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.offline.DownloaderFactory;
import com.google.android.exoplayer2.offline.WritableDownloadIndex;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.k0.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class DownloadManager$InternalHandler
extends Handler {
    private static final int UPDATE_PROGRESS_INTERVAL_MS = 5000;
    private int activeDownloadTaskCount;
    private final HashMap activeTasks;
    private final WritableDownloadIndex downloadIndex;
    private final DownloaderFactory downloaderFactory;
    private final ArrayList downloads;
    private boolean downloadsPaused;
    private final Handler mainHandler;
    private int maxParallelDownloads;
    private int minRetryCount;
    private int notMetRequirements;
    public boolean released;
    private final HandlerThread thread;

    public DownloadManager$InternalHandler(HandlerThread object, WritableDownloadIndex writableDownloadIndex, DownloaderFactory downloaderFactory, Handler handler, int n10, int n11, boolean bl2) {
        Looper looper = object.getLooper();
        super(looper);
        this.thread = object;
        this.downloadIndex = writableDownloadIndex;
        this.downloaderFactory = downloaderFactory;
        this.mainHandler = handler;
        this.maxParallelDownloads = n10;
        this.minRetryCount = n11;
        this.downloadsPaused = bl2;
        super();
        this.downloads = object;
        super();
        this.activeTasks = object;
    }

    public static /* synthetic */ int a(Download download, Download download2) {
        return DownloadManager$InternalHandler.compareStartTimes(download, download2);
    }

    private void addDownload(DownloadRequest object, int n10) {
        Object object2 = ((DownloadRequest)object).id;
        int n11 = 1;
        object2 = this.getDownload((String)object2, n11 != 0);
        long l10 = System.currentTimeMillis();
        if (object2 != null) {
            object = DownloadManager.mergeRequest((Download)object2, (DownloadRequest)object, n10, l10);
            this.putDownload((Download)object);
        } else {
            if (n10 == 0) {
                n11 = 0;
            }
            long l11 = -1;
            object2 = new Download((DownloadRequest)object, n11, l10, l10, l11, n10, 0);
            this.putDownload((Download)object2);
        }
        this.syncTasks();
    }

    private boolean canDownloadsRun() {
        boolean bl2 = this.downloadsPaused;
        bl2 = !bl2 && !(bl2 = this.notMetRequirements);
        return bl2;
    }

    private static int compareStartTimes(Download download, Download download2) {
        long l10 = download.startTimeMs;
        long l11 = download2.startTimeMs;
        return Util.compareLong(l10, l11);
    }

    private static Download copyDownloadWithState(Download download, int n10, int n11) {
        DownloadRequest downloadRequest = download.request;
        long l10 = download.startTimeMs;
        long l11 = System.currentTimeMillis();
        long l12 = download.contentLength;
        DownloadProgress downloadProgress = download.progress;
        Download download2 = new Download(downloadRequest, n10, l10, l11, l12, n11, 0, downloadProgress);
        return download2;
    }

    private Download getDownload(String string2, boolean bl2) {
        int n10;
        int n11 = this.getDownloadIndex(string2);
        if (n11 != (n10 = -1)) {
            return (Download)this.downloads.get(n11);
        }
        if (bl2) {
            WritableDownloadIndex writableDownloadIndex = this.downloadIndex;
            try {
                return writableDownloadIndex.getDownload(string2);
            }
            catch (IOException iOException) {
                String string3 = "Failed to load download: ";
                string2 = String.valueOf(string2);
                n10 = string2.length();
                string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
                string3 = "DownloadManager";
                Log.e(string3, string2, iOException);
            }
        }
        return null;
    }

    private int getDownloadIndex(String string2) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.downloads)).size()); ++i10) {
            object = ((Download)this.downloads.get((int)i10)).request.id;
            n10 = (int)(((String)object).equals(string2) ? 1 : 0);
            if (n10 == 0) continue;
            return i10;
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initialize(int n10) {
        Throwable throwable2;
        Object object;
        block6: {
            Object object2;
            this.notMetRequirements = n10;
            n10 = 0;
            Object var2_2 = null;
            object = null;
            try {
                try {
                    boolean bl2;
                    int n11;
                    object2 = this.downloadIndex;
                    object2.setDownloadingStatesToQueued();
                    object2 = this.downloadIndex;
                    int n12 = 5;
                    int[] nArray = new int[n12];
                    nArray[0] = 0;
                    nArray[n11] = n11 = 1;
                    nArray[n11] = n11 = 2;
                    n11 = 3;
                    nArray[n11] = n12;
                    n12 = 4;
                    nArray[n12] = n11 = 7;
                    object = object2.getDownloads(nArray);
                    while (bl2 = object.moveToNext()) {
                        object2 = this.downloads;
                        Download download = object.getDownload();
                        ((ArrayList)object2).add(download);
                    }
                }
                catch (IOException iOException) {
                    String string2 = "DownloadManager";
                    String string3 = "Failed to load index.";
                    Log.e(string2, string3, iOException);
                    object2 = this.downloads;
                    ((ArrayList)object2).clear();
                }
            }
            catch (Throwable throwable2) {
                break block6;
            }
            Util.closeQuietly(object);
            object2 = this.downloads;
            object = new ArrayList(object2);
            this.mainHandler.obtainMessage(0, object).sendToTarget();
            this.syncTasks();
            return;
        }
        Util.closeQuietly(object);
        throw throwable2;
    }

    private void onContentLengthChanged(DownloadManager$Task downloadManager$Task, long l10) {
        long l11;
        Object object = DownloadManager$Task.access$200((DownloadManager$Task)downloadManager$Task).id;
        DownloadRequest downloadRequest = null;
        object = (Download)Assertions.checkNotNull(this.getDownload((String)object, false));
        long l12 = ((Download)object).contentLength;
        long l13 = l10 - l12;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 != false && (object2 = (l11 = l10 - (l12 = (long)-1)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            Download download;
            downloadRequest = ((Download)object).request;
            int n10 = ((Download)object).state;
            long l14 = ((Download)object).startTimeMs;
            long l15 = System.currentTimeMillis();
            int n11 = ((Download)object).stopReason;
            int n12 = ((Download)object).failureReason;
            DownloadProgress downloadProgress = ((Download)object).progress;
            object = download;
            download = new Download(downloadRequest, n10, l14, l15, l10, n11, n12, downloadProgress);
            this.putDownload(download);
        }
    }

    private void onDownloadTaskStopped(Download download, Exception exception) {
        Download download2;
        DownloadManager$InternalHandler downloadManager$InternalHandler = this;
        Object object = download;
        Exception exception2 = exception;
        Object object2 = download.request;
        int n10 = exception == null ? 3 : 4;
        int n11 = n10;
        long l10 = ((Download)object).startTimeMs;
        long l11 = System.currentTimeMillis();
        long l12 = ((Download)object).contentLength;
        int n12 = ((Download)object).stopReason;
        int n13 = exception2 == null ? 0 : (n10 = 1);
        object = ((Download)object).progress;
        ArrayList arrayList = download2;
        exception2 = null;
        download2 = new Download((DownloadRequest)object2, n11, l10, l11, l12, n12, n13, (DownloadProgress)object);
        object = downloadManager$InternalHandler.downloads;
        arrayList = download2.request.id;
        n10 = downloadManager$InternalHandler.getDownloadIndex((String)((Object)arrayList));
        ((ArrayList)object).remove(n10);
        object = downloadManager$InternalHandler.downloadIndex;
        try {
            object.putDownload(download2);
        }
        catch (IOException iOException) {
            arrayList = "DownloadManager";
            object2 = "Failed to update index.";
            Log.e((String)((Object)arrayList), (String)object2, iOException);
        }
        object2 = downloadManager$InternalHandler.downloads;
        arrayList = new ArrayList(object2);
        exception2 = exception;
        object = new DownloadManager$DownloadUpdate(download2, false, arrayList, exception);
        downloadManager$InternalHandler.mainHandler.obtainMessage(2, object).sendToTarget();
    }

    private void onRemoveTaskStopped(Download download) {
        int n10 = download.state;
        int n11 = 1;
        int n12 = 7;
        if (n10 == n12) {
            n10 = download.stopReason;
            if (n10 == 0) {
                n11 = 0;
            }
            this.putDownloadWithState(download, n11, n10);
            this.syncTasks();
        } else {
            Object object = download.request.id;
            n10 = this.getDownloadIndex((String)object);
            ArrayList arrayList = this.downloads;
            arrayList.remove(n10);
            object = this.downloadIndex;
            arrayList = download.request;
            arrayList = ((DownloadRequest)arrayList).id;
            try {
                object.removeDownload((String)((Object)arrayList));
            }
            catch (IOException iOException) {
                object = "DownloadManager";
                arrayList = "Failed to remove from database";
                Log.e((String)object, (String)((Object)arrayList));
            }
            ArrayList arrayList2 = this.downloads;
            arrayList = new ArrayList(arrayList2);
            arrayList2 = null;
            object = new DownloadManager$DownloadUpdate(download, n11 != 0, arrayList, null);
            download = this.mainHandler;
            n11 = 2;
            download = download.obtainMessage(n11, object);
            download.sendToTarget();
        }
    }

    private void onTaskStopped(DownloadManager$Task object) {
        int n10;
        int n11;
        String string2 = DownloadManager$Task.access$200((DownloadManager$Task)object).id;
        HashMap hashMap = this.activeTasks;
        hashMap.remove(string2);
        int n12 = DownloadManager$Task.access$000((DownloadManager$Task)object);
        if (n12 == 0) {
            this.activeDownloadTaskCount = n11 = this.activeDownloadTaskCount + -1;
            if (n11 == 0) {
                n11 = 11;
                this.removeMessages(n11);
            }
        }
        if ((n11 = DownloadManager$Task.access$300((DownloadManager$Task)object)) != 0) {
            this.syncTasks();
            return;
        }
        Exception exception = DownloadManager$Task.access$400((DownloadManager$Task)object);
        if (exception != null) {
            object = String.valueOf(DownloadManager$Task.access$200((DownloadManager$Task)object));
            n10 = String.valueOf(object).length() + 20;
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append("Task failed: ");
            stringBuilder.append((String)object);
            stringBuilder.append(", ");
            stringBuilder.append(n12 != 0);
            object = stringBuilder.toString();
            String string3 = "DownloadManager";
            Log.e(string3, (String)object, exception);
        }
        object = (Download)Assertions.checkNotNull(this.getDownload(string2, false));
        int n13 = ((Download)object).state;
        n10 = 2;
        if (n13 != n10) {
            n11 = 5;
            if (n13 != n11 && n13 != (n11 = 7)) {
                object = new IllegalStateException();
                throw object;
            }
            Assertions.checkState(n12 != 0);
            this.onRemoveTaskStopped((Download)object);
        } else {
            n13 = n12 ^ 1;
            Assertions.checkState(n13 != 0);
            this.onDownloadTaskStopped((Download)object, exception);
        }
        this.syncTasks();
    }

    private Download putDownload(Download download) {
        Object object;
        Object object2;
        Object object3;
        int n10 = download.state;
        int n11 = 1;
        int n12 = 3;
        if (n10 != n12 && n10 != (n12 = 4)) {
            n10 = n11;
        } else {
            n10 = 0;
            object3 = null;
        }
        Assertions.checkState(n10 != 0);
        object3 = download.request.id;
        n10 = this.getDownloadIndex((String)object3);
        n12 = -1;
        if (n10 == n12) {
            this.downloads.add(download);
            object3 = this.downloads;
            object2 = i.a;
            Collections.sort(object3, object2);
        } else {
            long l10 = download.startTimeMs;
            Download download2 = (Download)this.downloads.get(n10);
            long l11 = download2.startTimeMs;
            long l12 = l10 - l11;
            n12 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n12 == 0) {
                n11 = 0;
                object2 = null;
            }
            object = this.downloads;
            ((ArrayList)object).set(n10, download);
            if (n11 != 0) {
                object3 = this.downloads;
                object2 = i.a;
                Collections.sort(object3, object2);
            }
        }
        object3 = this.downloadIndex;
        try {
            object3.putDownload(download);
        }
        catch (IOException iOException) {
            object2 = "DownloadManager";
            object = "Failed to update index.";
            Log.e((String)object2, (String)object, iOException);
        }
        object = this.downloads;
        object2 = new ArrayList(object);
        object3 = new DownloadManager$DownloadUpdate(download, false, (List)object2, null);
        this.mainHandler.obtainMessage(2, object3).sendToTarget();
        return download;
    }

    private Download putDownloadWithState(Download download, int n10, int n11) {
        int n12 = 3;
        n12 = n10 != n12 && n10 != (n12 = 4) ? 1 : 0;
        Assertions.checkState(n12 != 0);
        download = DownloadManager$InternalHandler.copyDownloadWithState(download, n10, n11);
        return this.putDownload(download);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void release() {
        Object object;
        boolean bl2;
        Object object2 = this.activeTasks.values().iterator();
        while (true) {
            boolean bl3 = object2.hasNext();
            bl2 = true;
            if (!bl3) break;
            object = (DownloadManager$Task)object2.next();
            ((DownloadManager$Task)object).cancel(bl2);
        }
        try {
            object2 = this.downloadIndex;
            object2.setDownloadingStatesToQueued();
        }
        catch (IOException iOException) {
            object = "DownloadManager";
            String string2 = "Failed to update index.";
            Log.e((String)object, string2, iOException);
        }
        this.downloads.clear();
        object2 = this.thread;
        object2.quit();
        synchronized (this) {
            this.released = bl2;
            ((Object)((Object)this)).notifyAll();
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private void removeAllDownloads() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void removeDownload(String string2) {
        boolean bl2 = true;
        Object object = this.getDownload(string2, bl2);
        if (object == null) {
            object = "Failed to remove nonexistent download: ";
            int n10 = (string2 = String.valueOf(string2)).length();
            string2 = n10 != 0 ? ((String)object).concat(string2) : new String((String)object);
            Log.e("DownloadManager", string2);
            return;
        }
        this.putDownloadWithState((Download)object, 5, 0);
        this.syncTasks();
    }

    private void setDownloadsPaused(boolean bl2) {
        this.downloadsPaused = bl2;
        this.syncTasks();
    }

    private void setMaxParallelDownloads(int n10) {
        this.maxParallelDownloads = n10;
        this.syncTasks();
    }

    private void setMinRetryCount(int n10) {
        this.minRetryCount = n10;
    }

    private void setNotMetRequirements(int n10) {
        this.notMetRequirements = n10;
        this.syncTasks();
    }

    private void setStopReason(Download download, int n10) {
        Download download2 = download;
        int n11 = 1;
        if (n10 == 0) {
            int n12 = download.state;
            if (n12 == n11) {
                n11 = 0;
                Object var6_7 = null;
                this.putDownloadWithState(download, 0, 0);
            }
        } else {
            int n13 = download.stopReason;
            if (n10 != n13) {
                Download download3;
                int n14;
                n13 = download.state;
                if (n13 == 0 || n13 == (n14 = 2)) {
                    n13 = n11;
                }
                DownloadRequest downloadRequest = download2.request;
                long l10 = download2.startTimeMs;
                long l11 = System.currentTimeMillis();
                long l12 = download2.contentLength;
                DownloadProgress downloadProgress = download2.progress;
                download2 = download3;
                download3 = new Download(downloadRequest, n13, l10, l11, l12, n10, 0, downloadProgress);
                this.putDownload(download3);
            }
        }
    }

    private void setStopReason(String object, int n10) {
        String string2 = "DownloadManager";
        Object object2 = null;
        if (object == null) {
            int n11;
            for (int i10 = 0; i10 < (n11 = ((ArrayList)(object = this.downloads)).size()); ++i10) {
                object = (Download)this.downloads.get(i10);
                this.setStopReason((Download)object, n10);
            }
            object = this.downloadIndex;
            try {
                object.setStopReason(n10);
            }
            catch (IOException iOException) {
                String string3 = "Failed to set manual stop reason";
                Log.e(string2, string3, iOException);
            }
        } else {
            object2 = this.getDownload((String)object, false);
            if (object2 != null) {
                this.setStopReason((Download)object2, n10);
            } else {
                object2 = this.downloadIndex;
                try {
                    object2.setStopReason((String)object, n10);
                }
                catch (IOException iOException) {
                    object2 = "Failed to set manual stop reason: ";
                    object = String.valueOf(object);
                    int n12 = ((String)object).length();
                    object = n12 != 0 ? ((String)object2).concat((String)object) : new String((String)object2);
                    Log.e(string2, (String)object, iOException);
                }
            }
        }
        this.syncTasks();
    }

    private void syncDownloadingDownload(DownloadManager$Task downloadManager$Task, Download download, int n10) {
        Assertions.checkState(DownloadManager$Task.access$000(downloadManager$Task) ^ true);
        int n11 = this.canDownloadsRun();
        if (n11 == 0 || n10 >= (n11 = this.maxParallelDownloads)) {
            n10 = 0;
            this.putDownloadWithState(download, 0, 0);
            downloadManager$Task.cancel(false);
        }
    }

    private DownloadManager$Task syncQueuedDownload(DownloadManager$Task object, Download object2) {
        int n10;
        int n11 = 0;
        Object object3 = null;
        if (object != null) {
            Assertions.checkState(DownloadManager$Task.access$000((DownloadManager$Task)object) ^ true);
            ((DownloadManager$Task)object).cancel(false);
            return object;
        }
        int n12 = this.canDownloadsRun();
        if (n12 != 0 && (n12 = this.activeDownloadTaskCount) < (n10 = this.maxParallelDownloads)) {
            object = this.putDownloadWithState((Download)object2, 2, 0);
            object2 = this.downloaderFactory;
            object3 = ((Download)object).request;
            Downloader downloader = object2.createDownloader((DownloadRequest)object3);
            DownloadRequest downloadRequest = ((Download)object).request;
            DownloadProgress downloadProgress = ((Download)object).progress;
            int n13 = this.minRetryCount;
            object2 = new DownloadManager$Task(downloadRequest, downloader, downloadProgress, false, n13, this, null);
            object3 = this.activeTasks;
            object = object.request.id;
            ((HashMap)object3).put(object, object2);
            n12 = this.activeDownloadTaskCount;
            this.activeDownloadTaskCount = n11 = n12 + 1;
            if (n12 == 0) {
                n12 = 11;
                long l10 = 5000L;
                this.sendEmptyMessageDelayed(n12, l10);
            }
            ((Thread)object2).start();
            return object2;
        }
        return null;
    }

    private void syncRemovingDownload(DownloadManager$Task object, Download object2) {
        if (object != null) {
            boolean bl2 = DownloadManager$Task.access$000((DownloadManager$Task)object);
            if (!bl2) {
                bl2 = false;
                object2 = null;
                ((DownloadManager$Task)object).cancel(false);
            }
            return;
        }
        object = this.downloaderFactory;
        Object object3 = ((Download)object2).request;
        Downloader downloader = object.createDownloader((DownloadRequest)object3);
        DownloadRequest downloadRequest = ((Download)object2).request;
        DownloadProgress downloadProgress = ((Download)object2).progress;
        int n10 = this.minRetryCount;
        object = new DownloadManager$Task(downloadRequest, downloader, downloadProgress, true, n10, this, null);
        object3 = this.activeTasks;
        object2 = object2.request.id;
        ((HashMap)object3).put(object2, object);
        ((Thread)object).start();
    }

    private void syncStoppedDownload(DownloadManager$Task downloadManager$Task) {
        if (downloadManager$Task != null) {
            Assertions.checkState(DownloadManager$Task.access$000(downloadManager$Task) ^ true);
            downloadManager$Task.cancel(false);
        }
    }

    private void syncTasks() {
        Object object;
        int n10;
        IllegalStateException illegalStateException = null;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.downloads)).size()); ++i10) {
            object = (Download)this.downloads.get(i10);
            Object object2 = this.activeTasks;
            String string2 = object.request.id;
            object2 = (DownloadManager$Task)((HashMap)object2).get(string2);
            int n12 = ((Download)object).state;
            if (n12 != 0) {
                int n13 = 1;
                if (n12 != n13) {
                    n13 = 2;
                    if (n12 != n13) {
                        n13 = 5;
                        if (n12 != n13 && n12 != (n13 = 7)) {
                            illegalStateException = new IllegalStateException();
                            throw illegalStateException;
                        }
                        this.syncRemovingDownload((DownloadManager$Task)object2, (Download)object);
                    } else {
                        Assertions.checkNotNull(object2);
                        this.syncDownloadingDownload((DownloadManager$Task)object2, (Download)object, n11);
                    }
                } else {
                    this.syncStoppedDownload((DownloadManager$Task)object2);
                }
            } else {
                object2 = this.syncQueuedDownload((DownloadManager$Task)object2, (Download)object);
            }
            if (object2 == null || (n10 = (int)(DownloadManager$Task.access$000((DownloadManager$Task)object2) ? 1 : 0)) != 0) continue;
            ++n11;
        }
    }

    private void updateProgress() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.downloads)).size()); ++i10) {
            object = (Download)this.downloads.get(i10);
            int n11 = ((Download)object).state;
            int n12 = 2;
            if (n11 != n12) continue;
            Object object2 = this.downloadIndex;
            try {
                object2.putDownload((Download)object);
                continue;
            }
            catch (IOException iOException) {
                object2 = "DownloadManager";
                String string2 = "Failed to update index.";
                Log.e((String)object2, string2, iOException);
            }
        }
        this.sendEmptyMessageDelayed(11, 5000L);
    }

    public void handleMessage(Message object) {
        int n10;
        int n11;
        int n12;
        block16: {
            n12 = object.what;
            n11 = 0;
            n10 = 1;
            switch (n12) {
                default: {
                    object = new IllegalStateException();
                    throw object;
                }
                case 12: {
                    this.release();
                    return;
                }
                case 11: {
                    this.updateProgress();
                    return;
                }
                case 10: {
                    DownloadManager$Task downloadManager$Task = (DownloadManager$Task)object.obj;
                    n11 = object.arg1;
                    int n13 = object.arg2;
                    long l10 = Util.toLong(n11, n13);
                    this.onContentLengthChanged(downloadManager$Task, l10);
                    return;
                }
                case 9: {
                    object = (DownloadManager$Task)object.obj;
                    this.onTaskStopped((DownloadManager$Task)object);
                    break block16;
                }
                case 8: {
                    this.removeAllDownloads();
                    break;
                }
                case 7: {
                    object = (String)object.obj;
                    this.removeDownload((String)object);
                    break;
                }
                case 6: {
                    DownloadRequest downloadRequest = (DownloadRequest)object.obj;
                    int n14 = object.arg1;
                    this.addDownload(downloadRequest, n14);
                    break;
                }
                case 5: {
                    int n15 = object.arg1;
                    this.setMinRetryCount(n15);
                    break;
                }
                case 4: {
                    int n16 = object.arg1;
                    this.setMaxParallelDownloads(n16);
                    break;
                }
                case 3: {
                    String string2 = (String)object.obj;
                    int n17 = object.arg1;
                    this.setStopReason(string2, n17);
                    break;
                }
                case 2: {
                    int n18 = object.arg1;
                    this.setNotMetRequirements(n18);
                    break;
                }
                case 1: {
                    int n19 = object.arg1;
                    if (n19 != 0) {
                        n11 = n10;
                    }
                    this.setDownloadsPaused(n11 != 0);
                    break;
                }
                case 0: {
                    int n20 = object.arg1;
                    this.initialize(n20);
                }
            }
            n11 = n10;
        }
        object = this.mainHandler;
        n12 = this.activeTasks.size();
        object.obtainMessage(n10, n11, n12).sendToTarget();
    }
}

