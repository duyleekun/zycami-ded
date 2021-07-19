/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Environment
 *  android.text.TextUtils
 */
package com.zhiyun.net.download;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.zhiyun.net.api.entity.DownloadFile;
import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.SingleDownloadManager$1;
import com.zhiyun.net.download.SingleDownloadManager$SerialDownloadListener;
import com.zhiyun.net.download.SingleDownloadTask;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m.a.a;

public class SingleDownloadManager {
    private static final int STATE_EXIST_DOWNLOADING = 2;
    private static final int STATE_EXIST_NO_DOWNLOADING = 1;
    private static final int STATE_NO_EXIST = 0;
    private static final String TAG = "SingleDownloadManager";
    private static volatile SingleDownloadManager mInstance;
    private String DEFAULT_FILE_DIR;
    private SingleDownloadTask currentDownloadTask;
    private String currentDownloadUrl;
    private float downloadProgress;
    private Context mContext;
    private DownloadListener mDownloadListener;
    private ArrayDeque mDownloadTaskArrayDeque;
    private Map mDownloadTaskMap;
    private SingleDownloadManager$SerialDownloadListener mSerialDownloadListener;

    private SingleDownloadManager(Context object) {
        Object object2 = new ArrayDeque();
        this.mDownloadTaskArrayDeque = object2;
        this.downloadProgress = 0.0f;
        this.mDownloadListener = object2 = new SingleDownloadManager$1(this);
        this.mContext = object;
        this.mDownloadTaskMap = object;
    }

    public static /* synthetic */ float access$000(SingleDownloadManager singleDownloadManager) {
        return singleDownloadManager.downloadProgress;
    }

    public static /* synthetic */ float access$002(SingleDownloadManager singleDownloadManager, float f10) {
        singleDownloadManager.downloadProgress = f10;
        return f10;
    }

    public static /* synthetic */ SingleDownloadManager$SerialDownloadListener access$100(SingleDownloadManager singleDownloadManager) {
        return singleDownloadManager.mSerialDownloadListener;
    }

    public static /* synthetic */ String access$200(SingleDownloadManager singleDownloadManager) {
        return singleDownloadManager.currentDownloadUrl;
    }

    public static /* synthetic */ String access$202(SingleDownloadManager singleDownloadManager, String string2) {
        singleDownloadManager.currentDownloadUrl = string2;
        return string2;
    }

    public static /* synthetic */ SingleDownloadTask access$302(SingleDownloadManager singleDownloadManager, SingleDownloadTask singleDownloadTask) {
        singleDownloadManager.currentDownloadTask = singleDownloadTask;
        return singleDownloadTask;
    }

    public static /* synthetic */ void access$400(SingleDownloadManager singleDownloadManager) {
        singleDownloadManager.download();
    }

