import java.util.*;

class Interval implements Comparable<Interval> {
    int index, startTime, finishTime, weight, p;

    Interval(int index, int startTime, int finishTime, int weight) {
        this.index = index;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.weight = weight;
        this.p = -1;
    }

    public int compareTo(Interval i) {
        return Integer.compare(finishTime, i.finishTime);
    }

    public String toString() {
        return "Interval no:" + (index + 1) + ")start:" + startTime + ",finish:" + finishTime + ",weight:" + weight;
    }

}

public class WeightedIntervalScheduling {

    public static void scheduledInterval(int[] s, int[] f, int[] w) {
        Interval[] allIntervals = new Interval[s.length];
        for (int i = 0; i < allIntervals.length; i++) {
            allIntervals[i] = new Interval(i, s[i], f[i], w[i]);
        }
        Arrays.sort(allIntervals);

        for (int i = 0; i < allIntervals.length; i++) {
            for (int j = 1; j >= 0; j--) {
                if (allIntervals[i].startTime >= allIntervals[j].finishTime) {
                    allIntervals[i].p = j;
                    break;
                }
            }
        }

        int[] OptimalWeight = new int[allIntervals.length + 1];
        ArrayList<Interval>[] OptimalList = new ArrayList[allIntervals.length + 1];
        for (int i = 0; i < allIntervals.length + 1; i++) {
            OptimalList[i] = new ArrayList<>();
        }
        OptimalWeight[0] = 0;
        for (int i = 1; i < OptimalWeight.length; i++) {
            if ((allIntervals[i - 1].weight + OptimalWeight[allIntervals[i - 1].p + 1]) > OptimalWeight[i - 1]) {
                OptimalWeight[i] = allIntervals[i - 1].weight + OptimalWeight[allIntervals[i - 1].p + 1];
                OptimalList[i].addAll(OptimalList[allIntervals[i - 1].p + 1]);
                OptimalList[i].add(allIntervals[i - 1]);
            } else {
                OptimalWeight[i] = OptimalWeight[i - 1];
                OptimalList[i].addAll(OptimalList[i - 1]);
            }
        }
        System.out.println("Selected intervals:");
        for (Interval i : OptimalList[OptimalList.length - 1]) {
            System.out.println(i);
        }
        System.out.println("\nMax Profit:" + OptimalWeight[OptimalWeight.length - 1]);
    }

    public static void main(String[] args) {
        int[] s = { 1, 3, 2, 2 };
        int[] f = { 2, 5, 19, 100 };
        int[] w = { 50, 20, 100, 200 };
        scheduledInterval(s, f, w);
    }
}
