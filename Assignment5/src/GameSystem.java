import java.util.Arrays;

public class GameSystem {
    private final Land[] LANDS;
    private Player[] players;
    private boolean gameOver;
    private int index = -1;
//    private int House = 0;

    public GameSystem(Player[] players, Land[] lands){
        LandColor.resetAllOccupiedStates();

        this.LANDS = lands;
        this.players = players;
        this.gameOver = false;
    }

    public Player nextPlayer(){
        index++;
        while (!players[index % players.length].isActive()) {
            index++;
        }
        return players[index % players.length];
    }

    public Player getCurrentPlayer(){
        if (index == -1)
            return null;
        else
            return players[index % players.length];
    }

    public boolean isGameOver(){
        int alivePlayer = 0;
        for (Player player : players){
            if (player.isActive()) alivePlayer++;
        }
        if (alivePlayer == 1)
            return true;
        else
            return false;
    }

    public boolean dealFailedPlayer(){
        if (!players[index % players.length].isActive()) {
            for (Land land : LANDS) {
                if (land.getHouse() != null && land.getHouse().getPlayer() == players[index % players.length]) {
                    land.setHouse(null);
                    land.getColor().setOccupiedby(0);
//                    House --;
                }
            }

            int alivePlayer = 0;
            for (Player player : players) {
                if (player.isActive()) alivePlayer++;
            }
            if (alivePlayer == 1) {
                gameOver = true;
            }
            return true;
        }
        else
            return false;
    }

    public String[] currentPlayersState(){
        String[] currentPlayersState = new String[players.length];
        int i = -1;
        for (Player player : players){
            currentPlayersState[++i] = player.toString();
        }
        return currentPlayersState;
    }

    public String[] currentLandsState(){
        String[] CurrentLandsState = new String[LANDS.length];
        int i = -1;
        int house = 0;
        for (Land land : LANDS){
            if (land.getHouse() != null) {
                CurrentLandsState[++i] = land.toString();
                house++;
            }
        }
        return Arrays.copyOfRange(CurrentLandsState, 0, house);
    }

    public void nextTurn(int step, int cost){
        Player player = nextPlayer();
        player.setLocation((player.getLocation() + step) % LANDS.length);
        if (LANDS[player.getLocation()].getHouse() != null && LANDS[player.getLocation()].getHouse().getPlayer() != player){
            if (player.getMoney() >= 0.5 * LANDS[player.getLocation()].getHouse().getHousePrice()){
                player.setMoney(player.getMoney() - 0.5 * LANDS[player.getLocation()].getHouse().getHousePrice());
                LANDS[player.getLocation()].getHouse().getPlayer().collectRent(0.5 * LANDS[player.getLocation()].getHouse().getHousePrice());
            }
            else{
                LANDS[player.getLocation()].getHouse().getPlayer().collectRent(player.getMoney());
                player.setActive(false);
                dealFailedPlayer();
            }
        }
        else{
            if (cost == 0 || (LANDS[player.getLocation()].getColor().getOccupiedby() != player.getId() && LANDS[player.getLocation()].getColor().getOccupiedby() != 0)) return;
            else{
                if (player.getMoney() >= cost){
                    player.buildHouse(LANDS[player.getLocation()], cost);
//                    House ++;
                    LANDS[player.getLocation()].getColor().setOccupiedby(player.getId());
                }
            }
        }
    }
}
