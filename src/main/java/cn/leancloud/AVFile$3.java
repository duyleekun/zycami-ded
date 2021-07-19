/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVFile;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.upload.FileUploadToken;
import cn.leancloud.upload.FileUploader;
import e.a.v0.o;
import java.io.IOException;

public class AVFile$3
implements o {
    public final /* synthetic */ AVFile this$0;
    public final /* synthetic */ AVUser val$asAuthenticatedUser;
    public final /* synthetic */ ProgressCallback val$callback;

    public AVFile$3(AVFile aVFile, ProgressCallback progressCallback, AVUser aVUser) {
        this.this$0 = aVFile;
        this.val$callback = progressCallback;
        this.val$asAuthenticatedUser = aVUser;
    }

    public AVFile apply(FileUploadToken object) {
        Object object2;
        AVLogger aVLogger;
        block8: {
            boolean bl2;
            aVLogger = AVObject.logger;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("[Thread:");
            long l10 = Thread.currentThread().getId();
            ((StringBuilder)object2).append(l10);
            ((StringBuilder)object2).append("]");
            Object object3 = ((FileUploadToken)object).toString();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(", ");
            object3 = this.this$0;
            ((StringBuilder)object2).append(object3);
            object2 = ((StringBuilder)object2).toString();
            aVLogger.d((String)object2);
            object2 = this.this$0;
            object3 = ((FileUploadToken)object).getObjectId();
            ((AVObject)object2).setObjectId((String)object3);
            object2 = this.this$0;
            object3 = ((FileUploadToken)object).getObjectId();
            AVFile.access$000((AVFile)object2, "objectId", object3);
            object2 = this.this$0;
            object3 = ((FileUploadToken)object).getBucket();
            AVFile.access$000((AVFile)object2, "bucket", object3);
            object2 = this.this$0;
            object3 = ((FileUploadToken)object).getProvider();
            AVFile.access$000((AVFile)object2, "provider", object3);
            object2 = this.this$0;
            object3 = ((FileUploadToken)object).getKey();
            AVFile.access$000((AVFile)object2, "key", object3);
            object3 = this.this$0;
            Object object4 = this.val$callback;
            object2 = new FileUploader((AVFile)object3, (FileUploadToken)object, (ProgressCallback)object4);
            object3 = this.this$0;
            object4 = ((FileUploadToken)object).getUrl();
            String string2 = "url";
            AVFile.access$000((AVFile)object3, string2, object4);
            object2 = object2.execute();
            object3 = JSONObject$Builder.create(null);
            if (object2 == null) {
                bl2 = true;
            } else {
                bl2 = false;
                object4 = null;
            }
            object4 = bl2;
            string2 = "result";
            object3.put(string2, object4);
            object = ((FileUploadToken)object).getToken();
            object3.put("token", object);
            object = new StringBuilder();
            ((StringBuilder)object).append("file upload result: ");
            object4 = ((JSONObject)object3).toJSONString();
            ((StringBuilder)object).append((String)object4);
            object = ((StringBuilder)object).toString();
            aVLogger.d((String)object);
            try {
                object = PaasClient.getStorageClient();
            }
            catch (IOException iOException) {
                AVObject.logger.w(iOException);
                throw iOException;
            }
            object4 = this.val$asAuthenticatedUser;
            ((StorageClient)object).fileCallback((AVUser)object4, (JSONObject)object3);
            if (object2 != null) break block8;
            return this.this$0;
        }
        object = "failed to invoke fileCallback. cause:";
        aVLogger.w((String)object, (Throwable)object2);
        throw object2;
    }
}

