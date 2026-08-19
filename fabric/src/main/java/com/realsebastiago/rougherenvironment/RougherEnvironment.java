package com.realsebastiago.rougherenvironment;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

import java.util.List;


@Environment(EnvType.CLIENT)
public class RougherEnvironment implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
                return ARGB.opaque(RougherEnvironmentCommon.SAND_RESOLVER.getColor(
                        level.getBiomeFabric(pos).value(), pos.getX(), pos.getZ()
                        )
                );
            }
            
            @Override
            public int color(BlockState state) {
                return ARGB.opaque(0xFCF3D1);
            }
        }), Blocks.SAND);
        
        FluidRenderingRegistry.register(
                Fluids.LAVA,
                Fluids.FLOWING_LAVA,
                new FluidModel.Unbaked(
                        new Material(Identifier.withDefaultNamespace("block/lava_still")),
                        new Material(Identifier.withDefaultNamespace("block/lava_flow")),
                        new Material(Identifier.withDefaultNamespace("block/water_overlay")),
                        new BlockTintSource() {
                            @Override
                            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
                                return ARGB.opaque(RougherEnvironmentCommon.LAVA_RESOLVER.getColor(
                                                level.getBiomeFabric(pos).value(), pos.getX(), pos.getZ()
                                        )
                                );
                            }
                            
                            @Override
                            public int color(BlockState state) {
                                return ARGB.opaque(0xE97D3A);
                            }
                        }
                )
        );
    }
    
}