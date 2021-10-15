package exercise.assignment.models;

public class Book{
    public String title;
    public String author;
    public String category;
    public float price;
    public boolean isPaperback;


    public Book(){}

    public Book(float price, boolean isPaperback){
        this.price = price;
        this.isPaperback = isPaperback;
    }

    public String sales(){
        String res = "";
        if(this.price < 30.0 && this.isPaperback == true){
            res = "Cheap";
        }else if (this.price > 30.0 || this.isPaperback == false){
            res = "Expenssive";
        }
        return res;
    }
}