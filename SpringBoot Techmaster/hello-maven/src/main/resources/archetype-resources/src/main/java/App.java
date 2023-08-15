package $org.example;

/**
 * Hello world!
 *
 */
import org.apache.commons.lang3.StringUtils;
public class App 
{
    public static void main( String[] args )
    {

        boolean rs = StringUtils.isNumeric("Hello Maven")
        System.out.println( rs );
    }
}
