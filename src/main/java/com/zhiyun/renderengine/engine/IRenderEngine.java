/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.renderengine.engine;

import android.content.Context;
import com.zhiyun.renderengine.bean.TextureFormat;
import com.zhiyun.renderengine.engine.IRenderEngine$RenderMode;
import com.zhiyun.renderengine.engine.RenderEngineType;
import d.v.b0.d.d;
import d.v.b0.f.b;
import java.util.List;

public interface IRenderEngine {
    public void a(int var1, int var2);

    public void b(int var1);

    public d c(int var1);

    public List d();

    public int e(byte[] var1, TextureFormat var2, int var3, boolean var4, int var5, int var6);

    public boolean f(d var1);

    public int g(byte[] var1, TextureFormat var2, int var3, int var4);

    public int getDeviceOrientation();

    public int h(int var1, int var2, int var3);

    public boolean i();

    public RenderEngineType j();

    public boolean k(Context var1);

    public int[] l();

    public d m(int var1);

    public boolean n();

    public TextureFormat[] o();

    public void p(IRenderEngine$RenderMode var1);

    public void q(b var1);

    public boolean r(d var1);
}

