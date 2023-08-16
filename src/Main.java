import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] ids = {1, 2, 3};
        String[] names = {"Teddy Bear", "Lego Set", "Doll"};
        double[] frequencies = {3.0, 2.0, 1.0};
        PriorityQueue<Toy> toysQueue = new PriorityQueue<>((t1, t2) ->
                Double.compare(t2.getFrequency(), t1.getFrequency()));
        for (int i = 0; i < ids.length; i++) {
            Toy toy = new Toy(ids[i], names[i], frequencies[i]);
            toysQueue.add(toy);
        }

        List<Toy> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {


            Toy currentToy = toysQueue.poll();
            if(currentToy != null){


            resultList.add(currentToy);
            System.out.println("pulled toy: " + currentToy.getName()   + currentToy.getFrequency());
        }else {
                break;
            }
            }
        String fileName = "result.txt";
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Toy toy : resultList) {
                writer.write(String.format("id: %d , name: %s , frequency : %.2f%n", toy.getId(), toy.getName(), toy.getFrequency()));
            }

        } catch (IOException e) {
            System.err.format("I0Exception : %s%n", e);
        }
    }
}



