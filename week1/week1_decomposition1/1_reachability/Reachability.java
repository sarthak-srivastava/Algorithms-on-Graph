import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        HashSet<Integer> hs = new HashSet<>();
        return dfs(adj, hs,x, y);
        
    }

    private static int dfs(ArrayList<Integer>[] adj, HashSet<Integer> visited, int src, int dest){
        if(src == dest)
            return 1;
        visited.add(src);
        for(int nb : adj[src])
        {
            if(!visited.contains(nb))
                {
                    int intermediate = dfs(adj, visited, nb, dest);
                    if(intermediate == 1)
                        return 1;
                }
        }
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

