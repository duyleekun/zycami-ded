/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.codec.SHA1;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.upload.FileUploader;
import cn.leancloud.upload.FileUploader$FileUploadProgressCallback;
import cn.leancloud.upload.FileUploader$ProgressCalculator;
import cn.leancloud.upload.HttpClientUploader;
import cn.leancloud.upload.QCloudUploader$1;
import cn.leancloud.upload.QCloudUploader$SliceUploadTask;
import cn.leancloud.utils.StringUtil;
import g.a0;
import g.a0$a;
import g.b0;
import g.c0;
import g.d0;
import g.v;
import g.w$a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class QCloudUploader
extends HttpClientUploader {
    private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    private static final int DEFAULT_SLICE_LEN = 524288;
    private static final String FILE_CONTENT = "filecontent";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final String OP_UPLOAD = "upload";
    private static final String OP_UPLOAD_SLICE = "upload_slice";
    private static final String PARAM_ACCESS_URL = "access_url";
    private static final String PARAM_FILE_SIZE = "filesize";
    private static final String PARAM_OFFSET = "offset";
    private static final String PARAM_OP = "op";
    private static final String PARAM_SESSION = "session";
    private static final String PARAM_SHA = "sha";
    private static final String PARAM_SLICE_SIZE = "slice_size";
    private static final int RETRY_TIMES = 5;
    private String fileKey;
    private String fileSha;
    private volatile Future[] tasks;
    private String token;
    private String uploadUrl;

    public QCloudUploader(AVFile object, String string2, String string3, ProgressCallback progressCallback) {
        super((AVFile)object, progressCallback);
        this.fileKey = object = ((AVFile)object).getKey();
        this.uploadUrl = string3;
        this.token = string2;
    }

    public static /* synthetic */ int access$000(int n10, int n11) {
        return QCloudUploader.getCurrentSliceLength(n10, n11);
    }

    private static int getCurrentSliceLength(int n10, int n11) {
        int n12 = 524288;
        if ((n11 -= (n10 *= n12)) < n12) {
            n12 = n11;
        }
        return n12;
    }

    private static JSONObject parseSliceUploadResponse(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            String string2;
            try {
                object = JSON.parseObject((String)object);
                string2 = "data";
            }
            catch (Exception exception) {}
            return ((JSONObject)object).getJSONObject(string2);
        }
        return null;
    }

    private JSONObject uploadControlSlice(String object, String string2, byte[] object2) {
        block21: {
            w$a w$a;
            String string3;
            block20: {
                String string4;
                String string5;
                string3 = MULTIPART_FORM_DATA;
                w$a = new w$a();
                try {
                    string5 = SHA1.compute((byte[])object2);
                    string4 = PARAM_SHA;
                }
                catch (Exception exception) {
                    object = new AVException(-1, "Upload file failure");
                    throw object;
                }
                w$a.a(string4, string5);
                string5 = PARAM_OP;
                string4 = OP_UPLOAD_SLICE;
                w$a.a(string5, string4);
                string5 = PARAM_FILE_SIZE;
                int n10 = ((Object)object2).length;
                object2 = String.valueOf(n10);
                w$a.a(string5, (String)object2);
                object2 = PARAM_SLICE_SIZE;
                int n11 = 524288;
                string5 = String.valueOf(n11);
                w$a.a((String)object2, string5);
                object2 = v.j(string3);
                if (object2 == null) break block20;
                w$a.g((v)object2);
            }
            object2 = new a0$a();
            ((a0$a)object2).B(string2);
            string2 = HEADER_AUTHORIZATION;
            ((a0$a)object2).n(string2, (String)object);
            object = HEADER_CONTENT_TYPE;
            ((a0$a)object2).n((String)object, string3);
            object = w$a.f();
            ((a0$a)object2).r((b0)object);
            object = ((a0$a)object2).b();
            int n12 = 5;
            object = this.executeWithRetry((a0)object, n12);
            if (object == null) break block21;
            object = ((c0)object).r0();
            object = ((d0)object).bytes();
            object = StringUtil.stringFromBytes((byte[])object);
            return QCloudUploader.parseSliceUploadResponse((String)object);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void uploadFile(byte[] object) {
        Object object2 = MULTIPART_FORM_DATA;
        try {
            boolean bl2;
            Object object3 = SHA1.compute(object);
            this.fileSha = object3;
            object3 = new w$a();
            Object object4 = APPLICATION_OCTET_STREAM;
            object4 = v.j((String)object4);
            int n10 = ((byte[])object).length;
            n10 = QCloudUploader.getCurrentSliceLength(0, n10);
            object = b0.create((v)object4, object, 0, n10);
            object4 = FILE_CONTENT;
            String string2 = this.fileKey;
            ((w$a)object3).b((String)object4, string2, (b0)object);
            object = PARAM_OP;
            object4 = OP_UPLOAD;
            ((w$a)object3).a((String)object, (String)object4);
            object = PARAM_SHA;
            object4 = this.fileSha;
            ((w$a)object3).a((String)object, (String)object4);
            object = v.j((String)object2);
            if (object != null) {
                ((w$a)object3).g((v)object);
            }
            object = new a0$a;
            object();
            object4 = this.uploadUrl;
            object.B((String)object4);
            object4 = HEADER_AUTHORIZATION;
            string2 = this.token;
            object.n((String)object4, string2);
            object4 = HEADER_CONTENT_TYPE;
            object.n((String)object4, (String)object2);
            object2 = FileUploader.UPLOAD_HEADERS;
            object2 = ((HashMap)object2).entrySet();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                object4 = object2.next();
                object4 = (Map.Entry)object4;
                string2 = object4.getKey();
                object4 = object4.getValue();
                object4 = (String)object4;
                object.n(string2, (String)object4);
            }
            object2 = ((w$a)object3).f();
            object.r((b0)object2);
            object = object.b();
            int n11 = 5;
            object = this.executeWithRetry((a0)object, n11);
            n11 = object.v0();
            int n12 = 200;
            if (n11 == n12) {
                return;
            }
            n12 = -1;
            object = object.r0();
            object = object.bytes();
            object = StringUtil.stringFromBytes(object);
            object2 = new AVException(n12, (String)object);
            throw object2;
        }
        catch (Exception exception) {
            object2 = new AVException("Exception during file upload", exception);
            throw object2;
        }
    }

    public AVException execute() {
        block34: {
            Object object;
            QCloudUploader qCloudUploader;
            block32: {
                Object object2;
                int n10;
                String string2;
                Object object3;
                int n11;
                int n12;
                block33: {
                    qCloudUploader = this;
                    object = this.avFile;
                    object = ((AVFile)object).getData();
                    n12 = ((Object)object).length;
                    int n13 = 524288;
                    n12 /= n13;
                    n11 = ((Object)object).length;
                    n11 %= n13;
                    n13 = 0;
                    object3 = null;
                    int n14 = 1;
                    if (n11 == 0) {
                        n11 = 0;
                        string2 = null;
                    } else {
                        n11 = n14;
                    }
                    n10 = n12 + n11;
                    if (n10 <= n14) break block32;
                    object2 = qCloudUploader.token;
                    string2 = qCloudUploader.uploadUrl;
                    object2 = qCloudUploader.uploadControlSlice((String)object2, string2, (byte[])object);
                    if (object2 != null) break block33;
                    object3 = "Exception during file upload";
                    object2 = new RuntimeException((String)object3);
                    object = new AVException((Throwable)object2);
                    return object;
                }
                string2 = PARAM_ACCESS_URL;
                n11 = (int)(object2.containsKey(string2) ? 1 : 0);
                if (n11 != 0) {
                    return null;
                }
                string2 = PARAM_SESSION;
                String string3 = ((JSONObject)object2).getString(string2);
                object2 = new QCloudUploader$1(qCloudUploader);
                FileUploader$ProgressCalculator fileUploader$ProgressCalculator = new FileUploader$ProgressCalculator(n10, (FileUploader$FileUploadProgressCallback)object2);
                object2 = "";
                int n15 = 0;
                while (n15 < n10 && object2 != null) {
                    QCloudUploader$SliceUploadTask qCloudUploader$SliceUploadTask;
                    string2 = qCloudUploader.fileKey;
                    String string4 = qCloudUploader.token;
                    String string5 = qCloudUploader.uploadUrl;
                    object2 = qCloudUploader$SliceUploadTask;
                    object3 = this;
                    int n16 = n15;
                    n15 = 0;
                    qCloudUploader$SliceUploadTask = new QCloudUploader$SliceUploadTask(this, string2, string4, string5, (byte[])object, n16, string3, fileUploader$ProgressCalculator, null);
                    object2 = qCloudUploader$SliceUploadTask.upload();
                    n15 = n16 + 1;
                }
                if (n15 >= n10) break block34;
                n12 = -1;
                object3 = "failed to upload slice.";
                try {
                    object = new AVException(n12, (String)object3);
                    return object;
                }
                catch (Exception exception) {
                    object2 = new AVException(exception);
                    return object2;
                }
            }
            qCloudUploader.uploadFile((byte[])object);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void interruptImmediately() {
        super.interruptImmediately();
        Future[] futureArray = this.tasks;
        if (futureArray == null) return;
        futureArray = this.tasks;
        int n10 = futureArray.length;
        if (n10 <= 0) return;
        futureArray = this.tasks;
        synchronized (futureArray) {
            Object object;
            int n11;
            int n12 = 0;
            Object var4_4 = null;
            while (n12 < (n11 = ((Future[])(object = this.tasks)).length)) {
                boolean bl2;
                object = this.tasks;
                if ((object = object[n12]) != null && !(bl2 = object.isDone()) && !(bl2 = object.isCancelled())) {
                    bl2 = true;
                    object.cancel(bl2);
                }
                ++n12;
            }
            return;
        }
    }
}

