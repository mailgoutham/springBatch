package processor;

import domain.CustomerCredit;
import org.springframework.batch.item.ItemProcessor;

/**
 * User: Goutham Rathnaswamy
 * Date: 20/07/2013
 * Time: 13:23
 */
public class CustomProcessor<T> implements ItemProcessor<T,T>{

    @Override
    public T process(T item) throws Exception {
//        if(((CustomerCredit)item).getName().equals("redbull")){
//          throw new Exception("Redbull not allowed");
//        }
        return item;
    }
}
