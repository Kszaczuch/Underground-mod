package net.kszaczuch.undergroundmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kszaczuch.undergroundmod.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CHLOROPHYTE_HELMET,ModItems.CHLOROPHYTE_CHESTPLATE,ModItems.CHLOROPHYTE_LEGGINGS,ModItems.CHLOROPHYTE_BOOTS);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.JUNGLE_MUSIC_DISC,ModItems.UNDERGROUND_JUNGLE_MUSIC_DISC,ModItems.UNDERGROUND_DESERT_MUSIC_DISC,ModItems.UNDERGROUND_ICE_MUSIC_DISC);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.JUNGLE_MUSIC_DISC,ModItems.UNDERGROUND_JUNGLE_MUSIC_DISC,ModItems.UNDERGROUND_DESERT_MUSIC_DISC,ModItems.UNDERGROUND_ICE_MUSIC_DISC);
    }
}
