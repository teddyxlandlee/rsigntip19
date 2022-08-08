package xland.mcmod.rsigntip19.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.client.multiplayer.ClientPacketListener")
abstract class MixinClientPacketListener {
    @Redirect(method = "handleServerData",
    at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/gui/components/toasts/ToastComponent;addToast(Lnet/minecraft/client/gui/components/toasts/Toast;)V"
    ))
    private void cancelOldToast(@Coerce Object instance, @Coerce Object toast) {}
}
