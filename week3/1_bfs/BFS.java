import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
        int[] dist = new int[adj.length];
        for(int i = 0 ;i < adj.length; i++)
        dist[i] = -1;
        if(s == t)
            return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        dist[s] = 0;
        while(queue.size() > 0)
        {
            int curr = queue.poll();
            for(int i : adj[curr])
            {
                if(dist[i] == -1)
                {
                    queue.offer(i);
                    dist[i] = dist[curr] + 1;
                    if(i == t)
                        return dist[i];
                }

            }
        }
        return -1;
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
        System.out.println(distance(adj, x, y));
    }
}

