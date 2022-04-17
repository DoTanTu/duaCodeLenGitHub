/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerbook.Dao;

import managerbook.Modle.Book;
import java.sql.Connection;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDao {
    
    //Lay tat ca thong tin cua sach
    public List<Book> getAllInformationBook(){
        List<Book> books = new ArrayList<Book>();
        Connection connection = ConnectionJDBC.connectionJDBC();
        String sql = "select * from BookManager ";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book bookk = new Book();
                bookk.setId(rs.getInt("id"));
                bookk.setTitle(rs.getString("title"));
                bookk.setPrice(rs.getDouble("price"));
                books.add(bookk);
            }
        }catch(SQLException ex ){
            ex.printStackTrace();
        }
        System.out.println(books);
        return books;
    }

    //Them sach vao database
    public void addBook(Book bookk){
        Connection connection = ConnectionJDBC.connectionJDBC();
        String sql = "insert into BookManager(title,price) values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bookk.getTitle());
            preparedStatement.setDouble(2, bookk.getPrice());
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Xoa sach theo id
    public void deleteBookById(int id){
        Connection connection  = ConnectionJDBC.connectionJDBC();
        String sql = "Delete from BookManager where id = "+ id;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    //Cap nhat lai thong tin cua sach theo id vao database
    public void upDateById(int id, String title, String price){
        Connection connection = ConnectionJDBC.connectionJDBC();
        String sql = "Update BookManager set title = ?,  price = ? where id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,price);
            preparedStatement.setInt(3,id);
            int rs = preparedStatement.executeUpdate(); 
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    
    //Lay tat ca cac id co trong database
    public List<Book> getAllId(){
        List<Book> bok = new ArrayList<Book>();
        Connection connection = ConnectionJDBC.connectionJDBC();
        String sql = "select id from BookManager";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book bokk = new Book();
                bokk.setId(rs.getInt("id"));
                bok.add(bokk);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return bok;
    }
    
    //Lay thong tin sach theo id
    public Book getBookById(int id){
        Connection connection = ConnectionJDBC.connectionJDBC();
        String sql = "select * from BookManager where id = " + id;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book bok = new Book();
                bok.setTitle(rs.getString("title"));
                bok.setPrice(rs.getDouble("price"));
                return bok;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    //lay tat cac thong tin ve sach theo "Title"
    public List<Book> getBookByTitle(String title){
       List<Book> books = new ArrayList<Book>();
        Connection connection = ConnectionJDBC.connectionJDBC();
        String sql = "select * from BookManager where title = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Book bookk = new Book();
                bookk.setId(rs.getInt("id"));
                bookk.setTitle(rs.getString("title"));
                bookk.setPrice(rs.getDouble("price"));
                books.add(bookk);           
            }
        }
        catch(SQLException ex ){
            ex.printStackTrace();
        }
        return books;
    } 
}
