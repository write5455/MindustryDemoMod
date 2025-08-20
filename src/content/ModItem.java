package content;

import mindustry.type.Item;

public class ModItem extends Item{
    public ModItem(String name){
        super(name);
    }
    public static ModItem apple;
    @Override
    public void load(){
        apple = new ModItem("apple");
    }
}
