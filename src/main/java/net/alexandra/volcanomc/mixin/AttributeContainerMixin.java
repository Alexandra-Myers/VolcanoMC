package net.alexandra.volcanomc.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DefaultAttributeContainer.Builder.class)
public abstract class AttributeContainerMixin {
	@Invoker("checkedAdd")
	public abstract EntityAttributeInstance invokeCheckedAdd(EntityAttribute attribute);
}
