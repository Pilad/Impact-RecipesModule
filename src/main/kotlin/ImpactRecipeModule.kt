import com.impactrecipes.MODID
import com.impactrecipes.loader.ModsLoader
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.*

@Mod(
    name = "Impact | Recipes Module",
    version = "MC1710",
    modid = MODID,
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter",
    dependencies = "required-after:forgelin; required-after:Forge; after:impact; after:IC2; after:gregtech; after:tectech; after:EnderIO;"
)
object ImpactRecipeModule {

    @Mod.InstanceFactory
    fun instance() = ImpactRecipeModule

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        ModsLoader.loader()
    }
}