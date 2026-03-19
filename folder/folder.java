package folder;

public class folder{
  String path;
  boolean inUse;
  boolean isWriting;
  int readers;


  public folder(String path){
    this.path = path;
    this.inUse = false;
    this.isWriting = false;
    this.readers = 0;
  }

  public synchronized void write(){
    System.out.println("writing");
  }

  public synchronized void read(){
    System.out.println("reading");
  }

  public synchronized void beforeReading(){
    while(isWriting){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      readers++;

      if(readers == 1){
        inUse = true;
      }
      
    }
    
  }

  public synchronized void afterReading(){
    readers--;

    if(readers == 0){
      inUse = false;
      notifyAll();
    }
    
  }

  public  synchronized void beforeWriting(){
      while(inUse){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      isWriting = true;
      inUse = true;

      
    }
    
  }

  public synchronized void afterWriting(){
    isWriting = false;
    inUse = false;
    notifyAll();
  }


}