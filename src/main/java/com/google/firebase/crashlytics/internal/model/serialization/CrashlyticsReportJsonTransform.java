/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  android.util.JsonReader
 */
package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem$Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User$Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$$Lambda$1;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$$Lambda$2;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$$Lambda$3;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$$Lambda$4;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$$Lambda$5;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$$Lambda$6;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$$Lambda$7;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform$ObjectParser;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

public class CrashlyticsReportJsonTransform {
    private static final DataEncoder CRASHLYTICS_REPORT_JSON_ENCODER;

    static {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        Configurator configurator = AutoCrashlyticsReportEncoder.CONFIG;
        CRASHLYTICS_REPORT_JSON_ENCODER = jsonDataEncoderBuilder.configureWith(configurator).ignoreNullValues(true).build();
    }

    public static /* synthetic */ CrashlyticsReport$Session$Event access$lambda$0(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEvent(jsonReader);
    }

    public static /* synthetic */ CrashlyticsReport$FilesPayload$File access$lambda$1(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseFile(jsonReader);
    }

    public static /* synthetic */ CrashlyticsReport$CustomAttribute access$lambda$2(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader);
    }

    public static /* synthetic */ CrashlyticsReport$Session$Event$Application$Execution$Thread access$lambda$3(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventThread(jsonReader);
    }

    public static /* synthetic */ CrashlyticsReport$Session$Event$Application$Execution$BinaryImage access$lambda$4(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventBinaryImage(jsonReader);
    }

    public static /* synthetic */ CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame access$lambda$5(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventFrame(jsonReader);
    }

    public static /* synthetic */ CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame access$lambda$6(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventFrame(jsonReader);
    }

    private static CrashlyticsReport$Session$Application parseApp(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$Application$Builder crashlyticsReport$Session$Application$Builder = CrashlyticsReport$Session$Application.builder();
        jsonReader.beginObject();
        block16: while (bl2 = jsonReader.hasNext()) {
            String string2 = jsonReader.nextName();
            string2.hashCode();
            int n10 = -1;
            int n11 = string2.hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 1975623094: {
                    String string3 = "displayVersion";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 5;
                    break;
                }
                case 719853845: {
                    String string3 = "installationUuid";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 4;
                    break;
                }
                case 351608024: {
                    String string3 = "version";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 3;
                    break;
                }
                case 213652010: {
                    String string3 = "developmentPlatformVersion";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 2;
                    break;
                }
                case -519438642: {
                    String string3 = "developmentPlatform";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 1;
                    break;
                }
                case -1618432855: {
                    String string3 = "identifier";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    jsonReader.skipValue();
                    continue block16;
                }
                case 5: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Application$Builder.setDisplayVersion(string2);
                    continue block16;
                }
                case 4: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Application$Builder.setInstallationUuid(string2);
                    continue block16;
                }
                case 3: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Application$Builder.setVersion(string2);
                    continue block16;
                }
                case 2: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Application$Builder.setDevelopmentPlatformVersion(string2);
                    continue block16;
                }
                case 1: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Application$Builder.setDevelopmentPlatform(string2);
                    continue block16;
                }
                case 0: 
            }
            string2 = jsonReader.nextString();
            crashlyticsReport$Session$Application$Builder.setIdentifier(string2);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Application$Builder.build();
    }

    private static ImmutableList parseArray(JsonReader jsonReader, CrashlyticsReportJsonTransform$ObjectParser crashlyticsReportJsonTransform$ObjectParser) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        jsonReader.beginArray();
        while (bl2 = jsonReader.hasNext()) {
            Object object = crashlyticsReportJsonTransform$ObjectParser.parse(jsonReader);
            arrayList.add(object);
        }
        jsonReader.endArray();
        return ImmutableList.from(arrayList);
    }

    private static CrashlyticsReport$CustomAttribute parseCustomAttribute(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$CustomAttribute$Builder crashlyticsReport$CustomAttribute$Builder = CrashlyticsReport$CustomAttribute.builder();
        jsonReader.beginObject();
        while (bl2 = jsonReader.hasNext()) {
            String string2 = jsonReader.nextName();
            string2.hashCode();
            String string3 = "key";
            boolean bl3 = string2.equals(string3);
            if (!bl3) {
                string3 = "value";
                bl2 = string2.equals(string3);
                if (!bl2) {
                    jsonReader.skipValue();
                    continue;
                }
                string2 = jsonReader.nextString();
                crashlyticsReport$CustomAttribute$Builder.setValue(string2);
                continue;
            }
            string2 = jsonReader.nextString();
            crashlyticsReport$CustomAttribute$Builder.setKey(string2);
        }
        jsonReader.endObject();
        return crashlyticsReport$CustomAttribute$Builder.build();
    }

    private static CrashlyticsReport$Session$Device parseDevice(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$Device$Builder crashlyticsReport$Session$Device$Builder = CrashlyticsReport$Session$Device.builder();
        jsonReader.beginObject();
        block22: while (bl2 = jsonReader.hasNext()) {
            String string2 = jsonReader.nextName();
            string2.hashCode();
            int n10 = -1;
            int n11 = string2.hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 2078953423: {
                    String string3 = "modelClass";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 8;
                    break;
                }
                case 109757585: {
                    String string3 = "state";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 7;
                    break;
                }
                case 104069929: {
                    String string3 = "model";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 6;
                    break;
                }
                case 94848180: {
                    String string3 = "cores";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 5;
                    break;
                }
                case 81784169: {
                    String string3 = "diskSpace";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 4;
                    break;
                }
                case 3002454: {
                    String string3 = "arch";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 3;
                    break;
                }
                case 112670: {
                    String string3 = "ram";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 2;
                    break;
                }
                case -1969347631: {
                    String string3 = "manufacturer";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 1;
                    break;
                }
                case -1981332476: {
                    String string3 = "simulator";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    jsonReader.skipValue();
                    continue block22;
                }
                case 8: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Device$Builder.setModelClass(string2);
                    continue block22;
                }
                case 7: {
                    bl2 = jsonReader.nextInt();
                    crashlyticsReport$Session$Device$Builder.setState((int)(bl2 ? 1 : 0));
                    continue block22;
                }
                case 6: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Device$Builder.setModel(string2);
                    continue block22;
                }
                case 5: {
                    bl2 = jsonReader.nextInt();
                    crashlyticsReport$Session$Device$Builder.setCores((int)(bl2 ? 1 : 0));
                    continue block22;
                }
                case 4: {
                    long l10 = jsonReader.nextLong();
                    crashlyticsReport$Session$Device$Builder.setDiskSpace(l10);
                    continue block22;
                }
                case 3: {
                    bl2 = jsonReader.nextInt();
                    crashlyticsReport$Session$Device$Builder.setArch((int)(bl2 ? 1 : 0));
                    continue block22;
                }
                case 2: {
                    long l10 = jsonReader.nextLong();
                    crashlyticsReport$Session$Device$Builder.setRam(l10);
                    continue block22;
                }
                case 1: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Device$Builder.setManufacturer(string2);
                    continue block22;
                }
                case 0: 
            }
            bl2 = jsonReader.nextBoolean();
            crashlyticsReport$Session$Device$Builder.setSimulator(bl2);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Device$Builder.build();
    }

    private static CrashlyticsReport$Session$Event parseEvent(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$Event$Builder crashlyticsReport$Session$Event$Builder = CrashlyticsReport$Session$Event.builder();
        jsonReader.beginObject();
        block14: while (bl2 = jsonReader.hasNext()) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            int n10 = -1;
            int n11 = ((String)object).hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 55126294: {
                    String string2 = "timestamp";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 4;
                    break;
                }
                case 3575610: {
                    String string2 = "type";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 3;
                    break;
                }
                case 107332: {
                    String string2 = "log";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 2;
                    break;
                }
                case 96801: {
                    String string2 = "app";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 1;
                    break;
                }
                case -1335157162: {
                    String string2 = "device";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    jsonReader.skipValue();
                    continue block14;
                }
                case 4: {
                    long l10 = jsonReader.nextLong();
                    crashlyticsReport$Session$Event$Builder.setTimestamp(l10);
                    continue block14;
                }
                case 3: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Session$Event$Builder.setType((String)object);
                    continue block14;
                }
                case 2: {
                    object = CrashlyticsReportJsonTransform.parseEventLog(jsonReader);
                    crashlyticsReport$Session$Event$Builder.setLog((CrashlyticsReport$Session$Event$Log)object);
                    continue block14;
                }
                case 1: {
                    object = CrashlyticsReportJsonTransform.parseEventApp(jsonReader);
                    crashlyticsReport$Session$Event$Builder.setApp((CrashlyticsReport$Session$Event$Application)object);
                    continue block14;
                }
                case 0: 
            }
            object = CrashlyticsReportJsonTransform.parseEventDevice(jsonReader);
            crashlyticsReport$Session$Event$Builder.setDevice((CrashlyticsReport$Session$Event$Device)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Builder.build();
    }

    private static CrashlyticsReport$Session$Event$Application parseEventApp(JsonReader jsonReader) {
        int n10;
        CrashlyticsReport$Session$Event$Application$Builder crashlyticsReport$Session$Event$Application$Builder = CrashlyticsReport$Session$Event$Application.builder();
        jsonReader.beginObject();
        block12: while ((n10 = jsonReader.hasNext()) != 0) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            int n11 = -1;
            int n12 = ((String)object).hashCode();
            switch (n12) {
                default: {
                    break;
                }
                case 928737948: {
                    String string2 = "uiOrientation";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 3;
                    break;
                }
                case 555169704: {
                    String string2 = "customAttributes";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 2;
                    break;
                }
                case -1090974952: {
                    String string2 = "execution";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 1;
                    break;
                }
                case -1332194002: {
                    String string2 = "background";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 0;
                }
            }
            switch (n11) {
                default: {
                    jsonReader.skipValue();
                    continue block12;
                }
                case 3: {
                    n10 = jsonReader.nextInt();
                    crashlyticsReport$Session$Event$Application$Builder.setUiOrientation(n10);
                    continue block12;
                }
                case 2: {
                    object = CrashlyticsReportJsonTransform$$Lambda$3.lambdaFactory$();
                    object = CrashlyticsReportJsonTransform.parseArray(jsonReader, (CrashlyticsReportJsonTransform$ObjectParser)object);
                    crashlyticsReport$Session$Event$Application$Builder.setCustomAttributes((ImmutableList)object);
                    continue block12;
                }
                case 1: {
                    object = CrashlyticsReportJsonTransform.parseEventExecution(jsonReader);
                    crashlyticsReport$Session$Event$Application$Builder.setExecution((CrashlyticsReport$Session$Event$Application$Execution)object);
                    continue block12;
                }
                case 0: 
            }
            n10 = (int)(jsonReader.nextBoolean() ? 1 : 0);
            object = n10 != 0;
            crashlyticsReport$Session$Event$Application$Builder.setBackground((Boolean)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Application$Builder.build();
    }

    private static CrashlyticsReport$Session$Event$Application$Execution$BinaryImage parseEventBinaryImage(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder = CrashlyticsReport$Session$Event$Application$Execution$BinaryImage.builder();
        jsonReader.beginObject();
        block12: while (bl2 = jsonReader.hasNext()) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            int n10 = -1;
            int n11 = ((String)object).hashCode();
            int n12 = 2;
            switch (n11) {
                default: {
                    break;
                }
                case 1153765347: {
                    String string2 = "baseAddress";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 3;
                    break;
                }
                case 3601339: {
                    String string2 = "uuid";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = n12;
                    break;
                }
                case 3530753: {
                    String string2 = "size";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 1;
                    break;
                }
                case 3373707: {
                    String string2 = "name";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    jsonReader.skipValue();
                    continue block12;
                }
                case 3: {
                    long l10 = jsonReader.nextLong();
                    crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder.setBaseAddress(l10);
                    continue block12;
                }
                case 2: {
                    object = Base64.decode((String)jsonReader.nextString(), (int)n12);
                    crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder.setUuidFromUtf8Bytes((byte[])object);
                    continue block12;
                }
                case 1: {
                    long l10 = jsonReader.nextLong();
                    crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder.setSize(l10);
                    continue block12;
                }
                case 0: 
            }
            object = jsonReader.nextString();
            crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder.setName((String)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder.build();
    }

    private static CrashlyticsReport$Session$Event$Device parseEventDevice(JsonReader jsonReader) {
        int n10;
        CrashlyticsReport$Session$Event$Device$Builder crashlyticsReport$Session$Event$Device$Builder = CrashlyticsReport$Session$Event$Device.builder();
        jsonReader.beginObject();
        block16: while ((n10 = jsonReader.hasNext()) != 0) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            int n11 = -1;
            int n12 = ((String)object).hashCode();
            switch (n12) {
                default: {
                    break;
                }
                case 1516795582: {
                    String string2 = "proximityOn";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 5;
                    break;
                }
                case 976541947: {
                    String string2 = "ramUsed";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 4;
                    break;
                }
                case 279795450: {
                    String string2 = "diskUsed";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 3;
                    break;
                }
                case -1439500848: {
                    String string2 = "orientation";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 2;
                    break;
                }
                case -1455558134: {
                    String string2 = "batteryVelocity";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 1;
                    break;
                }
                case -1708606089: {
                    String string2 = "batteryLevel";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 0;
                }
            }
            switch (n11) {
                default: {
                    jsonReader.skipValue();
                    continue block16;
                }
                case 5: {
                    n10 = jsonReader.nextBoolean();
                    crashlyticsReport$Session$Event$Device$Builder.setProximityOn(n10 != 0);
                    continue block16;
                }
                case 4: {
                    long l10 = jsonReader.nextLong();
                    crashlyticsReport$Session$Event$Device$Builder.setRamUsed(l10);
                    continue block16;
                }
                case 3: {
                    long l10 = jsonReader.nextLong();
                    crashlyticsReport$Session$Event$Device$Builder.setDiskUsed(l10);
                    continue block16;
                }
                case 2: {
                    n10 = jsonReader.nextInt();
                    crashlyticsReport$Session$Event$Device$Builder.setOrientation(n10);
                    continue block16;
                }
                case 1: {
                    n10 = jsonReader.nextInt();
                    crashlyticsReport$Session$Event$Device$Builder.setBatteryVelocity(n10);
                    continue block16;
                }
                case 0: 
            }
            double d10 = jsonReader.nextDouble();
            object = d10;
            crashlyticsReport$Session$Event$Device$Builder.setBatteryLevel((Double)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Device$Builder.build();
    }

    private static CrashlyticsReport$Session$Event$Application$Execution parseEventExecution(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$Event$Application$Execution$Builder crashlyticsReport$Session$Event$Application$Execution$Builder = CrashlyticsReport$Session$Event$Application$Execution.builder();
        jsonReader.beginObject();
        block12: while (bl2 = jsonReader.hasNext()) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            int n10 = -1;
            int n11 = ((String)object).hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 1481625679: {
                    String string2 = "exception";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 3;
                    break;
                }
                case 937615455: {
                    String string2 = "binaries";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 2;
                    break;
                }
                case -902467928: {
                    String string2 = "signal";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 1;
                    break;
                }
                case -1337936983: {
                    String string2 = "threads";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    jsonReader.skipValue();
                    continue block12;
                }
                case 3: {
                    object = CrashlyticsReportJsonTransform.parseEventExecutionException(jsonReader);
                    crashlyticsReport$Session$Event$Application$Execution$Builder.setException((CrashlyticsReport$Session$Event$Application$Execution$Exception)object);
                    continue block12;
                }
                case 2: {
                    object = CrashlyticsReportJsonTransform$$Lambda$5.lambdaFactory$();
                    object = CrashlyticsReportJsonTransform.parseArray(jsonReader, (CrashlyticsReportJsonTransform$ObjectParser)object);
                    crashlyticsReport$Session$Event$Application$Execution$Builder.setBinaries((ImmutableList)object);
                    continue block12;
                }
                case 1: {
                    object = CrashlyticsReportJsonTransform.parseEventSignal(jsonReader);
                    crashlyticsReport$Session$Event$Application$Execution$Builder.setSignal((CrashlyticsReport$Session$Event$Application$Execution$Signal)object);
                    continue block12;
                }
                case 0: 
            }
            object = CrashlyticsReportJsonTransform$$Lambda$4.lambdaFactory$();
            object = CrashlyticsReportJsonTransform.parseArray(jsonReader, (CrashlyticsReportJsonTransform$ObjectParser)object);
            crashlyticsReport$Session$Event$Application$Execution$Builder.setThreads((ImmutableList)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Application$Execution$Builder.build();
    }

    private static CrashlyticsReport$Session$Event$Application$Execution$Exception parseEventExecutionException(JsonReader jsonReader) {
        int n10;
        CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder crashlyticsReport$Session$Event$Application$Execution$Exception$Builder = CrashlyticsReport$Session$Event$Application$Execution$Exception.builder();
        jsonReader.beginObject();
        block14: while ((n10 = jsonReader.hasNext()) != 0) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            int n11 = -1;
            int n12 = ((String)object).hashCode();
            switch (n12) {
                default: {
                    break;
                }
                case 581754413: {
                    String string2 = "overflowCount";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 4;
                    break;
                }
                case 91997906: {
                    String string2 = "causedBy";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 3;
                    break;
                }
                case 3575610: {
                    String string2 = "type";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 2;
                    break;
                }
                case -934964668: {
                    String string2 = "reason";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 1;
                    break;
                }
                case -1266514778: {
                    String string2 = "frames";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 0;
                }
            }
            switch (n11) {
                default: {
                    jsonReader.skipValue();
                    continue block14;
                }
                case 4: {
                    n10 = jsonReader.nextInt();
                    crashlyticsReport$Session$Event$Application$Execution$Exception$Builder.setOverflowCount(n10);
                    continue block14;
                }
                case 3: {
                    object = CrashlyticsReportJsonTransform.parseEventExecutionException(jsonReader);
                    crashlyticsReport$Session$Event$Application$Execution$Exception$Builder.setCausedBy((CrashlyticsReport$Session$Event$Application$Execution$Exception)object);
                    continue block14;
                }
                case 2: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Session$Event$Application$Execution$Exception$Builder.setType((String)object);
                    continue block14;
                }
                case 1: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Session$Event$Application$Execution$Exception$Builder.setReason((String)object);
                    continue block14;
                }
                case 0: 
            }
            object = CrashlyticsReportJsonTransform$$Lambda$6.lambdaFactory$();
            object = CrashlyticsReportJsonTransform.parseArray(jsonReader, (CrashlyticsReportJsonTransform$ObjectParser)object);
            crashlyticsReport$Session$Event$Application$Execution$Exception$Builder.setFrames((ImmutableList)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Application$Execution$Exception$Builder.build();
    }

    private static CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame parseEventFrame(JsonReader jsonReader) {
        int n10;
        CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder = CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame.builder();
        jsonReader.beginObject();
        block14: while ((n10 = jsonReader.hasNext()) != 0) {
            long l10;
            String string2 = jsonReader.nextName();
            string2.hashCode();
            int n11 = -1;
            int n12 = string2.hashCode();
            switch (n12) {
                default: {
                    break;
                }
                case 2125650548: {
                    String string3 = "importance";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 4;
                    break;
                }
                case 3143036: {
                    String string3 = "file";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 3;
                    break;
                }
                case 3571: {
                    String string3 = "pc";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 2;
                    break;
                }
                case -887523944: {
                    String string3 = "symbol";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 1;
                    break;
                }
                case -1019779949: {
                    String string3 = "offset";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 0;
                }
            }
            switch (n11) {
                default: {
                    jsonReader.skipValue();
                    continue block14;
                }
                case 4: {
                    n10 = jsonReader.nextInt();
                    crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder.setImportance(n10);
                    continue block14;
                }
                case 3: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder.setFile(string2);
                    continue block14;
                }
                case 2: {
                    l10 = jsonReader.nextLong();
                    crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder.setPc(l10);
                    continue block14;
                }
                case 1: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder.setSymbol(string2);
                    continue block14;
                }
                case 0: 
            }
            l10 = jsonReader.nextLong();
            crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder.setOffset(l10);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder.build();
    }

    private static CrashlyticsReport$Session$Event$Log parseEventLog(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$Event$Log$Builder crashlyticsReport$Session$Event$Log$Builder = CrashlyticsReport$Session$Event$Log.builder();
        jsonReader.beginObject();
        while (bl2 = jsonReader.hasNext()) {
            String string2 = jsonReader.nextName();
            string2.hashCode();
            String string3 = "content";
            bl2 = string2.equals(string3);
            if (!bl2) {
                jsonReader.skipValue();
                continue;
            }
            string2 = jsonReader.nextString();
            crashlyticsReport$Session$Event$Log$Builder.setContent(string2);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Log$Builder.build();
    }

    private static CrashlyticsReport$Session$Event$Application$Execution$Signal parseEventSignal(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder crashlyticsReport$Session$Event$Application$Execution$Signal$Builder = CrashlyticsReport$Session$Event$Application$Execution$Signal.builder();
        jsonReader.beginObject();
        block10: while (bl2 = jsonReader.hasNext()) {
            String string2 = jsonReader.nextName();
            string2.hashCode();
            int n10 = -1;
            int n11 = string2.hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 3373707: {
                    String string3 = "name";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 2;
                    break;
                }
                case 3059181: {
                    String string3 = "code";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 1;
                    break;
                }
                case -1147692044: {
                    String string3 = "address";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    jsonReader.skipValue();
                    continue block10;
                }
                case 2: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Event$Application$Execution$Signal$Builder.setName(string2);
                    continue block10;
                }
                case 1: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$Event$Application$Execution$Signal$Builder.setCode(string2);
                    continue block10;
                }
                case 0: 
            }
            long l10 = jsonReader.nextLong();
            crashlyticsReport$Session$Event$Application$Execution$Signal$Builder.setAddress(l10);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Application$Execution$Signal$Builder.build();
    }

    private static CrashlyticsReport$Session$Event$Application$Execution$Thread parseEventThread(JsonReader jsonReader) {
        int n10;
        CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder crashlyticsReport$Session$Event$Application$Execution$Thread$Builder = CrashlyticsReport$Session$Event$Application$Execution$Thread.builder();
        jsonReader.beginObject();
        block10: while ((n10 = jsonReader.hasNext()) != 0) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            int n11 = -1;
            int n12 = ((String)object).hashCode();
            switch (n12) {
                default: {
                    break;
                }
                case 2125650548: {
                    String string2 = "importance";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 2;
                    break;
                }
                case 3373707: {
                    String string2 = "name";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 1;
                    break;
                }
                case -1266514778: {
                    String string2 = "frames";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 0;
                }
            }
            switch (n11) {
                default: {
                    jsonReader.skipValue();
                    continue block10;
                }
                case 2: {
                    n10 = jsonReader.nextInt();
                    crashlyticsReport$Session$Event$Application$Execution$Thread$Builder.setImportance(n10);
                    continue block10;
                }
                case 1: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Session$Event$Application$Execution$Thread$Builder.setName((String)object);
                    continue block10;
                }
                case 0: 
            }
            object = CrashlyticsReportJsonTransform$$Lambda$7.lambdaFactory$();
            object = CrashlyticsReportJsonTransform.parseArray(jsonReader, (CrashlyticsReportJsonTransform$ObjectParser)object);
            crashlyticsReport$Session$Event$Application$Execution$Thread$Builder.setFrames((ImmutableList)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Event$Application$Execution$Thread$Builder.build();
    }

    private static CrashlyticsReport$FilesPayload$File parseFile(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$FilesPayload$File$Builder crashlyticsReport$FilesPayload$File$Builder = CrashlyticsReport$FilesPayload$File.builder();
        jsonReader.beginObject();
        while (bl2 = jsonReader.hasNext()) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            String string2 = "filename";
            int n10 = ((String)object).equals(string2);
            if (n10 == 0) {
                string2 = "contents";
                bl2 = ((String)object).equals(string2);
                if (!bl2) {
                    jsonReader.skipValue();
                    continue;
                }
                object = jsonReader.nextString();
                n10 = 2;
                object = Base64.decode((String)object, (int)n10);
                crashlyticsReport$FilesPayload$File$Builder.setContents((byte[])object);
                continue;
            }
            object = jsonReader.nextString();
            crashlyticsReport$FilesPayload$File$Builder.setFilename((String)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$FilesPayload$File$Builder.build();
    }

    private static CrashlyticsReport$FilesPayload parseNdkPayload(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$FilesPayload$Builder crashlyticsReport$FilesPayload$Builder = CrashlyticsReport$FilesPayload.builder();
        jsonReader.beginObject();
        while (bl2 = jsonReader.hasNext()) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            String string2 = "files";
            boolean bl3 = ((String)object).equals(string2);
            if (!bl3) {
                string2 = "orgId";
                bl2 = ((String)object).equals(string2);
                if (!bl2) {
                    jsonReader.skipValue();
                    continue;
                }
                object = jsonReader.nextString();
                crashlyticsReport$FilesPayload$Builder.setOrgId((String)object);
                continue;
            }
            object = CrashlyticsReportJsonTransform$$Lambda$2.lambdaFactory$();
            object = CrashlyticsReportJsonTransform.parseArray(jsonReader, (CrashlyticsReportJsonTransform$ObjectParser)object);
            crashlyticsReport$FilesPayload$Builder.setFiles((ImmutableList)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$FilesPayload$Builder.build();
    }

    private static CrashlyticsReport$Session$OperatingSystem parseOs(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$OperatingSystem$Builder crashlyticsReport$Session$OperatingSystem$Builder = CrashlyticsReport$Session$OperatingSystem.builder();
        jsonReader.beginObject();
        block12: while (bl2 = jsonReader.hasNext()) {
            String string2 = jsonReader.nextName();
            string2.hashCode();
            int n10 = -1;
            int n11 = string2.hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 1874684019: {
                    String string3 = "platform";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 3;
                    break;
                }
                case 351608024: {
                    String string3 = "version";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 2;
                    break;
                }
                case -293026577: {
                    String string3 = "jailbroken";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 1;
                    break;
                }
                case -911706486: {
                    String string3 = "buildVersion";
                    bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    jsonReader.skipValue();
                    continue block12;
                }
                case 3: {
                    bl2 = jsonReader.nextInt();
                    crashlyticsReport$Session$OperatingSystem$Builder.setPlatform((int)(bl2 ? 1 : 0));
                    continue block12;
                }
                case 2: {
                    string2 = jsonReader.nextString();
                    crashlyticsReport$Session$OperatingSystem$Builder.setVersion(string2);
                    continue block12;
                }
                case 1: {
                    bl2 = jsonReader.nextBoolean();
                    crashlyticsReport$Session$OperatingSystem$Builder.setJailbroken(bl2);
                    continue block12;
                }
                case 0: 
            }
            string2 = jsonReader.nextString();
            crashlyticsReport$Session$OperatingSystem$Builder.setBuildVersion(string2);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$OperatingSystem$Builder.build();
    }

    private static CrashlyticsReport parseReport(JsonReader jsonReader) {
        int n10;
        CrashlyticsReport$Builder crashlyticsReport$Builder = CrashlyticsReport.builder();
        jsonReader.beginObject();
        block20: while ((n10 = jsonReader.hasNext()) != 0) {
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            int n11 = -1;
            int n12 = ((String)object).hashCode();
            switch (n12) {
                default: {
                    break;
                }
                case 1984987798: {
                    String string2 = "session";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 7;
                    break;
                }
                case 1975623094: {
                    String string2 = "displayVersion";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 6;
                    break;
                }
                case 1874684019: {
                    String string2 = "platform";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 5;
                    break;
                }
                case 719853845: {
                    String string2 = "installationUuid";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 4;
                    break;
                }
                case 344431858: {
                    String string2 = "gmpAppId";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 3;
                    break;
                }
                case -911706486: {
                    String string2 = "buildVersion";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 2;
                    break;
                }
                case -1962630338: {
                    String string2 = "sdkVersion";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 1;
                    break;
                }
                case -2118372775: {
                    String string2 = "ndkPayload";
                    n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 0;
                }
            }
            switch (n11) {
                default: {
                    jsonReader.skipValue();
                    continue block20;
                }
                case 7: {
                    object = CrashlyticsReportJsonTransform.parseSession(jsonReader);
                    crashlyticsReport$Builder.setSession((CrashlyticsReport$Session)object);
                    continue block20;
                }
                case 6: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Builder.setDisplayVersion((String)object);
                    continue block20;
                }
                case 5: {
                    n10 = jsonReader.nextInt();
                    crashlyticsReport$Builder.setPlatform(n10);
                    continue block20;
                }
                case 4: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Builder.setInstallationUuid((String)object);
                    continue block20;
                }
                case 3: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Builder.setGmpAppId((String)object);
                    continue block20;
                }
                case 2: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Builder.setBuildVersion((String)object);
                    continue block20;
                }
                case 1: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Builder.setSdkVersion((String)object);
                    continue block20;
                }
                case 0: 
            }
            object = CrashlyticsReportJsonTransform.parseNdkPayload(jsonReader);
            crashlyticsReport$Builder.setNdkPayload((CrashlyticsReport$FilesPayload)object);
        }
        jsonReader.endObject();
        return crashlyticsReport$Builder.build();
    }

    private static CrashlyticsReport$Session parseSession(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$Builder crashlyticsReport$Session$Builder = CrashlyticsReport$Session.builder();
        jsonReader.beginObject();
        block26: while (bl2 = jsonReader.hasNext()) {
            long l10;
            Object object = jsonReader.nextName();
            ((String)object).hashCode();
            int n10 = -1;
            int n11 = ((String)object).hashCode();
            int n12 = 2;
            switch (n11) {
                default: {
                    break;
                }
                case 2047016109: {
                    String string2 = "generatorType";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 10;
                    break;
                }
                case 1025385094: {
                    String string2 = "crashed";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 9;
                    break;
                }
                case 286956243: {
                    String string2 = "generator";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 8;
                    break;
                }
                case 3599307: {
                    String string2 = "user";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 7;
                    break;
                }
                case 96801: {
                    String string2 = "app";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 6;
                    break;
                }
                case 3556: {
                    String string2 = "os";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 5;
                    break;
                }
                case -1291329255: {
                    String string2 = "events";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 4;
                    break;
                }
                case -1335157162: {
                    String string2 = "device";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 3;
                    break;
                }
                case -1606742899: {
                    String string2 = "endedAt";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = n12;
                    break;
                }
                case -1618432855: {
                    String string2 = "identifier";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 1;
                    break;
                }
                case -2128794476: {
                    String string2 = "startedAt";
                    bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    jsonReader.skipValue();
                    continue block26;
                }
                case 10: {
                    bl2 = jsonReader.nextInt();
                    crashlyticsReport$Session$Builder.setGeneratorType((int)(bl2 ? 1 : 0));
                    continue block26;
                }
                case 9: {
                    bl2 = jsonReader.nextBoolean();
                    crashlyticsReport$Session$Builder.setCrashed(bl2);
                    continue block26;
                }
                case 8: {
                    object = jsonReader.nextString();
                    crashlyticsReport$Session$Builder.setGenerator((String)object);
                    continue block26;
                }
                case 7: {
                    object = CrashlyticsReportJsonTransform.parseUser(jsonReader);
                    crashlyticsReport$Session$Builder.setUser((CrashlyticsReport$Session$User)object);
                    continue block26;
                }
                case 6: {
                    object = CrashlyticsReportJsonTransform.parseApp(jsonReader);
                    crashlyticsReport$Session$Builder.setApp((CrashlyticsReport$Session$Application)object);
                    continue block26;
                }
                case 5: {
                    object = CrashlyticsReportJsonTransform.parseOs(jsonReader);
                    crashlyticsReport$Session$Builder.setOs((CrashlyticsReport$Session$OperatingSystem)object);
                    continue block26;
                }
                case 4: {
                    object = CrashlyticsReportJsonTransform$$Lambda$1.lambdaFactory$();
                    object = CrashlyticsReportJsonTransform.parseArray(jsonReader, (CrashlyticsReportJsonTransform$ObjectParser)object);
                    crashlyticsReport$Session$Builder.setEvents((ImmutableList)object);
                    continue block26;
                }
                case 3: {
                    object = CrashlyticsReportJsonTransform.parseDevice(jsonReader);
                    crashlyticsReport$Session$Builder.setDevice((CrashlyticsReport$Session$Device)object);
                    continue block26;
                }
                case 2: {
                    l10 = jsonReader.nextLong();
                    object = l10;
                    crashlyticsReport$Session$Builder.setEndedAt((Long)object);
                    continue block26;
                }
                case 1: {
                    object = Base64.decode((String)jsonReader.nextString(), (int)n12);
                    crashlyticsReport$Session$Builder.setIdentifierFromUtf8Bytes((byte[])object);
                    continue block26;
                }
                case 0: 
            }
            l10 = jsonReader.nextLong();
            crashlyticsReport$Session$Builder.setStartedAt(l10);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$Builder.build();
    }

    private static CrashlyticsReport$Session$User parseUser(JsonReader jsonReader) {
        boolean bl2;
        CrashlyticsReport$Session$User$Builder crashlyticsReport$Session$User$Builder = CrashlyticsReport$Session$User.builder();
        jsonReader.beginObject();
        while (bl2 = jsonReader.hasNext()) {
            String string2 = jsonReader.nextName();
            string2.hashCode();
            String string3 = "identifier";
            bl2 = string2.equals(string3);
            if (!bl2) {
                jsonReader.skipValue();
                continue;
            }
            string2 = jsonReader.nextString();
            crashlyticsReport$Session$User$Builder.setIdentifier(string2);
        }
        jsonReader.endObject();
        return crashlyticsReport$Session$User$Builder.build();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CrashlyticsReport$Session$Event eventFromJson(String object) {
        StringReader stringReader = new StringReader((String)object);
        Object object2 = new JsonReader((Reader)stringReader);
        {
            catch (IllegalStateException illegalStateException) {
                object2 = new IOException(illegalStateException);
                throw object2;
            }
            try {
                object = CrashlyticsReportJsonTransform.parseEvent(object2);
            }
            catch (Throwable throwable) {}
            try {
                object2.close();
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            {
                throw throwable;
            }
            {
                object2.close();
                return object;
            }
        }
    }

    public String eventToJson(CrashlyticsReport$Session$Event crashlyticsReport$Session$Event) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(crashlyticsReport$Session$Event);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CrashlyticsReport reportFromJson(String object) {
        StringReader stringReader = new StringReader((String)object);
        Object object2 = new JsonReader((Reader)stringReader);
        {
            catch (IllegalStateException illegalStateException) {
                object2 = new IOException(illegalStateException);
                throw object2;
            }
            try {
                object = CrashlyticsReportJsonTransform.parseReport(object2);
            }
            catch (Throwable throwable) {}
            try {
                object2.close();
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            {
                throw throwable;
            }
            {
                object2.close();
                return object;
            }
        }
    }

    public String reportToJson(CrashlyticsReport crashlyticsReport) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(crashlyticsReport);
    }
}

