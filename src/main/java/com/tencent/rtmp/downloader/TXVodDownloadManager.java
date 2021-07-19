/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.tencent.rtmp.downloader;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ijk.media.player.IjkDownloadCenter;
import com.tencent.ijk.media.player.IjkDownloadCenter$OnDownloadListener;
import com.tencent.ijk.media.player.IjkDownloadMedia;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.f;
import com.tencent.liteav.network.g;
import com.tencent.liteav.network.i;
import com.tencent.liteav.network.j;
import com.tencent.rtmp.TXPlayerAuthBuilder;
import com.tencent.rtmp.downloader.ITXVodDownloadListener;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.rtmp.downloader.TXVodDownloadManager$1;
import com.tencent.rtmp.downloader.TXVodDownloadMediaInfo;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TXVodDownloadManager {
    public static final int DOWNLOAD_AUTH_FAILED = 60535;
    public static final int DOWNLOAD_DISCONNECT = 60531;
    public static final int DOWNLOAD_FORMAT_ERROR = 60532;
    public static final int DOWNLOAD_HLS_KEY_ERROR = 60530;
    public static final int DOWNLOAD_NO_FILE = 60533;
    public static final int DOWNLOAD_PATH_ERROR = 60529;
    public static final int DOWNLOAD_SUCCESS = 0;
    private static final int IJKDM_EVT_FILE_OPEN_ERROR = 1008;
    private static final int IJKDM_EVT_HLS_KEY_ERROR = 1008;
    private static final int IJKDM_EVT_NET_DISCONNECT = 1001;
    private static final String TAG = "TXVodDownloadManager";
    private static TXVodDownloadManager instance;
    public IjkDownloadCenter mDownloadCenter;
    public IjkDownloadCenter$OnDownloadListener mDownloadCenterListener;
    public String mDownloadPath;
    public Map mHeaders;
    public ITXVodDownloadListener mListener;
    public ArrayList mMediaInfoArray;

    private TXVodDownloadManager() {
        ArrayList arrayList = new ArrayList(this);
        this.mDownloadCenterListener = arrayList;
        arrayList = IjkDownloadCenter.getInstance();
        this.mDownloadCenter = arrayList;
        IjkDownloadCenter$OnDownloadListener ijkDownloadCenter$OnDownloadListener = this.mDownloadCenterListener;
        ((IjkDownloadCenter)((Object)arrayList)).setListener(ijkDownloadCenter$OnDownloadListener);
        this.mMediaInfoArray = arrayList = new ArrayList();
    }

    public static TXVodDownloadManager getInstance() {
        TXVodDownloadManager tXVodDownloadManager = instance;
        if (tXVodDownloadManager == null) {
            instance = tXVodDownloadManager = new TXVodDownloadManager();
        }
        return instance;
    }

    public static String md5(String object) {
        String string2;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string3 = "";
        if (n10 != 0) {
            return string3;
        }
        Object object2 = "MD5";
        object2 = MessageDigest.getInstance((String)object2);
        object = ((String)object).getBytes();
        object = ((MessageDigest)object2).digest((byte[])object);
        try {
            n10 = ((Object)object).length;
            string2 = string3;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            TXCLog.e(TAG, "md5 failed.", noSuchAlgorithmException);
            return string3;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            StringBuilder stringBuilder;
            String string4;
            block18: {
                int n11 = object[i10] & 0xFF;
                string4 = Integer.toHexString(n11);
                int n12 = string4.length();
                int n13 = 1;
                if (n12 != n13) break block18;
                stringBuilder = new StringBuilder();
                String string5 = "0";
                stringBuilder.append(string5);
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string4);
            string2 = stringBuilder.toString();
            continue;
        }
        return string2;
    }

    public TXVodDownloadMediaInfo convertMedia(IjkDownloadMedia ijkDownloadMedia) {
        boolean bl2;
        Iterator iterator2 = this.mMediaInfoArray.iterator();
        while (bl2 = iterator2.hasNext()) {
            int n10;
            TXVodDownloadMediaInfo tXVodDownloadMediaInfo = (TXVodDownloadMediaInfo)iterator2.next();
            int n11 = tXVodDownloadMediaInfo.tid;
            int n12 = ijkDownloadMedia.tid;
            if (n11 != n12) continue;
            tXVodDownloadMediaInfo.downloadSize = n10 = ijkDownloadMedia.downloadSize;
            n10 = tXVodDownloadMediaInfo.size;
            if (n10 == 0) {
                int n13;
                tXVodDownloadMediaInfo.size = n13 = ijkDownloadMedia.size;
            }
            return tXVodDownloadMediaInfo;
        }
        return null;
    }

    public boolean deleteDownloadFile(String string2) {
        boolean bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("delete file ");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        String string3 = TAG;
        TXCLog.d(string3, (String)object);
        object = this.mMediaInfoArray.iterator();
        while (bl2 = object.hasNext()) {
            String string4 = ((TXVodDownloadMediaInfo)object.next()).playPath;
            if (string4 == null || !(bl2 = string4.equals(string2))) continue;
            TXCLog.e(string3, "file is downloading, can not be delete");
            return false;
        }
        object = new File(string2);
        ((File)object).delete();
        TXCLog.e(string3, "delete success");
        return true;
    }

    public void downloadMedia(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        Object object = tXVodDownloadMediaInfo.url;
        if (object == null) {
            return;
        }
        Object object2 = Uri.parse((String)object).getPath();
        String string2 = ".m3u8";
        boolean n10 = ((String)object2).endsWith(string2);
        int n11 = -5004;
        String string3 = TAG;
        if (n10) {
            int n12;
            CharSequence charSequence;
            int n13;
            object2 = this.makePlayPath((String)object);
            tXVodDownloadMediaInfo.playPath = object2;
            if (object2 == null) {
                object = this.mListener;
                if (object != null) {
                    int n14 = -5007;
                    string2 = "Failed to create local path";
                    object.onDownloadError(tXVodDownloadMediaInfo, n14, string2);
                }
                return;
            }
            object2 = tXVodDownloadMediaInfo.dataSource;
            if (object2 != null && (object2 = ((TXVodDownloadDataSource)object2).token) != null && (n13 = ((String[])(object2 = ((String)object).split("/"))).length) > 0) {
                n13 = ((String[])object2).length + -1;
                object2 = object2[n13];
                int n15 = ((String)object).lastIndexOf((String)object2);
                charSequence = new StringBuilder();
                String string4 = ((String)object).substring(0, n15);
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append("voddrm.token.");
                string4 = tXVodDownloadMediaInfo.dataSource.token;
                ((StringBuilder)charSequence).append(string4);
                string4 = ".";
                ((StringBuilder)charSequence).append(string4);
                object = ((String)object).substring(n15);
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("download hls ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" to ");
            charSequence = tXVodDownloadMediaInfo.playPath;
            ((StringBuilder)object2).append((String)charSequence);
            object2 = ((StringBuilder)object2).toString();
            TXCLog.d(string3, (String)object2);
            object2 = this.mDownloadCenter;
            charSequence = tXVodDownloadMediaInfo.playPath;
            tXVodDownloadMediaInfo.tid = n12 = ((IjkDownloadCenter)object2).downloadHls((String)object, (String)charSequence);
            if (n12 < 0) {
                TXCLog.e(string3, "start download failed");
                object = this.mListener;
                if (object != null) {
                    object2 = "Internal error";
                    object.onDownloadError(tXVodDownloadMediaInfo, n11, (String)object2);
                }
            }
            return;
        }
        object2 = new StringBuilder();
        String string5 = "format error: ";
        ((StringBuilder)object2).append(string5);
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        TXCLog.e(string3, (String)object);
        object = this.mListener;
        if (object != null) {
            object2 = "No support format";
            object.onDownloadError(tXVodDownloadMediaInfo, n11, (String)object2);
        }
    }

    public j getClassificationSource(i object, int n10) {
        if (n10 == 0) {
            object = ((i)object).d();
        } else {
            String string2 = TXVodDownloadDataSource.qualityToId(n10);
            String string3 = "hls";
            object = ((i)object).a(string2, string3);
        }
        return object;
    }

    public j getTemplateSource(i i10, String string2) {
        return i10.b(string2, "hls");
    }

    public String makePlayPath(String charSequence) {
        String string2;
        boolean bl2;
        CharSequence charSequence2 = new StringBuilder();
        Object object = this.mDownloadPath;
        charSequence2.append((String)object);
        charSequence2.append("/txdownload");
        charSequence2 = charSequence2.toString();
        object = new File((String)charSequence2);
        boolean bl3 = ((File)object).exists();
        String string3 = TAG;
        if (!(bl3 && (bl3 = ((File)object).isDirectory()) || (bl2 = ((File)object).mkdir()))) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Failed to create download path");
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.e(string3, (String)charSequence);
            return null;
        }
        object = Uri.parse((String)charSequence).getPath();
        bl2 = ((String)object).endsWith(string2 = ".m3u8");
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence2);
            ((StringBuilder)object).append("/");
            charSequence = TXVodDownloadManager.md5((String)charSequence);
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(".m3u8.sqlite");
            return ((StringBuilder)object).toString();
        }
        TXCLog.e(string3, "Unsupported format");
        return null;
    }

    public void setDownloadPath(String string2) {
        if (string2 == null) {
            return;
        }
        File file = new File(string2);
        file.mkdirs();
        this.mDownloadPath = string2;
    }

    public void setHeaders(Map map) {
        this.mHeaders = map;
        this.mDownloadCenter.setHeaders(map);
    }

    public void setListener(ITXVodDownloadListener iTXVodDownloadListener) {
        this.mListener = iTXVodDownloadListener;
    }

    public TXVodDownloadMediaInfo startDownload(TXVodDownloadDataSource object) {
        Object object2 = new TXVodDownloadMediaInfo();
        ((TXVodDownloadMediaInfo)object2).dataSource = object;
        TXPlayerAuthBuilder tXPlayerAuthBuilder = ((TXVodDownloadDataSource)object).authBuilder;
        if (tXPlayerAuthBuilder != null) {
            f f10 = new f();
            boolean bl2 = tXPlayerAuthBuilder.isHttps();
            f10.a(bl2);
            Object object3 = new TXVodDownloadManager$1(this, (TXVodDownloadMediaInfo)object2, (TXVodDownloadDataSource)object);
            f10.a((g)object3);
            int n10 = tXPlayerAuthBuilder.getAppId();
            String string2 = tXPlayerAuthBuilder.getFileId();
            String string3 = tXPlayerAuthBuilder.getTimeout();
            String string4 = tXPlayerAuthBuilder.getUs();
            int n11 = tXPlayerAuthBuilder.getExper();
            String string5 = tXPlayerAuthBuilder.getSign();
            object3 = f10;
            int n12 = f10.a(n10, string2, string3, string4, n11, string5);
            if (n12 == 0) {
                ((TXVodDownloadMediaInfo)object2).netApi = f10;
                this.mMediaInfoArray.add(object2);
                return object2;
            }
            object = TAG;
            object2 = "unable to getPlayInfo";
            TXCLog.e((String)object, (String)object2);
        }
        return null;
    }

    public TXVodDownloadMediaInfo startDownloadUrl(String string2) {
        TXVodDownloadMediaInfo tXVodDownloadMediaInfo = new TXVodDownloadMediaInfo();
        tXVodDownloadMediaInfo.url = string2;
        this.mMediaInfoArray.add(tXVodDownloadMediaInfo);
        this.downloadMedia(tXVodDownloadMediaInfo);
        return tXVodDownloadMediaInfo;
    }

    public void stopDownload(TXVodDownloadMediaInfo object) {
        if (object == null) {
            return;
        }
        ((TXVodDownloadMediaInfo)object).isStop = true;
        int n10 = ((TXVodDownloadMediaInfo)object).tid;
        String string2 = TAG;
        if (n10 < 0) {
            TXCLog.w(string2, "stop download not start task");
            return;
        }
        this.mDownloadCenter.stop(n10);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stop download ");
        object = ((TXVodDownloadMediaInfo)object).url;
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        TXCLog.d(string2, (String)object);
    }
}

