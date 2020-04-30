import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashSet;
public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int[] color = new int[adj.length];
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        color[0] = 1;        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
       while(queue.size() > 0)
        {
            int curr = queue.poll();
            for(int i : adj[curr])
            {
                if(!visited.contains(i))
                {
                    color[i] = - color[curr];
                    visited.add(i);
                    queue.offer(i);
                }
                else if(color[i] == color[curr])
                {
                    return 0;
                }
            }
        }
        return 1;
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
        System.out.println(bipartite(adj));
    }
}

