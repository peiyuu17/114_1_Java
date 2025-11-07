public class RPG {
    public static void main(String[] args) {
        SwordsMan swordsMan1 = new SwordsMan("亞瑟", 100, 20);
        SwordsMan swordsMan2 = new SwordsMan("蘭斯洛特", 100, 15);
        Magician magician1 = new Magician("梅林", 80, 10, 15);
        Magician magician2 = new Magician("法師", 100, 5,  10);
        // 戰鬥開始
        System.out.println("戰鬥開始!");
        swordsMan1.attack(swordsMan2);
        magician1.attack(magician2);
        magician2.heal(swordsMan2);
    }
}
