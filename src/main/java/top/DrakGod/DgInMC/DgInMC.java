package top.DrakGod.DgInMC;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.DrakGod.DgInMC.registers.*;

import org.apache.logging.log4j.*;

@Mod("dginmc")
public class DgInMC {
    public static String Mod_ID = "dginmc";
    public static String Mod_Version = "beta0.0.1";

    public static ItemGroup DgItemGroup = RegisterItems.DgItemGroup;
    public static RegisterItems Items = new RegisterItems();

    public static IEventBus EventBus;
    public static FMLJavaModLoadingContext Context;
    public static Logger Logger = LogManager.getLogger();

    public DgInMC() {
        Logger.info("DgInMC开始加载");
        Context = FMLJavaModLoadingContext.get();
        EventBus = Context.getModEventBus();

        EventBus.register(DgItemGroup);
        Logger.info("DgInMC已注册物品组");

        Items.Items.register(EventBus);
        Logger.info("DgInMC已注册物品");

        Logger.info("DgInMC加载结束");
    }
}
