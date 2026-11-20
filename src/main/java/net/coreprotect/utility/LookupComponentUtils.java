package net.coreprotect.utility;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;

public final class LookupComponentUtils {

    private LookupComponentUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String createCopyableUser(String user, String rbFormat) {
        return ChatUtils.createCopyableText(Color.DARK_AQUA + rbFormat + user + Color.WHITE + rbFormat, user, Color.GREY + user);
    }

    public static String createTranslatableTarget(String translationKey, String target, String rbFormat, String tooltip) {
        return ChatUtils.createTranslatableComponent(translationKey, Color.DARK_AQUA + rbFormat + target + Color.WHITE, tooltip, !rbFormat.isEmpty());
    }

    public static String getMaterialTranslationKey(Material material) {
        if (material == null || material.isLegacy()) {
            return "";
        }

        NamespacedKey key = material.getKey();
        String base = key.getNamespace() + "." + key.getKey();
        return material.isBlock() ? "block." + base : "item." + base;
    }

    public static String getEntityTranslationKey(EntityType entityType) {
        if (entityType == null || entityType == EntityType.UNKNOWN) {
            return "";
        }

        NamespacedKey key = entityType.getKey();
        return "entity." + key.getNamespace() + "." + key.getKey();
    }
}
