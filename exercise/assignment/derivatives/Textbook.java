package exercise.assignment.derivatives;

import exercise.assignment.models.Book;

public class Textbook{
    
    public static void main(String[] args){
        Book math = new Book();
        math.title = "College Math";
        System.out.println(math.title);

        Book fiction = new Book(20, false);
        fiction.title = "It is a new class";

        System.out.println("The book entitled: " + "\""+ fiction.title +"\""+ " is " + fiction.sales());
    }    
}