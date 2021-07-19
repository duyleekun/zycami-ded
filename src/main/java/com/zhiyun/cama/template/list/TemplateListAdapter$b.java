/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.list;

import com.zhiyun.cama.template.PlayState;
import com.zhiyun.editortemplate.util.DownloadState;

public class TemplateListAdapter$b {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13 = PlayState.values().length;
        int[] nArray = new int[n13];
        b = nArray;
        int n14 = 1;
        try {
            object3 = PlayState.STATE_PLAYING;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = b;
            object2 = PlayState.STATE_PLAY_PREPARE;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (PlayState)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = b;
            enum_ = PlayState.STATE_ERROR_IO;
            n10 = enum_.ordinal();
            object2[n10] = (PlayState)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = DownloadState.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = DownloadState.DOWNLOADING;
            n10 = enum_.ordinal();
            object2[n10] = (PlayState)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = DownloadState.DOWNLOAD_SUCCESSFUL;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)DownloadState.NONE;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DownloadState.PARSE_ERROR;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DownloadState.INSUFFICIENT_RESOURCES;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DownloadState.DOWNLOAD_FAILED;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DownloadState.DOWNLOAD_NETWORK_FAILED;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

