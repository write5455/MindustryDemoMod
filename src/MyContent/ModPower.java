package MyContent;

import mindustry.content.Items;
import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.*;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static MyContent.ModItems.apple;

public class ModPower extends Mod{
    public static Block appleGenerator;

    public static void load() {
        // 创建新发电机
        appleGenerator = new PowerGenerator("appleGenerator"){
            {
                // 设置发电机属性
                requirements(
                        Category.power,
                        ItemStack.with(
                                Items.copper,60,
                                Items.coal,40
                        )
                );

                powerProduction = 5f; // 发电量
                itemCapacity = 200; // 物品容量
                size = 4; // 方块大小
                //hasItems = true;

                // 设置消耗物品和发电时间
                consumeItem(Items.coal, 14/210); // 每秒消耗1个物品
            }

            @Override
            public void setStats(){
                super.setStats();
                // 自定义统计信息
                stats.add(Stat.productionTime, 210f/14f, StatUnit.seconds);
            }
        };
        appleGenerator.load();
    }
}