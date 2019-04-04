package com.tfar.mine3d;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;

public class GuiStuff {
  public static void drawEntityOnScreen(float posX, float posY, int scale, float mouseX, EntityLivingBase ent)
  {
    GlStateManager.enableColorMaterial();
    GlStateManager.pushMatrix();
    GlStateManager.translate(posX, posY, 50.0F);
    GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
    GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
    float f = ent.renderYawOffset;
    float f1 = ent.rotationYaw;
    float f2 = ent.rotationPitch;
    float f3 = ent.prevRotationYawHead;
    float f4 = ent.rotationYawHead;
    GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
    RenderHelper.enableStandardItemLighting();
    GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
    GlStateManager.rotate(0, 1, 0, 0);
    ent.renderYawOffset = (float)Math.atan((double)(mouseX / 40.0F)) * 20.0F;
    ent.rotationYaw = (float)Math.atan((double)(mouseX / 40.0F)) * 40.0F;
    ent.rotationPitch = 0;
    ent.rotationYawHead = ent.rotationYaw;
    ent.prevRotationYawHead = ent.rotationYaw;
    GlStateManager.translate(0.0F, 0.0F, 0.0F);
    RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
    rendermanager.setPlayerViewY(180.0F);
    rendermanager.setRenderShadow(false);
    rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
    rendermanager.setRenderShadow(true);
    ent.renderYawOffset = f;
    ent.rotationYaw = f1;
    ent.rotationPitch = f2;
    ent.prevRotationYawHead = f3;
    ent.rotationYawHead = f4;
    GlStateManager.popMatrix();
    RenderHelper.disableStandardItemLighting();
    GlStateManager.disableRescaleNormal();
    GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
    GlStateManager.disableTexture2D();
    GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
  }
}
