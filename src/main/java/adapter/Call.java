package adapter;

import java.util.Date;

public class Call {

  private int duration;
  private Date time;

  public Call(int duration, Date time) {
    this.duration = duration;
    this.time = time;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}
