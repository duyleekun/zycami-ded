/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.codec.Base64;
import cn.leancloud.json.JSON;
import cn.leancloud.upload.QiniuAccessor$QiniuBlockResponseData;
import cn.leancloud.upload.QiniuAccessor$QiniuMKFileResponseData;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import g.a0;
import g.a0$a;
import g.b0;
import g.c0;
import g.e;
import g.v;
import g.z;
import java.util.List;
import java.util.zip.CRC32;

public class QiniuAccessor {
    public static final int BLOCK_SIZE = 0x400000;
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String HEAD_AUTHORIZATION = "Authorization";
    public static final String HEAD_CONTENT_LENGTH = "Content-Length";
    public static final String HEAD_CONTENT_TYPE = "Content-Type";
    private static AVLogger LOGGER = LogUtil.getLogger(QiniuAccessor.class);
    public static final int NONWIFI_CHUNK_SIZE = 65536;
    public static final String QINIU_BRICK_UPLOAD_EP = "%s/bput/%s/%d";
    public static final String QINIU_CREATE_BLOCK_EP = "%s/mkblk/%d";
    public static final String QINIU_HOST = "http://upload.qiniu.com";
    public static final String QINIU_MKFILE_EP = "%s/mkfile/%d/key/%s";
    public static final String TEXT_CONTENT_TYPE = "text/plain";
    public static final int WIFI_CHUNK_SIZE = 262144;
    private z client;
    private String fileKey;
    private String uploadToken;
    private String uploadUrl;

    public QiniuAccessor(z z10, String string2, String string3, String string4) {
        String string5;
        this.uploadUrl = string5 = QINIU_HOST;
        this.client = z10;
        this.uploadToken = string2;
        this.fileKey = string3;
        boolean bl2 = StringUtil.isEmpty(string4);
        if (!bl2) {
            this.uploadUrl = string4;
        }
    }

