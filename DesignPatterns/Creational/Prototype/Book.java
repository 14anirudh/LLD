
// FIRST APPROACH USING CLONABLE INTERFACE

package Creational.Prototype;

import java.util.ArrayList;
import java.util.List;

// //Clonable is marker interface in JAVA - it has no methods but signals to JVM that a class permits field-to-field copying using the Object.clone() method

// public class Book implements Cloneable{
//     private String title;
//     private String author;
//     private List<String> tags;

//     public Book(String title , String author , List<String> tags){
//         this.title = title ;
//         this.author = author ;
//         this.tags = new ArrayList<>();
//     }

//    @Override
//     public Book clone() {
//         try {
//             Book cloned = (Book) super.clone();
//             // Deep copy of mutable fields
//             cloned.tags = new ArrayList<>(this.tags);
//             return cloned;
//         } catch (CloneNotSupportedException e) {
//             throw new RuntimeException("Clone not supported", e);
//         }
//     }

//     public void setTitle(String title){
//         this.title = title;
//     }

//     public void print(){
//       System.out.println("Book: " + title + ", Author: " + author + ", Tags: " + tags);
//     }

// }
// Pros:

// Fast for simple duplication

// Doesn’t re-run constructor logic

// Cons:

// Prone to bugs with deep copies

// Requires implementing Cloneable and clone()


// SECOND APPROACH USING COPY CONSTRUCTOR


public class Book {
    private String title;
    private String author;
    private List<String> tags;

    // Regular constructor
    public Book(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = new ArrayList<>(tags);
    }


   // Copy constructor
    public Book(Book other){
        this.title = other.title;
        this.author = other.author;
        this.tags = new ArrayList<>(other.tags);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void print() {
        System.out.println("Title: " + title + ", Author: " + author + ", Tags: " + tags);
    }
}

// Pros:

// Clean and type-safe

// No unexpected behavior (e.g., hidden fields or shallow copy bugs)

// Cons:

// You need to explicitly write the copy constructor

// Slightly slower if constructor does complex setup
