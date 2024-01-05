package com.brainterminator.verticalslabs.data.client;

import com.brainterminator.verticalslabs.handler.VerticalSlabLoader;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import javax.json.JsonObject;
import java.io.*;

/*
This class is just a temporary class to generate needed files to run and publish this mod.
TODO: USE THE RECOMMENDED DATAGEN TOOLS PROVIDED BY MOJANG IN THE ModBlockStateProvider
 */
public class BlockStateAndModelGenerator {

    //CALL THIS ONCE TO GENERATE FILES!
    public static void registerBlockStatesAndModels(){
        generateFolderStructure();
        for(RegistryObject<Block> slab : VerticalSlabLoader.SLABS){
            generateBlockState(slab.get());
            generateBlockModel(slab.get());
            generateBlockModelInner(slab.get());
            generateBlockModelOuter(slab.get());
            generateItemModel(slab.get());
        }
    }

    protected static void generateFolderStructure(){
        createFolder("../src/");
        createFolder("../src/generated/");
        createFolder("../src/generated/resources/assets/");
        createFolder("../src/generated/resources/assets/verticalslabs/");
        createFolder("../src/generated/resources/assets/verticalslabs/blockstates/");
        createFolder("../src/generated/resources/assets/verticalslabs/models/");
        createFolder("../src/generated/resources/assets/verticalslabs/models/block/");
        createFolder("../src/generated/resources/assets/verticalslabs/models/item/");
    }

