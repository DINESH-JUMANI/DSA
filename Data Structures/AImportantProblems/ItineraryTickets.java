package AImportantProblems;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ItineraryTickets {
    public static void main(String[] args) {
        HashMap<String , String> routes = new HashMap<>();
        routes.put("Chennai","Bangalore");
        routes.put("Mumbai","Delhi");
        routes.put("Goa","Chennai");
        routes.put("Delhi","Goa");

        Set<String> to = new HashSet<>(routes.keySet());
        Set<String> from = new HashSet<>(routes.values());
        String start = "", end = "";
        for (String temp : to) if(!from.contains(temp)) start = temp;
        for (String temp : from) if(!to.contains(temp)) end = temp;
        StringBuilder ans = new StringBuilder();

        while (!Objects.equals(start, end)){
            ans.append(start);
            ans.append("->");
            start = routes.get(start);
        }
        ans.append(end);
        System.out.println(ans);
    }
}
