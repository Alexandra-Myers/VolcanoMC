package net.alexandra.volcanomc.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class AttackSpeedMixin {
	private static final DefaultAttributeContainer.Builder Builder1 = new DefaultAttributeContainer.Builder();
	private static final DefaultAttributeContainer.Builder Y = Builder1.add(EntityAttributes.GENERIC_LUCK);
	@Redirect(method = "createPlayerAttributes",
			  at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;add(Lnet/minecraft/entity/attribute/EntityAttribute;)Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;"))
	private static DefaultAttributeContainer.Builder InstaAttack(DefaultAttributeContainer.Builder instance, EntityAttribute attribute) {
			if (attribute == EntityAttributes.GENERIC_ATTACK_SPEED) {
				return null;
			} else if (attribute == EntityAttributes.GENERIC_LUCK){
				return Y;
			}else {
				return null;
			}
	}
}
