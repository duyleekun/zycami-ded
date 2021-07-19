/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location;

import com.baidu.location.Address;

public class Address$Builder {
    private static final String BEI_JING = "\u5317\u4eac";
    private static final String CHONG_QIN = "\u91cd\u5e86";
    private static final String SHANG_HAI = "\u4e0a\u6d77";
    private static final String TIAN_JIN = "\u5929\u6d25";
    private String mAdcode = null;
    private String mAddress = null;
    private String mCity = null;
    private String mCityCode = null;
    private String mCountry = null;
    private String mCountryCode = null;
    private String mDistrict = null;
    private String mProvince = null;
    private String mStreet = null;
    private String mStreetNumber = null;
    private String mTown = null;

    public static /* synthetic */ String access$100(Address$Builder address$Builder) {
        return address$Builder.mCountry;
    }

    public static /* synthetic */ String access$1000(Address$Builder address$Builder) {
        return address$Builder.mAdcode;
    }

    public static /* synthetic */ String access$1100(Address$Builder address$Builder) {
        return address$Builder.mTown;
    }

    public static /* synthetic */ String access$200(Address$Builder address$Builder) {
        return address$Builder.mCountryCode;
    }

    public static /* synthetic */ String access$300(Address$Builder address$Builder) {
        return address$Builder.mProvince;
    }

    public static /* synthetic */ String access$400(Address$Builder address$Builder) {
        return address$Builder.mCity;
    }

    public static /* synthetic */ String access$500(Address$Builder address$Builder) {
        return address$Builder.mCityCode;
    }

    public static /* synthetic */ String access$600(Address$Builder address$Builder) {
        return address$Builder.mDistrict;
    }

    public static /* synthetic */ String access$700(Address$Builder address$Builder) {
        return address$Builder.mStreet;
    }

    public static /* synthetic */ String access$800(Address$Builder address$Builder) {
        return address$Builder.mStreetNumber;
    }

    public static /* synthetic */ String access$900(Address$Builder address$Builder) {
        return address$Builder.mAddress;
    }

    public Address$Builder adcode(String string2) {
        this.mAdcode = string2;
        return this;
    }

    public Address build() {
        int n10;
        String string2;
        Object object;
        block10: {
            block11: {
                String string3;
                object = new StringBuffer();
                string2 = this.mCountry;
                if (string2 != null) {
                    ((StringBuffer)object).append(string2);
                }
                if ((string2 = this.mProvince) != null) {
                    ((StringBuffer)object).append(string2);
                }
                if ((string2 = this.mProvince) != null && (string3 = this.mCity) != null && (n10 = string2.equals(string3)) == 0) {
                    string2 = this.mCity;
                    ((StringBuffer)object).append(string2);
                }
                if ((string2 = this.mDistrict) == null) break block10;
                string3 = this.mCity;
                if (string3 == null) break block11;
                n10 = string3.equals(string2);
                if (n10 != 0) break block10;
                string2 = this.mDistrict;
            }
            ((StringBuffer)object).append(string2);
        }
        if ((string2 = this.mTown) != null) {
            ((StringBuffer)object).append(string2);
        }
        if ((string2 = this.mStreet) != null) {
            ((StringBuffer)object).append(string2);
        }
        if ((string2 = this.mStreetNumber) != null) {
            ((StringBuffer)object).append(string2);
        }
        if ((n10 = ((StringBuffer)object).length()) > 0) {
            this.mAddress = object = ((StringBuffer)object).toString();
        }
        object = new Address(this, null);
        return object;
    }

    public Address$Builder city(String string2) {
        this.mCity = string2;
        return this;
    }

    public Address$Builder cityCode(String string2) {
        this.mCityCode = string2;
        return this;
    }

    public Address$Builder country(String string2) {
        this.mCountry = string2;
        return this;
    }

    public Address$Builder countryCode(String string2) {
        this.mCountryCode = string2;
        return this;
    }

    public Address$Builder district(String string2) {
        this.mDistrict = string2;
        return this;
    }

    public Address$Builder province(String string2) {
        this.mProvince = string2;
        return this;
    }

    public Address$Builder street(String string2) {
        this.mStreet = string2;
        return this;
    }

    public Address$Builder streetNumber(String string2) {
        this.mStreetNumber = string2;
        return this;
    }

    public Address$Builder town(String string2) {
        this.mTown = string2;
        return this;
    }
}

