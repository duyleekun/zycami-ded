/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.perf.FirebasePerformanceAttributable;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.AppStateUpdateHandler;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.PerfMetricValidator;
import com.google.firebase.perf.internal.PerfSession;
import com.google.firebase.perf.internal.SessionAwareObject;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.Counter;
import com.google.firebase.perf.metrics.Trace$1;
import com.google.firebase.perf.metrics.Trace$2;
import com.google.firebase.perf.metrics.TraceMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Trace
extends AppStateUpdateHandler
implements Parcelable,
FirebasePerformanceAttributable,
SessionAwareObject {
    public static final Parcelable.Creator CREATOR;
    public static final Parcelable.Creator CREATOR_DATAONLY;
    private static final AndroidLogger logger;
    private static final Map sTraces;
    private final Map attributes;
    private final Clock clock;
    private final Map counters;
    private Timer endTime;
    private final GaugeManager gaugeManager;
    private final String name;
    private final Trace parent;
    private final List sessions;
    private Timer startTime;
    private final List subtraces;
    private final TransportManager transportManager;
    private final WeakReference weakReference;

    static {
        logger = AndroidLogger.getInstance();
        Object object = new ConcurrentHashMap();
        sTraces = object;
        object = new Trace$1();
        CREATOR = object;
        object = new Trace$2();
        CREATOR_DATAONLY = object;
    }

    private Trace(Parcel object, boolean bl2) {
        Object object2 = bl2 ? null : AppStateMonitor.getInstance();
        super((AppStateMonitor)object2);
        object2 = new Object(this);
        this.weakReference = object2;
        object2 = Trace.class.getClassLoader();
        object2 = (Trace)object.readParcelable((ClassLoader)object2);
        this.parent = object2;
        object2 = object.readString();
        this.name = object2;
        object2 = new Object();
        this.subtraces = object2;
        Object object3 = Trace.class.getClassLoader();
        object.readList(object2, (ClassLoader)object3);
        super();
        this.counters = object2;
        object3 = new ConcurrentHashMap();
        this.attributes = object3;
        object3 = Counter.class.getClassLoader();
        object.readMap(object2, (ClassLoader)object3);
        object2 = Timer.class.getClassLoader();
        object2 = (Timer)object.readParcelable((ClassLoader)object2);
        this.startTime = object2;
        object2 = Timer.class.getClassLoader();
        object2 = (Timer)object.readParcelable((ClassLoader)object2);
        this.endTime = object2;
        object2 = new Object();
        this.sessions = object2 = Collections.synchronizedList(object2);
        object3 = PerfSession.class.getClassLoader();
        object.readList(object2, (ClassLoader)object3);
        if (bl2) {
            this.transportManager = null;
            this.clock = null;
            this.gaugeManager = null;
        } else {
            object = TransportManager.getInstance();
            this.transportManager = object;
            super();
            this.clock = object;
            object = GaugeManager.getInstance();
            this.gaugeManager = object;
        }
    }

    public /* synthetic */ Trace(Parcel parcel, boolean bl2, Trace$1 trace$1) {
        this(parcel, bl2);
    }

    private Trace(Trace object, String list, Timer timer, Timer timer2, List list2, Map map, Map map2) {
        WeakReference<Trace> weakReference;
        this.weakReference = weakReference = new WeakReference<Trace>(this);
        this.parent = object;
        list = ((String)((Object)list)).trim();
        this.name = list;
        this.startTime = timer;
        this.endTime = timer2;
        if (list2 == null) {
        }
        this.subtraces = list2;
        if (map == null) {
            super();
        }
        this.counters = map;
        if (map2 == null) {
            super();
        }
        this.attributes = map2;
        list = ((Trace)object).clock;
        this.clock = list;
        list = ((Trace)object).transportManager;
        this.transportManager = list;
        list = new List();
        this.sessions = list = Collections.synchronizedList(list);
        this.gaugeManager = object = ((Trace)object).gaugeManager;
    }

    private Trace(String string2) {
        TransportManager transportManager = TransportManager.getInstance();
        Clock clock = new Clock();
        AppStateMonitor appStateMonitor = AppStateMonitor.getInstance();
        GaugeManager gaugeManager = GaugeManager.getInstance();
        this(string2, transportManager, clock, appStateMonitor, gaugeManager);
    }

    public Trace(String string2, TransportManager transportManager, Clock clock, AppStateMonitor appStateMonitor) {
        GaugeManager gaugeManager = GaugeManager.getInstance();
        this(string2, transportManager, clock, appStateMonitor, gaugeManager);
    }

    public Trace(String list, TransportManager transportManager, Clock clock, AppStateMonitor weakReference, GaugeManager gaugeManager) {
        super((AppStateMonitor)((Object)weakReference));
        this.weakReference = weakReference = new WeakReference<Trace>(this);
        this.parent = null;
        list = ((String)((Object)list)).trim();
        this.name = list;
        list = new List();
        this.subtraces = list;
        super();
        this.counters = list;
        super();
        this.attributes = list;
        this.clock = clock;
        this.transportManager = transportManager;
        list = new List();
        this.sessions = list = Collections.synchronizedList(list);
        this.gaugeManager = gaugeManager;
    }

    private void checkAttribute(String object, String object2) {
        int n10 = this.isStopped();
        int n11 = 1;
        if (n10 == 0) {
            int n12;
            Object object3 = this.attributes;
            n10 = object3.containsKey(object);
            if (n10 == 0 && (n10 = (object3 = this.attributes).size()) >= (n12 = 5)) {
                object2 = Locale.ENGLISH;
                object3 = new Object[n11];
                Integer n13 = n12;
                object3[0] = n13;
                object2 = String.format((Locale)object2, "Exceeds max limit of number of attributes - %d", object3);
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            object3 = new AbstractMap.SimpleEntry(object, object2);
            if ((object = PerfMetricValidator.validateAttribute(object3)) == null) {
                return;
            }
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object2 = Locale.ENGLISH;
        Object[] objectArray = new Object[n11];
        String string2 = this.name;
        objectArray[0] = string2;
        object2 = String.format((Locale)object2, "Trace '%s' has been stopped", objectArray);
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static Trace create(String string2) {
        Trace trace = new Trace(string2);
        return trace;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Trace getTrace(String string2) {
        Class<Trace> clazz = Trace.class;
        synchronized (clazz) {
            void var3_6;
            Map map = sTraces;
            Object v10 = map.get(string2);
            Trace trace = (Trace)v10;
            if (trace == null) {
                Trace trace2 = new Trace(string2);
                map.put(string2, trace2);
            }
            return var3_6;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Trace getTrace(String string2, TransportManager transportManager, Clock clock, AppStateMonitor appStateMonitor) {
        Class<Trace> clazz = Trace.class;
        synchronized (clazz) {
            void var6_9;
            Map map = sTraces;
            Object v10 = map.get(string2);
            Trace trace = (Trace)v10;
            if (trace == null) {
                void var3_3;
                void var2_2;
                void var1_1;
                GaugeManager gaugeManager = GaugeManager.getInstance();
                Trace trace2 = new Trace(string2, (TransportManager)var1_1, (Clock)var2_2, (AppStateMonitor)var3_3, gaugeManager);
                map.put(string2, trace2);
            }
            return var6_9;
        }
    }

    private Counter obtainOrCreateCounterByName(String string2) {
        Counter counter = (Counter)this.counters.get(string2);
        if (counter == null) {
            counter = new Counter(string2);
            Map map = this.counters;
            map.put(string2, counter);
        }
        return counter;
    }

    private void setEndTimeOfLastStage(Timer timer) {
        Object object = this.subtraces;
        int n10 = object.isEmpty();
        if (n10 != 0) {
            return;
        }
        n10 = this.subtraces.size() + -1;
        object = (Trace)this.subtraces.get(n10);
        Timer timer2 = ((Trace)object).endTime;
        if (timer2 == null) {
            ((Trace)object).endTime = timer;
        }
    }

    public static Trace startTrace(String object) {
        Map map = sTraces;
        if ((object = (Trace)map.get(object)) != null) {
            ((Trace)object).start();
        }
        return object;
    }

    public static Trace stopTrace(String string2) {
        Map map = sTraces;
        Trace trace = (Trace)map.get(string2);
        if (trace != null) {
            trace.stop();
            map.remove(string2);
        }
        return trace;
    }

    public int describeContents() {
        return 0;
    }

    public void finalize() {
        block9: {
            boolean bl2 = this.isActive();
            if (!bl2) break block9;
            AndroidLogger androidLogger = logger;
            String string2 = "Trace '%s' is started but not stopped when it is destructed!";
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            String string3 = this.name;
            objectArray[0] = string3;
            androidLogger.warn(string2, objectArray);
            this.incrementTsnsCount(n10);
        }
        return;
        finally {
            super.finalize();
        }
    }

    public String getAttribute(String string2) {
        return (String)this.attributes.get(string2);
    }

    public Map getAttributes() {
        Map map = this.attributes;
        HashMap hashMap = new HashMap(map);
        return hashMap;
    }

    public Map getCounters() {
        return this.counters;
    }

    public Timer getEndTime() {
        return this.endTime;
    }

    public long getLongMetric(String object) {
        if (object != null) {
            Map map = this.counters;
            object = ((String)object).trim();
            object = (Counter)map.get(object);
        } else {
            object = null;
        }
        if (object == null) {
            return 0L;
        }
        return ((Counter)object).getCount();
    }

    public String getName() {
        return this.name;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getSessions() {
        List list = this.sessions;
        synchronized (list) {
            List list2 = new List();
            Object object = this.sessions;
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                if ((object2 = (PerfSession)object2) == null) continue;
                ((ArrayList)list2).add(object2);
            }
            return Collections.unmodifiableList(list2);
        }
    }

    public Timer getStartTime() {
        return this.startTime;
    }

    public List getSubtraces() {
        return this.subtraces;
    }

    public boolean hasStarted() {
        boolean bl2;
        Timer timer = this.startTime;
        if (timer != null) {
            bl2 = true;
        } else {
            bl2 = false;
            timer = null;
        }
        return bl2;
    }

    public void incrementMetric(String object, long l10) {
        Object object2 = PerfMetricValidator.validateMetricName((String)object);
        int n10 = 1;
        int n11 = 2;
        if (object2 != null) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object;
            objectArray[n10] = object2;
            androidLogger.error("Cannot increment metric '%s'. Metric name is invalid.(%s)", objectArray);
            return;
        }
        boolean bl2 = this.hasStarted();
        if (!bl2) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object;
            objectArray[n10] = object = this.name;
            androidLogger.warn("Cannot increment metric '%s' for trace '%s' because it's not started", objectArray);
            return;
        }
        bl2 = this.isStopped();
        if (bl2) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object;
            objectArray[n10] = object = this.name;
            androidLogger.warn("Cannot increment metric '%s' for trace '%s' because it's been stopped", objectArray);
            return;
        }
        object2 = ((String)object).trim();
        object2 = this.obtainOrCreateCounterByName((String)object2);
        ((Counter)object2).increment(l10);
        AndroidLogger androidLogger = logger;
        Object[] objectArray = new Object[3];
        objectArray[0] = object;
        objectArray[n10] = object = Long.valueOf(((Counter)object2).getCount());
        objectArray[n11] = object = this.name;
        androidLogger.debug("Incrementing metric '%s' to %d on trace '%s'", objectArray);
    }

    public boolean isActive() {
        boolean bl2 = this.hasStarted();
        bl2 = bl2 && !(bl2 = this.isStopped());
        return bl2;
    }

    public boolean isStopped() {
        boolean bl2;
        Timer timer = this.endTime;
        if (timer != null) {
            bl2 = true;
        } else {
            bl2 = false;
            timer = null;
        }
        return bl2;
    }

    public void putAttribute(String string2, String string3) {
        Object object;
        int n10 = 2;
        int n11 = 3;
        int n12 = 0;
        int n13 = 1;
        string2 = string2.trim();
        string3 = string3.trim();
        this.checkAttribute(string2, string3);
        AndroidLogger androidLogger = logger;
        Object object2 = "Setting attribute '%s' to '%s' on trace '%s'";
        Object[] objectArray = new Object[n11];
        objectArray[0] = string2;
        objectArray[n13] = string3;
        String string4 = this.name;
        objectArray[n10] = string4;
        try {
            androidLogger.debug((String)object2, objectArray);
            n12 = n13;
        }
        catch (Exception exception) {
            object2 = logger;
            Object[] objectArray2 = new Object[n11];
            objectArray2[0] = string2;
            objectArray2[n13] = string3;
            String string5 = exception.getMessage();
            objectArray2[n10] = string5;
            object = "Can not set attribute '%s' with value '%s' (%s)";
            ((AndroidLogger)object2).error((String)object, objectArray2);
        }
        if (n12 != 0) {
            object = this.attributes;
            object.put(string2, string3);
        }
    }

    public void putMetric(String object, long l10) {
        Object object2 = PerfMetricValidator.validateMetricName((String)object);
        int n10 = 1;
        int n11 = 2;
        if (object2 != null) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object;
            objectArray[n10] = object2;
            androidLogger.error("Cannot set value for metric '%s'. Metric name is invalid.(%s)", objectArray);
            return;
        }
        boolean bl2 = this.hasStarted();
        if (!bl2) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object;
            objectArray[n10] = object = this.name;
            androidLogger.warn("Cannot set value for metric '%s' for trace '%s' because it's not started", objectArray);
            return;
        }
        bl2 = this.isStopped();
        if (bl2) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object;
            objectArray[n10] = object = this.name;
            androidLogger.warn("Cannot set value for metric '%s' for trace '%s' because it's been stopped", objectArray);
            return;
        }
        object2 = ((String)object).trim();
        this.obtainOrCreateCounterByName((String)object2).setCount(l10);
        object2 = logger;
        Object[] objectArray = new Object[3];
        objectArray[0] = object;
        objectArray[n10] = object = Long.valueOf(l10);
        objectArray[n11] = object = this.name;
        ((AndroidLogger)object2).debug("Setting metric '%s' to '%s' on trace '%s'", objectArray);
    }

    public void removeAttribute(String string2) {
        boolean bl2 = this.isStopped();
        if (bl2) {
            logger.error("Can't remove a attribute from a Trace that's stopped.");
            return;
        }
        this.attributes.remove(string2);
    }

    public void start() {
        Object object = ConfigResolver.getInstance();
        boolean bl2 = ((ConfigResolver)object).isPerformanceMonitoringEnabled();
        if (!bl2) {
            logger.info("Trace feature is disabled.");
            return;
        }
        object = PerfMetricValidator.validateTraceName(this.name);
        int n10 = 1;
        WeakReference weakReference = null;
        if (object != null) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[2];
            String string2 = this.name;
            objectArray[0] = string2;
            objectArray[n10] = object;
            androidLogger.error("Cannot start trace '%s'. Trace name is invalid.(%s)", objectArray);
            return;
        }
        object = this.startTime;
        if (object != null) {
            object = logger;
            Object[] objectArray = new Object[n10];
            String string3 = this.name;
            objectArray[0] = string3;
            ((AndroidLogger)object).error("Trace '%s' has already started, should not start again!", objectArray);
            return;
        }
        this.startTime = object = this.clock.getTime();
        this.registerForAppState();
        object = SessionManager.getInstance().perfSession();
        Object object2 = SessionManager.getInstance();
        weakReference = this.weakReference;
        ((SessionManager)object2).registerForSessionUpdates(weakReference);
        this.updateSession((PerfSession)object);
        n10 = (int)(((PerfSession)object).isGaugeAndEventCollectionEnabled() ? 1 : 0);
        if (n10 != 0) {
            object2 = this.gaugeManager;
            object = ((PerfSession)object).getTimer();
            ((GaugeManager)object2).collectGaugeMetricOnce((Timer)object);
        }
    }

    public void startStage(String string2) {
        Timer timer = this.clock.getTime();
        this.setEndTimeOfLastStage(timer);
        List list = this.subtraces;
        Trace trace = new Trace(this, string2, timer, null, null, null, null);
        list.add(trace);
    }

    public void stop() {
        boolean bl2 = this.hasStarted();
        Object object = null;
        int n10 = 1;
        if (!bl2) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n10];
            String string2 = this.name;
            objectArray[0] = string2;
            androidLogger.error("Trace '%s' has not been started so unable to stop!", objectArray);
            return;
        }
        bl2 = this.isStopped();
        if (bl2) {
            AndroidLogger androidLogger = logger;
            Object[] objectArray = new Object[n10];
            String string3 = this.name;
            objectArray[0] = string3;
            androidLogger.error("Trace '%s' has already stopped, should not stop again!", objectArray);
            return;
        }
        Object object2 = SessionManager.getInstance();
        object = this.weakReference;
        ((SessionManager)object2).unregisterForSessionUpdates((WeakReference)object);
        this.unregisterForAppState();
        this.endTime = object2 = this.clock.getTime();
        object = this.parent;
        if (object == null) {
            this.setEndTimeOfLastStage((Timer)object2);
            object2 = this.name;
            bl2 = ((String)object2).isEmpty();
            if (!bl2) {
                object2 = this.transportManager;
                object = new TraceMetricBuilder(this);
                object = ((TraceMetricBuilder)object).build();
                ApplicationProcessState applicationProcessState = this.getAppState();
                ((TransportManager)object2).log((TraceMetric)object, applicationProcessState);
                object2 = SessionManager.getInstance().perfSession();
                bl2 = ((PerfSession)object2).isGaugeAndEventCollectionEnabled();
                if (bl2) {
                    object2 = this.gaugeManager;
                    object = SessionManager.getInstance().perfSession().getTimer();
                    ((GaugeManager)object2).collectGaugeMetricOnce((Timer)object);
                }
            } else {
                object2 = logger;
                object = "Trace name is empty, no log is sent to server";
                ((AndroidLogger)object2).error((String)object);
            }
        }
    }

    public void stopStage() {
        Timer timer = this.clock.getTime();
        this.setEndTimeOfLastStage(timer);
    }

    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.info("Unable to add new SessionId to the Trace. Continuing without it.");
            return;
        }
        boolean bl2 = this.hasStarted();
        if (bl2 && !(bl2 = this.isStopped())) {
            List list = this.sessions;
            list.add(perfSession);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.parent;
        List list = null;
        parcel.writeParcelable((Parcelable)object, 0);
        object = this.name;
        parcel.writeString((String)object);
        object = this.subtraces;
        parcel.writeList((List)object);
        object = this.counters;
        parcel.writeMap((Map)object);
        object = this.startTime;
        parcel.writeParcelable((Parcelable)object, 0);
        object = this.endTime;
        parcel.writeParcelable((Parcelable)object, 0);
        object = this.sessions;
        synchronized (object) {
            list = this.sessions;
            parcel.writeList(list);
            return;
        }
    }
}

