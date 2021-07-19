/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.filesys;

import com.mob.commons.filesys.FileUploader$UploadedFile;
import java.util.HashMap;

public class FileUploader$UploadedAudio
extends FileUploader$UploadedFile {
    public final int durationUSec;

    public FileUploader$UploadedAudio(HashMap object) {
        super((HashMap)object);
        int n10;
        String string2 = "time";
        object = ((HashMap)object).get(string2);
        object = String.valueOf(object);
        try {
            n10 = Integer.parseInt((String)object);
        }
        catch (Throwable throwable) {
            n10 = -1;
        }
        this.durationUSec = n10;
    }
}

