public interface Defendable {
    /**
     * 執行防禦動作（抽象方法）
     * 實作這個介面的類別必須提供防禦的具體實作
     */
    void defend();

    /**
     * 取得防禦力（抽象方法）
     * @return 防禦力數值
     */
    int getDefenseCapacity();

    /**
     * 檢查是否可以防禦（預設方法）
     * 這是介面的預設方法（default method，Java 8+）
     * 子類別可以選擇性覆寫
     *
     * @return true 如果可以防禦
     */
    default boolean canDefend() {
        return getDefenseCapacity() > 0;
    }
}
