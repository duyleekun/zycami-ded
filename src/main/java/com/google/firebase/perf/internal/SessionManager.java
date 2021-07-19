/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.internal;

import com.google.firebase.perf.internal.AppStateMonitor;
import com.google.firebase.perf.internal.AppStateUpdateHandler;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.PerfSession;
import com.google.firebase.perf.internal.SessionAwareObject;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SessionManager
extends AppStateUpdateHandler {
    private static final SessionManager ourInstance;
    private final AppStateMonitor appStateMonitor;
    private final Set clients;
    private final GaugeManager gaugeManager;
    private PerfSession perfSession;

    static {
        SessionManager sessionManager;
        ourInstance = sessionManager = new SessionManager();
    }

    private SessionManager() {
        GaugeManager gaugeManager = GaugeManager.getInstance();
        PerfSession perfSession = PerfSession.create();
        AppStateMonitor appStateMonitor = AppStateMonitor.getInstance();
        this(gaugeManager, perfSession, appStateMonitor);
    }

    public SessionManager(GaugeManager gaugeManager, PerfSession perfSession, AppStateMonitor appStateMonitor) {
        HashSet hashSet;
        this.clients = hashSet = new HashSet();
        this.gaugeManager = gaugeManager;
        this.perfSession = perfSession;
        this.appStateMonitor = appStateMonitor;
        this.registerForAppState();
    }

    public static SessionManager getInstance() {
        return ourInstance;
    }

    private void logGaugeMetadataIfCollectionEnabled(ApplicationProcessState applicationProcessState) {
        Object object = this.perfSession;
        boolean bl2 = ((PerfSession)object).isGaugeAndEventCollectionEnabled();
        if (bl2) {
            object = this.gaugeManager;
            String string2 = this.perfSession.sessionId();
            ((GaugeManager)object).logGaugeMetadata(string2, applicationProcessState);
        }
    }

    private void startOrStopCollectingGauges(ApplicationProcessState object) {
        Object object2 = this.perfSession;
        boolean bl2 = ((PerfSession)object2).isGaugeAndEventCollectionEnabled();
        if (bl2) {
            object2 = this.gaugeManager;
            PerfSession perfSession = this.perfSession;
            ((GaugeManager)object2).startCollectingGauges(perfSession, (ApplicationProcessState)object);
        } else {
            object = this.gaugeManager;
            ((GaugeManager)object).stopCollectingGauges();
        }
    }

    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        super.onUpdateAppState(applicationProcessState);
        Object object = this.appStateMonitor;
        boolean bl2 = ((AppStateMonitor)object).isColdStart();
        if (bl2) {
            return;
        }
        object = ApplicationProcessState.FOREGROUND;
        if (applicationProcessState == object) {
            this.updatePerfSession(applicationProcessState);
        } else {
            bl2 = this.updatePerfSessionIfExpired();
            if (!bl2) {
                this.startOrStopCollectingGauges(applicationProcessState);
            }
        }
    }

    public final PerfSession perfSession() {
        return this.perfSession;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerForSessionUpdates(WeakReference weakReference) {
        Set set = this.clients;
        synchronized (set) {
            Set set2 = this.clients;
            set2.add(weakReference);
            return;
        }
    }

    public void setPerfSession(PerfSession perfSession) {
        this.perfSession = perfSession;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterForSessionUpdates(WeakReference weakReference) {
        Set set = this.clients;
        synchronized (set) {
            Set set2 = this.clients;
            set2.remove(weakReference);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void updatePerfSession(ApplicationProcessState applicationProcessState) {
        Set set = this.clients;
        synchronized (set) {
            Iterator iterator2 = PerfSession.create();
            this.perfSession = iterator2;
            iterator2 = this.clients;
            iterator2 = iterator2.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = iterator2.hasNext())) {
                    // MONITOREXIT @DISABLED, blocks:[2, 3, 5] lbl9 : MonitorExitStatement: MONITOREXIT : var2_2
                    this.logGaugeMetadataIfCollectionEnabled(applicationProcessState);
                    this.startOrStopCollectingGauges(applicationProcessState);
                    return;
                }
                Object object = iterator2.next();
                object = (WeakReference)object;
                object = ((Reference)object).get();
                if ((object = (SessionAwareObject)object) != null) {
                    PerfSession perfSession = this.perfSession;
                    object.updateSession(perfSession);
                    continue;
                }
                iterator2.remove();
            }
        }
    }

    public boolean updatePerfSessionIfExpired() {
        Object object = this.perfSession;
        boolean bl2 = ((PerfSession)object).isExpired();
        if (bl2) {
            object = this.appStateMonitor.getAppState();
            this.updatePerfSession((ApplicationProcessState)object);
            return true;
        }
        return false;
    }
}

