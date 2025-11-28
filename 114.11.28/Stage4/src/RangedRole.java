
public abstract class RangedRole extends Role {
    // 攻擊範圍：遠程角色特有的屬性
    private int range;
    // 能量值：用於施放遠程攻擊（魔力、箭矢等）
    private int energy;
    private int maxEnergy;
    

    public RangedRole(String name, int health, int attackPower, int range, int maxEnergy) {
        super(name, health, attackPower);
        this.range = range;
        this.maxEnergy = maxEnergy;
        this.energy = maxEnergy; // 初始能量為最大值
    }

    // 取得攻擊範圍
    public int getRange() {
        return range;
    }

    // 取得當前能量值
    public int getEnergy() {
        return energy;
    }

    // 取得最大能量值
    public int getMaxEnergy() {
        return maxEnergy;
    }

    // 設定能量值
    public void setEnergy(int energy) {
        this.energy = Math.min(energy, maxEnergy); // 不超過最大值
    }

    public boolean isInRange(int distance) {
        boolean inRange = distance <= range;
        if (!inRange) {
            System.out.println("❌ 目標距離 " + distance + " 超出射程 " + range + "！");
        }
        return inRange;
    }

    public boolean consumeEnergy(int amount) {
        if (energy >= amount) {
            energy -= amount;
            System.out.println("💫 消耗 " + amount + " 點能量，剩餘：" + energy + "/" + maxEnergy);
            return true;
        } else {
            System.out.println("❌ 能量不足！需要 " + amount + "，目前只有 " + energy);
            return false;
        }
    }

    public void restoreEnergy(int amount) {
        int oldEnergy = energy;
        energy = Math.min(energy + amount, maxEnergy);
        System.out.println("✨ 恢復 " + (energy - oldEnergy) + " 點能量 (" + oldEnergy + " → " + energy + ")");
    }

    public abstract String getRangedAttackType();

    @Override
    public void prepareBattle() {
        System.out.println("🎯 " + getName() + " 準備 " + getRangedAttackType() + " 攻擊...");
        System.out.println("📊 能量值：" + energy + "/" + maxEnergy + "，射程：" + range);
        onRangedPrepare(); // 呼叫抽象方法，讓子類別加入特殊準備
    }

    protected abstract void onRangedPrepare();


    @Override
    public void afterBattle() {
        restoreEnergy(10); // 每次戰鬥後恢復 10 點能量
        onRangedRecover(); // 呼叫抽象方法
    }

    protected abstract void onRangedRecover();

    @Override
    public String toString() {
        return super.toString() + ", 能量: " + energy + "/" + maxEnergy + ", 射程: " + range;
    }
}
