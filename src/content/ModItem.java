package content;

import arc.graphics.Color;
import mindustry.mod.*;
import mindustry.type.*;

public class ModItem extends Mod {
    public static Item apple;

    public void loadcontent(){
        apple = new Item("apple"){
            {
                localizedName = "示例资源";
                description = "一种用于示例模组的特殊资源";
                color = Color.valueOf("84f542"); // 设置颜色
                hardness = 1;
                cost = 1.5f;
                alwaysUnlocked = true; // 不需要研究解锁
            }
        };
    }
}
