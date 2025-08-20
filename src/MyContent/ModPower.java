package MyContent;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.*;
import mindustry.world.consumers.ConsumeItemExplode;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.draw.*;

import static MyContent.ModItems.apple;

public class ModPower extends Mod{
    public static Block appleGenerator;
    public static Block bb;

    public static void load() {
        // 创建新发电机
        appleGenerator = new ConsumeGenerator("appleGenerator"){{
                // 设置发电机属性
                requirements(
                        Category.power,
                        ItemStack.with(
                                Items.copper,60,
                                Items.coal,40
                        )
                );

                powerProduction = 5f; // 发电量
                itemDuration = 60*14f; //发电时间
                itemCapacity = 200; // 物品容量
                size = 1; // 方块大小
                hasItems = true;

                // 设置消耗物品和发电时间
                consumeItem(apple, 1); // 每秒消耗1个物品
            }
        };

        bb = new ConsumeGenerator("bb-generator"){{
            requirements(Category.power, ItemStack.with(Items.copper, 25, Items.lead, 15));
            powerProduction = 10f;
            itemDuration = 120f;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;

            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());

            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
        }};

        appleGenerator.load();
    }
}