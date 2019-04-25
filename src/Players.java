public class Players {
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    private int playerMoney;

    public Players(String name, int money){
        this.playerMoney = money;
        this.playerName = name;
    }
}
