/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.utils;

import android.os.Bundle;
import com.kwai.opensdk.sdk.utils.LogUtil;
import java.util.ArrayList;

public class BundleUtil {
    public static boolean getBooleanExtra(Bundle bundle, String charSequence) {
        if (bundle != null) {
            try {
                return bundle.getBoolean((String)charSequence);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                String string2 = "getBooleanExtra exception:";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                charSequence = "KwaiOpenSdk";
                LogUtil.e((String)charSequence, string3);
            }
        }
        return false;
    }

    public static byte[] getByteArrayExtra(Bundle bundle, String charSequence) {
        if (bundle != null) {
            try {
                return bundle.getByteArray((String)charSequence);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                String string2 = "getByteArrayExtra exception:";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                charSequence = "KwaiOpenSdk";
                LogUtil.e((String)charSequence, string3);
            }
        }
        return null;
    }

    public static int getIntExtra(Bundle bundle, String charSequence, int n10) {
        if (bundle != null) {
            try {
                return bundle.getInt((String)charSequence, n10);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                String string2 = "getIntExtra exception:";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                charSequence = "KwaiOpenSdk";
                LogUtil.e((String)charSequence, string3);
            }
        }
        return n10;
    }

    public static long getLongExtra(Bundle bundle, String charSequence) {
        if (bundle != null) {
            try {
                return bundle.getLong((String)charSequence);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                String string2 = "getLongExtra exception:";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                charSequence = "KwaiOpenSdk";
                LogUtil.e((String)charSequence, string3);
            }
        }
        return 0L;
    }

    public static ArrayList getStringArrayListExtra(Bundle bundle, String charSequence) {
        if (bundle != null) {
            try {
                return bundle.getStringArrayList((String)charSequence);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                String string2 = "getStringArrayListExtra exception:";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                charSequence = "KwaiOpenSdk";
                LogUtil.e((String)charSequence, string3);
            }
        }
        return null;
    }

    public static String getStringExtra(Bundle bundle, String charSequence) {
        if (bundle != null) {
            try {
                return bundle.getString((String)charSequence);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                String string2 = "getStringExtra exception:";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                charSequence = "KwaiOpenSdk";
                LogUtil.e((String)charSequence, string3);
            }
        }
        return null;
    }
}

