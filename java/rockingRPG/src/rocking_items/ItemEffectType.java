package rocking_items;

import java.io.Serializable;

public enum ItemEffectType implements Serializable {
    RESTORE_HEALTH,
    INCREASE_DEFENSE,
    INCREASE_ATTACK,
    INCREASE_SPEED,
    INCREASE_INTELLIGENCE;
}
