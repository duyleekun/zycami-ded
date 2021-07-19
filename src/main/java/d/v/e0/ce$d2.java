/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.utils.Axis;
import com.zhiyun.stabilizer.Stabilizer;
import com.zhiyun.stabilizer.entities.StoryAxis;
import com.zhiyun.stabilizer.entities.StoryAxis$Type;
import d.v.e0.ce;
import d.v.e0.p7;
import e.a.e0;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class ce$d2
implements o {
    public final /* synthetic */ ce a;

    public ce$d2(ce ce2) {
        this.a = ce2;
    }

    public static /* synthetic */ Boolean b(Long l10) {
        return Boolean.TRUE;
    }

    public e0 a(StoryAxis object) {
        Object object2 = ((StoryAxis)object).type;
        Object object3 = StoryAxis$Type.POSITION;
        if (object2 == object3) {
            object2 = ce.s(this.a);
            object3 = ((StoryAxis)object).axis;
            long l10 = ((StoryAxis)object).wait;
            return ((Stabilizer)object2).D7((Axis)object3, l10);
        }
        object3 = StoryAxis$Type.SPEED;
        if (object2 == object3) {
            object2 = ce.s(this.a);
            object3 = ((StoryAxis)object).axis;
            long l11 = ((StoryAxis)object).wait;
            return ((Stabilizer)object2).E7((Axis)object3, l11);
        }
        long l12 = ((StoryAxis)object).wait;
        object = TimeUnit.MILLISECONDS;
        object = z.O6(l12, (TimeUnit)((Object)object));
        object2 = p7.a;
        return ((z)object).H3((o)object2);
    }
}

