/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.s0.h7;

import android.text.TextUtils;
import com.zhiyun.cama.camera.story.StoryZoom;
import com.zhiyun.cama.camera.story.StoryZoom$Type;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPointItem;
import com.zhiyun.stabilizer.entities.StoryAxis$Type;
import d.v.c.s0.h7.j0;
import d.v.e.h.c;
import java.util.ArrayList;
import java.util.List;

public class n0 {
    private static final int a = 300;
    private static final int b = 2048;

    private static void a(ScriptTrackPoint scriptTrackPoint) {
        String string2 = scriptTrackPoint.getOrientation();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = "horizontal";
            scriptTrackPoint.setOrientation(string2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)(string2 = scriptTrackPoint.getFunc()))) {
            string2 = "instant";
            scriptTrackPoint.setFunc(string2);
        }
    }

    private static float b(StoryAxis$Type storyAxis$Type, Float f10) {
        float f11;
        StoryAxis$Type storyAxis$Type2 = StoryAxis$Type.POSITION;
        int n10 = storyAxis$Type2.equals((Object)storyAxis$Type);
        if (n10 != 0) {
            n10 = 1133903872;
            f11 = 300.0f;
        } else {
            n10 = 0x45000000;
            f11 = 2048.0f;
        }
        return c.d(f10, f11);
    }

    private static long c(StoryAxis$Type object, String string2, long l10) {
        StoryAxis$Type storyAxis$Type = StoryAxis$Type.POSITION;
        if (object != storyAxis$Type) {
            return l10;
        }
        object = "uniform";
        boolean bl2 = ((String)object).equals(string2);
        if (!bl2) {
            l10 = 0L;
        }
        return l10;
    }

    private static StoryAxis$Type d(ScriptTrackPoint object) {
        boolean bl2;
        String string2 = "unmove";
        boolean bl3 = string2.equals(object = ((ScriptTrackPoint)object).getType());
        object = bl3 ? StoryAxis$Type.UNMOVE : ((bl2 = (string2 = "position").equals(object)) ? StoryAxis$Type.POSITION : StoryAxis$Type.SPEED);
        return object;
    }

    private static StoryZoom$Type e(ScriptTrackPointItem object) {
        StoryZoom$Type storyZoom$Type = StoryZoom$Type.SMOOTHLY;
        String string2 = storyZoom$Type.name().toLowerCase();
        boolean bl2 = string2.equals(object = ((ScriptTrackPointItem)object).getType());
        if (!bl2) {
            storyZoom$Type = StoryZoom$Type.IMMEDIATELY;
        }
        return storyZoom$Type;
    }

    private static boolean f(ScriptTrackPoint object) {
        object = ((ScriptTrackPoint)object).getOrientation();
        return "vertical".equals(object);
    }

    public static List g(List list) {
        int n10;
        ArrayList<j0> arrayList = new ArrayList<j0>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            j0 j02;
            ScriptTrackPoint scriptTrackPoint = (ScriptTrackPoint)list.get(i10);
            n0.a(scriptTrackPoint);
            StoryAxis$Type storyAxis$Type = n0.d(scriptTrackPoint);
            Object object = scriptTrackPoint.getPitch();
            float f10 = n0.b(storyAxis$Type, (Float)object);
            object = scriptTrackPoint.getRoll();
            float f11 = n0.b(storyAxis$Type, (Float)object);
            object = scriptTrackPoint.getYaw();
            float f12 = n0.b(storyAxis$Type, (Float)object);
            long l10 = scriptTrackPoint.getDuration();
            object = scriptTrackPoint.getFunc();
            long l11 = scriptTrackPoint.getDuration();
            l11 = n0.c(storyAxis$Type, (String)object, l11);
            int n11 = (int)l11;
            object = j02;
            j02 = new j0(storyAxis$Type, f10, f11, f12, n11, l10);
            n10 = (int)(n0.f(scriptTrackPoint) ? 1 : 0);
            j02.a = n10;
            arrayList.add(j02);
        }
        return arrayList;
    }

    public static List h(List object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (ScriptTrackPoint)object.next();
            ScriptTrackPointItem scriptTrackPointItem = ((ScriptTrackPoint)object2).getZoom();
            if (scriptTrackPointItem == null) continue;
            Float f10 = scriptTrackPointItem.getStart();
            float f11 = c.c(f10);
            float f12 = scriptTrackPointItem.getEnd();
            long l10 = ((ScriptTrackPoint)object2).getDuration();
            StoryZoom$Type storyZoom$Type = n0.e(scriptTrackPointItem);
            object2 = new StoryZoom(f11, f12, l10, storyZoom$Type);
            arrayList.add(object2);
        }
        return arrayList;
    }
}

