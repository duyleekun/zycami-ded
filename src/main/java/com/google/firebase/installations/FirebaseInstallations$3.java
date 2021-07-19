/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.remote.InstallationResponse$ResponseCode;
import com.google.firebase.installations.remote.TokenResult$ResponseCode;

public class FirebaseInstallations$3 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode;
    public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        Enum enum_;
        int n11;
        Object object;
        int n12 = TokenResult$ResponseCode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode = nArray;
        int n13 = 1;
        try {
            object = TokenResult$ResponseCode.OK;
            n11 = ((Enum)object).ordinal();
            nArray[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 2;
        try {
            object = $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode;
            enum_ = TokenResult$ResponseCode.BAD_CONFIG;
            n10 = enum_.ordinal();
            object[n10] = (TokenResult$ResponseCode)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode;
            enum_ = TokenResult$ResponseCode.AUTH_ERROR;
            n10 = enum_.ordinal();
            int n14 = 3;
            object[n10] = (TokenResult$ResponseCode)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = InstallationResponse$ResponseCode.values().length;
        object = new int[n11];
        $SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode = (int[])object;
        try {
            enum_ = InstallationResponse$ResponseCode.OK;
            n10 = enum_.ordinal();
            object[n10] = (TokenResult$ResponseCode)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            int[] nArray2 = $SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode;
            object = InstallationResponse$ResponseCode.BAD_CONFIG;
            n11 = ((Enum)object).ordinal();
            nArray2[n11] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

