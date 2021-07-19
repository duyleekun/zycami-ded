/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import d.v.j.e.i.b1;
import java.util.List;
import java.util.function.Predicate;

public final class m
implements Predicate {
    public final /* synthetic */ List a;

    public /* synthetic */ m(List list) {
        this.a = list;
    }

    public final boolean test(Object object) {
        List list = this.a;
        object = (ScriptTrackMetaData)object;
        return b1.X0(list, (ScriptTrackMetaData)object);
    }
}

