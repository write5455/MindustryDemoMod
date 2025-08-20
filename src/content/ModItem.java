package content;

import mindustry.type.Item;

public class ModItem extends Item {
    public ModItem(String name){
        super(name);
    }
    public static ModItem cpp = new ModItem("cpp");
}