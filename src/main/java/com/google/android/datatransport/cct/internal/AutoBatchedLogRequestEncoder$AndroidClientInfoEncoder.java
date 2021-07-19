/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

public final class AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder
implements ObjectEncoder {
    private static final FieldDescriptor APPLICATIONBUILD_DESCRIPTOR;
    private static final FieldDescriptor COUNTRY_DESCRIPTOR;
    private static final FieldDescriptor DEVICE_DESCRIPTOR;
    private static final FieldDescriptor FINGERPRINT_DESCRIPTOR;
    private static final FieldDescriptor HARDWARE_DESCRIPTOR;
    public static final AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder INSTANCE;
    private static final FieldDescriptor LOCALE_DESCRIPTOR;
    private static final FieldDescriptor MANUFACTURER_DESCRIPTOR;
    private static final FieldDescriptor MCCMNC_DESCRIPTOR;
    private static final FieldDescriptor MODEL_DESCRIPTOR;
    private static final FieldDescriptor OSBUILD_DESCRIPTOR;
    private static final FieldDescriptor PRODUCT_DESCRIPTOR;
    private static final FieldDescriptor SDKVERSION_DESCRIPTOR;

    static {
        AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder autoBatchedLogRequestEncoder$AndroidClientInfoEncoder;
        INSTANCE = autoBatchedLogRequestEncoder$AndroidClientInfoEncoder = new AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder();
        SDKVERSION_DESCRIPTOR = FieldDescriptor.of("sdkVersion");
        MODEL_DESCRIPTOR = FieldDescriptor.of("model");
        HARDWARE_DESCRIPTOR = FieldDescriptor.of("hardware");
        DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
        PRODUCT_DESCRIPTOR = FieldDescriptor.of("product");
        OSBUILD_DESCRIPTOR = FieldDescriptor.of("osBuild");
        MANUFACTURER_DESCRIPTOR = FieldDescriptor.of("manufacturer");
        FINGERPRINT_DESCRIPTOR = FieldDescriptor.of("fingerprint");
        LOCALE_DESCRIPTOR = FieldDescriptor.of("locale");
        COUNTRY_DESCRIPTOR = FieldDescriptor.of("country");
        MCCMNC_DESCRIPTOR = FieldDescriptor.of("mccMnc");
        APPLICATIONBUILD_DESCRIPTOR = FieldDescriptor.of("applicationBuild");
    }

    private AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder() {
    }

    public void encode(AndroidClientInfo object, ObjectEncoderContext objectEncoderContext) {
        FieldDescriptor fieldDescriptor = SDKVERSION_DESCRIPTOR;
        Object object2 = ((AndroidClientInfo)object).getSdkVersion();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = MODEL_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getModel();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = HARDWARE_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getHardware();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = DEVICE_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getDevice();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = PRODUCT_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getProduct();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = OSBUILD_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getOsBuild();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = MANUFACTURER_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getManufacturer();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = FINGERPRINT_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getFingerprint();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = LOCALE_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getLocale();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = COUNTRY_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getCountry();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = MCCMNC_DESCRIPTOR;
        object2 = ((AndroidClientInfo)object).getMccMnc();
        objectEncoderContext.add(fieldDescriptor, object2);
        fieldDescriptor = APPLICATIONBUILD_DESCRIPTOR;
        object = ((AndroidClientInfo)object).getApplicationBuild();
        objectEncoderContext.add(fieldDescriptor, object);
    }
}

