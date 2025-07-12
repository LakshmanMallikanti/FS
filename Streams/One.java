package Streams;
/*
Given a list of EventAttendance (eventId, attendeeName, durationMinutes), 
Your task is to consider only attendees who stayed ≥ 60 minutes.
For each event, display the Event ID (ascending order), List of qualified 
attendee names (alphabetically sorted) and Count of such attendees.

Example 1
---------
Sample Input:
4
E101 John 90
E101 Alice 55
E101 Zara 75
E102 Mark 120

Sample output:
E101 [John, Zara] Count=2
E102 [Mark] Count=1

Example 2
---------
Sample Input:
11
E502 Carl 90
E502 Dan 45
E501 Ana 100
E502 Evan 75
E501 Beth 61
E502 Fred 20
E301 Ron 30
E301 Tony 60
E302 Lily 75
E302 Kevin 50
E301 Maya 90

Sample Output:
E301 [Maya, Tony] Count=2
E302 [Lily] Count=1
E501 [Ana, Beth] Count=2
E502 [Carl, Evan] Count=2

*/
import java.util.*;
import java.util.stream.Collectors;
public class One{
    static class person{
        String id,name;
         int time;
        public person(String id,String name,int time){
            this.id=id;
            this.name=name;
            this.time=time;
        }
         String getId(){
            return id;
        }
         String getName(){
            return name;
        }
        public int getTime(){
            return time;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        List<person> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] line=sc.nextLine().split(" ");
            list.add(new person(line[0],line[1],Integer.parseInt(line[2])));
        }
        Map<String,List<String>> res=list.stream().filter(x->x.getTime()>=60)
        .collect(Collectors.groupingby(person::getId,TreeMap::new,Collectors.mapping(id::getName,Collectors.toList())));
        res.forEach((id,names)->{
            List<String> sortedlist=names.stream().sorted().collect(Collectors.toList());
            System.out.println(id+" "+sortedlist+" Count="+sortedlist.size());
        });
    }
}