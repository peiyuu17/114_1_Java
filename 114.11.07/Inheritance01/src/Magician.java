public class Magician extends Role {
    private int healPower;
    public Magician(String name, int health, int attackPower,int healPower) {
        super(name, health, attackPower);
        this.healPower= healPower;
    }
    public int getHealPower() {
        return healPower;
    }
    public void attack(Magician opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 使用魔法攻擊了 " + opponent.getName() + "，造成 " + this.getAttackPower() + " 點傷害！");
    }

    public void heal(SwordsMan ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療了 " + ally.getName() + "，恢復了 " + healPower + " 點生命值！");
    }
    @Override
    public String toString() {
        return super.toString() + ", 治療力: " + healPower;
    }
}