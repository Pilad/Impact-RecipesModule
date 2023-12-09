package com.impactrecipes.loader;

import com.impactrecipes.recipes.*;
import com.impactrecipes.recipes.laser.LaserEngraver;

import static com.impactrecipes.RecipeKotlinKt.recipesInit;
import static com.impactrecipes.util.RecipeUtils.registerRecipeClass;

/**
 * Класс для регистрации всех классов с рецептами
 */
public class ModsLoader {

    public static void loader() {
        ChiselGroup.run();

        new LaserEngraver();
        new Vanilla().run();
        new Gregtech().run();
        new AE().run();
        new BuildCraft().run();
        new Jabba().run();
        new OpenComputers().run();
        new RailCraft().run();
        new StevesFactoryManager().run();
        new StorageDrawers().run();
        new TecTech().run();
        new ProjectRed().run();
        new OpenBlocks().run();
        new ImpactCore().run();
        new GalaxySpace().run();
        new GalactiCraft().run();
        new IC2().run();
        new ExtraUtilities().run();
        new GraviSuite().run();
        new StarGate().run();
        new Gendustry().run();
        new Ztones().run();
        new Forestry().run();
        new ChestUp().run();
        new LogisticPipes().run();
        new MalisisDoors().run();
        new Backpack().run();
        new BiblioCraft().run();
        new ChickenChunks().run();
        new ArchitectureCraft().run();
        new CarpentersBlocks().run();
        new NuclearControl().run();
        new Ender_IO().run();
        new CatWalks().run();
        new UBC().run();
        new ChiselRecipes().run();


        registerRecipeClass(LaserEngraver.class);
        registerRecipeClass(Vanilla.class);
        registerRecipeClass(Gregtech.class);
        registerRecipeClass(AE.class);
        registerRecipeClass(BuildCraft.class);
        registerRecipeClass(Jabba.class);
        registerRecipeClass(OpenComputers.class);
        registerRecipeClass(RailCraft.class);
        registerRecipeClass(StevesFactoryManager.class);
        registerRecipeClass(StorageDrawers.class);
        registerRecipeClass(TecTech.class);
        registerRecipeClass(ProjectRed.class);
        registerRecipeClass(OpenBlocks.class);
        registerRecipeClass(ImpactCore.class);
        registerRecipeClass(GalaxySpace.class);
        registerRecipeClass(GalactiCraft.class);
        registerRecipeClass(IC2.class);
        registerRecipeClass(ExtraUtilities.class);
        registerRecipeClass(GraviSuite.class);
        registerRecipeClass(StarGate.class);
        registerRecipeClass(Gendustry.class);
        registerRecipeClass(Ztones.class);
        registerRecipeClass(Forestry.class);
        registerRecipeClass(ChestUp.class);
        registerRecipeClass(LogisticPipes.class);
        registerRecipeClass(MalisisDoors.class);
        registerRecipeClass(Backpack.class);
        registerRecipeClass(BiblioCraft.class);
        registerRecipeClass(ChickenChunks.class);
        registerRecipeClass(ArchitectureCraft.class);
        registerRecipeClass(CarpentersBlocks.class);
        registerRecipeClass(NuclearControl.class);
        registerRecipeClass(Ender_IO.class);
        registerRecipeClass(CatWalks.class);
        registerRecipeClass(UBC.class);
        registerRecipeClass(ChiselRecipes.class);
    
        recipesInit();
    }
}