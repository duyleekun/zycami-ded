/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  android.media.Image
 *  android.media.ImageReader
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.IBinder
 *  android.os.Looper
 *  android.util.Size
 *  android.view.Surface
 */
package com.zhiyun.cama.camera.liveassistant.vision;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions$Builder;
import com.zhiyun.cama.camera.liveassistant.vision.LiveAssistantService$a;
import com.zhiyun.cama.camera.liveassistant.vision.LiveAssistantService$b;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.e7.u.a;
import d.v.c.s0.e7.u.b;
import d.v.c.s0.e7.u.c;
import d.v.c.s0.e7.u.l;
import d.v.c.s0.e7.u.m;
import d.v.c.s0.e7.u.m$b;
import d.v.c.s0.e7.u.n;
import d.v.c.s0.e7.u.o;
import d.v.e.h.d;
import d.v.e0.ce;
import d.v.f.f.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LiveAssistantService
extends Service {
    public static String l = "extra_notification";
    public static String m = "extra_notification_id";
    public static String n = "extra_screen_capture_result_code";
    public static String o = "extra_screen_capture_result_data";
    private static final int p = 5;
    private static final long q = 3000L;
    private static final int r = 50;
    private e a;
    private Handler b;
    private HandlerThread c;
    private m d;
    private l e;
    private long f;
    private FaceDetector g;
    private volatile boolean h;
    private n i;
    private long j;
    private final o k;

    public LiveAssistantService() {
        o o10;
        this.k = o10 = new o();
    }

    private List a(Rect rect, List object) {
        int n10 = object.size();
        ArrayList<n> arrayList = new ArrayList<n>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Face face = (Face)object.next();
            Integer n11 = face.getTrackingId();
            int n12 = -1;
            int n13 = d.v.e.h.d.d(n11, n12);
            face = face.getBoundingBox();
            n n14 = new n(n13, (Rect)face, rect);
            arrayList.add(n14);
        }
        return arrayList;
    }

    private FaceDetector b() {
        FaceDetectorOptions$Builder faceDetectorOptions$Builder = new FaceDetectorOptions$Builder();
        int n10 = 1;
        return FaceDetection.getClient(faceDetectorOptions$Builder.setLandmarkMode(n10).setPerformanceMode(n10).enableTracking().build());
    }

    private void c(InputImage object) {
        object = this.g.process((InputImage)object);
        Object object2 = new b(this);
        object = ((Task)object).addOnSuccessListener((OnSuccessListener)object2);
        object2 = new c(this);
        ((Task)object).addOnFailureListener((OnFailureListener)object2);
        this.h = false;
    }

    private float d(float f10, float f11) {
        return (f10 - f11) / f10;
    }

    private n e(List object) {
        Object object2;
        n n10 = this.i;
        n10 = n10 == null ? this.g() : n10.c();
        object = this.a((Rect)n10, (List)object);
        boolean bl2 = object.isEmpty();
        boolean bl3 = false;
        float f10 = 0.0f;
        if (!bl2) {
            Collections.sort(object);
            object = (n)object.get(0);
        } else {
            object2 = 0;
            object = null;
        }
        n10 = this.i;
        if (n10 == null) {
            this.i = object;
            return object;
        }
        bl2 = true;
        float f11 = Float.MIN_VALUE;
        if (object != null) {
            int n11;
            int n12 = ((n)object).d();
            if (n12 >= (n11 = 50)) {
                bl3 = bl2;
                f10 = f11;
            }
            bl2 = bl3;
            f11 = f10;
        }
        long l10 = 0L;
        if (bl2) {
            long l11 = this.j;
            long l12 = l11 - l10;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == 0) {
                this.j = l11 = System.currentTimeMillis();
            }
            l11 = System.currentTimeMillis();
            l10 = this.j;
            long l13 = (l11 -= l10) - (l10 = 3000L);
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 >= 0) {
                this.i = null;
            }
            return null;
        }
        this.j = l10;
        this.i = object;
        return object;
    }

    private int f() {
        int n10 = Windows.j((Context)this);
        int n11 = this.a.a();
        return (n10 + n11) % 4 * 90 % 360;
    }

    private Rect g() {
        Size size = this.d.e();
        boolean bl2 = this.i();
        if (bl2) {
            int n10 = size.getWidth();
            int n11 = size.getHeight();
            Rect rect = new Rect(0, 0, n10, n11);
            return rect;
        }
        int n12 = size.getHeight();
        int n13 = size.getWidth();
        Rect rect = new Rect(0, 0, n12, n13);
        return rect;
    }

    private boolean i() {
        int n10;
        e e10 = this.a;
        int n11 = e10.a();
        return n11 == 0 || n11 == (n10 = 2);
    }

    private /* synthetic */ void j(List object) {
        this.h = false;
        object = this.e((List)object);
        this.z((n)object);
    }

    private /* synthetic */ void l(Exception exception) {
        this.h = false;
    }

    private /* synthetic */ void n(ImageReader object) {
        int n10 = this.h();
        if (n10 != 0) {
            return;
        }
        if ((object = object.acquireNextImage()) == null) {
            return;
        }
        if ((object = d.v.c.s0.e7.u.l.f((Image)object)) == null) {
            return;
        }
        n10 = this.f();
        object = InputImage.fromBitmap((Bitmap)object, n10);
        this.c((InputImage)object);
    }

    private void p(Rect rect) {
        Rect rect2 = this.g();
        float f10 = rect2.exactCenterX();
        float f11 = rect.exactCenterX();
        f10 = this.d(f10, f11);
        float f12 = rect2.exactCenterY();
        float f13 = rect.exactCenterY();
        f13 = this.d(f12, f13);
        int n10 = this.i();
        if (n10 != 0) {
            n10 = -1082130432;
            f12 = -1.0f;
            f13 *= f12;
        }
        this.k.p(f10, f13);
    }

    private l q(Size object) {
        object = d.v.c.s0.e7.u.l.d((Size)object);
        a a10 = new a(this);
        Handler handler = this.b;
        ((l)object).e(a10, handler);
        return object;
    }

    private void r(long l10) {
        long l11 = System.currentTimeMillis() - l10;
        this.f = l10 = Math.max(this.f, l11);
        int n10 = 1;
        Object object = new Object[n10];
        Long l12 = l11;
        object[0] = l12;
        m.a.a.i("\u6d88\u8017\u65f6\u95f4: %d", object);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object = Long.valueOf(this.f);
        m.a.a.b("\u6700\u5927\u6d88\u8017\u65f6\u95f4: %d", objectArray);
    }

    private void s() {
        l l10;
        Size size = this.d.f();
        this.e = l10 = this.q(size);
        size = l10.b(size);
        this.d.p((Surface)size);
    }

    private void u() {
        HandlerThread handlerThread;
        this.c = handlerThread = new HandlerThread("MediaProjectionThread");
        handlerThread.start();
        Looper looper = this.c.getLooper();
        handlerThread = new Handler(looper);
        this.b = handlerThread;
    }

    private void v(Intent intent) {
        this.a.enable();
        Object object = this.d;
        boolean n10 = ((m)object).i();
        if (n10) {
            this.s();
            return;
        }
        object = n;
        int n11 = intent.getIntExtra((String)object, 0);
        Object object2 = o;
        intent = (Intent)intent.getParcelableExtra((String)object2);
        if (n11 != 0 && intent != null) {
            object2 = this.d;
            ((m)object2).j(n11, intent);
            this.s();
        }
    }

    private void w(Intent objectArray) {
        int n10 = 0;
        if (objectArray == null) {
            objectArray = new Object[]{};
            m.a.a.x("Screen capture service intent is null. ", objectArray);
            return;
        }
        String string2 = l;
        if ((string2 = (Notification)objectArray.getParcelableExtra(string2)) == null) {
            objectArray = new Object[]{};
            m.a.a.x("Screen capture foreground service can not started, notification is null. ", objectArray);
            return;
        }
        String string3 = m;
        int n11 = objectArray.getIntExtra(string3, 0);
        n10 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n10 >= n12) {
            n10 = 32;
            this.startForeground(n11, (Notification)string2, n10);
        } else {
            this.startForeground(n11, (Notification)string2);
        }
    }

    private void x() {
        this.c.quit();
    }

    private void y() {
        this.a.disable();
        this.d.q();
        this.e.a();
        FaceDetector faceDetector = this.g;
        if (faceDetector != null) {
            faceDetector.close();
        }
    }

    private void z(n object) {
        if (object == null) {
            object = this.k;
            ((o)object).p(0.0f, 0.0f);
        } else {
            object = ((n)object).c();
            this.p((Rect)object);
        }
    }

    public boolean h() {
        synchronized (this) {
            boolean bl2 = this.h;
            return bl2;
        }
    }

    public /* synthetic */ void k(List list) {
        this.j(list);
    }

    public /* synthetic */ void m(Exception exception) {
        this.l(exception);
    }

    public /* synthetic */ void o(ImageReader imageReader) {
        this.n(imageReader);
    }

    public IBinder onBind(Intent object) {
        object = new LiveAssistantService$b(this);
        return object;
    }

    public void onConfigurationChanged(Configuration object) {
        object = this.e;
        if (object != null) {
            object = this.d.f();
            object = this.e.b((Size)object);
            m m10 = this.d;
            m10.m((Surface)object);
        }
        this.i = null;
    }

    public void onCreate() {
        super.onCreate();
        Object object = new m((Context)this, 5);
        this.d = object;
        this.g = object = this.b();
        object = new LiveAssistantService$a(this, (Context)this);
        this.a = object;
    }

    public void onDestroy() {
        this.k.r();
        this.y();
        this.x();
        ce.E0().c0();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int n10, int n11) {
        this.w(intent);
        this.u();
        this.v(intent);
        ce.E0().R();
        this.k.q();
        return 1;
    }

    public void t(m.b b10) {
        this.d.n(b10);
    }
}

