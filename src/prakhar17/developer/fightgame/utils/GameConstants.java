package prakhar17.developer.fightgame.utils;

public interface GameConstants {
String TITLE = ConfigReader.getValue("game.title");
int GW =Integer.parseInt(ConfigReader.getValue("game.width")) ;
int GH =Integer.parseInt(ConfigReader.getValue("game.height")) ;
}