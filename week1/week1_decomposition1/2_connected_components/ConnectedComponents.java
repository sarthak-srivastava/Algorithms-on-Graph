import java.util.*;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        //write your code here
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<adj.length; i++)
        {
            if(!hs.contains(i))
            {   result++;
                // hs.add(i);
                dfs(adj,i,hs);
            }
        }
        return result;
    }
    private static void dfs(ArrayList<Integer>[] adj, int src, HashSet<Integer> visited)
    {
        if(visited.contains(src))
            return;
        visited.add(src);
        for(int i: adj[src])
        {
            if(!visited.contains(i))
            dfs(adj, i, visited);
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
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

