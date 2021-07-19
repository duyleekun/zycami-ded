/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzn;
import com.google.android.gms.internal.measurement.zzp;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzw;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzy;
import java.util.HashMap;

public abstract class zzo
extends zzb
implements zzp {
    public zzo() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzp asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        boolean bl2 = iInterface instanceof zzp;
        if (bl2) {
            return (zzp)iInterface;
        }
        iInterface = new zzn(iBinder);
        return iInterface;
    }

    public final boolean zza(int n10, Parcel parcel, Parcel parcel2, int n11) {
        Object object = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy";
        Object object2 = "com.google.android.gms.measurement.api.internal.IBundleReceiver";
        boolean bl2 = false;
        Object object3 = null;
        switch (n10) {
            default: {
                return false;
            }
            case 45: {
                object = Bundle.CREATOR;
                object = (Bundle)zzc.zzc(parcel, (Parcelable.Creator)object);
                long l10 = parcel.readLong();
                this.setConsentThirdParty((Bundle)object, l10);
                break;
            }
            case 44: {
                object = Bundle.CREATOR;
                object = (Bundle)zzc.zzc(parcel, (Parcelable.Creator)object);
                long l11 = parcel.readLong();
                this.setConsent((Bundle)object, l11);
                break;
            }
            case 43: {
                long l12 = parcel.readLong();
                this.clearMeasurementEnabled(l12);
                break;
            }
            case 42: {
                object = Bundle.CREATOR;
                Bundle bundle = (Bundle)zzc.zzc(parcel, (Parcelable.Creator)object);
                this.setDefaultEventParameters(bundle);
                break;
            }
            case 40: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    object = iBinder.queryLocalInterface((String)object2);
                    boolean bl3 = object instanceof zzs;
                    if (bl3) {
                        object3 = object;
                        object3 = (zzs)object;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.isDataCollectionEnabled((zzs)object3);
                break;
            }
            case 39: {
                boolean bl4 = zzc.zza(parcel);
                this.setDataCollectionEnabled(bl4);
                break;
            }
            case 38: {
                object = parcel.readStrongBinder();
                if (object != null) {
                    bl2 = (object2 = object.queryLocalInterface((String)object2)) instanceof zzs;
                    if (bl2) {
                        object3 = object2;
                        object3 = (zzs)object2;
                    } else {
                        object3 = new zzq((IBinder)object);
                    }
                }
                int n12 = parcel.readInt();
                this.getTestFlag((zzs)object3, n12);
                break;
            }
            case 37: {
                HashMap hashMap = zzc.zzf(parcel);
                this.initForTests(hashMap);
                break;
            }
            case 36: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    boolean bl5 = (object = iBinder.queryLocalInterface((String)object)) instanceof zzv;
                    if (bl5) {
                        object3 = object;
                        object3 = (zzv)object;
                    } else {
                        object3 = new zzt(iBinder);
                    }
                }
                this.unregisterOnMeasurementEventListener((zzv)object3);
                break;
            }
            case 35: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    boolean bl6 = (object = iBinder.queryLocalInterface((String)object)) instanceof zzv;
                    if (bl6) {
                        object3 = object;
                        object3 = (zzv)object;
                    } else {
                        object3 = new zzt(iBinder);
                    }
                }
                this.registerOnMeasurementEventListener((zzv)object3);
                break;
            }
            case 34: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    boolean bl7 = (object = iBinder.queryLocalInterface((String)object)) instanceof zzv;
                    if (bl7) {
                        object3 = object;
                        object3 = (zzv)object;
                    } else {
                        object3 = new zzt(iBinder);
                    }
                }
                this.setEventInterceptor((zzv)object3);
                break;
            }
            case 33: {
                int n13 = parcel.readInt();
                object2 = parcel.readString();
                object3 = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapper = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapper2 = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                zzo zzo2 = this;
                this.logHealthData(n13, (String)object2, (IObjectWrapper)object3, iObjectWrapper, iObjectWrapper2);
                break;
            }
            case 32: {
                object = Bundle.CREATOR;
                object = (Bundle)zzc.zzc(parcel, (Parcelable.Creator)object);
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    bl2 = (object2 = iBinder.queryLocalInterface((String)object2)) instanceof zzs;
                    if (bl2) {
                        object3 = object2;
                        object3 = (zzs)object2;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                long l13 = parcel.readLong();
                this.performAction((Bundle)object, (zzs)object3, l13);
                break;
            }
            case 31: {
                object = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    bl2 = (object2 = iBinder.queryLocalInterface((String)object2)) instanceof zzs;
                    if (bl2) {
                        object3 = object2;
                        object3 = (zzs)object2;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                long l14 = parcel.readLong();
                this.onActivitySaveInstanceState((IObjectWrapper)object, (zzs)object3, l14);
                break;
            }
            case 30: {
                object = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                long l15 = parcel.readLong();
                this.onActivityResumed((IObjectWrapper)object, l15);
                break;
            }
            case 29: {
                object = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                long l16 = parcel.readLong();
                this.onActivityPaused((IObjectWrapper)object, l16);
                break;
            }
            case 28: {
                object = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                long l17 = parcel.readLong();
                this.onActivityDestroyed((IObjectWrapper)object, l17);
                break;
            }
            case 27: {
                object = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                object2 = Bundle.CREATOR;
                object2 = (Bundle)zzc.zzc(parcel, (Parcelable.Creator)object2);
                long l18 = parcel.readLong();
                this.onActivityCreated((IObjectWrapper)object, (Bundle)object2, l18);
                break;
            }
            case 26: {
                object = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                long l19 = parcel.readLong();
                this.onActivityStopped((IObjectWrapper)object, l19);
                break;
            }
            case 25: {
                object = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                long l20 = parcel.readLong();
                this.onActivityStarted((IObjectWrapper)object, l20);
                break;
            }
            case 24: {
                object = parcel.readString();
                long l21 = parcel.readLong();
                this.endAdUnitExposure((String)object, l21);
                break;
            }
            case 23: {
                object = parcel.readString();
                long l22 = parcel.readLong();
                this.beginAdUnitExposure((String)object, l22);
                break;
            }
            case 22: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    object = iBinder.queryLocalInterface((String)object2);
                    boolean bl8 = object instanceof zzs;
                    if (bl8) {
                        object3 = object;
                        object3 = (zzs)object;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.generateEventId((zzs)object3);
                break;
            }
            case 21: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    object = iBinder.queryLocalInterface((String)object2);
                    boolean bl9 = object instanceof zzs;
                    if (bl9) {
                        object3 = object;
                        object3 = (zzs)object;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.getGmpAppId((zzs)object3);
                break;
            }
            case 20: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    object = iBinder.queryLocalInterface((String)object2);
                    boolean bl10 = object instanceof zzs;
                    if (bl10) {
                        object3 = object;
                        object3 = (zzs)object;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.getAppInstanceId((zzs)object3);
                break;
            }
            case 19: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    object = iBinder.queryLocalInterface((String)object2);
                    boolean bl11 = object instanceof zzs;
                    if (bl11) {
                        object3 = object;
                        object3 = (zzs)object;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.getCachedAppInstanceId((zzs)object3);
                break;
            }
            case 18: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    object = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    boolean bl12 = object instanceof zzx;
                    if (bl12) {
                        object3 = object;
                        object3 = (zzx)object;
                    } else {
                        object3 = new zzw(iBinder);
                    }
                }
                this.setInstanceIdProvider((zzx)object3);
                break;
            }
            case 17: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    object = iBinder.queryLocalInterface((String)object2);
                    boolean bl13 = object instanceof zzs;
                    if (bl13) {
                        object3 = object;
                        object3 = (zzs)object;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.getCurrentScreenClass((zzs)object3);
                break;
            }
            case 16: {
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    object = iBinder.queryLocalInterface((String)object2);
                    boolean bl14 = object instanceof zzs;
                    if (bl14) {
                        object3 = object;
                        object3 = (zzs)object;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.getCurrentScreenName((zzs)object3);
                break;
            }
            case 15: {
                object = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                object2 = parcel.readString();
                object3 = parcel.readString();
                long l23 = parcel.readLong();
                zzo zzo3 = this;
                this.setCurrentScreen((IObjectWrapper)object, (String)object2, (String)object3, l23);
                break;
            }
            case 14: {
                long l24 = parcel.readLong();
                this.setSessionTimeoutDuration(l24);
                break;
            }
            case 13: {
                long l25 = parcel.readLong();
                this.setMinimumSessionDuration(l25);
                break;
            }
            case 12: {
                long l26 = parcel.readLong();
                this.resetAnalyticsData(l26);
                break;
            }
            case 11: {
                boolean bl15 = zzc.zza(parcel);
                long l27 = parcel.readLong();
                this.setMeasurementEnabled(bl15, l27);
                break;
            }
            case 10: {
                object = parcel.readString();
                String string2 = parcel.readString();
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    bl2 = (object2 = iBinder.queryLocalInterface((String)object2)) instanceof zzs;
                    if (bl2) {
                        object3 = object2;
                        object3 = (zzs)object2;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.getConditionalUserProperties((String)object, string2, (zzs)object3);
                break;
            }
            case 9: {
                object = parcel.readString();
                object2 = parcel.readString();
                object3 = Bundle.CREATOR;
                Bundle bundle = (Bundle)zzc.zzc(parcel, object3);
                this.clearConditionalUserProperty((String)object, (String)object2, bundle);
                break;
            }
            case 8: {
                object = Bundle.CREATOR;
                object = (Bundle)zzc.zzc(parcel, (Parcelable.Creator)object);
                long l28 = parcel.readLong();
                this.setConditionalUserProperty((Bundle)object, l28);
                break;
            }
            case 7: {
                object = parcel.readString();
                long l29 = parcel.readLong();
                this.setUserId((String)object, l29);
                break;
            }
            case 6: {
                object = parcel.readString();
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    bl2 = (object2 = iBinder.queryLocalInterface((String)object2)) instanceof zzs;
                    if (bl2) {
                        object3 = object2;
                        object3 = (zzs)object2;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.getMaxUserProperties((String)object, (zzs)object3);
                break;
            }
            case 5: {
                object = parcel.readString();
                String string3 = parcel.readString();
                boolean bl16 = zzc.zza(parcel);
                IBinder iBinder = parcel.readStrongBinder();
                if (iBinder != null) {
                    bl2 = (object2 = iBinder.queryLocalInterface((String)object2)) instanceof zzs;
                    if (bl2) {
                        object3 = object2;
                        object3 = (zzs)object2;
                    } else {
                        object3 = new zzq(iBinder);
                    }
                }
                this.getUserProperties((String)object, string3, bl16, (zzs)object3);
                break;
            }
            case 4: {
                object = parcel.readString();
                object2 = parcel.readString();
                object3 = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                boolean bl17 = zzc.zza(parcel);
                long l30 = parcel.readLong();
                zzo zzo4 = this;
                this.setUserProperty((String)object, (String)object2, (IObjectWrapper)object3, bl17, l30);
                break;
            }
            case 3: {
                object = parcel.readString();
                String string4 = parcel.readString();
                Parcelable.Creator creator = Bundle.CREATOR;
                creator = (Bundle)zzc.zzc(parcel, creator);
                Object object4 = parcel.readStrongBinder();
                if (object4 == null) {
                    object4 = null;
                } else {
                    bl2 = (object2 = object4.queryLocalInterface((String)object2)) instanceof zzs;
                    object2 = bl2 ? (zzs)object2 : new zzq((IBinder)object4);
                    object4 = object2;
                }
                long l31 = parcel.readLong();
                zzo zzo5 = this;
                object2 = string4;
                object3 = creator;
                string4 = object4;
                long l32 = l31;
                this.logEventAndBundle((String)object, (String)object2, (Bundle)creator, (zzs)object4, l31);
                break;
            }
            case 2: {
                object = parcel.readString();
                object2 = parcel.readString();
                object3 = Bundle.CREATOR;
                object3 = (Bundle)zzc.zzc(parcel, object3);
                boolean bl18 = zzc.zza(parcel);
                boolean bl19 = zzc.zza(parcel);
                long l33 = parcel.readLong();
                zzo zzo6 = this;
                this.logEvent((String)object, (String)object2, (Bundle)object3, bl18, bl19, l33);
                break;
            }
            case 1: {
                object = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                object2 = zzy.CREATOR;
                object2 = (zzy)zzc.zzc(parcel, (Parcelable.Creator)object2);
                long l34 = parcel.readLong();
                this.initialize((IObjectWrapper)object, (zzy)object2, l34);
            }
        }
        parcel2.writeNoException();
        return true;
    }
}

