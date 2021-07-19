/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.data.me.remote;

import android.content.Context;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.zhiyun.cama.data.me.remote.AliyunManager$1;
import com.zhiyun.cama.data.me.remote.AliyunManager$2;
import com.zhiyun.cama.data.me.remote.AliyunManager$3;
import com.zhiyun.cama.data.me.remote.AliyunManager$4;
import com.zhiyun.cama.data.me.remote.AliyunManager$OnAliyunCallback;
import com.zhiyun.cama.data.me.remote.AliyunManager$OnAliyunProgressCallback;
import d.v.c.v0.u.c0.a;
import d.v.e.f;
import d.v.e.l.k2;
import java.io.File;

public class AliyunManager {
    public static final String BUCKETNAME = "zhiyundata";
    public static final String END = "oss-cn-shenzhen.aliyuncs.com";
    public static final String ENDPOINT = "http://oss-cn-shenzhen.aliyuncs.com";
    public static final String TAG = "AliyunManager";
    private static volatile AliyunManager mInstance;
    private OSS mOSS;

    private AliyunManager() {
        this.init();
    }

    public static /* synthetic */ void a(AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback, ResumableUploadRequest resumableUploadRequest, long l10, long l11) {
        if (aliyunManager$OnAliyunProgressCallback != null) {
            long l12 = 100;
            l10 = l10 * l12 / l11;
            int n10 = (int)l10;
            aliyunManager$OnAliyunProgressCallback.onProgress(n10);
        }
    }

    private String getAliyunPath() {
        return "zyplay";
    }

    private String getFileUrl(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://zhiyundata.oss-cn-shenzhen.aliyuncs.com/");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private void init() {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        int n10 = 15000;
        clientConfiguration.setConnectionTimeout(n10);
        clientConfiguration.setSocketTimeout(n10);
        clientConfiguration.setMaxConcurrentRequest(5);
        clientConfiguration.setMaxErrorRetry(2);
        AliyunManager$1 aliyunManager$1 = new AliyunManager$1(this);
        Context context = f.a().c();
        OSSClient oSSClient = new OSSClient(context, ENDPOINT, aliyunManager$1, clientConfiguration);
        this.mOSS = oSSClient;
    }

    public static AliyunManager instance() {
        AliyunManager aliyunManager = mInstance;
        if (aliyunManager == null) {
            mInstance = aliyunManager = new AliyunManager();
        }
        return mInstance;
    }

