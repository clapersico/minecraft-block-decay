package com.example.fragileblockmod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = FragileBlockMod.MODID, name = FragileBlockMod.NAME, version = FragileBlockMod.VERSION)
public class FragileBlockMod {
    public static final String MODID = "fragileblockmod";
    public static final String NAME = "FragileBlockMod";
    public static final String VERSION = "1.0";

    public static Block fragileBlock;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            fragileBlock = new FragileBlock();
            event.getRegistry().register(fragileBlock);
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new ItemBlock(fragileBlock).setRegistryName(fragileBlock.getRegistryName()));
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(fragileBlock), 0,
                new ModelResourceLocation(fragileBlock.getRegistryName(), "inventory"));
        }
    }
}
