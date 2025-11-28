
public abstract class MeleeRole extends Role {
    // 護甲值：近戰角色特有的屬性
    private int armor;

    public MeleeRole(String name, int health, int attackPower, int armor) {
        super(name, health, attackPower);
        this.armor = armor;
    }

    // 取得護甲值
    public int getArmor() {
        return armor;
    }

    // 設定護甲值
    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int calculateDefense(int incomingDamage) {
        int actualDamage = Math.max(0, incomingDamage - armor);
        if (armor > 0 && incomingDamage > 0) {
            System.out.println("🛡️  護甲減免 " + Math.min(armor, incomingDamage) + " 點傷害！");
        }
        return actualDamage;
    }

    @Override
    public void takeDamage(int damage) {
        // 先計算護甲減免
        int actualDamage = calculateDefense(damage);
        // 再呼叫父類別的 takeDamage 處理實際傷害
        super.takeDamage(actualDamage);
    }

    public abstract String getWeaponType();

    @Override
    public void prepareBattle() {
        System.out.println("⚔️  " + getName() + " 檢查 " + getWeaponType() + " 的狀態...");
        System.out.println("🛡️  目前護甲值：" + armor);
        onMeleePrepare(); // 呼叫抽象方法，讓子類別加入特殊準備
    }

    protected abstract void onMeleePrepare();

    @Override
    public String toString() {
        return super.toString() + ", 護甲值: " + armor;
    }
}
