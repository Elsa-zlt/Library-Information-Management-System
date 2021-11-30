package com.zlt.controller;

import com.zlt.pojo.Books;
import com.zlt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

// @Controller用于标记一个类，使用他标记的类就是一个SpringMVC Controller对象，
// 即一个控制器类，Spring使用扫描机制查找应用程序中所有基于注解的控制器类。
// 分发处理器会扫描使用了该注解的类的方法，
// 并检测该方法是否使用了@RequestMapping注解的方法才是真正处理请求的处理器。

//  注解 @RequestMapping 可以用在类定义处和方法定义处。
//  类定义处：规定初步的请求映射，相对于web应用的根目录；
//  方法定义处：进一步细分请求映射，相对于类定义处的URL。如果类定义处没有使用该注解，则方法标记的URL相对于根目录而言；

@Controller
@RequestMapping("/book")
public class BookController {

    // @Autowired 注释：这个注释的功能就是为我们注入一个定义好的 bean

    // 使用 @Autowired 注解是Spring依赖注入的绝好方法。
    // 但是有些场景下仅仅靠这个注解不足以让Spring知道到底要注入哪个bean。
    // 默认情况下，@Autowired 按类型装配 Spring Bean。
    // 如果容器中有多个相同类型的 bean，则框架将抛出 NoUniqueBeanDefinitionException，
    // 以提示有多个满足条件的 bean 进行自动装配。程序无法正确做出判断使用哪一个

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询  全部书籍
    // 在许多实际项目需求中，后台要从控制层直接返回前端所需的数据，这时Model大家族就派上用场了。
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);

        //  跳转到 allBook.jsp 页面
        return "allBook";
    }

    // <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增</a> 跳转到这个方法
    @RequestMapping("/toAddBook")
    public String toAddPaper() {

        //  跳转到 addBook.jsp 页面
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);

        //  重定向（redirect） 到 /book/allBook.jsp 页面
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {

        // 获取 <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.getBookID()}"> 的id值
        Books books = bookService.queryBookById(id);
        System.out.println(books);

        //  将获取到的 books 加入 model 中
        model.addAttribute("book",books );

        //  跳转到 updateBook.jsp 页面
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {

        // book 用于提取上面 toUpdateBook 方法的 model.addAttribute("book",books ) 的数据
        System.out.println(book);
        bookService.updateBook(book);

        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);

        //  重定向（redirect） 到 /book/allBook.jsp 页面
        return "redirect:/book/allBook";
    }

    // @PathVariable 接收请求路径中占位符的值
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);

        //  重定向（redirect） 到 /book/allBook.jsp 页面
        return "redirect:/book/allBook";
    }

    // 查询一本书
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if (books==null) {
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }

        model.addAttribute("list",list);
        return "allBook";
    }

}
