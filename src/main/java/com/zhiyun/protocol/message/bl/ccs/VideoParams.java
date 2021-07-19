/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.ccs;

import com.zhiyun.protocol.message.bl.ccs.VideoParams$Protocol;
import d.v.y.d.k;
import java.util.Objects;

public class VideoParams {
    private String a = "udp://192.168.2.1:6000";
    private VideoParams$Protocol b;
    private String c;
    private int d = 7000;

    public static VideoParams a(String object) {
        int n10;
        int n11;
        VideoParams videoParams = new VideoParams();
        Object object2 = ",";
        int n12 = ((String[])(object = object.split((String)object2))).length;
        if (n12 >= (n11 = 1)) {
            n12 = 0;
            object2 = object[0];
            videoParams.f((String)object2);
        }
        if ((n12 = ((String[])object).length) >= (n10 = 2)) {
            object2 = VideoParams.j(object[n11]);
            videoParams.g((VideoParams$Protocol)((Object)object2));
        }
        if ((n12 = ((String[])object).length) >= (n11 = 3)) {
            object2 = object[n10];
            videoParams.i((String)object2);
        }
        if ((n12 = ((String[])object).length) >= (n10 = 4)) {
            object = object[n11];
            int n13 = k.i((String)object);
            videoParams.h(n13);
        }
        return videoParams;
    }

    private static VideoParams$Protocol j(String string2) {
        for (VideoParams$Protocol videoParams$Protocol : VideoParams$Protocol.values()) {
            String string3 = videoParams$Protocol.name();
            boolean bl2 = string3.equalsIgnoreCase(string2);
            if (!bl2) continue;
            return videoParams$Protocol;
        }
        return VideoParams$Protocol.H264;
    }

    public String b() {
        return this.a;
    }

    public VideoParams$Protocol c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (VideoParams)object;
            int n10 = this.d;
            int n11 = ((VideoParams)object).d;
            if (n10 != n11 || (n10 = (int)(Objects.equals(object3 = this.a, object2 = ((VideoParams)object).a) ? 1 : 0)) == 0 || (object3 = this.b) != (object2 = ((VideoParams)object).b) || !(bl3 = Objects.equals(object3 = this.c, object = ((VideoParams)object).c))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public void f(String string2) {
        this.a = string2;
    }

    public void g(VideoParams$Protocol videoParams$Protocol) {
        this.b = videoParams$Protocol;
    }

    public void h(int n10) {
        this.d = n10;
    }

    public int hashCode() {
        Object[] objectArray = new Object[4];
        Object object = this.a;
        objectArray[0] = object;
        object = this.b;
        objectArray[1] = object;
        object = this.c;
        objectArray[2] = object;
        object = this.d;
        objectArray[3] = object;
        return Objects.hash(objectArray);
    }

    public void i(String string2) {
        this.c = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoParams{address='");
        String string2 = this.a;
        stringBuilder.append(string2);
        int n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", protocol=");
        Object object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(", strategy='");
        object = this.c;
        stringBuilder.append((String)object);
        stringBuilder.append((char)n10);
        stringBuilder.append(", replayPort=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

