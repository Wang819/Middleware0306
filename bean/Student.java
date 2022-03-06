package bean;
public class Student{
   private int iD;
   private String name;

   public void setID(int iD){
      this.iD = iD; }

   public int getID(){
      return iD;}

   public void setName(String name){
      this.name = name; }

   public String getName(){
      return name; }
   public String toString() {
		return "Student [iD=" + iD + ", name=" + name + "]";
	}
}
