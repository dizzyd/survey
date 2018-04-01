package com.dizzyd.survey.blocks;

import com.dizzyd.survey.Survey;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nullable;

public class BlockStake extends Block {

	@GameRegistry.ObjectHolder(Survey.MODID + ":stake")
	public static BlockStake INSTANCE;

	protected static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(
			0.375D, 0.0D, 0.375D,
			0.625D, 0.625D, 0.625D);

	public BlockStake() {
		super(Material.GRASS);
		this.setUnlocalizedName(Survey.MODID + ".stake");
		this.setRegistryName(Survey.MODID, "stake");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		Item i = Item.getItemFromBlock(this);
		ModelResourceLocation mr = new ModelResourceLocation(getRegistryName(), "");
		ModelLoader.setCustomModelResourceLocation(i, 0, mr);
	}

	public void registerItems(IForgeRegistry<Item> registry) {
		Item item = new ItemBlock(this).setRegistryName(this.getRegistryName());
		registry.register(item);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BLOCK_AABB;
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
}
