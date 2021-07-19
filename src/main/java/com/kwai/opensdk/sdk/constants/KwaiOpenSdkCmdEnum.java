/*
 * Decompiled with CFR 0.151.
 */
package com.kwai.opensdk.sdk.constants;

public final class KwaiOpenSdkCmdEnum
extends Enum {
    private static final /* synthetic */ KwaiOpenSdkCmdEnum[] $VALUES;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_AI_CUT_MEDIAS;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_MULTI_MEDIA_CLIP;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_SHARE_MESSAGE;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_SHARE_MESSAGE_TO_BUDDY;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_SHOW_PROFILE;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_SINGLE_PICTURE_EDIT;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_SINGLE_PICTURE_PUBLISH;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_SINGLE_VIDEO_CLIP;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_SINGLE_VIDEO_EDIT;
    public static final /* enum */ KwaiOpenSdkCmdEnum CMD_SINGLE_VIDEO_PUBLISH;
    private String bundleKey;
    private String cmd;
    private String feature;
    private boolean isAuthCmd;
    private boolean isNeedLogin;
    private int type;
    private String verifyStr;

    static {
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum2;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum3;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum4;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum5;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum6;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum7;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum8;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum9;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum10 = kwaiOpenSdkCmdEnum9;
        CMD_SHARE_MESSAGE = kwaiOpenSdkCmdEnum9 = new KwaiOpenSdkCmdEnum("CMD_SHARE_MESSAGE", 0, 1, "share_message", true, true, "social-ft", "kwai_bundle_share_message", "share_message");
        boolean bl2 = true;
        boolean bl3 = true;
        CMD_SHARE_MESSAGE_TO_BUDDY = kwaiOpenSdkCmdEnum10 = new KwaiOpenSdkCmdEnum("CMD_SHARE_MESSAGE_TO_BUDDY", 1, 2, "share_message_to_buddy", bl2, bl3, "social-ft", "kwai_bundle_share_message_to_buddy", "share_message");
        boolean bl4 = true;
        boolean bl5 = true;
        CMD_SHOW_PROFILE = kwaiOpenSdkCmdEnum8 = new KwaiOpenSdkCmdEnum("CMD_SHOW_PROFILE", 2, 3, "show_profile", bl4, bl5, "social-ft", "kwai_bundle_show_profile", "show_profile");
        CMD_SINGLE_PICTURE_EDIT = kwaiOpenSdkCmdEnum7 = new KwaiOpenSdkCmdEnum("CMD_SINGLE_PICTURE_EDIT", 3, 4, "single_picture_edit", bl2, bl3, "post-ft", "kwai_bundle_post_single_picture_edit", "share_media");
        CMD_SINGLE_PICTURE_PUBLISH = kwaiOpenSdkCmdEnum6 = new KwaiOpenSdkCmdEnum("CMD_SINGLE_PICTURE_PUBLISH", 4, 5, "single_picture_publish", bl4, bl5, "post-ft", "kwai_bundle_post_single_picture_publish", "share_media");
        CMD_SINGLE_VIDEO_PUBLISH = kwaiOpenSdkCmdEnum5 = new KwaiOpenSdkCmdEnum("CMD_SINGLE_VIDEO_PUBLISH", 5, 6, "single_video_publish", bl2, bl3, "post-ft", "kwai_bundle_post_single_video_publish", "share_media");
        CMD_SINGLE_VIDEO_EDIT = kwaiOpenSdkCmdEnum4 = new KwaiOpenSdkCmdEnum("CMD_SINGLE_VIDEO_EDIT", 6, 7, "single_video_edit", bl4, bl5, "post-ft", "kwai_bundle_post_single_video_edit", "share_media");
        CMD_SINGLE_VIDEO_CLIP = kwaiOpenSdkCmdEnum3 = new KwaiOpenSdkCmdEnum("CMD_SINGLE_VIDEO_CLIP", 7, 8, "single_video_clip", bl2, bl3, "post-ft", "kwai_bundle_post_single_video_clip", "share_media");
        CMD_MULTI_MEDIA_CLIP = kwaiOpenSdkCmdEnum2 = new KwaiOpenSdkCmdEnum("CMD_MULTI_MEDIA_CLIP", 8, 9, "multi_media_clip", bl4, bl5, "post-ft", "kwai_bundle_post_multi_media_clip", "share_media");
        CMD_AI_CUT_MEDIAS = kwaiOpenSdkCmdEnum = new KwaiOpenSdkCmdEnum("CMD_AI_CUT_MEDIAS", 9, 10, "ai_cut_medias", bl2, bl3, "post-ft", "kwai_bundle_post_ai_cut_medias", "share_media");
        KwaiOpenSdkCmdEnum[] kwaiOpenSdkCmdEnumArray = new KwaiOpenSdkCmdEnum[]{kwaiOpenSdkCmdEnum9, kwaiOpenSdkCmdEnum10, kwaiOpenSdkCmdEnum8, kwaiOpenSdkCmdEnum7, kwaiOpenSdkCmdEnum6, kwaiOpenSdkCmdEnum5, kwaiOpenSdkCmdEnum4, kwaiOpenSdkCmdEnum3, kwaiOpenSdkCmdEnum2, kwaiOpenSdkCmdEnum};
        $VALUES = kwaiOpenSdkCmdEnumArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private KwaiOpenSdkCmdEnum(boolean bl2, boolean bl3, String string2, String string3, String string4) {
        void var9_7;
        void var8_6;
        void var2_-1;
        void var1_-1;
        this.type = (int)(bl2 ? 1 : 0);
        this.cmd = (String)bl3;
        this.isAuthCmd = string2;
        this.feature = string4;
        this.isNeedLogin = string3;
        this.bundleKey = var8_6;
        this.verifyStr = var9_7;
    }

    public static KwaiOpenSdkCmdEnum getOpenSdkCmd(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 10: {
                return CMD_AI_CUT_MEDIAS;
            }
            case 9: {
                return CMD_MULTI_MEDIA_CLIP;
            }
            case 8: {
                return CMD_SINGLE_VIDEO_CLIP;
            }
            case 7: {
                return CMD_SINGLE_VIDEO_EDIT;
            }
            case 6: {
                return CMD_SINGLE_VIDEO_PUBLISH;
            }
            case 5: {
                return CMD_SINGLE_PICTURE_PUBLISH;
            }
            case 4: {
                return CMD_SINGLE_PICTURE_EDIT;
            }
            case 3: {
                return CMD_SHOW_PROFILE;
            }
            case 2: {
                return CMD_SHARE_MESSAGE_TO_BUDDY;
            }
            case 1: 
        }
        return CMD_SHARE_MESSAGE;
    }

    public static KwaiOpenSdkCmdEnum getOpenSdkCmd(String string2) {
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 2001009187: {
                String string3 = "ai_cut_medias";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n11 = 9;
                break;
            }
            case 1601196442: {
                String string4 = "share_message_to_buddy";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n11 = 8;
                break;
            }
            case 1436970385: {
                String string5 = "multi_media_clip";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n11 = 7;
                break;
            }
            case 1132183143: {
                String string6 = "show_profile";
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n11 = 6;
                break;
            }
            case 751494548: {
                String string7 = "single_video_publish";
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n11 = 5;
                break;
            }
            case -713356073: {
                String string8 = "single_picture_publish";
                boolean bl7 = string2.equals(string8);
                if (!bl7) break;
                n11 = 4;
                break;
            }
            case -958377150: {
                String string9 = "single_picture_edit";
                boolean bl8 = string2.equals(string9);
                if (!bl8) break;
                n11 = 3;
                break;
            }
            case -965968987: {
                String string10 = "single_video_edit";
                boolean bl9 = string2.equals(string10);
                if (!bl9) break;
                n11 = 2;
                break;
            }
            case -966020885: {
                String string11 = "single_video_clip";
                boolean bl10 = string2.equals(string11);
                if (!bl10) break;
                n11 = 1;
                break;
            }
            case -1126324313: {
                String string12 = "share_message";
                boolean bl11 = string2.equals(string12);
                if (!bl11) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                return null;
            }
            case 9: {
                return CMD_AI_CUT_MEDIAS;
            }
            case 8: {
                return CMD_SHARE_MESSAGE_TO_BUDDY;
            }
            case 7: {
                return CMD_MULTI_MEDIA_CLIP;
            }
            case 6: {
                return CMD_SHOW_PROFILE;
            }
            case 5: {
                return CMD_SINGLE_VIDEO_PUBLISH;
            }
            case 4: {
                return CMD_SINGLE_PICTURE_PUBLISH;
            }
            case 3: {
                return CMD_SINGLE_PICTURE_EDIT;
            }
            case 2: {
                return CMD_SINGLE_VIDEO_EDIT;
            }
            case 1: {
                return CMD_SINGLE_VIDEO_CLIP;
            }
            case 0: 
        }
        return CMD_SHARE_MESSAGE;
    }

    public static KwaiOpenSdkCmdEnum valueOf(String string2) {
        return Enum.valueOf(KwaiOpenSdkCmdEnum.class, string2);
    }

    public static KwaiOpenSdkCmdEnum[] values() {
        return (KwaiOpenSdkCmdEnum[])$VALUES.clone();
    }

    public String getBundleKey() {
        return this.bundleKey;
    }

    public String getCmdString() {
        return this.cmd;
    }

    public String getFeature() {
        return this.feature;
    }

    public int getType() {
        return this.type;
    }

    public String getVerifyStr() {
        return this.verifyStr;
    }

    public boolean isAuthCmd() {
        return this.isAuthCmd;
    }

    public boolean isNeedLogin() {
        return this.isNeedLogin;
    }
}