    private String uploadShareFile(String object, String string2, String string3, AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKETNAME, (String)object, string3);
        object = new AliyunManager$2(this, aliyunManager$OnAliyunProgressCallback);
        putObjectRequest.setProgressCallback((OSSProgressCallback)object);
        this.mOSS.putObject(putObjectRequest);
        return string2;
    }

    private void uploadShareFile(String object, String string2, String object2, AliyunManager$OnAliyunCallback aliyunManager$OnAliyunCallback) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKETNAME, (String)object, (String)object2);
        object = new AliyunManager$3(this, aliyunManager$OnAliyunCallback);
        putObjectRequest.setProgressCallback((OSSProgressCallback)object);
        object = this.mOSS;
        object2 = new AliyunManager$4(this, aliyunManager$OnAliyunCallback, string2);
        object.asyncPutObject(putObjectRequest, (OSSCompletedCallback)object2);
    }

    public String getAliyunObjectKey(String string2, String string3, String string4) {
        StringBuilder stringBuilder = new StringBuilder();
        String string5 = this.getAliyunPath();
        stringBuilder.append(string5);
        stringBuilder.append("/share/");
        stringBuilder.append(string2);
        string2 = "/";
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public String uploadAppealPicFile(String string2, String string3, AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback) {
        CharSequence charSequence = new StringBuilder();
        String string4 = this.getAliyunPath();
        charSequence.append(string4);
        charSequence.append("/audit_images/");
        charSequence.append(string2);
        string2 = charSequence.toString();
        charSequence = this.getFileUrl(string2);
        return this.uploadShareFile(string2, (String)charSequence, string3, aliyunManager$OnAliyunProgressCallback);
    }

    public String uploadCircleArticleFileSync(String string2, String string3, AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback) {
        CharSequence charSequence = new StringBuilder();
        String string4 = this.getAliyunPath();
        charSequence.append(string4);
        charSequence.append("/circle/post_images/");
        charSequence.append(string2);
        string2 = charSequence.toString();
        charSequence = this.getFileUrl(string2);
        return this.uploadShareFile(string2, (String)charSequence, string3, aliyunManager$OnAliyunProgressCallback);
    }

    public void uploadCircleAvatarFile(String string2, String string3, AliyunManager$OnAliyunCallback aliyunManager$OnAliyunCallback) {
        CharSequence charSequence = new StringBuilder();
        String string4 = this.getAliyunPath();
        charSequence.append(string4);
        charSequence.append("/circle/avatar/");
        charSequence.append(string2);
        string2 = charSequence.toString();
        charSequence = this.getFileUrl(string2);
        this.uploadShareFile(string2, (String)charSequence, string3, aliyunManager$OnAliyunCallback);
    }

    public void uploadFeedbackFile(String string2, String string3, AliyunManager$OnAliyunCallback aliyunManager$OnAliyunCallback) {
        CharSequence charSequence = new StringBuilder();
        String string4 = this.getAliyunPath();
        charSequence.append(string4);
        charSequence.append("/site_feedback/");
        charSequence.append(string2);
        string2 = charSequence.toString();
        charSequence = this.getFileUrl(string2);
        this.uploadShareFile(string2, (String)charSequence, string3, aliyunManager$OnAliyunCallback);
    }

    public String uploadFeedbackFileSync(String string2, String string3) {
        CharSequence charSequence = new StringBuilder();
        String string4 = this.getAliyunPath();
        charSequence.append(string4);
        charSequence.append("/site_feedback/");
        charSequence.append(string2);
        string2 = charSequence.toString();
        charSequence = this.getFileUrl(string2);
        return this.uploadShareFile(string2, (String)charSequence, string3, (AliyunManager$OnAliyunProgressCallback)null);
    }

    public String uploadFeedbackPicFile(String string2, String string3, AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback) {
        CharSequence charSequence = new StringBuilder();
        String string4 = this.getAliyunPath();
        charSequence.append(string4);
        charSequence.append("/site_feedback/");
        charSequence.append(string2);
        string2 = charSequence.toString();
        charSequence = this.getFileUrl(string2);
        return this.uploadShareFile(string2, (String)charSequence, string3, aliyunManager$OnAliyunProgressCallback);
    }

    public void uploadHeadImgFile(String string2, String string3, String string4, AliyunManager$OnAliyunCallback aliyunManager$OnAliyunCallback) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User_Avatar/");
        stringBuilder.append(string2);
        stringBuilder.append("/");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        string3 = this.getFileUrl(string2);
        this.uploadShareFile(string2, string3, string4, aliyunManager$OnAliyunCallback);
    }

    public void uploadShareFile(String string2, String string3, String string4, String string5, AliyunManager$OnAliyunCallback aliyunManager$OnAliyunCallback) {
        StringBuilder stringBuilder = new StringBuilder();
        String string6 = this.getAliyunPath();
        stringBuilder.append(string6);
        stringBuilder.append("/share/");
        stringBuilder.append(string3);
        string3 = "/";
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(string4);
        string2 = stringBuilder.toString();
        string3 = this.getFileUrl(string2);
        this.uploadShareFile(string2, string3, string5, aliyunManager$OnAliyunCallback);
    }

    public String uploadShareFileSync(String string2, String string3, AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback) {
        String string4 = this.getFileUrl(string2);
        return this.uploadShareFile(string2, string4, string3, aliyunManager$OnAliyunProgressCallback);
    }

    public String uploadShareResumeFileSync(String object, String string2, AliyunManager$OnAliyunProgressCallback aliyunManager$OnAliyunProgressCallback) {
        String string3 = k2.c().getAbsolutePath();
        Object object2 = new File(string3);
        boolean bl2 = ((File)object2).exists();
        if (!bl2) {
            ((File)object2).mkdirs();
        }
        object2 = this.getFileUrl((String)object);
        ResumableUploadRequest resumableUploadRequest = new ResumableUploadRequest(BUCKETNAME, (String)object, string2, string3);
        object = Boolean.FALSE;
        resumableUploadRequest.setDeleteUploadOnCancelling((Boolean)object);
        object = new a(aliyunManager$OnAliyunProgressCallback);
        resumableUploadRequest.setProgressCallback((OSSProgressCallback)object);
        this.mOSS.resumableUpload(resumableUploadRequest);
        return object2;
    }
}

