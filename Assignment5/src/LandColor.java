public enum LandColor {
    RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE, WHITE, BLACK;

    private int Occupiedby;

    public int getOccupiedby() {
        return Occupiedby;
    }

    public void setOccupiedby(int occupiedid) {
        Occupiedby = occupiedid;
    }

    public static void resetAllOccupiedStates() {
        for (LandColor color : LandColor.values()) {
            color.setOccupiedby(0); // 假设 0 表示未占用状态
        }
    }

//    public static int isColorOccupied(LandColor color) {
//        return color.isOccupied();
//    }
}
