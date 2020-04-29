import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        //write your code here
        Stack<Integer> order = new Stack<Integer>();
        HashSet<Integer> visited = new HashSet<>();
        for(int k = 0; k< adj.length; k++)
        {
        if(!visited.contains(k))
        fillOrder(k,adj, order, visited);
        }
        adj = transpose(adj);
        visited = new HashSet<>();
        int count = 0;
        while(order.size() > 0)
        {
            int i = order.pop();
            if(!visited.contains(i)){
                count++;
                dfs(adj,i,visited);}
        }
        return count;
    }
    private static void fillOrder(int i, ArrayList<Integer>[] adj, Stack<Integer> order, HashSet<Integer> visited)
    {
        if(visited.contains(i))
        {
            return;
        }
        visited.add(i);
        for(int j: adj[i])
        {
            if(!visited.contains(j))
            {
                fillOrder(j, adj, order, visited);
            }
        }
        order.push(i);
    }
    private static ArrayList<Integer>[] transpose(ArrayList<Integer>[] adj)
    {
        ArrayList<Integer>[] adjTranspose = (ArrayList<Integer>[])new ArrayList[adj.length];
        for(int i = 0; i < adj.length; i++)
        adjTranspose[i] = new ArrayList<Integer>();
        for(int i = 0; i < adj.length; i++)
        {
            for(int j: adj[i])
            adjTranspose[j].add(i);
        }
        return adjTranspose;
    }
    private static void dfs( ArrayList<Integer>[] adj, int i, HashSet<Integer> visited)
    {
        if(visited.contains(i))
        return;
        visited.add(i);
        for(int j: adj[i])
        {
            if(!visited.contains(j))
                dfs(adj,j,visited);
        }
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
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

