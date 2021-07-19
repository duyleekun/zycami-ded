/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.text.TextUtils
 */
package com.zhiyun.net.download;

import android.os.Environment;
import android.text.TextUtils;
import com.zhiyun.net.api.entity.DownloadFile;
import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.DownloadManager$SerialDownloadListener;
import com.zhiyun.net.download.DownloadTask;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m.a.a;

public class DownloadManager {
    private static final int DEFAULT_THREAD_COUNT = 3;
    private static final int SINGLE_THREAD_COUNT = 1;
    private static final int STATE_EXIST_DOWNLOADING = 2;
    private static final int STATE_EXIST_NO_DOWNLOADING = 1;
    private static final int STATE_NO_EXIST = 0;
    private static final String TAG = "DownloadManager";
    private static volatile DownloadManager mInstance;
    private String DEFAULT_FILE_DIR;
    private DownloadTask currentDownloadTask;
    private String currentDownloadUrl;
    private float downloadProgress = 0.0f;
    private DownloadListener mDownloadListener;
    private ArrayDeque mDownloadTaskArrayDeque;
    private Map mDownloadTaskMap;
    private DownloadManager$SerialDownloadListener mSerialDownloadListener;

    private DownloadManager() {
        HashMap hashMap = new HashMap();
        this.mDownloadTaskArrayDeque = hashMap;
        hashMap = new HashMap(this);
        this.mDownloadListener = hashMap;
        this.mDownloadTaskMap = hashMap = new HashMap();
    }

    public static /* synthetic */ float access$000(DownloadManager downloadManager) {
        return downloadManager.downloadProgress;
    }

    public static /* synthetic */ float access$002(DownloadManager downloadManager, float f10) {
        downloadManager.downloadProgress = f10;
        return f10;
    }

    public static /* synthetic */ DownloadManager$SerialDownloadListener access$100(DownloadManager downloadManager) {
        return downloadManager.mSerialDownloadListener;
    }

    public static /* synthetic */ String access$200(DownloadManager downloadManager) {
        return downloadManager.currentDownloadUrl;
    }

    public static /* synthetic */ String access$202(DownloadManager downloadManager, String string2) {
        downloadManager.currentDownloadUrl = string2;
        return string2;
    }

    public static /* synthetic */ DownloadTask access$302(DownloadManager downloadManager, DownloadTask downloadTask) {
        downloadManager.currentDownloadTask = downloadTask;
        return downloadTask;
    }

    public static /* synthetic */ void access$400(DownloadManager downloadManager) {
        downloadManager.download();
    }

    private void download() {
        Object object = this.mDownloadTaskArrayDeque;
        boolean bl2 = ((ArrayDeque)object).isEmpty();
        if (bl2) {
            return;
        }
        object = this.currentDownloadTask;
        if (object != null && (bl2 = ((DownloadTask)object).isDownloading())) {
            object = new Object[]{};
            a.b("currentDownloadTask is Downloading", (Object[])object);
            return;
        }
        object = (DownloadTask)this.mDownloadTaskArrayDeque.pollFirst();
        this.currentDownloadTask = object;
        object = ((DownloadTask)object).getDownloadFile().getUrl();
        this.currentDownloadUrl = object;
        object = this.currentDownloadTask;
        DownloadListener downloadListener = this.mDownloadListener;
        ((DownloadTask)object).addDownloadListener(downloadListener);
        this.currentDownloadTask.startSingleDownload();
    }

