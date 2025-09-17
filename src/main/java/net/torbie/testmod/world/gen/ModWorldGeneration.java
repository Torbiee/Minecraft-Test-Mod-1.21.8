package net.torbie.testmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();
        ModEntitySpawns.addSpawns();
    }
}
