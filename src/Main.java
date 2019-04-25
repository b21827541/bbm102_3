import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;


public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // setup

        ArrayList<String> chance = new ArrayList<String>();
        ArrayList<String> communityChest = new ArrayList<String>();
        ArrayList<String> firstProperty = new ArrayList<String>();
        ArrayList<String> secondProperty = new ArrayList<String>();
        ArrayList<String> thirdProperty = new ArrayList<String>();
        List<String> list = new ArrayList<>();
        String fileName = "./commands.txt";
        Players player1 = new Players("player 1", 15000);
        Players player2 = new Players("player 2", 15000);
        Banker banker = new Banker(100000);
        ArrayList<String> player1Dice = new ArrayList<String>();
        ArrayList<String> player2Dice = new ArrayList<String>();


        JSONParser parser1 = new JSONParser();

        try {

            Object obj = parser1.parse(new FileReader("./list.json"));

            JSONObject jsonObject1 = (JSONObject) obj;

            JSONArray chanceList = (JSONArray) jsonObject1.get("chanceList");
            JSONArray communityChestList = (JSONArray) jsonObject1.get("communityChestList");

            Iterator iterator1 = chanceList.iterator();
            Iterator iterator2 = communityChestList.iterator();

            while(iterator1.hasNext()){
                Iterator<Map.Entry> itr1 = ((Map) iterator1.next()).entrySet().iterator();
                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                    String str = "";
                    str =(String) pair.getValue();
                    chance.add(str);
                }
            }
            System.out.println("\n");
            while(iterator2.hasNext()){
                Iterator<Map.Entry> itr2 = ((Map) iterator2.next()).entrySet().iterator();
                while (itr2.hasNext()) {
                    Map.Entry pair = itr2.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                    String str = "";
                    str =(String) pair.getValue();
                    communityChest.add(str);
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JSONParser parser2 = new JSONParser();

        try {

            Object obj = parser2.parse(new FileReader("./property.json"));

            JSONObject jsonObject2 = (JSONObject) obj;

            JSONArray first = (JSONArray) jsonObject2.get("1");
            JSONArray second = (JSONArray) jsonObject2.get("2");
            JSONArray third = (JSONArray) jsonObject2.get("3");

            Iterator iterator_first = first.iterator();
            Iterator iterator_second = second.iterator();
            Iterator iterator_third = third.iterator();
            System.out.println("\n");
            while(iterator_first.hasNext()){
                Iterator<Map.Entry> itr = ((Map) iterator_first.next()).entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry pair = itr.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                    String str = "";
                    str =(String) pair.getValue();
                    firstProperty.add(str);
                }
            }
            System.out.println("\n");
            while(iterator_second.hasNext()){
                Iterator<Map.Entry> itr = ((Map) iterator_second.next()).entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry pair = itr.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                    String str = "";
                    str =(String) pair.getValue();
                    secondProperty.add(str);
                }
            }
            System.out.println("\n");
            while(iterator_third.hasNext()){
                Iterator<Map.Entry> itr = ((Map) iterator_third.next()).entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry pair = itr.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                    String str = "";
                    str =(String) pair.getValue();
                    thirdProperty.add(str);
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            list = stream
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int j=0;j<list.size();j++) {
            String lines[] = list.get(j).split(";");
            if (lines[0].equals(player1.getPlayerName())){
                player1Dice.add(lines[1]);
            }
            if (lines[0].equals(player2.getPlayerName())){
                player2Dice.add(lines[1]);
            }
        }
        
    }
}
