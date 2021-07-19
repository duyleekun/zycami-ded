/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.Parcelable
 */
package com.google.android.exoplayer2.offline;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcelable;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.DownloadService$DownloadManagerHelper;
import com.google.android.exoplayer2.offline.DownloadService$ForegroundNotificationUpdater;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;

public abstract class DownloadService
extends Service {
    public static final String ACTION_ADD_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";
    public static final String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final String ACTION_PAUSE_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
    public static final String ACTION_REMOVE_ALL_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
    public static final String ACTION_REMOVE_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
    private static final String ACTION_RESTART = "com.google.android.exoplayer.downloadService.action.RESTART";
    public static final String ACTION_RESUME_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";
    public static final String ACTION_SET_REQUIREMENTS = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";
    public static final String ACTION_SET_STOP_REASON = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000L;
    public static final int FOREGROUND_NOTIFICATION_ID_NONE = 0;
    public static final String KEY_CONTENT_ID = "content_id";
    public static final String KEY_DOWNLOAD_REQUEST = "download_request";
    public static final String KEY_FOREGROUND = "foreground";
    public static final String KEY_REQUIREMENTS = "requirements";
    public static final String KEY_STOP_REASON = "stop_reason";
    private static final String TAG = "DownloadService";
    private static final HashMap downloadManagerHelpers;
    private final int channelDescriptionResourceId;
    private final String channelId;
    private final int channelNameResourceId;
    private DownloadManager downloadManager;
    private final DownloadService$ForegroundNotificationUpdater foregroundNotificationUpdater;
    private boolean isDestroyed;
    private boolean isStopped;
    private int lastStartId;
    private boolean startedInForeground;
    private boolean taskRemoved;

    static {
        HashMap hashMap;
        downloadManagerHelpers = hashMap = new HashMap();
    }

    public DownloadService(int n10) {
        this(n10, 1000L);
    }

    public DownloadService(int n10, long l10) {
        this(n10, l10, null, 0, 0);
    }

    public DownloadService(int n10, long l10, String string2, int n11) {
        this(n10, l10, string2, n11, 0);
    }

    public DownloadService(int n10, long l10, String string2, int n11, int n12) {
        if (n10 == 0) {
            this.foregroundNotificationUpdater = null;
            this.channelId = null;
            n10 = 0;
            this.channelNameResourceId = 0;
            this.channelDescriptionResourceId = 0;
        } else {
            DownloadService$ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater;
            this.foregroundNotificationUpdater = downloadService$ForegroundNotificationUpdater = new DownloadService$ForegroundNotificationUpdater(this, n10, l10);
            this.channelId = string2;
            this.channelNameResourceId = n11;
            this.channelDescriptionResourceId = n12;
        }
    }

    public static /* synthetic */ DownloadManager access$200(DownloadService downloadService) {
        return downloadService.downloadManager;
    }

    public static /* synthetic */ void access$300(DownloadService downloadService, List list) {
        downloadService.notifyDownloads(list);
    }

    public static /* synthetic */ void access$400(DownloadService downloadService, Download download) {
        downloadService.notifyDownloadChanged(download);
    }

    public static /* synthetic */ boolean access$500(int n10) {
        return DownloadService.needsStartedService(n10);
    }

    public static /* synthetic */ void access$600(DownloadService downloadService, Download download) {
        downloadService.notifyDownloadRemoved(download);
    }

    public static /* synthetic */ void access$700(DownloadService downloadService) {
        downloadService.stop();
    }

    public static /* synthetic */ boolean access$800(DownloadService downloadService) {
        return downloadService.isStopped();
    }

    public static /* synthetic */ Intent access$900(Context context, Class clazz, String string2) {
        return DownloadService.getIntent(context, clazz, string2);
    }

    public static Intent buildAddDownloadIntent(Context context, Class clazz, DownloadRequest downloadRequest, int n10, boolean bl2) {
        return DownloadService.getIntent(context, clazz, ACTION_ADD_DOWNLOAD, bl2).putExtra(KEY_DOWNLOAD_REQUEST, (Parcelable)downloadRequest).putExtra(KEY_STOP_REASON, n10);
    }

    public static Intent buildAddDownloadIntent(Context context, Class clazz, DownloadRequest downloadRequest, boolean bl2) {
        return DownloadService.buildAddDownloadIntent(context, clazz, downloadRequest, 0, bl2);
    }

    public static Intent buildPauseDownloadsIntent(Context context, Class clazz, boolean bl2) {
        return DownloadService.getIntent(context, clazz, ACTION_PAUSE_DOWNLOADS, bl2);
    }

    public static Intent buildRemoveAllDownloadsIntent(Context context, Class clazz, boolean bl2) {
        return DownloadService.getIntent(context, clazz, ACTION_REMOVE_ALL_DOWNLOADS, bl2);
    }

    public static Intent buildRemoveDownloadIntent(Context context, Class clazz, String string2, boolean bl2) {
        return DownloadService.getIntent(context, clazz, ACTION_REMOVE_DOWNLOAD, bl2).putExtra(KEY_CONTENT_ID, string2);
    }

    public static Intent buildResumeDownloadsIntent(Context context, Class clazz, boolean bl2) {
        return DownloadService.getIntent(context, clazz, ACTION_RESUME_DOWNLOADS, bl2);
    }

    public static Intent buildSetRequirementsIntent(Context context, Class clazz, Requirements requirements, boolean bl2) {
        return DownloadService.getIntent(context, clazz, ACTION_SET_REQUIREMENTS, bl2).putExtra(KEY_REQUIREMENTS, (Parcelable)requirements);
    }

    public static Intent buildSetStopReasonIntent(Context context, Class clazz, String string2, int n10, boolean bl2) {
        return DownloadService.getIntent(context, clazz, ACTION_SET_STOP_REASON, bl2).putExtra(KEY_CONTENT_ID, string2).putExtra(KEY_STOP_REASON, n10);
    }

    private static Intent getIntent(Context context, Class clazz, String string2) {
        Intent intent = new Intent(context, clazz);
        return intent.setAction(string2);
    }

    private static Intent getIntent(Context context, Class clazz, String string2, boolean bl2) {
        return DownloadService.getIntent(context, clazz, string2).putExtra(KEY_FOREGROUND, bl2);
    }

    private boolean isStopped() {
        return this.isStopped;
    }

    private static boolean needsStartedService(int n10) {
        int n11 = 2;
        n10 = n10 != n11 && n10 != (n11 = 5) && n10 != (n11 = 7) ? 0 : 1;
        return n10 != 0;
    }

    private void notifyDownloadChanged(Download object) {
        this.onDownloadChanged((Download)object);
        DownloadService$ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater = this.foregroundNotificationUpdater;
        if (downloadService$ForegroundNotificationUpdater != null) {
            boolean bl2 = DownloadService.needsStartedService(((Download)object).state);
            if (bl2) {
                object = this.foregroundNotificationUpdater;
                ((DownloadService$ForegroundNotificationUpdater)object).startPeriodicUpdates();
            } else {
                object = this.foregroundNotificationUpdater;
                ((DownloadService$ForegroundNotificationUpdater)object).invalidate();
            }
        }
    }

    private void notifyDownloadRemoved(Download object) {
        this.onDownloadRemoved((Download)object);
        object = this.foregroundNotificationUpdater;
        if (object != null) {
            ((DownloadService$ForegroundNotificationUpdater)object).invalidate();
        }
    }

    private void notifyDownloads(List object) {
        DownloadService$ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater = this.foregroundNotificationUpdater;
        if (downloadService$ForegroundNotificationUpdater != null) {
            int n10;
            downloadService$ForegroundNotificationUpdater = null;
            for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
                Download download = (Download)object.get(i10);
                n10 = (int)(DownloadService.needsStartedService(download.state) ? 1 : 0);
                if (n10 == 0) continue;
                object = this.foregroundNotificationUpdater;
                ((DownloadService$ForegroundNotificationUpdater)object).startPeriodicUpdates();
                break;
            }
        }
    }

    public static void sendAddDownload(Context context, Class clazz, DownloadRequest downloadRequest, int n10, boolean bl2) {
        clazz = DownloadService.buildAddDownloadIntent(context, clazz, downloadRequest, n10, bl2);
        DownloadService.startService(context, (Intent)clazz, bl2);
    }

    public static void sendAddDownload(Context context, Class clazz, DownloadRequest downloadRequest, boolean bl2) {
        clazz = DownloadService.buildAddDownloadIntent(context, clazz, downloadRequest, bl2);
        DownloadService.startService(context, (Intent)clazz, bl2);
    }

    public static void sendPauseDownloads(Context context, Class clazz, boolean bl2) {
        clazz = DownloadService.buildPauseDownloadsIntent(context, clazz, bl2);
        DownloadService.startService(context, (Intent)clazz, bl2);
    }

    public static void sendRemoveAllDownloads(Context context, Class clazz, boolean bl2) {
        clazz = DownloadService.buildRemoveAllDownloadsIntent(context, clazz, bl2);
        DownloadService.startService(context, (Intent)clazz, bl2);
    }

    public static void sendRemoveDownload(Context context, Class clazz, String string2, boolean bl2) {
        clazz = DownloadService.buildRemoveDownloadIntent(context, clazz, string2, bl2);
        DownloadService.startService(context, (Intent)clazz, bl2);
    }

    public static void sendResumeDownloads(Context context, Class clazz, boolean bl2) {
        clazz = DownloadService.buildResumeDownloadsIntent(context, clazz, bl2);
        DownloadService.startService(context, (Intent)clazz, bl2);
    }

    public static void sendSetRequirements(Context context, Class clazz, Requirements requirements, boolean bl2) {
        clazz = DownloadService.buildSetRequirementsIntent(context, clazz, requirements, bl2);
        DownloadService.startService(context, (Intent)clazz, bl2);
    }

    public static void sendSetStopReason(Context context, Class clazz, String string2, int n10, boolean bl2) {
        clazz = DownloadService.buildSetStopReasonIntent(context, clazz, string2, n10, bl2);
        DownloadService.startService(context, (Intent)clazz, bl2);
    }

    public static void start(Context context, Class clazz) {
        clazz = DownloadService.getIntent(context, clazz, ACTION_INIT);
        context.startService((Intent)clazz);
    }

    public static void startForeground(Context context, Class clazz) {
        clazz = DownloadService.getIntent(context, clazz, ACTION_INIT, true);
        Util.startForegroundService(context, (Intent)clazz);
    }

    private static void startService(Context context, Intent intent, boolean bl2) {
        if (bl2) {
            Util.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
    }

    private void stop() {
        int n10;
        int n11;
        DownloadService$ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater = this.foregroundNotificationUpdater;
        if (downloadService$ForegroundNotificationUpdater != null) {
            downloadService$ForegroundNotificationUpdater.stopPeriodicUpdates();
        }
        if ((n11 = Util.SDK_INT) < (n10 = 28) && (n11 = (int)(this.taskRemoved ? 1 : 0)) != 0) {
            this.stopSelf();
            n11 = 1;
            this.isStopped = n11;
        } else {
            n11 = (int)(this.isStopped ? 1 : 0);
            n10 = this.lastStartId;
            n10 = (int)(this.stopSelfResult(n10) ? 1 : 0);
            this.isStopped = n11 |= n10;
        }
    }

    public abstract DownloadManager getDownloadManager();

    public abstract Notification getForegroundNotification(List var1);

    public abstract Scheduler getScheduler();

    public final void invalidateForegroundNotification() {
        boolean bl2;
        DownloadService$ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater = this.foregroundNotificationUpdater;
        if (downloadService$ForegroundNotificationUpdater != null && !(bl2 = this.isDestroyed)) {
            downloadService$ForegroundNotificationUpdater.invalidate();
        }
    }

    public final IBinder onBind(Intent object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    /*
     * WARNING - void declaration
     */
    public void onCreate() {
        HashMap hashMap;
        Object object;
        Object object2 = this.channelId;
        if (object2 != null) {
            int n10 = this.channelNameResourceId;
            int bl2 = this.channelDescriptionResourceId;
            int n11 = 2;
            NotificationUtil.createNotificationChannel((Context)this, (String)object2, n10, bl2, n11);
        }
        if ((object = (DownloadService$DownloadManagerHelper)(hashMap = downloadManagerHelpers).get(object2 = ((Object)((Object)this)).getClass())) == null) {
            void var3_6;
            object = this.foregroundNotificationUpdater;
            if (object != null) {
                boolean bl2 = true;
            } else {
                boolean bl3 = false;
                object = null;
            }
            void var7_11 = var3_6;
            if (var3_6 != false) {
                object = this.getScheduler();
            } else {
                boolean bl4 = false;
                object = null;
            }
            Object object3 = object;
            this.downloadManager = object = this.getDownloadManager();
            ((DownloadManager)object).resumeDownloads();
            Context context = this.getApplicationContext();
            DownloadManager downloadManager = this.downloadManager;
            object = new DownloadService$DownloadManagerHelper(context, downloadManager, (boolean)var7_11, (Scheduler)object3, (Class)object2, null);
            hashMap.put(object2, object);
        } else {
            this.downloadManager = object2 = DownloadService$DownloadManagerHelper.access$100((DownloadService$DownloadManagerHelper)object);
        }
        ((DownloadService$DownloadManagerHelper)object).attachService(this);
    }

    public void onDestroy() {
        boolean bl2;
        this.isDestroyed = bl2 = true;
        Object object = downloadManagerHelpers;
        Class<?> clazz = ((Object)((Object)this)).getClass();
        ((DownloadService$DownloadManagerHelper)Assertions.checkNotNull((DownloadService$DownloadManagerHelper)((HashMap)object).get(clazz))).detachService(this);
        object = this.foregroundNotificationUpdater;
        if (object != null) {
            ((DownloadService$ForegroundNotificationUpdater)object).stopPeriodicUpdates();
        }
    }

    public void onDownloadChanged(Download download) {
    }

    public void onDownloadRemoved(Download download) {
    }

    public int onStartCommand(Intent object, int n10, int n11) {
        int n12;
        Object object2;
        CharSequence charSequence;
        this.lastStartId = n11;
        this.taskRemoved = false;
        Object object3 = "com.google.android.exoplayer.downloadService.action.RESTART";
        int n13 = 0;
        Object object4 = null;
        int n14 = 1;
        if (object != null) {
            object4 = object.getAction();
            charSequence = object.getStringExtra("content_id");
            boolean bl2 = this.startedInForeground;
            object2 = "foreground";
            int n15 = (int)(object.getBooleanExtra((String)object2, false) ? 1 : 0);
            if (n15 == 0 && (n15 = ((String)object3).equals(object4)) == 0) {
                n15 = 0;
                object2 = null;
            } else {
                n15 = n14;
            }
            this.startedInForeground = bl2 |= n15;
        } else {
            charSequence = null;
        }
        String string2 = "com.google.android.exoplayer.downloadService.action.INIT";
        if (object4 == null) {
            object4 = string2;
        }
        object2 = (DownloadManager)Assertions.checkNotNull(this.downloadManager);
        ((String)object4).hashCode();
        int n16 = -1;
        int n17 = ((String)object4).hashCode();
        switch (n17) {
            default: {
                break;
            }
            case 1547520644: {
                object3 = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                if (n11 == 0) break;
                n16 = 8;
                break;
            }
            case 1015676687: {
                n11 = (int)(((String)object4).equals(string2) ? 1 : 0);
                if (n11 == 0) break;
                n16 = 7;
                break;
            }
            case 671523141: {
                object3 = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";
                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                if (n11 == 0) break;
                n16 = 6;
                break;
            }
            case 191112771: {
                object3 = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                if (n11 == 0) break;
                n16 = 5;
                break;
            }
            case -119057172: {
                object3 = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";
                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                if (n11 == 0) break;
                n16 = 4;
                break;
            }
            case -650547439: {
                object3 = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                if (n11 == 0) break;
                n16 = 3;
                break;
            }
            case -871181424: {
                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                if (n11 == 0) break;
                n16 = 2;
                break;
            }
            case -932047176: {
                object3 = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";
                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                if (n11 == 0) break;
                n16 = n14;
                break;
            }
            case -1931239035: {
                object3 = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";
                n11 = (int)(((String)object4).equals(object3) ? 1 : 0);
                if (n11 == 0) break;
                n16 = 0;
            }
        }
        object3 = "stop_reason";
        string2 = "DownloadService";
        switch (n16) {
            default: {
                object = "Ignored unrecognized action: ";
                object3 = String.valueOf(object4);
                n13 = ((String)object3).length();
                object = n13 != 0 ? ((String)object).concat((String)object3) : (object3 = new String((String)object));
                Log.e(string2, (String)object);
                break;
            }
            case 8: {
                if (charSequence == null) {
                    object = "Ignored REMOVE_DOWNLOAD: Missing content_id extra";
                    Log.e(string2, (String)object);
                    break;
                }
                ((DownloadManager)object2).removeDownload((String)charSequence);
                break;
            }
            case 6: {
                object4 = (Intent)Assertions.checkNotNull(object);
                n13 = (int)(object4.hasExtra((String)object3) ? 1 : 0);
                if (n13 == 0) {
                    object = "Ignored SET_STOP_REASON: Missing stop_reason extra";
                    Log.e(string2, (String)object);
                    break;
                }
                n12 = object.getIntExtra((String)object3, 0);
                ((DownloadManager)object2).setStopReason((String)charSequence, n12);
                break;
            }
            case 5: {
                ((DownloadManager)object2).pauseDownloads();
                break;
            }
            case 4: {
                object = (Intent)Assertions.checkNotNull(object);
                object3 = "requirements";
                object = (Requirements)object.getParcelableExtra((String)object3);
                if (object == null) {
                    object = "Ignored SET_REQUIREMENTS: Missing requirements extra";
                    Log.e(string2, (String)object);
                    break;
                }
                object3 = this.getScheduler();
                if (object3 != null && (n13 = (int)(((Requirements)(object3 = object3.getSupportedRequirements((Requirements)object))).equals(object) ? 1 : 0)) == 0) {
                    n12 = ((Requirements)object).getRequirements();
                    n13 = ((Requirements)object3).getRequirements();
                    n12 ^= n13;
                    n13 = 65;
                    charSequence = new StringBuilder(n13);
                    object4 = "Ignoring requirements not supported by the Scheduler: ";
                    ((StringBuilder)charSequence).append((String)object4);
                    ((StringBuilder)charSequence).append(n12);
                    object = ((StringBuilder)charSequence).toString();
                    Log.w(string2, (String)object);
                    object = object3;
                }
                ((DownloadManager)object2).setRequirements((Requirements)object);
                break;
            }
            case 3: {
                ((DownloadManager)object2).removeAllDownloads();
                break;
            }
            case 1: {
                ((DownloadManager)object2).resumeDownloads();
                break;
            }
            case 0: {
                object4 = (Intent)Assertions.checkNotNull(object);
                charSequence = "download_request";
                object4 = (DownloadRequest)object4.getParcelableExtra((String)charSequence);
                if (object4 == null) {
                    object = "Ignored ADD_DOWNLOAD: Missing download_request extra";
                    Log.e(string2, (String)object);
                    break;
                }
                n12 = object.getIntExtra((String)object3, 0);
                ((DownloadManager)object2).addDownload((DownloadRequest)object4, n12);
            }
            case 2: 
            case 7: 
        }
        n12 = Util.SDK_INT;
        n11 = 26;
        if (n12 >= n11 && (n12 = (int)(this.startedInForeground ? 1 : 0)) != 0 && (object = this.foregroundNotificationUpdater) != null) {
            ((DownloadService$ForegroundNotificationUpdater)object).showNotificationIfNotAlready();
        }
        this.isStopped = false;
        n12 = (int)(((DownloadManager)object2).isIdle() ? 1 : 0);
        if (n12 != 0) {
            this.stop();
        }
        return n14;
    }

    public void onTaskRemoved(Intent intent) {
        this.taskRemoved = true;
    }
}