    public static void createFolder(String path) {
        File folder = new File(path);
            if (!folder.exists()) {
                if (folder.mkdirs()) {
                    System.err.println("Folder created: " + path);
                } else {
                    System.err.println("Failed to create folder: " + path);
                }
            } else {
                System.err.println("Folder already exists: " + path);
            }
    }
    protected static void generateBlockState(Block block){
        String blockName = I18n.get(block.getDescriptionId()).replace("block.verticalslabs.", "");

        String blockStateJSON = "{\n" +
                "  \"variants\": {\n" +
                "    \"facing=east,half=bottom,shape=inner_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=bottom,shape=inner_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\"\n" +
                "    },\n" +
                "    \"facing=east,half=bottom,shape=outer_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=bottom,shape=outer_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\"\n" +
                "    },\n" +
                "    \"facing=east,half=bottom,shape=straight\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab\"\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=inner_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=inner_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=outer_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=outer_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=east,half=top,shape=straight\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=inner_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=inner_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=outer_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=outer_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=bottom,shape=straight\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab\",\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=inner_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=inner_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=outer_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=outer_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=north,half=top,shape=straight\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=inner_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\"\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=inner_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=outer_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\"\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=outer_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=bottom,shape=straight\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=inner_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=inner_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=outer_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=outer_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=south,half=top,shape=straight\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=inner_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=inner_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=outer_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"y\": 90,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=outer_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=bottom,shape=straight\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab\",\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=inner_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=inner_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_inner\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=outer_left\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=outer_right\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab_outer\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 270,\n" +
                "      \"uvlock\": true\n" +
                "    },\n" +
                "    \"facing=west,half=top,shape=straight\": {\n" +
                "      \"model\": \"verticalslabs:block/vertical_slab\",\n" +
                "      \"x\": 180,\n" +
                "      \"y\": 180,\n" +
                "      \"uvlock\": true\n" +
                "    }\n" +
                "  }\n" +
                "}";

        blockStateJSON = blockStateJSON.replace("vertical_slab", blockName);

        try {
            System.out.println("Starting Writing of BlockStates");
            Writer writer = new BufferedWriter(new FileWriter("../src/generated/resources/assets/verticalslabs/blockstates/" + blockName + ".json"));
            writer.write(blockStateJSON);
            writer.close();
            System.out.println("FINISHED!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void generateBlockModel(Block block){
        String blockName = block.getDescriptionId().replace("block.verticalslabs.", "");
        String textureName = VerticalSlabLoader.getVanillaOf(block).getDescriptionId().replace("block.minecraft.", "").replace("_slab", "");

        String blockModelJSON = "{\n" +
                "\t\"textures\": {\n" +
                "\t\t\"0\": \"minecraft:block/original\",\n" +
                "\t\t\"particle\": \"minecraft:block/original\"\n" +
                "\t},\n" +
                "\t\"elements\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"from\": [8, 0, 0],\n" +
                "\t\t\t\"to\": [16, 16, 16],\n" +
                "\t\t\t\"faces\": {\n" +
                "\t\t\t\t\"north\": {\"uv\": [4, 0, 12, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"east\": {\"uv\": [0, 0, 16, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"south\": {\"uv\": [4, 0, 12, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"west\": {\"uv\": [0, 0, 16, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"up\": {\"uv\": [0, 4, 16, 12], \"rotation\": 90, \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"down\": {\"uv\": [0, 4, 16, 12], \"rotation\": 270, \"texture\": \"#0\"}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"display\": {\n" +
                "\t\t\"thirdperson_righthand\": {\n" +
                "\t\t\t\"scale\": [0.4, 0.4, 0.4]\n" +
                "\t\t},\n" +
                "\t\t\"thirdperson_lefthand\": {\n" +
                "\t\t\t\"scale\": [0.4, 0.4, 0.4]\n" +
                "\t\t},\n" +
                "\t\t\"firstperson_righthand\": {\n" +
                "\t\t\t\"scale\": [0.4, 0.4, 0.4]\n" +
                "\t\t},\n" +
                "\t\t\"firstperson_lefthand\": {\n" +
                "\t\t\t\"scale\": [0.4, 0.4, 0.4]\n" +
                "\t\t},\n" +
                "\t\t\"ground\": {\n" +
                "\t\t\t\"translation\": [0, 3, 0],\n" +
                "\t\t\t\"scale\": [0.3, 0.3, 0.3]\n" +
                "\t\t},\n" +
                "\t\t\"gui\": {\n" +
                "\t\t\t\"rotation\": [20, 39, 0],\n" +
                "\t\t\t\"translation\": [-2, -0.5, 0],\n" +
                "\t\t\t\"scale\": [0.7, 0.7, 0.7]\n" +
                "\t\t},\n" +
                "\t\t\"fixed\": {\n" +
                "\t\t\t\"scale\": [0.4, 0.4, 0.4]\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        blockModelJSON = blockModelJSON.replace("original", textureName);

        try {
            System.out.println("Starting Writing of Model");
            Writer writer = new BufferedWriter(new FileWriter("../src/generated/resources/assets/verticalslabs/models/block/" + blockName + ".json"));
            writer.write(blockModelJSON);
            writer.close();
            System.out.println("FINISHED!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void generateBlockModelInner(Block block){
        String blockName = block.getDescriptionId().replace("block.verticalslabs.", "");
        String textureName = VerticalSlabLoader.getVanillaOf(block).getDescriptionId().replace("block.minecraft.", "").replace("_slab", "");

        String blockModelJSON = "{\n" +
                "\t\"textures\": {\n" +
                "\t\t\"0\": \"minecraft:block/original\",\n" +
                "\t\t\"particle\": \"minecraft:block/original\"\n" +
                "\t},\n" +
                "\t\"elements\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"from\": [0, 0, 8],\n" +
                "\t\t\t\"to\": [16, 16, 16],\n" +
                "\t\t\t\"rotation\": {\"angle\": 0, \"axis\": \"y\", \"origin\": [14, 0, 16]},\n" +
                "\t\t\t\"faces\": {\n" +
                "\t\t\t\t\"north\": {\"uv\": [0, 0, 16, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"east\": {\"uv\": [0, 0, 8, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"south\": {\"uv\": [0, 0, 16, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"west\": {\"uv\": [4, 0, 12, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"up\": {\"uv\": [0, 0, 16, 8], \"rotation\": 180, \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"down\": {\"uv\": [0, 8, 16, 16], \"rotation\": 180, \"texture\": \"#0\"}\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"from\": [8, 0, 0],\n" +
                "\t\t\t\"to\": [16, 16, 8],\n" +
                "\t\t\t\"rotation\": {\"angle\": 0, \"axis\": \"y\", \"origin\": [14, 0, 16]},\n" +
                "\t\t\t\"faces\": {\n" +
                "\t\t\t\t\"north\": {\"uv\": [4, 0, 12, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"east\": {\"uv\": [8, 0, 16, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"south\": {\"uv\": [0, 0, 8, 16], \"texture\": \"#missing\"},\n" +
                "\t\t\t\t\"west\": {\"uv\": [0, 0, 8, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"up\": {\"uv\": [0, 0, 8, 8], \"rotation\": 90, \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"down\": {\"uv\": [0, 8, 8, 16], \"rotation\": 270, \"texture\": \"#0\"}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"display\": {\n" +
                "\t\t\"thirdperson_righthand\": {\n" +
                "\t\t\t\"scale\": [0.3, 0.3, 0.3]\n" +
                "\t\t},\n" +
                "\t\t\"thirdperson_lefthand\": {\n" +
                "\t\t\t\"scale\": [0.3, 0.3, 0.3]\n" +
                "\t\t},\n" +
                "\t\t\"firstperson_righthand\": {\n" +
                "\t\t\t\"scale\": [0.5, 0.5, 0.5]\n" +
                "\t\t},\n" +
                "\t\t\"firstperson_lefthand\": {\n" +
                "\t\t\t\"scale\": [0.5, 0.5, 0.5]\n" +
                "\t\t},\n" +
                "\t\t\"ground\": {\n" +
                "\t\t\t\"translation\": [0, -1, 0],\n" +
                "\t\t\t\"scale\": [0.3, 0.3, 0.3]\n" +
                "\t\t},\n" +
                "\t\t\"gui\": {\n" +
                "\t\t\t\"rotation\": [15, -34, -2],\n" +
                "\t\t\t\"translation\": [-1.5, -0.5, 0],\n" +
                "\t\t\t\"scale\": [0.7, 0.7, 0.7]\n" +
                "\t\t},\n" +
                "\t\t\"fixed\": {\n" +
                "\t\t\t\"rotation\": [0, -90, 0],\n" +
                "\t\t\t\"scale\": [0.81, 0.81, 0.81]\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        blockModelJSON = blockModelJSON.replace("original", textureName);

        try {
            System.out.println("Starting Writing of Model");
            Writer writer = new BufferedWriter(new FileWriter("../src/generated/resources/assets/verticalslabs/models/block/" + blockName + "_inner.json"));
            writer.write(blockModelJSON);
            writer.close();
            System.out.println("FINISHED!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void generateBlockModelOuter(Block block){
        String blockName = block.getDescriptionId().replace("block.verticalslabs.", "");
        String textureName = VerticalSlabLoader.getVanillaOf(block).getDescriptionId().replace("block.minecraft.", "").replace("_slab", "");

        String blockModelJSON = "{\n" +
                "\t\"textures\": {\n" +
                "\t\t\"0\": \"minecraft:block/original\",\n" +
                "\t\t\"particle\": \"minecraft:block/original\"\n" +
                "\t},\n" +
                "\t\"elements\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"from\": [8, 0, 8],\n" +
                "\t\t\t\"to\": [16, 16, 16],\n" +
                "\t\t\t\"faces\": {\n" +
                "\t\t\t\t\"north\": {\"uv\": [0, 0, 8, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"east\": {\"uv\": [8, 0, 16, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"south\": {\"uv\": [0, 0, 8, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"west\": {\"uv\": [8, 0, 16, 16], \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"up\": {\"uv\": [8, 8, 16, 16], \"rotation\": 180, \"texture\": \"#0\"},\n" +
                "\t\t\t\t\"down\": {\"uv\": [8, 0, 16, 8], \"rotation\": 180, \"texture\": \"#0\"}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"display\": {\n" +
                "\t\t\"thirdperson_righthand\": {\n" +
                "\t\t\t\"scale\": [0.3, 0.3, 0.3]\n" +
                "\t\t},\n" +
                "\t\t\"thirdperson_lefthand\": {\n" +
                "\t\t\t\"scale\": [0.3, 0.3, 0.3]\n" +
                "\t\t},\n" +
                "\t\t\"firstperson_righthand\": {\n" +
                "\t\t\t\"scale\": [0.5, 0.5, 0.5]\n" +
                "\t\t},\n" +
                "\t\t\"firstperson_lefthand\": {\n" +
                "\t\t\t\"scale\": [0.5, 0.5, 0.5]\n" +
                "\t\t},\n" +
                "\t\t\"ground\": {\n" +
                "\t\t\t\"translation\": [0, -1, 0],\n" +
                "\t\t\t\"scale\": [0.3, 0.3, 0.3]\n" +
                "\t\t},\n" +
                "\t\t\"gui\": {\n" +
                "\t\t\t\"rotation\": [15, -34, -2],\n" +
                "\t\t\t\"translation\": [-1.5, -0.5, 0],\n" +
                "\t\t\t\"scale\": [0.7, 0.7, 0.7]\n" +
                "\t\t},\n" +
                "\t\t\"fixed\": {\n" +
                "\t\t\t\"rotation\": [0, -90, 0],\n" +
                "\t\t\t\"scale\": [0.81, 0.81, 0.81]\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        blockModelJSON = blockModelJSON.replace("original", textureName);

        try {
            System.out.println("Starting Writing of Model");
            Writer writer = new BufferedWriter(new FileWriter("../src/generated/resources/assets/verticalslabs/models/block/" + blockName + "_outer.json"));
            writer.write(blockModelJSON);
            writer.close();
            System.out.println("FINISHED!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void generateItemModel(Block block){
        String blockName = block.getDescriptionId().replace("block.verticalslabs.", "");

        String blockModelJSON = "{\n" +
                "  \"parent\": \"verticalslabs:block/vertical_slab\"\n" +
                "}";

        blockModelJSON = blockModelJSON.replace("vertical_slab", blockName);

        try {
            System.out.println("Starting Writing of Model");
            Writer writer = new BufferedWriter(new FileWriter("../src/generated/resources/assets/verticalslabs/models/item/" + blockName + ".json"));
            writer.write(blockModelJSON);
            writer.close();
            System.out.println("FINISHED!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
