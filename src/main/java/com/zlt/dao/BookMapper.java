package com.zlt.dao;

import com.zlt.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一本书信息
    int addBook(Books book);

    //根据id删除一本书信息
    int deleteBookById(@Param("bookID") int id);

    //更新一本书信息
    int updateBook(Books books);

    //根据id查询,返回一本书信息
    Books queryBookById(@Param("bookID") int id);

    //查询全部书籍信息,返回list集合
    List<Books> queryAllBook();

    Books queryBookByName(String bookName);

}