    private static Object parseQiniuResponse(c0 object, Class serializable) {
        int n10 = ((c0)object).v0();
        CharSequence charSequence = ((c0)object).E0();
        String string2 = ((c0)object).y0("X-Log");
        int n11 = 401;
        if (n10 != n11) {
            int n12;
            block6: {
                object = StringUtil.stringFromBytes(((c0)object).r0().bytes());
                n11 = n10 / 100;
                int n13 = 2;
                if (n11 != n13) break block6;
                try {
                    return JSON.parseObject((String)object, serializable);
                }
                catch (Exception exception) {
                    AVLogger aVLogger = LOGGER;
                    aVLogger.w(exception);
                }
            }
            if ((n12 = ((String)object).length()) <= 0) {
                boolean bl2 = StringUtil.isEmpty(string2);
                if (!bl2) {
                    object = new Exception(string2);
                    throw object;
                }
                object = new Exception((String)charSequence);
                throw object;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(n10);
            ((StringBuilder)charSequence).append(":");
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            serializable = new Exception((String)object);
            throw serializable;
        }
        object = new Exception("unauthorized to create Qiniu Block");
        throw object;
    }

    private void validateCrc32Value(QiniuAccessor$QiniuBlockResponseData object, byte[] byArray, int n10, int n11) {
        long l10;
        long l11;
        long l12;
        CRC32 cRC32 = new CRC32();
        cRC32.update(byArray, n10, n11);
        long l13 = cRC32.getValue();
        if (object != null && (l12 = (l11 = (l10 = QiniuAccessor$QiniuBlockResponseData.access$200((QiniuAccessor$QiniuBlockResponseData)object)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            object = new AVException(-1, "CRC32 validation failure for chunk upload");
            throw object;
        }
    }

    public QiniuAccessor$QiniuBlockResponseData createBlockInQiniu(int n10, int n11, byte[] byArray, int n12) {
        Object object;
        Object object2 = DEFAULT_CONTENT_TYPE;
        Class<QiniuAccessor$QiniuBlockResponseData> clazz = QINIU_CREATE_BLOCK_EP;
        int n13 = 2;
        try {
            object = new Object[n13];
        }
        catch (Exception exception) {
            int n14 = n12 + -1;
            if (n12 > 0) {
                return this.createBlockInQiniu(n10, n11, byArray, n14);
            }
            LOGGER.w(exception);
            return null;
        }
        Object object3 = this.uploadUrl;
        object[0] = object3;
        int n15 = 1;
        Object object4 = n10;
        object[n15] = object4;
        clazz = String.format((String)((Object)clazz), (Object[])object);
        object = new a0$a();
        ((a0$a)object).B((String)((Object)clazz));
        object3 = HEAD_CONTENT_TYPE;
        ((a0$a)object).a((String)object3, (String)object2);
        object3 = HEAD_CONTENT_LENGTH;
        object4 = String.valueOf(n11);
        ((a0$a)object).a((String)object3, (String)object4);
        object3 = HEAD_AUTHORIZATION;
        object4 = new StringBuilder();
        String string2 = "UpToken ";
        ((StringBuilder)object4).append(string2);
        string2 = this.uploadToken;
        ((StringBuilder)object4).append(string2);
        object4 = ((StringBuilder)object4).toString();
        ((a0$a)object).a((String)object3, (String)object4);
        object3 = LOGGER;
        object4 = new StringBuilder();
        string2 = "createBlockInQiniu with uploadUrl: ";
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append((String)((Object)clazz));
        clazz = ((StringBuilder)object4).toString();
        ((AVLogger)object3).d((String)((Object)clazz));
        object2 = v.j((String)object2);
        object2 = b0.create((v)object2, byArray, 0, n11);
        object2 = ((a0$a)object).r((b0)object2);
        clazz = this.client;
        object2 = ((a0$a)object2).b();
        object2 = ((z)((Object)clazz)).a((a0)object2);
        object2 = FirebasePerfOkHttpClient.execute((e)object2);
        clazz = QiniuAccessor$QiniuBlockResponseData.class;
        object2 = QiniuAccessor.parseQiniuResponse((c0)object2, clazz);
        return (QiniuAccessor$QiniuBlockResponseData)object2;
    }

    public QiniuAccessor$QiniuMKFileResponseData makeFile(int n10, List list, int n11) {
        a0$a a0$a;
        int n12;
        Object object;
        Object object2 = TEXT_CONTENT_TYPE;
        Class<QiniuAccessor$QiniuMKFileResponseData> clazz = QINIU_MKFILE_EP;
        int n13 = 3;
        try {
            object = new Object[n13];
            n12 = 0;
            a0$a = null;
        }
        catch (Exception exception) {
            int n14 = n11 + -1;
            if (n11 > 0) {
                return this.makeFile(n10, list, n14);
            }
            LOGGER.w(exception);
            return null;
        }
        Object object3 = this.uploadUrl;
        object[0] = object3;
        n12 = 1;
        object3 = n10;
        object[n12] = object3;
        n12 = 2;
        object3 = this.fileKey;
        object3 = ((String)object3).getBytes();
        int n15 = 10;
        object3 = Base64.encodeToString((byte[])object3, n15);
        object[n12] = object3;
        clazz = String.format((String)((Object)clazz), (Object[])object);
        object = ",";
        object = StringUtil.join((CharSequence)object, list);
        a0$a = new a0$a();
        a0$a.B((String)((Object)clazz));
        object3 = HEAD_CONTENT_TYPE;
        a0$a.a((String)object3, (String)object2);
        object3 = HEAD_CONTENT_LENGTH;
        n15 = ((String)object).length();
        CharSequence charSequence = String.valueOf(n15);
        a0$a.a((String)object3, (String)charSequence);
        object3 = HEAD_AUTHORIZATION;
        charSequence = new StringBuilder();
        String string2 = "UpToken ";
        ((StringBuilder)charSequence).append(string2);
        string2 = this.uploadToken;
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        a0$a.a((String)object3, (String)charSequence);
        object3 = LOGGER;
        charSequence = new StringBuilder();
        string2 = "makeFile to qiniu with uploadUrl: ";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append((String)((Object)clazz));
        clazz = ((StringBuilder)charSequence).toString();
        ((AVLogger)object3).d((String)((Object)clazz));
        object2 = v.j((String)object2);
        object2 = b0.create((v)object2, (String)object);
        object2 = a0$a.r((b0)object2);
        clazz = this.client;
        object2 = ((a0$a)object2).b();
        object2 = ((z)((Object)clazz)).a((a0)object2);
        object2 = FirebasePerfOkHttpClient.execute((e)object2);
        clazz = QiniuAccessor$QiniuMKFileResponseData.class;
        object2 = QiniuAccessor.parseQiniuResponse((c0)object2, clazz);
        return (QiniuAccessor$QiniuMKFileResponseData)object2;
    }

    public QiniuAccessor$QiniuBlockResponseData putFileBlocksToQiniu(QiniuAccessor$QiniuBlockResponseData qiniuAccessor$QiniuBlockResponseData, int n10, byte[] byArray, int n11, int n12) {
        int n13;
        int n14;
        Object object;
        Object object2 = DEFAULT_CONTENT_TYPE;
        Class<QiniuAccessor$QiniuBlockResponseData> clazz = QINIU_BRICK_UPLOAD_EP;
        int n15 = 3;
        try {
            object = new Object[n15];
        }
        catch (Exception exception) {
            int n16 = n12 + -1;
            if (n12 > 0) {
                clazz = this;
                object = qiniuAccessor$QiniuBlockResponseData;
                n14 = n10;
                n13 = n11;
                return this.putFileBlocksToQiniu(qiniuAccessor$QiniuBlockResponseData, n10, byArray, n11, n16);
            }
            LOGGER.w(exception);
            return null;
        }
        Object object3 = this.uploadUrl;
        object[0] = object3;
        n14 = 1;
        Object object4 = QiniuAccessor$QiniuBlockResponseData.access$000(qiniuAccessor$QiniuBlockResponseData);
        object[n14] = object4;
        n14 = 2;
        n13 = QiniuAccessor$QiniuBlockResponseData.access$100(qiniuAccessor$QiniuBlockResponseData);
        object4 = n13;
        object[n14] = object4;
        clazz = String.format((String)((Object)clazz), (Object[])object);
        object = new a0$a();
        ((a0$a)object).B((String)((Object)clazz));
        object3 = HEAD_CONTENT_TYPE;
        ((a0$a)object).a((String)object3, (String)object2);
        object3 = HEAD_CONTENT_LENGTH;
        object4 = String.valueOf(n11);
        ((a0$a)object).a((String)object3, (String)object4);
        object3 = HEAD_AUTHORIZATION;
        object4 = new StringBuilder();
        String string2 = "UpToken ";
        ((StringBuilder)object4).append(string2);
        string2 = this.uploadToken;
        ((StringBuilder)object4).append(string2);
        object4 = ((StringBuilder)object4).toString();
        ((a0$a)object).a((String)object3, (String)object4);
        object3 = LOGGER;
        object4 = new StringBuilder();
        string2 = "putFileBlocksToQiniu with uploadUrl: ";
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append((String)((Object)clazz));
        clazz = ((StringBuilder)object4).toString();
        ((AVLogger)object3).d((String)((Object)clazz));
        object2 = v.j((String)object2);
        object2 = b0.create((v)object2, byArray, 0, n11);
        object2 = ((a0$a)object).r((b0)object2);
        clazz = this.client;
        object2 = ((a0$a)object2).b();
        object2 = ((z)((Object)clazz)).a((a0)object2);
        object2 = FirebasePerfOkHttpClient.execute((e)object2);
        clazz = QiniuAccessor$QiniuBlockResponseData.class;
        object2 = QiniuAccessor.parseQiniuResponse((c0)object2, clazz);
        object2 = (QiniuAccessor$QiniuBlockResponseData)object2;
        this.validateCrc32Value((QiniuAccessor$QiniuBlockResponseData)object2, byArray, 0, n11);
        return object2;
    }
}

