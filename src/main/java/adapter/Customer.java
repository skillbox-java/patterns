package adapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {

  public int getCallsCount(Date from, Date to) {
    return 0;
  }

  public List<Call> getCalls(Date from, Date to) {
    return new ArrayList<Call>();
  }
}
