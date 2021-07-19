/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.e;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraSelector$Builder;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$Builder;
import androidx.camera.core.ImageCapture$OutputFileOptions;
import androidx.camera.core.ImageCapture$OutputFileOptions$Builder;
import androidx.camera.core.Preview;
import androidx.camera.core.Preview$Builder;
import androidx.camera.core.Preview$SurfaceProvider;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$Result;
import androidx.camera.core.UseCase;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import d.v.d.g.e.a;
import d.v.d.g.e.b;
import d.v.d.g.e.c;
import d.v.d.g.e.d;
import d.v.d.g.e.e$a;
import d.v.d.h.f;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class e {
    private Context a;
    private ListenableFuture b;
    private LifecycleOwner c;
    private Preview d;
    private CameraSelector e;
    private ImageCapture f;
    private Executor g;
    private int h = 1;
    private PreviewView i;

    public e(Context object) {
        this.a = object;
        object = (LifecycleOwner)object;
        this.c = object;
        this.i.getController();
    }

    /*
     * WARNING - void declaration
     */
    private ProcessCameraProvider b() {
        void var1_4;
        ListenableFuture listenableFuture = this.b;
        listenableFuture = listenableFuture.get();
        try {
            return (ProcessCameraProvider)((Object)listenableFuture);
        }
        catch (InterruptedException interruptedException) {
        }
        catch (ExecutionException executionException) {
            // empty catch block
        }
        var1_4.printStackTrace();
        return null;
    }

    public static /* synthetic */ void c(SurfaceRequest$Result surfaceRequest$Result) {
        d.v.d.h.f.a(surfaceRequest$Result.toString());
    }

    private /* synthetic */ void d(SurfaceTexture object, SurfaceRequest surfaceRequest) {
        Size size = surfaceRequest.getResolution();
        int n10 = size.getWidth();
        int n11 = size.getHeight();
        object.setDefaultBufferSize(n10, n11);
        size = new Surface(object);
        object = this.g;
        d d10 = d.v.d.g.e.d.a;
        surfaceRequest.provideSurface((Surface)size, (Executor)object, d10);
    }

    private /* synthetic */ Thread f(Runnable object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("Camera");
        int n10 = this.h;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        this.h = n10 = this.h + 1;
        Thread thread = new Thread((String)object);
        return thread;
    }

    private /* synthetic */ void h(SurfaceTexture surfaceTexture) {
        Object object = new Preview$Builder();
        int n10 = 720;
        int n11 = 1280;
        Size size = new Size(n10, n11);
        this.d = object = ((Preview$Builder)object).setTargetResolution(size).build();
        object = new CameraSelector$Builder();
        size = null;
        this.e = object = ((CameraSelector$Builder)object).requireLensFacing(0).build();
        object = new ImageCapture$Builder();
        this.f = object = ((ImageCapture$Builder)object).build();
        object = this.b();
        if (object == null) {
            d.v.d.h.f.a("cameraProvider is  null");
            return;
        }
        ((ProcessCameraProvider)object).unbindAll();
        LifecycleOwner lifecycleOwner = this.c;
        CameraSelector cameraSelector = this.e;
        UseCase[] useCaseArray = new UseCase[2];
        UseCase useCase = this.d;
        useCaseArray[0] = useCase;
        useCase = this.f;
        useCaseArray[1] = useCase;
        ((ProcessCameraProvider)object).bindToLifecycle(lifecycleOwner, cameraSelector, useCaseArray);
        object = new a(this, surfaceTexture);
        this.d.setSurfaceProvider((Preview$SurfaceProvider)object);
    }

    public void a() {
    }

    public /* synthetic */ void e(SurfaceTexture surfaceTexture, SurfaceRequest surfaceRequest) {
        this.d(surfaceTexture, surfaceRequest);
    }

    public /* synthetic */ Thread g(Runnable runnable) {
        return this.f(runnable);
    }

    public /* synthetic */ void i(SurfaceTexture surfaceTexture) {
        this.h(surfaceTexture);
    }

    public void j() {
        ThreadPoolExecutor threadPoolExecutor;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingDeque<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<Runnable>(200);
        b b10 = new b(this);
        Executor executor = threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(2, 4, (long)10, timeUnit, linkedBlockingDeque, b10);
        this.g = threadPoolExecutor;
        executor = ContextCompat.getMainExecutor(this.a);
        this.g = executor;
    }

    public void k(SurfaceTexture object) {
        ListenableFuture listenableFuture;
        this.b = listenableFuture = ProcessCameraProvider.getInstance(this.a);
        c c10 = new c(this, (SurfaceTexture)object);
        object = this.g;
        listenableFuture.addListener(c10, (Executor)object);
    }

    public void l() {
    }

    public void m() {
    }

    public void n(String object) {
        Object object2 = this.f;
        if (object2 != null) {
            d.v.d.h.f.a("The savePath is null ,return!");
            return;
        }
        Object object3 = new File((String)object);
        object2 = new ImageCapture$OutputFileOptions$Builder((File)object3);
        object = ((ImageCapture$OutputFileOptions$Builder)object2).build();
        object2 = this.f;
        object3 = ContextCompat.getMainExecutor(this.a);
        e$a e$a = new e$a(this);
        ((ImageCapture)object2).takePicture((ImageCapture$OutputFileOptions)object, (Executor)object3, e$a);
    }
}

