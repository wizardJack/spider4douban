import java.util.ArrayList;

/**
 * The entry of the program.
 * Created by asus on 2016/11/12.
 */
public class Spider {
    static String keyword = "互联网，编程，算法"; //to search books from douban;
    static int pageNumber = 0; //of searching result
    public static void main(String[] args){
        ArrayList<BookBean> books = new ArrayList<BookBean>(); // all books retrieved
        ArrayList<BookBean> aBatchBooks = new ArrayList<BookBean>(); // one batch of books retrieved from douban
        //0.make a loop to execute steps 1 to 3
        boolean flag = true; //the flag to control the loop mentioned before.
        while (flag){
            //1.get books from douban.
            aBatchBooks = getBooks(nextUrl());
            flag = aBatchBooks.size() != 0 ;
            books.addAll(aBatchBooks);
            //2.save data to temporary file, includes pageNumber and books retrieved
            TemporaryMemory.saveBooks(aBatchBooks);
        }
        //3.sort books by score
        Sorter.sort(books);
        //4.output to excel after all staff done
        Output2Excel.output(books);
    }
    private static String nextUrl(){
        String pageString = pageNumber == 0 ? "" : "start=" + pageNumber * 15 + "&";
        return "https://book.douban.com/subject_search?" + pageString + "search_text=" + keyword + "&cat=1001";
    }
    private static ArrayList<BookBean> getBooks (String url){
        return new ArrayList<BookBean>();
    }
}
