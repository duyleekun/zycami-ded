/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.filesys;

import com.mob.commons.filesys.FileUploader$UploadedFile;
import java.util.HashMap;

public class FileUploader$UploadedImage
extends FileUploader$UploadedFile {
    public final HashMap zoomList;

    public FileUploader$UploadedImage(HashMap hashMap) {
        super(hashMap);
        String string2 = "list";
        hashMap = hashMap.get(string2);
        try {
        }
        catch (Throwable throwable) {
            hashMap = null;
        }
        this.zoomList = hashMap;
    }
}

