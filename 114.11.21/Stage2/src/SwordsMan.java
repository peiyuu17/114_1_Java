public  class SwordsMan extends Role{
    private int health;

    // 建構子：初始化劍士的名稱、生命值和攻擊力
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    @Override
    public void onLevelUp() {
        System.out.println("⚔️  劍技更加精湛！");
    }
    // 攻擊對手(劍客/魔法師)，父類別的參考指到子類別物件
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }
    public void takeDamage(int damage) {
        // 步驟 1: 扣血（所有角色相同）
        this.health -= damage;

        // 步驟 2: 顯示訊息（所有角色相同）
        System.out.println("受到傷害");

        // 步驟 3: 檢查死亡（所有角色相同）
        if (!isAlive()) {
            // 步驟 4: 死亡處理（每個角色不同 - 抽象方法）
            onDeath();
        }
    }
    @Override
    public void onDeath() {
        System.out.println(this.getName() + " 倒下了……劍士的戰鬥結束了。");
    }

    @Override
    public void prepareBattle() {
        System.out.println(this.getName() + " 正在拔劍準備戰鬥！");
    }

    @Override
    public void afterBattle() {
        System.out.println(this.getName() + " 收劍並調整呼吸。");
    }

}
