import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
  
    public class Node {
    	
    	ArrayList<Node> children = new ArrayList<Node>();	
    	void addChild(Node n) {
    		this.children.add(n);
    	} 
    }
    
	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
                        // Original code replaced with a faster implementation
			ArrayList<Node> nodes = new ArrayList<Node>();	
			for (int i=0; i<n; i++) {
				nodes.add(new Node());
			}
			int p_index = 0;
			Node root_node = new Node();
			for (int i=0; i<n; i++) {
				p_index = parent[i];
				if (p_index == -1) {
					root_node = nodes.get(i);
				}
				else {
					nodes.get(p_index).addChild(nodes.get(i));
				}	
			}
			//Breadth first search 
			LinkedList<Node> que = new LinkedList<Node>();
			Node pRoot = new Node();
			que.add(root_node);
			int depth = 0;  
		    while( !que.isEmpty() ){  
		         ++depth;  
		        int curLevelNodesTotal = que.size();  
		        int cnt = 0;  
		        while( cnt < curLevelNodesTotal ){  
		            ++cnt;  
		            pRoot = que.peek(); 
		            que.remove();
		            for (int i=0; i<pRoot.children.size(); i++) {
		            	que.add(pRoot.children.get(i));
		            }
		        }  
		    }  
			return depth;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
