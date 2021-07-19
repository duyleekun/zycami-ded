/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location;

import com.baidu.location.Address$1;
import com.baidu.location.Address$Builder;

public final class Address {
    public final String adcode;
    public final String address;
    public final String city;
    public final String cityCode;
    public final String country;
    public final String countryCode;
    public final String district;
    public final String province;
    public final String street;
    public final String streetNumber;
    public final String town;

    private Address(Address$Builder object) {
        String string2;
        this.country = string2 = Address$Builder.access$100((Address$Builder)object);
        this.countryCode = string2 = Address$Builder.access$200((Address$Builder)object);
        this.province = string2 = Address$Builder.access$300((Address$Builder)object);
        this.city = string2 = Address$Builder.access$400((Address$Builder)object);
        this.cityCode = string2 = Address$Builder.access$500((Address$Builder)object);
        this.district = string2 = Address$Builder.access$600((Address$Builder)object);
        this.street = string2 = Address$Builder.access$700((Address$Builder)object);
        this.streetNumber = string2 = Address$Builder.access$800((Address$Builder)object);
        this.address = string2 = Address$Builder.access$900((Address$Builder)object);
        this.adcode = string2 = Address$Builder.access$1000((Address$Builder)object);
        this.town = object = Address$Builder.access$1100((Address$Builder)object);
    }

    public /* synthetic */ Address(Address$Builder address$Builder, Address$1 address$1) {
        this(address$Builder);
    }
}

