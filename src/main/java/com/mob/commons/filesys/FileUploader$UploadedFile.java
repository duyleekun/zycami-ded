/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.filesys;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;

public class FileUploader$UploadedFile
implements PublicMemberKeeper {
    public final String id;
    public final String url;

    public FileUploader$UploadedFile(HashMap object) {
        String string2 = "src";
        boolean bl2 = ((HashMap)object).containsKey(string2);
        this.url = bl2 ? (string2 = (String)((HashMap)object).get(string2)) : null;
        string2 = "id";
        bl2 = ((HashMap)object).containsKey(string2);
        this.id = bl2 ? (object = (String)((HashMap)object).get(string2)) : null;
    }
}

