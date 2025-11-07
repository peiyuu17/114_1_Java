// src/SwordsMan.java
public class SwordsMan extends Role {

    // 建構子：初始化名稱、生命與攻擊力
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void attack(SwordsMan opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 使用劍攻擊了 " + opponent.getName() + "，造成 " +
                this.getAttackPower() + " 點傷害！"+opponent.toString());
    }
}
