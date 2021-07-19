/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs.local.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.SystemPropUtils;
import java.util.Locale;
import java.util.Objects;

public class CountryCodeBean {
    private static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
    private static final int COUNTRYCODE_SIZE = 2;
    private static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale";
    private static final String LOCALE_REGION_COUNTRYSYSTEMPROP = "ro.product.locale.region";
    private static final String SPECIAL_COUNTRYCODE_CN = "cn";
    private static final String SPECIAL_COUNTRYCODE_EU = "eu";
    private static final String SPECIAL_COUNTRYCODE_GB = "gb";
    private static final String SPECIAL_COUNTRYCODE_LA = "la";
    private static final String SPECIAL_COUNTRYCODE_UK = "uk";
    private static final String TAG = "CountryCodeBean";
    private static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
    private String countryCode;
    private String countrySource;

    public CountryCodeBean(Context object, boolean bl2) {
        String string2;
        this.countrySource = string2 = "UNKNOWN";
        this.countryCode = string2;
        this.init((Context)object, bl2);
        object = this.countryCode;
        Locale locale = Locale.ENGLISH;
        this.countryCode = object = ((String)object).toUpperCase(locale);
    }

    private void checkCodeLenth() {
        int n10;
        int n11;
        String string2 = this.countryCode;
        if (string2 == null || (n11 = string2.length()) != (n10 = 2)) {
            this.countryCode = string2 = "UNKNOWN";
            this.countrySource = string2;
        }
    }

    private void getLocaleCountryCode() {
        boolean bl2 = EmuiUtil.isUpPVersion();
        if (bl2) {
            this.getRegionSettingCountryCode();
        } else {
            this.getProductCountryCode();
        }
        this.countrySource = "LOCALE_INFO";
    }

    private void getProductCountryCode() {
        boolean bl2;
        int n10;
        String string2;
        CharSequence charSequence = "get";
        String string3 = ANDRIOD_SYSTEMPROP;
        String string4 = "UNKNOWN";
        this.countryCode = string2 = SystemPropUtils.getProperty((String)charSequence, LOCALE_REGION_COUNTRYSYSTEMPROP, string3, string4);
        string2 = TAG;
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("countryCode by ro.product.locale.region is:");
        String string5 = this.countryCode;
        charSequence2.append(string5);
        charSequence2 = charSequence2.toString();
        Logger.i(string2, charSequence2);
        charSequence2 = this.countryCode;
        int n11 = TextUtils.isEmpty((CharSequence)charSequence2);
        if ((n11 != 0 || (n11 = string4.equals(charSequence2 = this.countryCode)) != 0) && (n10 = TextUtils.isEmpty((CharSequence)(charSequence = SystemPropUtils.getProperty((String)charSequence, (String)(charSequence2 = LOCALE_COUNTRYSYSTEMPROP), string3, string4)))) == 0 && (n10 = ((String)charSequence).lastIndexOf(string3 = "-")) != (n11 = -1)) {
            charSequence = ((String)charSequence).substring(++n10);
            this.countryCode = charSequence;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("countryCode by ro.product.locale is:");
            string3 = this.countryCode;
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            Logger.i(string2, charSequence);
        }
        if (!(bl2 = (string2 = SPECIAL_COUNTRYCODE_CN).equalsIgnoreCase((String)(charSequence = this.countryCode)))) {
            this.countryCode = string4;
        }
    }

    private void getRegionSettingCountryCode() {
        String string2;
        this.countryCode = string2 = Locale.getDefault().getCountry();
        string2 = TAG;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("countryCode by system's region setting is: ");
        String string3 = this.countryCode;
        charSequence.append(string3);
        charSequence = charSequence.toString();
        Logger.i(string2, charSequence);
        string2 = this.countryCode;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            this.countryCode = string2 = "UNKNOWN";
        }
    }

    private void getSimCountryCode(Context context) {
        this.getSimCountryCode(context, false);
    }

    private void getSimCountryCode(Context object, boolean n10) {
        object = object.getApplicationContext();
        String string2 = "phone";
        if ((object = (TelephonyManager)object.getSystemService(string2)) != null) {
            CharSequence charSequence;
            int n11;
            if (n10 != 0 && (n10 = object.getPhoneType()) != (n11 = 2)) {
                object = object.getNetworkCountryIso();
                this.countryCode = object;
                this.countrySource = "NETWORK_COUNTRY";
                object = TAG;
                charSequence = new StringBuilder();
                string2 = "countryCode by NetworkCountryIso is: ";
            } else {
                object = object.getSimCountryIso();
                this.countryCode = object;
                this.countrySource = "SIM_COUNTRY";
                object = TAG;
                charSequence = new StringBuilder();
                string2 = "countryCode by SimCountryIso is: ";
            }
            charSequence.append(string2);
            string2 = this.countryCode;
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Logger.i((String)object, charSequence);
        }
        this.checkCodeLenth();
    }

    private void getVendorCountryCode() {
        String string2;
        String string3;
        this.countrySource = string3 = "VENDOR_COUNTRY";
        String string4 = "UNKNOWN";
        this.countryCode = string2 = SystemPropUtils.getProperty("get", VENDORCOUNTRY_SYSTEMPROP, ANDRIOD_SYSTEMPROP, string4);
        string2 = TAG;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("countryCode by ro.hw.country is: ");
        String string5 = this.countryCode;
        charSequence.append(string5);
        charSequence = charSequence.toString();
        Logger.i(string2, charSequence);
        charSequence = this.countryCode;
        string5 = SPECIAL_COUNTRYCODE_EU;
        boolean bl2 = string5.equalsIgnoreCase((String)charSequence);
        if (!bl2 && !(bl2 = (string5 = SPECIAL_COUNTRYCODE_LA).equalsIgnoreCase((String)(charSequence = this.countryCode)))) {
            string5 = SPECIAL_COUNTRYCODE_UK;
            charSequence = this.countryCode;
            bl2 = string5.equalsIgnoreCase((String)charSequence);
            if (bl2) {
                charSequence = "special country of UK to map GB.";
                Logger.i(string2, charSequence);
                this.countryCode = string2 = SPECIAL_COUNTRYCODE_GB;
                this.countrySource = string3;
            } else {
                this.checkCodeLenth();
            }
        } else {
            this.countryCode = string4;
            this.countrySource = string4;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void init(Context object, boolean bl2) {
        String string2 = "context must be not null.Please provide app's Context";
        Objects.requireNonNull(object, string2);
        try {
            this.getVendorCountryCode();
            boolean bl3 = this.isCodeValidate();
            if (bl3) {
                String string3 = TAG;
                string2 = "get issue_country code from VENDOR_COUNTRY";
                Logger.i(string3, string2);
                return;
            }
            this.getSimCountryCode((Context)object);
            boolean bl4 = this.isCodeValidate();
            if (bl4) {
                String string4 = TAG;
                string2 = "get issue_country code from SIM_COUNTRY";
                Logger.i(string4, string2);
                return;
            }
            this.getLocaleCountryCode();
            bl4 = this.isCodeValidate();
            if (!bl4) return;
            String string5 = TAG;
            string2 = "get issue_country code from LOCALE_INFO";
            Logger.i(string5, string2);
            return;
        }
        catch (Exception exception) {
            String string6 = TAG;
            string2 = "get CountryCode error";
            Logger.w(string6, string2);
        }
    }

    private boolean isCodeValidate() {
        String string2 = this.countryCode;
        return "UNKNOWN".equals(string2) ^ true;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountrySource() {
        return this.countrySource;
    }
}

