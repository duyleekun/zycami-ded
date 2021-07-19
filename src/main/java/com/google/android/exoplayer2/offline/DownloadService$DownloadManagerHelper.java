/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadManager$Listener;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.offline.DownloadService$1;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.k0.k;
import java.util.List;

public final class DownloadService$DownloadManagerHelper
implements DownloadManager$Listener {
    private final Context context;
    private final DownloadManager downloadManager;
    private DownloadService downloadService;
    private final boolean foregroundAllowed;
    private final Scheduler scheduler;
    private final Class serviceClass;

    private DownloadService$DownloadManagerHelper(Context context, DownloadManager downloadManager, boolean bl2, Scheduler scheduler, Class clazz) {
        this.context = context;
        this.downloadManager = downloadManager;
        this.foregroundAllowed = bl2;
        this.scheduler = scheduler;
        this.serviceClass = clazz;
        downloadManager.addListener(this);
        this.updateScheduler();
    }

    public /* synthetic */ DownloadService$DownloadManagerHelper(Context context, DownloadManager downloadManager, boolean bl2, Scheduler scheduler, Class clazz, DownloadService$1 downloadService$1) {
        this(context, downloadManager, bl2, scheduler, clazz);
    }

    private /* synthetic */ void a(DownloadService downloadService) {
        List list = this.downloadManager.getCurrentDownloads();
        DownloadService.access$300(downloadService, list);
    }

    public static /* synthetic */ DownloadManager access$100(DownloadService$DownloadManagerHelper downloadService$DownloadManagerHelper) {
        return downloadService$DownloadManagerHelper.downloadManager;
    }

    private void restartService() {
        boolean bl2 = this.foregroundAllowed;
        if (bl2) {
            Context context = this.context;
            Class clazz = this.serviceClass;
            String string2 = "com.google.android.exoplayer.downloadService.action.RESTART";
            context = DownloadService.access$900(context, clazz, string2);
            clazz = this.context;
            Util.startForegroundService((Context)clazz, (Intent)context);
        } else {
            Object object = this.context;
            Object object2 = this.serviceClass;
            String string3 = "com.google.android.exoplayer.downloadService.action.INIT";
            object = DownloadService.access$900(object, (Class)object2, string3);
            object2 = this.context;
            try {
                object2.startService((Intent)object);
            }
            catch (IllegalStateException illegalStateException) {
                object = "DownloadService";
                object2 = "Failed to restart DownloadService (process is idle).";
                Log.w((String)object, (String)object2);
            }
        }
    }

    private boolean serviceMayNeedRestart() {
        boolean bl2;
        DownloadService downloadService = this.downloadService;
        if (downloadService != null && !(bl2 = DownloadService.access$800(downloadService))) {
            bl2 = false;
            downloadService = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private void updateScheduler() {
        Object object = this.scheduler;
        if (object == null) {
            return;
        }
        object = this.downloadManager;
        boolean bl2 = ((DownloadManager)object).isWaitingForRequirements();
        if (bl2) {
            String string2;
            object = this.context.getPackageName();
            Scheduler scheduler = this.scheduler;
            Object object2 = this.downloadManager.getRequirements();
            bl2 = scheduler.schedule((Requirements)object2, (String)object, string2 = "com.google.android.exoplayer.downloadService.action.RESTART");
            if (!bl2) {
                object = "DownloadService";
                object2 = "Scheduling downloads failed.";
                Log.e((String)object, (String)object2);
            }
        } else {
            object = this.scheduler;
            object.cancel();
        }
    }

    public void attachService(DownloadService downloadService) {
        boolean bl2;
        Object object = this.downloadService;
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkState(bl2);
        this.downloadService = downloadService;
        object = this.downloadManager;
        bl2 = ((DownloadManager)object).isInitialized();
        if (bl2) {
            object = Util.createHandlerForCurrentOrMainLooper();
            k k10 = new k(this, downloadService);
            object.postAtFrontOfQueue(k10);
        }
    }

    public /* synthetic */ void b(DownloadService downloadService) {
        this.a(downloadService);
    }

    public void detachService(DownloadService object) {
        boolean bl2;
        DownloadService downloadService = this.downloadService;
        if (downloadService == object) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkState(bl2);
        bl2 = false;
        this.downloadService = null;
        object = this.scheduler;
        if (object != null && !(bl2 = ((DownloadManager)(object = this.downloadManager)).isWaitingForRequirements())) {
            object = this.scheduler;
            object.cancel();
        }
    }

    public void onDownloadChanged(DownloadManager object, Download object2, Exception exception) {
        boolean bl2;
        object = this.downloadService;
        if (object != null) {
            DownloadService.access$400((DownloadService)((Object)object), (Download)object2);
        }
        if ((bl2 = this.serviceMayNeedRestart()) && (bl2 = DownloadService.access$500(((Download)object2).state))) {
            object = "DownloadService";
            object2 = "DownloadService wasn't running. Restarting.";
            Log.w((String)object, (String)object2);
            this.restartService();
        }
    }

    public void onDownloadRemoved(DownloadManager object, Download download) {
        object = this.downloadService;
        if (object != null) {
            DownloadService.access$600((DownloadService)((Object)object), download);
        }
    }

    public final void onIdle(DownloadManager object) {
        object = this.downloadService;
        if (object != null) {
            DownloadService.access$700((DownloadService)((Object)object));
        }
    }

    public void onInitialized(DownloadManager object) {
        DownloadService downloadService = this.downloadService;
        if (downloadService != null) {
            object = ((DownloadManager)object).getCurrentDownloads();
            DownloadService.access$300(downloadService, (List)object);
        }
    }

    public void onWaitingForRequirementsChanged(DownloadManager object, boolean n10) {
        if (n10 == 0 && (n10 = ((DownloadManager)object).getDownloadsPaused()) == 0 && (n10 = this.serviceMayNeedRestart()) != 0) {
            int n11;
            object = ((DownloadManager)object).getCurrentDownloads();
            for (n10 = 0; n10 < (n11 = object.size()); ++n10) {
                Download download = (Download)object.get(n10);
                n11 = download.state;
                if (n11 != 0) continue;
                this.restartService();
                break;
            }
        }
        this.updateScheduler();
    }
}

