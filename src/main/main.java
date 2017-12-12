/**
 * Created by jwest1 on 12/8/2017.
 */
package main;

import com.sun.javafx.geom.Edge;
import org.jgrapht.Graph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.RandomWalkIterator;

import java.util.Iterator;

public class main {
    final static String IL = "Illinois";
    final static String IN = "Indiana";
    final static String MO = "Missouri";
    final static String OH = "Ohio";
    final static String WI = "Wisconsin";
    final static String IA = "Iowa";
    final static String KY = "Kentucky";
    final static String MI = "Michigan";

    public static void main(String args[])
    {
        final Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);

        myMap.addVertex(IL);
        myMap.addVertex(IN);
        myMap.addVertex(MO);
        myMap.addVertex(OH);
        myMap.addVertex(WI);
        myMap.addVertex(IA);
        myMap.addVertex(MI);
        myMap.addVertex(KY);

        myMap.addEdge(IL, IN);
        myMap.addEdge(IL, MO);
        myMap.addEdge(IL, WI);
        myMap.addEdge(IL, KY);
        myMap.addEdge(IL, IA);
        myMap.addEdge(KY, OH);
        myMap.addEdge(KY, IN);
        myMap.addEdge(KY, MO);
        myMap.addEdge(MO, IA);
        myMap.addEdge(MI, IN);
        myMap.addEdge(MI, OH);
        myMap.addEdge(OH, IN);
        myMap.addEdge(WI, IA);

        final Iterator<String> bf = new BreadthFirstIterator<>(myMap, MO);
        System.out.println("Breadth First Algorithm starting at Missouri");
        while (bf.hasNext()) {
            final String country = bf.next();
            System.out.println(country);
        }
        final Iterator<String> bf2 = new BreadthFirstIterator<>(myMap, IL);
        System.out.println("Breadth First Algorithm starting at Illinois");
        while (bf2.hasNext()) {
            final String country = bf2.next();
            System.out.println(country);
        }
        System.out.println("Closest First Algorithm starting at Missouri");
        final Iterator<String> cf = new ClosestFirstIterator<>(myMap, MO);
        while (cf.hasNext()) {
            final String country = cf.next();
            System.out.println(country);
        }
        System.out.println("Closest First Algorithm starting at Illinois");
        final Iterator<String> cf2 = new ClosestFirstIterator<>(myMap, IL);
        while (cf2.hasNext()) {
            final String country = cf2.next();
            System.out.println(country);
        }
        System.out.println("Depth First Algorithm starting at Missouri");
        final Iterator<String> df = new DepthFirstIterator<>(myMap, MO);
        while (df.hasNext()) {
            final String country = df.next();
            System.out.println(country);
        }
        System.out.println("Depth First Algorithm starting at Illinois");
        final Iterator<String> df2 = new DepthFirstIterator<>(myMap, IL);
        while (df2.hasNext()) {
            final String country = df2.next();
            System.out.println(country);
        }

        GreedyColoring<DefaultEdge,String> coloring = new GreedyColoring(myMap);

        System.out.println(coloring.getColoring());

        System.out.println("Random Walk Algorithm starting at Missouri");
        final Iterator<String> rw = new RandomWalkIterator<>(myMap, MO,false,8);
        while (rw.hasNext()) {
            final String country = rw.next();
            System.out.println(country);
        }
        System.out.println("Random Walk Algorithm starting at Illinois");
        final Iterator<String> rw2 = new RandomWalkIterator<>(myMap, IL,false,8);
        while (rw2.hasNext()) {
            final String country = rw2.next();
            System.out.println(country);
        }



        System.out.println("test");
    }
}
