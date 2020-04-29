import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
        Set<Integer> recStack = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        for(int i = 0; i< adj.length; i++)
        {   res = acyclic(i, adj, visited, recStack);
        if(res == 1)
            return res;}
        return res;
    }
    private static int acyclic(int curr, ArrayList<Integer>[] adj, Set<Integer> visited, Set<Integer> recStack)
    {
        if(recStack.contains(curr))
            return 1;
        if(visited.contains(curr))
            return 0;
        recStack.add(curr);
        int inter = 0;
        for(int i: adj[curr])
        {
            inter = acyclic(i, adj, visited, recStack);
            if(inter == 1)
                return inter;
        }
        recStack.remove(curr);
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

