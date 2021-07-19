/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.upload.FileUploader$FileUploadProgressCallback;
import cn.leancloud.upload.FileUploader$ProgressCalculator;
import cn.leancloud.upload.HttpClientUploader;
import cn.leancloud.upload.QiniuAccessor;
import cn.leancloud.upload.QiniuAccessor$QiniuBlockResponseData;
import cn.leancloud.upload.QiniuAccessor$QiniuMKFileResponseData;
import cn.leancloud.upload.QiniuSlicingUploader$1;
import cn.leancloud.utils.LogUtil;
import g.z;
import java.io.InputStream;
import java.util.ArrayList;

public class QiniuSlicingUploader
extends HttpClientUploader {
    private static AVLogger LOGGER = LogUtil.getLogger(QiniuSlicingUploader.class);
    private String fileKey = null;
    private FileUploader$ProgressCalculator progressCalculator;
    private QiniuAccessor qiniuAccessor;
    private final String token;
    private int uploadChunkSize = 262144;

    public QiniuSlicingUploader(AVFile object, String object2, String charSequence, ProgressCallback object3) {
        super((AVFile)object, (ProgressCallback)object3);
        this.token = object2;
        this.fileKey = object = ((AVFile)object).getKey();
        object3 = this.getOKHttpClient();
        String string2 = this.fileKey;
        this.qiniuAccessor = object = new QiniuAccessor((z)object3, (String)object2, string2, (String)charSequence);
        object = LOGGER;
        super();
        ((StringBuilder)charSequence).append("Constructor with token=");
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(", key=");
        object2 = this.fileKey;
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(", accessor=");
        object2 = this.qiniuAccessor;
        ((StringBuilder)charSequence).append(object2);
        object2 = ((StringBuilder)charSequence).toString();
        ((AVLogger)object).d((String)object2);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public AVException execute() {
        void var3_10;
        Object object;
        block109: {
            Object object2;
            block111: {
                void var3_8;
                block110: {
                    InputStream inputStream;
                    int n10;
                    Object object3;
                    block108: {
                        Object object4;
                        block106: {
                            block107: {
                                Object object5;
                                CharSequence charSequence;
                                ArrayList<Object> arrayList;
                                int n11;
                                int n12;
                                QiniuSlicingUploader qiniuSlicingUploader;
                                block104: {
                                    block105: {
                                        qiniuSlicingUploader = this;
                                        n12 = this.uploadChunkSize;
                                        object3 = new byte[n12];
                                        object2 = this.avFile;
                                        n11 = ((AVFile)object2).getSize();
                                        int n13 = 0x400000;
                                        n10 = n11 / n13;
                                        int n14 = n11 % n13;
                                        int n15 = 0;
                                        String string2 = null;
                                        if (n14 > 0) {
                                            n14 = 1;
                                        } else {
                                            n14 = 0;
                                            object4 = null;
                                        }
                                        int n16 = n10 + n14;
                                        arrayList = new ArrayList<Object>(n16);
                                        object4 = new QiniuSlicingUploader$1(qiniuSlicingUploader);
                                        qiniuSlicingUploader.progressCalculator = object2 = new FileUploader$ProgressCalculator(n16, (FileUploader$FileUploadProgressCallback)object4);
                                        object2 = qiniuSlicingUploader.avFile;
                                        inputStream = ((AVFile)object2).getDataStream();
                                        object2 = LOGGER;
                                        object4 = new StringBuilder();
                                        charSequence = "begin to upload qiniu. chunkSize=";
                                        ((StringBuilder)object4).append((String)charSequence);
                                        int n17 = qiniuSlicingUploader.uploadChunkSize;
                                        ((StringBuilder)object4).append(n17);
                                        charSequence = ", blockCount=";
                                        ((StringBuilder)object4).append((String)charSequence);
                                        ((StringBuilder)object4).append(n16);
                                        charSequence = ", is=";
                                        ((StringBuilder)object4).append((String)charSequence);
                                        ((StringBuilder)object4).append(inputStream);
                                        object4 = ((StringBuilder)object4).toString();
                                        ((AVLogger)object2).d((String)object4);
                                        int n18 = 0;
                                        while (true) {
                                            Object object6;
                                            int n19;
                                            int n20 = 6;
                                            object5 = ") result=";
                                            if (n18 >= n16) break block104;
                                            n17 = n18 * n13;
                                            n10 = n16 + -1;
                                            n14 = n18 == n10 ? (n10 = n11 - n17) : n13;
                                            n10 = qiniuSlicingUploader.uploadChunkSize;
                                            int n21 = n14 / n10;
                                            n10 = n14 % n10;
                                            if (n10 > 0) {
                                                n10 = 1;
                                            } else {
                                                n10 = 0;
                                                object2 = null;
                                            }
                                            n10 = n21 + n10;
                                            Object object7 = null;
                                            for (n13 = 0; n13 < n10; ++n13) {
                                                int n22;
                                                int n23;
                                                int n24 = qiniuSlicingUploader.uploadChunkSize;
                                                int n25 = n13 * n24;
                                                int n26 = n10 + -1;
                                                if (n13 == n26) {
                                                    n24 = n14 - n25;
                                                }
                                                n26 = n24 + 0;
                                                n26 = inputStream.read((byte[])object3, 0, n26);
                                                for (n15 = n25 = n26 + 0; n26 > 0 && n15 < n24; n15 += n26) {
                                                    n26 = n24 - n15;
                                                    n26 = inputStream.read((byte[])object3, n15, n26);
                                                    continue;
                                                }
                                                string2 = ", curChunkSize=";
                                                if (n13 == 0) {
                                                    object = qiniuSlicingUploader.qiniuAccessor;
                                                    object = ((QiniuAccessor)object).createBlockInQiniu(n14, n24, (byte[])object3, n20);
                                                    AVLogger aVLogger = LOGGER;
                                                    n23 = n10;
                                                    object2 = new StringBuilder();
                                                    charSequence = "createBlockInQiniu(curBlockSize=";
                                                    ((StringBuilder)object2).append((String)charSequence);
                                                    ((StringBuilder)object2).append(n14);
                                                    ((StringBuilder)object2).append(string2);
                                                    ((StringBuilder)object2).append(n24);
                                                    ((StringBuilder)object2).append((String)object5);
                                                    ((StringBuilder)object2).append(object);
                                                    object2 = ((StringBuilder)object2).toString();
                                                    aVLogger.d((String)object2);
                                                    n22 = n14;
                                                    n19 = n16;
                                                    object7 = object;
                                                    n16 = n18;
                                                    object6 = object3;
                                                    n12 = n17;
                                                } else {
                                                    n23 = n10;
                                                    object2 = qiniuSlicingUploader.qiniuAccessor;
                                                    n26 = 6;
                                                    n22 = n14;
                                                    object4 = object7;
                                                    n20 = n17;
                                                    String string3 = object5;
                                                    object5 = object3;
                                                    object6 = object3;
                                                    n12 = n17;
                                                    n19 = n16;
                                                    n20 = n24;
                                                    n16 = n18;
                                                    n18 = n26;
                                                    object2 = ((QiniuAccessor)object2).putFileBlocksToQiniu((QiniuAccessor$QiniuBlockResponseData)object7, n17, (byte[])object3, n24, n26);
                                                    object4 = LOGGER;
                                                    charSequence = new StringBuilder();
                                                    object5 = "putFileBlocksToQiniu(lastRes=";
                                                    ((StringBuilder)charSequence).append((String)object5);
                                                    object = object7;
                                                    ((StringBuilder)charSequence).append(object7);
                                                    object5 = ", curBlockOffset=";
                                                    ((StringBuilder)charSequence).append((String)object5);
                                                    ((StringBuilder)charSequence).append(n17);
                                                    ((StringBuilder)charSequence).append(string2);
                                                    ((StringBuilder)charSequence).append(n24);
                                                    object5 = string3;
                                                    ((StringBuilder)charSequence).append(string3);
                                                    ((StringBuilder)charSequence).append(object2);
                                                    charSequence = ((StringBuilder)charSequence).toString();
                                                    ((AVLogger)object4).d((String)charSequence);
                                                    object7 = object2;
                                                }
                                                n17 = n12;
                                                n18 = n16;
                                                n16 = n19;
                                                n10 = n23;
                                                object3 = object6;
                                                n14 = n22;
                                                n20 = 6;
                                                n15 = 0;
                                                string2 = null;
                                            }
                                            object6 = object3;
                                            n19 = n16;
                                            object = object7;
                                            n16 = n18;
                                            if (object7 == null) break;
                                            object3 = ((QiniuAccessor$QiniuBlockResponseData)object7).getCtx();
                                            arrayList.add(object3);
                                            object3 = qiniuSlicingUploader.progressCalculator;
                                            n10 = 100;
                                            ((FileUploader$ProgressCalculator)object3).publishProgress(n18, n10);
                                            object3 = LOGGER;
                                            object2 = new StringBuilder();
                                            object4 = "finished to upload block(";
                                            ((StringBuilder)object2).append((String)object4);
                                            ((StringBuilder)object2).append(n18);
                                            object4 = "), ctx=";
                                            ((StringBuilder)object2).append((String)object4);
                                            object4 = ((QiniuAccessor$QiniuBlockResponseData)object7).getCtx();
                                            ((StringBuilder)object2).append((String)object4);
                                            object2 = ((StringBuilder)object2).toString();
                                            ((AVLogger)object3).d((String)object2);
                                            ++n18;
                                            n16 = n19;
                                            object3 = object6;
                                            n13 = 0x400000;
                                            n15 = 0;
                                            string2 = null;
                                            continue;
                                            break;
                                        }
                                        n10 = 9302;
                                        object4 = "failed to upload file to qiniu.";
                                        object3 = new AVException(n10, (String)object4);
                                        if (inputStream == null) break block105;
                                        try {
                                            inputStream.close();
                                        }
                                        catch (Exception exception) {
                                            return object3;
                                        }
                                    }
                                    return object3;
                                }
                                object3 = qiniuSlicingUploader.qiniuAccessor;
                                n10 = 6;
                                object3 = ((QiniuAccessor)object3).makeFile(n11, arrayList, n10);
                                object2 = LOGGER;
                                object4 = new StringBuilder();
                                charSequence = "makeFile(fileSize=";
                                ((StringBuilder)object4).append((String)charSequence);
                                ((StringBuilder)object4).append(n11);
                                ((StringBuilder)object4).append((String)object5);
                                ((StringBuilder)object4).append(object3);
                                object4 = ((StringBuilder)object4).toString();
                                ((AVLogger)object2).d((String)object4);
                                if (object3 == null) break block106;
                                object3 = ((QiniuAccessor$QiniuMKFileResponseData)object3).key;
                                object2 = qiniuSlicingUploader.fileKey;
                                n12 = (int)(((String)object3).equals(object2) ? 1 : 0);
                                if (n12 == 0) break block106;
                                if (inputStream == null) break block107;
                                try {
                                    inputStream.close();
                                }
                                catch (Exception exception) {
                                    return null;
                                }
                            }
                            return null;
                        }
                        n10 = -1;
                        object4 = "upload file failure";
                        object3 = new AVException(n10, (String)object4);
                        if (inputStream == null) break block108;
                        try {
                            inputStream.close();
                        }
                        catch (Exception exception) {
                            return object3;
                        }
                    }
                    return object3;
                    catch (Throwable throwable) {
                        object = inputStream;
                        break block109;
                    }
                    catch (Exception exception) {
                        object = inputStream;
                        break block110;
                    }
                    catch (Throwable throwable) {
                        n10 = 0;
                        object2 = null;
                        boolean bl2 = false;
                        object = null;
                        break block109;
                    }
                    catch (Exception exception) {
                        n10 = 0;
                        object2 = null;
                        boolean bl3 = false;
                        object = null;
                    }
                }
                object2 = new AVException((Throwable)var3_8);
                if (object == null) break block111;
                try {
                    ((InputStream)object).close();
                }
                catch (Exception exception) {
                    return object2;
                }
            }
            return object2;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (object != null) {
            ((InputStream)object).close();
        }
        throw var3_10;
        catch (Exception exception) {
            throw var3_10;
        }
    }
}

