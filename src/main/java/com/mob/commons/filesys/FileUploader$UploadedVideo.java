/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.filesys;

import com.mob.commons.filesys.FileUploader$UploadedFile;
import java.util.HashMap;

public class FileUploader$UploadedVideo
extends FileUploader$UploadedFile {
    public final int durationUSec;
    public final int height;
    public final int width;

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FileUploader$UploadedVideo(HashMap object) {
        int n10;
        int n11;
        int n12;
        block6: {
            super((HashMap)object);
            n12 = -1;
            String string2 = "time";
            Object v10 = ((HashMap)object).get(string2);
            String string3 = String.valueOf(v10);
            n11 = Integer.parseInt(string3);
            String string4 = "height";
            Object v11 = ((HashMap)object).get(string4);
            String string5 = String.valueOf(v11);
            n10 = Integer.parseInt(string5);
            String string6 = "width";
            try {
                object = ((HashMap)object).get(string6);
                object = String.valueOf(object);
                n12 = Integer.parseInt((String)object);
                break block6;
            }
            catch (Throwable throwable) {}
            catch (Throwable throwable) {
                n10 = n12;
            }
            break block6;
            catch (Throwable throwable) {
                n11 = n12;
                n10 = n12;
            }
        }
        this.durationUSec = n11;
        this.width = n12;
        this.height = n10;
    }
}

