package prakhar17.developer.fightgame.utils;

public interface GameConstants {
    String TITLE = ConfigReader.getValue("game.title");
    int GW = Integer.parseInt(ConfigReader.getValue("game.width"));
    int GH = Integer.parseInt(ConfigReader.getValue("game.height"));
    int FLOOR = Integer.parseInt(ConfigReader.getValue("game.height")) - 100;

    int KICK = 2;
    int WALK = 1;
    int GRAVITY = 1;
    int DELAY = 100;
}
