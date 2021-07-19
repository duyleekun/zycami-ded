/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.upload.HttpClientUploader;

public class UrlDirectlyUploader
extends HttpClientUploader {
    public UrlDirectlyUploader(AVFile aVFile, ProgressCallback progressCallback) {
        super(aVFile, progressCallback);
    }

    public AVException execute() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("UrlDirectlyUploader is deprecated.");
        AVException aVException = new AVException(unsupportedOperationException);
        return aVException;
    }
}

