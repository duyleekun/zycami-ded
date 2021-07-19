/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender$$Lambda$1;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender$$Lambda$2;
import java.nio.charset.Charset;

public class DataTransportCrashlyticsReportSender {
    private static final String CRASHLYTICS_API_KEY;
    private static final String CRASHLYTICS_ENDPOINT;
    private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    private static final Transformer DEFAULT_TRANSFORM;
    private static final CrashlyticsReportJsonTransform TRANSFORM;
    private final Transport transport;
    private final Transformer transportTransform;

    static {
        CrashlyticsReportJsonTransform crashlyticsReportJsonTransform;
        TRANSFORM = crashlyticsReportJsonTransform = new CrashlyticsReportJsonTransform();
        CRASHLYTICS_ENDPOINT = DataTransportCrashlyticsReportSender.mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
        CRASHLYTICS_API_KEY = DataTransportCrashlyticsReportSender.mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
        DEFAULT_TRANSFORM = DataTransportCrashlyticsReportSender$$Lambda$2.lambdaFactory$();
    }

    public DataTransportCrashlyticsReportSender(Transport transport, Transformer transformer) {
        this.transport = transport;
        this.transportTransform = transformer;
    }

    public static DataTransportCrashlyticsReportSender create(Context object) {
        TransportRuntime.initialize((Context)object);
        object = TransportRuntime.getInstance();
        Object object2 = CRASHLYTICS_ENDPOINT;
        Object object3 = CRASHLYTICS_API_KEY;
        Object object4 = new CCTDestination((String)object2, (String)object3);
        object = ((TransportRuntime)object).newFactory((Destination)object4);
        object2 = Encoding.of("json");
        object3 = DEFAULT_TRANSFORM;
        object = object.getTransport(CRASHLYTICS_TRANSPORT_NAME, CrashlyticsReport.class, (Encoding)object2, (Transformer)object3);
        object4 = new DataTransportCrashlyticsReportSender((Transport)object, (Transformer)object3);
        return object4;
    }

    public static /* synthetic */ void lambda$sendReport$1(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exception) {
        if (exception != null) {
            taskCompletionSource.trySetException(exception);
            return;
        }
        taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
    }

    public static /* synthetic */ byte[] lambda$static$0(CrashlyticsReport object) {
        object = TRANSFORM.reportToJson((CrashlyticsReport)object);
        Charset charset = Charset.forName("UTF-8");
        return ((String)object).getBytes(charset);
    }

    private static String mergeStrings(String object, String string2) {
        int n10 = ((String)object).length();
        int n11 = string2.length();
        if ((n10 -= n11) >= 0 && n10 <= (n11 = 1)) {
            char c10;
            n11 = ((String)object).length();
            int c102 = string2.length();
            StringBuilder stringBuilder = new StringBuilder(n11 += c102);
            for (n11 = 0; n11 < (c10 = ((String)object).length()); ++n11) {
                c10 = ((String)object).charAt(n11);
                stringBuilder.append(c10);
                c10 = string2.length();
                if (c10 <= n11) continue;
                c10 = string2.charAt(n11);
                stringBuilder.append(c10);
            }
            return stringBuilder.toString();
        }
        object = new IllegalArgumentException("Invalid input received");
        throw object;
    }

    public Task sendReport(CrashlyticsReportWithSessionId object) {
        Object object2 = ((CrashlyticsReportWithSessionId)object).getReport();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Transport transport = this.transport;
        object2 = Event.ofUrgent(object2);
        object = DataTransportCrashlyticsReportSender$$Lambda$1.lambdaFactory$(taskCompletionSource, (CrashlyticsReportWithSessionId)object);
        transport.schedule((Event)object2, (TransportScheduleCallback)object);
        return taskCompletionSource.getTask();
    }
}

