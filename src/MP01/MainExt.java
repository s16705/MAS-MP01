package MP01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainExt implements Serializable {

    private static List<MainExt> allExtents = new ArrayList<>();

    public MainExt(){
        allExtents.add(this);
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }


    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (ArrayList<MainExt>) stream.readObject();
    }

    public static void getExt(){
        for (MainExt e : allExtents)
            System.out.println(e.getClass());
    }

}