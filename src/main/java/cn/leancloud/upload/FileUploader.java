/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.upload.FileUploadToken;
import cn.leancloud.upload.HttpClientUploader;
import cn.leancloud.upload.QCloudUploader;
import cn.leancloud.upload.QiniuSlicingUploader;
import cn.leancloud.upload.S3Uploader;
import cn.leancloud.upload.Uploader;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.HashMap;

public class FileUploader
extends HttpClientUploader {
    public static HashMap UPLOAD_HEADERS;
    public static final int gProgressComplete = 100;
    public static final int gProgressGotToken = 10;
    public static final int gProgressUploadedFile = 90;
    public static final String gProviderQCloud = "qcloud";
    public static final String gProviderS3 = "s3";
    private static AVLogger logger;
    private String bucket;
    private String provider;
    private String token;
    private String uploadUrl;

    static {
        HashMap hashMap;
        logger = LogUtil.getLogger(FileUploader.class);
        UPLOAD_HEADERS = hashMap = new HashMap();
    }

    public FileUploader(AVFile object, FileUploadToken fileUploadToken, ProgressCallback progressCallback) {
        super((AVFile)object, progressCallback);
        this.token = object = fileUploadToken.getToken();
        this.bucket = object = fileUploadToken.getBucket();
        this.uploadUrl = object = fileUploadToken.getUploadUrl();
        this.provider = object = fileUploadToken.getProvider();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void completeFileUpload(boolean bl2) {
        String string2 = this.token;
        boolean bl3 = StringUtil.isEmpty(string2);
        if (bl3) return;
        bl3 = false;
        string2 = null;
        try {
            JSONObject jSONObject = JSONObject$Builder.create(null);
            String string3 = "result";
            Object object = bl2;
            jSONObject.put(string3, object);
            object = "token";
            string3 = this.token;
            jSONObject.put(object, string3);
            object = PaasClient.getStorageClient();
            ((StorageClient)object).fileCallback(null, jSONObject);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private Uploader getUploaderImplementation() {
        Object object = this.provider;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            Object object2 = gProviderQCloud;
            object = this.provider;
            bl2 = ((String)object2).equalsIgnoreCase((String)object);
            if (bl2) {
                object2 = this.avFile;
                String string2 = this.token;
                String string3 = this.uploadUrl;
                ProgressCallback progressCallback = this.progressCallback;
                object = new QCloudUploader((AVFile)object2, string2, string3, progressCallback);
                return object;
            }
            object2 = gProviderS3;
            object = this.provider;
            bl2 = ((String)object2).equalsIgnoreCase((String)object);
            if (bl2) {
                object2 = this.avFile;
                String string4 = this.uploadUrl;
                ProgressCallback progressCallback = this.progressCallback;
                object = new S3Uploader((AVFile)object2, string4, progressCallback);
                return object;
            }
            object2 = this.avFile;
            String string5 = this.token;
            String string6 = this.uploadUrl;
            ProgressCallback progressCallback = this.progressCallback;
            object = new QiniuSlicingUploader((AVFile)object2, string5, string6, progressCallback);
            return object;
        }
        logger.w("provider doesnot exist, cannot upload any file.");
        return null;
    }

    public static void setUploadHeader(String string2, String string3) {
        UPLOAD_HEADERS.put(string2, string3);
    }

    public AVException execute() {
        int n10 = 10;
        this.publishProgress(n10);
        Object object = this.getUploaderImplementation();
        if (object == null) {
            Throwable throwable = new Throwable("Uploader can not be instantiated.");
            object = new AVException(throwable);
            return object;
        }
        if ((object = object.execute()) == null) {
            this.publishProgress(100);
            this.completeFileUpload(true);
            return null;
        }
        this.completeFileUpload(false);
        return object;
    }
}

