/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.common.internal;

import androidx.lifecycle.LifecycleObserver;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.ModelResource;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.zza;
import com.google.mlkit.vision.common.internal.zzb;
import com.google.mlkit.vision.common.internal.zzc;
import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class MobileVisionBase
implements LifecycleObserver,
Closeable {
    private static final GmsLogger zza;
    private final AtomicBoolean zzb;
    private final MLTask zzc;
    private final CancellationTokenSource zzd;
    private final Executor zze;

    static {
        GmsLogger gmsLogger;
        zza = gmsLogger = new GmsLogger("MobileVisionBase", "");
    }

    public MobileVisionBase(MLTask object, Executor object2) {
        Object object3 = new AtomicBoolean(false);
        this.zzb = object3;
        this.zzc = object;
        this.zzd = object3 = new CancellationTokenSource();
        this.zze = object2;
        ((ModelResource)object).pin();
        Callable callable = com.google.mlkit.vision.common.internal.zzb.zza;
        object3 = ((CancellationTokenSource)object3).getToken();
        object = ((ModelResource)object).callAfterLoad((Executor)object2, callable, (CancellationToken)object3);
        object2 = com.google.mlkit.vision.common.internal.zza.zza;
        ((Task)object).addOnFailureListener((OnFailureListener)object2);
    }

    public static final /* synthetic */ Object zza() {
        return null;
    }

    public static final /* synthetic */ void zza(Exception exception) {
        zza.e("MobileVisionBase", "Error preloading model resource", exception);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        synchronized (this) {
            Object object = this.zzb;
            boolean bl2 = true;
            boolean bl3 = ((AtomicBoolean)object).getAndSet(bl2);
            if (!bl3) {
                object = this.zzd;
                ((CancellationTokenSource)object).cancel();
                object = this.zzc;
                Executor executor = this.zze;
                ((ModelResource)object).unpin(executor);
            }
            return;
        }
    }

    public Task processBase(InputImage object) {
        synchronized (this) {
            int n10;
            Object object2;
            block18: {
                block17: {
                    object2 = "InputImage can not be null";
                    Preconditions.checkNotNull(object, object2);
                    object2 = this.zzb;
                    boolean n11 = ((AtomicBoolean)object2).get();
                    if (!n11) break block17;
                    object2 = "This detector is already closed!";
                    int n12 = 14;
                    object = new MlKitException((String)object2, n12);
                    object = Tasks.forException((Exception)object);
                    return object;
                }
                int n13 = ((InputImage)object).getWidth();
                n10 = 32;
                if (n13 < n10) break block18;
                int n14 = ((InputImage)object).getHeight();
                if (n14 < n10) break block18;
                object2 = this.zzc;
                Executor executor = this.zze;
                zzc zzc2 = new zzc(this, (InputImage)object);
                object = this.zzd;
                object = ((CancellationTokenSource)object).getToken();
                object = ((ModelResource)object2).callAfterLoad(executor, zzc2, (CancellationToken)object);
                return object;
            }
            object2 = "InputImage width and height should be at least 32!";
            n10 = 3;
            object = new MlKitException((String)object2, n10);
            object = Tasks.forException((Exception)object);
            return object;
            finally {
            }
        }
    }

    public final /* synthetic */ Object zza(InputImage inputImage) {
        return this.zzc.run(inputImage);
    }
}

