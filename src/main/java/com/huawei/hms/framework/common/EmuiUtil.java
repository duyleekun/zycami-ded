/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.android.os.BuildEx$VERSION
 */
package com.huawei.hms.framework.common;

import com.huawei.android.os.BuildEx;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.ReflectionUtils;

public class EmuiUtil {
    private static final String BUILDEX_NAME = "com.huawei.android.os.BuildEx";
    public static final String BUILDEX_VERSION = "com.huawei.android.os.BuildEx$VERSION";
    private static final int EMUI_3_0 = 7;
    private static final int EMUI_3_1 = 8;
    private static final int EMUI_4_0 = 9;
    private static final int EMUI_4_1 = 10;
    private static final int EMUI_5_0 = 11;
    private static final int EMUI_6_0 = 14;
    private static final int EMUI_8_0_1 = 15;
    private static final int EMUI_9_0 = 17;
    public static final String EMUI_SDK_INT = "EMUI_SDK_INT";
    private static final int EMUI_TYPE_UNKOWN = 255;
    public static final String GET_PRIMARY_COLOR = "getPrimaryColor";
    public static final String GET_SUGGESTION_FOR_GROUND_COLOR_STYLE = "getSuggestionForgroundColorStyle";
    public static final String IMMERSION_STYLE = "com.huawei.android.immersion.ImmersionStyle";
    private static final String TAG = "KPMS_Util_Emui";
    private static final int TYPE_EMUI_30 = 30;
    private static final int TYPE_EMUI_31 = 31;
    private static final int TYPE_EMUI_40 = 40;
    private static final int TYPE_EMUI_41 = 41;
    private static final int TYPE_EMUI_50 = 50;
    private static final int TYPE_EMUI_60 = 60;
    private static final int TYPE_EMUI_801 = 81;
    private static final int TYPE_EMUI_90 = 90;
    private static int emuiType = 255;

    static {
        EmuiUtil.initEmuiType();
    }

    private static int getEMUIVersionCode() {
        CharSequence charSequence;
        int n10;
        String string2;
        block4: {
            Object object = ReflectionUtils.getStaticFieldObj(BUILDEX_VERSION, EMUI_SDK_INT);
            string2 = TAG;
            if (object != null) {
                object = (Integer)object;
                try {
                    n10 = (Integer)object;
                    break block4;
                }
                catch (ClassCastException classCastException) {
                    charSequence = "getEMUIVersionCode ClassCastException:";
                    Logger.e(string2, (String)charSequence, classCastException);
                }
            }
            n10 = 0;
            object = null;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("the emui version code is::");
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        Logger.d(string2, charSequence);
        return n10;
    }

    private static void initEmuiType() {
        int n10 = EmuiUtil.getEMUIVersionCode();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("getEmuiType emuiVersionCode=");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = TAG;
        Logger.d(string2, charSequence);
        int n11 = 17;
        if (n10 >= n11) {
            emuiType = n10 = 90;
        } else {
            n11 = 15;
            if (n10 >= n11) {
                emuiType = n10 = 81;
            } else {
                n11 = 14;
                if (n10 >= n11) {
                    emuiType = n10 = 60;
                } else {
                    n11 = 11;
                    if (n10 >= n11) {
                        emuiType = n10 = 50;
                    } else {
                        n11 = 10;
                        if (n10 >= n11) {
                            emuiType = n10 = 41;
                        } else {
                            n11 = 9;
                            if (n10 >= n11) {
                                emuiType = n10 = 40;
                            } else {
                                n11 = 8;
                                if (n10 >= n11) {
                                    emuiType = n10 = 31;
                                } else {
                                    n11 = 7;
                                    if (n10 >= n11) {
                                        emuiType = n10 = 30;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        n10 = emuiType;
        n11 = -1;
        if (n10 == n11) {
            String string3 = "emuiType is unkown";
            Logger.i(string2, string3);
        }
    }

    public static boolean isEMUI() {
        int n10 = -1;
        int n11 = emuiType;
        n11 = n10 != n11 ? 1 : 0;
        return n11 != 0;
    }

    public static boolean isUpPVersion() {
        int n10;
        String string2 = BUILDEX_NAME;
        int n11 = ReflectionUtils.checkCompatible(string2);
        if (n11 != 0 && (n11 = BuildEx.VERSION.EMUI_SDK_INT) >= (n10 = 17)) {
            n11 = 1;
        } else {
            n11 = 0;
            string2 = null;
        }
        return n11 != 0;
    }
}

