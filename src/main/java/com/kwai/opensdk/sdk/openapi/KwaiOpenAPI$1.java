/*
 * Decompiled with CFR 0.151.
 */
package com.kwai.opensdk.sdk.openapi;

import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;

public class KwaiOpenAPI$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum;
        int n12 = KwaiOpenSdkCmdEnum.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum = nArray;
        try {
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_SHARE_MESSAGE;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_SHARE_MESSAGE_TO_BUDDY;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_SHOW_PROFILE;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_SINGLE_PICTURE_EDIT;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_SINGLE_PICTURE_PUBLISH;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_SINGLE_VIDEO_EDIT;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_SINGLE_VIDEO_PUBLISH;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_SINGLE_VIDEO_CLIP;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_MULTI_MEDIA_CLIP;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            kwaiOpenSdkCmdEnum = KwaiOpenSdkCmdEnum.CMD_AI_CUT_MEDIAS;
            n11 = kwaiOpenSdkCmdEnum.ordinal();
            nArray[n11] = n10 = 10;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

