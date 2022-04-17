
package managerbook.Services;

import managerbook.Dao.BookDao;
import managerbook.Modle.Book;
import java.util.List;

public class Service {
    private BookDao dao;
    
    public Service(){
        dao = new BookDao();
    }
    
    public List<Book> getAllInformationBook(){
        return dao.getAllInformationBook();
    }
    
    public void deleteBookById(int id){
        dao.deleteBookById(id);
    }
    
    public void addBook(Book bookk){
        dao.addBook(bookk);
    }
    
    public List<Book> getBookByTitle(String title){
        return dao.getBookByTitle(title);
    }
    
    public List<Book> getAllId(){
        return dao.getAllId();
    }
    
    public Book getBookById(int id){
        return dao.getBookById(id);
    }
    
    public void upDateById(int id,String title,String price){
        dao.upDateById(id,title,price);
    }
}
