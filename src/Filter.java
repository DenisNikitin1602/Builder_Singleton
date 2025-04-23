import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int element : source) {
            if (element > treshold ) {
                result.add(element);
                logger.log("Элемент \""+ element + "\" проходит");
                count++;
            } else {
                logger.log("Элемент \"" + element + "\" не проходит");
            }
        }
        logger.log("Прошло фильтр " + count + " из " + source.size());
        return result;
    }
}