    private String getDefaultDirectory() {
        CharSequence charSequence = this.DEFAULT_FILE_DIR;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            charSequence = new StringBuilder();
            Object object = Environment.getExternalStorageDirectory();
            ((StringBuilder)charSequence).append(object);
            object = File.separator;
            ((StringBuilder)charSequence).append((String)object);
            String string2 = "ZYPlay";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            this.DEFAULT_FILE_DIR = charSequence;
        }
        return this.DEFAULT_FILE_DIR;
    }

    private String getFileName(String string2) {
        int n10 = string2.lastIndexOf("/") + 1;
        return string2.substring(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static DownloadManager getInstance() {
        Object object = mInstance;
        if (object != null) return mInstance;
        object = DownloadManager.class;
        synchronized (object) {
            DownloadManager downloadManager = mInstance;
            if (downloadManager != null) return mInstance;
            mInstance = downloadManager = new DownloadManager();
            return mInstance;
        }
    }

    public void add(String string2, DownloadListener downloadListener) {
        this.add(string2, null, null, downloadListener);
    }

    public void add(String string2, String string3, DownloadListener downloadListener) {
        this.add(string2, string3, null, downloadListener);
    }

    public void add(String string2, String string3, String string4, DownloadListener downloadListener) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (bl2) {
            string3 = this.getDefaultDirectory();
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string4)) {
            string4 = this.getFileName(string2);
        }
        Object object = new String[1];
        DownloadTask downloadTask = null;
        object[0] = string2;
        bl2 = this.isDownloading((String[])object);
        if (!bl2) {
            object = this.mDownloadTaskMap;
            DownloadFile downloadFile = new DownloadFile(string4, string2, string3);
            downloadTask = new DownloadTask(downloadFile, downloadListener);
            object.put(string2, downloadTask);
        }
    }

    public void addListener(String object, DownloadListener downloadListener) {
        Map map = this.mDownloadTaskMap;
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            map = this.mDownloadTaskMap;
            object = (DownloadTask)map.get(object);
            ((DownloadTask)object).addDownloadListener(downloadListener);
        }
    }

    public void addSerialDownloadTask(DownloadFile serializable) {
        serializable = this.mDownloadTaskArrayDeque;
        DownloadTask downloadTask = new DownloadTask((DownloadFile)serializable);
        boolean bl2 = ((ArrayDeque)serializable).contains(downloadTask);
        if (!bl2) {
            serializable = this.mDownloadTaskArrayDeque;
            ((ArrayDeque)serializable).add(downloadTask);
        }
        this.download();
    }

    public void addSerialDownloadTask(String string2) {
        this.addSerialDownloadTask(string2, null, null);
    }

    public void addSerialDownloadTask(String string2, String string3) {
        this.addSerialDownloadTask(string2, string3, null);
    }

    public void addSerialDownloadTask(String string2, String string3, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (bl2) {
            string3 = this.getDefaultDirectory();
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string4)) {
            string4 = this.getFileName(string2);
        }
        DownloadFile downloadFile = new DownloadFile(string4, string2, string3);
        this.addSerialDownloadTask(downloadFile);
    }

    public void addSerialDownloadTask(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Serializable serializable = (DownloadFile)object.next();
            serializable = this.mDownloadTaskArrayDeque;
            DownloadTask downloadTask = new DownloadTask((DownloadFile)serializable);
            bl2 = ((ArrayDeque)serializable).contains(downloadTask);
            if (bl2) continue;
            serializable = this.mDownloadTaskArrayDeque;
            ((ArrayDeque)serializable).add(downloadTask);
        }
        this.download();
    }

    public void cancel(String ... stringArray) {
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Map map = this.mDownloadTaskMap;
            String string2 = stringArray[i10];
            boolean bl2 = map.containsKey(string2);
            if (!bl2) continue;
            ((DownloadTask)this.mDownloadTaskMap.get(string2)).cancel();
            map = this.mDownloadTaskMap;
            map.remove(string2);
        }
    }

    public void cancelAll() {
        boolean bl2;
        Iterator iterator2 = this.mDownloadTaskMap.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            ((DownloadTask)this.mDownloadTaskMap.get(string2)).cancel();
            Map map = this.mDownloadTaskMap;
            map.remove(string2);
        }
    }

    public void cancelSerialDownload() {
        boolean bl2;
        this.mDownloadTaskArrayDeque.clear();
        DownloadTask downloadTask = this.currentDownloadTask;
        if (downloadTask != null && (bl2 = downloadTask.isDownloading())) {
            downloadTask = this.currentDownloadTask;
            downloadTask.cancel();
        }
    }

    public void cancelSerialDownload(String object) {
        boolean bl2;
        boolean bl3;
        Object object2 = this.currentDownloadUrl;
        if (object2 != null && (bl3 = ((String)object2).equals(object))) {
            object = this.currentDownloadTask;
            boolean bl4 = ((DownloadTask)object).isDownloading();
            if (bl4) {
                object = this.currentDownloadTask;
                ((DownloadTask)object).cancel();
            }
            return;
        }
        bl3 = false;
        object2 = null;
        Iterator iterator2 = this.mDownloadTaskArrayDeque.iterator();
        while (bl2 = iterator2.hasNext()) {
            DownloadTask downloadTask = (DownloadTask)iterator2.next();
            String string2 = downloadTask.getDownloadFile().getUrl();
            boolean bl5 = string2.equals(object);
            if (!bl5) continue;
            object2 = downloadTask;
        }
        if (object2 != null) {
            object = this.mDownloadTaskArrayDeque;
            ((ArrayDeque)object).remove(object2);
        }
    }

    public void download(String ... stringArray) {
        this.downloadWithCount(3, stringArray);
    }

    public void downloadWithCount(int n10, String ... stringArray) {
        int n11 = stringArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object = this.mDownloadTaskMap;
            Object object2 = stringArray[i10];
            boolean bl2 = object.containsKey(object2);
            if (!bl2) continue;
            object = new String[]{object2};
            bl2 = this.isDownloading((String[])object);
            if (bl2) continue;
            ((DownloadTask)this.mDownloadTaskMap.get(object2)).setThreadCount(n10);
            object = this.mDownloadTaskMap;
            object2 = (DownloadTask)object.get(object2);
            ((DownloadTask)object2).start();
        }
    }

    public int getUrlState(String object) {
        Map map = this.mDownloadTaskMap;
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            map = this.mDownloadTaskMap;
            boolean bl3 = ((DownloadTask)(object = (DownloadTask)map.get(object))).isDownloading();
            if (bl3) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public boolean isContainUrl(String string2) {
        return this.mDownloadTaskMap.containsKey(string2);
    }

    public boolean isDownloading(String ... stringArray) {
        int n10 = stringArray.length;
        boolean bl2 = false;
        DownloadTask downloadTask = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Map map = this.mDownloadTaskMap;
            String string2 = stringArray[i10];
            boolean bl3 = map.containsKey(string2);
            if (!bl3) continue;
            downloadTask = (DownloadTask)this.mDownloadTaskMap.get(string2);
            bl2 = downloadTask.isDownloading();
        }
        return bl2;
    }

    public void pause(String ... stringArray) {
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Map map = this.mDownloadTaskMap;
            String string2 = stringArray[i10];
            boolean bl2 = map.containsKey(string2);
            if (!bl2) continue;
            ((DownloadTask)this.mDownloadTaskMap.get(string2)).pause();
            map = this.mDownloadTaskMap;
            map.remove(string2);
        }
    }

    public void pauseAll() {
        boolean bl2;
        Iterator iterator2 = this.mDownloadTaskMap.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            Object object = (DownloadTask)this.mDownloadTaskMap.get(string2);
            boolean bl3 = ((DownloadTask)object).isDownloading();
            if (!bl3) continue;
            ((DownloadTask)this.mDownloadTaskMap.get(string2)).pause();
            object = this.mDownloadTaskMap;
            object.remove(string2);
        }
    }

    public void removeListener(String ... stringArray) {
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Map map = this.mDownloadTaskMap;
            Object object = stringArray[i10];
            boolean bl2 = map.containsKey(object);
            if (!bl2) continue;
            map = this.mDownloadTaskMap;
            object = (DownloadTask)map.get(object);
            ((DownloadTask)object).removeListener();
        }
    }

    public void setSerialDownloadListener(DownloadManager$SerialDownloadListener downloadManager$SerialDownloadListener) {
        this.mSerialDownloadListener = downloadManager$SerialDownloadListener;
    }

    public void singleDownload(String ... stringArray) {
        this.downloadWithCount(1, stringArray);
    }

    public void startDownload(String string2, String stringArray, String string3, DownloadListener downloadListener) {
        int n10 = this.getUrlState(string2);
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                int n12 = 2;
                if (n10 == n12) {
                    this.addListener(string2, downloadListener);
                }
            } else {
                stringArray = new String[n11];
                stringArray[0] = string2;
                this.download(stringArray);
                this.addListener(string2, downloadListener);
            }
        } else {
            this.add(string2, (String)stringArray, string3, downloadListener);
            stringArray = new String[n11];
            stringArray[0] = string2;
            this.download(stringArray);
        }
    }

    public void startSingleDownload(String string2, String stringArray, String string3, DownloadListener downloadListener) {
        int n10 = this.getUrlState(string2);
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                int n12 = 2;
                if (n10 == n12) {
                    this.addListener(string2, downloadListener);
                }
            } else {
                stringArray = new String[n11];
                stringArray[0] = string2;
                this.singleDownload(stringArray);
                this.addListener(string2, downloadListener);
            }
        } else {
            this.add(string2, (String)stringArray, string3, downloadListener);
            stringArray = new String[n11];
            stringArray[0] = string2;
            this.singleDownload(stringArray);
        }
    }
}

