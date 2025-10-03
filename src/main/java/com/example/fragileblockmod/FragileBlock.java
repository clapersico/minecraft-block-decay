package com.example.fragileblockmod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FragileBlock extends Block {
    public FragileBlock() {
        super(Material.CLOTH);
        setUnlocalizedName("fragile_block");
        setRegistryName("fragile_block");
        setHardness(0.8F);
        setResistance(4.0F);
        setSoundType(SoundType.CLOTH);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if (!world.isRemote) {
            // 5% chance to decay into air
            if (rand.nextFloat() < 0.05F) {
                world.setBlockToAir(pos);
            }
        }
    }
}
