public class Magician extends Role {
    // 治癒力
    private int healPower;

    // 建構子：初始化魔法師的名稱、生命值和攻擊力
    public Magician(String name, int health, int attackPower, int healPower) {
        super(name, health, attackPower);
        this.healPower = healPower;
    }

    // 取得治癒力
    public int getHealPower() {
        return healPower;
    }

    // 攻擊對手
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 魔法攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }

    // 治療隊友
    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療 " + ally.getName() + " 回復 " + healPower + " 點生命值。" + ally);
    }

    @Override
    public void onLevelUp() {
        this.healPower += 3;
        System.out.println("✨ 魔法力量增強！治療力 +3");
    }

    // 亡行為
    @Override
    public void onDeath() {
        System.out.println(this.getName() + " 倒下了...（魔法師煙霧散去）");
    }

    // 戰鬥前行為
    @Override
    public void prepareBattle() {
        System.out.println(this.getName() + " 正在專注並聚集魔力...");
    }

    // 戰鬥後行為
    @Override
    public void afterBattle() {
        System.out.println(this.getName() + " 結束戰鬥，調整魔力。");
    }

    @Override
    public String toString() {
        return super.toString() + ", 治癒力: " + healPower;
    }
}
