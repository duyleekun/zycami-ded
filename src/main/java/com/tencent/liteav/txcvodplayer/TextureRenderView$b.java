/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.TextureView$SurfaceTextureListener
 */
package com.tencent.liteav.txcvodplayer;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.tencent.ijk.media.player.ISurfaceTextureHost;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.TextureRenderView$a;
import com.tencent.liteav.txcvodplayer.a$a;
import com.tencent.liteav.txcvodplayer.a$b;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class TextureRenderView$b
implements TextureView.SurfaceTextureListener,
ISurfaceTextureHost {
    private SurfaceTexture a;
    private boolean b;
    private int c;
    private int d;
    private boolean e = true;
    private boolean f = false;
    private boolean g = false;
    private WeakReference h;
    private Map i;

    public TextureRenderView$b(TextureRenderView textureRenderView) {
        WeakReference<TextureRenderView> weakReference = new WeakReference<TextureRenderView>();
        this.i = weakReference;
        this.h = weakReference = new WeakReference<TextureRenderView>(textureRenderView);
    }

    public static /* synthetic */ SurfaceTexture a(TextureRenderView$b textureRenderView$b) {
        return textureRenderView$b.a;
    }

    public void a() {
        TXCLog.i("TextureRenderView", "willDetachFromWindow()");
        this.f = true;
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.a = surfaceTexture;
    }

    public void a(a$a a$a) {
        int n10;
        int n11;
        SurfaceTexture surfaceTexture;
        TextureRenderView textureRenderView;
        this.i.put(a$a, a$a);
        Object object = this.a;
        if (object != null) {
            textureRenderView = (TextureRenderView)this.h.get();
            surfaceTexture = this.a;
            object = new TextureRenderView$a(textureRenderView, surfaceTexture, this);
            n11 = this.c;
            n10 = this.d;
            a$a.a((a$b)object, n11, n10);
        } else {
            object = null;
        }
        n11 = this.b;
        if (n11 != 0) {
            if (object == null) {
                textureRenderView = (TextureRenderView)this.h.get();
                surfaceTexture = this.a;
                object = new TextureRenderView$a(textureRenderView, surfaceTexture, this);
            }
            n11 = 0;
            textureRenderView = null;
            n10 = this.c;
            int n12 = this.d;
            a$a.a((a$b)object, 0, n10, n12);
        }
    }

    public void a(boolean bl2) {
        this.e = bl2;
    }

    public void b() {
        TXCLog.i("TextureRenderView", "didDetachFromWindow()");
        this.g = true;
    }

    public void b(a$a a$a) {
        this.i.remove(a$a);
    }

    public void c() {
        TXCLog.i("TextureRenderView", "onAttachFromWindow()");
        this.f = false;
        this.g = false;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture object, int n10, int n11) {
        boolean bl2;
        this.a = object;
        this.b = false;
        this.c = 0;
        this.d = 0;
        Object object2 = (TextureRenderView)this.h.get();
        TextureRenderView$a textureRenderView$a = new TextureRenderView$a((TextureRenderView)object2, (SurfaceTexture)object, this);
        object = this.i.keySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (a$a)object.next();
            object2.a(textureRenderView$a, 0, 0);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture object) {
        boolean bl2;
        this.a = object;
        boolean bl3 = false;
        this.b = false;
        this.c = 0;
        this.d = 0;
        Object object2 = (TextureRenderView)this.h.get();
        TextureRenderView$a textureRenderView$a = new TextureRenderView$a((TextureRenderView)object2, (SurfaceTexture)object, this);
        object = this.i.keySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (a$a)object.next();
            object2.a(textureRenderView$a);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("onSurfaceTextureDestroyed: destroy: ");
        bl3 = this.e;
        ((StringBuilder)object).append(bl3);
        object = ((StringBuilder)object).toString();
        TXCLog.i("TextureRenderView", (String)object);
        return this.e;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture object, int n10, int n11) {
        boolean bl2;
        boolean bl3;
        this.a = object;
        this.b = bl3 = true;
        this.c = n10;
        this.d = n11;
        Object object2 = (TextureRenderView)this.h.get();
        TextureRenderView$a textureRenderView$a = new TextureRenderView$a((TextureRenderView)object2, (SurfaceTexture)object, this);
        object = this.i.keySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (a$a)object.next();
            object2.a(textureRenderView$a, 0, n10, n11);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void releaseSurfaceTexture(SurfaceTexture object) {
        String string2 = "TextureRenderView";
        if (object == null) {
            object = "releaseSurfaceTexture: null";
            TXCLog.i(string2, (String)object);
        } else {
            boolean bl2 = this.g;
            if (bl2) {
                Object object2 = this.a;
                if (object != object2) {
                    object2 = "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture";
                    TXCLog.i(string2, (String)object2);
                    object.release();
                } else {
                    bl2 = this.e;
                    if (!bl2) {
                        object2 = "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture";
                        TXCLog.i(string2, (String)object2);
                        object.release();
                    } else {
                        object = "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView";
                        TXCLog.i(string2, (String)object);
                    }
                }
            } else {
                bl2 = this.f;
                boolean bl3 = true;
                if (bl2) {
                    Object object3 = this.a;
                    if (object != object3) {
                        object3 = "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture";
                        TXCLog.i(string2, (String)object3);
                        object.release();
                    } else {
                        boolean bl4 = this.e;
                        if (!bl4) {
                            object = "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView";
                            TXCLog.i(string2, (String)object);
                            this.a(bl3);
                        } else {
                            object = "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView";
                            TXCLog.i(string2, (String)object);
                        }
                    }
                } else {
                    Object object4 = this.a;
                    if (object != object4) {
                        object4 = "releaseSurfaceTexture: alive: release different SurfaceTexture";
                        TXCLog.i(string2, (String)object4);
                        object.release();
                    } else {
                        boolean bl5 = this.e;
                        if (!bl5) {
                            object = "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView";
                            TXCLog.i(string2, (String)object);
                            this.a(bl3);
                        } else {
                            object = "releaseSurfaceTexture: alive: will released by TextureView";
                            TXCLog.i(string2, (String)object);
                        }
                    }
                }
            }
        }
    }
}

