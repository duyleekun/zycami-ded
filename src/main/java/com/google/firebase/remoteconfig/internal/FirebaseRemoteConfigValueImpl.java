/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import java.nio.charset.Charset;
import java.util.regex.Matcher;

public class FirebaseRemoteConfigValueImpl
implements FirebaseRemoteConfigValue {
    private static final String ILLEGAL_ARGUMENT_STRING_FORMAT = "[Value: %s] cannot be converted to a %s.";
    private final int source;
    private final String value;

    public FirebaseRemoteConfigValueImpl(String string2, int n10) {
        this.value = string2;
        this.source = n10;
    }

    private String asTrimmedString() {
        return this.asString().trim();
    }

    private void throwIfNullValue() {
        Object object = this.value;
        if (object != null) {
            return;
        }
        object = new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        throw object;
    }

    public boolean asBoolean() {
        int n10 = this.source;
        if (n10 == 0) {
            return false;
        }
        String string2 = this.asTrimmedString();
        Object object = ConfigGetParameterHandler.TRUE_REGEX.matcher(string2);
        boolean bl2 = ((Matcher)object).matches();
        int n11 = 1;
        if (bl2) {
            return n11 != 0;
        }
        object = ConfigGetParameterHandler.FALSE_REGEX.matcher(string2);
        bl2 = ((Matcher)object).matches();
        if (bl2) {
            return false;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = string2;
        objectArray[n11] = "boolean";
        string2 = String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, objectArray);
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public byte[] asByteArray() {
        int n10 = this.source;
        if (n10 == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        String string2 = this.value;
        Charset charset = ConfigGetParameterHandler.FRC_BYTE_ARRAY_ENCODING;
        return string2.getBytes(charset);
    }

    public double asDouble() {
        Double d10;
        int n10 = this.source;
        if (n10 == 0) {
            return 0.0;
        }
        String string2 = this.asTrimmedString();
        try {
            d10 = Double.valueOf(string2);
        }
        catch (NumberFormatException numberFormatException) {
            Object[] objectArray = new Object[]{string2, "double"};
            string2 = String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, objectArray);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2, numberFormatException);
            throw illegalArgumentException;
        }
        return d10;
    }

    public long asLong() {
        Long l10;
        int n10 = this.source;
        if (n10 == 0) {
            return 0L;
        }
        String string2 = this.asTrimmedString();
        try {
            l10 = Long.valueOf(string2);
        }
        catch (NumberFormatException numberFormatException) {
            Object[] objectArray = new Object[]{string2, "long"};
            string2 = String.format(ILLEGAL_ARGUMENT_STRING_FORMAT, objectArray);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2, numberFormatException);
            throw illegalArgumentException;
        }
        return l10;
    }

    public String asString() {
        int n10 = this.source;
        if (n10 == 0) {
            return "";
        }
        this.throwIfNullValue();
        return this.value;
    }

    public int getSource() {
        return this.source;
    }
}

