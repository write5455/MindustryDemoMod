package MyContent;

import arc.graphics.Color;
import mindustry.mod.Mod;
import mindustry.type.Item;

public class ModItems extends Mod{
    public static Item apple;

    public static void load() {
        // 创建新物品
        apple = new Item("apple"){
            {
                // 设置物品属性
                localizedName = "示例资源";
                description = "一种用于示例模组的特殊资源";
                color = Color.valueOf("84f542"); // 设置颜色
                hardness = 1;
                cost = 1.5f;
                alwaysUnlocked = false; // 需要研究解锁
            }
        };
        apple.load();
    }
}
