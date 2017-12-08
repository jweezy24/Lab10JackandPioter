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
        myMap.addEdge(KY, OH);
        myMap.addEdge(KY, IN);
        myMap.addEdge(MI, IN);
        myMap.addEdge(MI, OH);
        myMap.addEdge(OH, IN);

        final Iterator<String> bf = new BreadthFirstIterator<>(myMap, MO);
        System.out.println("Breadth First Algorithm");
        while (bf.hasNext()) {
            final String country = bf.next();
            System.out.println(country);
        }
        System.out.println("Closest First Algorithm");
        final Iterator<String> cf = new ClosestFirstIterator<>(myMap, MO);
        while (cf.hasNext()) {
            final String country = cf.next();
            System.out.println(country);
        }
        System.out.println("Depth First Algorithm");
        final Iterator<String> df = new DepthFirstIterator<>(myMap, MO);
        while (df.hasNext()) {
            final String country = df.next();
            System.out.println(country);
        }

        GreedyColoring<DefaultEdge,String> coloring = new GreedyColoring(myMap);

        System.out.println(coloring.getColoring());


        //final Iterator<String> rw = new RandomWalkIterator<>(myMap, MO);
        //while (rw.hasNext()) {
         //   final String country = rw.next();
          //  System.out.println(country);
        //}




        System.out.println("test");
    }
}
