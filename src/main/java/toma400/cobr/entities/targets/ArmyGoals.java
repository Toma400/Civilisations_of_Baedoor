package toma400.cobr.entities.targets;

import net.minecraft.world.entity.ai.goal.Goal;

public class ArmyGoals {

    public static class FollowLeaderGoal extends Goal {

        @Override
        public boolean canUse() {
            return false;
        }
    }

}
