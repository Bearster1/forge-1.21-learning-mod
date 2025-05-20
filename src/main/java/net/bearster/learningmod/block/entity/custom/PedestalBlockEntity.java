package net.bearster.learningmod.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PedestalBlockEntity extends BlockEntity implements Container {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);

    public PedestalBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.PEDESTAL_BE.get(), pPos, pBlockState);
    }

    @Override
    public int getContainerSize() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < getContainerSize(); i++) {
            ItemStack stack = getItem(i);
            if (!stack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int i) {
        setChanged();
        return inventory.get(i);
    }

    @Override
    public ItemStack removeItem(int i, int amount) {
        setChanged();
        ItemStack stack = inventory.get(i);
        stack.shrink(amount);
        return inventory.set(i, stack);
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        setChanged();
        return ContainerHelper.takeItem(inventory, i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        setChanged();
        inventory.set(i, itemStack.copyWithCount(1));
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        inventory.clear();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        ContainerHelper.saveAllItems(pTag, inventory, pRegistries);

    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        ContainerHelper.loadAllItems(pTag, inventory, pRegistries);


    }
}