    private void download() {
        Object object = this.mDownloadTaskArrayDeque;
        boolean bl2 = ((ArrayDeque)object).isEmpty();
        if (bl2) {
            return;
        }
        object = this.currentDownloadTask;
        if (object != null && (bl2 = ((SingleDownloadTask)object).isDownloading())) {
            object = new Object[]{};
            a.b("currentDownloadTask is Downloading", (Object[])object);
            return;
        }
        object = (SingleDownloadTask)this.mDownloadTaskArrayDeque.pollFirst();
        this.currentDownloadTask = object;
        object = ((SingleDownloadTask)object).getDownloadFile().getUrl();
        this.currentDownloadUrl = object;
        object = this.currentDownloadTask;
        DownloadListener downloadListener = this.mDownloadListener;
        ((SingleDownloadTask)object).addDownloadListener(downloadListener);
        this.currentDownloadTask.start(false);
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
    public static SingleDownloadManager getInstance(Context context) {
        Object object = mInstance;
        if (object != null) return mInstance;
        object = SingleDownloadManager.class;
        synchronized (object) {
            SingleDownloadManager singleDownloadManager = mInstance;
            if (singleDownloadManager != null) return mInstance;
            mInstance = singleDownloadManager = new SingleDownloadManager(context);
            return mInstance;
        }
    }

    public void add(String string2, DownloadListener downloadListener) {
        this.add(string2, null, null, downloadListener);
    }

    public void add(String string2, String string3, DownloadListener downloadListener) {
        this.add(string2, string3, null, downloadListener);
    }

    public void add(String objectArray, String object, String string2, DownloadListener downloadListener) {
        int n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 != 0) {
            object = this.getDefaultDirectory();
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)string2)) != 0) {
            string2 = this.getFileName((String)objectArray);
        }
        n10 = 1;
        Object object2 = new String[n10];
        object2[0] = objectArray;
        boolean bl2 = this.isDownloading((String[])object2);
        if (!bl2) {
            object2 = this.mDownloadTaskMap;
            Context context = this.mContext;
            DownloadFile downloadFile = new DownloadFile(string2, (String)objectArray, (String)object);
            SingleDownloadTask singleDownloadTask = new SingleDownloadTask(context, downloadFile, downloadListener);
            object2.put(objectArray, singleDownloadTask);
            objectArray = new Object[n10];
            int n11 = this.mDownloadTaskMap.size();
            objectArray[0] = object = Integer.valueOf(n11);
            object = "size = %s";
            a.b((String)object, objectArray);
        }
    }

    public void addListener(String object, DownloadListener downloadListener) {
        Map map = this.mDownloadTaskMap;
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            map = this.mDownloadTaskMap;
            object = (SingleDownloadTask)map.get(object);
            ((SingleDownloadTask)object).addDownloadListener(downloadListener);
        }
    }

    public void addSerialDownloadTask(DownloadFile serializable) {
        serializable = this.mDownloadTaskArrayDeque;
        Context context = this.mContext;
        SingleDownloadTask singleDownloadTask = new SingleDownloadTask(context, (DownloadFile)serializable);
        boolean bl2 = ((ArrayDeque)serializable).contains(singleDownloadTask);
        if (!bl2) {
            serializable = this.mDownloadTaskArrayDeque;
            ((ArrayDeque)serializable).add(singleDownloadTask);
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
            Context context = this.mContext;
            SingleDownloadTask singleDownloadTask = new SingleDownloadTask(context, (DownloadFile)serializable);
            bl2 = ((ArrayDeque)serializable).contains(singleDownloadTask);
            if (bl2) continue;
            serializable = this.mDownloadTaskArrayDeque;
            ((ArrayDeque)serializable).add(singleDownloadTask);
        }
        this.download();
    }

    public void addUri(String objectArray, Uri object, String string2, DownloadListener downloadListener) {
        if (object == null) {
            return;
        }
        int n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n10 != 0) {
            string2 = this.getFileName((String)objectArray);
        }
        n10 = 1;
        Object object2 = new String[n10];
        object2[0] = objectArray;
        boolean bl2 = this.isDownloading((String[])object2);
        if (!bl2) {
            object2 = this.mDownloadTaskMap;
            Context context = this.mContext;
            DownloadFile downloadFile = new DownloadFile(string2, (String)objectArray, (Uri)object);
            SingleDownloadTask singleDownloadTask = new SingleDownloadTask(context, downloadFile, downloadListener);
            object2.put(objectArray, singleDownloadTask);
            objectArray = new Object[n10];
            int n11 = this.mDownloadTaskMap.size();
            object = n11;
            objectArray[0] = object;
            object = "size = %s";
            a.b((String)object, objectArray);
        }
    }

    public void cancel(String ... stringArray) {
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Map map = this.mDownloadTaskMap;
            Object object = stringArray[i10];
            boolean bl2 = map.containsKey(object);
            if (!bl2) continue;
            map = this.mDownloadTaskMap;
            object = (SingleDownloadTask)map.get(object);
            ((SingleDownloadTask)object).cancel();
        }
    }

    public void cancelAll() {
        boolean bl2;
        Iterator iterator2 = this.mDownloadTaskMap.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (String)iterator2.next();
            Map map = this.mDownloadTaskMap;
            object = (SingleDownloadTask)map.get(object);
            ((SingleDownloadTask)object).cancel();
        }
    }

    public void cancelSerialDownload() {
        boolean bl2;
        this.mDownloadTaskArrayDeque.clear();
        SingleDownloadTask singleDownloadTask = this.currentDownloadTask;
        if (singleDownloadTask != null && (bl2 = singleDownloadTask.isDownloading())) {
            singleDownloadTask = this.currentDownloadTask;
            singleDownloadTask.cancel();
        }
    }

    public void cancelSerialDownload(String object) {
        boolean bl2;
        boolean bl3;
        Object object2 = this.currentDownloadUrl;
        if (object2 != null && (bl3 = ((String)object2).equals(object))) {
            object = this.currentDownloadTask;
            boolean bl4 = ((SingleDownloadTask)object).isDownloading();
            if (bl4) {
                object = this.currentDownloadTask;
                ((SingleDownloadTask)object).cancel();
            }
            return;
        }
        bl3 = false;
        object2 = null;
        Iterator iterator2 = this.mDownloadTaskArrayDeque.iterator();
        while (bl2 = iterator2.hasNext()) {
            SingleDownloadTask singleDownloadTask = (SingleDownloadTask)iterator2.next();
            String string2 = singleDownloadTask.getDownloadFile().getUrl();
            boolean bl5 = string2.equals(object);
            if (!bl5) continue;
            object2 = singleDownloadTask;
        }
        if (object2 != null) {
            object = this.mDownloadTaskArrayDeque;
            ((ArrayDeque)object).remove(object2);
        }
    }

    public void download(boolean bl2, String ... stringArray) {
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.mDownloadTaskMap;
            Object object2 = stringArray[i10];
            boolean bl3 = object.containsKey(object2);
            if (!bl3) continue;
            object = new String[]{object2};
            bl3 = this.isDownloading((String[])object);
            if (bl3) continue;
            object = this.mDownloadTaskMap;
            object2 = (SingleDownloadTask)object.get(object2);
            ((SingleDownloadTask)object2).start(bl2);
        }
    }

    public int getUrlState(String object) {
        Map map = this.mDownloadTaskMap;
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            map = this.mDownloadTaskMap;
            boolean bl3 = ((SingleDownloadTask)(object = (SingleDownloadTask)map.get(object))).isDownloading();
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
        SingleDownloadTask singleDownloadTask = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Map map = this.mDownloadTaskMap;
            String string2 = stringArray[i10];
            boolean bl3 = map.containsKey(string2);
            if (!bl3) continue;
            singleDownloadTask = (SingleDownloadTask)this.mDownloadTaskMap.get(string2);
            bl2 = singleDownloadTask.isDownloading();
        }
        return bl2;
    }

    public void pause(String ... stringArray) {
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Map map = this.mDownloadTaskMap;
            Object object = stringArray[i10];
            boolean bl2 = map.containsKey(object);
            if (!bl2) continue;
            map = this.mDownloadTaskMap;
            object = (SingleDownloadTask)map.get(object);
            ((SingleDownloadTask)object).pause();
        }
    }

    public void pauseAll() {
        boolean bl2;
        Iterator iterator2 = this.mDownloadTaskMap.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (String)iterator2.next();
            Object object2 = (SingleDownloadTask)this.mDownloadTaskMap.get(object);
            boolean bl3 = ((SingleDownloadTask)object2).isDownloading();
            if (!bl3) continue;
            object2 = this.mDownloadTaskMap;
            object = (SingleDownloadTask)object2.get(object);
            ((SingleDownloadTask)object).pause();
        }
    }

    public void removeListener(String object, DownloadListener downloadListener) {
        Map map = this.mDownloadTaskMap;
        boolean bl2 = map.containsKey(object);
        if (bl2) {
            map = this.mDownloadTaskMap;
            object = (SingleDownloadTask)map.get(object);
            ((SingleDownloadTask)object).removeListener(downloadListener);
        }
    }

    public void setSerialDownloadListener(SingleDownloadManager$SerialDownloadListener singleDownloadManager$SerialDownloadListener) {
        this.mSerialDownloadListener = singleDownloadManager$SerialDownloadListener;
    }

    public void startDownload(String string2, Uri stringArray, String string3, DownloadListener downloadListener) {
        int n10 = this.getUrlState(string2);
        int n11 = 1;
        if (n10 != 0 && n10 != n11) {
            int n12 = 2;
            if (n10 == n12) {
                this.addListener(string2, downloadListener);
            }
        } else {
            this.addUri(string2, (Uri)stringArray, string3, downloadListener);
            stringArray = new String[n11];
            string3 = null;
            stringArray[0] = string2;
            this.download(false, stringArray);
        }
    }

    public void startDownload(String string2, String string3, String string4, DownloadListener downloadListener) {
        this.startDownload(string2, string3, string4, true, downloadListener);
    }

    public void startDownload(String string2, String stringArray, String string3, boolean bl2, DownloadListener downloadListener) {
        int n10 = this.getUrlState(string2);
        int n11 = 1;
        if (n10 != 0 && n10 != n11) {
            int n12 = 2;
            if (n10 == n12) {
                this.addListener(string2, downloadListener);
            }
        } else {
            this.add(string2, (String)stringArray, string3, downloadListener);
            stringArray = new String[n11];
            string3 = null;
            stringArray[0] = string2;
            this.download(bl2, stringArray);
        }
    }
}

